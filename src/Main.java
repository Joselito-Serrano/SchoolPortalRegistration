import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String firstName = scan.nextLine();
        String lastName = scan.nextLine();
        String birthday = scan.nextLine();
        String course = scan.nextLine();
        String emailAddress = scan.nextLine();
        scan.close();

        String yearToDate = String.valueOf(LocalDate.now().getYear());

        //To store as LocalDate replace all '/' with '-'
        birthday = birthday.replaceAll("/", "-");
        LocalDate birthDate = LocalDate.parse(birthday);


        String toReturn = yearToDate + "-" + birthDate.getDayOfMonth() + "01" + "-" + lastName.charAt(0);

        System.out.println(toReturn);
    }
}