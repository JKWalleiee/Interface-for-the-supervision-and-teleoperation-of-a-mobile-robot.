package source;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author Carlos Sanchez
 */
public class ConnectDB {
/**
	* Carga el driver para DB MySQL y permite la conexión con la base de datos, recibe la URL donde esta alojada la 
	* DB, contraseña, y usuario de un archivo de texto y retorna una variable tipo statement.
	*
	* @param URL Password User
	* @return DB1Connect.
	*/  
static Connection conn = null;
	public static Statement Connect(){
		 
		 String url = "jdbc:mysql://localhost/robotdb";
		    Connection conn = null;
		    Statement stm=null;
		    try
		    {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver).newInstance();
		    }
		    catch (Exception e)
		    {
			System.out.println("No se  puede cargar el Driver de MYSQL");
			e.printStackTrace();
			
		    }

	    try
	    {
		conn = DriverManager.getConnection(url, "root", "1134");
		stm = conn.createStatement();
		conn.setAutoCommit(false);
	    }
	    catch (Exception e)
	    {
		e.printStackTrace();
	    }

	    
	    return stm;
	}
	public static void CloseDB(){
		
		if(conn!=null)
		{
		 try {conn.close();}
		 catch (Exception e) {e.printStackTrace();}
		}
}
}
