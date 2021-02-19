import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileHandler {

    public void writeChildToFile(List<Child> childList){
        try{
            File childData = new File("childData.txt");

            FileWriter myWriter = new FileWriter(childData);
            for (int i = 0;i<childList.size(); i++){
                myWriter.write(childList.get(i).getID()  + " " +  childList.get(i).getFirstName() + " " + childList.get(i).getLastName() + " " + childList.get(i).getCprNR() + " " +  childList.get(i).getStartDate() + " " +  childList.get(i).getRoom() + " " + childList.get(i).getParentID() + " " + childList.get(i).getDate() + " " + childList.get(i).isWaitList());
            }
            myWriter.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeParentToFile(List<Parent> parentList){
        try{
            File parentData = new File("parentData.txt");

            FileWriter myWriter = new FileWriter(parentData);
            for (int i = 0;i<parentList.size(); i++){
                myWriter.write(parentList.get(i).getID()  + " " +  parentList.get(i).getFirstName() + " " + parentList.get(i).getLastName() + " " + parentList.get(i).getMomordad() + " " + parentList.get(i).getPhoneNumber());
            }
            myWriter.close();


        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Child> readChildFromFile(){
        List<Child> tempChildList = new LinkedList<>();
        try {
            File childData = new File("childData.txt");
            Scanner fileScanner = new Scanner(childData);

            while(fileScanner.hasNextLine()){
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

                tempChildList.add(new Child(id, firstName, lastName, cprNumber, startDate, room, parentID, date, waitlist));
            }

        } catch (FileNotFoundException e){
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

                String firstName = lineScan.next();
                String lastName = lineScan.next();
                String momordad = lineScan.next();
                int phoneNumber = lineScan.nextInt();

                tempParentList.add(new Parent(firstName, lastName, momordad, phoneNumber));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return tempParentList;
    }
}


//
