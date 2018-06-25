package source;
import java.sql.*;
/**
 * @author Carlos Sanchez
 * @author Juan Carlos Noguera
 * @author Jhon Kevin Muñoz
*/
public class SelectUsuario
{
     /**
        *Permite el acceso y seleccion a todos la informacion de todos los usuarios registrados actualmente en la base de datos.
        * Recibe el objeto de conexion a la base de datos y regresa una variable tipo ResultSet.
        *
        * @param stm
        * @return rs
        */
    public static ResultSet SelectR(Statement stm)
    {
    	ResultSet rs = null;
        try
        {
            rs = stm.executeQuery("select id, int_usuarios_tipo_id, nombres, apellidos, email from int_usuarios order by id");


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

			return rs;
    }

     /**
        *Permite el acceso y seleccion de un solo campo de interes relacionado a un usuario de interes de los registrados
        * actualemnte en la base de datos. Recibe el objeto de conexion a la base de datos, el nombre y apellido del usuario
        * de interes y el campo solicitado, y regresa una variable tipo ResultSet.
        *
        * @param stm, nombreU, apellidoU, pedido
        * @return rs
        */
    public static String SelectRunico(Statement stm, String UserEmail, String pedido)
    {
    	String Salida="";
        try
        {
            ResultSet rs = stm.executeQuery("select "+pedido+" from int_usuarios where email='"+UserEmail+"'");

            while(rs.next())
            {


            Salida = rs.getString(pedido);


            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return Salida;
    }

    /**
        *Permite el acceso, seleccion, adicion, actualizacion y borrado de los horarios programados de un usuario en especifico para un proceso especifico.
        *Recibe el objeto de conexion, la accion a realizar, el proceso de interes, el ID del usuario de interes, y la fecha, horario incial y horario
        * final a actualizar. Regresa una variable tipo ResultSet.
        *
        * @param stm, accion, procesoD, IDUsuario
        * @return rs
        */

    public static ResultSet Programacion(Statement stm, int accion, String procesoD, String IDUsuario)
    {
    	ResultSet rs = null;
        String FechaT = "0000-00-00";
        String HoraInicio = "00:00:00";
        String HoraFinal = "00:00:00";
        switch(accion)
        {
        case 1:
           try
            {
                rs = stm.executeQuery("select UP.id, UP.int_proceso_id, UP.int_usuarios_id, UP.fecha, UP.hora_inicio, UP.hora_fin, U.nombres, U.apellidos, IP.nombre from int_usuarios_proceso UP, int_usuarios U, int_proceso IP where IP.id="+procesoD+" and IP.id=UP.int_proceso_id and UP.int_usuarios_id=U.id and U.id='"+IDUsuario+"'");

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            break;

        case 2:
            try
            {
                //stm.executeUpdate("insert into int_usuarios_proceso set int_proceso_id="+procesoD+", int_usuarios_id="+IDUsuario+", fecha='"+FechaT+"', hora_inicio='"+HoraInicio+"', hora_fin='"+HoraFinal+"', hits=1");
            	 stm.executeUpdate("insert into int_usuarios_proceso set int_proceso_id="+procesoD+", int_usuarios_id="+IDUsuario+", fecha='"+FechaT+"', hora_inicio='"+HoraInicio+"', hora_fin='"+HoraFinal+"'");

            	//  System.out.println("Filas Afectadas (INSERT): "+InsertRows);
            }
             catch (Exception e)
            {
            e.printStackTrace();
            }
            break;

        case 3:
            try
            {
                stm.executeUpdate("update int_usuarios_proceso set hora_inicio='"+HoraInicio+"', hora_fin='"+HoraFinal+"' where int_proceso_id="+procesoD+" and int_usuarios_id="+IDUsuario+" and fecha='"+FechaT+"'");
          //    System.out.println("Filas Afectadas (INSERT): "+updateRows);
            }
             catch (Exception e)
            {
            e.printStackTrace();
            }
            break;

        case 4:
            try
            {
              stm.executeUpdate("delete from int_usuarios_proceso where int_proceso_id="+procesoD+" and int_usuarios_id="+IDUsuario+" and fecha='"+FechaT+"'");
              //System.out.println("Filas Afectadas (INSERT): "+DeleteRows);
            }
             catch (Exception e)
            {
            e.printStackTrace();
            }
            break;

        }
        return rs;
    }
}
