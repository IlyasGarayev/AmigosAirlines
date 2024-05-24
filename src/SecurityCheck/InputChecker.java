package SecurityCheck;

import java.util.Scanner;

public class InputChecker {

    public int choiceChecker(int num) {
        int mistakeCount = 3;
        Scanner scanner = new Scanner(System.in); // Initialize the scanner once

        while (true) {
            try {
                System.out.print("Please enter your choice: ");
                if (scanner.hasNextInt()) {
                    int a = scanner.nextInt();
                    if (a >= 0 && a <= num) {
                        return a;
                    } else {
                        mistakeCount--;
                        System.out.println("Verilen eded 0 ile " + num + " arasinda olmalidir. " + mistakeCount + " haqqiniz qaldi\n");
                        if (mistakeCount == 0) {
                            System.out.println("You are banned!");
                            Thread.sleep(3000);
                            System.exit(0);
                        }
                        System.out.println("Seciminizi yeniden edin: ");
                    }
                } else {
                    scanner.next(); // Consume the invalid input
                    mistakeCount--;
                    System.out.println("Invalid input. " + mistakeCount + " haqqiniz qaldi\n");
                    if (mistakeCount == 0) {
                        System.out.println("You are banned!");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ie) {
                            throw new RuntimeException(ie);
                        }
                        System.exit(0);
                    }
                    System.out.println("Seciminizi yeniden edin: ");
                }
            } catch (Exception e) {
                scanner.nextLine(); // Clear the invalid input
                mistakeCount--;
                System.out.println("Invalid input. " + mistakeCount + " haqqiniz qaldi\n");
                if (mistakeCount == 0) {
                    System.out.println("You are banned!");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ie) {
                        throw new RuntimeException(ie);
                    }
                    System.exit(0);
                }
                System.out.println("Seciminizi yeniden edin: ");
            }
        }
    }
}
