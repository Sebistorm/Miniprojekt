public class Staff {
    String name;


    public Staff(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "com.company.Staff{" +
                "name='" + name + '\'' +
                '}';
    }
    public String getName() {
        return name;
    }

}