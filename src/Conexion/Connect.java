package Conexion;

import oracle.jdbc.OracleTypes;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class Connect {
    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:DATABASE";
    private static String DB_USER;
    private static String DB_PASSWORD;
    private static Connection connection;

    public Connect(String user,String password){
        DB_USER=user;
        DB_PASSWORD=password;
        connection =getDBConnection();
    };

    private static Connection getDBConnection() {
        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }
    public Connection getConnection(){
        return connection;
    }
    public Boolean isConnected(){
        if(connection == null){
            return false;
        }
        return true;
    }
    public Boolean isAdministrador(){
        CallableStatement callableStatement = null;
        String code = "{call HR.IS_ADMINISTRADOR(?,?)}";
        try{
            callableStatement = connection.prepareCall(code);

            callableStatement.setString(1, DB_USER);
            callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

            callableStatement.executeUpdate();

            ResultSet rs = (ResultSet) callableStatement.getObject(2);

            if(rs.next()){
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public Boolean isParticipante(){
        CallableStatement callableStatement = null;
        String code = "{call HR.IS_PARTICIPANTE(?,?)}";
        try{
            callableStatement = connection.prepareCall(code);

            callableStatement.setString(1, DB_USER);
            callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

            callableStatement.executeUpdate();

            ResultSet rs = (ResultSet) callableStatement.getObject(2);

            if(rs.next()){
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public String getUsername(){
        return DB_USER;
    }
    public void add_telefono(){}
    public void add_administrador(){}
    public void add_participante(){}
    public void mod_usuario(){}

    public void add_subasta(){};
    public void add_oferta(){};
    public void add_comentario_vendedor(){};
    public void add_comentario_comprador(){};

    public ArrayList<String> listar_subcategorias(){};
    public ArrayList<String> listar_categorias(){};

    public ArrayList listar_subasta(){};
    public ArrayList listar_pujas_subasta(){};
    public ArrayList listar_subastas_usuario(){};
    public ArrayList listar_pujas_usuario(){};

    public void mod_porcentaje(){};
    public void mod_minimo(){};
    public ArrayList listar_idsubastas_completas(){};


    /*HR.ADD_TELEFONO(STRING AL,NUMER IN NUMBER)
HR.ADD_ADMINISTRADOR(CED IN NUMBER ,COR IN VARCHAR2 , AL IN VARCHAR2 , NOM IN VARCHAR2 , APE IN VARCHAR2 , DIR IN VARCHAR2, PASS IN CLOB,TEL IN NUMBER)
HR.ADD_PARTICIPANTE(CED IN NUMBER ,COR IN VARCHAR2, AL IN VARCHAR2 , NOM IN VARCHAR2 , APE IN VARCHAR2 , DIR IN VARCHAR2, PASS IN CLOB, TEL IN NUMBER)
HR.MOD_USUARIO(CED IN NUMBER ,COR IN VARCHAR2, NOM IN VARCHAR2 , APE IN VARCHAR2 , DIR IN VARCHAR2)


HR.ADD_ITEM(nom IN VARCHAR2, descr IN VARCHAR2, prim IN VARCHAR2, segu IN VARCHAR2)
HR.ADD_SUBASTA(precIn IN NUMBER,fechaFin IN DATE,descrEntrega IN VARCHAR2,aliasVende IN VARCHAR2,nomItem IN VARCHAR2, descItem IN VARCHAR2, primCat IN VARCHAR2,segCat IN VARCHAR2)
HR.ADD_OFERTA(valorO IN NUMBER, ali IN VARCHAR,subast IN NUMBER)
HR.ADD_COMENTARIO_COMPRADOR(COMM IN VARCHAR,IDSU IN NUMBER)
HR.ADD_COMENTARIO_VENDEDOR(CAL IN NUMBER,COMM IN VARCHAR,IDSU IN NUMBER)
HR.LISTAR_SUBCATEGORIAS(PRIM IN VARCHAR,cur OUT SYS_REFCURSOR)
HR.LISTAR_CATEGORIAS(cur OUT SYS_REFCURSOR)

HR.LISTAR_SUBASTA(prim IN VARCHAR2,segu IN VARCHAR2, cur OUT SYS_REFCURSOR)
HR.LISTAR_PUJAS_SUBASTA(idS IN NUMBER, cur OUT SYS_REFCURSOR)
HR.LISTAR_SUBASTAS_USUARIO(AL IN VARCHAR2, cur OUT SYS_REFCURSOR)
HR.LISTAR_PUJAS_USUARIO(AL IN VARCHAR2, cur OUT SYS_REFCURSOR)
HR.IS_ADMINISTRADOR(AL IN VARCHAR,cur OUT SYS_REFCURSOR)
HR.IS_PARTICIPANTE(AL IN VARCHAR,cur OUT SYS_REFCURSOR)
HR.MOD_PORCENTAJE(N IN NUMBER)
HR.MOD_MINIMO(N IN NUMBER)
HR.LISTAR_IDSUBASTAS_COMPLETAS(cur OUT SYS_REFCURSOR)
*/
}
