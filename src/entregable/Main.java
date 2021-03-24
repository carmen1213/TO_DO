package entregable;

import java.util.Scanner;

public class Main {
    static final String JDBC_DRIVER="org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/dam";
    static final String User = "root";
    static final String Pass = "";
        static Tarea tasks[] = new Tarea[50];
        static int noTareas = 0;

        public static void main(String[] args) {

            boolean salir = false;

            while (salir = true) {

                Scanner sc = new Scanner(System.in);
                System.out.println("");
                System.out.println("Elige una opcion");
                System.out.println("");
                System.out.println("1-Crear una nueva Tarea");
                System.out.println("2- Ver tareas");
                System.out.println("3-Completar tareas pendientes");
                System.out.println("4- Salir");

                int a = sc.nextInt();

                switch (a) {
                    case 1:
                        Switch.crearTarea();
                        break;
                    case 2:
                        Switch.leerTareas();
                        break;
                    case 3:
                        Switch.completarTareas();
                        break;
                    case 4:
                        System.out.println("Has decidido Salir.");
                        salir = false;
                        return;
                    default:
                        System.out.println("El numero introducido no corresponde a ningun valor correcto");
                        return;
                }
            }
        }
}


