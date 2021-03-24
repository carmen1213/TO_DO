package entregable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Fecha {

        public static String CrearFecha(Date fecha) {
            DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            //System.out.println(hourdateFormat.format(fecha));
            return hourdateFormat.format(fecha);
        }

        public static Date leerFecha(String fecha) {
            try {
                Date date1=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(fecha);
                return date1;
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

