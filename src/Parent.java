import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Parent {

    private int ID;
    static int nextID = 1;

    private String firstName;
    private String lastName;
    private String momordad;
    private int phoneNumber;

    public Parent(String firstName, String lastName, String isMother, int phoneNumber) {
        ID = nextID;
        nextID++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.momordad = momordad;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", momordad='" + momordad + '\'' +
                ", phoneNumber=" + phoneNumber + "\n";
    }

    public static Parent createParent(Scanner input){
        System.out.println("Enter first name: ");
        String firstName = input.next();
        System.out.println("Enter last name: ");
        String lastName = input.next();
        System.out.println("Is parent a mother? m/d");
        String momordad = input.next();
        System.out.println("Enter phone number: ");
        int phoneNumber = input.nextInt();

        Parent newParent = new Parent(firstName, lastName, momordad, phoneNumber);
        return newParent;
    }


    public static void changeParentFirstName(List<Parent> list, Scanner input) {
        // print relevante oplysninger til bruger
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Forælders ID " + list.get(i).getID());
            System.out.println("Forælders navn " + list.get(i).getFirstName());
        }
        System.out.println("Skriv id'et på forælderen");
        // scanner til indtastning af id på parent
        int index = input.nextInt();
        System.out.println(index);
        // loop listen igennem
        for (int i = 0; i < list.size(); i++) {
            // hvis ID'et, som brugeren indtaster er lig med en af forældrenes id'ere så gør dette:
            if(index == list.get(i).getID()) {
                System.out.println("Hvad skal forælderen hedde?");
                String newParentFirstName = input.next();
                // kald metode fra Parent.java, som redigerer fornavnet
                list.get(i).changeParentFirstName(newParentFirstName);
                System.out.println("opdateret info");
                System.out.println(list.get(i));
                break;
            }
        }
    }


    public static void deleteParent(List<Parent> list, Scanner input) {
        Iterator<Parent> it = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Forælders ID " + list.get(i).getID());
            System.out.println("Forælders navn " + list.get(i).getFirstName());
            System.out.println("");
        }
        System.out.println("Indtast id'et på parent som skal slettes");
        int chosenID = input.nextInt();

        while(it.hasNext()) {
            Parent index = it.next();
            if(index.getID() == chosenID) {
                it.remove();
            }
        }
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

    public String getMomordad() {
        return momordad;
    }

    public void setMomordad(String momordad) {
        this.momordad = momordad;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void changeParentFirstName(String newParentFirstName) {
        this.firstName = newParentFirstName;
    }
}
