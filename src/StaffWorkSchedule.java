//Vælge ugenummer, ugedag, tilføj medarbejder.
//Skal lave et nyt hashmap/treeset/list hver uge, der tilføjes.

//Hashmap


public class StaffWorkSchedule {

    int weekNumber;
    String weekDay;
    String staff;


    public StaffWorkSchedule(int weekNumber, String weekDay, String staff) {
        this.weekNumber = weekNumber;
        this.weekDay = weekDay;
        this.staff = staff;

    }

    @Override
    public String toString() {
        return "StaffWorkSchedule{" +
                "weekNumber=" + weekNumber +
                ", weekDay='" + weekDay + '\'' +
                ", staff='" + staff + '\'' +
                '}';
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

}
