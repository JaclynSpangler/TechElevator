package com.techelevator;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;
    private Department department;
    private String hireDate;

    private static final double STARTING_SALARY = 60000;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return STARTING_SALARY;
    }

    public void setSalary(double salary) {
        this.salary = STARTING_SALARY;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getFullName() {
        return lastName + ", " + firstName;
    }

    public Employee(long employeeId, String firstName, String lastName,
                    String email, Department department, String hireDate) {
        setFirstName(firstName);
        setEmployeeId(employeeId);
        setLastName(lastName);
        setEmail(email);
        setDepartment(department);
        setHireDate(hireDate);

    }

    public Employee() {

    }

    public void raiseSalary(double percent) {
        salary += salary * (percent / 100);
    }


}


