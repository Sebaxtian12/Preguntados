package co.edu.unab.parra.cristian.reprofunab.Adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import co.edu.unab.parra.cristian.reprofunab.Model.ExamenConstantes.*;
import co.edu.unab.parra.cristian.reprofunab.Model.ExamenModel;

import java.util.ArrayList;
import java.util.List;

public class ExamenDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NOMBRE = "asasas.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;
    public ExamenDBHelper(Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                PreguntasTable.TABLE_NAME + " ( " +
                PreguntasTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PreguntasTable.COLUMN_PREGUNTA + " TEXT, " +
                PreguntasTable.COLUMN_OPCION1 + " TEXT, " +
                PreguntasTable.COLUMN_OPCION2 + " TEXT, " +
                PreguntasTable.COLUMN_OPCION3 + " TEXT, " +
                PreguntasTable.COLUMN_OPCION4 + " TEXT, " +
                PreguntasTable.COLUMN_RESPUESTA + " INTEGER," +
                PreguntasTable.COLUMN_SUBOPCION1 + " TEXT," +
                PreguntasTable.COLUMN_SUBOPCION2 + " TEXT, " +
                PreguntasTable.COLUMN_SUBOPCION3 + " TEXT, " +
                PreguntasTable.COLUMN_SUBOPCION4 + " TEXT " + ")" ;
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        LlenarPreguntasTable();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PreguntasTable.TABLE_NAME);
        onCreate(db);
    }
    private void LlenarPreguntasTable() {
        ExamenModel p1 = new ExamenModel("Dada las siguientes opciones. Todo aspirante UNAB debe cumplir con:",
                "A", "B", "C", "D", 3,
                "Una beca o cualquier garant??a de que termine la carrera con ??xito",
                "Un desempe??o alto y certificado que demuestre sus aptitudes para pertenecer a la instituci??n",
                "Cumplir con los tramites, ce??irse al modelo educativo y plan curricular",
                "Debe de tener una certificaci??n de una instituci??n educativa que demuestre estar listo para desarrollar su conocimiento dentro de la instituci??n");
        addPregunta(p1);
        ExamenModel p2 = new ExamenModel("La UNAB aceptara a todo solicitante que:",
                "A", "B", "C", "D", 2,
                "Sea recomendado por un directivo o personal de la instituci??n universitaria",
                "Cumpla con los requisitos de la ley y los establecidos por la instituci??n durante el proceso de admisi??n",
                "No haya cancelado su proceso de admisi??n",
                "Cumpla con los requisitos de la ley y no tenga antecedentes de mala conducta");
        addPregunta(p2);
        ExamenModel p3 = new ExamenModel("El aspirante admitido adquiere el rol de:",
                "A", "B", "C", "D", 1,
                "Estudiante activo", "Personal UNAB",
                "Estudiante de pregrado UNAB",
                "Persona UNAB");
        addPregunta(p3);
        ExamenModel p4 = new ExamenModel("Una vez el aspirante sea admitido deber??:",
                "A", "B", "C", "D", 3,
                "Renovar su matr??cula cada a??o ",
                "Renovar su matr??cula cada final de semestre ",
                "Renovar su matr??cula seg??n el crono grama acad??mico",
                "Renovar su matr??cula cada que el director de programa establezca las fechas");
        addPregunta(p4);
        ExamenModel p5 = new ExamenModel("Todo estudiante UNAB sea nacional o extranjero, deber??:",
                "A", "B", "C", "D", 4,
                "Elegir entre las normas de la UNAB o las normas de su lugar local para cumplirlas",
                "Acatar las normas de la instituci??n siempre y cuando estas no contradigan las normas del lugar en donde el estudiante procede",
                "Acatar las normas del lugar donde proviene cada estudiante y la instituci??n deber?? ser flexible a cualquiera de ellas",
                "Acatar las normas y reglamentos de la instituci??n por encima de cualquier otra que no sobreexceda la constituci??n");
        addPregunta(p5);

        ExamenModel p6 = new ExamenModel("Uno de los principios para la aplicaci??n de las sanciones disciplinarias es:",
                "A", "B", "C", "D", 3,
                "Ser el proceso educativo una construcci??n equitativa fundada en la parcialidad, en la injusticia, y en el respeto a la dignidad humana.",
                "Falsificar o adulterar cualquier documento de la UNAB",
                "La proporcionalidad entre la falta y la sanci??n.",
                "La autorizaci??n de todo tipo de responsabilidad objetiva.");
        addPregunta(p6);
        ExamenModel p7 = new ExamenModel("Seleccione la falta calificada como grav??sima:",
                "A", "B", "C", "D", 1,
                "Hacer plagio o fraude acad??mico en el desarrollo o presentaci??n de trabajos de grado o los productos derivados del mismo.",
                "Incurrir en fraude acad??mico o plagio en cualquier tipo de evaluaci??n, trabajo o actividad acad??mica.",
                "La ausencia, el incumplimiento o el cambio no autorizado de actividades acad??micas programadas en los diferentes escenarios de pr??ctica.",
                "Cualquier conducta de acoso sobre un miembro de la comunidad acad??mica o personal al servicio de la Universidad que no est?? determinada como grav??sima. ");
        addPregunta(p7);
        ExamenModel p8 = new ExamenModel("Seleccione la falta calificada como grave:",
                "A", "B", "C", "D", 2,
                "Hacer plagio o fraude acad??mico en el desarrollo o presentaci??n de trabajos de grado o los productos derivados del mismo",
                "Causar da??os intencionales a los bienes muebles o inmuebles de la UNAB, de los escenarios de pr??ctica, o de los lugares en que se realicen actividades acad??micas",
                "Cualquier conducta destinada a desacatar la sanci??n disciplinaria o a burlar sus efectos.",
                "Falsificar o adulterar cualquier documento de la UNAB.");
        addPregunta(p8);
        ExamenModel p9 = new ExamenModel("Una de las sanciones para una falta calificada como grav??sima es:",
                "A", "B", "C", "D", 2,
                "Calificaci??n de cero, cero (0.0) en el curso.",
                "Expulsi??n de la Universidad que significa la p??rdida inmediata y definitiva de su condici??n de estudiante de la UNAB.",
                "Suspensi??n inmediata de estudios hasta por dos (2) per??odos acad??micos regulares consecutivos.",
                "Amonestaci??n privada acompa??ada de un compromiso firmado por el estudiante con copia a la hoja de vida.");
        addPregunta(p9);
        ExamenModel p10 = new ExamenModel("Una de las sanciones para una falta calificada como grave es:",
                "A", "B", "C", "D", 1,
                "Calificaci??n de cero, cero (0.0) en el curso.",
                "Revocatoria del t??tulo acad??mico otorgado.",
                "Amonestaci??n verbal con compromiso firmado por el estudiante y sin anotaci??n en la hoja de vida.",
                "P??rdida del derecho a matricularse en cualquiera de los programas acad??micos.");
        addPregunta(p10);
        ExamenModel p11 = new ExamenModel("Una de las sanciones para una falta calificada como leve es:",
                "A", "B", "C", "D", 3,
                "Calificaci??n de cero, cero (0.0) en la prueba",
                "Revocatoria del t??tulo acad??mico otorgado.",
                "Amonestaci??n privada acompa??ada de un compromiso firmado por el estudiante con copia a la hoja de vida.",
                "Suspensi??n inmediata de estudios hasta por dos (2) per??odos acad??micos regulares consecutivos.");
        addPregunta(p11);
        ExamenModel p12 = new ExamenModel("Procedimiento disciplinario para falta considerada como grave o grav??sima:",
                "A", "B", "C", "D", 2,
                "El fallo en primera instancia es de competencia del Consejo Acad??mico de la Universidad.",
                "El fallo en primera instancia es de competencia del Consejo de Facultad.",
                "En la etapa de investigaci??n y fallo, la competencia corresponder?? al Consejo de Facultad.",
                "En segunda instancia, del Consejo de Facultad.");
        addPregunta(p12);
        ExamenModel p13 = new ExamenModel("Procedimiento disciplinario para falta considerada como leve:",
                "A", "B", "C", "D", 1,
                "En segunda instancia, del Consejo de Facultad.",
                "El fallo de segunda instancia, en caso de apelaci??n, es de competencia privativa del Consejo Acad??mico de la Universidad.",
                "El fallo en primera instancia es de competencia del Consejo de Facultad.",
                "En la etapa de investigaci??n y fallo, la competencia corresponder?? al Consejo de Facultad.");
        addPregunta(p13);
        ExamenModel p14 = new ExamenModel("Principio de procedimiento disciplinario que la Universidad hace cumplir al estudiante disciplinado:",
                "A", "B", "C", "D", 2,
                "La imposibilidad de designar apoderado o la de estar acompa??ado del mismo en todos los tr??mites disciplinarios",
                "El traslado al imputado de todas y cada una de las pruebas que fundamentan los cargos formulados.",
                "La posibilidad de que el disciplinado no pueda controvertir, ninguna de las decisiones de las autoridades competentes.",
                "La formulaci??n de los cargos imputados, en la que no consten las faltas disciplinarias.");
        addPregunta(p14);
        ExamenModel p15 = new ExamenModel("Un requisitos m??nimos para decisi??n que dispone la apertura de la investigaci??n:",
                "A", "B", "C", "D", 2,
                "La relaci??n de los hechos conocidos que dieron lugar a la apertura de la investigaci??n.",
                "Respuesta A, C y D.",
                "La relaci??n de las pruebas en que se sustentan dichos hechos y la de aquellas cuya pr??ctica se ordena.",
                "La identidad del posible autor o autores.");
        addPregunta(p15);
    }
    private void addPregunta(ExamenModel pregunta) {
        ContentValues cv = new ContentValues();
        cv.put(PreguntasTable.COLUMN_PREGUNTA, pregunta.getPregunta());
        cv.put(PreguntasTable.COLUMN_OPCION1, pregunta.getOpcion1());
        cv.put(PreguntasTable.COLUMN_OPCION2, pregunta.getOpcion2());
        cv.put(PreguntasTable.COLUMN_OPCION3, pregunta.getOpcion3());
        cv.put(PreguntasTable.COLUMN_OPCION4, pregunta.getOpcion4());
        cv.put(PreguntasTable.COLUMN_RESPUESTA, pregunta.getRespuesta());
        cv.put(PreguntasTable.COLUMN_SUBOPCION1, pregunta.getSubopcion1());
        cv.put(PreguntasTable.COLUMN_SUBOPCION2, pregunta.getSubopcion2());
        cv.put(PreguntasTable.COLUMN_SUBOPCION3, pregunta.getSubopcion3());
        cv.put(PreguntasTable.COLUMN_SUBOPCION4, pregunta.getSubopcion4());
        db.insert(PreguntasTable.TABLE_NAME, null, cv);
    }
    public List<ExamenModel> getAllPreguntas() {
        ArrayList<ExamenModel> examenModelList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + PreguntasTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                ExamenModel pregunta = new ExamenModel();
                pregunta.setPregunta(c.getString(c.getColumnIndex(PreguntasTable.COLUMN_PREGUNTA)));
                pregunta.setOpcion1(c.getString(c.getColumnIndex(PreguntasTable.COLUMN_OPCION1)));
                pregunta.setOpcion2(c.getString(c.getColumnIndex(PreguntasTable.COLUMN_OPCION2)));
                pregunta.setOpcion3(c.getString(c.getColumnIndex(PreguntasTable.COLUMN_OPCION3)));
                pregunta.setOpcion4(c.getString(c.getColumnIndex(PreguntasTable.COLUMN_OPCION4)));
                pregunta.setRespuesta(c.getInt(c.getColumnIndex(PreguntasTable.COLUMN_RESPUESTA)));
                pregunta.setSubopcion1(c.getString(c.getColumnIndex(PreguntasTable.COLUMN_SUBOPCION1)));
                pregunta.setSubopcion2(c.getString(c.getColumnIndex(PreguntasTable.COLUMN_SUBOPCION2)));
                pregunta.setSubopcion3(c.getString(c.getColumnIndex(PreguntasTable.COLUMN_SUBOPCION3)));
                pregunta.setSubopcion4(c.getString(c.getColumnIndex(PreguntasTable.COLUMN_SUBOPCION4)));
                examenModelList.add(pregunta);
            } while (c.moveToNext());
        }
        c.close();
        return examenModelList;
    }
}