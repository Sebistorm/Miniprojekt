import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// HAR VI BRUG FOR AT SKELNE MELLEM MOR OG FAR?

public class Parent {

    private int ID;
    static int nextID = 1;

    private String firstName;
    private String lastName;
    private int phoneNumber;

//    public Parent(String firstName, String lastName, int phoneNumber) {
    public Parent(String firstName, String lastName, int phoneNumber) {
        ID = nextID;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public static Parent createParent(Scanner input){
        System.out.println("Indtast fornavn: ");
        String firstName = input.next();
        System.out.println("Indtast efternavn: ");
        String lastName = input.next();
//        System.out.println("Is parent a mother? m/d");
//        String momordad = input.next();
        System.out.println("Indtast telefonnummer: ");
        int phoneNumber = input.nextInt();

//        Parent newParent = new Parent(firstName, lastName, momordad, phoneNumber);
        Parent newParent = new Parent(firstName, lastName, phoneNumber);
        return newParent;
    }

    public static void changeParentFirstName(List<Parent> list, Scanner input) {
        // print relevante oplysninger til bruger
        System.out.println("FORÆLDRELISTE");

        for (int i = 0; i < list.size(); i++) {
            System.out.print("ID " + list.get(i).getID() + ": ");
            System.out.print(" " + list.get(i).getFirstName()+" ");
            System.out.println(list.get(i).getLastName());
        }
        System.out.println("Skriv id'et på forælderen, du vil skifte fornavn på og tast ENTER.");
        // scanner til at tage imod indtastning af id på parent
        int index = input.nextInt();
        System.out.println(index);
        // loop listen igennem
        for (int i = 0; i < list.size(); i++) {
            // hvis ID'et, som brugeren indtaster er lig med en af forældrenes id'ere så gør dette:
            if(index == list.get(i).getID()) {
                //System.out.println("Hvad er forælderens nye fornavn?");
                System.out.println("Hvad skal " + list.get(i).getFirstName()+" hedde til fornavn?");
                String newName = input.next();
                list.get(i).setFirstName(newName);
                System.out.println("Navnet er nu ændret til "+list.get(i).getFirstName() +".");
                //System.out.println(list.get(i));
                break;
            }
        }
    }

    public static void changeParentLastName(List<Parent> list, Scanner input) {
        // PRINT OVERSIGT
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Forælders ID " + list.get(i).getID());
            System.out.println("Forælders fornavn " + list.get(i).getFirstName());
            System.out.println("Forælders efternavn " + list.get(i).getLastName());
        }
        System.out.println("Skriv id'et på forælderen, som du vil ændre navn på og tast Enter: ");
        // scanner til at tage imod indtastning af id på parent
        int index = input.nextInt();
        System.out.println(index);
        // loop listen igennem
        for (int i = 0; i < list.size(); i++) {
            // hvis ID'et, som brugeren indtaster er lig med en af forældrenes id så gør dette:
            if (index == list.get(i).getID()) {
                System.out.println("Indtast forælderens nye efternavn: ");
                String newName = input.next();
                list.get(i).setLastName(newName);
                System.out.println("Navnet er nu ændret.");
                System.out.println(list.get(i));
                break;
            }
        }
    }

    public static void changeParentPhoneNumber(List<Parent> list, Scanner input) {
        // PRINT OVERSIGT
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Forælders ID " + list.get(i).getID());
            System.out.println("Forælders navn " + list.get(i).getLastName());
            System.out.println("Telefonnummer " + list.get(i).getPhoneNumber());
        }
        System.out.println("Skriv id'et på forælderen, som du vil ændre navn på og tast Enter: ");
        // scanner til at tage imod indtastning af id på parent
        int index = input.nextInt();
        System.out.println(index);
        // loop listen igennem
        for (int i = 0; i < list.size(); i++) {
            // hvis ID'et, som brugeren indtaster er lig med en af forældrenes id så gør dette:
            if (index == list.get(i).getID()) {
                System.out.println("Indtast forælderens nye telefonnummer: ");
                int newPhone = input.nextInt();
                list.get(i).setPhoneNumber(newPhone);
                System.out.println("Telefonnummeret er nu ændret.");
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
}
