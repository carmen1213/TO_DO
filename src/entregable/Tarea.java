package entregable;

import java.util.Date;
public class Tarea {

        private Date fecha;
        private String titulo;
        private boolean estado;

        public Tarea(Date Fecha, String Titulo, boolean Estado) {
            this.fecha=Fecha;
            this.titulo=Titulo;
            this.estado=Estado;
        }

        public Date getFecha() {
            return fecha;
        }
        public String getTitulo() {
            return titulo;
        }
        public boolean getEstado() {
            return estado;
        }

        public void setFecha(Date Fecha) {
            this.fecha=Fecha;

        }
        public void setTitulo(String Titulo) {
            this.titulo=Titulo;

        }
        public void setEstado(boolean Estado) {
            this.estado=Estado;

        }

        public String toString () {
            return titulo + " " + fecha + " " + estado;
        }


    }


