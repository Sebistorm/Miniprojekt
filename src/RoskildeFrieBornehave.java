import java.util.*;


public class RoskildeFrieBornehave {

    public static void main (String[] args ) {
        Scanner input = new Scanner(System.in);
        FileHandler filehandler = new FileHandler();
        List<Child> childList = new LinkedList<>();
        childList = filehandler.readChildFromFile();
        //List<Parent> parentList = new LinkedList<>();
        //parentList = filehandler.readParentFromFile();
        System.out.println(childList);
        //System.out.println(parentList);

        childList.add(createChild(input));

        //filehandler.writeChildToFile(childList);

        //parentList.add(createParent(input));
       // filehandler.writeParentToFile(parentList);
        //changeFirstName(childList,input);

        //deleteChild(childList,input);
        filehandler.writeChildToFile(childList);

    }


    private static void deleteChild(List<Child> list, Scanner input) {
        Iterator<Child> it = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Barns ID " + list.get(i).getID());
            System.out.println("Barns navn " + list.get(i).getFirstName());
        }
        System.out.println("Indtast id'et på det child på som skal slettes");
        int chosenID = input.nextInt();

        while(it.hasNext()) {
            Child index = it.next();
            if(index.getID() == chosenID) {
                it.remove();
            }
        }
    }


    private static void changeFirstName(List<Child> list, Scanner input) {
        // print relevante oplysninger til bruger
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Barns ID " + list.get(i).getID());
            System.out.println("Barns navn " + list.get(i).getFirstName());
        }
        System.out.println("Skriv id'et på barnet");
        // scanner til indtastning af id på child
        int index = input.nextInt();
        System.out.println(index);
        // loop listen igennem
        for (int i = 0; i < list.size(); i++) {
            // hvis ID'et, som brugeren indtaster er lig med en af børnenes id'ere så gør dette:
            if(index == list.get(i).getID()) {
                System.out.println("Hvad skal barnet hedde?");
                String newName = input.next();
                // kald metode fra child.java, som redigere fornavnet
                list.get(i).changeFirstName(newName);
                System.out.println("opdateret info");
                System.out.println(list.get(i));
                break;
            }
        }
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
