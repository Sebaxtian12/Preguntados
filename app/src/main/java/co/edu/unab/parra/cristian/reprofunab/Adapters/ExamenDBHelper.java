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
                "Una beca o cualquier garantía de que termine la carrera con éxito",
                "Un desempeño alto y certificado que demuestre sus aptitudes para pertenecer a la institución",
                "Cumplir con los tramites, ceñirse al modelo educativo y plan curricular",
                "Debe de tener una certificación de una institución educativa que demuestre estar listo para desarrollar su conocimiento dentro de la institución");
        addPregunta(p1);
        ExamenModel p2 = new ExamenModel("La UNAB aceptara a todo solicitante que:",
                "A", "B", "C", "D", 2,
                "Sea recomendado por un directivo o personal de la institución universitaria",
                "Cumpla con los requisitos de la ley y los establecidos por la institución durante el proceso de admisión",
                "No haya cancelado su proceso de admisión",
                "Cumpla con los requisitos de la ley y no tenga antecedentes de mala conducta");
        addPregunta(p2);
        ExamenModel p3 = new ExamenModel("El aspirante admitido adquiere el rol de:",
                "A", "B", "C", "D", 1,
                "Estudiante activo", "Personal UNAB",
                "Estudiante de pregrado UNAB",
                "Persona UNAB");
        addPregunta(p3);
        ExamenModel p4 = new ExamenModel("Una vez el aspirante sea admitido deberá:",
                "A", "B", "C", "D", 3,
                "Renovar su matrícula cada año ",
                "Renovar su matrícula cada final de semestre ",
                "Renovar su matrícula según el crono grama académico",
                "Renovar su matrícula cada que el director de programa establezca las fechas");
        addPregunta(p4);
        ExamenModel p5 = new ExamenModel("Todo estudiante UNAB sea nacional o extranjero, deberá:",
                "A", "B", "C", "D", 4,
                "Elegir entre las normas de la UNAB o las normas de su lugar local para cumplirlas",
                "Acatar las normas de la institución siempre y cuando estas no contradigan las normas del lugar en donde el estudiante procede",
                "Acatar las normas del lugar donde proviene cada estudiante y la institución deberá ser flexible a cualquiera de ellas",
                "Acatar las normas y reglamentos de la institución por encima de cualquier otra que no sobreexceda la constitución");
        addPregunta(p5);

        ExamenModel p6 = new ExamenModel("Uno de los principios para la aplicación de las sanciones disciplinarias es:",
                "A", "B", "C", "D", 3,
                "Ser el proceso educativo una construcción equitativa fundada en la parcialidad, en la injusticia, y en el respeto a la dignidad humana.",
                "Falsificar o adulterar cualquier documento de la UNAB",
                "La proporcionalidad entre la falta y la sanción.",
                "La autorización de todo tipo de responsabilidad objetiva.");
        addPregunta(p6);
        ExamenModel p7 = new ExamenModel("Seleccione la falta calificada como gravísima:",
                "A", "B", "C", "D", 1,
                "Hacer plagio o fraude académico en el desarrollo o presentación de trabajos de grado o los productos derivados del mismo.",
                "Incurrir en fraude académico o plagio en cualquier tipo de evaluación, trabajo o actividad académica.",
                "La ausencia, el incumplimiento o el cambio no autorizado de actividades académicas programadas en los diferentes escenarios de práctica.",
                "Cualquier conducta de acoso sobre un miembro de la comunidad académica o personal al servicio de la Universidad que no esté determinada como gravísima. ");
        addPregunta(p7);
        ExamenModel p8 = new ExamenModel("Seleccione la falta calificada como grave:",
                "A", "B", "C", "D", 2,
                "Hacer plagio o fraude académico en el desarrollo o presentación de trabajos de grado o los productos derivados del mismo",
                "Causar daños intencionales a los bienes muebles o inmuebles de la UNAB, de los escenarios de práctica, o de los lugares en que se realicen actividades académicas",
                "Cualquier conducta destinada a desacatar la sanción disciplinaria o a burlar sus efectos.",
                "Falsificar o adulterar cualquier documento de la UNAB.");
        addPregunta(p8);
        ExamenModel p9 = new ExamenModel("Una de las sanciones para una falta calificada como gravísima es:",
                "A", "B", "C", "D", 2,
                "Calificación de cero, cero (0.0) en el curso.",
                "Expulsión de la Universidad que significa la pérdida inmediata y definitiva de su condición de estudiante de la UNAB.",
                "Suspensión inmediata de estudios hasta por dos (2) períodos académicos regulares consecutivos.",
                "Amonestación privada acompañada de un compromiso firmado por el estudiante con copia a la hoja de vida.");
        addPregunta(p9);
        ExamenModel p10 = new ExamenModel("Una de las sanciones para una falta calificada como grave es:",
                "A", "B", "C", "D", 1,
                "Calificación de cero, cero (0.0) en el curso.",
                "Revocatoria del título académico otorgado.",
                "Amonestación verbal con compromiso firmado por el estudiante y sin anotación en la hoja de vida.",
                "Pérdida del derecho a matricularse en cualquiera de los programas académicos.");
        addPregunta(p10);
        ExamenModel p11 = new ExamenModel("Una de las sanciones para una falta calificada como leve es:",
                "A", "B", "C", "D", 3,
                "Calificación de cero, cero (0.0) en la prueba",
                "Revocatoria del título académico otorgado.",
                "Amonestación privada acompañada de un compromiso firmado por el estudiante con copia a la hoja de vida.",
                "Suspensión inmediata de estudios hasta por dos (2) períodos académicos regulares consecutivos.");
        addPregunta(p11);
        ExamenModel p12 = new ExamenModel("Procedimiento disciplinario para falta considerada como grave o gravísima:",
                "A", "B", "C", "D", 2,
                "El fallo en primera instancia es de competencia del Consejo Académico de la Universidad.",
                "El fallo en primera instancia es de competencia del Consejo de Facultad.",
                "En la etapa de investigación y fallo, la competencia corresponderá al Consejo de Facultad.",
                "En segunda instancia, del Consejo de Facultad.");
        addPregunta(p12);
        ExamenModel p13 = new ExamenModel("Procedimiento disciplinario para falta considerada como leve:",
                "A", "B", "C", "D", 1,
                "En segunda instancia, del Consejo de Facultad.",
                "El fallo de segunda instancia, en caso de apelación, es de competencia privativa del Consejo Académico de la Universidad.",
                "El fallo en primera instancia es de competencia del Consejo de Facultad.",
                "En la etapa de investigación y fallo, la competencia corresponderá al Consejo de Facultad.");
        addPregunta(p13);
        ExamenModel p14 = new ExamenModel("Principio de procedimiento disciplinario que la Universidad hace cumplir al estudiante disciplinado:",
                "A", "B", "C", "D", 2,
                "La imposibilidad de designar apoderado o la de estar acompañado del mismo en todos los trámites disciplinarios",
                "El traslado al imputado de todas y cada una de las pruebas que fundamentan los cargos formulados.",
                "La posibilidad de que el disciplinado no pueda controvertir, ninguna de las decisiones de las autoridades competentes.",
                "La formulación de los cargos imputados, en la que no consten las faltas disciplinarias.");
        addPregunta(p14);
        ExamenModel p15 = new ExamenModel("Un requisitos mínimos para decisión que dispone la apertura de la investigación:",
                "A", "B", "C", "D", 2,
                "La relación de los hechos conocidos que dieron lugar a la apertura de la investigación.",
                "Respuesta A, C y D.",
                "La relación de las pruebas en que se sustentan dichos hechos y la de aquellas cuya práctica se ordena.",
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