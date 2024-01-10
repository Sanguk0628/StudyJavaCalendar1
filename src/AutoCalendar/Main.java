package AutoCalendar;

import java.util.*;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main {
    private static HashMap <Date, String> planMap;
    
   /* public Main() {
  		planMap = new HashMap<Date, String>();
  	}*/
    
	public static void register(String strDate, String plan) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strDate);
		planMap.put(date, plan);
		
	}
	
	public static String Search(String strDate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strDate);
		String plan = planMap.getOrDefault(date, "000");
		return plan;
	}
	

	public static void main(String[] args) throws ParseException {
		
		Scanner scanner = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();		
  		planMap = new HashMap<Date, String>();

		int year = 2020; 
		int month = 1;
		
		while(true) {
			//물어보고, 대답출력
			printMenu();
			String option = scanner.next();
			
			//대답에 맞게 뿌려주기
			switch (option) {
			case "1": {
				try {
					registerPlan(scanner,cal);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			}
			case "2": {
				try {
					searchPlan(scanner,cal);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			case "3": {
				lookCal(scanner, cal);
				break;
			}
			case "h": {
				printHelp();
				break;
			}
			case "q": {
				System.out.println("Bye~");
				break;
			}
			default:
				System.out.println("잘못된 입력입니다");
				continue;
			}
			if(option.equals("h")){
				break;
			}
		
			scanner.close();
			System.out.print("프로그램 종료");
		
	}

}		
	
	
		//0. 메뉴 출력
	private static void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");           
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말");
		System.out.println("| q. 종료");
		System.out.println("+----------------------+");
		System.out.println("명령 (1, 2, 3, h, q)");		
	}
	
		// 1. 일정 등록
	private static void registerPlan(Scanner s, Calendar c) throws ParseException {
		System.out.println("[[새 일정을 등록합니다]]");
		System.out.println("날짜를 입력하여 주세요(yyyy-mm-dd)");
		String date = s.next();
		String text ="";
		s.nextLine();
		System.out.println("일정을 적어주세요(문장 끝에 .을 찍어주세요)");
		text = s.nextLine();
		
		register(date, text);	
	}
	
		// 2. 일정 검색
	private static void searchPlan(Scanner s, Calendar c) throws ParseException {
		System.out.println("[[일정을 검색합니다]]");
		System.out.println("날짜를 입력하여 주세요(yyyy-mm-dd)");
		String date = s.next();
		String plan = null;
		
		try {
			plan = Search(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(plan != null) {
		System.out.println(plan);
		}else {
			System.out.println("일정이 없습니다!");
		}
	}
	
	
		// 3. 달력보기
		private static void lookCal(Scanner scanner, Calendar calendar) {
		PrintPrompt pp = new PrintPrompt();
		int month = 1;
		int year = 1000;
		
			
		System.out.println("년도를 입력 후 엔터하세요");
		year = scanner.nextInt();
				
			
		System.out.println("달을 입력 후 엔터하세요");
		month = scanner.nextInt();
		
		pp.printCalendar(year, month);
		
	}
		
		// 4. 도움말
	private static void printHelp() {
		System.out.println("도움이 필요한시면 www.aaaa.kr 로 문의주세요!");	
	}
	
}
