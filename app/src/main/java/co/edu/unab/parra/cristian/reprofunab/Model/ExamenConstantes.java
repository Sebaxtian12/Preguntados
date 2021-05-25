package co.edu.unab.parra.cristian.reprofunab.Model;

import android.provider.BaseColumns;

public final class ExamenConstantes {
    private ExamenConstantes() {
    }
    public static class PreguntasTable implements BaseColumns {
        public static final String TABLE_NAME = "examen_preguntas";
        public static final String COLUMN_PREGUNTA = "pregunta";
        public static final String COLUMN_OPCION1 = "opcion1";
        public static final String COLUMN_OPCION2 = "opcion2";
        public static final String COLUMN_OPCION3 = "opcion3";
        public static final String COLUMN_OPCION4 = "opcion4";
        public static final String COLUMN_RESPUESTA = "respuesta";
        public static final String COLUMN_SUBOPCION1 = "subopcion1";
        public static final String COLUMN_SUBOPCION2 = "subopcion2";
        public static final String COLUMN_SUBOPCION3 = "subopcion3";
        public static final String COLUMN_SUBOPCION4 = "subopcion4";

    }
}

