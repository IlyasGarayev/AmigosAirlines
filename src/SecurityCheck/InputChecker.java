package SecurityCheck;

import java.text.ParseException;
import java.util.Scanner;

public class InputChecker {
    public int choiceChecker(int num)  {
        int mistakeCount = 3;
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        while(a < 0 || a > num){
            mistakeCount--;
            System.out.println("Verilen eded 0 ile " + num + " arasinda olmalidir." + mistakeCount + " haqqiniz qaldi\n");
            if(mistakeCount == 0){
                System.out.println("You are banned!");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return 0;
            }
            System.out.println("Seciminizi yeniden edin: ");
            a = scanner.nextInt();
        }
        return a;
    }
}
