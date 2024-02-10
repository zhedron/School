package school;

import models.Student;

import java.util.Scanner;
import java.util.UUID;

public class School {
    public Student student = new Student();

    public void start () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Enter your name, lastname and password.\n 2. Enter if you want know your average grade\n " +
                "3. Exit");

        int action = scanner.nextInt();

        switch (action) {
            case 1:
                registration();
            case 2:
                averageGrade();
                averageGradeForMonth();
                break;
            case 3:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Wrong action.");
        }
    }

    public String generatePassword () {
        return UUID.randomUUID().toString();
    }

    public void averageGrade () {
        if (student.getGrade() < 0) {
            return;
        }

        double grade = student.getGrade();

        double result = grade / 2;

        System.out.println("Average Grade for day: " + result);
    }

    public void averageGradeForMonth () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of days in the month");

        int daysInMonth = scanner.nextInt();

        double totalGrade = 0;

        for (int day = 1; day <= daysInMonth; day++) {
            double[] dailyGrade = student.getGrades();

            totalGrade += dailyGrade[day - 1];
        }

        double averageGrade = totalGrade / daysInMonth;

        System.out.println("Average grade " + averageGrade);
    }

    public void registration () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name");

        String nameStudent = scanner.nextLine();

        System.out.println("Your name: " + nameStudent);

        System.out.println("Enter your last name");

        String lastNameStudent = scanner.nextLine();

        System.out.println("Your last name: " + lastNameStudent);

        String generatePassword = generatePassword();

        System.out.println("Your password: " + generatePassword);

        System.out.println("Enter your password");

        String password = scanner.nextLine();

        if (password.equals(generatePassword)) {
            System.out.println("Password is correct");
        } else {
            System.out.println("Incorrect password");
            System.exit(0);
        }

        System.out.println("Enter your grade today");

        double grade = scanner.nextDouble();

        System.out.println("Grade: " + grade);

        student.setName(nameStudent);
        student.setLastName(lastNameStudent);
        student.setPassword(password);
        student.setGrade(grade);

        double[] gradeForMonth = new double[30];

        for (int i = 1; i < gradeForMonth.length; i++) {
            System.out.println("Enter 30 grade");

            gradeForMonth[i] = scanner.nextDouble();

            System.out.println("Time " + i + ": Grade " + gradeForMonth[i]);

            student.setGrades(gradeForMonth);
        }
    }
}
