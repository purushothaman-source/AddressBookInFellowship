package com.uccases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AddressBookOperations {
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
        int option = userinput.nextInt();
        if (option == 1) {
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
        } else {
            System.out.println("Enter State");
            String state = userinput.next();
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

    public static void viewByCityorState(Scanner userinput, ArrayList<Contacts> book) {
        System.out.println("how do you like to view 1.city 2.state ?");
        int option = userinput.nextInt();
        if (option == 1) {
            System.out.println("Enter city");
            String city = userinput.next();
            boolean flag = false;
            for (Contacts Books : book) {
                if (Books.city.equalsIgnoreCase(city)) {
                    System.out.println(Books);
                    flag = true;
                }
            }
            if (flag == false)
                System.out.println("No records found");
        } else {
            System.out.println("Enter State");
            String state = userinput.next();
            boolean flag = false;
            for (Contacts Books : book) {
                if (Books.state.equalsIgnoreCase(state)) {
                    System.out.println(Books);
                    flag = true;
                }
            }
            if (flag == false)
                System.out.println("No records found");
        }
    }

    public static void countByCityorState(Scanner userinput, ArrayList<Contacts> book) {
        System.out.println("how do you like to count 1.city 2.state ?");
        int option = userinput.nextInt();
        int count = 0;

        if (option == 1) {
            System.out.println("Enter city");
            String city = userinput.next();
            boolean flag = false;
            for (Contacts Books : book) {
                if (Books.city.equalsIgnoreCase(city)) {
                    count++;
                    flag = true;
                }
            }
            System.out.println(count + " entries in this city");
            if (flag == false)
                System.out.println("No records found");
        } else {
            System.out.println("Enter State");
            String state = userinput.next();
            boolean flag = false;
            for (Contacts Books : book) {
                if (Books.state.equalsIgnoreCase(state)) {
                    count++;
                    flag = true;
                }
            }
            System.out.println(count + " entries in this state");

            if (flag == false)
                System.out.println("No records found");

        }
    }


}



