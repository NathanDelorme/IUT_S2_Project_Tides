package views;

import java.awt.Color;

import javax.swing.JFrame;

public class MotherFrame extends JFrame  implements commons.Constants{
	public MotherFrame (String parTitre) {
		super (parTitre);
		
		Frame contentPane = new Frame ();
		
		setContentPane (contentPane);
		setBackground (new Color (230,67,98));
		contentPane.setBackground (new Color (230,67,98));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,200); setVisible(true); setLocation(200,300);
	}
}
