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
public class CalendarPanel  extends JPanel implements commons.Constants, ActionListener{
	JPanel centerPanel = new JPanel ( ) ;
	CardLayout gestCard = new CardLayout(10,10);
	JButton [] tabButtons = new JButton[LABELS_BUTTONS.length];
	
	JButton  showButton = new JButton (BUTTON);
	
	public JLabel nameOfMonthLabel;
	
	public int monthIndex = 0;
	
	public MonthPanel [] monthPanel;
	
	public JComboBox<String> ports = new JComboBox<String>();
	String oui [] = {"huit","neuf"};
	
	
	
	/**
	 * Constructor of CalendarPanel
	 */
	public CalendarPanel() {
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
			
		southPanel.setLayout (new FlowLayout ( FlowLayout.CENTER, 4,4));	
			for (int i = 0 ; i< LABELS_BUTTONS.length ; i++)		{
				tabButtons[i] = new JButton (LABELS_BUTTONS[i]);  
				tabButtons[i].setActionCommand(LABELS_BUTTONS[i]) ; 
				tabButtons[i].addActionListener (this); 
				tabButtons[i].setFont (new Font ("Verdana",Font.PLAIN,16));
				tabButtons[i].setBackground(Color.lightGray);
				southPanel.add (tabButtons[i]) ;
				}
			
		centerPanel.setBackground(Color.white);
		southPanel.setBackground (Color.white);	
		setBackground (Color.white);
		setPreferredSize(new Dimension (500,320));
		
			
		for (int i =0; i< oui.length;i++) {
			ports.addItem(oui[i]);
		}
		northJpanel.add(ports);
		 

		showButton.setFont (new Font ("Verdana",Font.PLAIN,16));
		showButton.setBackground(Color.lightGray);
		showButton.setFocusPainted(false);
		showButton.setMnemonic('S');
		
		northJpanel.add(showButton);
		
		
	}// end of constructor
	
	
	public String getPorts() {	
		return (String) ports.getSelectedItem();
				
	}
	
	public JButton getShowButton()
	{
		return showButton;
	}
	
	
	/**
	 * Change the display of the month when you click on button
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
				for (int monthIndex = 0 ; monthIndex< MONTHS_NAME.length ; monthIndex++)
				{
					for(DateButton bt : monthPanel[monthIndex].arJButton)
					{
						bt.addActionListener(controller);
					}
				}
				showButton.addActionListener(controller);
			}
			
}
