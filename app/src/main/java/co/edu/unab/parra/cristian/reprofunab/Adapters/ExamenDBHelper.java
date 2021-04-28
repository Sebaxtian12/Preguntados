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
                PreguntasTable.COLUMN_RESPUESTA + " INTEGER," +
                PreguntasTable.COLUMN_SUBOPCION1 + " TEXT," +
                PreguntasTable.COLUMN_SUBOPCION2 + " TEXT, " +
                PreguntasTable.COLUMN_SUBOPCION3 + " TEXT " + ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        LlenarPreguntasTable();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PreguntasTable.TABLE_NAME);
        onCreate(db);
    }
    private void LlenarPreguntasTable() {
        ExamenModel p1 = new ExamenModel("¿Cuál es el objetivo del reglamento del profesorado?", "A", "B", "C", 1, "Estimular y orientar el desarrollo humano y profesional para consolidar una comunidad científica y profesoral de excelencia en sus funciones", "Ser el reglamento consultado para trabajos academicos", "Ninguna de las anteriores");
        addPregunta(p1);
        ExamenModel p2 = new ExamenModel("Es una responsabilidad de todo docente UNAB", "A", "B", "C", 3, "Notificar su asistencia diaria", "Hacer un reporte con el nombre de los estudiantes que no aprueban la materia", "Promover y desarrollar actividades investigativas en la institución");
        addPregunta(p2);
        ExamenModel p3 = new ExamenModel("Es una restricción para ser docente UNAB", "A", "B", "C", 2, "Ser extranjero y tener menos de 15 años de residencia", "Quien haya sido condenado por sentencia judicial a pena privativa de la libertad, excepto por delitos culposos", "Estar trabajando actualmente en otra universidad");
        addPregunta(p3);
        ExamenModel p4 = new ExamenModel("¿Cuál de las siguientes respuestas es uno de los objetivo de la evaluación docente?", "A", "B", "C", 2,  "Una actividad extracurricular de los estudiantes", "Elevar la cultura institucional y la calidad académica","Una actividad extracurricular de los estudiantes");
        addPregunta(p4);
        ExamenModel p5 = new ExamenModel("¿Qué le sucede al docente que incurrá en algunas de las faltas mencionadas en el reglamento?", "A", "B", "C", 1, "Se efectuará la cancelación de su contrato, ya sea laboral o de prestación de servicios", "Se dará inicio a un proceso legal por incumplir con lo estipulado en su contrato", "Será inhabilitado para ejercer docencia en cualquier institución de educación por un lapso de 20 años ");
        addPregunta(p5);
    }
    private void addPregunta(ExamenModel pregunta) {
        ContentValues cv = new ContentValues();
        cv.put(PreguntasTable.COLUMN_PREGUNTA, pregunta.getPregunta());
        cv.put(PreguntasTable.COLUMN_OPCION1, pregunta.getOpcion1());
        cv.put(PreguntasTable.COLUMN_OPCION2, pregunta.getOpcion2());
        cv.put(PreguntasTable.COLUMN_OPCION3, pregunta.getOpcion3());
        cv.put(PreguntasTable.COLUMN_RESPUESTA, pregunta.getRespuesta());
        cv.put(PreguntasTable.COLUMN_SUBOPCION1, pregunta.getSubopcion1());
        cv.put(PreguntasTable.COLUMN_SUBOPCION2, pregunta.getSubopcion2());
        cv.put(PreguntasTable.COLUMN_SUBOPCION3, pregunta.getSubopcion3());
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
                pregunta.setRespuesta(c.getInt(c.getColumnIndex(PreguntasTable.COLUMN_RESPUESTA)));
                pregunta.setSubopcion1(c.getString(c.getColumnIndex(PreguntasTable.COLUMN_SUBOPCION1)));
                pregunta.setSubopcion2(c.getString(c.getColumnIndex(PreguntasTable.COLUMN_SUBOPCION2)));
                pregunta.setSubopcion3(c.getString(c.getColumnIndex(PreguntasTable.COLUMN_SUBOPCION3)));
                examenModelList.add(pregunta);
            } while (c.moveToNext());
        }
        c.close();
        return examenModelList;
    }
}