import java.util.*;

class Room{

    int roomNo;
    String type;
    boolean booked;

    Room(int roomNo,String type){
        this.roomNo=roomNo;
        this.type=type;
        booked=false;
    }

}

public class HotelReservation {

    static ArrayList<Room> rooms=new ArrayList<>();

    static Scanner sc=new Scanner(System.in);

    static void addRooms(){

        rooms.add(new Room(101,"Standard"));
        rooms.add(new Room(102,"Standard"));
        rooms.add(new Room(201,"Deluxe"));
        rooms.add(new Room(202,"Deluxe"));
        rooms.add(new Room(301,"Suite"));
    }

    static void showRooms(){

        System.out.println("\nAvailable Rooms");

        for(Room r:rooms){

            if(!r.booked)

                System.out.println(r.roomNo+" - "+r.type);

        }

    }

    static void bookRoom(){

        showRooms();

        System.out.print("Enter Room Number: ");

        int no=sc.nextInt();

        for(Room r:rooms){

            if(r.roomNo==no && !r.booked){

                r.booked=true;

                System.out.println("Room Booked Successfully.");

                payment();

                return;

            }

        }

        System.out.println("Room Not Available.");

    }

    static void cancelRoom(){

        System.out.print("Enter Room Number: ");

        int no=sc.nextInt();

        for(Room r:rooms){

            if(r.roomNo==no && r.booked){

                r.booked=false;

                System.out.println("Booking Cancelled.");

                return;

            }

        }

        System.out.println("Booking Not Found.");

    }

    static void payment(){

        System.out.println("\nPayment Simulation");

        System.out.println("1. UPI");

        System.out.println("2. Card");

        System.out.print("Choose Payment: ");

        int c=sc.nextInt();

        System.out.println("Payment Successful.");

    }

    static void viewBookings(){

        System.out.println("\nBooked Rooms");

        for(Room r:rooms){

            if(r.booked)

                System.out.println(r.roomNo+" - "+r.type);

        }

    }

    public static void main(String args[]){

        addRooms();

        while(true){

            System.out.println("\n===== HOTEL MENU =====");

            System.out.println("1.Search Rooms");

            System.out.println("2.Book Room");

            System.out.println("3.Cancel Booking");

            System.out.println("4.View Bookings");

            System.out.println("5.Exit");

            System.out.print("Enter Choice: ");

            int ch=sc.nextInt();

            switch(ch){

                case 1:
                    showRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    cancelRoom();
                    break;

                case 4:
                    viewBookings();
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");

            }

        }

    }

}