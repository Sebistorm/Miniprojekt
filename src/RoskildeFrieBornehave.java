import java.util.*;


public class RoskildeFrieBornehave {

    public static void main (String[] args ) {
        Scanner input = new Scanner(System.in);
        FileHandler filehandler = new FileHandler();
       // List<Child> childList = new LinkedList<>();
       // childList = filehandler.readChildFromFile();
        List<Parent> parentList = new LinkedList<>();
        parentList = filehandler.readParentFromFile();
        //System.out.println(childList);
        System.out.println(parentList);
/*
        childList.add(createChild(input));

        filehandler.writeChildToFile(childList);
*/
        //parentList.add(createParent(input));
       // filehandler.writeParentToFile(parentList);


    }



    private static Child createChild(Scanner input) {
        System.out.println("Enter first name: ");
        String firstName = input.next();
        System.out.println("Enter last name: ");
        String lastName = input.next();
        System.out.println("Enter Cpr nr. format: DDMMYYYY: ");
        int cprNr = input.nextInt();
        System.out.println("Start date: ");
        int startDate = input.nextInt();
        System.out.println(" Stue: Yellow, red, green");
        String room = input.next();
        System.out.println("Parent id: ");
        int parentID = input.nextInt();
        System.out.println("Current date: ");
        int date = input.nextInt();
        System.out.println("Add child to waitlist? y/n");
        String waitListAnswer = input.next();
        boolean waitList = false;
        if(waitListAnswer.equalsIgnoreCase("y")){
            waitList = true;
        }
        Child newChild = new Child(firstName, lastName, cprNr, startDate, room, parentID, date, waitList);
        return newChild;

    }

    private static Parent createParent(Scanner input){
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

}
