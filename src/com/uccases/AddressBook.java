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
        add(book);
        edit(book);
        System.out.println(book);
    }

    public static void add(ArrayList<Contacts> book) {
        Scanner input = new Scanner(System.in);
        String firstName = input.next();
        String lastName = input.next();
        String address = input.next();
        String city = input.next();
        String state = input.next();
        long zip = input.nextLong();
        long phoneNumber = input.nextLong();
        book.add(new Contacts(firstName, lastName, address, city, state, zip, phoneNumber));
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
}