/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json.parsing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

/**
 *
 * @author kmhasan
 */
public class JSONParsing {

    public JSONParsing() throws JSONException {
        JSONObject jsonObject;
        try {
            RandomAccessFile input = new RandomAccessFile("student.json", "r");
            String line;
            String jsonString = "";
            
            while ((line = input.readLine()) != null) {
                jsonString = jsonString + line.trim();
            }
            
            jsonObject = new JSONObject(jsonString);
            String name = (String) jsonObject.get("name");
            String id = (String) jsonObject.get("id");
            Student student = new Student(id, name);
            System.out.println(student);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSONParsing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSONParsing.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JSONException {
        new JSONParsing();
    }
    
}
