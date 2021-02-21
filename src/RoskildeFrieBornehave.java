import java.util.*;


public class RoskildeFrieBornehave {

    public static void main (String[] args ) {
        Scanner input = new Scanner(System.in);
        FileHandler filehandler = new FileHandler();

        // CHILD //

//        CREATE CHILD LIST AND READ FROM FILE
//        List<Child> childList = new LinkedList<>();
//        childList = filehandler.readChildFromFile();

//        PRINT CHILD LIST
//        System.out.println(childList);
//
//        CREATE CHILD FROM USER INPUT
//        childList.add(createChild(input));
//        filehandler.writeChildToFile(childList);

        // EDIT CHILD
//        changeFirstName(childList,input);
//        filehandler.writeChildToFile(childList);
//        System.out.println("NY BØRNELISTE:\n " + childList);

       // DELETE CHILD
//        deleteChild(childList,input);
//        filehandler.writeChildToFile(childList);


//        CREATE PARENT LIST AND READ FROM FILE
//        List<Parent> parentList = new LinkedList<>();
//        parentList = filehandler.readParentFromFile();

       // PRINT PARENT LIST
//        System.out.println(parentList);

       // CREATE PARENT FROM USER INPUT
//        parentList.add(Parent.createParent(input));
//        filehandler.writeParentToFile(parentList);

       // EDIT PARENT //
//        Parent.changeParentFirstName(parentList,input);
//        filehandler.writeParentToFile(parentList);
//        System.out.println("NY LISTE:\n " + parentList);

//        DELETE PARENT
//        Parent.deleteParent(parentList,input);
//        filehandler.writeParentToFile(parentList);


        // STAFF //
        List<Staff> staffList = new ArrayList<>();
        staffList = filehandler.readStaffFromFile();

        staffList.add(Staff.createStaff(input));
        filehandler.writeStaffToFile(staffList);
        System.out.println("NY LISTE:\n " + staffList);


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

    private static void changeChildRoom(List<Child> list, Scanner input) {
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
                System.out.println("Hvilken stue skal barnet være på? Gul, Rød eller Grøn Stue");
                String newRoom = input.next();
                // kald metode fra child.java, som redigere fornavnet
                list.get(i).changeRoom(newRoom);
                System.out.println("opdateret info");
                System.out.println(list.get(i));
                break;
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

    private static void changeCPRnr(List<Child> list, Scanner input) {
        // print relevante oplysninger til bruger
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Barns ID " + list.get(i).getID());
            System.out.println("Barns navn " + list.get(i).getLastName());
        }
        System.out.println("Skriv id'et på barnet");
        // scanner til indtastning af id på child
        int index = input.nextInt();
        System.out.println(index);
        // loop listen igennem
        for (int i = 0; i < list.size(); i++) {
            // hvis ID'et, som brugeren indtaster er lig med en af børnenes id'ere så gør dette:
            if(index == list.get(i).getID()) {
                System.out.println("Skriv nyt CPR: ");
                int newCRP = input.nextInt();
                // kald metode fra child.java, som redigere efternavnet
                list.get(i).changeCPRnr(newCRP);
                System.out.println("opdateret info");
                System.out.println(list.get(i));
                break;
            }
        }
    }

    private static void changeLastName(List<Child> list, Scanner input) {
        // print relevante oplysninger til bruger
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Barns ID " + list.get(i).getID());
            System.out.println("Barns navn " + list.get(i).getLastName());
        }
        System.out.println("Skriv id'et på barnet");
        // scanner til indtastning af id på child
        int index = input.nextInt();
        System.out.println(index);
        // loop listen igennem
        for (int i = 0; i < list.size(); i++) {
            // hvis ID'et, som brugeren indtaster er lig med en af børnenes id'ere så gør dette:
            if(index == list.get(i).getID()) {
                System.out.println("Hvad er efternavnet?");
                String newName = input.next();
                // kald metode fra child.java, som redigere efternavnet
                list.get(i).changeLastName(newName);
                System.out.println("opdateret info");
                System.out.println(list.get(i));
                break;
            }
        }
    }

