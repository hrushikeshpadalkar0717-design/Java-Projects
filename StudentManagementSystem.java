package BASICS.JAVA_PROJECTS;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    float marks;
    Student prev, next;

    Student(int rollNo, String name, float marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        this.prev = this.next = null;
    }
}

class StudentList {
    private Student head;

    public void addStudent(int rollNo, String name, float marks) {
        Student newStudent = new Student(rollNo, name, marks);

        if (head == null) {
            head = newStudent;
        } else {
            Student temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newStudent;
            newStudent.prev = temp;
        }
        System.out.println("Student added successfully");
    }

    public void deleteStudent(int rollNo) {
        Student temp = head;
        while (temp != null && temp.rollNo != rollNo)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Student not found");
            return;
        }

        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp == head) head = temp.next;

        System.out.println("Student deleted successfully");
    }

    public void updateStudent(int rollNo, String newName, float newMarks) {
        Student temp = head;
        while (temp != null && temp.rollNo != rollNo)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Student not found");
            return;
        }

        temp.name = newName;
        temp.marks = newMarks;
        System.out.println("Student updated successfully");
    }

    public void searchStudent(int rollNo) {
        Student temp = head;
        while (temp != null && temp.rollNo != rollNo)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Student not found");
            return;
        }

        System.out.println("Roll No: " + temp.rollNo + " | Name: " + temp.name + " | Marks: " + temp.marks);
    }

    public void sortStudents(boolean byMarks, boolean ascending) {
        if (head == null) return;

        for (Student i = head; i.next != null; i = i.next) {
            for (Student j = i.next; j != null; j = j.next) {
                boolean condition;
                if (byMarks)
                    condition = ascending ? (i.marks > j.marks) : (i.marks < j.marks);
                else
                    condition = ascending ? (i.rollNo > j.rollNo) : (i.rollNo < j.rollNo);

                if (condition) {
                    int tempRoll = i.rollNo; i.rollNo = j.rollNo; j.rollNo = tempRoll;
                    String tempName = i.name; i.name = j.name; j.name = tempName;
                    float tempMarks = i.marks; i.marks = j.marks; j.marks = tempMarks;
                }
            }
        }
        System.out.println("Records sorted successfully");
    }

    public void displayStudents() {
        if (head == null) {
            System.out.println("No records found");
            return;
        }

        System.out.println("\nStudent Records");
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + " | Name: " + temp.name + " | Marks: " + temp.marks);
            temp = temp.next;
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();

        int choice, rollNo;
        String name;
        float marks;

        do {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort by Roll No Asc");
            System.out.println("6. Sort by Roll No Desc");
            System.out.println("7. Sort by Marks Asc");
            System.out.println("8. Sort by Marks Desc");
            System.out.println("9. Display Students");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    rollNo = sc.nextInt();
                    System.out.print("Enter Name: ");
                    name = sc.next();
                    System.out.print("Enter Marks: ");
                    marks = sc.nextFloat();
                    list.addStudent(rollNo, name, marks);
                    break;

                case 2:
                    System.out.print("Enter Roll No to delete: ");
                    rollNo = sc.nextInt();
                    list.deleteStudent(rollNo);
                    break;

                case 3:
                    System.out.print("Enter Roll No to update: ");
                    rollNo = sc.nextInt();
                    System.out.print("Enter New Name: ");
                    name = sc.next();
                    System.out.print("Enter New Marks: ");
                    marks = sc.nextFloat();
                    list.updateStudent(rollNo, name, marks);
                    break;

                case 4:
                    System.out.print("Enter Roll No to search: ");
                    rollNo = sc.nextInt();
                    list.searchStudent(rollNo);
                    break;

                case 5: list.sortStudents(false, true); break;
                case 6: list.sortStudents(false, false); break;
                case 7: list.sortStudents(true, true); break;
                case 8: list.sortStudents(true, false); break;
                case 9: list.displayStudents(); break;

                case 0: System.out.println("Exiting"); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 0);

        sc.close();
    }
}
