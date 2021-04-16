package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private Map<String, Project> projects = new HashMap<>();

    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {


        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!
        employees.get(1).raiseSalary(10.0);

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        Department marketing = new Department(1, "Marketing");
        departments.add(marketing);
        Department sales = new Department(2, "Sales");
        departments.add(sales);
        Department engineering = new Department(3, "Engineering");
        departments.add(engineering);


    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for(Department department : departments){
            System.out.println(department.getName());
        }

    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {

        Employee employee = new Employee();
        employee.setEmployeeId(1);
        employee.setFirstName("Dean");
        employee.setLastName("Johnson");
        employee.setEmail("djohnson@teams.com");
        employee.setDepartment(departments.get(2));
        employee.setHireDate("08/21/2020");
        employees.add(employee);

        employees.add(new Employee(2,"Angie", "Smith",
                "asmith@team.com", departments.get(2), "08/21/2020"));

        employees.add(new Employee(3, "Margaret", "Thompson", "mthompson@teams.com",
                departments.get(0), "08/21/2020"));

    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        for(Employee employeeTemp : employees){
            System.out.println(employeeTemp.getFullName() + " (" + employeeTemp.getSalary() + ") " + employeeTemp.getDepartment().getName());
        }

    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {

        Project projectOne = new Project("TEams","Project Management Software", "10/10/2020", "11/10/2020");
                for(Employee employeeVar : employees){
                    if(departments.get(2).equals(employeeVar.getDepartment() ) ){
                        projectOne.setTeamMembers(employeeVar);
                    }
        }
                projects.put(projectOne.getName(), projectOne);

    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {

        Project projectTwo = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing",
                "10/10/2020", "10/17/2020");
        for (Employee employeeVar : employees) {
            if (departments.get(0).equals(employeeVar.getDepartment())) {
                projectTwo.setTeamMembers(employeeVar);
            }
        }
        projects.put(projectTwo.getName(), projectTwo);
    }


    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport(){
        System.out.println("\n------------- PROJECTS ------------------------------");
        for(Map.Entry<String, Project> entry : projects.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getTeamMembers().size());
        }
        }

    }

