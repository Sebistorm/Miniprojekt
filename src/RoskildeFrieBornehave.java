import java.util.*;

public class RoskildeFrieBornehave {

    public static List<Parent> parentList = new LinkedList<>();
    public static List<Child> childList = new LinkedList<>();
    public static List<Staff> staffList = new LinkedList<>();
    public static List<StaffWorkSchedule> staffWorkSchedule = new LinkedList<>();
   // public static boolean isLeader = false;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FileHandler filehandler = new FileHandler();

        staffList = filehandler.readStaffFromFile();
        childList = filehandler.readChildFromFile();
        parentList = filehandler.readParentFromFile();


        // PrintAll methods
        printAllChildren(childList);
        // PrintAll for Parent
        printAllParents(parentList);
        // PrintAll for Staff
        printAllStaffs(staffList);
        dummyDataStaffSchedule(staffWorkSchedule);
        // PrintAll for Vagtplan
        printAllWorkSchedule(staffWorkSchedule);

        //Sets nextID
        Child child = new Child();
        child.changeNextID(filehandler.readCounters().get(0));

        Parent parent = new Parent();
        parent.changeNextID(filehandler.readCounters().get(1));

        filehandler.writeParentToFile(parentList);

        saveCounters(filehandler);

        login(input, filehandler);
    }


    // M E N U E R

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

        System.out.println("TAST 1 - VIS BØRNEMENU");
        System.out.println("TAST 2 - VIS  FORÆLDREMENU");
        System.out.println("TAST 3 - VIS MEDARBEJDERMENU");

//        if (isLeader){
//            System.out.println("TAST 3 - VIS MEDARBEJDERMENU");
//        }

        System.out.println("TAST 0: Afslut programmet");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                subMenuChild(input, filehandler);
                break;
            case 2:
                subMenuParent(input, filehandler);
                break;
            case 3:
