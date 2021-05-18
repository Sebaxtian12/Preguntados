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
                PreguntasTable.COLUMN_SUBOPCION3 + " TEXT " + ")" ;
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        LlenarPreguntasTable();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PreguntasTable.TABLE_NAME);
        onCreate(db);
    }
    private void LlenarPreguntasTable() {
        ExamenModel p1 = new ExamenModel("Dada las siguientes opciones. Todo aspirante UNAB debe cumplir con:", "A", "B", "C", 3, "Una beca o cualquier garantía de que termine la carrera con éxito", "Un desempeño alto y certificado que demuestre sus aptitudes para pertenecer a la institución", "Cumplir con los tramites, ceñirse al modelo educativo y plan curricular");
        addPregunta(p1);
        ExamenModel p2 = new ExamenModel("La UNAB aceptara a todo solicitante que:", "A", "B", "C", 2, "Sea recomendado por un directivo o personal de la institución universitaria", "Cumpla con los requisitos de la ley y los establecidos por la institución durante el proceso de admisión", "No haya cancelado su proceso de admisión");
        addPregunta(p2);
        ExamenModel p3 = new ExamenModel("El aspirante admitido adquiere el rol de:", "A", "B", "C", 1, "Estudiante activo", "Personal UNAB", "Estudiante de pregrado UNAB");
        addPregunta(p3);
        ExamenModel p4 = new ExamenModel("Una vez el aspirante sea admitido deberá:", "A", "B", "C", 3,  "Renovar su matrícula cada año ", "Renovar su matrícula cada final de semestre ","Renovar su matrícula según el crono grama académico");
        addPregunta(p4);
        ExamenModel p5 = new ExamenModel("Todo estudiante UNAB sea nacional o extranjero, deberá:", "A", "B", "C", 1, "Acatar las normas y reglamentos de la institución por encima de cualquier otra que no sobreexceda la constitución", "Acatar las normas de la institución siempre y cuando estas no contradigan las normas del lugar en donde el estudiante procede", "Acatar las normas del lugar donde proviene cada estudiante y la institución deberá ser flexible a cualquiera de ellas");
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