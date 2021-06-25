package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import controllers.controller;

/**
 * The {@code CalendarOfMonth} class from {@code view} package 
 * create the frame where all panel will be assembled. 
 * @author Alexandre LENFANTIN
 *
 */
public class Frame extends JPanel implements commons.Constants{
	
	/**
	 * Constructor of Frame. We instantiate {@code LeftPanel} and {@code CenterPanel} 
	 * and we add them in this panel. 
	 *  We instantiate the controller too.
	 */
	public Frame () {
		this.setLayout (new BorderLayout(9,9));
		//WEST
		LeftPanel leftPanel = new LeftPanel () ;
		CenterPanel centerPanel = new CenterPanel();
		this.add(leftPanel,BorderLayout.WEST);
		this.add(centerPanel,BorderLayout.CENTER  );
		
		
		new controller (leftPanel);
		
		//CENTER
		
		} // Frame ()
}	
