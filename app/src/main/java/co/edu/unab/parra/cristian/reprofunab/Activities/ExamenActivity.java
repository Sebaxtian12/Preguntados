package co.edu.unab.parra.cristian.reprofunab.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.yy.mobile.rollingtextview.RollingTextView;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import co.edu.unab.parra.cristian.reprofunab.Adapters.ExamenDBHelper;
import co.edu.unab.parra.cristian.reprofunab.Model.ExamenModel;
import co.edu.unab.parra.cristian.reprofunab.R;


public class ExamenActivity extends AppCompatActivity {
    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 30000;
    ProgressBar progress_bar;
    public static final int TIMER = 30;
    private TextView tvPregunta;
    private RollingTextView tvScore;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private TextView tev1, tev2, tev3;
    private Button Botonenviar;
    private ColorStateList textColorDefaultCd;
    private CountDownTimer cuentaRegresiva;
    private long tiemporestante;
    private int tiempobar;
    private List<ExamenModel> examenModelList;
    private int PreguntaContador;
    private int PreguntasRestantes;
    private ExamenModel examenModelActual;
    private int score;
    private boolean respondido;
    private long backPressedTime;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen);

            // Set a Toolbar to replace the ActionBar.
        Toolbar appbar = findViewById(R.id.toolbar);
        setSupportActionBar(appbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_flecha);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.examen_intento));


        tvPregunta = findViewById(R.id.tv_pregunta);
        tvScore = findViewById(R.id.tv_verpuntuacion);
        textViewCountDown = findViewById(R.id.tv_temporizador);
        rbGroup = findViewById(R.id.radio_groupexamen);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        tev1 = findViewById(R.id.tev1);
        tev2 = findViewById(R.id.tev2);
        tev3 = findViewById(R.id.tev3);
        progress_bar = findViewById(R.id.progress_bar);
        Botonenviar = findViewById(R.id.button_confirmar);
        textColorDefaultCd = textViewCountDown.getTextColors();
        progress_bar.setMax(TIMER);

        ExamenDBHelper dbHelper = new ExamenDBHelper(this);
        examenModelList = dbHelper.getAllPreguntas();
        PreguntasRestantes = examenModelList.size();
        Collections.shuffle(examenModelList);
        preguntaSiguiente();


        Botonenviar.setOnClickListener(v -> {
            if (!respondido) {
                if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                    checkRespuesta();
                } else {
                    Toast.makeText(ExamenActivity.this, "Elija la respuesta correcta", Toast.LENGTH_SHORT).show();
                }
            } else {
                preguntaSiguiente();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void preguntaSiguiente() {

        rb1.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_bg_blanco));
        rb2.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_bg_blanco));
        rb3.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_bg_blanco));
        rbGroup.clearCheck();
        if (PreguntaContador < PreguntasRestantes) {
            examenModelActual = examenModelList.get(PreguntaContador);
            tvPregunta.setText(examenModelActual.getPregunta());
            rb1.setText(examenModelActual.getOpcion1());
            rb2.setText(examenModelActual.getOpcion2());
            rb3.setText(examenModelActual.getOpcion3());
            tev1.setText(examenModelActual.getSubopcion1());
            tev2.setText(examenModelActual.getSubopcion2());
            tev3.setText(examenModelActual.getSubopcion3());

            PreguntaContador++;
            respondido = false;
            Botonenviar.setText("Enviar");
            tiemporestante = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        cuentaRegresiva = new CountDownTimer(tiemporestante, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                tiemporestante = millisUntilFinished;
                updateCountDownText();
                tiempobar = (int) millisUntilFinished / 1000;
                progress_bar.setProgress(tiempobar);
            }
            @Override
            public void onFinish() {
                tiemporestante = 0;
                updateCountDownText();
                checkRespuesta();
            }
        }.start();
    }
    private void updateCountDownText() {

        int seconds = (int) (tiemporestante / 1000) % 60;
        String timeFormatted = String.format(Locale.getDefault(), "%02d", seconds);
        textViewCountDown.setText(timeFormatted);
        if (tiemporestante < 10000) {
            textViewCountDown.setTextColor(Color.RED);
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }
    @SuppressLint("SetTextI18n")


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this,NavigationDrawerActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
    private void checkRespuesta() {
        respondido = true;
        cuentaRegresiva.cancel();

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected);
        int answerNr2 = rbGroup.indexOfChild(rbSelected)-1;
        int answerNr3 = rbGroup.indexOfChild(rbSelected)+1;
        if (answerNr == examenModelActual.getRespuesta()) {
            score++;
            tvScore.setText("" + score);
        }if(answerNr2 == examenModelActual.getRespuesta()){
            score++;
            tvScore.setText("" + score);
        }if (answerNr3 == examenModelActual.getRespuesta()){
            score++;
            tvScore.setText("" + score);
        }
        showRespuesta();
    }

    @SuppressLint("SetTextI18n")
    private void showRespuesta() {
        rb1.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_bg_rojo));
        rb2.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_bg_rojo));
        rb3.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_bg_rojo));
        switch (examenModelActual.getRespuesta()) {
            case 1:
                rb1.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_bg_verde));
                tvPregunta.setText("A es la respuesta correcta");
                break;
            case 2:
                rb2.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_bg_verde));
                tvPregunta.setText("B es la respuesta correcta");
                break;
            case 3:
                rb3.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_bg_verde));
                tvPregunta.setText("C es la respuesta correcta");
                break;
        }
        if (PreguntaContador < PreguntasRestantes) {
            Botonenviar.setText("Siguiente");
        } else {
            Botonenviar.setText("Finalizar");
        }
    }
    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }



    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "Pulsa de nuevo para salir", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (cuentaRegresiva != null) {
            cuentaRegresiva.cancel();
        }
    }
}