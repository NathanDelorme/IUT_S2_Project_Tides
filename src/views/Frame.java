package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import controllers.controller;

/**
 * 
 * @author Alexandre LENFANTIN
 *
 */
public class Frame extends JPanel implements commons.Constants{
	
	public Frame () {
		this.setLayout (new BorderLayout(9,9));
		//WEST
		CalendarPanel leftPanel = new CalendarPanel () ;
		this.add(leftPanel,BorderLayout.WEST);
		
		new controller (leftPanel);
		
		//CENTER
		
		} // Frame ()
}	
