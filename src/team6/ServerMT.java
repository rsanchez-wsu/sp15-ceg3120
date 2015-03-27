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

package team6;

import java.util.concurrent.*;
import java.util.*;
import java.math.*;

// This class isnt complete yet; eventually, you will pass it a Game Instance object and it will: 
// run a thread of a socket server, that creates threads out of socket connections
// keep references to all socket threads
// keep a thread safe data structure buffer, which will contain actions from parsed inbound messages
// keep a buffer of messages that need to be sent outbound to specific sockets
// have a main loop which completes the next tasks waiting in the inbound and outbound buffers
// For now, exceptions will just be printed
public class ServerMT {

	static ConcurrentLinkedQueue inBuffer = new ConcurrentLinkedQueue<InBufferInstruction>();
	static ArrayList<ConcurrentLinkedQueue> outBuffers = new ArrayList();

	ServerMTSockListen listener = new ServerMTSockListen();
	GameInstance currentGame;
	boolean needViewUpdate = false; // gets flagged when playerUpdate array
									// contains a true
	boolean playerUpdate[] = { false, false, false, false, false, false, false,
			false };// means that corrisponding player number needs a new vision
					// update

	public ServerMT(GameInstance game) {
		Thread thread = new Thread(listener);
		thread.start();
		currentGame = game;
	}// end constructor

	public boolean lobby() {
		if (listener.socketList.size() > 7)
			return false;
		else

			return true;

	}

	public void step() {

		if (!inBuffer.isEmpty())
			inProcess((InBufferInstruction) inBuffer.remove());

		if (needViewUpdate)
			generateViews();

		// -parse inBuffer, take action on gameInstance
		// //-detect new terrain to send to tank that moved
		// //-check and see if anytanks can see moved tank
		// //generate tank position messages to send to those tanks

	}

	private void generateViews() {
		for (int i = 0; i < ServerMTSockListen.socketList.size(); i++) {
			if (playerUpdate[i])
				processVision(i);
			playerUpdate[i] = false;
		}
		needViewUpdate = false;

	}// end generateViews()

	// this method will calculate vision based on terrian view modifiers, but
	// for now just shows tile tank is in
	private void processVision(int playerNumber) {
		int x = currentGame.tanks.get(playerNumber).xCoord;
		int y = currentGame.tanks.get(playerNumber).yCoord;

		OutBufferInstruction outInstruction;
		//creates instructions for tank positions to be updated on client
		for (int i = 0; i < ServerMTSockListen.socketList.size(); i++) {
			// TODO if lineOfSite=true
			outInstruction = new OutBufferInstruction(2, playerNumber, x, y);
			outBuffers.get(playerNumber).add(outInstruction);
		}// end for
		
	// gets tiles around tank
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				// TODO if lineOfSite=true
				if (x + j >= 0 && y + i >= 0) {
					outInstruction = new OutBufferInstruction(3,y + j ,x + i ,
							currentGame.gameMap.baseLayer[y + i][x + j],
							currentGame.gameMap.topLayer[y + i][x + j],
							currentGame.gameMap.spriteStyle[y + i][x + j],
							currentGame.gameMap.corners[y + i][x + j]);
					outBuffers.get(playerNumber).add(outInstruction);
				}// end if
			}// end for
		}// end for

	}

	// processes instructions based on their types
	private void inProcess(InBufferInstruction instruction) {

		switch (instruction.type) {
		case 0:
			System.out.println("MT processing tank move");
			// check to see if tank is only moving 1 sq
			if (validateMove(instruction)) {
				currentGame.tanks.get(instruction.sourceID).yCoord = instruction.y;
				currentGame.tanks.get(instruction.sourceID).xCoord = instruction.x;
				needViewUpdate = true;
				playerUpdate[instruction.sourceID] = true;
				System.out.println("tank " + instruction.sourceID
						+ " moved to x=" + instruction.x + " y="
						+ instruction.y);
				ServerGUI.getInstance().updateTable(currentGame);
				// call send map info to moved tank
			}

			break;
		case 1:
			System.out.println("MT processing tank attack");
			if (validateAttack(instruction)) {
				conductAttack(instruction);
				ServerGUI.getInstance().updateTable(currentGame);
			}

			break;
		case 2:
			System.out.println("MT processing chat");
			System.out.println("debug: Chat is: " + instruction.message);
			// add outbufferinstruction for chat sending message to each client
			break;

		case 3:
			System.out.println("MT processing handshake");
			currentGame.tanks.get(instruction.sourceID).Name = instruction.message;
			playerUpdate[instruction.sourceID]=true;
			needViewUpdate=true;
			ServerGUI.getInstance().updateTable(currentGame);
			// generate messages to update player names to everyone
			for (int i = 0; i < listener.socketList.size(); i++) {
				// sent a message to each socket, the name of the player
				// associated with the outer loop
				for (int j = 0; j < listener.socketList.size(); j++) {

					outBuffers.get(j).add(
							new OutBufferInstruction(1, i, currentGame.tanks
									.get(i).Name));
					System.out.println("debug: player name");
				}// end inner loop

			}// end outer loop

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
		temp = Math.abs(currentGame.tanks.get(instruction.sourceID).yCoord
				- instruction.y);
		if (temp > 1) {
			System.out.println("invalid move, Y axis");
			return false;
		}
		temp = Math.abs(currentGame.tanks.get(instruction.sourceID).xCoord
				- instruction.x);
		if (temp > 1) {
			System.out.println("invalid move, X axis");
			return false;
		}

		return true;
	}// end validate move

	private boolean validateAttack(InBufferInstruction instruction) {

		boolean test = false;
		for (TankObject tank : currentGame.tanks) {
			if (tank.xCoord == instruction.x && tank.yCoord == instruction.y)
				test = true;
		}
		// TODO add check to make sure attack position is on same x, or y coord
		// as attacker
		return test;
	}// end validate attack

	private void conductAttack(InBufferInstruction instruction) {

		int temp = -1;
		temp = (int) Math.pow(
				currentGame.tanks.get(instruction.sourceID).xCoord
						- instruction.x, 2);

		temp += (int) (Math.pow(
				currentGame.tanks.get(instruction.sourceID).yCoord
						- instruction.y, 2));

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

		}// end switch

		// if the shot hit, perform attack
		Random rand = new Random();
		if (attack) {
			int attackVal = rand.nextInt((10 - 4) + 1) + 4; // 4-10 random
															// number

			for (int i = 0; i < 8; i++) {
				if (currentGame.tanks.get(i).xCoord == instruction.x
						&& currentGame.tanks.get(i).yCoord == instruction.y) {
					currentGame.tanks.get(i).health -= attackVal;
					System.out.println("shot hit for " + attackVal);

				}// end if tank matches
			}// end for
		}// end if attack
		else
			System.out.println("miss attack");
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

		}// end switch
			// if counter attack hits

		if (counterAttack && attack) { // ensures counter attack only happens if
										// attack happen
			rand = new Random();
			int counterAttackVal = rand.nextInt((5 - 2) + 1) + 5; // 2-5 random
			currentGame.tanks.get(instruction.sourceID).health -= counterAttackVal;
			System.out.println("counter shot hit for " + counterAttackVal);
		}// end counter attack
		else
			System.out.println("miss counter attack");

	}// end conduct attack

}// end class
