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

        preguntas1.add("Admisiones:\n");
        preguntas1.add("Pasos para la matrícula:\n");
        preguntas1.add("El derecho a la renovación de matrícula se perderá por una de las siguientes causas:\n");
        preguntas1.add("Solicitud de admisión por transferencia:\n");
        preguntas1.add("Requisitos para la homologación:\n");
        preguntas1.add("Condiciones académicas dentro de la UNAB: \n");
        preguntas1.add("Estados académicos en la UNAB:\n");
        preguntas1.add("¿Qué es el Currículo?\n");
        preguntas1.add("¿Qué es el Plan de estudios?\n");
        preguntas1.add("¿Qué son las Actividades académicas? \n");
        preguntas1.add("¿Que es un Crédito?\n");
        preguntas1.add("La escala de calificación en la UNAB \n");
        preguntas1.add("Cálculo del PPA y PGA. \n");
        preguntas1.add("Las Habilitaciones:\n");
        preguntas1.add("Los objetivos de la práctica académica \n");
        preguntas1.add("El trabajo de grado.\n");
        preguntas1.add("Requisitos para obtener el título en estudios de pregrado: \n");

        preguntas2.add("Derechos de los estudiantes.\n");
        preguntas2.add("Deberes de los estudiantes\n");

        preguntas3.add("Objetivos del acompañamiento académico\n");
        preguntas3.add("Estímulos y distinciones\n");
        preguntas3.add("Derechos derivados de las distinciones académicas\n");

        preguntas4.add("Faltas gravísimas\n");
        preguntas4.add("Faltas graves\n");
        preguntas4.add("Faltas leves\n");


        preguntas5.add("Tipos de sanción para falta gravísima:\n");
        preguntas5.add("Para falta grave\n");
        preguntas5.add("Para falta leve:\n");
        preguntas5.add("Los Requisitos mínimos que dispone la apertura de la investigación deberá contener:\n\n");
        preguntas5.add("Los requisitos formales del pliego de cargos. El pliego de cargos deberá contener como mínimo:\n\n");
        preguntas5.add(". De la audiencia de fallo . Si existe mérito disciplinario, se procederá a proferir fallo motivado que contendrá:\n");


        elementos.add(new TitleModel(R.drawable.titulo01, "1","Titulo 1" , "De las normas generales que rigen el funcionamiento académico",preguntas1));
        elementos.add(new TitleModel(R.drawable.titulo02, "2","Titulo 2" , "Derechos y deberes de los estudiantes",preguntas2));
        elementos.add(new TitleModel(R.drawable.titulo03, "3","Titulo 3" , "De las normas generales que regulan el acompañamiento y apoyo académico",preguntas3));
        elementos.add(new TitleModel(R.drawable.titulo04, "4","Titulo 4", "Del Régimen Disciplinario", preguntas4));
        elementos.add(new TitleModel(R.drawable.titulo05, "5","Titulo 5" , "Disposiciones generales y vigencia",preguntas5));

    }

    }