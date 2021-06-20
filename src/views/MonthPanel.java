package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.CalendarOfMonth;
import models.Date;

/**
 * The {@code MonthPanel} class from {@code view} package is class which allow to record the day on a Array List.
 * With that we can display the month on the {@code CalendarPanel}
 * @author Alexandre LENFANTIN
 *
 */
public class MonthPanel extends JPanel implements commons.Constants {
	public DateButton selectedButton;
	public ArrayList<DateButton> arJButton = new ArrayList<DateButton>();
	public int month;
		
	/**
	 * Constructor of MonthPanel with a month.
	 * @param parMonth
	 * 		value parMonth
	 */
	public MonthPanel (int parMonth)  {
		this.month = parMonth;
		Date today = new Date();
		 
		Collection <Date> datesDuMois = new CalendarOfMonth(parMonth,today.getYear()).getDates();	
		this.setLayout(new GridLayout (0,7,8,8));
		for (int i= 0; i < 7 ; i++) {
			JLabel labeljour = new  JLabel (DAYS_NAME_ABR[i],JLabel.CENTER);
			this.add(labeljour);
		}
		
		DateButton dayBouton;
		
		Iterator <Date> iterateur = datesDuMois.iterator();
		while (iterateur.hasNext()) {
				Date date = iterateur.next() ;
				dayBouton = new  DateButton (date);
				; 
				// Management of the buttons' colors
				this.add(dayBouton);
				 
				dayBouton.setBackground(Color.white);
				
				if (date.isToday())
					dayBouton.setBackground(Color.cyan);
				else if (date.getMonth() != month)
					dayBouton.setBackground(Color.lightGray);
				if (date.getDayOfWeek() == 6 || date.getDayOfWeek() == 7)
					dayBouton.setForeground(Color.red);
				arJButton.add(dayBouton);
					
		}		
		
		setBackground(Color.white);
	}
	/**
	 * Return the button who was selected by user
	 * @return selectedButton
	 */
	public JButton getSelectButton () {
		return selectedButton;	
	}
}
