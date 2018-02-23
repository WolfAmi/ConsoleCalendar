import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


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

        int firstMonthDay = gregorianCalendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = YearMonth.of(year, month).lengthOfMonth();

        LocalDate firstMonthData = LocalDate.of(year,month,1);
        LocalDate lastMonthData = LocalDate.of(year,month,daysInMonth);

        List<LocalDate> days = getListOfDays(firstMonthData, lastMonthData);
        printMonthCalendar(days, firstMonthDay);
    }


    public static List<LocalDate> getListOfDays(
            LocalDate startDate, LocalDate endDate) {

        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween+1)
                .mapToObj(i -> startDate.plusDays(i))
                .collect(Collectors.toList());
    }


    private static void printMonthCalendar(List<LocalDate> days, int firstMonthDay) {
        int weekdayIndex = 0;

        System.out.println(ANSI_RED+"Mn  Tu  Wn  Th  Fr  St  Sun"+ANSI_RESET);

        for (int day = 1; day < firstMonthDay; day++) {
            System.out.print("    ");
            weekdayIndex++;
        }

        for (LocalDate date : days) {
            int dayOfMonth = date.getDayOfMonth();

            if (dayOfMonth<10&&(weekdayIndex == 5||weekdayIndex == 6)) System.out.print(ANSI_RED+dayOfMonth+" "+ANSI_RESET);
            else if (dayOfMonth<10)                                    System.out.print(dayOfMonth+" ");
            else if (date==LocalDate.now())                            System.out.print(ANSI_CYAN+dayOfMonth+ANSI_RESET);
            else if (weekdayIndex == 5||weekdayIndex == 6)             System.out.print(ANSI_RED+dayOfMonth+ANSI_RESET);
            else System.out.print(dayOfMonth);

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



