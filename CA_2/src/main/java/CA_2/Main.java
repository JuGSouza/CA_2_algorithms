package CA_2;

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
}