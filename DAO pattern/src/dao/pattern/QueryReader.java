/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class QueryReader {
    private Map<String, String> queries;
    
    public QueryReader() {
        queries = new HashMap<>();
        InputStream inputStream = QueryReader.class.getResourceAsStream("queries.sql");
        BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));
        
        try {
            String line;
            boolean queryStart = true;
            String queryName = "";
            String queryStatement = "";
            
            while (true) {
                line = input.readLine();
                
                if (line == null)
                    break;
                
                if (line.length() == 0)
                    continue;
                
                if (queryStart) {
                    queryName = line.substring(0, line.indexOf(" "));
                    queryStart = false;
                    continue;
                }
                
                if (line.equals("}")) {
                    queryStatement = queryStatement.trim().replaceAll("\\s+", " ");
                    queries.put(queryName, queryStatement);
                    queryStart = true;
                    queryStatement = "";
                    continue;
                }
                
                queryStatement += line;
            }
        } catch (IOException ex) {
            Logger.getLogger(QueryReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Map<String, String> getQueries() {
        return queries;
    }
    
}
