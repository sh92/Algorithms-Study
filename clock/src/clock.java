import java.util.Scanner;

/**
 * Created by withGod on 10/6/16.
 */
public class clock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시간을 입력하세요");
        int hour = scanner.nextInt();
        System.out.println("분을 입력하세요");
        int minute = scanner.nextInt();
        new clock(hour,minute);
    }
    public clock(int hour,int minutes) {
        double hours =  hour%12;
        double A = hours*30+ 0.5*minutes;
        double B = minutes*6;
        double angle = Math.abs(A-B);
        System.out.println("Angle is " + angle % 180+ "도");

    }
}
