package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.Date;
import views.LeftPanel;
import views.DateButton;

/**
 * he {@code Controller} class from {@code controller} package is the Controller part of MVC agenda software.
 * @author Alexandre LENFANTIN
 *
 *@see LeftPanel.CalendarPanel
 * 
 * 
 */
public class controller implements ActionListener {
	
	/**
     * Constructor of the class {@code controller}
     * @param parCalendarPanel
     */
	LeftPanel atCalendarPanel;
	
	public controller (/*liste des horraires*/ LeftPanel parCalendarPanel) {
		
		/*listes hooraires = parListeHorraire*/
		atCalendarPanel = parCalendarPanel;
		
		atCalendarPanel.recordListenner(this);
	}


	/**
	 * {@code @code controller} is a variable from {@code @code controller} class.
	 * This actionPerformed allow to change date and port. With that we can switch between two
	 * Table to display schedule and the advancement of tides.
	 * It can exit the gui with a button
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		 if (evt.getSource() == atCalendarPanel.getShowButton()) {
			String str = atCalendarPanel.getPorts();
			System.out.println(str);
			/*JOptionPane.showMessageDialog(atCalendarPanel.getShowButton(),"oui");*/
		}
		 
		 else if (evt.getSource() == atCalendarPanel.getExitButton()) {
			 int grasped = JOptionPane.showConfirmDialog (atCalendarPanel,"Êtes-vous sûr de votre choix ?",
					 "Dialogue de confirmation",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
			 switch (grasped) {
			 	case JOptionPane.CLOSED_OPTION:
			 		/*System.out.println ("Valeur retournée : " +grasped);*/break;
			 	case JOptionPane.OK_OPTION:
			 		System.exit(0);
			 		/*System.out.println ("Valeur retournée : " +grasped);*/break;
			 	case JOptionPane.CANCEL_OPTION:
					/*System.out.println ("Valeur retournée : " +grasped); */break;
				} // switch
		 }
		 
		 else if(evt.getSource() instanceof DateButton)
		{			
			DateButton bt = atCalendarPanel.monthPanel[atCalendarPanel.monthIndex].selectedButton;
			
			if(bt != null)
			{
				Date selectedDate = bt.getDate();
				bt.setBackground(Color.white);
				
				if (selectedDate.isToday())
					bt.setBackground(Color.cyan);
				else if (selectedDate.getMonth() != atCalendarPanel.monthPanel[atCalendarPanel.monthIndex].month)
					bt.setBackground(Color.lightGray);
				if (selectedDate.getDayOfWeek() == 6 || selectedDate.getDayOfWeek() == 7)
					bt.setForeground(Color.red);
			}
			
			bt = (DateButton) evt.getSource();
			bt.setBackground(Color.yellow);
			atCalendarPanel.monthPanel[atCalendarPanel.monthIndex].selectedButton = bt;
			
		}
		
			
	}
	
}
