package co.edu.unab.parra.cristian.reprofunab.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Title implements Serializable{

    private int img;
    private String numero;
    private String nombre;
    private String descripcion;
    private ArrayList<String> preguntas;

    public Title(int img, String numero, String nombre, String descripcion, ArrayList<String> preguntas) {
        this.img = img;
        this.numero = numero;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.preguntas= preguntas;

    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<String> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<String> preguntas) {
        this.preguntas = preguntas;
    }
}