//                if(isLeader){
//                    subMenuStaff(input, filehandler);
//                }
                subMenuStaff(input, filehandler);
                break;
            case 0:
                System.out.println("Programmet er nu afsluttet.");
                System.exit(-1);
            default:
                menuManager(input, filehandler);
                break;
        }
    }

    private static void subMenuChild(Scanner input, FileHandler filehandler) {
        System.out.println("B Ø R N E   M E N U");
        System.out.println("TAST 1: Vis liste over børn.");
        System.out.println("TAST 2: Opret et ny barn.");
        System.out.println("TAST 3: Rediger oplysninger om et barn.");
        System.out.println("TAST 4: Slet et barn.");
        System.out.println("TAST 5: Vis venteliste.");
        System.out.println("TAST 6: Ændre venteliste.");
        System.out.println("TAST 9: HOVEDMENU");
        System.out.println("TAST 0: Afslut programmet");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println(childList);
                subMenuChild(input, filehandler);
                break;
            case 2:
                childList.add(createChild(input));
                filehandler.writeChildToFile(childList);
                saveCounters(filehandler);
                subMenuChild(input, filehandler);
                break;
            case 3:
                subMenuEditChild(input, filehandler);
                break;
            case 4:
                deleteChild(childList, input);
                filehandler.writeChildToFile(childList);
                subMenuChild(input, filehandler);
            case 5: showChildWaitlist(childList, input);
                subMenuChild(input, filehandler);
            break;
            case 6: changeChildWaitList(childList, input);
                filehandler.writeChildToFile(childList);
                showChildWaitlist(childList, input);

            case 9:
                menuManager(input, filehandler);
                break;
            case 0:
                System.out.println("Programmet er nu afsluttet");
                System.exit(-1);
            default:
                menuManager(input, filehandler);
                break;
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
            default:
                menuManager(input, filehandler);
                break;
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
            default:
                menuManager(input, filehandler);
                break;
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
            default:
                menuManager(input, filehandler);
                break;
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
            default:
                menuManager(input, filehandler);
                break;

        }
    }

    private static void subMenuStaff(Scanner input, FileHandler filehandler){
        System.out.println("S T A F F   M E N U");
        System.out.println("TAST 1: Vis liste over medarbejdere.");
        System.out.println("TAST 2: Opret en ny medarbejder.");
        System.out.println("TAST 3: Rediger oplysninger om en medarbejder.");
        System.out.println("TAST 4: Slet en medarbejder.");
        System.out.println("TAST 5: Vis vagtplan.");
        System.out.println("TAST 6: Lav vagtplan");
        System.out.println("TAST 9: HOVEDMENU");
        System.out.println("TAST 0: Afslut programmet");

        int choice = input.nextInt();

        switch (choice){
            case 1:
                System.out.println(staffList);
                break;
            case 2:
                staffList.add(createStaff(input));
                filehandler.writeStaffToFile(staffList);
                subMenuStaff(input, filehandler);
                break;
            case 3:
                subMenuEditStaff(input, filehandler);
                break;
            case 4:

            case 5:
                makeSchedule(input, staffList, staffWorkSchedule);
                System.out.println(staffWorkSchedule);
                subMenuStaff(input, filehandler);
            default:
                menuManager(input, filehandler);


        }
    }

    private static void subMenuEditStaff(Scanner input, FileHandler filehandler) {
        System.out.println("R E D I G E R   M E D A R B E J D E R");
        System.out.println("TAST 1: Skift fornavn");
        System.out.println("TAST 2: Skift efternavn");
        System.out.println("TAST 3: Skift telefonnummer");
        System.out.println("TAST 8: Tilbage til medarbejdermenu");
        System.out.println("TAST 9: HOVEDMENU");
        System.out.println("TAST 0: Afslut programmet");

        int choice = input.nextInt();
        int chosenID;

        switch (choice) {
            case 1:
                System.out.println(staffList);
                System.out.println("Vælg id på medarbejderen: ");
                chosenID = input.nextInt();
                for (int i = 0; i < staffList.size(); i++) {
                    if (staffList.get(i).getID() == chosenID) {
                        System.out.println("Indtast nyt navn for " + staffList.get(i).getFirstName() + ": ");
                        staffList.get(i).setFirstName(input.next());
                        break;
                    }
                }
                filehandler.writeStaffToFile(staffList);
                subMenuEditStaff(input, filehandler);
            case 2:
                System.out.println(staffList);
                System.out.println("Vælg id på på medarbejderen: ");
                chosenID = input.nextInt();
                for (int i = 0; i < staffList.size(); i++) {
                    if (staffList.get(i).getID() == chosenID) {
                        System.out.println("Indtast nyt efternavn for " + staffList.get(i).getLastName() + ": ");
                        staffList.get(i).setLastName(input.next());
                        break;
                    }
                }
                filehandler.writeStaffToFile(staffList);
                subMenuEditStaff(input, filehandler);
                break;
            case 3:
                System.out.println(staffList);
                System.out.println("Vælg id på medarbejder: ");
                chosenID = input.nextInt();
                for (int i = 0; i < staffList.size(); i++) {
                    if (staffList.get(i).getID() == chosenID) {
                        System.out.println(staffList.get(i).getFirstName() + " er valgt.  \n");
                        System.out.println("Indtast nyt telefonnummer: ");
                        staffList.get(i).setPhoneNumber(input.nextInt());
                        break;
                    }
                }
                filehandler.writeStaffToFile(staffList);
                subMenuEditStaff(input, filehandler);
                break;
            case 8:
                subMenuStaff(input, filehandler);
            case 9:
                menuManager(input, filehandler);
            case 0:
                System.out.println("Programmet er afsluttet");
                System.exit(-1);
            default:
                menuManager(input, filehandler);
        }
    }


    //  C H I L D

    private static Child createChild(Scanner input) {
        System.out.println("Indtast fornavn: ");
        String firstName = input.next();
        System.out.println("Indtast efternavn: ");
        String lastName = input.next();
        System.out.println("Indtast CPR-NR: ");
        int cprNr = input.nextInt();
        System.out.println("Indtast barnets startdato: "); //BURDE HÆNGE SAMMEN MED VENTELISTE
        int startDate = input.nextInt();
        System.out.println("Hvilken stue skal barnet tilknyttes? Stue: Yellow, red, green");// METODE TIL DANSK
        String room = input.next();
        System.out.println("Indtast dags dato: "); //SLETTE?
        int date = input.nextInt();
        System.out.println("Skal barnet på venteliste? y/n"); //DET BURDE VÆRE EN CONDITION DER ÅBNER FOR STARTDATO
        String waitListAnswer = input.next();
        boolean waitList = false;
        if (waitListAnswer.equalsIgnoreCase("y")) {
            waitList = true;
        }
        Child newChild = new Child(firstName, lastName, cprNr, startDate, room, date, waitList);
        return newChild;
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

    private static void  showChildWaitlist (List<Child> list, Scanner input) {
        System.out.println("V E N T E L I S T E");
           for (int i = 0; i < list.size(); i++) {
               if(list.get(i).isWaitList()) {
                   System.out.print("Barns ID: " + list.get(i).getID() + " \tNavn: "+list.get(i).getFirstName()
                           + " " + list.get(i).getLastName() + "\n");
               }
        }
        System.out.println("");
    }

    private static void changeChildWaitList(List<Child> list, Scanner input) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("Barns ID: " + list.get(i).getID() + " \tNavn: "+list.get(i).getFirstName()
                    + " " + list.get(i).getLastName() + "\n");
        }
        System.out.println("Skriv id'et på barnet");
        int index = input.nextInt();
        System.out.println(index);
        for (int i = 0; i < list.size(); i++) {
            if (index == list.get(i).getID()) {
                System.out.println("Skal barnet være på venteliste? true / false");
                boolean status = input.nextBoolean();
                list.get(i).setWaitList(status);
                System.out.println("Ventelisten er nu opdateret.");
                System.out.println(list.get(i));
                break;
            }
        }
    }

    private static void saveCounters(FileHandler filehandler) {
        Child childObj = new Child();
        Parent parentObj = new Parent();

        filehandler.writeCounters(childObj.getID(), parentObj.getID());
    }


    //  P A R E N T
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


    //  S T A F F
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

    private static Staff createStaff(Scanner input) {
        System.out.println("Indtast ønsket medarbejder ID nr.: ");
        int id = input.nextInt();
        System.out.println("Enter first name: ");
        String firstName = input.next();
        System.out.println("Enter last name: ");
        String lastName = input.next();
        System.out.println("Indtast telefon nr.: ");
        int phonenr = input.nextInt();
        Staff newStaff = new Staff(id, firstName, lastName, phonenr);
        return newStaff;
    }

    // PrintAll for Child
    public static void printAllChildren(List<Child> childList) {
        String waitlist = "";
        System.out.println("Oversigt over Børn");
        for (int i = 0; i < childList.size(); i++) {
            if (childList.get(i).isWaitList()) {
                waitlist = "Er ikke på venteliste";
            } else {
                waitlist = "Er på venteliste";
            }
            System.out.println("ID: " + childList.get(i).getID() + " | " + "Navn: " + childList.get(i).getFirstName() + " " + childList.get(i).getLastName() + " | " +
                    "CPR nr :" + childList.get(i).getCprNR() + " | " + "Startdato: " + childList.get(i).getStartDate() + " | " +"Rum: " + childList.get(i).getRoom() + " | " +
                    "dato: " + childList.get(i).getDate() + " | " + "Venteliste: " + waitlist);

        }
    }

    // PrintAll for parents
    public static void printAllParents(List<Parent> parentList) {
        System.out.println("Oversigt over Forældre");
        for (int i = 0; i < parentList.size(); i++) {
            System.out.println("ID: " + parentList.get(i).getID() + " | " + "Navn: " + parentList.get(i).getFirstName() + " " + parentList.get(i).getLastName() + " | "
                    + "ChildID: " + parentList.get(i).getChildId() + " | " + "Telefonnummer: " + parentList.get(i).getPhoneNumber());
        }

    }

    //PrintAll for Staff
    public static void printAllStaffs(List<Staff> staffList) {
        System.out.println("Oversigt over Personale");
        for (int i = 0; i < staffList.size(); i++) {
            System.out.println("ID: " + staffList.get(i).getID() + " | " + "Navn: " + staffList.get(i).getFirstName() + " " + staffList.get(i).getLastName() + " | " +
                    "Telefonnummer: " + staffList.get(i).getPhoneNumber());
        }
    }

    //PrintAll for Vagtplan
    public static void printAllWorkSchedule(List<StaffWorkSchedule> plan) {
        System.out.println("Vagtplan");
        for (int i = 0; i < plan.size(); i++) {
            System.out.println("Uge: " + plan.get(i).getWeekNumber());
            System.out.print("Mandagshold: ");
            for (int k = 0; k < plan.get(i).getMondayStaff().size(); k++) {
                System.out.print(plan.get(i).getMondayStaff().get(k) + " | ");
            }
            System.out.print("\nTirsdagshold: ");
            for (int k = 0; k < plan.get(i).getTuesdayStaff().size(); k++) {
                System.out.print(plan.get(i).getTuesdayStaff().get(k) + " | ");
            }
            System.out.print("\nOnsdagshold: ");
            for (int k = 0; k < plan.get(i).getWednesdayStaff().size(); k++) {
                System.out.print(plan.get(i).getWednesdayStaff().get(k) + " | ");
            }
            System.out.print("\nTorsdagshold: ");
            for (int k = 0; k < plan.get(i).getThursdayStaff().size(); k++) {
                System.out.print(plan.get(i).getThursdayStaff().get(k) + " | ");
            }
            System.out.print("\nFredagshold: ");
            for (int k = 0; k < plan.get(i).getFridayStaff().size(); k++) {
                System.out.print(plan.get(i).getFridayStaff().get(k) + " | ");
            }
            // To make a new line for the next week
            System.out.println("\n");
        }

    }


    //  V A G T P L A N
    public static void makeSchedule (Scanner input, List<Staff> list, List<StaffWorkSchedule> plan) {
        System.out.println("L A V   V A G T P L A N");
        System.out.println("Skriv hvilken uge vagtplanen gælder for");
        int week = input.nextInt();

        // mandag
        System.out.println("Tilføj personale til mandag:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " " + list.get(i).getFirstName() + " " + list.get(i).getLastName());
        }
        boolean moreStaffMonday = true;
        ArrayList<String> mondayShift = new ArrayList<>();
        while (moreStaffMonday) {
            System.out.println("Tilføj personalet ved at indtaste deres nummer");
            int userChoice = input.nextInt();
            for (int i = 0; i < list.size(); i++) {
                if (i == userChoice) {
                    mondayShift.add(list.get(i).getFirstName() + list.get(i).getLastName());
                    break;
                }
            }
            System.out.println("Vil du tilføje mere personale? ja/nej");
            String userAnswer = input.next();
            if (userAnswer.equalsIgnoreCase("nej")) {
                moreStaffMonday = false;
            }
        }

        // Tirsdag
        System.out.println("Tilføj personale til Tirsdag:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " " + list.get(i).getFirstName() + " " + list.get(i).getLastName());
        }
        boolean moreStaffTuesday = true;
        ArrayList<String> tuesdayShift = new ArrayList<>();
        while (moreStaffTuesday) {
            System.out.println("Tilføj personalet ved at indtaste deres nummer");
            int userChoice = input.nextInt();
            for (int i = 0; i < list.size(); i++) {
                if (i == userChoice) {
                    tuesdayShift.add(list.get(i).getFirstName() + list.get(i).getLastName());
                    break;
                }
            }
            System.out.println("Vil du tilføje mere personale? ja/nej");
            String userAnswer = input.next();
            if (userAnswer.equalsIgnoreCase("nej")) {
                moreStaffTuesday = false;
            }

        }

        // Onsdag
        System.out.println("Tilføj personale til Onsdag:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " " + list.get(i).getFirstName() + " " + list.get(i).getLastName());
        }
        boolean moreStaffWednesday = true;
        ArrayList<String> wednesdayShift = new ArrayList<>();
        while (moreStaffWednesday) {
            System.out.println("Tilføj personalet ved at indtaste deres nummer");
            int userChoice = input.nextInt();
            for (int i = 0; i < list.size(); i++) {
                if (i == userChoice) {
                    wednesdayShift.add(list.get(i).getFirstName() + list.get(i).getLastName());
                    break;
                }
            }
            System.out.println("Vil du tilføje mere personale? ja/nej");
            String userAnswer = input.next();
            if (userAnswer.equalsIgnoreCase("nej")) {
                moreStaffWednesday = false;
            }
        }

        // Torsdag
        System.out.println("Tilføj personale til Torsdag:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " " + list.get(i).getFirstName() + " " + list.get(i).getLastName());
        }
        boolean moreStaffThursday = true;
        ArrayList<String> thurdayShift = new ArrayList<>();
        while (moreStaffThursday) {
            System.out.println("Tilføj personalet ved at indtaste deres nummer");
            int userChoice = input.nextInt();
            for (int i = 0; i < list.size(); i++) {
                if (i == userChoice) {
                    thurdayShift.add(list.get(i).getFirstName() + list.get(i).getLastName());
                    break;
                }
            }
            System.out.println("Vil du tilføje mere personale? ja/nej");
            String userAnswer = input.next();
            if (userAnswer.equalsIgnoreCase("nej")) {
                moreStaffThursday = false;
            }
        }

        // Fredag
        System.out.println("Tilføj personale til Fredag:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " " + list.get(i).getFirstName() + " " + list.get(i).getLastName());
        }
        boolean moreStaffFriday = true;
        ArrayList<String> fridayShift = new ArrayList<>();
        while (moreStaffFriday) {
            System.out.println("Tilføj personalet ved at indtaste deres nummer");
            int userChoice = input.nextInt();
            for (int i = 0; i < list.size(); i++) {
                if (i == userChoice) {
                    fridayShift.add(list.get(i).getFirstName() + list.get(i).getLastName());
                    break;
                }
            }
            System.out.println("Vil du tilføje mere personale? ja/nej");
            String userAnswer = input.next();
            if (userAnswer.equalsIgnoreCase("nej")) {
                moreStaffFriday = false;
            }
        }

        StaffWorkSchedule newWeek = new StaffWorkSchedule(week, mondayShift, tuesdayShift, wednesdayShift, thurdayShift, fridayShift);
        plan.add(newWeek);


    }

    public static void dummyDataStaffSchedule(List<StaffWorkSchedule> plan) {
        // Staff dummy data
        Staff newStaff1 = new Staff(1, "Bo", "Madsen", 12345678);
        Staff newStaff2 = new Staff(2, "Daniel", "Jensen", 44351211);
        Staff newStaff3 = new Staff(3, "Camilla", "Høj", 44356211);
        Staff newStaff4 = new Staff(4, "Sarah", "Madsen", 43452211);
        Staff newStaff5 = new Staff(5, "Mette", "Mink", 44356711);
        // ArrayList dummydata
        ArrayList<String> mondayShift = new ArrayList<>();
        mondayShift.add(newStaff1.getFirstName() + " " + newStaff1.getLastName());
        mondayShift.add(newStaff2.getFirstName() + " " + newStaff2.getLastName());
        mondayShift.add(newStaff3.getFirstName() + " " + newStaff3.getLastName());

        ArrayList<String> tuesdayShift = new ArrayList<>();
        tuesdayShift.add(newStaff3.getFirstName() + " " + newStaff3.getLastName());
        tuesdayShift.add(newStaff5.getFirstName() + " " + newStaff5.getLastName());
        tuesdayShift.add(newStaff2.getFirstName() + " " + newStaff2.getLastName());

        ArrayList<String> wednesdayShift = new ArrayList<>();
        wednesdayShift.add(newStaff5.getFirstName() + " " + newStaff5.getLastName());
        wednesdayShift.add(newStaff1.getFirstName() + " " + newStaff1.getLastName());

        ArrayList<String> thurdayShift = new ArrayList<>();
        thurdayShift.add(newStaff2.getFirstName() + " " + newStaff2.getLastName());
        thurdayShift.add(newStaff4.getFirstName() + " " + newStaff4.getLastName());
        thurdayShift.add(newStaff1.getFirstName() + " " + newStaff1.getLastName());

        ArrayList<String> fridayShift = new ArrayList<>();
        fridayShift.add(newStaff1.getFirstName() + " " + newStaff1.getLastName());
        fridayShift.add(newStaff5.getFirstName() + " " + newStaff5.getLastName());

        StaffWorkSchedule newWeek = new StaffWorkSchedule(8, mondayShift, tuesdayShift, wednesdayShift, thurdayShift, fridayShift);
        plan.add(newWeek);

        StaffWorkSchedule newWeek2 = new StaffWorkSchedule(9, mondayShift, tuesdayShift, wednesdayShift, thurdayShift, fridayShift);
        plan.add(newWeek2);
    }

}

