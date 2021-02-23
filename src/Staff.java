import java.util.Scanner;

public class Staff {
    int ID;
    static int nextID = 1;
    String firstName;
    String lastName;
    int phoneNumber;

    public Staff(String name) {
        this.firstName = name;
    }

    public Staff(int ID, String firstName, String lastName, int phoneNumber) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;

    }

    public Staff() {
        ID = nextID;
    }

    @Override
    public String toString() {
        return "Medarbejder nr. " + nextID + "\n" +
                "First name = '" + firstName + "\n" +
                "Last name = " + lastName + "\n" +
                "Phone number = " + phoneNumber + "\n";
    }
    public String getName() {
        return firstName;
    }

    public static Staff createStaff(Scanner input){

        System.out.println("navn");
        String name = input.next();

        Staff newStaff = new Staff(name);
        return newStaff;
    }
}