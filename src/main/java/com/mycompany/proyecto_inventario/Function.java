package com.mycompany.proyecto_inventario;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

public class Function {

    //Atributos para la conexión a la base de datos.
    private static final String JDBC_DRIVER = "com.ibm.db2.jcc.DB2Driver";
    private static final String DB_URL = "jdbc:db2://localhost:25000/INV_DB";
    private static final String USER = "Usuario";
    private static final String PASS = "admin123";
    private Random random;

    public Function() {
        random = new Random();
    }

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
    public boolean create_rol(int id_rol, String nombre) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_rol_create (?, ?)}")) {
            stmt.setInt(1, id_rol);
            stmt.setString(2, nombre);
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean create_privilegio(int id_privilegio, String nombre) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_privilegio_create (?, ?)}")) {
            stmt.setInt(1, id_privilegio);
            stmt.setString(2, nombre);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("NO SE HA CONECTADO A PRIVILEGIO!");
        }
        return false;
    }

    public boolean create_usuario(String usuario_unico, String clave) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_usuario_create (?, ?)}")) {
            stmt.setString(1, usuario_unico);
            stmt.setString(2, clave);
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace(); //Sería bueno agregar un mensaje diciendo que no se pudo crear el usuario por ejemplo.
        }
        return false;
    }

    public boolean create_cliente(int id_cliente, String nombre, String fecha_creacion, String usuario_creo) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_cliente_create (?, ?, ?, ?)}")) {
            stmt.setInt(1, id_cliente);
            stmt.setString(2, nombre);
            stmt.setString(3, fecha_creacion);
            stmt.setString(4, usuario_creo);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("NO SE HA CONECTADO A CLIENTE!");
            System.out.println("Mensaje de excepción: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean create_proveedor(int codigo_proveedor, String nombre, String nombre_contacto_principal, String estado, String direccion, String fecha_creacion, String usuario_creo) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_proveedor_create (?, ?, ?, ?, ?, ?, ?)}")) {
            stmt.setInt(1, codigo_proveedor);
            stmt.setString(2, nombre);
            stmt.setString(3, nombre_contacto_principal);
            stmt.setString(4, estado);
            stmt.setString(5, direccion);
            stmt.setString(6, fecha_creacion);
            stmt.setString(7, usuario_creo);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("NO SE HA CONECTADO A PROVEEDOR!");
            System.out.println("Mensaje de excepción: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public void create_telefono() {

    }

    public void create_ajuste() {

    }

    /*
    public void create_factura() {

    }
     */
    public void create_compra() {

    }

    public boolean create_producto(int codigo_producto, String categoria, String estado, String existencia, double precio, String marca, double costo, String nombre, String fecha_creacion, String usuario_creo) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_producto_create (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}")) {
            stmt.setInt(1, codigo_producto);
            stmt.setString(2, categoria);
            stmt.setString(3, estado);
            stmt.setString(4, existencia);
            stmt.setDouble(5, precio);
            stmt.setString(6, marca);
            stmt.setDouble(7, costo);
            stmt.setString(8, nombre);
            stmt.setString(9, fecha_creacion);
            stmt.setString(10, usuario_creo);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("NO SE HA CONECTADO A PRODUCTO!");
            System.out.println("Mensaje de excepción: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
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

    public int generarID_ROL() {
        // Generamos un número aleatorio entre 1 y 1000
        int numeroAleatorio = random.nextInt(998) + 100;
        int cantidad_registros = 0;

        try (Connection conn = DriverManager.getConnection(this.getDB_URL(), this.getUSER(), this.getPASS()); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM \"USUARIO\".\"rol\"")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cantidad_registros = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("No se ha conectado!");
        }

        return cantidad_registros + 1 + numeroAleatorio;
    }

    public int generarID_PRIVILEGIO() {
        // Generamos un número aleatorio entre 1 y 1000
        int numeroAleatorio = random.nextInt(998) + 100;
        int cantidad_registros = 0;

        try (Connection conn = DriverManager.getConnection(this.getDB_URL(), this.getUSER(), this.getPASS()); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM \"USUARIO\".\"privilegio\"")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cantidad_registros = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("No se ha conectado!");
        }

        return cantidad_registros + 1 + numeroAleatorio;
    }

    public int generarID_CLIENTE() {
        // Generamos un número aleatorio entre 1 y 1000
        int numeroAleatorio = random.nextInt(998) + 100;
        int cantidad_registros = 0;

        try (Connection conn = DriverManager.getConnection(this.getDB_URL(), this.getUSER(), this.getPASS()); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM \"USUARIO\".\"cliente\"")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cantidad_registros = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("No se ha conectado!");
        }

        return cantidad_registros + 1 + numeroAleatorio;
    }

    public int generarID_PRODUCTO() {
        // Generamos un número aleatorio entre 1 y 1000
        int numeroAleatorio = random.nextInt(998) + 100;
        int cantidad_registros = 0;

        try (Connection conn = DriverManager.getConnection(this.getDB_URL(), this.getUSER(), this.getPASS()); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM \"USUARIO\".\"producto\"")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cantidad_registros = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("No se ha conectado!");
        }

        return cantidad_registros + 1 + numeroAleatorio;
    }

    public int generarID_PROVEEDOR() {
        // Generamos un número aleatorio entre 1 y 1000
        int numeroAleatorio = random.nextInt(998) + 100;
        int cantidad_registros = 0;

        try (Connection conn = DriverManager.getConnection(this.getDB_URL(), this.getUSER(), this.getPASS()); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM \"USUARIO\".\"proveedor\"")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cantidad_registros = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("No se ha conectado!");
        }

        return cantidad_registros + 1 + numeroAleatorio;
    }

    // Función que retorna la fecha actual en el formato deseado.
    public String getFormattedDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(now);
        return formattedDate;
    }

    // Funciones para trabaajr con las facturas.
    public boolean createFactura(int numero_factura, int id_cliente, int descuento, double subtotal, double total, int impuesto, String fecha, String fecha_creacion, String usuario_creo) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_factura_create (?, ?, ?, ?, ?, ?, ?, ?, ?)}")) {
            stmt.setInt(1, numero_factura);
            stmt.setInt(2, id_cliente);
            stmt.setInt(3, descuento);
            stmt.setDouble(4, subtotal);
            stmt.setDouble(5, total);
            stmt.setInt(6, impuesto);
            stmt.setString(7, fecha);
            stmt.setString(8, fecha_creacion);
            stmt.setString(9, usuario_creo);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("NO SE HA CONECTADO A FACTURA!");
            System.out.println("Mensaje de excepción: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean createDetalle_Factura(int numero_detalle_factura, int numero_factura, int codigo_producto, double precio_venta, int cantidad, double subtotal) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_detalle_factura_create (?, ?, ?, ?, ?, ?)}")) {
            stmt.setInt(1, numero_detalle_factura);
            stmt.setInt(2, numero_factura);
            stmt.setInt(3, codigo_producto);
            stmt.setDouble(4, precio_venta);
            stmt.setInt(5, cantidad);
            stmt.setDouble(6, subtotal);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("NO SE HA CONECTADO A FACTURA!");
            System.out.println("Mensaje de excepción: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public int generarNumeroFactura() {
        // Generamos un número aleatorio entre 1 y 1000
        int numeroAleatorio = random.nextInt(998) + 100;
        int cantidad_registros = 0;

        try (Connection conn = DriverManager.getConnection(this.getDB_URL(), this.getUSER(), this.getPASS()); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM \"USUARIO\".\"factura\"")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cantidad_registros = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("No se ha conectado!");
        }

        return cantidad_registros + 10000 + numeroAleatorio;
    }

    public double getPrecioProducto(int codigo_producto) {
        double precio = 0;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); PreparedStatement stmt = conn.prepareStatement("SELECT \"USUARIO\".\"producto\".\"precio\" FROM \"USUARIO\".\"producto\" WHERE \"codigo_producto\" = ?")) {

            stmt.setInt(1, codigo_producto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                precio = rs.getDouble("precio");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return precio;
    }

    public int generarNumero_DETALLE_FACTURA() {

        int cantidad_registros = 0;

        try (Connection conn = DriverManager.getConnection(this.getDB_URL(), this.getUSER(), this.getPASS()); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM \"USUARIO\".\"detalle_factura\"")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cantidad_registros = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("No se ha conectado!");
        }

        return cantidad_registros + 1;
    }

    // Funciones para trabaajr con las compras.
    public boolean createCompra(int id_compra, int codigo_proveedor, String fecha_compra, String fabricante, String total, String fecha_creacion, String usuario_creo) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_compra_create (?, ?, ?, ?, ?, ?, ?)}")) {
            stmt.setInt(1, id_compra);
            stmt.setInt(2, codigo_proveedor);
            stmt.setString(3, fecha_compra);
            stmt.setString(4, fabricante);
            stmt.setString(5, total);
            stmt.setString(6, fecha_creacion);
            stmt.setString(7, usuario_creo);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("NO SE HA CONECTADO A COMPRA!");
            System.out.println("Mensaje de excepción: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean createDetalle_COMPRA(int numero_detalle_compra, int id_compra, int codigo_producto, String costo_compra, String subtotal, String cantidad) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_detalle_compra_create (?, ?, ?, ?, ?, ?)}")) {
            stmt.setInt(1, numero_detalle_compra);
            stmt.setInt(2, id_compra);
            stmt.setInt(3, codigo_producto);
            stmt.setString(4, costo_compra);
            stmt.setString(5, subtotal);
            stmt.setString(6, cantidad);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("NO SE HA CONECTADO A DETALLE_COMPRA!");
            System.out.println("Mensaje de excepción: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public int generarNumero_DETALLE_COMPRA() {

        int cantidad_registros = 0;

        try (Connection conn = DriverManager.getConnection(this.getDB_URL(), this.getUSER(), this.getPASS()); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM \"USUARIO\".\"detalle_compra\"")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cantidad_registros = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("No se ha conectado!");
        }

        return cantidad_registros + 1;
    }

    public int generarNumeroCompra() {
        // Generamos un número aleatorio entre 1 y 1000
        int numeroAleatorio = random.nextInt(998) + 100;
        int cantidad_registros = 0;

        try (Connection conn = DriverManager.getConnection(this.getDB_URL(), this.getUSER(), this.getPASS()); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM \"USUARIO\".\"compra\"")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cantidad_registros = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("No se ha conectado!");
        }

        return cantidad_registros + 10000 + numeroAleatorio;
    }

    //AJUSTES.
    // Funciones para trabajar con los ajustes.
    public boolean createAjuste(int id_ajuste, String fecha, String entrada, String salida, String fecha_creacion, String usuario_creo) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_ajuste_create (?, ?, ?, ?, ?, ?)}")) {
            stmt.setInt(1, id_ajuste);
            stmt.setString(2, fecha);
            stmt.setString(3, entrada);
            stmt.setString(4, salida);
            stmt.setString(5, fecha_creacion);
            stmt.setString(6, usuario_creo);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("NO SE HA CONECTADO A AJUSTES!");
            System.out.println("Mensaje de excepción: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean createDetalle_AJUSTE(int numero_detalle_ajuste, int id_ajuste, int codigo_producto, double coste_producto, int cantidad, double subtotal) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); CallableStatement stmt = conn.prepareCall("{call sp_detalle_ajuste_create (?, ?, ?, ?, ?, ?)}")) {
            stmt.setInt(1, numero_detalle_ajuste);
            stmt.setInt(2, id_ajuste);
            stmt.setInt(3, codigo_producto);
            stmt.setDouble(4, coste_producto);
            stmt.setInt(5, cantidad);
            stmt.setDouble(6, subtotal);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("NO SE HA CONECTADO A DETALLE_AJUSTE!");
            System.out.println("Mensaje de excepción: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public int generarNumero_DETALLE_AJUSTES() {

        int cantidad_registros = 0;

        try (Connection conn = DriverManager.getConnection(this.getDB_URL(), this.getUSER(), this.getPASS()); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM \"USUARIO\".\"detalle_ajuste\"")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cantidad_registros = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("No se ha conectado!");
        }

        return cantidad_registros + 1;
    }

    public int generarNumeroAjuste() {
        // Generamos un número aleatorio entre 1 y 1000
        int numeroAleatorio = random.nextInt(998) + 100;
        int cantidad_registros = 0;

        try (Connection conn = DriverManager.getConnection(this.getDB_URL(), this.getUSER(), this.getPASS()); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM \"USUARIO\".\"ajuste\"")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cantidad_registros = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("No se ha conectado!");
        }

        return cantidad_registros + 10000 + numeroAleatorio;
    }

    public void callProductoUpdate(int codigoProducto, String categoria, String estado, String existencia, double precio, String marca, double costo, String nombre, String fechaUltimaActualizacion, String usuarioActualizo) throws SQLException {
        Connection conn = DriverManager.getConnection(getDB_URL(), getUSER(), getPASS());
        CallableStatement stmt = conn.prepareCall("{call sp_producto_update(?,?,?,?,?,?,?,?,?,?)}");

        stmt.setInt(1, codigoProducto);
        stmt.setString(2, categoria);
        stmt.setString(3, estado);
        stmt.setString(4, existencia);
        stmt.setDouble(5, precio);
        stmt.setString(6, marca);
        stmt.setDouble(7, costo);
        stmt.setString(8, nombre);
        stmt.setString(9, fechaUltimaActualizacion);
        stmt.setString(10, usuarioActualizo);

        stmt.execute();
        stmt.close();
        conn.close();
    }

    public void actualizaProductos_detalles(int codigo_producto_act, boolean tipo, int cantidad) {
        //Cargamos la tabla.
        try (Connection conn = DriverManager.getConnection(getDB_URL(), getUSER(), getPASS()); CallableStatement stmt = conn.prepareCall("{call sp_producto_read}")) {
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();

            String codigo_producto;
            String categoria;
            String estado;
            String existencia;
            String precio;
            String marca;
            String costo;
            String nombre;
            String fecha_creacion;
            String fecha_ultimma_actualizacion;
            String usuario_creo;
            String usuario_actualizo;
            int nuevaExistencia = 0;
            String nuevaExistencia_str = "";

            while (rs.next()) {
                codigo_producto = rs.getString(1);
                categoria = rs.getString(2);
                estado = rs.getString(3);
                existencia = rs.getString(4);
                precio = rs.getString(5);
                marca = rs.getString(6);
                costo = rs.getString(7);
                nombre = rs.getString(8);
                fecha_creacion = rs.getString(9);
                fecha_ultimma_actualizacion = rs.getString(10);
                usuario_creo = rs.getString(11);
                usuario_actualizo = rs.getString(12);

                nuevaExistencia = Integer.parseInt(existencia);

                if (Integer.toString(codigo_producto_act).equals(codigo_producto)) {
                    if (tipo) { //Entrada - compra
                        nuevaExistencia = nuevaExistencia + cantidad;
                        nuevaExistencia_str = String.valueOf(nuevaExistencia);
                        this.callProductoUpdate(codigo_producto_act, categoria, estado, nuevaExistencia_str, codigo_producto_act, marca, codigo_producto_act, nombre, fecha_ultimma_actualizacion, usuario_actualizo);
                    } else { // Salida - factura
                        nuevaExistencia = nuevaExistencia - cantidad;
                        nuevaExistencia_str = String.valueOf(nuevaExistencia);
                        this.callProductoUpdate(codigo_producto_act, categoria, estado, nuevaExistencia_str, codigo_producto_act, marca, codigo_producto_act, nombre, fecha_ultimma_actualizacion, usuario_actualizo);
                    }
                }

            }

        } catch (SQLException e) {
            System.out.println("No se ha conectado!");
        }
    }

}
