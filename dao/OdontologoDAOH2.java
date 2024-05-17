package dao;
import dao.iOdontologoDAO;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OdontologoDAO implements iOdontologoDAO<Odontologo>{

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/parcial_odontologos";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "sa";

    // Creacion de tablas
    private final static String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ODONTOLOGOS"
            + "("
            + "ID INT PRIMARY KEY AUTO_INCREMENT,"
            + "NROMATRICULA INT NOT NULL,"
            + "NOMBRE VARCHAR(25) NOT NULL,"
            + "APELLIDO VARCHAR(25) NOT NULL"
            +");";

    // Guardamos registro
    private final static String SQL_INSERT = "INSERT INTO ODONTOLOGOS (NROMATRICULA, NOMBRE, APELLIDO) values(?,?,?)";

    // Listado
    private final static String SQL_FINDALL = "SELECT * FROM ODONTOLOGOS";

    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);

    public static Connection getConnection()  {
        Connection connection = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            Statement statement = connection.createStatement();
            logger.info("Conexión exitosa");
            statement.execute(SQL_CREATE_TABLE);

        }  catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            logger.error("Error de conexión a la BD");
        }
        return connection;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        PreparedStatement psInsert = null;
        try {
            psInsert = getConnection().prepareStatement(SQL_INSERT);
            psInsert.setInt(1, odontologo.getNumeroMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());

            psInsert.execute();
            logger.info("Se ha guardado correctamente a la matrícula " + odontologo.getNumeroMatricula() + " correspondiente a " + odontologo.getNombre() + odontologo.getApellido() + " en la Base de Datos");
            psInsert.close();
        } catch (SQLExcepetion e) {
            e.printStackTrace();
            logger.error("Error, no se pudo agregar");
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos(){
        PreparedStatement psListarTodos=null;
        List<Odontologo> odontologos= new ArrayList<>();
        Odontologo odontologo= null;

        try{
            psListarTodos= getConnection().prepareStatement(SQL_FINDALL);
            ResultSet rs = psListarTodos.executeQuery();
            while (rs.next()){
                logger.info("Buscando la info del odontólogo: ");

                Double idOdontologo = rs.getDouble(1);
                Integer numeroMatricula = rs.getInt(2);
                String nombre = rs.getString(3);
                String apellido = rs.getString(4);

                odontologo = new Odontologo(idOdontologo, numeroMatricula, nombre, apellido);
                odontologos.add(odontologo);
            }
            logger.info("Lista de odontólogos: "+odontologos);
            psListarTodos.close();
        }catch (SQLException e){
            e.printStackTrace();
            logger.error("Error, no podemos mostrarte los odontólogos.")
        }
        return odontologos;
    }
}


