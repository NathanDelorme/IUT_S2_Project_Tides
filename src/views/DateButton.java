package views;

import javax.swing.JButton;

import models.Date;

/**
 * The {@code BoutonDate} class from {@code vue} package is class useful for create the button present in the calendar panel.
 *
 * @author  Nathan Delorme
 */
public class DateButton extends JButton {

	private static final long serialVersionUID = 1L;
	/**
	 * Contain the date printed on the button's text
	 */
	private Date date;
	
	/**
	 * Constructor for the ButtonDate
	 * 
	 * @param date
	 * 		  Contain button's date
	 */
	public DateButton(Date date) {
		super (Integer.toString(date.getDay()));
		this.date= date;
	}

	/**
	 * get the date of the button.
	 * 
	 * @return date
	 */
	public Date getDate() {		 
		return date;
	}

}