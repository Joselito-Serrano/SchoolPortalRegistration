
# Assignment Instructions

- Use different classes as needed.
- Create multiple methods as needed.
- Commit your codes in your git repositories.
---


To access the school portal, the user must be able to register and create an account.


Simulate a registry form with the following info and validations:
1. First Name -
- should not contain numerals and special chars
- should not be longer than 50 chars

2. Last Name
- should not contain numerals and special chars
- should not be longer than 50 chars

3. Birthday
- format: yyyy/mm/dd
- acceptable range for college age

4. course
- should not contain numerals
- should not be longer than 50 chars

5. email address
- correct format

6. If all inputs are valid, return a student number with the following format:
   {yearToDate}-{birthday}(01)-{firstLetterOfSurname}
   example: 2023-0201-r