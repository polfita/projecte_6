package concesionario_guadalupe_fernandez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class concesionario_guadalupe_fernandez {

    static final String DB_URL = "jdbc:mysql://localhost:3306/Concesionario_Guadalupe_Fernandez";
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "userBD";
    static final String DB_PASSWD = "userBD";
    static Connection connection = null;
    static Statement statement = null;

    public static void CrearConnexio() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void pdConsultaVehiculos() {
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM vehiculos");
            while (resultSet.next()) {
                System.out.printf("%d\t%s\t%s\t%s\t%d\t%.2f\t%d\n",
                        resultSet.getInt("id"),
                        resultSet.getString("tipo"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getInt("anio"),
                        resultSet.getFloat("precio"),
                        resultSet.getInt("cantidad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void pdInsertarVehiculos(String stipo, String smarca, String smodelo, int ianio, float fprecio, int icantidad) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO vehiculos (tipo, marca, modelo, anio, precio, cantidad) VALUES ('" 
                    + stipo + "','" + smarca + "', '" + smodelo + "'," + ianio + "," + fprecio + "," + icantidad + ")");
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void pdModificarVehiculos(int id, String stipo, String smarca, String smodelo, int ianio, float fprecio, int icantidad) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE vehiculos SET tipo='" + stipo + "', marca='" + smarca + "', modelo='" + smodelo + 
                    "', anio=" + ianio + ", precio=" + fprecio + ", cantidad=" + icantidad + " WHERE id=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void pdEliminarVehiculos(int id) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM vehiculos WHERE id=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void elegirTabla(String operacion) {
        System.out.println("- Escoge una tabla:");
        System.out.println("1. Vehiculos");
        System.out.println("2. Clientes");
        System.out.println("3. Empleados");
        System.out.println("4. Proveedores");
        System.out.println("5. Ventas");

        int tabla = sc.nextInt();
        switch (tabla) {
            case 1:
                if (operacion.equals("insertar")) {
                    insertarVehiculo();
                } else if (operacion.equals("modificar")) {
                    modificarVehiculo();
                } else if (operacion.equals("eliminar")) {
                    eliminarVehiculo();
                }
                break;
            case 2:
                if (operacion.equals("insertar")) {
                    insertarCliente();
                } else if (operacion.equals("modificar")) {
                    modificarCliente();
                } else if (operacion.equals("eliminar")) {
                    eliminarCliente();
                }
                break;
            case 3:
                if (operacion.equals("insertar")) {
                    insertarEmpleado();
                } else if (operacion.equals("modificar")) {
                    modificarEmpleado();
                } else if (operacion.equals("eliminar")) {
                    eliminarEmpleado();
                }
                break;
            case 4:
                if (operacion.equals("insertar")) {
                    insertarProveedor();
                } else if (operacion.equals("modificar")) {
                    modificarProveedor();
                } else if (operacion.equals("eliminar")) {
                    eliminarProveedor();
                }
                break;
            case 5:
                if (operacion.equals("insertar")) {
                    insertarVenta();
                } else if (operacion.equals("modificar")) {
                    modificarVenta();
                } else if (operacion.equals("eliminar")) {
                    eliminarVenta();
                }
                break;
            default:
                System.out.println("Tabla no valida.");
                break;
        }
    }

    public static void insertarVehiculo() {
        System.out.print("Introduce el tipo: ");
        String tipo = sc.next();
        System.out.print("Introduce la marca: ");
        String marca = sc.next();
        System.out.print("Introduce el modelo: ");
        String modelo = sc.next();
        System.out.print("Introduce el anio: ");
        int anio = sc.nextInt();
        System.out.print("Introduce el precio: ");
        float precio = sc.nextFloat();
        System.out.print("Introduce la cantidad: ");
        int cantidad = sc.nextInt();
        pdInsertarVehiculos(tipo, marca, modelo, anio, precio, cantidad);
    }

    public static void modificarVehiculo() {
        System.out.print("Introduce el ID del vehiculo: ");
        int id = sc.nextInt();
        System.out.print("Introduce el tipo: ");
        String tipo = sc.next();
        System.out.print("Introduce la marca: ");
        String marca = sc.next();
        System.out.print("Introduce el modelo: ");
        String modelo = sc.next();
        System.out.print("Introduce el anio: ");
        int anio = sc.nextInt();
        System.out.print("Introduce el precio: ");
        float precio = sc.nextFloat();
        System.out.print("Introduce la cantidad: ");
        int cantidad = sc.nextInt();
        pdModificarVehiculos(id, tipo, marca, modelo, anio, precio, cantidad);
    }

    public static void eliminarVehiculo() {
        System.out.print("Introduce el ID del vehiculo: ");
        int id = sc.nextInt();
        pdEliminarVehiculos(id);
    }

    public static void insertarCliente() {
        System.out.print("Introduce el nombre: ");
        String nombre = sc.next();
        System.out.print("Introduce la direccion: ");
        String direccion = sc.next();
        System.out.print("Introduce el telefono: ");
        String telefono = sc.next();
        System.out.print("Introduce el email: ");
        String email = sc.next();
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO clientes (nombre, direccion, telefono, email) VALUES ('" 
                    + nombre + "','" + direccion + "', '" + telefono + "', '" + email + "')");
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void modificarCliente() {
        System.out.print("Introduce el ID del cliente: ");
        int id = sc.nextInt();
        System.out.print("Introduce el nombre: ");
        String nombre = sc.next();
        System.out.print("Introduce la direccion: ");
        String direccion = sc.next();
        System.out.print("Introduce el telefono: ");
        String telefono = sc.next();
        System.out.print("Introduce el email: ");
        String email = sc.next();
        try {
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE clientes SET nombre='" + nombre + "', direccion='" + direccion + "', telefono='" 
                    + telefono + "', email='" + email + "' WHERE id=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void eliminarCliente() {
        System.out.print("Introduce el ID del cliente: ");
        int id = sc.nextInt();
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM clientes WHERE id=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertarEmpleado() {
        System.out.print("Introduce el nombre: ");
        String nombre = sc.next();
        System.out.print("Introduce la posicion: ");
        String posicion = sc.next();
        System.out.print("Introduce el salario: ");
        float salario = sc.nextFloat();
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO empleados (nombre, posicion, salario) VALUES ('" 
                    + nombre + "','" + posicion + "', " + salario + ")");
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void modificarEmpleado() {
        System.out.print("Introduce el ID del empleado: ");
        int id = sc.nextInt();
        System.out.print("Introduce el nombre: ");
        String nombre = sc.next();
        System.out.print("Introduce la posicion: ");
        String posicion = sc.next();
        System.out.print("Introduce el salario: ");
        float salario = sc.nextFloat();
        try {
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE empleados SET nombre='" + nombre + "', posicion='" + posicion + "', salario=" 
                    + salario + " WHERE id=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void eliminarEmpleado() {
        System.out.print("Introduce el ID del empleado: ");
        int id = sc.nextInt();
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM empleados WHERE id=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertarProveedor() {
        System.out.print("Introduce el nombre: ");
        String nombre = sc.next();
        System.out.print("Introduce la direccion: ");
        String direccion = sc.next();
        System.out.print("Introduce el telefono: ");
        String telefono = sc.next();
        System.out.print("Introduce el email: ");
        String email = sc.next();
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO proveedores (nombre, direccion, telefono, email) VALUES ('" 
                    + nombre + "','" + direccion + "', '" + telefono + "', '" + email + "')");
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void modificarProveedor() {
        System.out.print("Introduce el ID del proveedor: ");
        int id = sc.nextInt();
        System.out.print("Introduce el nombre: ");
        String nombre = sc.next();
        System.out.print("Introduce la direccion: ");
        String direccion = sc.next();
        System.out.print("Introduce el telefono: ");
        String telefono = sc.next();
        System.out.print("Introduce el email: ");
        String email = sc.next();
        try {
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE proveedores SET nombre='" + nombre + "', direccion='" + direccion + "', telefono='" 
                    + telefono + "', email='" + email + "' WHERE id=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void eliminarProveedor() {
        System.out.print("Introduce el ID del proveedor: ");
        int id = sc.nextInt();
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM proveedores WHERE id=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertarVenta() {
        System.out.print("Introduce el ID del vehiculo: ");
        int id_vehiculo = sc.nextInt();
        System.out.print("Introduce el ID del cliente: ");
        int id_cliente = sc.nextInt();
        System.out.print("Introduce el ID del empleado: ");
        int id_empleado = sc.nextInt();
        System.out.print("Introduce la fecha (YYYY-MM-DD): ");
        String fecha = sc.next();
        System.out.print("Introduce la cantidad: ");
        int cantidad = sc.nextInt();
        System.out.print("Introduce el total: ");
        float total = sc.nextFloat();
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO ventas (id_vehiculo, id_cliente, id_empleado, fecha, cantidad, total) VALUES (" 
                    + id_vehiculo + "," + id_cliente + "," + id_empleado + ",'" + fecha + "'," + cantidad + "," + total + ")");
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void modificarVenta() {
        System.out.print("Introduce el ID de la venta: ");
        int id = sc.nextInt();
        System.out.print("Introduce el ID del vehiculo: ");
        int id_vehiculo = sc.nextInt();
        System.out.print("Introduce el ID del cliente: ");
        int id_cliente = sc.nextInt();
        System.out.print("Introduce el ID del empleado: ");
        int id_empleado = sc.nextInt();
        System.out.print("Introduce la fecha (YYYY-MM-DD): ");
        String fecha = sc.next();
        System.out.print("Introduce la cantidad: ");
        int cantidad = sc.nextInt();
        System.out.print("Introduce el total: ");
        float total = sc.nextFloat();
        try {
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE ventas SET id_vehiculo=" + id_vehiculo + ", id_cliente=" + id_cliente + ", id_empleado=" 
                    + id_empleado + ", fecha='" + fecha + "', cantidad=" + cantidad + ", total=" + total + " WHERE id=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void eliminarVenta() {
        System.out.print("Introduce el ID de la venta: ");
        int id = sc.nextInt();
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM ventas WHERE id=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        CrearConnexio();
        int opcionUsuario = 0;
        do {
            System.out.println("- Escoge una opcion: ");
            System.out.println("1. Insertar datos");
            System.out.println("2. Modificar datos");
            System.out.println("3. Eliminar datos");
            System.out.println("4. Consultar datos");
            System.out.println("5. Salir");

            System.out.print("¿Que opcion deseas escoger?: ");
            opcionUsuario = sc.nextInt();

            switch (opcionUsuario) {
                case 1:
                    elegirTabla("insertar");
                    break;
                case 2:
                    elegirTabla("modificar");
                    break;
                case 3:
                    elegirTabla("eliminar");
                    break;
                case 4:
                    pdConsultaVehiculos();
                    break;
                case 5:
                    TancarConnexio();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del 1 al 5.");
                    break;
            }
        } while (opcionUsuario != 5);
    }
    
    public static void TancarConnexio() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
