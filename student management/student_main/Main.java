package student_main;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
           System.out.println("-------------------------------");
           System.out.println("---STUDENT MANAGEMENT SYSTEM---");
           System.out.println("-------------------------------");
        while(true) {
            System.out.println("1. Insert Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
             System.out.print("enter your choice : ");
            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    students.insertstudent();
                    break;

                case 2:
                    students.displayStudents();
                    break;

                case 3:
                    students.updatestudent();
                    break;

                case 4:
                    students.deletestudent();
                    break;

                case 5:
                    students.searchstudent();
                    break;

                case 6:
                    System.out.println("Thank you for using Student Management System");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}