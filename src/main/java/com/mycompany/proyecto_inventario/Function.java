package com.mycompany.proyecto_inventario;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Function {

    //Atributos para la conexión a la base de datos.
    private static final String JDBC_DRIVER = "com.ibm.db2.jcc.DB2Driver";
    private static final String DB_URL = "jdbc:db2://localhost:25000/INV_DB";
    private static final String USER = "Usuario";
    private static final String PASS = "admin123";

    //Getters.
    public String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASS() {
        return PASS;
    }

    //CREATES.
    public void create_rol() {

    }

    public void create_privilegio() {

    }

    public void create_usuario(String usuario_unico, String clave) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_usuario_create (?, ?)}")) {
            stmt.setString(1, usuario_unico);
            stmt.setString(2, clave);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace(); //Sería bueno agregar un mensaje diciendo que no se pudo crear el usuario por ejemplo.
        }
    }

    public String read_usuario() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_usuario_read}")) {
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                String usuario_unico = rs.getString("usuario_unico");
                String clave = rs.getString("clave");
                sb.append("Usuario único: ").append(usuario_unico).append(", Clave: ").append(clave).append("\n");
            }
            return sb.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void create_cliente() {

    }

    public void create_proveedor() {

    }

    public void create_telefono() {

    }

    public void create_ajuste() {

    }

    public void create_factura() {

    }

    public void create_compra() {

    }

    public void create_producto() {

    }

    public void create_detalle_factura() {

    }

    public void create_detalle_ajuste() {

    }

    public void create_detalle_compra() {

    }

    //UPDATES
    public void update_rol() {

    }

    public void update_privilegio() {

    }

    public void update_usuario() {

    }

    public void update_cliente() {

    }

    public void update_proveedor() {

    }

    public void update_telefono() {

    }

    public void update_ajuste() {

    }

    public void update_factura() {

    }

    public void update_compra() {

    }

    public void update_producto() {

    }

    public void update_detalle_factura() {

    }

    public void update_detalle_ajuste() {

    }

    public void update_detalle_compra() {

    }

    //READ
    public void read_rol() {

    }

    public void read_privilegio() {

    }

    /*
    public void read_usuario(){
        
    }
     */
    public void read_cliente() {

    }

    public void read_proveedor() {

    }

    public void read_telefono() {

    }

    public void read_ajuste() {

    }

    public void read_factura() {

    }

    public void read_compra() {

    }

    public void read_producto() {

    }

    public void read_detalle_factura() {

    }

    public void read_detalle_ajuste() {

    }

    public void read_detalle_compra() {

    }

    //DELETE.
    public boolean delete_rol(int id_rol) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_rol_delete(?)}")) {
            stmt.setInt(1, id_rol);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
        return false;
    }

    public boolean delete_privilegio(int id_privilegio_delete) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_privilegio_delete(?)}")) {
            stmt.setInt(1, id_privilegio_delete);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
        return false;
    }

    public boolean delete_usuario(String usuario_unico) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_usuario_delete(?)}")) {
            stmt.setString(1, usuario_unico);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
        return false;
    }

    public boolean delete_cliente(int id_cliente) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_cliente_delete(?)}")) {
            stmt.setInt(1, id_cliente);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
        return false;
    }

    public boolean delete_proveedor(int codigo_proveedor) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_proveedor_delete(?)}")) {
            stmt.setInt(1, codigo_proveedor);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
        return false;
    }

    public void delete_telefono() {

    }

    public boolean delete_ajuste(int id_ajuste) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_ajuste_delete(?)}")) {
            stmt.setInt(1, id_ajuste);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
        return false;
    }

    public boolean delete_factura(int numero_factura) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_factura_delete(?)}")) {
            stmt.setInt(1, numero_factura);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
        return false;
    }

    public boolean delete_compra(int id_compra) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_compra_delete(?)}")) {
            stmt.setInt(1, id_compra);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
        return false;
    }

    public boolean delete_producto(int codigo_producto) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_producto_delete(?)}")) {
            stmt.setInt(1, codigo_producto);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
        return false;
    }

    public void delete_detalle_factura() {

    }

    public void delete_detalle_ajuste() {

    }

    public void delete_detalle_compra() {

    }

}
