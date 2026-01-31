package BASICS.JAVA_PROJECTS;

import java.util.Scanner;

class Product {
    int productId;
    String productName;
    double price;
    int quantity;

    
    public Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    
    public double calculateTotalCost() {
        return price * quantity;
    }

    
    public void displayProduct() {
        System.out.println(productId + "\t" + productName + "\t" + price + "\t" + quantity + "\t" + calculateTotalCost());
    }
}

public class ProductBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for product " + (i + 1));
            System.out.print("Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Product Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int qty = sc.nextInt();

            products[i] = new Product(id, name, price, qty);
        }

       
        System.out.println("\n----- WELCOME TO OUR MALL -----"); 
        System.out.println("\n----- Final Bill -----");
        System.out.println("ID\tName\tPrice\tQty\tTotal");
        double finalBill = 0;
        for (Product p : products) {
            p.displayProduct();
            finalBill += p.calculateTotalCost();
        }
        System.out.println("---------------------------");
        System.out.println("Final Bill Amount: Rs. " + finalBill);

        
    }
}
