package co.edu.unab.parra.cristian.reprofunab.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.unab.parra.cristian.reprofunab.R;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation animacion1= AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2= AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);
        TextView txtReglamento=findViewById(R.id.txt_reglamento);
        ImageView img=findViewById(R.id.imageView);
        txtReglamento.setAnimation(animacion2);
        img.setAnimation(animacion1);


        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i= new Intent(MainActivity.this, NavigationDrawerActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);
    }
}