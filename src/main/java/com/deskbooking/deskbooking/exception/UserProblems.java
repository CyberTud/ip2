package com.deskbooking.deskbooking.exception;

public class UserProblems extends Exception{
    public UserProblems(){
        super("The user does not exist");
    }
}
