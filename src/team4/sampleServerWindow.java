package team4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JList;

public class sampleServerWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sampleServerWindow window = new sampleServerWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public sampleServerWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * Modify here.
	 */
	private void initialize() {
		ArrayList<Person> personList = new ArrayList<Person>();
		Person player1 = new Person("10.131.22.8", 1, 1, 22, new Point(7, 2),
				Person.State.Waiting);
		Person player2 = new Person("10.131.22.3", 1, 2, 50, new Point(1, 3),
				Person.State.Waiting);
		Person player3 = new Person("10.131.22.4", 1, 3, 12, new Point(25, 52),
				Person.State.Waiting);
		Person player4 = new Person("10.131.22.5", 1, 4, 23, new Point(25, 44),
				Person.State.Active);
		Person player5 = new Person("10.131.22.66", 1, 5, 0, new Point(44, 52),
				Person.State.Dead);
		Person player6 = new Person("10.131.22.250", 1, 6, 16,
				new Point(44, 23), Person.State.Waiting);
		Person player7 = new Person("10.131.22.230", 1, 7, 50,
				new Point(55, 13), Person.State.Waiting);
		Person player8 = new Person("10.131.22.150", 1, 8, 42,
				new Point(66, 1), Person.State.Waiting);
		personList.add(player1);
		personList.add(player2);
		personList.add(player3);
		personList.add(player4);
		personList.add(player5);
		personList.add(player6);
		personList.add(player7);
		personList.add(player8);

		frame = new JFrame();
		frame.setBounds(100, 100, 927, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}

}
