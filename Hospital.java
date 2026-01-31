package BASICS.JAVA_PROJECTS;
import java.util.*;

class Patient {
    String name, disease;
    int age;

    // Constructor
    Patient(String n, int a, String d) {
        name = n;
        age = a;
        disease = d;
    }

    // Method to display patient details
    void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Disease: " + disease);
    }
}

public class Hospital {
    public static void main(String[] args) {
        // Create patients
        Patient p1 = new Patient("Raj", 30, "Fever");
        Patient p2 = new Patient("Amit", 21, "Cold");
        Patient p3 = new Patient("Siddharth", 25, "Asthma");

        // Store in array
        Patient patients[] = {p1, p2, p3};

        // Display all patients
        System.out.println("All Patient Records:");
        for (int i = 0; i < patients.length; i++) {
            patients[i].display();
        }

        // Search patient by name
        String searchName = "Sneha";  // You can change input here
        boolean found = false;

        for (int i = 0; i < patients.length; i++) {
            if (patients[i].name.equalsIgnoreCase(searchName)) {
                System.out.println("\nPatient Found!");
                patients[i].display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nPatient Not Found!");
        }
    }
}
