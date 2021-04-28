package co.edu.unab.parra.cristian.reprofunab.Fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.skyfishjy.library.RippleBackground;
import com.yy.mobile.rollingtextview.RollingTextView;


import co.edu.unab.parra.cristian.reprofunab.Activities.ExamenActivity;
import co.edu.unab.parra.cristian.reprofunab.R;

public class PreExamenFragment extends Fragment {
    private static final int REQUEST_CODE_QUIZ = 1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_RECORD = "keyHighscore";
    private RollingTextView tV_Record;
    private int record;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_exameninicio, container, false);

        tV_Record = view.findViewById(R.id.tv_puntuacionalta);
        loadHighscore();

        final RippleBackground rippleBackground= view.findViewById(R.id.contenido);
        ImageView imageView= view.findViewById(R.id.centerImage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rippleBackground.startRippleAnimation();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getActivity(), ExamenActivity.class);
                        startActivityForResult(intent, REQUEST_CODE_QUIZ);
                        rippleBackground.stopRippleAnimation();
                    }
                }, 2000);

            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == Activity.RESULT_OK) {
                int score = data.getIntExtra(ExamenActivity.EXTRA_SCORE, 0);
                if (score > record) {
                    updateHighscore(score);
                }
            }
        }
    }
    @SuppressLint("SetTextI18n")
    private void loadHighscore() {
        SharedPreferences prefs = this.requireActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        record = prefs.getInt(KEY_RECORD, 0);
        tV_Record.setText("" + record);
    }
    @SuppressLint("SetTextI18n")
    private void updateHighscore(int highscoreNew) {
        record = highscoreNew;
        tV_Record.setText("" + record);
        SharedPreferences prefs = this.requireActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_RECORD, record);
        editor.apply();
    }
}