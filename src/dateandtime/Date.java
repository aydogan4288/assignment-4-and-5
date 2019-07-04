package dateandtime;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;

public class Date {
	
	static String dividerString = "\n===================================\n";

	public static void main(String[] args) {
		System.out.println(dividerString);
		printPreviousThu();
		System.out.println(dividerString);
		instantToZd();
		System.out.println(dividerString);
		lengthOfMonth(2012);
		System.out.println(dividerString);
		getMondaysOfMonth(Month.MARCH);
		System.out.println(dividerString);
		dateOccursOnFriday("march", "17");
	}
	
	public static void printPreviousThu() {
		LocalDate today = LocalDate.now();
		System.out.printf("The previous Thursday is: %s%n",
		          today.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)));
	}
	
	public static void instantToZd() {
		Instant instant = Instant.now();
        System.out.println(instant);
        
        // ZDT to Instant
        ZonedDateTime zDateTime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()); 
        
        //Instant to ZDT
        Instant inst = ZonedDateTime.now().toInstant();
	}
	
//	5. Write an example that, for a given year, reports the length of each month within that year.
	
	public static void lengthOfMonth(int year) {
		
		if(year <= 0) {
			System.out.println("Year must be greater than 0");
		}else {
			System.out.printf("For the year %d:%n", year);
	        for (Month month : Month.values()) {
	            YearMonth ym = YearMonth.of(year, month);
	            System.out.printf("%s: %d days%n", month, ym.lengthOfMonth());
	        }
		
		}

	}
	
//	Write an example that, for a given month of the current year, lists all of the Mondays in that month.
	public static void getMondaysOfMonth(Month month) {
		
		if(month.length(true) < 1) {
			System.out.println("Type a valid month");
			throw new IllegalArgumentException();
		}
		
		System.out.printf("For the month of %s:%n", month);
        LocalDate date = Year.now().atMonth(month).atDay(1).
              with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        Month mi = date.getMonth();
        while (mi == month) {
            System.out.printf("%s%n", date);
            date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            mi = date.getMonth();
        }	
	}
	
//	Write an example that tests whether a given date occurs on Friday the 13th.
	public static void dateOccursOnFriday(String arg1, String arg2) {
		Month month = null;
		LocalDate date = null;
		
		month = Month.valueOf(arg1.toUpperCase());
		int day = Integer.parseInt(arg2);
		
		date = Year.now().atMonth(month).atDay(day);
		System.out.println(date.query(new FridayQuery()));
		
	}
	
}
	

