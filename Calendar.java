package calendar;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
public class Calendar {
    private static String head;
    private static LocalDate currentDate;
    private static int currentDayOfWeekNumber;
    private static int days;
    private static void init(int year, int month){
        head = "MON|TUE|WED|THU|FRI|SAT|SUN|";
        currentDate = LocalDate.of(year, month, 1);
        currentDayOfWeekNumber = currentDate.getDayOfWeek().getValue();
        days = currentDate.getMonth().length(getLeapYear(year));
    }
    private static boolean getLeapYear(int year){
        return ((2000 - year) %4 == 0);
    }
    private static boolean checked(int year, int month){
        boolean checked = true;
        if (year < 1900 || year > 2100) checked = false;
        if (month < 1 || month > 12) checked = false;
        return checked;
    }
    public static void show(int year, int month) throws CalendarIllegalArgumentException{
        if (!checked(year, month)) throw new CalendarIllegalArgumentException("Year or/and month value is incorrect!");
        init(year, month);
        System.out.println(currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.US) +
                ", " + currentDate.getYear());
        System.out.print(head + "\n");
        for (int i = 1; i < currentDayOfWeekNumber; i++) System.out.print("   |");
        for (int i = 1; i <= days; i++){
            if (currentDayOfWeekNumber <= 7) {
                System.out.printf("%3d", i);
                System.out.print("|");
                currentDayOfWeekNumber++;
            }
            else {
                System.out.println();
                System.out.printf("%3d", i);
                System.out.print("|");
                currentDayOfWeekNumber = 2;
            }
        }
        System.out.println();
    }
}
