import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

// MANGLER VENTELISTE

public class Child {
    private final int ID;
    static int nextID = 1;

    private String firstName;
    private String lastName;
    private int cprNR;
    private int startDate;
    private String room;
    private int date;
    private boolean waitList;

    // Constructor til et helt nyt barn
    public Child(String firstName, String lastName, int cprNR, int startDate, String room, int date, boolean waitList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cprNR = cprNR;
        this.startDate = startDate;
        this.room = room;

        this.date = date;
        this.waitList = waitList;
        ID = nextID;
        nextID++;
    }

    // Constructor når læses fra fil
    public Child(int ID, String firstName, String lastName, int cprNR, int startDate, String room, int date, boolean waitList) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cprNR = cprNR;
        this.startDate = startDate;
        this.room = room;
        this.date = date;
        this.waitList = waitList;
    }

    public Child() {
        ID = nextID;
    }

    @Override
    public String toString() {
        return "Child{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cprNR=" + cprNR +
                ", startDate=" + startDate +
                ", room='" + room + '\'' +
//                ", parentID=" + parentID +
                ", date=" + date +
                ", waitList=" + waitList + "\n";
    }

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

    public int getCprNR() {
        return cprNR;
    }

    public void setCprNR(int cprNR) {
        this.cprNR = cprNR;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    /*
        public int getParentID() {
            return parentID;
        }

        public void setParentID(int parentID) {
            this.parentID = parentID;
        }
    */
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public boolean isWaitList() {
        return waitList;
    }

    public void setWaitList(boolean waitList) {
        this.waitList = waitList;
    }

    public void changeFirstName(String newName) {
        this.firstName = newName;
    }

    public void changeLastName(String newName) {
        this.firstName = newName;

    }

    public void changeCPRnr(int newCRP) {
        this.cprNR = newCRP;
    }

    public void changeStartDate(int newStartDate) {
        this.startDate = newStartDate;
    }

    public void changeRoom(String newRoom) {
        this.room = newRoom;
    }

/*    public void changeParentID(int parentID) {
        this.parentID = parentID;
    }
*/

    public void changeDate(int newDate) {
        this.date = newDate;
    }

    public void changeNextID(int number){

        nextID = number;
    }
}

