package models;
import java.util.*;


/**
 * The {@code Date} class from {@code modele} package is class which allow to store date.
 * 
 * @author Alexandre LENFANTIN
 *
 */
public class Date implements commons.Constants, Comparable<Date>{
	private int day;
	private int month;
	private int year;
	private int dayofWeek;
	private int numberOfWeek;
	 
	/**
	 * Constructor for today's date
	 */
	public Date() {
		GregorianCalendar dateAuj = new GregorianCalendar ();
		year = dateAuj.get (Calendar.YEAR);
		month = dateAuj.get (Calendar.MONTH) + 1; 
		day = dateAuj.get (Calendar.DAY_OF_MONTH);
		dayofWeek = dateAuj.get (Calendar.DAY_OF_WEEK);
		numberOfWeek = dateAuj.get(Calendar.WEEK_OF_YEAR);
		if (dayofWeek == 1)
			dayofWeek = 7;
		else dayofWeek -= 1; 
	}
	
	/**
	 * Constructor for today's date with parameters like day , month and year
	 * 
	 * @param parDay
	 * 		  day value
	 * 
	 * @param parMonth
	 *  	  month value
	 *  
	 * @param parYear
	 *  	  year value
	 */
	public Date (int parDay,int parMonth, int parYear) {
		day = parDay;
		month = parMonth;
		year = parYear; 
		GregorianCalendar date = new GregorianCalendar (year,month-1,day);
		dayofWeek = date.get (Calendar.DAY_OF_WEEK);	
		numberOfWeek = date.get(Calendar.WEEK_OF_YEAR);
		if (dayofWeek == 1)
			dayofWeek = 7;
		else dayofWeek -= 1; 

	}
	  /**
	   * Get if it's a leap year or not from year.
	   *
	   * @param  parAnnee
	   *         year value
	   */
	  private static boolean isBissextile(int parYear) {
				return parYear % 4 == 0 && (parYear % 100 != 0 || parYear % 400 == 0);
	  }
	  
	  
	 /**
	   * get number of day int the month.
	   * 
	   * @param  parMois
	   *         month value
	   *
	   * @param  parAnnee
	   *         year value
	   * 
	   * @return int
	   */
	public static int lastDayofTheMonth (int parMonth,int parYear) {
		switch (parMonth) {
		case 2 : if (isBissextile (parYear))  return 29 ; else return 28 ;  
		 case 4 : 	 case 6 : 	 case 9 : 	 case 11 : return 30 ;
		 default : return 31;
		}
	}
	
	/**
	 * Get next date of the current date.
	 * 
	 * @return Date
	 */
	public Date nextDaysDate () {
		if (day < lastDayofTheMonth(month,year))
		     return  new Date (day+1,month,year);
		else if (month < 12)
				return new Date (1,month+1,year);
			 else return new Date (1,1,year+1);
	}
	
	/**
	 * Get previous date of the current date.
	 * 
	 * @return Date
	 */
	 public Date yesterdaysDate () {    
			if (day > 1)
					return  new Date (day-1,month,year);
			else if (month > 1)
					   return new Date (Date.lastDayofTheMonth(month-1, year),month-1,year);
				 else return  new Date (31,12,year-1);
		  }	 
	 /**
	 * Return boolean if the date is equal to the today date.
	  * 
	  * @return boolean
	  */
	 public boolean isToday() {
	 	return new Date().compareTo(this) == 0;
	 }
	 
	  /**
	   * return the first day of the week.
	   * @return Date
	   * 	value date
	   */
	  public Date firstDayOfWeek()

	  {
		  Date res = this;
		  
		  while(res.getDayOfWeek() != 1)
		  {
			  res = res.yesterdaysDate();
		  }
		  
		  return res;
	  }
	  
	  /**
	   * Getter for year.
	   * 
	   * @return year
	   */
	public int getYear() { 
		return year;
	}

	/**
	 * Getter for day.
	 * 
	 * @return day
	 */
	public int getDay() { 
		return day;
	}

	/**
	 * Getter for month.
	 * 
	 * @return month
	 */
	public int getMonth() { 
		return month;
	}

	/**
	 * Getter for jourSemaine.
	 * 
	 * @return jourSemaine
	 */
	public int getDayOfWeek () {
		return dayofWeek;
	}
	
	/**
	 * toSting methode is used to print the result of date on the console
	 */
	public String toString () {
		  return  DAYS_NAME[dayofWeek -1] + " " + day + " " + MONTHS_NAME[month-1];	  
	 }
	
	/**
	   * return 0 if this and parDate are equals, 
	   * -1 if this is before parDate,
	   *  1 if parDate is before this.
	   *  
	   *  
	   *  * @param  parDate
	   *         compared date
	   *        
	   */
	@Override
	public int compareTo(Date parDate) {
		 if (year < parDate.year)
				return -1;
			if (year > parDate.year)
				return 1;
			
			if (month < parDate.month)
				return -1;
			if (month > parDate.month)
				return 1;
			
			if (day < parDate.day)
				return -1;
			if (day > parDate.day)
				return 1;
			return 0;	
		// TODO Auto-generated method stub
	}
 
}
