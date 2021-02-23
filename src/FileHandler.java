import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileHandler {

    public void writeChildToFile(List<Child> childList) {
        try {
            File childData = new File("childData.txt");

            FileWriter myWriter = new FileWriter(childData);
            for (int i = 0; i < childList.size(); i++) {
                myWriter.write(childList.get(i).getID() + " " + childList.get(i).getFirstName() + " " + childList.get(i).getLastName() + " " + childList.get(i).getCprNR() + " " + childList.get(i).getStartDate() + " " + childList.get(i).getRoom() + " " + childList.get(i).getDate() + " " + childList.get(i).isWaitList());
                if (i != childList.size() - 1) {
                    myWriter.write("\n");
                }
            }
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeParentToFile(List<Parent> parentList) {
        try {
            File parentData = new File("parentData.txt");

            FileWriter myWriter = new FileWriter(parentData);
            for (int i = 0; i < parentList.size(); i++) {
                myWriter.write(parentList.get(i).getID() + " " + parentList.get(i).getFirstName() + " "
                        + parentList.get(i).getLastName() + " " + parentList.get(i).getChildId() + " "
                        + parentList.get(i).getPhoneNumber());
                if (i != parentList.size() - 1) {
                    myWriter.write("\n");
                }
            }
            myWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeStaffToFile(List<Staff> staffList) {
        try {
            File staffData = new File("staffData.txt");

            FileWriter myWriter = new FileWriter(staffData);
            for (int i = 0; i < staffList.size(); i++) {
                myWriter.write(staffList.get(i).getName());
                if (i != staffList.size() - 1) {
                    myWriter.write("\n");
                }

            }
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Child> readChildFromFile() {
        List<Child> tempChildList = new LinkedList<>();
        try {
            File childData = new File("childData.txt");
            Scanner fileScanner = new Scanner(childData);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Scanner lineScan = new Scanner(line);

                int id = lineScan.nextInt();
                String firstName = lineScan.next();
                String lastName = lineScan.next();
                int cprNumber = lineScan.nextInt();
                int startDate = lineScan.nextInt();
                String room = lineScan.next();
                int parentID = lineScan.nextInt();
                int date = lineScan.nextInt();
                boolean waitlist = lineScan.nextBoolean();

                tempChildList.add(new Child(id, firstName, lastName, cprNumber, startDate, room, date, waitlist));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return tempChildList;
    }

    public List<Parent> readParentFromFile() {
        List<Parent> tempParentList = new LinkedList<>();
        try {
            File parentData = new File("parentData.txt");
            Scanner fileScanner = new Scanner(parentData);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Scanner lineScan = new Scanner(line);

                int id = lineScan.nextInt();
                String firstName = lineScan.next();
                String lastName = lineScan.next();
                int childID = lineScan.nextInt();
                int phoneNumber = lineScan.nextInt();

//                tempParentList.add(new Parent(firstName, lastName, momordad, phoneNumber));
                tempParentList.add(new Parent(firstName, lastName, childID, phoneNumber));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return tempParentList;
    }

    public List<Staff> readStaffFromFile() {

        List<Staff> tempStaffList = new ArrayList<>();
        try {
            File staffData = new File("staffData.txt");
            Scanner fileScanner = new Scanner(staffData);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Scanner lineScan = new Scanner(line);
                int id = lineScan.nextInt();
                String name = lineScan.next();

                tempStaffList.add(new Staff(id,name));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return tempStaffList;
    }



    public void writeCounters(int childID, int parentID){
        try {
            File counters = new File("counters.txt");
            FileWriter myWriter = new FileWriter(counters);

            String childIDStr = String.valueOf(childID);
            String parentIDStr = String.valueOf(parentID);

            myWriter.write(childIDStr + "\n" + parentIDStr);

            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> readCounters(){
        ArrayList<Integer> counters = new ArrayList<>();

        try {
            File counterData = new File("counters.txt");
            Scanner fileScanner = new Scanner(counterData);

            // første tal i array vil være child Counter.

            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                Scanner lineScan = new Scanner(line);

                counters.add(lineScan.nextInt());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return counters;
    }
}

//
