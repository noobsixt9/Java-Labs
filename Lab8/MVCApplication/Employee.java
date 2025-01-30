package Lab8.MVCApplication;

public class Employee {
    public static void main(String[] args) {
        EmployeeModel model = new EmployeeModel("", "", "", "");
        EmployeeView view = new EmployeeView();
        EmployeeDAO dao = new EmployeeDAO();
        EmployeeController controller = new EmployeeController(model, view, dao);
    }
}