public class Parent {

    private int ID;
    static int nextID = 1;

    private String firstName;
    private String lastName;
    private String momordad;
    private int phoneNumber;

    public Parent(String firstName, String lastName, String isMother, int phoneNumber) {
        ID = nextID;
        nextID++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.momordad = momordad;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", momordad='" + momordad + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
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

    public String getMomordad() {
        return momordad;
    }

    public void setMomordad(String momordad) {
        this.momordad = momordad;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
