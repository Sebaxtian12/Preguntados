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

        preguntas2.add("¿Cómo se produce la vinculación a la Universidad Autónoma de Bucaramanga y cuáles son los requisitos de ingreso? (Requisitos generales de ingreso)\n");
        preguntas2.add("¿Si pretendo ser profesor, pero no cuento con posgrado ni con los 2 años de experiencia, quedaría completamente descartado? (Parágrafo 1)\n");
        preguntas2.add("¿Si pretendo ser profesor, pero no cuento con un título profesional, quedaría completamente descartado? (Parágrafo 2)\n");
        preguntas2.add("¿Qué es la convocatoria y qué debo saber sobre ésta? (Proceso de selección - Convocatoria)\n");
        preguntas2.add("¿Cuál es la finalidad del concurso de méritos y en qué consiste? (Concurso)\n");
        preguntas2.add("¿Qué es un concurso desierto y que implica si se presenta? (Acta final del concurso)\n");
        preguntas2.add("¿Cómo se clasifica el personal docente de la UNAB? (Dedicación)\n");
        preguntas2.add("¿Qué es un profesor de planta?\n");
        preguntas2.add("¿Qué es un profesor de cátedra?\n");
        preguntas2.add("¿Qué es un profesor visitante?\n");
        preguntas2.add("¿Qué es un profesor Ad-honorem?\n");
        preguntas2.add("¿Qué es la asignación académica?\n");
        preguntas2.add("¿Qué es el escalafón y cómo es su aplicación?\n");
        preguntas2.add("¿Cuáles son las categorías docentes?\n");
        preguntas2.add("¿Quién es un profesor auxiliar? (Requisitos específicos)\n");
        preguntas2.add("¿Quién es un profesor asistente?\n");
        preguntas2.add("¿Quién es un profesor asociado?\n");
        preguntas2.add("¿Quién es un profesor titular?\n");
        preguntas2.add("¿Cómo son los ascensos?\n");
        preguntas2.add("¿Cuáles son las situaciones especiales del profesor de planta?\n");

        preguntas3.add("¿Cuáles son las responsabilidades del profesor?\n");
        preguntas3.add("¿Cuáles son los derechos de los profesores?\n");
        preguntas3.add("¿Cuáles son los deberes de los profesores?\n");
        preguntas3.add("¿Existen estímulos para los profesores?\n");
        preguntas3.add("¿Existen distinciones para los profesores?\n");
        preguntas3.add("¿Qué inhabilita a un profesor de la UNAB?\n");
        preguntas3.add("¿Hay incompatibilidades para ser profesor UNAB?\n");
        preguntas3.add("¿Cuáles son las prohibiciones que tienen los profesores?\n");

        preguntas4.add("¿Cómo se realiza el seguimiento y la evaluación del desempeño del profesorado?\n");

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