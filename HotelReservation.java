import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Room {
    private int roomNumber;
    private String category;
    private boolean isAvailable;
    private double price;
    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public String getCategory() {
        return category;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void bookRoom() {
        this.isAvailable = false;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return " Room Number: " + roomNumber + "\n Category: " + category + "\n Price: Rs." + price;
    }
}
class Reservation {
    private Room room;
    private String customerName;
    private String paymentStatus;
    public Reservation(Room room, String customerName) {
        this.room = room;
        this.customerName = customerName;
        this.paymentStatus = "Pending";
    }
    public void processPayment() {
        this.paymentStatus = "Paid";
        room.bookRoom();
    }
    public String getDetails() {
        return " Customer Name: " + customerName + "\n " + room.toString() + "\n Payment Status: " + paymentStatus;
    }
}

public class HotelReservation {
    private List<Room> rooms;
    private List<Reservation> reservations;
    public HotelReservation() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }
    private void initializeRooms() {
        rooms.add(new Room(101, "Sigle", 100));
        rooms.add(new Room(102, "Double", 150));
        rooms.add(new Room(201, "Suite", 250));
        rooms.add(new Room(202, "Deluxe", 300));
    }
    public void searchAvailableRooms() {
        System.out.println("Available Rooms :");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }
    public void makeReservation(String customerName, int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                Reservation reservation = new Reservation(room, customerName);
                reservations.add(reservation);
                reservation.processPayment();
                System.out.println("Reservation successful for " + customerName + " in Room " + roomNumber);
                return;
            }
        }
        System.out.println("Room not available or does not exist.");
    }
    public void viewBookingDetails() {
        System.out.println("Booking Details:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation.getDetails());
        }
    }
    public static void main(String[] args) {
        HotelReservation system = new HotelReservation();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===================================");
            System.out.println("    Hotel Reservation System");
            System.out.println("===================================");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit \n");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    system.searchAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter room number to reserve: ");
                    int roomNumber = scanner.nextInt();
                    system.makeReservation(name, roomNumber);
                    break;
                case 3:
                    system.viewBookingDetails();
                    break;
                case 4:
                System.out.println("===================================");
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }
}