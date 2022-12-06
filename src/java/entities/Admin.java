/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author RANIA
 */
@Entity
public class Admin extends User implements Serializable{
    
    private String username;

    public Admin() {
    }

    public Admin(String username, String email, String password) {
        super(email, password);
        this.username = username;
    }

    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   
   
 
}
