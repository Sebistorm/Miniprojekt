
import java.util.ArrayList;

public class StaffWorkSchedule {

    int weekNumber;
    ArrayList<String> mondayStaff;
    ArrayList<String> tuesdayStaff;
    ArrayList<String> wednesdayStaff;
    ArrayList<String> thursdayStaff;
    ArrayList<String> fridayStaff;

    public StaffWorkSchedule(int weekNumber, ArrayList<String> mondayStaff, ArrayList<String> tuesdayStaff, ArrayList<String> wednesdayStaff, ArrayList<String> thursdayStaff, ArrayList<String> fridayStaff) {
        this.weekNumber = weekNumber;
        this.mondayStaff = mondayStaff;
        this.tuesdayStaff = tuesdayStaff;
        this.wednesdayStaff = wednesdayStaff;
        this.thursdayStaff = thursdayStaff;
        this.fridayStaff = fridayStaff;
    }

    @Override
    public String toString() {
        return "StaffWorkSchedule{ \n" +
                "weekNumber=" + weekNumber +
                "\n, mondayStaff=" + mondayStaff +
                "\n, tuesdayStaff=" + tuesdayStaff +
                "\n, wednesdayStaff=" + wednesdayStaff +
                "\n, thursdayStaff=" + thursdayStaff +
                "\n, fridayStaff=" + fridayStaff +
                '}';
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public ArrayList<String> getMondayStaff() {
        return mondayStaff;
    }

    public void setMondayStaff(ArrayList<String> mondayStaff) {
        this.mondayStaff = mondayStaff;
    }

    public ArrayList<String> getTuesdayStaff() {
        return tuesdayStaff;
    }

    public void setTuesdayStaff(ArrayList<String> tuesdayStaff) {
        this.tuesdayStaff = tuesdayStaff;
    }

    public ArrayList<String> getWednesdayStaff() {
        return wednesdayStaff;
    }

    public void setWednesdayStaff(ArrayList<String> wednesdayStaff) {
        this.wednesdayStaff = wednesdayStaff;
    }

    public ArrayList<String> getThursdayStaff() {
        return thursdayStaff;
    }

    public void setThursdayStaff(ArrayList<String> thursdayStaff) {
        this.thursdayStaff = thursdayStaff;
    }

    public ArrayList<String> getFridayStaff() {
        return fridayStaff;
    }

    public void setFridayStaff(ArrayList<String> fridayStaff) {
        this.fridayStaff = fridayStaff;
    }
}
