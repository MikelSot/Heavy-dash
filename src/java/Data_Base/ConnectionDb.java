
package Data_Base;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionDb {
    
    private static final String SQLserver_DB ="jdbc:sqlserver://localhost:1433;databaseName=Heavy";
    private static final String SQLserve_USER ="me";
    private static final String SQLserver_PASSWORD ="miguel10@(8)";
    private static final String SQLserver_NAME ="com.microsoft.sqlserver.jdbc.SQLServerDriver";

        
   
    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        try {
            Class.forName(SQLserver_NAME);
            connection = DriverManager.getConnection(SQLserver_DB,SQLserve_USER,SQLserver_PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDb.class.getName()).log(Level.SEVERE, null, ex);            
        }
            return connection;
    }
    

    public static void processEception(SQLException e){
        System.err.println("Error ***>>>"+ e.getMessage());
        System.err.println("code ***>>>"+ e.getErrorCode());
        System.err.println("SQL state ***>>>"+ e.getSQLState());
    }
    

    public static void close(ResultSet resultSet){        
        try {
            resultSet.close();
        } catch (SQLException e) {
            processEception(e);
        }           
    }
    
    public static void close(PreparedStatement preparedStatement){
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            processEception(e);
        }
    }
    
 
    
    public static void close(Connection connection){
        
        try {
            connection.close();
        } catch (SQLException e) {
            processEception(e);
        }
    }
    
     public static void close(CallableStatement callableStatement){
        
        try {
            callableStatement.close();
        } catch (SQLException e) {
            processEception(e);
        }
    }
    
    
    
    
}
