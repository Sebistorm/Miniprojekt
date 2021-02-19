import java.util.Scanner;

public class Child {
    int ID;
    String firstName;
    String lastName;
    int cprNR;
    int startDate;
    String room;
    int parentID;
    int date;
    boolean waitList;

    public Child(String firstName, String lastName, int cprNR, int startDate, String room, int parentID, int date, boolean waitList) {
//        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cprNR = cprNR;
        this.startDate = startDate;
        this.room = room;
        this.parentID = parentID;
        this.date = date;
        this.waitList = waitList;

    }

    @Override
    public String toString() {
        return "Child{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cprNR=" + cprNR +
                ", startDate=" + startDate +
                ", room='" + room + '\'' +
                ", parentID=" + parentID +
                ", date=" + date +
                ", waitList=" + waitList +
                '}';
    }
}

