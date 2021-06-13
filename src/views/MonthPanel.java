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

public class MonthPanel extends JPanel implements commons.Constants {
	public DateButton selectedButton;
	public ArrayList<DateButton> arJButton = new ArrayList<DateButton>();
	public int month;
		
	public MonthPanel (int parMonth)  {
		this.month = parMonth;
		Date today = new Date();
		 
		Collection <Date> datesDuMois = new CalendarOfMonth(month,today.getYear()).getDates();
		//System.out.println(datesDuMois);		
		this.setLayout(new GridLayout (0,7,8,8));
		for (int i= 0; i < 7 ; i++) {
			JLabel labeljour = new  JLabel (DAYS_NAME_ABR[i],JLabel.CENTER);
			this.add(labeljour);
		}
		
		DateButton boutonJour;
		
		Iterator <Date> iterateur = datesDuMois.iterator();
		while (iterateur.hasNext()) {
				Date date = iterateur.next() ;
				boutonJour = new  DateButton (date);
				
				//boutonJour.addActionListener(this); 
				// gestion des couleurs des boutons 
				this.add(boutonJour);
				 
				boutonJour.setBackground(Color.white);
				
				if (date.isToday())
					boutonJour.setBackground(Color.cyan);
				else if (date.getMonth() != month)
					boutonJour.setBackground(Color.lightGray);
				if (date.getDayOfWeek() == 6 || date.getDayOfWeek() == 7)
					boutonJour.setForeground(Color.red);
				arJButton.add(boutonJour);
					
		}		
		
		setBackground(Color.white);
	}
	
	public JButton getSelectButton () {
		return selectedButton;	
	}
}
