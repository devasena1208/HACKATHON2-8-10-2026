import java.util.Scanner;

public class Hackathon2 {

    static class Student {
        String studentName;
        int rollNumber;
        double marks;
        String courseName;
        int courseCredits;

        Student(String studentName, int rollNumber, double marks, String courseName, int courseCredits) {
            this.studentName = studentName;
            this.rollNumber = rollNumber;
            this.marks = marks;
            this.courseName = courseName;
            this.courseCredits = courseCredits;
        }

        double calculateFee() {
            return courseCredits * 1500;
        }

        boolean checkEligibility() {
            return marks >= 50;
        }

        double calculateScholarship() {
            double fee = calculateFee();
            if (marks >= 85) {
                return fee * 20 / 100;
            } else if (marks >= 70) {
                return fee * 10 / 100;
            } else {
                return 0;
            }
        }

        double calculateFinalFee() {
            return calculateFee() - calculateScholarship();
        }

        void displayDetails() {
            System.out.println("\n===== Student Details =====");
            System.out.println("Student Name   : " + studentName);
            System.out.println("Roll Number    : " + rollNumber);
            System.out.println("Marks          : " + marks);

            System.out.println("\n===== Course Details =====");
            System.out.println("Course Name    : " + courseName);
            System.out.println("Course Credits : " + courseCredits);

            System.out.println("\n===== Registration Details =====");
            System.out.println("Eligibility    : " + (checkEligibility() ? "Eligible" : "Not Eligible"));
            System.out.printf("Total Fee      : Rs. %.2f%n", calculateFee());
            System.out.printf("Scholarship    : Rs. %.2f%n", calculateScholarship());
            System.out.printf("Final Fee      : Rs. %.2f%n", calculateFinalFee());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();

        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter course name: ");
        String course = sc.nextLine();

        System.out.print("Enter course credits: ");
        int credits = sc.nextInt();

        Student s = new Student(name, roll, marks, course, credits);

        if (s.checkEligibility()) {
            s.displayDetails();
        } else {
            System.out.println("Student is not eligible for course registration.");
        }

        sc.close();
    }
}