package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private String description;
    private String startDate;
    private String dueDate;
    List<Employee> teamMembers = new ArrayList<>();

    //setters & getter

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getStartDate(){
        return startDate;
    }

    public void setStartDate(String startDate){
        this.startDate = startDate;
    }
    public String getDueDate(){
        return dueDate;
    }
    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }

    public List<Employee> getTeamMembers(){
        return this.teamMembers;

    }
    public void setTeamMembers(Employee teamMembers){
        this.teamMembers.add(teamMembers);
    }




    //constructors

    public Project(String name, String description, String startDate, String dueDate){
        setName(name);
        setDescription(description);
        setStartDate(startDate);
        setDueDate(dueDate);

    }

}
