package CA_2;


public class Manager {

    // store the manager type
    private String managerType;

    // save the manager type passed by the user
    public Manager(String managerType) {
        this.managerType = managerType;
    }

    // return the manager type
    public String getManagerType() {
        return managerType;
    }
}
