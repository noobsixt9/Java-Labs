package Lab8.MVCApplication;

public class EmployeeModel {
    private String name;
    private String age;
    private String address;
    private String position;

    EmployeeModel(String name, String age, String address, String position) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}