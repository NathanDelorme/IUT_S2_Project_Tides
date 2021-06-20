package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.Date;
import views.CalendarPanel;
import views.DateButton;

/**
 * he {@code Controller} class from {@code controller} package is the Controller part of MVC agenda software.
 * @author Alexandre LENFANTIN
 *
 *@see view.CalendarPanel
 *@see view.PortsButtons 
 * 
 */
public class controller implements ActionListener {
	
	/**
     * {@code atCalendarPanel} is a variable from {@code CalendarPanel} class. Contains a {@code JPanel} with the UI for select event day.
     */
	CalendarPanel atCalendarPanel;
	
	public controller (/*liste des horraires*/ CalendarPanel parCalendarPanel) {
		
		/*listes hooraires = parListeHorraire*/
		atCalendarPanel = parCalendarPanel;
		
		atCalendarPanel.recordListenner(this);
		atCalendarPanel.recordListenner(this);
	}


	@Override
	public void actionPerformed(ActionEvent evt) {
		
		 if (evt.getSource() == atCalendarPanel.getShowButton()) {
			String str = atCalendarPanel.getPorts();
			System.out.println(str);
			JOptionPane.showMessageDialog(atCalendarPanel.getShowButton(),"oui");
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
