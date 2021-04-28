package co.edu.unab.parra.cristian.reprofunab.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class TitleModel implements Serializable{

    private final int img;
    private final String numero;
    private final String nombre;
    private final String descripcion;
    private final ArrayList<String> preguntas;

    public TitleModel(int img, String numero, String nombre, String descripcion, ArrayList<String> preguntas) {
        this.img = img;
        this.numero = numero;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.preguntas= preguntas;

    }

    public int getImg() {
        return img;
    }


    public String getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public ArrayList<String> getPreguntas() {
        return preguntas;
    }
}

