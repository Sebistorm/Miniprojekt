//Vælge ugenummer, ugedag, tilføj medarbejder.
//Skal lave et nyt hashmap/treeset/list hver uge, der tilføjes.

//Hashmap


import java.util.ArrayList;
import java.util.Arrays;

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
}
