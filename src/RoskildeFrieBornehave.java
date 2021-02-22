import java.util.*;

// Hvordan kæder vi børn og forældre sammen?

public class RoskildeFrieBornehave {

    public static List<Parent> parentList = new LinkedList<>();

    public static void main (String[] args ) {
        Scanner input = new Scanner(System.in);
        FileHandler filehandler = new FileHandler();

//      CREATE PARENT LIST AND READ FROM FILE
        List<Parent> parentList = new LinkedList<>();
        parentList = filehandler.readParentFromFile();

        login(input, filehandler);

//        CREATE CHILD LIST AND READ FROM FILE
//        List<Child> childList = new LinkedList<>();
//        childList = filehandler.readChildFromFile();

//        PRINT CHILD LIST
//        System.out.println(childList);
//
//        CREATE CHILD FROM USER INPUT
//        childList.add(createChild(input));
//        filehandler.writeChildToFile(childList);

//        EDIT CHILD
//        changeFirstName(childList,input);
//        filehandler.writeChildToFile(childList);
//        System.out.println("NY BØRNELISTE:\n " + childList);

//        DELETE CHILD
//        deleteChild(childList,input);
//        filehandler.writeChildToFile(childList);


       // PRINT PARENT LIST
//        System.out.println(parentList);

       // CREATE PARENT FROM USER INPUT
//        parentList.add(Parent.createParent(input));
//        filehandler.writeParentToFile(parentList);

       // CHANGE PARENT FIRSTNAME //
//        Parent.changeParentFirstName(parentList,input);
//        filehandler.writeParentToFile(parentList);

//        CHANGE PARENT LASTNAME //
//        Parent.changeParentLastName(parentList,input);
//        filehandler.writeParentToFile(parentList);

//        EDIT PARENT PHONE
//        Parent.changeParentPhoneNumber(parentList,input);
//        filehandler.writeParentToFile(parentList);

//        DELETE PARENT
//        Parent.deleteParent(parentList,input);
//        filehandler.writeParentToFile(parentList);

        // STAFF //
//        List<Staff> staffList = new ArrayList<>();
//        staffList = filehandler.readStaffFromFile();
//
        //CREATE STAFF
//        staffList.add(Staff.createStaff(input));
//        filehandler.writeStaffToFile(staffList);

    }

    public static void login(Scanner input, FileHandler filehandler){
        System.out.println("");
        System.out.println("-------------------------------------");
        System.out.println("             L O G I N ");
        System.out.println("-------------------------------------");

        System.out.println("Indtast kodeord og tryk ENTER: \n");

        int choice = input.nextInt();
        int password = 1234;

            if (choice != password) {
                login(input, filehandler);
            } else {
                menuManager(input, filehandler);
            }
    }

    private static void menuManager(Scanner input, FileHandler filehandler){
        System.out.println("V E L K O M M E N   T I L   R O S K I L D E  F R I E  B Ø R N E H A V E");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("");
        System.out.println("H O V E D M E N U");

        System.out.println("TAST 1 - FORÆLDER");

        System.out.println("TAST 0: Afslut programmet");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                subMenuParent(input, filehandler);
            case 0:
                System.out.println("Programmet er nu afsluttet.");
                System.exit(-1);
        }
    }

    private static void subMenuChild(Scanner input, FileHandler filehandler){
        int choice = input.nextInt();

        switch (choice) {
            case 1:


        }

    }

    private static void subMenuParent(Scanner input, FileHandler filehandler){
        System.out.println("F O R Æ L D E R   M E N U");
        System.out.println("TAST 1: Vis liste over forældre.");
        System.out.println("TAST 2: Opret en ny forælder.");
        System.out.println("TAST 3: Rediger oplysninger om en forælder.");
        System.out.println("TAST 4: Slet en forælder.");
        System.out.println("TAST 9: HOVEDMENU");
        System.out.println("TAST 0: Afslut programmet");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                parentList = filehandler.readParentFromFile();
                System.out.println(parentList);
                backToSubMenuParent(input, filehandler);
                break;
            case 2:
                parentList.add(Parent.createParent(input));
                filehandler.writeParentToFile(parentList);
                backToSubMenuParent(input, filehandler);
                break;
            case 3:
                subMenuEditParent(input, filehandler);
            case 4:
                Parent.deleteParent(parentList,input);
                filehandler.writeParentToFile(parentList);
                backToSubMenuParent(input, filehandler);
                break;
            case 9:
                menuManager(input, filehandler);
            case 0:
                System.out.println("Programmet er nu afsluttet.");
                System.exit(-1);

        }
    }
    private static void subMenuEditParent(Scanner input, FileHandler filehandler){
        System.out.println("R E D I G E R   F O R Æ L D E R");
        System.out.println("TAST 1: Skift fornavn på en forælder.");
        System.out.println("TAST 2: Skift efternavn på en forælder.");
        System.out.println("TAST 3: Skift telefonnummer på en forælder.");
        System.out.println("TAST 4: Tilbage til forældermenu");
        System.out.println("TAST 9: HOVEDMENU");
        System.out.println("TAST 0: Afslut programmet");

        int choice = input.nextInt();

        switch (choice){
            case 1:
                Parent.changeParentFirstName(parentList,input);
                filehandler.writeParentToFile(parentList);
                backToSubMenuParent(input, filehandler);
                break;
            case 2:
                Parent.changeParentLastName(parentList,input);
                filehandler.writeParentToFile(parentList);
                backToSubMenuParent(input, filehandler);
                break;
            case 3:
                Parent.changeParentPhoneNumber(parentList,input);
                filehandler.writeParentToFile(parentList);
                backToSubMenuParent(input, filehandler);
                break;
            case 4:
                subMenuParent(input, filehandler);

            case 9:
                menuManager(input, filehandler);
            case 0:
                System.out.println("Programmet er nu afsluttet.");
                System.exit(-1);
        }
    }

    private static void backToSubMenuParent(Scanner input, FileHandler filehandler) {
        System.out.println("TAST 4: Tilbage til forældermenu");
        System.out.println("TAST 9: HOVEDMENU");
        System.out.println("TAST 0: Afslut programmet");

        int choice = input.nextInt();

        switch (choice) {

            case 4:
                subMenuParent(input, filehandler);
            case 9:
                menuManager(input, filehandler);
            case 0:
                System.out.println("Programmet er nu afsluttet.");
                System.exit(-1);

        }
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

}
