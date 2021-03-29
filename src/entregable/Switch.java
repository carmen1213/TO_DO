package entregable;

import java.sql.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import entregable.*;

public class Switch {

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/to-do";
    static final String User = "root";
    static final String Pass = "";



    public static void crearTarea() {
        Connection conn = ConexionB();
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribir una nueva Tarea:");
        String titulo = sc.nextLine();

        String sql = "INSERT INTO tarea(Tareas) VALUES(?)";
        PreparedStatement prpStatement;

        try {
            prpStatement = conn.prepareStatement(sql);
            prpStatement.setString(1, titulo);
            ResultSet rs = prpStatement.executeQuery();
            System.out.println("La tarea se creo correctamente");



        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
        }

    }

    static void leerTareas() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, User, Pass);
            stmt = conn.createStatement();
            String sql = "select * from tareas";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                System.out.println(result.getString("Titulo") + "/" + result.getString("Estado"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    static void completarTareas() {

        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        Statement stmt = null;
        System.out.println("Que tarea quiere completar?");
        String Titulo = sc.nextLine();

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, User, Pass);
            stmt = conn.createStatement();
            String sql = "UPDATE tareas SET Estado=?, Fecha = CURRENT_TIMESTAMP WHERE Titulo=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,"Completado");
            preparedStatement.setString(2,Titulo);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                System.out.println(result.getString("Titulo") + "/" + result.getString("Estado"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

        public static Connection ConexionB () {
            Connection conn = null;
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, User, Pass);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
    }
