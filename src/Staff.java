import java.util.Scanner;

public class Staff {
    int ID;
    String firstName;
    String lastName;
    int phoneNumber;

    public Staff(int ID, String firstName, String lastName, int phoneNumber) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    /*
    public Staff() {
        ID = nextID;
    }

 */

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' + ", lastName=" + lastName + "\n" + "Phone nr.: " +
                '}';
    }


    }

    /*
    public static Staff createStaff(Scanner input){

        System.out.println("navn");
        String name = input.next();

        Staff newStaff = new Staff(name);
        return newStaff;
    }

     */