import java.util.Scanner;

public class Staff {
    int ID;
    //static int nextID = 1;
    private String name;

    public Staff(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    /*
    public Staff() {
        ID = nextID;
    }

 */

    @Override
    public String toString() {
        return "Staff{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return ID;
    }

    /*
    public static Staff createStaff(Scanner input){

        System.out.println("navn");
        String name = input.next();

        Staff newStaff = new Staff(name);
        return newStaff;
    }

     */
}