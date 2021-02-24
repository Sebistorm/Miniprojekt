import java.util.*;

// Hvordan kæder vi børn og forældre sammen?

public class RoskildeFrieBornehave {

    public static List<Parent> parentList = new LinkedList<>();
    public static List<Child> childList = new LinkedList<>();
    public static List<Staff> staffList = new LinkedList<>();

    public static boolean isLeader = false;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FileHandler filehandler = new FileHandler();

        staffList = filehandler.readStaffFromFile();

        childList = filehandler.readChildFromFile();
        parentList = filehandler.readParentFromFile();

        System.out.println(staffList);

        Staff newStaff1 = new Staff(1, "Bo", "Madsen", 12345678);
        Staff newStaff2 = new Staff(2, "Daniel", "Jensen", 44332211);
        ArrayList<Staff> list2 = new ArrayList<>();
        list2.add(newStaff1);
        list2.add(newStaff2);
        StaffWorkSchedule newWeek = new StaffWorkSchedule(8, list2, list2, list2, list2, list2);

        System.out.println(newWeek);

        //Sets nextID
        Child child = new Child();
        child.changeNextID(filehandler.readCounters().get(0));

        Parent parent = new Parent();
        parent.changeNextID(filehandler.readCounters().get(1));

        filehandler.writeParentToFile(parentList);


        saveCounters(filehandler);
        subMenuEditParent(input, filehandler);


//      CREATE PARENT LIST AND READ FROM FILE


