import java.util.ArrayList;
import java.util.List;
public class tempClass {

    public static void test(List<Child> childList, List<Parent> parentList, List<Staff> staffList, List<StaffWorkSchedule> plan) {
        // PrintAll for Child
        printAllChildren(childList);
        System.out.println();
        // PrintAll for Parent
        printAllParents(parentList);
        System.out.println();

        // PrintAll for Staff
        printAllStaffs(staffList);
        System.out.println();

        dummyDataStaffSchedule(plan);
        // PrintAll for Vagtplan
        printAllWorkSchedule(plan);


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


