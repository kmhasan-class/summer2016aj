/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pattern;

/**
 *
 * @author students
 */
public class NewClass {
    private String Address;
    private String Contact;

    public NewClass(String Address, String Contact) {
        this.Address = Address;
        this.Contact = Contact;
    }

    public String getAddress() {
        return Address;
    }

    public String getContact() {
        return Contact;
    }

    @Override
    public String toString() {
        return "NewClass{" + "Address=" + Address + ", Contact=" + Contact + '}';
    }
    
    
    
}