        //login(input, filehandler);


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
        createStaff();
        deleteStaff();
        

    }

    private static void deleteStaff(List<Staff> list, Scanner input) {
        Iterator<Staff> it = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Medarbejder nr.: " + list.get(i).getID());
            System.out.println("Medarbejder navn: " + list.get(i).getFirstName());
        }
        System.out.println("Indtast id'et på den medarbejder der skal fjernes: ");
        int chosenID = input.nextInt();

        while (it.hasNext()) {
            Staff index = it.next();
            if (index.getID() == chosenID) {
                it.remove();
            }
        }
    }

    private static void createStaff(Scanner input) {
        System.out.println("Indtast ønsket medarbejder ID nr.: ");
        int id = input.nextInt();
        System.out.println("Enter first name: ");
        String firstName = input.next();
        System.out.println("Enter last name: ");
        String lastName = input.next();
        System.out.println("Indtast telefon nr.: ");
        int phonenr = input.nextInt();
        Child newChild = new Child(id, firstName, lastName, phonenr);
        return newChild;
    }


    public static void login(Scanner input, FileHandler filehandler) {
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

    private static void menuManager(Scanner input, FileHandler filehandler) {
        System.out.println("V E L K O M M E N   T I L   R O S K I L D E  F R I E  B Ø R N E H A V E");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("");
        System.out.println("H O V E D M E N U");

        System.out.println("TAST 1 - FORÆLDER");
        System.out.println("TAST 2 - BØRN");
        if (isLeader){
            System.out.println("TAST 3 - STAFF");
        }

        System.out.println("TAST 0: Afslut programmet");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                subMenuParent(input, filehandler);
            case 2:
                subMenuChild(input, filehandler);
            case 3:
                if(isLeader){
                    // staffmenu
                }
            case 0:
                System.out.println("Programmet er nu afsluttet.");
                System.exit(-1);
        }
    }

    private static void subMenuStaff(Scanner input, FileHandler filehandler){
        System.out.println("S T A F F   M E N U");
        System.out.println("TAST 1: Vis liste over staff.");
        System.out.println("TAST 2: Opret ny staff.");
        System.out.println("TAST 3: Rediger oplysninger om en medarbejder.");
        System.out.println("TAST 4: Slet et barn.");
        System.out.println("TAST 9: HOVEDMENU");
        System.out.println("TAST 0: Afslut programmet");

        int choice = input.nextInt();

        switch (choice){
            case 1:
                System.out.println(staffList);
                break;
            case 2:
                break;
            case 3:
                subMenuEditStaff(input, filehandler);
        }
    }

    private static void subMenuEditStaff(Scanner input, FileHandler filehandler){
        System.out.println("R E D I G E R   S T A F F");
        System.out.println("TAST 1: Skift fornavn på en medarbejder.");
        System.out.println("TAST 2: Skift efternavn på en medarbejder.");
        System.out.println("TAST 3: Skift CPR på en medarbejder.");
        System.out.println("TAST 4: Skift start dato på en medarbejder.");
        System.out.println("TAST 5: Skift rum på en medarbejder.");
        System.out.println("TAST 6: Skift indmeldnings dato på en medarbejder.");
        System.out.println("TAST 7: Skift venteliste status på en medarbejder.");

        System.out.println("TAST 9: Tilbage til børne menu");
        System.out.println("TAST 0: Afslut programmet");
    }

    private static void subMenuChild(Scanner input, FileHandler filehandler) {
        System.out.println("B Ø R N E   M E N U");
        System.out.println("TAST 1: Vis liste over børn.");
        System.out.println("TAST 2: Opret et ny barn.");
        System.out.println("TAST 3: Rediger oplysninger om et barn.");
        System.out.println("TAST 4: Slet et barn.");
        System.out.println("TAST 9: HOVEDMENU");
        System.out.println("TAST 0: Afslut programmet");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println(childList);
                break;
            case 2:
                childList.add(createChild(input));
                filehandler.writeChildToFile(childList);
                saveCounters(filehandler);
                subMenuChild(input, filehandler);
                break;
            case 3:
                subMenuEditChild(input, filehandler);
            case 4:
                deleteChild(childList, input);
                filehandler.writeChildToFile(childList);
                subMenuChild(input, filehandler);
            case 9:
                menuManager(input, filehandler);
                break;
            case 0:
                System.out.println("PRogrammet er nu afsluttet");
                System.exit(-1);
        }
    }

    private static void subMenuEditChild(Scanner input, FileHandler filehandler){
        System.out.println("R E D I G E R   B Ø R N");
        System.out.println("TAST 1: Skift fornavn på et barn.");
        System.out.println("TAST 2: Skift efternavn på et barn.");
        System.out.println("TAST 3: Skift CPR på et barn.");
        System.out.println("TAST 4: Skift start dato på et barn.");
        System.out.println("TAST 5: Skift rum på et barn.");
        System.out.println("TAST 6: Skift indmeldnings dato på et barn.");
        System.out.println("TAST 7: Skift venteliste status på et barn.");

        System.out.println("TAST 9: Tilbage til børne menu");
        System.out.println("TAST 0: Afslut programmet");

        int choice = input.nextInt();

        int chosenID;

        switch (choice) {
            case 1:
                System.out.println(childList);
                System.out.println("Vælg id på ønsket barn: ");
                chosenID = input.nextInt();
                for (int i = 0; i < childList.size(); i++){
                    if (childList.get(i).getID()==chosenID){
                        System.out.println("Indtast nyt navn for " + childList.get(i).getFirstName() + ": " );
                        childList.get(i).setFirstName(input.next());
                        break;
                    }
                }
            case 2:
                System.out.println(childList);
                System.out.println("Vælg id på ønsket barn: ");
                chosenID = input.nextInt();
                for (int i = 0; i < childList.size(); i++){
                    if (childList.get(i).getID() == chosenID) {
                        System.out.println("Indtast nyt efternavn for " + childList.get(i).getLastName() + ": ");
                        childList.get(i).setLastName(input.next());
                        break;
                    }
                }
                filehandler.writeChildToFile(childList);
                subMenuEditChild(input, filehandler);
                break;
            case 3:
                System.out.println(childList);
                System.out.println("Vælg id på ønsket barn: ");
                chosenID = input.nextInt();
                for (int i = 0; i < childList.size(); i++){
                    if(childList.get(i).getID() == chosenID){
                        System.out.println(childList.get(i).getFirstName() + " er valgt.  \n");
                        System.out.println("Indtast nyt CPR nummer: ");
                        childList.get(i).setCprNR(input.nextInt());
                        break;
                    }
                }
                filehandler.writeParentToFile(parentList);
                backToSubMenuParent(input, filehandler);
                break;
            case 4:
                System.out.println(childList);
                System.out.println("Vælg id på ønsket barn: ");
                chosenID = input.nextInt();
                for (int i = 0; i < childList.size(); i++){
                    if (childList.get(i).getID() == chosenID) {
                        System.out.println("Indtast nyt start dato for " + childList.get(i).getFirstName() + ": ");
                        childList.get(i).setStartDate(input.nextInt());
                        break;
                    }
                }
                filehandler.writeChildToFile(childList);
                subMenuEditChild(input, filehandler);
                break;
            case 5:
                System.out.println(childList);
                System.out.println("Vælg id på ønsket barn: ");
                chosenID = input.nextInt();
                for (int i = 0; i < childList.size(); i++){
                    if (childList.get(i).getID() == chosenID) {
                        System.out.println("Indtast andet rum for " + childList.get(i).getFirstName() + ": ");
                        childList.get(i).setRoom(input.next());
                        break;
                    }
                }
                filehandler.writeChildToFile(childList);
                subMenuEditChild(input, filehandler);
                break;
            case 6:
                System.out.println(childList);
                System.out.println("Vælg id på ønsket barn: ");
                chosenID = input.nextInt();
                for (int i = 0; i < childList.size(); i++){
                    if (childList.get(i).getID() == chosenID) {
                        System.out.println("Indtast ny indmeldnings dato for " + childList.get(i).getFirstName() + ": ");
                        childList.get(i).setStartDate(input.nextInt());
                        break;
                    }
                }
                filehandler.writeChildToFile(childList);
                subMenuEditChild(input, filehandler);
                break;
            case 7:
                System.out.println(childList);
                System.out.println("Vælg id på ønsket barn: ");
                chosenID = input.nextInt();
                for (int i = 0; i < childList.size(); i++){
                    if (childList.get(i).getID() == chosenID) {
                        System.out.println("Skift venteliste status for " + childList.get(i).getFirstName() + "(true/false): ");
                        childList.get(i).setWaitList(input.nextBoolean());
                        break;
                    }
                }
                filehandler.writeChildToFile(childList);
                subMenuEditChild(input, filehandler);
                break;
            case 9:
                menuManager(input, filehandler);
            case 0:
                System.out.println("Programmet er afsluttet");
                System.exit(-1);
        }
    }

    private static void subMenuParent(Scanner input, FileHandler filehandler) {
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
                System.out.println(parentList);
                backToSubMenuParent(input, filehandler);
                break;
            case 2:
                parentList.add(createParent(input, filehandler));
                filehandler.writeParentToFile(parentList);
                saveCounters(filehandler);
                backToSubMenuParent(input, filehandler);
                break;
            case 3:
                subMenuEditParent(input, filehandler);
            case 4:
                deleteParent(parentList,input);
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

    private static void subMenuEditParent(Scanner input, FileHandler filehandler) {
        System.out.println("R E D I G E R   F O R Æ L D E R");
        System.out.println("TAST 1: Skift fornavn på en forælder.");
        System.out.println("TAST 2: Skift efternavn på en forælder.");
        System.out.println("TAST 3: Skift telefonnummer på en forælder.");
        System.out.println("TAST 4: Tilbage til forældermenu");
        System.out.println("TAST 9: HOVEDMENU");
        System.out.println("TAST 0: Afslut programmet");

        int choice = input.nextInt();

        int chosenID;
        switch (choice) {
            case 1:
                //print liste over forældre
                System.out.println(parentList);
                System.out.println("Vælg id på ønsket forældre: ");
                chosenID = input.nextInt();
                for (int i = 0; i < parentList.size(); i++){
                    if (parentList.get(i).getID()==chosenID){
                        System.out.println("Indtast nyt navn for " + parentList.get(i).getFirstName() + ": " );
                        parentList.get(i).setFirstName(input.next());
                        break;
                    }
                }
                filehandler.writeParentToFile(parentList);
                backToSubMenuParent(input, filehandler);
                break;
            case 2:
                System.out.println(parentList);
                System.out.println("Vælg id på ønsket forældre: ");
                chosenID = input.nextInt();
                for (int i = 0; i < parentList.size(); i++){
                    if (parentList.get(i).getID() == chosenID) {
                        System.out.println("Indtast nyt efternavn for " + parentList.get(i).getLastName() + ": ");
                        parentList.get(i).setLastName(input.next());
                        break;
                    }
                }
                filehandler.writeParentToFile(parentList);
                backToSubMenuParent(input, filehandler);
                break;
            case 3:
                System.out.println(parentList);
                System.out.println("Vælg id på ønsket forældre: ");
                chosenID = input.nextInt();
                    for (int i = 0; i < parentList.size(); i++){
                        if(parentList.get(i).getID() == chosenID){
                            System.out.println(parentList.get(i).getFirstName() + " er valgt.  \n");
                            System.out.println("Indtast nyt telefonnummer: ");
                            parentList.get(i).setPhoneNumber(input.nextInt());
                            break;

                        }

                    }
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

        while (it.hasNext()) {
            Child index = it.next();
            if (index.getID() == chosenID) {
                it.remove();
            }
        }
    }

    private static void deleteParent(List<Parent> list, Scanner input) {
        Iterator<Parent> it = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Forælder ID " + list.get(i).getID());
            System.out.println("Forælder navn " + list.get(i).getFirstName());
        }
        System.out.println("Indtast id'et på det parent på som skal slettes");
        int chosenID = input.nextInt();

        while (it.hasNext()) {
            Parent index = it.next();
            if (index.getID() == chosenID) {
                it.remove();
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
        System.out.println("Current date: ");
        int date = input.nextInt();
        System.out.println("Add child to waitlist? y/n");
        String waitListAnswer = input.next();
        boolean waitList = false;
        if (waitListAnswer.equalsIgnoreCase("y")) {
            waitList = true;
        }
        Child newChild = new Child(firstName, lastName, cprNr, startDate, room, date, waitList);
        return newChild;
    }

 //   private static Child

    private static void saveCounters(FileHandler filehandler) {
        Child childObj = new Child();
        Parent parentObj = new Parent();

        filehandler.writeCounters(childObj.getID(), parentObj.getID());
    }


    public static Parent createParent(Scanner input, FileHandler fileHandler) {
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


}

