import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private String course;
    private String emailAddress;
    private String studentNumber;

    public String getFirstName() {
        return firstName;
    }

    public boolean setFirstName(String firstName) {
        if (containsNumeral(firstName) || containsSpecialChars(firstName) || characterLimit(firstName)) {
            return false;
        } else {
            this.firstName = firstName;
            return true;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public boolean setLastName(String lastName) {
        if (containsNumeral(lastName) || containsSpecialChars(lastName) || characterLimit(lastName)) {
            return false;
        } else {
            this.lastName = lastName;
            return true;
        }
    }

    public String getBirthDay(String format) {
        if (format.equalsIgnoreCase("")) {
            format = "yyyy-mm-dd";
        }
        return LocalDate.parse(birthDay.toString(), DateTimeFormatter.ofPattern(format)).toString();
    }

    public boolean setBirthDay(String birthDay) {
        if (correctDateFormat(birthDay) && acceptableCollegeAge(birthDay)) {
            this.birthDay = getLocalDate(birthDay);
            return true;
        } else {
            return false;
        }
    }

    public String getCourse() {
        return course;
    }

    public boolean setCourse(String course) {
        if (containsNumeral(course) || characterLimit(course)) {
            return false;
        } else {
            this.course = course;
            return true;
        }
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public boolean setEmailAddress(String emailAddress) {
        if (correctEmailFormat(emailAddress)) {
            this.emailAddress = emailAddress;
            return true;
        } else {
            return false;
        }
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public boolean setStudentNumber() {
        if (!firstName.isEmpty() && !lastName.isEmpty()
                && !birthDay.toString().isEmpty() && !course.isEmpty()
                && !emailAddress.isEmpty()) {
            int year = LocalDate.now().getYear();
            this.studentNumber = year + "-" + birthDay.getDayOfMonth() + "01-" + firstName.charAt(0);
//            {yearToDate}-{birthday}(01)-{firstLetterOfSurname}
            return true;
        }
        return false;
    }

    public boolean containsNumeral(String input) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public boolean containsSpecialChars(String input) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9 ]");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public boolean characterLimit(String input) {
        final int charLimit = 50;
        return charLimit < input.length();
    }

    public boolean correctDateFormat(String date) {
        Pattern pattern = Pattern.compile("^[\\d]{4}/[\\d]{2}/[\\d]{2}$");
        Matcher matcher = pattern.matcher(date);
        return matcher.find();
    }

    public boolean acceptableCollegeAge(String date) {
        final int collegeAgeMin = 18;
        final int collegeAgeMax = 122;
        try {
            final int age = getAge(date);

            return age >= collegeAgeMin && age <= collegeAgeMax;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public int getAge(String date) {
        final LocalDate birthDate = getLocalDate(date);
        final LocalDate curDate = LocalDate.now();

        //Probably same as below
        return birthDate.until(curDate).getYears();
//        return Period.between(birthDate, curDate).getYears();
    }

    //Need to convert input due to format required input by user is yyyy/mm/dd to yyyy-mm-dd
    private LocalDate getLocalDate(String date) {
        date = date.replaceAll("/", "-");
        return LocalDate.parse(date);
    }

    private boolean correctEmailFormat(String emailAddress) {
        final String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?``{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailAddress);
        return matcher.find();
    }

}
