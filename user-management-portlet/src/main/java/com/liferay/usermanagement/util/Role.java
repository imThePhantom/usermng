package com.liferay.usermanagement.util;

public enum Role {
        
    STAFF("Staff"),
    SUBLEADER("SubLeader"),
    LEADER("Leader");
    
    private String role;
    
    Role(String role){
	this.role = role;
    }
    public String toString(){
	return role;
    }
}
