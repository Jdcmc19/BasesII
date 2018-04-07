package Conexion;

import Conexion.Clases.Comentario;
import Conexion.Clases.Puja;
import Conexion.Clases.Subasta;
import Conexion.Clases.Usuario;
import oracle.jdbc.OracleTypes;


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
        connection = getDBConnection();
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
    public Boolean isConnected(){
        if(connection == null){
            return false;
        }
        return true;
    }
    public Boolean isAdministrador(){
        CallableStatement callableStatement = null;
        connection = getDBConnection();
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
        connection=getDBConnection();
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
    public Boolean add_telefono(String alias,int numero)throws SQLException {
        CallableStatement callableStatement = null;
        connection = getDBConnection();

        String code = "{call HR.ADD_TELEFONO2(?,?,?)}";

        try {
            callableStatement = connection.prepareCall(code);

            callableStatement.setString(1, alias);
            callableStatement.setInt(2, numero);
            callableStatement.registerOutParameter(3,OracleTypes.NUMBER);

            callableStatement.execute();
            int result=callableStatement.getInt(3);
            if(result==1)
                return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return false;
    }
    public Boolean add_administrador(Usuario user,int telefono)throws SQLException{
        CallableStatement callableStatement = null;
        connection = getDBConnection();

        int cedula = user.getCedula();
        String corr = user.getCorreo();
        String alias = user.getAlias();
        String nombre = user.getNombre();
        String apellido = user.getApellido();
        String dir = user.getDireccion();
        String passw = user.getPass();


        String code = "{call HR.ADD_ADMINISTRADOR(?,?,?,?,?,?,?,?,?)}";

        try {
            callableStatement = connection.prepareCall(code);

            callableStatement.setInt(1, cedula);
            callableStatement.setString(2, corr);
            callableStatement.setString(3, alias);
            callableStatement.setString(4, nombre);
            callableStatement.setString(5, apellido);
            callableStatement.setString(6, dir);
            callableStatement.setString(7, passw);
            callableStatement.setInt(8, telefono);

            callableStatement.registerOutParameter(9,OracleTypes.NUMBER);

            callableStatement.execute();
            int result=callableStatement.getInt(9);
            if(result==1)
                return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return false;
    }
    public Boolean add_participante(Usuario user,int telefono)throws SQLException{
        CallableStatement callableStatement = null;
        connection = getDBConnection();

        int cedula = user.getCedula();
        String corr = user.getCorreo();
        String alias = user.getAlias();
        String nombre = user.getNombre();
        String apellido = user.getApellido();
        String dir = user.getDireccion();
        String passw = user.getPass();


        String code = "{call HR.ADD_PARTICIPANTE(?,?,?,?,?,?,?,?,?)}";

        try {
            callableStatement = connection.prepareCall(code);

            callableStatement.setInt(1, cedula);
            callableStatement.setString(2, corr);
            callableStatement.setString(3, alias);
            callableStatement.setString(4, nombre);
            callableStatement.setString(5, apellido);
            callableStatement.setString(6, dir);
            callableStatement.setString(7, passw);
            callableStatement.setInt(8, telefono);

            callableStatement.registerOutParameter(9,OracleTypes.NUMBER);

            callableStatement.execute();
            int result=callableStatement.getInt(9);
            if(result==1)
                return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return false;
    }
    public void mod_usuario(Usuario user)throws SQLException{
        CallableStatement callableStatement = null;
        connection = getDBConnection();

        int cedula = user.getCedula();
        String corr = user.getCorreo();
        String nombre = user.getNombre();
        String apellido = user.getApellido();
        String dir = user.getDireccion();


        String code = "{call HR.MOD_USUARIO(?,?,?,?,?)}";

        try {
            callableStatement = connection.prepareCall(code);

            callableStatement.setInt(1, cedula);
            callableStatement.setString(2, corr);
            callableStatement.setString(3, nombre);
            callableStatement.setString(4, apellido);
            callableStatement.setString(5, dir);


            callableStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
    }

    public void add_subasta(Subasta subasta)throws SQLException{
        CallableStatement callableStatement = null;
        connection = getDBConnection();

        BigDecimal precioInicial=subasta.getPrecioInicial();
        Timestamp fechaFin=subasta.getFechaFinal();
        String descEntrega=subasta.getDescripcionEntrega();
        String aliasVendedor=subasta.getAliasVendedor();
        String nombreItem=subasta.getNombreItem();
        String descItem=subasta.getDescItem();
        String primCat=subasta.getPrimCat();
        String segCat=subasta.getSegCat();

        String code = "{call HR.ADD_SUBASTA(?,?,?,?,?,?,?,?)}";

        try {
            callableStatement = connection.prepareCall(code);

            callableStatement.setBigDecimal(1, precioInicial);
            callableStatement.setTimestamp(2, fechaFin);
            callableStatement.setString(3, descEntrega);
            callableStatement.setString(4, aliasVendedor);
            callableStatement.setString(5, nombreItem);
            callableStatement.setString(6, descItem);
            callableStatement.setString(7, primCat);
            callableStatement.setString(8, segCat);

            callableStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
    };
    public Boolean add_oferta(Puja puja)throws SQLException{
        CallableStatement callableStatement = null;
        connection = getDBConnection();

        BigDecimal valorO=puja.getValorOferta();
        String alias = puja.getAlias();
        int idsubasta= puja.getId();


        String code = "{call HR.ADD_OFERTA(?,?,?,?)}";

        try {
            callableStatement = connection.prepareCall(code);

            callableStatement.setBigDecimal(1, valorO);
            callableStatement.setString(2, alias);
            callableStatement.setInt(3, idsubasta);
            callableStatement.registerOutParameter(4,OracleTypes.NUMBER);

            callableStatement.execute();
            int result=callableStatement.getInt(4);
            if(result==1)
                return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return false;
    };
    public void add_comentario_vendedor(int calificacion,String comentario,int idSubasta)throws SQLException{
        CallableStatement callableStatement = null;
        connection = getDBConnection();

        String code = "{call HR.ADD_COMENTARIO_VENDEDOR(?,?,?)}";

        try {
            callableStatement = connection.prepareCall(code);

            callableStatement.setInt(1, calificacion);
            callableStatement.setString(2, comentario);
            callableStatement.setInt(3, idSubasta);


            callableStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
    };
    public void add_comentario_comprador(String comentario,int idSubasta)throws SQLException{
        CallableStatement callableStatement = null;
        connection = getDBConnection();

        String code = "{call HR.ADD_COMENTARIO_COMPRADOR(?,?)}";

        try {
            callableStatement = connection.prepareCall(code);

            callableStatement.setString(1, comentario);
            callableStatement.setInt(2, idSubasta);


            callableStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
    };

    public ArrayList<String> listar_subcategorias(String primaria)throws SQLException{
        ArrayList<String> subcategorias = new ArrayList<>();

        CallableStatement callableStatement = null;
        connection=getDBConnection();
        String code = "{call HR.LISTAR_SUBCATEGORIAS(?,?)}";
        try{
            callableStatement = connection.prepareCall(code);

            callableStatement.setString(1, primaria);
            callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

            callableStatement.executeUpdate();

            ResultSet rs = (ResultSet) callableStatement.getObject(2);

            while (rs.next()){
                subcategorias.add(rs.getString(1));
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return subcategorias;

    };
    public ArrayList<String> listar_categorias()throws SQLException{
        ArrayList<String> categorias = new ArrayList<>();

        CallableStatement callableStatement = null;
        connection=getDBConnection();
        String code = "{call HR.LISTAR_CATEGORIAS(?)}";
        try{
            callableStatement = connection.prepareCall(code);

            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);

            callableStatement.executeUpdate();

            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                categorias.add(rs.getString(1));
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return categorias;

    };

    public ArrayList<Subasta> listar_subasta(String primCat,String segCat)throws SQLException{
        ArrayList<Subasta> consulta = new ArrayList<>();

        CallableStatement callableStatement = null;
        connection=getDBConnection();
        String code = "{call HR.LISTAR_SUBASTA(?,?,?)}";
        try{
            callableStatement = connection.prepareCall(code);

            callableStatement.setString(1,primCat);
            callableStatement.setString(2,segCat);
            callableStatement.registerOutParameter(3, OracleTypes.CURSOR);

            callableStatement.executeUpdate();

            ResultSet rs = (ResultSet) callableStatement.getObject(3);

            int idSubasta;
            BigDecimal precioInicial;
            Timestamp fechaFinal;
            String descEntrega;
            String aliasUsuario;
            String itemNombre;

            while (rs.next()){
                idSubasta = rs.getInt(1);
                precioInicial = rs.getBigDecimal(2);
                fechaFinal = rs.getTimestamp(3);
                descEntrega = rs.getString(4);
                aliasUsuario = rs.getString(5);
                itemNombre = rs.getString(6);
                Subasta s = new Subasta(precioInicial,fechaFinal,descEntrega,aliasUsuario,itemNombre,"","","",idSubasta);
                consulta.add(s);
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return consulta;
    };
    public ArrayList<Puja> listar_pujas_subasta(int idSubasta)throws SQLException{
        ArrayList<Puja> consulta = new ArrayList<>();

        CallableStatement callableStatement = null;
        connection=getDBConnection();
        String code = "{call HR.LISTAR_PUJAS_SUBASTA(?,?)}";
        try{
            callableStatement = connection.prepareCall(code);

            callableStatement.setInt(1,idSubasta);
            callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

            callableStatement.executeUpdate();

            ResultSet rs = (ResultSet) callableStatement.getObject(2);

            int id;
            BigDecimal valoroferta;
            Timestamp fecha;
            String aliasUsuario;
            String itemNombre;

            while (rs.next()){
                id = rs.getInt(1);
                fecha = rs.getTimestamp(2);
                valoroferta = rs.getBigDecimal(3);
                aliasUsuario = rs.getString(4);
                itemNombre = rs.getString(5);
                Puja s = new Puja(valoroferta,aliasUsuario,id,itemNombre,fecha);
                consulta.add(s);
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return consulta;
    };
    public ArrayList<Comentario> listar_subastas_usuario(String alias)throws SQLException{
        ArrayList<Comentario> consulta = new ArrayList<>();

        CallableStatement callableStatement = null;
        connection=getDBConnection();
        String code = "{call HR.LISTAR_SUBASTAS_USUARIO(?,?)}";
        try{
            callableStatement = connection.prepareCall(code);

            callableStatement.setString(1,alias);
            callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

            callableStatement.executeUpdate();

            ResultSet rs = (ResultSet) callableStatement.getObject(2);


            String itemNombre;
            BigDecimal precioInicial;
            BigDecimal valoroferta;
            String comentario;

            while (rs.next()){
                itemNombre = rs.getString(1);
                precioInicial = rs.getBigDecimal(2);
                valoroferta = rs.getBigDecimal(3);
                comentario = rs.getString(4);
                Comentario s = new Comentario(itemNombre,precioInicial,valoroferta,comentario);
                consulta.add(s);
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return consulta;
    };
    public ArrayList<Comentario> listar_pujas_usuario(String alias)throws SQLException{
        ArrayList<Comentario> consulta = new ArrayList<>();

        CallableStatement callableStatement = null;
        connection=getDBConnection();
        String code = "{call HR.LISTAR_PUJAS_USUARIO(?,?)}";
        try{
            callableStatement = connection.prepareCall(code);

            callableStatement.setString(1,alias);
            callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

            callableStatement.executeUpdate();

            ResultSet rs = (ResultSet) callableStatement.getObject(2);


            String itemNombre;
            BigDecimal precioInicial;
            BigDecimal valoroferta;
            String comentario;

            while (rs.next()){
                itemNombre = rs.getString(1);
                precioInicial = rs.getBigDecimal(2);
                valoroferta = rs.getBigDecimal(3);
                comentario = rs.getString(4);
                Comentario s = new Comentario(itemNombre,precioInicial,valoroferta,comentario);
                consulta.add(s);
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return consulta;
    };

    public void mod_porcentaje(int porcen)throws SQLException{
        ArrayList<Comentario> consulta = new ArrayList<>();

        CallableStatement callableStatement = null;
        connection=getDBConnection();
        String code = "{call HR.MOD_PORCENTAJE(?)}";
        try{
            callableStatement = connection.prepareCall(code);

            callableStatement.setInt(1,porcen);

            callableStatement.executeUpdate();

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
    };
    public void mod_minimo(int minim)throws SQLException{
        ArrayList<Comentario> consulta = new ArrayList<>();

        CallableStatement callableStatement = null;
        connection=getDBConnection();
        String code = "{call HR.MOD_MINIMO(?)}";
        try{
            callableStatement = connection.prepareCall(code);

            callableStatement.setInt(1,minim);

            callableStatement.executeUpdate();

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
    };
    public ArrayList<Integer> listar_idsubastas_completas()throws SQLException{
        ArrayList<Integer> consulta = new ArrayList<>();

        CallableStatement callableStatement = null;
        connection=getDBConnection();
        String code = "{call HR.LISTAR_IDSUBASTAS_COMPLETAS(?)}";
        try{
            callableStatement = connection.prepareCall(code);

            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);

            callableStatement.executeUpdate();

            ResultSet rs = (ResultSet) callableStatement.getObject(1);

            while (rs.next()){
                consulta.add(rs.getInt(1));
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return consulta;
    };
    public ArrayList<Integer> listar_idsubastas_vendedor(String alias)throws SQLException{
        ArrayList<Integer> consulta = new ArrayList<>();

        CallableStatement callableStatement = null;
        connection=getDBConnection();
        String code = "{call HR.LISTAR_IDSUBASTAS_VENDEDOR(?,?)}";
        try{
            callableStatement = connection.prepareCall(code);

            callableStatement.setString(1,alias);
            callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

            callableStatement.executeUpdate();

            ResultSet rs = (ResultSet) callableStatement.getObject(2);

            while (rs.next()){
                consulta.add(rs.getInt(1));
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return consulta;
    };
    public ArrayList<Integer> listar_idsubastas_comprador(String alias)throws SQLException{
        ArrayList<Integer> consulta = new ArrayList<>();

        CallableStatement callableStatement = null;
        connection=getDBConnection();
        String code = "{call HR.LISTAR_IDSUBASTAS_COMPRADOR(?,?)}";
        try{
            callableStatement = connection.prepareCall(code);

            callableStatement.setString(1,alias);
            callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

            callableStatement.executeUpdate();

            ResultSet rs = (ResultSet) callableStatement.getObject(2);

            while (rs.next()){
                consulta.add(rs.getInt(1));
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return consulta;
    };
    public ArrayList<Integer> add_imagen(String nombre,String path)throws SQLException{
        ArrayList<Integer> consulta = new ArrayList<>();

        CallableStatement callableStatement = null;
        connection=getDBConnection();
        String code = "{call HR.ADD_IMAGEN(?,?)}";
        try{
            callableStatement = connection.prepareCall(code);

            callableStatement.setString(1,nombre);
            callableStatement.setString(2, path);

            callableStatement.executeUpdate();

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return consulta;
    };
    public String get_imagen(String nombre)throws SQLException{
        ArrayList<Integer> consulta = new ArrayList<>();

        CallableStatement callableStatement = null;
        connection=getDBConnection();
        String code = "{call HR.GET_IMAGEN(?,?)}";
        try{
            callableStatement = connection.prepareCall(code);

            callableStatement.setString(1,nombre);
            callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

            callableStatement.executeUpdate();

            ResultSet rs = (ResultSet) callableStatement.getObject(2);

            while (rs.next()){
                return rs.getString(1);
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return null;
    };
    /*
HR.ADD_ADMINISTRADOR(CED IN NUMBER ,COR IN VARCHAR2 , AL IN VARCHAR2 , NOM IN VARCHAR2 , APE IN VARCHAR2 , DIR IN VARCHAR2, PASS IN CLOB,TEL IN NUMBER)
HR.ADD_PARTICIPANTE(CED IN NUMBER ,COR IN VARCHAR2, AL IN VARCHAR2 , NOM IN VARCHAR2 , APE IN VARCHAR2 , DIR IN VARCHAR2, PASS IN CLOB, TEL IN NUMBER)
HR.MOD_USUARIO(CED IN NUMBER ,COR IN VARCHAR2, NOM IN VARCHAR2 , APE IN VARCHAR2 , DIR IN VARCHAR2)

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
