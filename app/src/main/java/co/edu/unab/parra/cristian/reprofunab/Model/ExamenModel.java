package co.edu.unab.parra.cristian.reprofunab.Model;
public class ExamenModel {
    private String pregunta;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    private int respuesta;
    private String subopcion1;
    private String subopcion2;
    private String subopcion3;
    private String subopcion4;

    public ExamenModel() {
    }

    public ExamenModel(String pregunta, String opcion1, String opcion2, String opcion3, String opcion4, int respuesta, String subopcion1, String subopcion2, String subopcion3, String subopcion4) {
        this.pregunta = pregunta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.respuesta = respuesta;
        this.subopcion1 = subopcion1;
        this.subopcion2 = subopcion2;
        this.subopcion3 = subopcion3;
        this.subopcion4 = subopcion4;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) { this.opcion4 = opcion4; }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public String getSubopcion1() {
        return subopcion1;
    }

    public void setSubopcion1(String subopcion1) {
        this.subopcion1 = subopcion1;
    }

    public String getSubopcion2() {
        return subopcion2;
    }

    public void setSubopcion2(String subopcion2) {
        this.subopcion2 = subopcion2;
    }

    public String getSubopcion3() {
        return subopcion3;
    }

    public void setSubopcion3(String subopcion3) {
        this.subopcion3 = subopcion3;
    }

    public String getSubopcion4() {
        return subopcion4;
    }

    public void setSubopcion4(String subopcion4) {
        this.subopcion4 = subopcion4;
    }

}

