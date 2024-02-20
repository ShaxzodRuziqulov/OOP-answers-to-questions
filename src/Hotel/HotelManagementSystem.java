package Hotel;

import java.util.ArrayList;
import java.util.Scanner;

class Guest {
    private String name;
    private String email;
    private int age;

    public Guest(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}

class Room {
    private int number;
    private int capacity;
    private ArrayList<Guest> guests;

    public Room(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public void addGuest(Guest guest) {
        if (guests.size() < capacity) {
            guests.add(guest);
            System.out.println("Guest added to room " + number + ": " + guest.getName());
        } else {
            System.out.println("Cannot add guest. Room is full.");
        }
    }

    public void removeGuest(Guest guest) {
        if (guests.remove(guest)) {
            System.out.println("Guest removed from room " + number + ": " + guest.getName());
        } else {
            System.out.println("Guest not found in room " + number);
        }
    }
}

class Hotel {
    private ArrayList<Room> rooms;

    public Hotel() {
        this.rooms = new ArrayList<>();
    }
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("Room added: " + room.getNumber());
    }

    public void listRooms() {
        System.out.println("Hotel Rooms:");
        for (Room room : rooms) {
            System.out.println("Room Number: " + room.getNumber() + ", Capacity: " + room.getCapacity());
        }
    }
}

public class HotelManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("\nActions:\n1. Add Room\n2. List Rooms\n3. Add Guest to Room\n4. Remove Guest from Room\n0. Exit");
            System.out.print("Choose (0-4): ");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter room capacity: ");
                    int capacity = scanner.nextInt();
                    hotel.addRoom(new Room(roomNumber, capacity));
                    break;
                case 2:
                    hotel.listRooms();
                    break;
                case 3:
                    System.out.print("Enter room number to add guest: ");
                    int roomNumAdd = scanner.nextInt();
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.next();
                    System.out.print("Enter guest email: ");
                    String guestEmail = scanner.next();
                    System.out.print("Enter guest age: ");
                    int guestAge = scanner.nextInt();
                    Room roomToAddGuest = findRoomByNumber(hotel, roomNumAdd);
                    if (roomToAddGuest != null) {
                        roomToAddGuest.addGuest(new Guest(guestName, guestEmail, guestAge));
                    } else {
                        System.out.println("Room not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter room number to remove guest: ");
                    int roomNumRemove = scanner.nextInt();
                    Room roomToRemoveGuest = findRoomByNumber(hotel, roomNumRemove);
                    if (roomToRemoveGuest != null) {
                        System.out.print("Enter guest name to remove: ");
                        String guestNameToRemove = scanner.next();
                        ArrayList<Guest> guestsInRoom = roomToRemoveGuest.getGuests();
                        boolean guestFound = false;
                        for (Guest guest : guestsInRoom) {
                            if (guest.getName().equals(guestNameToRemove)) {
                                roomToRemoveGuest.removeGuest(guest);
                                guestFound = true;
                                break;
                            }
                        }
                        if (!guestFound) {
                            System.out.println("Guest not found in room.");
                        }
                    } else {
                        System.out.println("Room not found.");
                    }
                    break;
                case 0:
                    System.out.println("Program exited.");
                    System.exit(0);
                default:
                    System.out.println("Invalid action chosen. Please try again.");
            }
        }
    }

    private static Room findRoomByNumber(Hotel hotel, int number) {
        for (Room room : hotel.getRooms()) {
            if (room.getNumber() == number) {
                return room;
            }
        }
        return null;
    }

}
