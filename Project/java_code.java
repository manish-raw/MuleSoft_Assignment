// 1.Created Database moviesdb

package database;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception
    {
    	String url = "jdbc:mysql://localhost:3306/";
        String uname = "root";
        String pass = "Manish32!@";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(url, uname, pass);
                Statement stmt = conn.createStatement();
             ) {		      
                String sql = "CREATE DATABASE moviesdb";
                stmt.executeUpdate(sql);
                System.out.println("Database created successfully...");   	  
             } catch (SQLException e) {
                e.printStackTrace();
             } 
        
        
    }
}


// 2.Inserted Table 

package database;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception
    {
    	String url = "jdbc:mysql://localhost:3306/moviesdb";
        String uname = "root";
        String pass = "Manish32!@";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(url, uname, pass);
                Statement stmt = conn.createStatement();
             ) {		      
        	String sql = "CREATE TABLE MOVIES " +
                    "(idmovies INTEGER not NULL, " +
                    " movie_name VARCHAR(45) not NULL, " + 
                    " movie_actor VARCHAR(45) not NULL, " + 
                    " movie_actoress VARCHAR(45) not NULL, " + 
                    " movie_director VARCHAR(45) not NULL, " +
                    " PRIMARY KEY ( idmovies ))"; 

                stmt.executeUpdate(sql);
                System.out.println("Created table in given database...");   	  
             } catch (SQLException e) {
                e.printStackTrace();
             } 
        
        
    }
}

// 3. query the movie details (name, actor, actress, director, year of release) using a SELECT statement

package database;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/moviesdb";
        String uname = "root";
        String pass = "Manish32!@";
        String query = "select * from movies where movie_actor= 'Tom Hardy' ";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st= con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        String userData = "";
        while(rs.next()) {
        	userData = rs.getInt(1)+ " : " + rs.getString(2)+" - " + rs.getString(3)
        	+" - " + rs.getString(4)+" - "+ rs.getString(5) +" - " + rs.getDate("movie_yor");
        	System.out.println(userData);
        }
        
        
        st.close();
        con.close();
    }
}



// 4. a query with parameter like actor name to select movies based on the actor's name.


package database;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/moviesdb";
        String uname = "root";
        String pass = "Manish32!@";
        String query = "select * from movies where movie_actor= 'Tom Hardy' ";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st= con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        String name =rs.getInt(1)+ " : " + rs.getString(2)+" - " + rs.getString(3)
        			+" - " + rs.getString(4)+" - "+ rs.getString(5) +" - " + rs.getDate("movie_yor");        
        System.out.println(name);
        st.close();
        con.close();
    }
}




