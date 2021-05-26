package co.edu.unab.parra.cristian.reprofunab.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mlsdev.animatedrv.AnimatedRecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.edu.unab.parra.cristian.reprofunab.Activities.DetalleActivity;
import co.edu.unab.parra.cristian.reprofunab.Adapters.TitleAdapter;
import co.edu.unab.parra.cristian.reprofunab.Model.TitleModel;
import co.edu.unab.parra.cristian.reprofunab.R;

public class TitleFragment extends Fragment {

    private List<TitleModel> elementos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getData();

        View view = inflater.inflate(R.layout.fragment_titles, container, false);


        TitleAdapter titleAdapter = new TitleAdapter(elementos, getActivity(), new TitleAdapter.onItemClickListener() {
            @Override
            public void onItemClick(TitleModel myTitle, int posicion) {
                Intent miIntencion = new Intent(getActivity(), DetalleActivity.class);
                miIntencion.putExtra("Titulosxd", myTitle);
                startActivity(miIntencion);
            }
            });
        RecyclerView recyclerView = view.findViewById(R.id.rvTitulos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(titleAdapter);

        return view;
        }


    private void getData() {

        elementos = new ArrayList<>();

        ArrayList<String> preguntas1 = new ArrayList<>();
        ArrayList<String> preguntas2 = new ArrayList<>();
        ArrayList<String> preguntas3 = new ArrayList<>();
        ArrayList<String> preguntas4 = new ArrayList<>();
        ArrayList<String> preguntas5 = new ArrayList<>();

        preguntas1.add("¿Cuál es el objetivo del Reglamento del profesorado?\n");
        preguntas1.add("¿Qué es el reglamento docente? (Definiciones)\n");
        preguntas1.add("¿Qué es un Docente UNAB y cuáles son sus características? (Definiciones y perfil del profesor UNAB)\n");
        preguntas1.add("¿A quién aplica este Reglamento y desde qué momento? (Campo de aplicación e integración a los contratos)\n");

        preguntas2.add("Derechos de los estudiantes.\n");
        preguntas2.add("Deberes de los estudiantes\n");

        preguntas3.add("Objetivos del acompañamiento académico\n");
        preguntas3.add("Estímulos y distinciones\n");
        preguntas3.add("Derechos derivados de las distinciones académicas\n");

        preguntas4.add("Faltas gravísimas\n");
        preguntas4.add("Faltas graves\n");
        preguntas4.add("Faltas leves\n");





        preguntas5.add("¿Cuales son las causas para iniciar un proceso disciplinario en contra de un docente?\n");
        preguntas5.add("¿Cuales son las faltas disciplinarias para un docente de la unab?\n");
        preguntas5.add("¿Cuales son las sanciones por faltas disciplinarias?\n");
        preguntas5.add("¿Cual es la consecuencia de incurrir en las prohibiciones, inhabilidades e incompatibilidades señaladas en este Reglamento?\n");
        preguntas5.add("Normatividad llevada a cabo en un procedimiento disciplinario\n");
        preguntas5.add("¿Cuales son los pasos a seguir para un procedimiento disciplinario?\n");


        elementos.add(new TitleModel(R.drawable.titulo01, "1","Titulo 1" , "De las normas generales que rigen el funcionamiento académico",preguntas1));
        elementos.add(new TitleModel(R.drawable.titulo02, "2","Titulo 2" , "Derechos y deberes de los estudiantes",preguntas2));
        elementos.add(new TitleModel(R.drawable.titulo03, "3","Titulo 3" , "De las normas generales que regulan el acompañamiento y apoyo académico",preguntas3));
        elementos.add(new TitleModel(R.drawable.titulo04, "4","Titulo 4", "Del Régimen Disciplinario", preguntas4));
        elementos.add(new TitleModel(R.drawable.titulo05, "5","Titulo 5" , "Disposiciones generales y vigencia",preguntas5));

    }

    }