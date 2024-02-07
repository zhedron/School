package school;

import models.Student;
import models.Teacher;

import java.util.Scanner;
import java.util.UUID;

public class School {
    public Student student;
    public Teacher teacher;

    public void start () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Enter your name, lastname and password\n 2. Enter if you want know your average grade\n " +
                "3. Enter your name, lastName and job position teacher.\n 4. Exit");

        student = new Student();
        teacher = new Teacher();

        int action = scanner.nextInt();

     //   String generatePassword = generatePassword();

      //  System.out.println("Your password: " + generatePassword);

        switch (action) {
            case 1:
                registration();
             //   break;

            case 2:
                averageGrade();
                averageGradeForMonth();
                break;

            case 3:
                registrationTeacher();
                break;

            default:
                System.out.println("Application finished.");
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

        System.out.println(result);
    }

    public void averageGradeForMonth () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of days in the month");

        int daysInMonth = scanner.nextInt();

        double totalGrade = 0;

        for (int day = 1; day < daysInMonth; day++) {
            double dailyGrade = student.getGrade();

            if (dailyGrade < 0) {
                day--;
                continue;
            }

            totalGrade += dailyGrade;
        }

        double averageGrade = totalGrade / daysInMonth;

        System.out.println("Average grade " + averageGrade);
    }

    public void registration () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name");

        String nameStudent = scanner.nextLine();

        System.out.println("Enter your last name");

        String lastNameStudent = scanner.nextLine();

        System.out.println("Enter your grade today");
        //  String password = scanner.nextLine();
        double grade = scanner.nextDouble();

        String password = generatePassword();

        System.out.println("Your password: " + password);

        System.out.println("Name Student: " +  nameStudent);

        System.out.println("Grade: " + grade);

        student.setName(nameStudent);
        student.setLastName(lastNameStudent);
        student.setPassword(password);
        student.setGrade(grade);
    }

    public void registrationTeacher () {
        Scanner scanner = new Scanner(System.in);

        String nameTeacher = scanner.nextLine();
        String lastNameTeacher = scanner.nextLine();
        String jobPosition = scanner.nextLine();

        teacher.setName(nameTeacher);
        teacher.setLastName(lastNameTeacher);
        teacher.setJobPosition(jobPosition);
    }

   /* public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }*/
}
