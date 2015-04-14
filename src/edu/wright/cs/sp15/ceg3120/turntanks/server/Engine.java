/*
 * Team 6
 * Mason Henrickson
 * Christopher Dolence
 * Scott Lee
 * Benjamin Winks
 */

/*
 *  Copyright (C) <2015>  <Team 6>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package edu.wright.cs.sp15.ceg3120.turntanks.server;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import edu.wright.cs.sp15.ceg3120.turntanks.Game;
import edu.wright.cs.sp15.ceg3120.turntanks.Player;

// This class isnt complete yet; eventually, you will pass it a Game Instance object and it will: 
// run a thread of a socket server, that creates threads out of socket connections
// keep references to all socket threads
// keep a thread safe data structure buffer, which will contain actions from parsed inbound messages
// keep a buffer of messages that need to be sent outbound to specific sockets
// have a main loop which completes the next tasks waiting in the inbound and outbound buffers
// For now, exceptions will just be printed
public class Engine {

	// FIXME: Is it intentional that these are package visible instead of
	// private?
	static ConcurrentLinkedQueue<InBufferInstruction> inBuffer = new ConcurrentLinkedQueue<>();
	static ArrayList<ConcurrentLinkedQueue<OutBufferInstruction>> outBuffers = new ArrayList<>();

	private ServerListener listener = new ServerListener();
	private Game currentGame;
	private boolean needViewUpdate = false; // gets flagged when playerUpdate
											// array
	// contains a true
	private boolean playerUpdate[] = { false, false, false, false, false,
			false, false, false };// means that corrisponding player number
									// needs a new vision
									// update

	public Engine(Game game) {
		Thread thread = new Thread(listener);
		thread.start();
		currentGame = game;
	}

	public boolean lobby() {
		if (ServerListener.socketList.size() > 7)
			return false;
		else
			return true;

	}

	public void step() {

		if (!inBuffer.isEmpty())
			inProcess(inBuffer.remove());

		if (needViewUpdate)
			generateViews();

		// -parse inBuffer, take action on gameInstance
		// //-detect new terrain to send to tank that moved
		// //-check and see if anygetPlayerList() can see moved tank
		// //generate tank position messages to send to those getPlayerList()

	}

	private void generateViews() {
		for (int i = 0; i < ServerListener.socketList.size(); i++) {
			if (true)// TODO change to playerUpdate[i] once vision checks set
				processVision(i);
			playerUpdate[i] = false;
		}
		needViewUpdate = false;

	}

	// this method will calculate vision based on terrian view modifiers, but
	// for now just shows tile tank is in
	private void processVision(int playerNumber) {
		int x = currentGame.getPlayerList().get(playerNumber).getPlayerLocation().x;
		int y = currentGame.getPlayerList().get(playerNumber).getPlayerLocation().y;

		OutBufferInstruction outInstruction;
		// creates instructions for tank positions to be updated on client
		for (int i = 0; i < ServerListener.socketList.size(); i++) {
			// TODO if lineOfSite=true

			outInstruction = new OutBufferInstruction(2, i, currentGame.getPlayerList()
					.get(i).getPlayerLocation().x, currentGame.getPlayerList().get(i)
					.getPlayerLocation().y);
			outBuffers.get(playerNumber).add(outInstruction);
		}

		// gets tiles around tank
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				// TODO if lineOfSite=true
				if (y + i >= 0 && x + j >= 0) {
					outInstruction = new OutBufferInstruction(3, x + j, y + i,
							currentGame.getGameMap().baseLayer[y + i][x + j],
							currentGame.getGameMap().topLayer[y + i][x + j],
							currentGame.getGameMap().spriteStyle[y + i][x + j],
							currentGame.getGameMap().corners[y + i][x + j]);
					outBuffers.get(playerNumber).add(outInstruction);
				}
			}
		}

	}

	// processes instructions based on their types
	private void inProcess(InBufferInstruction instruction) {

		switch (instruction.type) {
		case 0:
			processTankMove(instruction);
			break;
		case 1:
			processTankAttack(instruction);
			break;
		case 2:
			processChat(instruction);
			// add outbufferinstruction for chat sending message to each client
			break;

		case 3:
			processHandshake(instruction);
			break;

		default:
			System.out.println("inprocess failed");
			break;
		}

	}// end serverMTInstruction

	// checks to make sure that the move is only 1 space
	// need to add check to make sure terrain
	private boolean validateMove(InBufferInstruction instruction) {
		int temp = 0;
		temp = Math.abs(currentGame.getPlayerList().get(instruction.sourceID)
				.getPlayerLocation().y - instruction.y);
		if (temp > 1) {
			System.out.println("invalid move, Y axis");
			return false;
		}
		temp = Math.abs(currentGame.getPlayerList().get(instruction.sourceID)
				.getPlayerLocation().x - instruction.x);
		if (temp > 1) {
			System.out.println("invalid move, X axis");
			return false;
		}

		return true;
	}

	private boolean validateAttack(InBufferInstruction instruction) {

		boolean test = false;
		for (Player tank : currentGame.getPlayerList()) {
			if (tank.getPlayerLocation().x == instruction.x
					&& tank.getPlayerLocation().y == instruction.y)
				test = true;
		}
		// TODO add check to make sure attack position is on same x, or y coord
		// as attacker
		return test;
	}

	private void conductAttack(InBufferInstruction instruction) {

		int temp = -1;
		temp = (int) Math.pow(currentGame.getPlayerList().get(instruction.sourceID)
				.getPlayerLocation().x - instruction.x, 2);

		temp += (int) (Math.pow(currentGame.getPlayerList().get(instruction.sourceID)
				.getPlayerLocation().y - instruction.y, 2));

		temp = (int) Math.sqrt(temp);

		// shot hit probablities
		boolean attack = false;
		switch (temp) {
		case 1:
			if (Math.random() < .8)
				attack = true;
			break;
		case 2:
			if (Math.random() < .4)
				attack = true;
			break;
		case 3:
			if (Math.random() < .2)
				attack = true;
			break;
		case 4:
			if (Math.random() < .1)
				attack = true;
			break;
		default:
			System.out.println("mason messed up the distance formula");

		}

		// if the shot hit, perform attack
		Random rand = new Random();
		if (attack) {
			// 4-10 random number
			int attackVal = rand.nextInt((10 - 4) + 1) + 4;

			for (int i = 0; i < 8; i++) {
				if (currentGame.getPlayerList().get(i).getPlayerLocation().x == instruction.x
						&& currentGame.getPlayerList().get(i).getPlayerLocation().y == instruction.y) {
					currentGame.getPlayerList().get(i).setPlayerHealth(
							currentGame.getPlayerList().get(i).getPlayerHealth()
									- attackVal);
					System.out.println("shot hit for " + attackVal);

				}
			}
		} else {
			System.out.println("miss attack");
		}

		// counter attack
		boolean counterAttack = false;
		switch (temp) {
		case 1:
			if (Math.random() < .8)
				counterAttack = true;
			break;
		case 2:
			if (Math.random() < .4)
				counterAttack = true;
			break;
		case 3:
			if (Math.random() < .2)
				counterAttack = true;
			break;
		case 4:
			if (Math.random() < .1)
				counterAttack = true;
			break;
		default:
			System.out.println("mason messed up the distance formula");

		}

		// if counter attack hits
		// ensures counter attack only happens if attack happens
		if (counterAttack && attack) {
			rand = new Random();
			int counterAttackVal = rand.nextInt((5 - 2) + 1) + 5; // 2-5 random
			currentGame.getPlayerList().get(instruction.sourceID).setPlayerHealth(
					currentGame.getPlayerList().get(instruction.sourceID)
							.getPlayerHealth() - counterAttackVal);
			System.out.println("counter shot hit for " + counterAttackVal);
		} else {
			System.out.println("miss counter attack");
		}

	}

	private void processTankMove(InBufferInstruction instruction) {
		System.out.println("MT processing tank move");
		// check to see if tank is only moving 1 sq
		if (validateMove(instruction)) {
			currentGame.getPlayerList().get(instruction.sourceID).getPlayerLocation().y = instruction.y;
			currentGame.getPlayerList().get(instruction.sourceID).getPlayerLocation().x = instruction.x;
			needViewUpdate = true;
			playerUpdate[instruction.sourceID] = true;
			System.out.println("tank " + instruction.sourceID + " moved to x="
					+ instruction.x + " y=" + instruction.y);
			// TODO INTEGRATION FIX
			// ServerGUI.getInstance().updateTable(currentGame);
			// call send map info to moved tank
		}
	}

	private void processTankAttack(InBufferInstruction instruction) {
		System.out.println("MT processing tank attack");
		if (validateAttack(instruction)) {
			conductAttack(instruction);
			// TODO INTERGRATION FIX
			// ServerGUI.getInstance().updateTable(currentGame);
		}
	}

	private void processChat(InBufferInstruction instruction) {
		System.out.println("MT processing chat");
		System.out.println("debug: Chat is: " + instruction.message);
	}

	private void processHandshake(InBufferInstruction instruction) {
		System.out.println("MT processing handshake");
		currentGame.getPlayerList().get(instruction.sourceID).setName(instruction.message);
		playerUpdate[instruction.sourceID] = true;
		needViewUpdate = true;
		// TODO INTERGRATION FIX
		// ServerGUI.getInstance().updateTable(currentGame);
		// generate messages to update player names to everyone
		for (int i = 0; i < ServerListener.socketList.size(); i++) {
			// sent a message to each socket, the name of the player
			// associated with the outer loop
			for (int j = 0; j < ServerListener.socketList.size(); j++) {
				outBuffers.get(j).add(
						new OutBufferInstruction(1, i,
								currentGame.getPlayerList().get(i).getName()));
				System.out.println("debug: player name");
			}
		}
	}
	
	public Game getGame(){
		return this.currentGame;
	}

}
