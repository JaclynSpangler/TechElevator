package com.techelevator;

public class Department {

    private int departmentId;
    private String name;

    public int getDepartmentId(){
        return departmentId;
    }

    public String getName(){
        return name;
    }
    public void setDepartmentld(int departmentId){
        this.departmentId = departmentId;
    }
    public void setName(String name){
        this.name = name;
    }
    public Department(int departmentId, String name){
        setDepartmentld(departmentId);
        setName(name);
    }
}
