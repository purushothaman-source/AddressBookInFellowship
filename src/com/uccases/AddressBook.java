package com.uccases;

import java.util.ArrayList;
import java.util.Scanner;

class Contacts {
    String firstName, lastName, address, city, state;
    long zip, phoneNumber;

    public Contacts(String firstName, String lastName, String address, String city, String state, long zip,
                    long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Contacts{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

public class AddressBook {
    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook");
        ArrayList<Contacts> book = new ArrayList<>();
        book.add( new Contacts("purushoth", "kabaddi"," address","chennai", "tamilnadu", 607003, 9488806205l));
        book.add( new Contacts("babu", "Sail"," address","mumbai", "maharastra", 607007, 9488806205l));
        book.add( new Contacts("appu", "Jana"," address","bangalore", "karnataka", 607403, 9488806205l));
        book.add( new Contacts("seetha", "lakshmi"," address","pune", "maharastra", 607083, 9488806205l));
        book.add( new Contacts("siva", "nantham"," address","kolkata", "west bengal", 607903, 9488806205l));
        Scanner input = new Scanner(System.in);
        String check = "y";
        while (!check.equalsIgnoreCase("n")) {
            System.out.println("Enter the Operation you want to perform");
            System.out.println("1.Add \n 2.Edit \n 3.Delete \n 4.Search");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    add(book);
                    break;
                case 2:
                    edit(book);
                    break;
                case 3:
                    delete(book);
                    break;
                case 4:
                    search(input, book);
                    break;
            }
            System.out.println("Do you want to perform any other option ?press(y/n)");
            check = input.next();
        }
        System.out.println(book);
    }

    public static void add(ArrayList<Contacts> book) {
        String check = "y";
        while (!check.equalsIgnoreCase("n")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter FirstName");
            String firstName = input.next();
            for (Contacts Books : book) {
                if (firstName.equalsIgnoreCase(Books.firstName)) {
                    System.out.println("Duplicate Entry");
                    return;
                }
            }
            System.out.println("Enter lastname");
            String lastName = input.next();
            System.out.println("Enter address");
            String address = input.next();
            System.out.println("enter city");
            String city = input.next();
            System.out.println("Enter state");
            String state = input.next();
            System.out.println("Enter zip");
            long zip = input.nextLong();
            System.out.println("Enter phone number");
            long phoneNumber = input.nextLong();
            book.add(new Contacts(firstName, lastName, address, city, state, zip, phoneNumber));
            System.out.println("Do you want to add more?(y/n)");
            Scanner scanner = new Scanner(System.in);
            check = scanner.next();
        }
    }

    public static void edit(ArrayList<Contacts> book) {
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        System.out.println("ENTER THE FIRSTNAME WHICH YOU WANT TO EDIT");
        System.out.println("enter firstname");
        String firstName = input.next();
        for (Contacts books : book) {
            if (books.firstName.equalsIgnoreCase(firstName)) {
                flag = true;
                book.remove(books);
                break;
            }
        }
        if (flag == true) {
            System.out.println("enter lastname");
            String lastName = input.next();
            System.out.println("enter address");
            String address = input.next();
            System.out.println("enter city");
            String city = input.next();
            System.out.println("enter state");
            String state = input.next();
            System.out.println("enter zip");
            long zip = input.nextLong();
            System.out.println("enter phone number");
            long phoneNumber = input.nextLong();
            book.add(new Contacts(firstName, lastName, address, city, state, zip, phoneNumber));
            System.out.println("******EDITED SUCCESSFULLY*******");
        } else {
            System.out.println("No records found");
        }
    }

    public static void delete(ArrayList<Contacts> book) {
        System.out.println("Enter the firstname to delete");
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        String firstName = input.next();
        for (Contacts Books : book) {
            if (Books.firstName.equalsIgnoreCase(firstName)) {
                book.remove(Books);
                System.out.println("DELETED SUCCESSFULLY");
                flag = true;
                return;
            }

        }
        if (flag == false)
            System.out.println("NO RECORDS FOUND TO DELETE");
    }

    public static void search(Scanner userinput, ArrayList<Contacts> book) {
        System.out.println("how do you like to search 1.city 2.state ?");
        int option= userinput.nextInt();
        if(option==1) {
            System.out.println("Enter city");
            String city = userinput.next();
            System.out.println("Enter the FirstName you want to see");
            String firstname = userinput.next();
            boolean flag = false;
            for (Contacts Books : book) {
                if (Books.firstName.equalsIgnoreCase(firstname) && Books.city.equalsIgnoreCase(city)) {
                    System.out.println(Books);
                    flag = true;
                }
            }
            if (flag == false)
                System.out.println("No records found");
        }
        else {
            System.out.println("Enter State");
            String state  = userinput.next();
            System.out.println("Enter the FirstName you want to see");
            String firstname = userinput.next();
            boolean flag = false;
            for (Contacts Books : book) {
                if (Books.firstName.equalsIgnoreCase(firstname) && Books.state.equalsIgnoreCase(state)) {
                    System.out.println(Books);
                    flag = true;
                }
            }
            if (flag == false)
                System.out.println("No records found");
        }
    }
}