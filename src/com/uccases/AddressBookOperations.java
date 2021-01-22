package com.uccases;

import java.util.*;
import java.util.stream.Collectors;

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
            book.stream().filter(n -> n.firstName.equalsIgnoreCase(firstname)&& n.city.equalsIgnoreCase(city))
                    .forEach(System.out::println);
        } else {
            System.out.println("Enter State");
            String state = userinput.next();
            System.out.println("Enter the FirstName you want to see");
            String firstname = userinput.next();
            book.stream().filter(n -> n.firstName.equalsIgnoreCase(firstname)&& n.city.equalsIgnoreCase(state))
                    .forEach(System.out::println);

        }
    }

    public static void viewByCityorState(Scanner userinput, ArrayList<Contacts> book) {
        System.out.println("how do you like to view 1.city 2.state ?");
        int option = userinput.nextInt();
        if (option == 1) {
            System.out.println("Enter city");
            String viewCity = userinput.next();
            book.stream().filter(n -> n.city.equalsIgnoreCase(viewCity)).forEach(System.out::println);
        } else {
            System.out.println("Enter State");
            String viewState = userinput.next();
            book.stream().filter(n -> n.state.equalsIgnoreCase(viewState)).forEach(System.out::println);
        }
    }

    public static void countByCityorState(Scanner userinput, ArrayList<Contacts> book) {
        System.out.println("how do you like to count 1.city 2.state ?");
        int option = userinput.nextInt();
        if (option == 1) {
            System.out.println("Enter city");
            String citySearch = userinput.next();
            long count = book.stream().filter(n -> n.city.equalsIgnoreCase(citySearch))
                    .count();
            System.out.println(count);

        } else {
            System.out.println("Enter State");
            String stateSearch = userinput.next();
            long count = book.stream().filter(n -> n.state.equalsIgnoreCase(stateSearch))
                    .count();
            System.out.println(count);
        }
    }

    public static void sortByFirstName(ArrayList<Contacts> book) {
        List<Contacts> sortedBook = book.stream()
                .sorted((p1, p2) -> p1.firstName.compareTo(p2.firstName))
                .collect(Collectors.toList());
        sortedBook.forEach(System.out::println);
    }

    public static void sortByCity(ArrayList<Contacts> book) {
        List<Contacts> sortedBook = book.stream()
                .sorted((p1, p2) -> p1.city.compareTo(p2.city))
                .collect(Collectors.toList());
        sortedBook.forEach(System.out::println);
    }

    public static void sortByState(ArrayList<Contacts> book) {
        List<Contacts> sortedBook = book.stream()
                .sorted((p1, p2) -> p1.state.compareTo(p2.state))
                .collect(Collectors.toList());
        sortedBook.forEach(System.out::println);
    }

    public static void sortByzip(ArrayList<Contacts> book) {
        List<Contacts> sortedBook = book.stream()
                .sorted(Comparator.comparingLong(Contacts::getZip))
                .collect(Collectors.toList());
        sortedBook.forEach(System.out::println);
    }


}



