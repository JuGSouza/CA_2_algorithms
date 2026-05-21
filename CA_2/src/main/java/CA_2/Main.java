package CA_2;

import static CA_2.MenuOption.ADD_RECORD;
import static CA_2.MenuOption.CREATE_TREE;
import static CA_2.MenuOption.EXIT;
import static CA_2.MenuOption.SEARCH;
import static CA_2.MenuOption.SORT;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

        static ArrayList<Employee> employees = new ArrayList<>();

       static BinaryTree tree = new BinaryTree();

    
    public static void addStartingEmployees() {

        employees.add(new Employee("Kate Summer", "Senior Manager", "IT Development"));
        employees.add(new Employee("Ken Winter", "Team Lead", "IT Development"));
        employees.add(new Employee("James Anderson", "Manager", "Sales"));
        employees.add(new Employee("Sarah Johnson", "Assistant Manager", "HR"));
        employees.add(new Employee("John Smith", "Senior Manager", "Finance"));
        employees.add(new Employee("Emily Brown", "Team Lead", "Marketing"));
        employees.add(new Employee("Michael Williams", "Assistant Manager", "IT Development"));
        employees.add(new Employee("Sophia Taylor", "Team Lead", "Customer Service"));
        employees.add(new Employee("David Wilson", "Manager", "IT Development"));
        employees.add(new Employee("Olivia Martinez", "Assistant Manager", "Accounting"));
        employees.add(new Employee("Ethan Anderson", "Senior Manager", "Finance"));
        employees.add(new Employee("Mia Clark", "Team Lead", "Operations"));
        employees.add(new Employee("John Anderson", "Manager", "Sales"));
        employees.add(new Employee("Sam Johnson", "Manager", "HR"));
        employees.add(new Employee("John Brown", "Manager", "Finance"));
        employees.add(new Employee("Emma Brown", "Team Lead", "Marketing"));
        employees.add(new Employee("Max Williams", "Assistant Manager", "Technical Support"));
        employees.add(new Employee("Sonya Taylor", "Team Lead", "Customer Service"));
        employees.add(new Employee("Denis Wilson", "Manager", "IT Development"));
        employees.add(new Employee("Olga Martinez", "Assistant Manager", "Accounting"));
    }

   
    public static void mergeSort(ArrayList<Employee> list) {

        if (list.size() <= 1) {
            return;
        }

        int middle = list.size() / 2;

        ArrayList<Employee> left = new ArrayList<>();
        ArrayList<Employee> right = new ArrayList<>();

        for (int i = 0; i < middle; i++) {
            left.add(list.get(i));
        }

        for (int i = middle; i < list.size(); i++) {
            right.add(list.get(i));
        }

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }
 public static void merge(ArrayList<Employee> list, ArrayList<Employee> left, ArrayList<Employee> right) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.size() && j < right.size()) {

            if (left.get(i).getName().compareToIgnoreCase(right.get(j).getName()) <= 0) {
                list.set(k, left.get(i));
                i++;
            } else {
                list.set(k, right.get(j));
                j++;
            }

            k++;
        }

        while (i < left.size()) {
            list.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < right.size()) {
            list.set(k, right.get(j));
            j++;
            k++;
        }
    }
  public static Employee binarySearch(ArrayList<Employee> list, String target, int left, int right) {

        if (left > right) {
            return null;
        }

        int middle = (left + right) / 2;

        Employee middleEmployee = list.get(middle);

        int result = target.compareToIgnoreCase(middleEmployee.getName());

        if (result == 0) {
            return middleEmployee;
        } else if (result < 0) {
            return binarySearch(list, target, left, middle - 1);
        } else {
            return binarySearch(list, target, middle + 1, right);
        }
    }
   public static void addEmployee(Scanner scanner) {

        scanner.nextLine();

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.println("\nChoose Manager Type:");
        System.out.println("1. Manager");
        System.out.println("2. Senior Manager");
        System.out.println("3. Assistant Manager");
        System.out.println("4. Team Lead");

        System.out.print("Choose an option: ");
        int managerChoice = scanner.nextInt();

        String managerType;

        switch (managerChoice) {
            case 1:
                managerType = "Manager";
                break;
            case 2:
                managerType = "Senior Manager";
                break;
            case 3:
                managerType = "Assistant Manager";
                break;
            case 4:
                managerType = "Team Lead";
                break;
            default:
                System.out.println("Invalid manager type.");
                return;
        }

        System.out.println("\nChoose Department:");
        System.out.println("1. IT Development");
        System.out.println("2. HR");
        System.out.println("3. Finance");
        System.out.println("4. Sales");
        System.out.println("5. Customer Service");

        System.out.print("Choose an option: ");
        int departmentChoice = scanner.nextInt();

        String department;

        switch (departmentChoice) {
            case 1:
                department = "IT Development";
                break;
            case 2:
                department = "HR";
                break;
            case 3:
                department = "Finance";
                break;
            case 4:
                department = "Sales";
                break;
            case 5:
                department = "Customer Service";
                break;
            default:
                System.out.println("Invalid department.");
                return;
        }

        Employee employee = new Employee(name, managerType, department);
        employees.add(employee);

        System.out.println("\nNew employee added successfully:");
        System.out.println(employee);
    }
 public static void showMenu() {
        System.out.println("\n=== Department Store Employee System ===");
        System.out.println("1. Sort employees");
        System.out.println("2. Search employee");
        System.out.println("3. Add new employee");
        System.out.println("4. Create employee hierarchy using Binary Tree");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }
 public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        addStartingEmployees();

        boolean running = true;

        while (running) {

            showMenu();

            int choice = scanner.nextInt();

            MenuOption option;

            switch (choice) {
                case 1:
                    option = MenuOption.SORT;
                    break;
                case 2:
                    option = MenuOption.SEARCH;
                    break;
                case 3:
                    option = MenuOption.ADD_RECORD;
                    break;
                case 4:
                    option = MenuOption.CREATE_TREE;
                    break;
                case 5:
                    option = MenuOption.EXIT;
                    break;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            switch (option) {

                case SORT:
                    mergeSort(employees);

                    System.out.println("\nFirst 20 employees in alphabetical order:");

                    for (int i = 0; i < employees.size() && i < 20; i++) {
                        System.out.println(employees.get(i));
                    }

                    break;

                case SEARCH:
                    scanner.nextLine();

                    mergeSort(employees);

                    System.out.print("Enter employee name to search: ");
                    String name = scanner.nextLine();

                    Employee found = binarySearch(employees, name, 0, employees.size() - 1);

                    if (found != null) {
                        System.out.println("\nEmployee found:");
                        System.out.println(found);
                    } else {
                        System.out.println("\nEmployee not found.");
                    }

                    break;

                case ADD_RECORD:
                    addEmployee(scanner);
                    break;

                case CREATE_TREE:
                    tree = new BinaryTree();

                    for (Employee employee : employees) {
                        tree.insert(employee);
                    }

                    System.out.println("\nEmployee hierarchy - Level Order:");

                    tree.displayLevelOrder();

                    System.out.println("\nTree height: " + tree.getHeight(tree.root));
                    System.out.println("Total node count: " + tree.countNodes(tree.root));

                    break;

                case EXIT:
                    running = false;
                    System.out.println("Program finished.");
                    break;
            }
        }

        scanner.close();
    }

}