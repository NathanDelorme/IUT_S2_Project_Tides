package models;
import java.util.*;
/**
 *The {@code CalendrierDuMois} class from {@code modele} package create a treeset which contain all day from a month of a year. 
 * @author Alexandre LENFANTIN
 *
 */

public class CalendarOfMonth {
	
	/**
	 * Contains all day of the month of the year
	 */
	private Collection <Date> treeSetDate;
	
	/**
	 * Constructor who build the collection treeSetDate.
	 * @param mois
	 * 			mois of the year
	 * @param annee
	 * 			annee value
	 */
	public CalendarOfMonth (int parMonth, int parYear) {
		treeSetDate = new TreeSet <Date> ();
	    Date date = new Date (1,parMonth,parYear);
	    int indiceDay = date.getDayOfWeek() ;
	    for (int x = indiceDay ; x!=0 ; x--) {
	    	treeSetDate.add(date);	    	
	    	date = date.yesterdaysDate();
	    }	    
	    date = new Date (2,parMonth,parYear);
	    indiceDay = indiceDay % 7 ;
	    while (date.getMonth () == parMonth) {
	    	while(indiceDay<7) {
	    		treeSetDate.add(date);
	    		date = date.yesterdaysDate();
	    		indiceDay++ ;
	    	} 
	    	indiceDay=0;
	    }
	}
 
	/**
	 * Getter for treeSetDate.
	 * @return treeSetDate
	 */
	public Collection <Date> getDates() {	
		return treeSetDate;	
	}	
	
	/**
	 * Return a string contain the representation of the data in treeSetDate.
	 */
	public String toString () {
		return treeSetDate.toString();
	}
}
