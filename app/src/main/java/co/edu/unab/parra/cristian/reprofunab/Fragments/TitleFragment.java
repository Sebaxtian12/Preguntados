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
        preguntas1.add("Pasos para la matr??cula:\n");
        preguntas1.add("El derecho a la renovaci??n de matr??cula se perder?? por una de las siguientes causas:\n");
        preguntas1.add("Solicitud de admisi??n por transferencia:\n");
        preguntas1.add("Requisitos para la homologaci??n:\n");
        preguntas1.add("Condiciones acad??micas dentro de la UNAB: \n");
        preguntas1.add("Estados acad??micos en la UNAB:\n");
        preguntas1.add("??Qu?? es el Curr??culo?\n");
        preguntas1.add("??Qu?? es el Plan de estudios?\n");
        preguntas1.add("??Qu?? son las Actividades acad??micas? \n");
        preguntas1.add("??Que es un Cr??dito?\n");
        preguntas1.add("La escala de calificaci??n en la UNAB \n");
        preguntas1.add("C??lculo del PPA y PGA. \n");
        preguntas1.add("Las Habilitaciones:\n");
        preguntas1.add("Los objetivos de la pr??ctica acad??mica \n");
        preguntas1.add("El trabajo de grado.\n");
        preguntas1.add("Requisitos para obtener el t??tulo en estudios de pregrado: \n");

        preguntas2.add("Derechos de los estudiantes.\n");
        preguntas2.add("Deberes de los estudiantes\n");

        preguntas3.add("Objetivos del acompa??amiento acad??mico\n");
        preguntas3.add("Est??mulos y distinciones\n");
        preguntas3.add("Derechos derivados de las distinciones acad??micas\n");

        preguntas4.add("Faltas grav??simas\n");
        preguntas4.add("Faltas graves\n");
        preguntas4.add("Faltas leves\n");


        preguntas5.add("Tipos de sanci??n para falta grav??sima:\n");
        preguntas5.add("Para falta grave\n");
        preguntas5.add("Para falta leve:\n");
        preguntas5.add("Los Requisitos m??nimos que dispone la apertura de la investigaci??n deber?? contener:\n\n");
        preguntas5.add("Los requisitos formales del pliego de cargos. El pliego de cargos deber?? contener como m??nimo:\n\n");
        preguntas5.add(". De la audiencia de fallo . Si existe m??rito disciplinario, se proceder?? a proferir fallo motivado que contendr??:\n");


        elementos.add(new TitleModel(R.drawable.titulo01, "1","Titulo 1" , "De las normas generales que rigen el funcionamiento acad??mico",preguntas1));
        elementos.add(new TitleModel(R.drawable.titulo02, "2","Titulo 2" , "Derechos y deberes de los estudiantes",preguntas2));
        elementos.add(new TitleModel(R.drawable.titulo03, "3","Titulo 3" , "De las normas generales que regulan el acompa??amiento y apoyo acad??mico",preguntas3));
        elementos.add(new TitleModel(R.drawable.titulo04, "4","Titulo 4", "Del R??gimen Disciplinario", preguntas4));
        elementos.add(new TitleModel(R.drawable.titulo05, "5","Titulo 5" , "Disposiciones generales y vigencia",preguntas5));

    }

    }