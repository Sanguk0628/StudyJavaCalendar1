package AutoCalendar;

import java.util.Calendar;

public class PrintPrompt {
private static final int[] MAXDAYS = {31,28,31,30,31,30,31,31,30,31,30,31};

	//최대 일수 구하기
	public int getMaxOfMonth(int month) {
		
		return MAXDAYS[month-1];
	}
	
	
	//시작 요일 구하기
	public int getWeekDay(int year, int month) {
		
       Calendar calendar = Calendar.getInstance();		
       calendar.set(year,month-1,1);
		
	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

		return dayOfWeek-1;
	}
	
	
	public void printCalendar(int year, int month) {
		
		//윤달 처리
		if((year % 4 == 0) && ((year % 100 != 0) || (year % 400 != 0))) {
			MAXDAYS[1] = 29;
		}
		
		//get WeekDay automatically
		int dayOfWeek = getWeekDay(year, month);
		
		//printout
		System.out.println();
		System.out.printf(" << %4d년%3d월 >>",year, month);
		System.out.println();
		System.out.println("----------------------");
		System.out.println(" 일 월 화 수 목 금 토 ");
		System.out.println("======================");
		
		int maxOfDays = getMaxOfMonth(month);
		
		// print blank line
		for (int j = 0; j < dayOfWeek; j++) {
			System.out.printf("   ");
		}
		
		// print first line
		int count = 7 - dayOfWeek;
		int delim = count;
		
		// 수 3 카ㅣ운트 4
		for(int i = 1; i <= count; i++) {
			System.out.printf("%3d",i);
		}
		System.out.println();

		count++;
		// print remain line
		for(int i = count; i <= maxOfDays; i++) {
			System.out.printf("%3d",i);
			
			if(i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("----------------------");
		System.out.println();
		MAXDAYS[1] = 28;
	}
}
