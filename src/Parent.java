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

    public static Parent createParent(Scanner input, FileHandler fileHandler){
        System.out.println("Indtast fornavn: ");
        String firstName = input.next();
        System.out.println("Indtast efternavn: ");
        String lastName = input.next();
        System.out.println("Hvilket barn skal tilknyttes: ");
        System.out.println(fileHandler.readChildFromFile());
        int childID = input.nextInt();

        System.out.println("Indtast telefonnummer: ");
        int phoneNumber = input.nextInt();

//        Parent newParent = new Parent(firstName, lastName, momordad, phoneNumber);
        Parent newParent = new Parent(firstName, lastName, childID, phoneNumber);
        return newParent;
    }



    // GETTERS AND SETTERS //
    public int getID() {
        return ID;
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

    public void changeParentFirstName(String newParentFirstName) {
        this.firstName = newParentFirstName;
    }

    public void changeNextID(int number){

        nextID = number;
    }

    public int getChildId() {
        return childID;
    }
}
