import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        User user1 = new User();
        Scanner scan = new Scanner(System.in);
        boolean hasSet;

        System.out.println("Input First Name: ");
        do {
            hasSet = user1.setFirstName(scan.nextLine());
            hasSet = !hasSet;
            if (hasSet) {
                System.out.println("Invalid First Name!\nInput First Name:");
            }
        }
        while (hasSet);

        System.out.println("Input Last Name: ");
        do {
            hasSet = user1.setLastName(scan.nextLine());
            hasSet = !hasSet;
            if (hasSet) {
                System.out.println("Invalid Last Name!\nInput Last Name:");
            }
        }
        while (hasSet);

        System.out.println("Input Birth Day: ");
        do {
            hasSet = user1.setBirthDay(scan.nextLine());
            hasSet = !hasSet;
            if (hasSet) {
                System.out.println("Invalid Birth Day!\nInput Birth Day:");
            }
        }
        while (hasSet);

        System.out.println("Input Course: ");
        do {
            hasSet = user1.setCourse(scan.nextLine());
            hasSet = !hasSet;
            if (hasSet) {
                System.out.println("Invalid Course!\nInput Course:");
            }
        }
        while (hasSet);

        System.out.println("Input Email Address: ");
        do {
            hasSet = user1.setEmailAddress(scan.nextLine());
            hasSet = !hasSet;
            if (hasSet) {
                System.out.println("Invalid Email Address!\nInput Email Address:");
            }
        }
        while (hasSet);

        scan.close();

        if (user1.setStudentNumber()) {
            System.out.println(user1.getStudentNumber());
        } else {
            System.out.println("Unexpected Error!");
        }
    }

    //Method with more precise feedback
    private static void anotherMethod() {
        String input;
        User user1 = new User();
        Scanner scan = new Scanner(System.in);
        boolean hasSet;

        System.out.println("Input First Name: ");
        do {
            input = scan.nextLine();
            if (user1.containsNumeral(input)) {
                System.out.println("First Name can't contain numbers");
                hasSet = false;
            } else if (user1.containsSpecialChars(input)) {
                System.out.println("First Name can't special characters");
                hasSet = false;
            } else if (user1.characterLimit(input)) {
                System.out.println("First Name can't exceed 50 characters");
                hasSet = false;
            } else {
                hasSet = true;
            }

            hasSet = !hasSet;
            if (hasSet) {
                System.out.println("Input First Name:");
            }
        }
        while (hasSet);

        System.out.println("Input Last Name: ");
        do {
            hasSet = user1.setLastName(scan.nextLine());
            hasSet = !hasSet;
            if (hasSet) {
                System.out.println("Invalid Last Name!\nInput Last Name:");
            }
        }
        while (hasSet);

        System.out.println("Input Birth Day: ");
        do {
            hasSet = user1.setBirthDay(scan.nextLine());
            hasSet = !hasSet;
            if (hasSet) {
                System.out.println("Invalid Birth Day!\nInput Birth Day:");
            }
        }
        while (hasSet);

        System.out.println("Input Course: ");
        do {
            hasSet = user1.setCourse(scan.nextLine());
            hasSet = !hasSet;
            if (hasSet) {
                System.out.println("Invalid Course!\nInput Course:");
            }
        }
        while (hasSet);

        System.out.println("Input Email Address: ");
        do {
            hasSet = user1.setEmailAddress(scan.nextLine());
            hasSet = !hasSet;
            if (hasSet) {
                System.out.println("Invalid Email Address!\nInput Email Address:");
            }
        }
        while (hasSet);

        scan.close();

        if (user1.setStudentNumber()) {
            System.out.println(user1.getStudentNumber());
        } else {
            System.out.println("Unexpected Error!");
        }
    }

    private static String validateName(String name, String input) {
        return "";
    }
}