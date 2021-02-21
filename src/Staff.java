import java.util.Scanner;

public class Staff {
    String name;

    public Staff(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Staff: " +
                "name='" + name + "\n";
    }
    public String getName() {
        return name;
    }

    public static Staff createStaff(Scanner input){

        System.out.println("navn");
        String name = input.next();

        Staff newStaff = new Staff(name);
        return newStaff;
    }
}