    private static void changeChildStartDate(List<Child> list, Scanner input) {
        // print relevante oplysninger til bruger
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Barns ID " + list.get(i).getID());
            System.out.println("Barns navn " + list.get(i).getLastName());
        }
        System.out.println("Skriv id'et på barnet");
        // scanner til indtastning af id på child
        int index = input.nextInt();
        System.out.println(index);
        // loop listen igennem
        for (int i = 0; i < list.size(); i++) {
            // hvis ID'et, som brugeren indtaster er lig med en af børnenes id'ere så gør dette:
            if(index == list.get(i).getID()) {
                System.out.println("Ny start dato: ");
                int newStartDate = input.nextInt();
                // kald metode fra child.java, som ændrer startdato
                list.get(i).changeStartDate(newStartDate);
                System.out.println("opdateret info");
                System.out.println(list.get(i));
                break;
            }
        }
    }

    private static void changeParentID(List<Child> list, Scanner input) {
        // print relevante oplysninger til bruger
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Barns ID " + list.get(i).getID());
            System.out.println("Barns navn " + list.get(i).getLastName());
        }
        System.out.println("Skriv id'et på barnet");
        // scanner til indtastning af id på child
        int index = input.nextInt();
        System.out.println(index);
        // loop listen igennem
        for (int i = 0; i < list.size(); i++) {
            // hvis ID'et, som brugeren indtaster er lig med en af børnenes id'ere så gør dette:
            if(index == list.get(i).getID()) {
                System.out.println("Ny start dato: ");
                int parentID = input.nextInt();
                // kald metode fra child.java, som ændrer parent ID
                list.get(i).changeParentID(parentID);
                System.out.println("opdateret info");
                System.out.println(list.get(i));
                break;
            }
        }
    }

    private static void changeDate(List<Child> list, Scanner input) {
        // print relevante oplysninger til bruger
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Barns ID " + list.get(i).getID());
            System.out.println("Barns navn " + list.get(i).getLastName());
        }
        System.out.println("Skriv id'et på barnet");
        // scanner til indtastning af id på child
        int index = input.nextInt();
        System.out.println(index);
        // loop listen igennem
        for (int i = 0; i < list.size(); i++) {
            // hvis ID'et, som brugeren indtaster er lig med en af børnenes id'ere så gør dette:
            if(index == list.get(i).getID()) {
                System.out.println("set date: ");
                int newDate = input.nextInt();
                // kald metode fra child.java, som ændrer dato
                list.get(i).changeDate(newDate);
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

//    public static void changeParentFirstName(List<Parent> list, Scanner input) {
//        // print relevante oplysninger til bruger
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("Forælders ID " + list.get(i).getID());
//            System.out.println("Forælders navn " + list.get(i).getFirstName());
//        }
//        System.out.println("Skriv id'et på forælderen");
//        // scanner til indtastning af id på parent
//        int index = input.nextInt();
//        System.out.println(index);
//        // loop listen igennem
//        for (int i = 0; i < list.size(); i++) {
//            // hvis ID'et, som brugeren indtaster er lig med en af forældrenes id'ere så gør dette:
//            if(index == list.get(i).getID()) {
//                System.out.println("Hvad skal forælderen hedde?");
//                String newParentFirstName = input.next();
//                // kald metode fra Parent.java, som redigerer fornavnet
//                list.get(i).changeParentFirstName(newParentFirstName);
//                System.out.println("opdateret info");
//                System.out.println(list.get(i));
//                break;
//            }
//        }
//    }


//    private static Parent createParent(Scanner input){
//        System.out.println("Enter first name: ");
//        String firstName = input.next();
//        System.out.println("Enter last name: ");
//        String lastName = input.next();
//        System.out.println("Is parent a mother? m/d");
//        String momordad = input.next();
//        System.out.println("Enter phone number: ");
//        int phoneNumber = input.nextInt();
//
//        Parent newParent = new Parent(firstName, lastName, momordad, phoneNumber);
//        return newParent;
//    }

}
