import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// HAR VI BRUG FOR AT SKELNE MELLEM MOR OG FAR?

public class Parent {

    private int ID;
    static int nextID = 1;

    private String firstName;
    private String lastName;
    private int childID;
    private int phoneNumber;

//    public Parent(String firstName, String lastName, int phoneNumber) {
    public Parent(String firstName, String lastName, int childID, int phoneNumber) {
        ID = nextID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.childID = childID;
        this.phoneNumber = phoneNumber;
        nextID++;
    }

    public Parent() {
        ID = nextID;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +

                ", phoneNumber=" + phoneNumber + "\n";
    }


    // GETTERS AND SETTERS //
    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void changeParentFirstName(String newParentFirstName) {
        this.firstName = newParentFirstName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getMomordad() {
//        return momordad;
//    }
//
//    public void setMomordad(String momordad) {
//        this.momordad = momordad;
//    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public void changeNextID(int number){

        nextID = number;
    }

    public int getChildId() {
        return childID;
    }
}

