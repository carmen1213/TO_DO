package entregable;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class Switch {


    static void crearTarea() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribir una nueva Tarea:");
        String tarea = sc.nextLine();
        Main.tasks[Main.noTareas++] = new Tarea(new Date(), tarea, false);
    }

    static void leerTareas() {
        System.out.println("Tareas Pendientes");
        for (int i = 0; i < Main.noTareas; i++) {
            if (Main.tasks[i].getEstado() == false) {
                System.out.println(Main.tasks[i]);
            }
        }
        System.out.println("Tareas Completadas");
        for (int i = 0; i < Main.noTareas; i++) {
            if (Main.tasks[i].getEstado() == true) {
                System.out.println(Main.tasks[i]);
            }
        }

    }

    static void completarTareas() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el titulo de la tarea que quieras completar:");
        String tareaACompletar = sc.nextLine();
        for (int i = 0; i < Main.noTareas; i++) {
            if (Main.tasks[i].getTitulo().equals(tareaACompletar)) {
                Main.tasks[i].setEstado(true);
            }
        }


    }
}