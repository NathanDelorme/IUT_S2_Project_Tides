package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controllers.controller;
import models.Date;

/**
 * The {@code CalendarPanel} class from {@code view} package is class which allow to display a calendar based on month.
 * @author Alexandre LENFANTIN
 *
 */
public class LeftPanel  extends JPanel implements commons.Constants, ActionListener{
	JPanel centerPanel = new JPanel ( ) ;
	CardLayout gestCard = new CardLayout(10,10);
	JButton [] tabButtons = new JButton[LABELS_BUTTONS.length];
	
	JButton  showButton = new JButton (BUTTON);
	JButton  exitButton = new JButton ("Exit");
	
	public JLabel nameOfMonthLabel;
	
	public int monthIndex = 0;
	
	public MonthPanel [] monthPanel;
	
	public JComboBox<String> ports = new JComboBox<String>();
	String oui [] = {"huit","neuf"};
	
	
	
	/**
	 * Constructor of CalendarPanel.
	 * In this method two panel are used. 
	 * The first one is for Port's button and the second one is for the Calendar
	 */
	public LeftPanel() {
		Date today = new Date ();
		this.setLayout (new BorderLayout(9,9));
		JPanel southPanel = new JPanel ( ) ;
		JPanel northJpanel = new JPanel();
		this.add(southPanel,BorderLayout.SOUTH);
		this.add(northJpanel,BorderLayout.NORTH);
		
		//Center panel
		this.add (centerPanel, BorderLayout.CENTER);
		monthPanel = new MonthPanel [MONTHS_NAME.length];
		
		centerPanel.setLayout (gestCard);
		for (int monthIndex = 0 ; monthIndex< MONTHS_NAME.length ; monthIndex++)
		{
			monthPanel [monthIndex] = new MonthPanel (monthIndex+1);	 
			centerPanel.add (monthPanel[monthIndex], MONTHS_NAME[monthIndex]);
		}
		
		// place the current month at the top of the stack
		gestCard.show (centerPanel, MONTHS_NAME[today.getMonth()-1]); 		
		monthIndex = today.getMonth()-1;
		
		// southPanel  
		nameOfMonthLabel = new JLabel (MONTHS_NAME[today.getMonth()-1], JLabel.LEFT);
		nameOfMonthLabel.setPreferredSize(new Dimension (80,20)); 		 
		nameOfMonthLabel.setFont (new Font ("Verdana",Font.PLAIN,14));	 
		southPanel.add (nameOfMonthLabel);  
		
		//instantiate all button on the calendar 
		southPanel.setLayout (new FlowLayout ( FlowLayout.CENTER, 4,4));	
			for (int i = 0 ; i< LABELS_BUTTONS.length ; i++)		{
				tabButtons[i] = new JButton (LABELS_BUTTONS[i]);  
				tabButtons[i].setActionCommand(LABELS_BUTTONS[i]) ; 
				tabButtons[i].addActionListener (this); 
				tabButtons[i].setFont (new Font ("Verdana",Font.PLAIN,16));
				tabButtons[i].setBackground(Color.lightGray);
				southPanel.add (tabButtons[i]) ;
				}
		
		//add calendar in panel
		centerPanel.setBackground(Color.white);
		southPanel.setBackground (Color.white);	
		setBackground (Color.white);
		setPreferredSize(new Dimension (500,320));
		
		//instantiate Jcombobox 	
		for (int i =0; i< oui.length;i++) {
			ports.addItem(oui[i]);
		}
		northJpanel.add(ports);
		 
		// add exitButoon to northPanel on Leftpanel
		exitButton.setFont (new Font ("Verdana",Font.PLAIN,16));
		exitButton.setBackground(Color.lightGray);
		exitButton.setFocusPainted(false);
		exitButton.setMnemonic('E'); 
		exitButton.setActionCommand("Exit") ; 
		
		northJpanel.add(exitButton);
		
		// add showButton to northPanel on Leftpanel
		showButton.setFont (new Font ("Verdana",Font.PLAIN,16));
		showButton.setBackground(Color.lightGray);
		showButton.setFocusPainted(false);
		showButton.setMnemonic('S');
		exitButton.setActionCommand(BUTTON) ;
		
		northJpanel.add(showButton);
		
		
	}// end of constructor
	
	/**
	   * return the name of the Port selected.
	   * @return String
	   * 	value string
	   */
	public String getPorts() {	
		return (String) ports.getSelectedItem();
				
	}
	
	/**
	   * return the button selected.
	   * @return showButton
	   * 	value showButton
	   */
	public JButton getShowButton()
	{
		return showButton;
	}
	
	/**
	   * return the exit button.
	   * @return exitButton
	   * 	value exitButton
	   */
	public JButton getExitButton()
	{
		return exitButton;
	}
	
	
	/**
	 * Change the display of the month when you click on button and change the name of month.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// to bleach the selected button
		JButton selectedButton = monthPanel [monthIndex].getSelectButton();
		if (selectedButton != null) {
			selectedButton.setBackground(Color.white);
		}
		switch (e.getActionCommand()) {
				case LABEL_FIRST :{
					gestCard.first (centerPanel);
					monthIndex=0; 			
				break;
				}
				case LABEL_PREVIOUS :{
					gestCard.previous (centerPanel);		 
					if (monthIndex==0) {
						monthIndex=MONTHS_NAME.length-1; 				
						}
					else {
						--monthIndex;
					}
					break ;
					}
					case LABEL_NEXT :{
						gestCard.next (centerPanel);		
						if (monthIndex==MONTHS_NAME.length-1) {
							monthIndex=0;
						}
					else {
						++monthIndex;
						}
					break;
					}
					case LABEL_LAST : {
						gestCard.last (centerPanel);
						monthIndex=MONTHS_NAME.length-1; 
						break;			
					}
				 
				}// switch
			nameOfMonthLabel.setText(MONTHS_NAME[monthIndex]);
			}// actionPerformed

			public void recordListenner(controller controller) {
				showButton.addActionListener(controller);
				exitButton.addActionListener(controller);
				for (int monthIndex = 0 ; monthIndex< MONTHS_NAME.length ; monthIndex++)
				{
					for(DateButton bt : monthPanel[monthIndex].arJButton)
					{
						bt.addActionListener(controller);
					}
				}
			
			}
			
}
