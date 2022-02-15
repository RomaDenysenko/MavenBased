package MyTest;
import java.util.Scanner;
public class MyTest2 {
    //body mass index calculation

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("input weight:");
        int w = scanner.nextInt(); //weight in killograms
        System.out.println(w);

        System.out.print("input growth:");
        double g = scanner.nextDouble(); //growth in meters

        System.out.println(w/(g*2));
    }
}


