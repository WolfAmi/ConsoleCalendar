import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class CalendarForMounth {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter month and year, format - MM YYYY:");

        Calendar currData = Calendar.getInstance();
        int currMonth = currData.get(Calendar.MONTH) +1;
        int currYear = currData.get(Calendar.YEAR);

        String month = scanner.next();
        String year = scanner.next();

        if (month.equals("-")||year.equals("-")) {
            printCalendarMonthYear(currMonth, currYear);
        }
        else {
            printCalendarMonthYear(Integer.parseInt(month),  Integer.parseInt(year));
        }

        scanner.close();
    }

    private static void printCalendarMonthYear(int month, int year) {
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.clear();
        gregorianCalendar.set(year, month - 1, 0);

        Calendar calendar = Calendar.getInstance();
        int dayOfCurrMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int currMonth = calendar.get(Calendar.MONTH)+1;

        int firstMonthDay = gregorianCalendar.get(Calendar.DAY_OF_WEEK);
        int numMonthDay = gregorianCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        if (month!=currMonth) {dayOfCurrMonth=0;}

        printCalendar(numMonthDay, firstMonthDay, dayOfCurrMonth);
    }


    private static void printCalendar(int numMonthDay, int firstMonthDay, int dayOfCurrMonth) {
        int weekdayIndex = 0;

        System.out.println(ANSI_RED+"Mn  Tu  Wn  Th  Fr  St  Sun"+ANSI_RESET);

        for (int day = 1; day < firstMonthDay; day++) {
            System.out.print("    ");
            weekdayIndex++;
        }

        for (int day = 1; day <= numMonthDay; day++) {

            if (day<10&&(weekdayIndex == 5||weekdayIndex == 6)) System.out.print(ANSI_RED+day+" "+ANSI_RESET);
            else if (day<10)                                    System.out.print(day+" ");
            else if (day==dayOfCurrMonth)                       System.out.print(ANSI_CYAN+day+ANSI_RESET);
            else if (weekdayIndex == 5||weekdayIndex == 6)      System.out.print(ANSI_RED+day+ANSI_RESET);
            else System.out.print(day);

            weekdayIndex++;

            if (weekdayIndex == 7) {
                weekdayIndex = 0;
                System.out.println();
            }
            else {
                System.out.print("  ");
         }}
    }

 }



