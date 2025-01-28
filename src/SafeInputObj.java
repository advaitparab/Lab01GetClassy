import java.util.Scanner;

public class SafeInputObj {
    private Scanner pipe;

    // Constructors
    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    public SafeInputObj(Scanner pipe) {
        this.pipe = pipe;
    }

    // Methods
    public String getNonZeroLengthString(String prompt) {
        String input;
        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine();
        } while (input.trim().isEmpty());
        return input;
    }

    public int getInt(String prompt) {
        int value;
        while (true) {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine(); // clear the buffer
                return value;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.nextLine(); // clear invalid input
            }
        }
    }

    public double getDouble(String prompt) {
        double value;
        while (true) {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine(); // clear the buffer
                return value;
            } else {
                System.out.println("Invalid input. Please enter a double.");
                pipe.nextLine(); // clear invalid input
            }
        }
    }

    public boolean getYNConfirm(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            input = pipe.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                return true;
            } else if (input.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }
}
