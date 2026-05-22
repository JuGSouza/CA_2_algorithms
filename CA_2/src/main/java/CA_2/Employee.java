package CA_2;

public class Employee {

    // store the employee name
    private String name;
    
    // store the manager type of the employee
    private String managerType;
    
    // store the department name
    private String department;

    public Employee(String name, String managerType, String department) {
       
        // save the employee name
        this.name = name;
        
        // save the manager type
        this.managerType = managerType;
        
        // save the department
        this.department = department;
    }

    // return the employee name
    public String getName() {
        return name;
    }

    // return the manager type
    public String getManagerType() {
        return managerType;
    }

    // return the department name
    public String getDepartment() {
        return department;
    }

    // rweturn employee information as text
    @Override
    public String toString() {
        return name + " | Manager Type: " + managerType + " | Department: " + department;
    }
}