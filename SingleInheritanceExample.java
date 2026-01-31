package BASICS.JAVA_PROJECTS;
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {
    int rollNo;
    Student(String name, int age, int rollNo) {
        super(name, age);
        this.rollNo = rollNo;
    }
    void displayStudent() {
        System.out.println("Roll Number: " + rollNo);
    }
}

class Teacher extends Person {
    String subject;
    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    void displayTeacher() {
        System.out.println("Subject: " + subject);
    }
}

class Staff extends Person {
    String department;
    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    void displayStaff() {
        System.out.println("Department: " + department);
    }
}

class Athlete extends Person {
    String sport;
    Athlete(String name, int age, String sport) {
        super(name, age);
        this.sport = sport;
    }
    void displayAthlete() {
        System.out.println("Sport: " + sport);
    }
}

public class SingleInheritanceExample {
    public static void main(String[] args) {
        Student st = new Student("Shreyash", 18, 121);
        st.displayDetails();
        st.displayStudent();

        Teacher t = new Teacher("Shubham", 35, "Chemistry");
        t.displayDetails();
        t.displayTeacher();

        Staff sf = new Staff("Meera", 40, "Administration");
        sf.displayDetails();
        sf.displayStaff();

        Athlete a = new Athlete("Raj", 22, "Football");
        a.displayDetails();
        a.displayAthlete();
    }
}
