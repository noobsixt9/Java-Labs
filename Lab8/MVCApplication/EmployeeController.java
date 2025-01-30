package Lab8.MVCApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeController {
    private EmployeeView view;
    private EmployeeModel model;
    private EmployeeDAO dao;

    EmployeeController(EmployeeModel model, EmployeeView view, EmployeeDAO dao) {
        this.model = model;
        this.view = view;
        this.dao = dao;

        view.addSubmitListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });
    }

    void handleSubmit() {
        String name = view.getName();
        String age = view.getAge();
        String address = view.getAddress();
        String position = view.getPosition();
        model.setName(name);
        model.setAge(age);
        model.setAddress(address);
        model.setPosition(position);

        if (name.isEmpty() || age.isEmpty() || address.isEmpty() || position.isEmpty()) {
            view.setMessage("Fields cannot be empty!");
            return;
        }

        int ageInteger = Integer.parseInt(age);
        if (ageInteger <= 20) {
            view.setMessage("Age must be 20 or above");
            return;
        }

        boolean isAdded = dao.addEmployee(model);

        if (isAdded) {
            view.setMessage("Employee added to the database.");
        }
    }
}