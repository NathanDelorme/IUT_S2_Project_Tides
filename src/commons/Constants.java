package commons;

import models.Date;

/**
 * This class contain all constants we need in our code
 * 
 * @author Alexandre LENFANTIN and Nathan DELORME
 *
 */

public interface Constants {
	/**
     * Constant that contains days week names.
     */
	final String[] DAYS_NAME = {"lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"};
	/**
     * Constant that contains days week names abreviations.
     */
	final String[] DAYS_NAME_ABR = {"lu","ma","me","je","ve","sa","di"};  
	/**
     * Constant that contains months names.
     */
	final  String[] MONTHS_NAME = {"janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre", "novembre", "décembre"};
	
	/**
     * Constant that contain the text for first button slide.
     */
	final String LABEL_FIRST = "<<";
	/**
     * Constant that contain the text for previous button slide.
     */
	final String LABEL_PREVIOUS = "<";
	/**
     * Constant that contain the text for next button slide.
     */
	final String LABEL_NEXT = ">";
	/**
     * Constant that contain the text for last button slide.
     */
	final String LABEL_LAST = ">>";
	
	/**
	* Constant that contains A string for a button
	*/
	final  String BUTTON = "SHOW";
	 
	final  String[] LABELS_BUTTONS = {LABEL_FIRST, LABEL_PREVIOUS, LABEL_NEXT, LABEL_LAST};
		
	/**
	* Constant that contains all hours in {@code String} format.
	*/
	public final  String[] HOURS =
		{"00", "01", "02", "03", "04", "05", "06",
		"07", "08", "09", "10", "11", "12", "13",
		"14", "15", "16", "17", "18", "19", "20",
		"21", "22", "23"};
	/**
	* Constant that contains all minute that can be divided by 15 in {@code String} format.
	*/
	public final  String[] MINUTES = {"00", "15", "30", "45"};
}
