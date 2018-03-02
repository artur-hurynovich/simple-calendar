package calendar;
import java.util.Scanner;
public class CalendarRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;
        String repeat;
        do {
            try {
                System.out.print("Enter the year: ");
                int year = scanner.nextInt();
                System.out.print("Enter the month: ");
                int month = scanner.nextInt();
                Calendar.show(year, month);
                success = true;
            }
            catch (CalendarIllegalArgumentException e){
                System.err.println(e.getMessage());
            }
            finally {
                System.out.println("If you want to repeat, type \"y\", otherwise - \"n\": ");
                repeat = scanner.next();
            }
        }
        while (!success || repeat.equalsIgnoreCase("y"));
    }
}