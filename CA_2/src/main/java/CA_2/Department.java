package CA_2;

public class Department {

    // store the department name
    private String departmentName;

    // save the department name passed by the user
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    // return the department name
    public String getDepartmentName() {
        return departmentName;
    }
}
