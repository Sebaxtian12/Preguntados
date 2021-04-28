package co.edu.unab.parra.cristian.reprofunab.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AyudaModel {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> p1 = new ArrayList<String>();
        p1.add("Establece las directrices eticas y normas de trabajo del cuerpo docente de la UNAB.");

        List<String> p2 = new ArrayList<String>();
        p2.add("Esta app se realizó con el fin de promulgar de una manera dinámica el reglamento de docentes");

        List<String> p3 = new ArrayList<String>();
        p3.add("Pueden ser docentes asociados, asistente o títular (ningún profesor podrá ingresar a la UNAB con esta categoría)  ");

        List<String> p4 = new ArrayList<String>();
        p4.add("El documento oficial expedido por la universidad para establecer las reglas de trabajo y penalizaciones del cuerpo docente");

        List<String> p5 = new ArrayList<String>();
        p5.add("Sí, la información presentada en el aplicativo es fiable al contenido del reglamento oficial, sólo difiere en su extensión");


        expandableListDetail.put("¿Cuál es el objetivo del Reglamento del profesorado?", p1);
        expandableListDetail.put("¿Por qué este aplicativo?", p2);
        expandableListDetail.put("¿Cuáles son las caracteristicas del docente UNAB?", p3);
        expandableListDetail.put("¿Qué es el reglamento docente?", p4);
        expandableListDetail.put("¿Es fiable el contenido presentado en la app?", p5);

        return expandableListDetail;
    }
}