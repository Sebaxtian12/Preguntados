package co.edu.unab.parra.cristian.reprofunab.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import co.edu.unab.parra.cristian.reprofunab.Adapters.AdapterDetalle;
import co.edu.unab.parra.cristian.reprofunab.Fragments.TitleFragment;
import co.edu.unab.parra.cristian.reprofunab.Model.TitleModel;
import co.edu.unab.parra.cristian.reprofunab.R;

public class DetalleActivity extends AppCompatActivity {

    ExpandableListView expandibleListView;
    List<String> listGroup;
    HashMap<String, List<String>> listItem;
    AdapterDetalle adapter;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);


        // Set a Toolbar to replace the ActionBar.
        Toolbar appbar = findViewById(R.id.toolbar);
        setSupportActionBar(appbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_flecha);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.detalle));

        appbar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                finish();
                return false;
            }
        });

        Bundle datos= getIntent().getExtras();
        TitleModel myTitleModel = (TitleModel) datos.getSerializable("Titulosxd");
        int numero = Integer.parseInt(myTitleModel.getNumero());
        List<String> preguntas = myTitleModel.getPreguntas();
        Log.e("Testeo", preguntas.get(0));
        cargarElementos(preguntas, numero);

    }

    public void cargarElementos(List<String> preguntas, int numero){
        expandibleListView= findViewById(R.id.exp_list_view);
        expandibleListView.setFocusable(false);
        listGroup= new ArrayList<>();
        listItem= new HashMap<>();
        adapter = new AdapterDetalle(this, listGroup, listItem);
        expandibleListView.setAdapter(adapter);
        initListData(preguntas, numero);
    }



    private void initListData(List<String> preguntas, int numero) {
        listGroup.addAll(preguntas);
        /*listGroup.add("1");
        listGroup.add("2");
        listGroup.add("3");*/


        //String[]array;
        for(int i=0; i<preguntas.size(); i++){
            List<String> listAux = new ArrayList<>();
            listAux.add("Una respuesta xd");
            listItem.put(listGroup.get(i),listAux);
        }


//Titulo1

        if (numero==1){
            //Pregunta1
            List<String> list1 = new ArrayList<>();
            list1.add("Estimular y orientar el desarrollo humano y profesional hacia el cumplimiento de su misión particular, para consolidar una comunidad científica y profesoral de excelencia en sus funciones. \n");
            listItem.put(listGroup.get(0), list1);
            //Pregunta2
            List<String> list2 = new ArrayList<>();
            list2.add("Es el conjunto de principios, valores y reglas básicas que rige la relación Universidad-profesores, donde se establecen las responsabilidades, derechos, deberes y lo referente a la carrera profesoral (perfil, selección, vinculación, remuneración, evaluación, promoción, inhabilidades, incompatibilidades, estímulos, distinciones y retiro.\n");
            listItem.put(listGroup.get(1), list2);
            //Pregunta3
            List<String> list3 = new ArrayList<>();
            list3.add("Persona que desarrolla la actividad de docencia e investigación, consciente del importante rol que desempeña, vinculado a una Facultad Académica de la Universidad y cumplidor del Reglamento del profesorado, entre sus características particulares se destacan:\n\n" +
                    "   a) Su preparación académica e idoneidad profesional.\n" +
                    "   b) Su tolerancia y respeto a las ideas divergentes.\n" +
                    "   c) Su creatividad y espíritu crítico.\n" +
                    "   d) Su compromiso con los principios que definen la Visión y Misión de la Universidad.\n" +
                    "   e) Sus habilidades pedagógicas para orientar los procesos de formación e instrucción del estudiante.\n" +
                    "   f) Su capacidad para generar, desde la cátedra, soluciones a la problemática regional y nacional.\n" +
                    "   g) El ejercicio de la docencia en la investigación y en el diálogo amplio.\n" +
                    "   h) La ética en el desempeño integral de sus actividades personales, profesionales y pedagógicas.\n" +
                    "   i) La actitud positiva y continua hacia su actualización científica, pedagógica y profesional.\n" +
                    "   j) Su integración al proceso de conformación de la comunidad académica UNAB.\n");
            listItem.put(listGroup.get(2), list3);
            //Pregunta4
            List<String> list4 = new ArrayList<>();
            list4.add("A todo el profesorado de la UNAB, y también a profesores que asuman responsabilidades administrativas o académico-administrativas en la institución, o se encuentren en cumplimiento de una comisión. Automáticamente el docente al firmar el respectivo contrato declara conocerlo y acatarlo.\n");
            listItem.put(listGroup.get(3), list4);
        }

//Titulo2

        if (numero==2){
            //Pregunta1
            List<String> list1 = new ArrayList<>();
            list1.add("Mediante concurso de méritos, donde el aspirante debe cumplir los siguientes requisitos:\n\n" +
                    "   a) Poseer título universitario en la disciplina o profesión a la cual se vincula.\n" +
                    "   b) Poseer título de posgrado en el campo o área en la que se vincula como docente.\n" +
                    "   c) Demostrar mediante concurso de méritos las cualidades requeridas para el desempeño del cargo.\n" +
                    "   d) Tener mínimo 2 años de experiencia profesional.\n" +
                    "   e) Afinidad con los principios y valores de la UNAB declarados en el acta de constitución, en la misión y los estatutos de la Universidad.\n");
            listItem.put(listGroup.get(0), list1);
            //Pregunta2
            List<String> list2 = new ArrayList<>();
            list2.add("La Rectoría y la Vicerrectoría Académica excepcionalmente, y de acuerdo con los intereses de la Universidad, podrá autorizar la vinculación de un Profesor de reconocidos méritos que no reúna los requisitos exonerar del cumplimiento de los literales b y d. \n");
            listItem.put(listGroup.get(1), list2);
            //Pregunta3
            List<String> list3 = new ArrayList<>();
            list3.add("La Rectoría y la Vicerrectoría Académica podrán exonerar del cumplimiento del literal a), a quien se desempeñe con suficiencia académica o a quienes demuestren que han hecho aportes significativos en el campo de las Bellas Artes, o en determinados aspectos de la técnica, las humanidades o la ciencia, etc. \n");
            listItem.put(listGroup.get(2), list3);
            //Pregunta4
            List<String> list4 = new ArrayList<>();
            list4.add("La convocatoria es el mecanismo por medio del cual se promueve la participación, en igualdad de condiciones, de los profesionales universitarios al concurso de méritos para ocupar las distintas plazas docentes que se encuentren vacantes. Para tal fin, el Decano de la respectiva Facultad, previa información a la Vicerrectoría Académica hará la convocatoria, que deberá realizarse mediante publicación interna o externa y en las fechas establecidas por la Universidad. La convocatoria para el concurso deberá contener por lo menos la siguiente información:\n\n" +
                    "   a) Número y fecha de la convocatoria.\n" +
                    "   b) Identificación de la plaza docente.\n" +
                    "   c) Requisitos mínimos que deberán satisfacer los aspirantes.\n");
            listItem.put(listGroup.get(3), list4);
            //Pregunta5
            List<String> list5 = new ArrayList<>();
            list5.add("El concurso de méritos tiene como finalidad evaluar las calidades académicas y personales de los candidatos, apreciar la capacidad, idoneidad, aptitudes y potencialidades del aspirante. Las pruebas o instrumentos de selección se aplicarán en dos etapas: la primera de preselección y la posterior de selección. En la etapa de preselección, que deberá realizarse en  un  término no inferior a cinco (5) días a partir de su señalamiento, el Comité evaluará las cualidades del candidato mediante:\n\n" +
                    "   a) El análisis de la hoja de vida.\n" +
                    "   b) Los resultados de una prueba psicotécnica. \n" +
                    "   c) Una entrevista con el Decano.\n" +
                    "Practicadas las anteriores pruebas, el concursante tendrá una entrevista con un psicólogo designado por la Facultad de Psicología Organizacional de la Universidad. Cada uno de los instrumentos de evaluación en esta etapa tendrá un puntaje que, sumado, deberá dar un porcentaje máximo de 100 y un mínimo de 70 para poder pasar a la segunda etapa del concurso.\n\n" +
                    "En el evento de que un concursante sea eliminado en esta etapa, por haber obtenido un puntaje inferior a 70, en el acta que elabore el Comité deberá dejar consignados de manera clara, cada uno de los puntajes y los fundamentos de tal decisión.\n" +
                    "Los candidatos que cumplan con el perfil establecido en el artículo anterior, pasarán a la segunda etapa del proceso que consiste en una de las siguientes pruebas: \n\n" +
                    "   a) Presentación por escrito y sustentación oral ante el Comité de una disertación académica sobre un tema establecido con anticipación no inferior a cinco(5)  días,  por el mismo Comité y referido al campo del conocimiento para el cual se requiere el profesor, en el contexto curricular establecido por el Proyecto Educativo Institucional.\n" +
                    "   b) Formulación de una propuesta de investigación, para la cual contará con diez (10) días contados a partir de la respectiva comunicación.\n" +
                    "   c) Exposición de un tema ante un grupo de profesores y de estudiantes, en la forma que lo determine el Comité. \n" +
                    "El puntaje máximo de esta evaluación será de 100 y un mínimo de 70 puntos, los que serán sumados a los obtenidos en la anterior etapa, en orden a establecer los puntajes de mayor a menor, obtenidos por los distintos concursantes cuando hubieren sido varios.\n" +
                    "Finalmente se elaborará el acta final del concurso por el comité que contendrá:\n\n" +
                    "   a) Número, fecha y cargo del docente.\n" +
                    "   b) Nombre de las personas inscritas, donde se señalan las que hubieren pasado a concurso y anotando las razones por las cuales fueron rechazados los otros aspirantes.\n" +
                    "   c) Puntajes obtenidos en cada prueba por quienes aprobaron.\n" +
                    "   d) Orden del resultado final obtenido por los participantes en el concurso de méritos.\n" +
                    "   e) Decisión y firma del acta por los integrantes del comité de selección.\n" +
                    "   f) Concluido el anterior procedimiento, el comité solicitará al Rector el nombramiento del  candidato o candidatos que hubieren ganado el concurso. La información académica relacionada en el concurso conformará una base de datos que estará a cargo de la Vicerrectoría Académica.\n\n");
            listItem.put(listGroup.get(4), list5);
            //Pregunta6
            List<String> list6 = new ArrayList<>();
            list6.add("El comité de selección puede declarar desierto el concurso cuando a su juicio los aspirantes no reúnen los requisitos exigidos en la convocatoria, o cuando no se hubiere inscrito ningún aspirante o cuando ninguno de ellos hubiere superado la totalidad de las pruebas.\n" +
                    "Declarado desierto el concurso, se hará una nueva convocatoria con los mismo parámetros señalados en los artículos precedentes. Si en esta segunda oportunidad se declara desierto el concurso, el Rector procederá a nombrar el candidato que más convenga a los intereses de la Universidad.\n");
            listItem.put(listGroup.get(5), list6);
            //Pregunta7
            List<String> list7 = new ArrayList<>();
            list7.add("De acuerdo con su vinculación y dedicación académica, el personal docente de la Universidad se clasifica como: \n\n" +
                    "   a) Profesor de Planta.\n" +
                    "   b) Profesor de Cátedra.\n" +
                    "   c) Profesor Visitante.\n" +
                    "   d) Profesor Ad-Honorem.\n");
            listItem.put(listGroup.get(6), list7);
            //Pregunta8
            List<String> list8 = new ArrayList<>();
            list8.add("Son quienes se encuentran vinculados mediante contrato de trabajo, y de acuerdo con la dedicación académica pueden ser: \n\n" +
                    "   a) De tiempo completo con una dedicación a la Universidad de cuarenta horas semanales.\n" +
                    "   b) De tiempo parcial, con una dedicación a la Universidad de treinta horas semanales.\n" +
                    "   c) De medio tiempo, con una dedicación a la Universidad de veinte horas semanales.\n");
            listItem.put(listGroup.get(7), list8);
            //Pregunta9
            List<String> list9 = new ArrayList<>();
            list9.add("Son quienes se encuentran vinculados mediante contrato de prestación de servicios. Durante el tiempo contratado su carga académica se distribuirá en:\n\n" +
                    "   a) Docencia directa.\n" +
                    "   b) Labores de coordinación.\n" +
                    "   c) Evaluación de dicha actividad. \n");
            listItem.put(listGroup.get(8), list9);
            //Pregunta10
            List<String> list10 = new ArrayList<>();
            list10.add(" Aquel que se encuentra vinculado a otra institución pero la Universidad considera vincularlo de manera transitoria, con una finalidad y un período específicos. Su vinculación se hará mediante contrato de prestación de servicios de carácter civil.\n");
            listItem.put(listGroup.get(9), list10);
            //Pregunta11
            List<String> list11 = new ArrayList<>();
            list11.add("Aquel que asume responsabilidades académicas pero que voluntariamente no recibe remuneración. Su vinculación se efectuará mediante resolución de Rectoría y su ubicación en el escalafón docente se hará de conformidad con su hoja de vida profesional y académica.\n");
            listItem.put(listGroup.get(10), list11);
            //Pregunta12
            List<String> list12 = new ArrayList<>();
            list12.add("Se define como la distribución de la actividad docente del profesor de acuerdo a su categoría dentro del escalafón. La asignación académica de cada profesor se debe ajustar de acuerdo al programa y período académico. Está integrada por:\n\n" +
                    "   a) Docencia directa: Horas semanales de un docente para impartir clase asignadas por la facultad a la que pertenece.\n" +
                    "   b) Preparación de clases: Tiempo de planeación de las asignaturas asignadas al docente.\n" +
                    "   c) Corrección de pruebas: Tiempo de evaluación y corrección de pruebas realizadas durante el periodo académico. \n" +
                    "   d) Atención a estudiantes: Tiempo que ofrece un docente para aclarar y orientar a los estudiantes que cursen las asignaturas que imparte.\n" +
                    "   e) Labores administrativas: Tiempo que emplea un docente en labores de apoyo a la institución.\n" +
                    "   f) Actividades de investigación: Tiempo utilizado por profesores de planta en la ejecución de labores investigativas debidamente aprobadas por el Comité Central de Investigaciones.\n" +
                    "   g) Coordinación: Tiempo utilizado por el docente en actividades de coordinación impuestas por la respectiva facultad.\n" +
                    "   h) Seminarios disciplinarios y de área: Actividades institucionales por parte de los profesores de una facultad y están centradas en evaluar el plan de estudio con el fin de mejorar la calidad de la educación.\n");
            listItem.put(listGroup.get(11), list12);
            //Pregunta13
            List<String> list13 = new ArrayList<>();
            list13.add("Conjunto ordenado y jerárquico de categorías que se establecen para clasificar a los profesores de acuerdo a:\n\n" +
                    "   a) Títulos universitarios, tanto de pregrado como posgrado en las áreas afines.\n" +
                    "   b) Experiencia en el campo, es decir, debe haber tenido desempeño en áreas afines.\n" +
                    "   c) Producción intelectual como escritos científicos, literarios y humanísticos. Para ascender en el escalafón es requisito la producción intelectual.\n" +
                    "   d) Antigüedad en cada una de las categorías docentes y tiempo de vinculación.\n" +
                    "   e) El escalafón y sus diferentes categorías rigen para todas las modalidades de vinculación de un profesor. Los criterios de ingreso, permanencia, ascenso y retiro se aplican por igual a todas las modalidades.\n");
            listItem.put(listGroup.get(12), list13);
            //Pregunta14
            List<String> list14 = new ArrayList<>();
            list14.add("Los docentes de la UNAB estarán categorizados como:\n\n" +
                    "   a) Profesor auxiliar (categoría inicial para todos los docentes recién ingresados).\n" +
                    "   b) Profesor asistente.\n" +
                    "   c) Profesor asociado.\n" +
                    "   d) Profesor titular (ningún profesor podrá ingresar a la UNAB en esta categoría).\n" +
                    "   e) A los profesores que se vinculen a la Universidad provenientes de otras instituciones de educación superior de características similares a la UNAB, se les respetará la clasificación que acrediten en el respectivo escalafón docente.\n" +
                    "A los profesores que se vinculen a la Universidad provenientes de otras instituciones de educación superior de características similares a la UNAB, se les respetará la clasificación que acrediten en el respectivo escalafón docente.\n");
            listItem.put(listGroup.get(13), list14);
            //Pregunta15
            List<String> list15 = new ArrayList<>();
            list15.add("Básicamente cualquier profesor que cumpla con los requisitos para lograr ser un docente UNAB.\n");
            listItem.put(listGroup.get(14), list15);
            //Pregunta16
            List<String> list16 = new ArrayList<>();
            list16.add("Aquel profesor que haya sido profesor auxiliar por un periodo de dos años, adicionalmente se requiere:\n\n" +
                    "   a) Poseer título de posgrado en el área que trabaje como docente.\n" +
                    "   b) Evaluación satisfactoria como profesor auxiliar.\n" +
                    "   c) Haber cumplido con los requerimientos del programa de perfeccionamiento docente de la UNAB.\n" +
                    "   d) Acreditar en este periodo cursos de perfeccionamiento en su disciplina no inferior a 80 horas de intensidad.\n" +
                    "   e) Acreditar 2 publicaciones como producción intelectual en revistas UNAB o en otras reconocidas nacionalmente.\n" +
                    "   f) Acreditar ante la institución conocimientos básicos en un idioma extranjero.\n" +
                    "   g) Acreditar el nivel básico en informática.\n");
            listItem.put(listGroup.get(15), list16);
            //Pregunta17
            List<String> list17 = new ArrayList<>();
            list17.add("Aquel profesor que haya sido profesor asistente por un periodo de tres años, adicionalmente se requiere:\n\n" +
                    "   a) Acreditar título universitario.\n" +
                    "   b) Evaluación satisfactoria como profesor asistente.\n" +
                    "   c) Acreditar una maestría en su campo de desempeño académico.\n" +
                    "   d) Haber realizado un posgrado en educación.\n" +
                    "   e) Acreditar que durante el lapso que fue profesor asistente adelantó cursos de perfeccionamiento en su disciplina científica con una intensidad no menor a 80 horas\n" +
                    "   f) Haber entregado el informe final de un trabajo de investigación en el cual haya sido director, coinvestigador o investigador principal, ó también haber publicado un  texto  en el campo de la ciencia en la cual realiza su ejercicio docente.\n" +
                    "   g) Acreditar ante la institución el conocimiento de un idioma extranjero.\n");
            listItem.put(listGroup.get(16), list17);
            //Pregunta18
            List<String> list18 = new ArrayList<>();
            list18.add("Aquel profesor que haya sido profesor asociado por un periodo de cuatro años, adicionalmente se requiere:\n\n" +
                    "   a) Acreditar evaluación satisfactoria como profesor asociado.\n" +
                    "   b) Haber desarrollado o estar adelantando en calidad de investigador principal, un trabajo de investigación inscrito en la institución.\n" +
                    "   c) Tener al menos 2 publicaciones de carácter científico en revistas UNAB o en otras reconocidas nacional o internacionalmente.\n" +
                    "   d) Acreditar un posgrado en el nivel de doctorado u otra maestría.\n");
            listItem.put(listGroup.get(17), list18);
            //Pregunta19
            List<String> list19 = new ArrayList<>();
            list19.add("La solicitud de ascenso se debe presentar a la decanatura de la facultad en el mes de septiembre. El decano verificará el cumplimiento de los requisitos y la remitirá a la Rectoría y Vicerrectoría académica para su análisis y su posterior aprobación o improbación del ascenso. El ascenso regirá en el escalafón a partir del primero de enero del año siguiente\n");
            listItem.put(listGroup.get(18), list19);
            //Pregunta20
            List<String> list20 = new ArrayList<>();
            list20.add("Existen distintas situaciones especiales relacionadas al profesor de planta:\n\n" +
                    "   a) Encargado de funciones diferentes a su cargo contratado, el profesor de planta puede ejercer funciones como encargado por decisión de la autoridad universitaria competente de manera transitoria.\n" +
                    "   b) Licencia por enfermedad o maternidad de acuerdo a la ley, el profesor puede solicitar por escrito la licencia ordinaria por un periodo superior a 3 días. Al vencerse la licencia, el docente debe retomar sus funciones; de no hacerlo se puede dar por terminado su contrato.\n" +
                    "   c) En permiso por razones de fuerza mayor o fortuita y no mayor a 3 días. El profesor debe solicitar el permiso al decano de la facultad o director del programa.\n" +
                    "   d) En comisión de servicios, estudios y representación de la institución en eventos especiales. La comisión puede ser:\n\n" +
                    "       I) Servicios, cuando el profesor ejerce sus funciones en un sitio distinto de la institución.\n" +
                    "       II) Estudios, cuando el profesor se encuentre en sus estudios de capacitación o posgrado.\n" +
                    "       III) Eventos especiales, cuando el profesor asiste en representación de la institución a foros, conferencias.\n" +
                    "   e) Vacaciones dentro del lapso dado por la institución.\n" +
                    "   f) Retiro, la desvinculación del docente de la UNAB implica la cesación en el ejercicio de todas sus funciones y se produce por:\n\n" +
                    "       I) Renuncia, en este caso el docente debe presentar a rectoría, decano de la facultad y al departamento de personal una carta explicando las razones para terminar de manera prematura el contrato, con un tiempo no inferior a treinta días antes de la separación del cargo.\n" +
                    "       II) Acuerdo mutuo.\n" +
                "           III) Vencimiento del término del contrato.\n" +
                    "       IV) Unilateralmente.\n" +
                    "Cuando al momento de presentar la renuncia existan compromisos entre la Universidad y el profesor, derivados de una comisión de estudios, una beca-crédito o cualquier otra modalidad bajo la cual el profesor haya recibido soporte o financiación por parte de la Universidad, directa o indirectamente éste deberá pagar a la Universidad el valor que corresponde conforme a los términos del contrato.\n");
            listItem.put(listGroup.get(19), list20);
        }

//Titulo3

        if (numero==3) {
            //Pregunta1
            List<String> list1 = new ArrayList<>();
            list1.add("Un profesor en la UNAB tiene las siguientes responsabilidades:\n\n" +
                    "   a) Aportar lo necesario para fortalecer la relación profesor-estudiante.\n" +
                    "   b) Asumir total responsabilidad de sus tareas como docente.\n" +
                    "   c) Contribuir a la formación de los estudiantes con su ejemplo y dedicación.\n" +
                    "   d) Ejercer su labor docente de acuerdo a los lineamientos de la Institución.\n" +
                    "   e) Mantener comunicación con el personal administrativo del programa respecto al desarrollo de las asignaturas.\n" +
                    "   f) Promover y desarrollar actividades investigativas en la institución.\n" +
                    "   g) Colaborar cuando la universidad lo considere necesario en actividades fuera de su área de experticia.\n" +
                    "   h) Participar en la programación y ejecución de evaluaciones de las asignaturas de la facultad a la que pertenece.\n" +
                    "   i) Promover y contribuir a la buena imagen de la Universidad delante de la comunidad.\n");
            listItem.put(listGroup.get(0), list1);
            //Pregunta2
            List<String> list2 = new ArrayList<>();
            list2.add("Son derechos del profesor:\n\n" +
                    "   a) El ejercicio de todos los derechos y garantías consagrados en la Constitución Política de Colombia.\n" +
                    "   b) El pleno ejercicio de la libertad de enseñanza, aprendizaje, investigación y cátedra de acuerdo con la Ley Fundamental, los Estatutos y los Reglamentos de la Universidad.\n" +
                    "   c) Participar en la elaboración de propuestas en materia académica, acordes con las políticas institucionales.\n" +
                    "   d) Participar en los planes de capacitación y mejoramiento pedagógicos, científicos y técnicos, de acuerdo con los planes y políticas de la Institución y del campo de formación del profesor.\n" +
                    "   e) Elegir y ser elegido para las representaciones profesorales ante el Consejo Académico, los Consejos de Facultad, y otros en los que la Universidad establezca representación del profesorado.\n" +
                    "   f) Recibir tratamiento respetuoso por parte de todos los miembros de la comunidad académica.\n" +
                    "   g) Participar y usufructuar de la propiedad intelectual y derechos de autor, en su propiedad intelectual, conforme a las prescripciones legales y a los reglamentos de la Universidad.\n" +
                    "   h) Disponer de los medios necesarios para la realización de la actividad académica, en condiciones de calidad, eficiencia, y seguridad industrial.\n" +
                    "   i) Recibir oportunamente la retribución en dinero y el reconocimiento que le correspondan conforme a su categoría dentro del escalafón, y a las disposiciones legales vigentes que rijan la modalidad contractual de su vinculación.\n" +
                    "   j) Solicitar la promoción en el escalafón docente de acuerdo con lo establecido en el presente Reglamento.\n" +
                    "   k) Disfrutar de las licencias y permisos solicitados con causa justificada.\n" +
                    "   l) Gozar de las actividades de bienestar universitario ofrecidas por la Universidad.\n" +
                    "   m) Gozar de los estímulos consagrados en este Reglamento y de los que adicionalmente pueda reconocer la Universidad.\n" +
                    "   n) Conocer y hacer parte del proceso de evaluación de su desempeño: ser notificado oportunamente del resultado, y utilizar los recursos de reposición y apelación que sean del caso.\n\n");
            listItem.put(listGroup.get(1), list2);
            //Pregunta3
            List<String> list3 = new ArrayList<>();
            list3.add("Son deberes de los profesores:\n\n" +
                    "   a) Conocer y cumplir las obligaciones que se derivan de la Constitución Política de Colombia, de las leyes de la República, de los Estatutos y reglamentos de la Universidad.\n" +
                    "   b) Observar las normas inherentes a la ética profesional y a su condición de docente.\n" +
                    "   c) Cumplir su compromiso con la Misión y el Proyecto Educativo de la Universidad.\n" +
                    "   d) Desempeñar con responsabilidad y eficiencia las funciones inherentes a su ejercicio docente y a las actividades que le sean confiadas.\n" +
                    "   e) Participar en el proceso de evaluación integral de aprendizaje del estudiante, e informar oportunamente sus resultados a los alumnos y a la Facultad correspondiente.\n" +
                    "   f) Cumplir el horario convenido en el contrato celebrado con la Universidad.\n" +
                    "   g) Elaborar, presentar y actualizar oportunamente, los programas de las asignaturas a su cargo, y desarrollarlos de acuerdo con los lineamientos definidos por las Facultades y la Universidad.\n" +
                    "   h) Dar tratamiento respetuoso a todos los miembros de la comunidad académica.\n" +
                    "   i) Preservar las instalaciones, equipos y elementos de apoyo académico de la Universidad y, responder por los daños y pérdidas de los bienes confiados a su guarda o administración.\n" +
                    "   j) Coordinar la actividad académica con los profesores de la misma asignatura atendiendo criterios de gestión curricular que permitan articular sus contenidos con las líneas, niveles y soportes pertinentes.\n" +
                    "   k) Participar en los grupos de trabajo que le sean asignados en desarrollo de los programas y planes institucionales.\n" +
                    "   l) Contribuir, con elevado ejercicio de sus responsabilidades académicas, al buen uso, a la guarda, engrandecimiento del nombre y del patrimonio cultural, científico, técnico, social y físico de la Universidad.\n" +
                    "   m) Fomentar la educación para la conservación de los recursos naturales y del ambiente.\n" +
                    "   n) Participar en las actividades de perfeccionamiento docente y de capacitación profesional.\n" +
                    "   o) Respetar los derechos de producción intelectual, la propiedad industrial y derechos de autor que correspondan a la Universidad, o a terceros, de acuerdo con la Ley y las normas institucionales.\n" +
                    "   p) Ejercer la actividad académica con dinamismo intelectual, respetando diferencias de credos e ideologías de los educandos.\n" +
                    "   q) Participar en el proceso de evaluación de su desempeño académico.\n" +
                    "   r) Participar activamente en la construcción y actualización de su portafolio docente.\n");
            listItem.put(listGroup.get(2), list3);
            //Pregunta4
            List<String> list4 = new ArrayList<>();
            list4.add("Sí, los estímulos tienen como objetivo elevar la excelencia del profesorado y en tal virtud, el profesor tiene derecho a participar en los programas de estudios avanzados, actualización de conocimientos, capacitación, complementación y desarrollo humanístico, científico, técnico o artístico, de acuerdo con los planes y políticas institucionales y con sus propios intereses.\n");
            listItem.put(listGroup.get(3), list4);
            //Pregunta5
            List<String> list5 = new ArrayList<>();
            list5.add(" Sí, la universidad reconocerá calidades docentes, investigativas y de proyección al profesorado. Son reconocimientos para los profesores:\n \n" +
                    "   a) Profesor Distinguido: Aquel profesor que destaque por sus contribuciones sobresalientes a la ciencia, arte y tecnología. Igualmente se podrá otorgar esta distinción al profesor que destaque en la actualización de los planes curriculares de la institución o que de iniciativas meritorias a la modernización  de la actividad administrativa  de la Universidad.\n" +
                    "   b) Profesor Laureado: Aquel profesor que haya desempeñado meritoriamente labores como Profesor Titular por un período no menor de cinco años y que haya recibido el reconocimiento de la comunidad académica por sus trabajos de investigación, sus publicaciones en revistas de reconocido prestigio, su producción de textos acogidos por la comunidad académica nacional, y por propiedad de patentes.\n" +
                    "   c) Profesor Emérito: Aquel profesor retirado para disfrutar su pensión cuando haya sobresalido en el ámbito nacional o internacional por sus contribuciones a la ciencia, al arte, a la técnica, a la administración pública o a la educación superior a lo largo de su carrera.\n");
            listItem.put(listGroup.get(4), list5);
            //Pregunta6
            List<String> list6 = new ArrayList<>();
            list6.add("No podrá ser profesor de la universidad:\n\n" +
                    "   a) Quien haya sido condenado por sentencia judicial a pena privativa de la libertad, excepto por delitos culposos.\n" +
                    "   b) Quien haya sido miembro de corporaciones públicas y en ejercicio de sus funciones haya perdido la investidura por hechos reñidos con la ética pública.\n" +
                    "   c) Los extranjeros que hayan perdido la nacionalidad colombiana por adopción, excepto el caso de renuncia (Art. 24 Ley 43/93).\n" +
                    "   d) Quien haya renunciado a la nacionalidad colombiana y actúe contra los intereses del Estado.\n" +
                    "   e) Quien por acto de autoridad competente, haya recibido cancelación o suspensión de su título profesional, ó de la licencia para ejercer la profesión.\n" +
                    "   f) Quien haya sido destituido o desvinculado de instituciones de educación oficial o privada por faltas graves en el ejercicio de la actividad docente.\n" +
                    "   g) Quien sea adicto al alcohol, o a cualquier tipo de fármaco que produzca dependencia.\n" +
                    "   h) Quien por faltas contra la ética, haya sido suspendido temporal o definitivamente del ejercicio profesional.\n" +
                    "   i) Quien estando sujeto a la ley 200 de 1995 (Código Disciplinario), haya sido sancionado disciplinariamente con suspensión o destitución en el empleo, como consecuencia de una falta grave.\n" +
                    "   j) Quien haya sido autor o partícipe de escándalo que atente contra la moralidad pública o las buenas costumbres.\n" +
                    "   k) Quien incurra en comportamientos que atenten contra la buena imagen de la Universidad, de sus directivas o de su cuerpo docente.\n" +
                    "   l) Quien con su conducta dé mal ejemplo a los educandos o lesione la dignidad, libertades y derechos individuales de los estudiantes.\n");
            listItem.put(listGroup.get(5), list6);
            //Pregunta7
            List<String> list7 = new ArrayList<>();
            list7.add("Los funcionarios de la institución con labores de dirección académica o administrativa no podrán ejercer en otras instituciones educativas a menos que tengan convenio con la UNAB.\n");
            listItem.put(listGroup.get(6), list7);
            //Pregunta8
            List<String> list8 = new ArrayList<>();
            list8.add("Los profesores les está prohibido: \n\n" +
                    "   a) Acudir a la Universidad bajo los efectos del alcohol, de sustancias alucinógenas o psicoactivas. \n" +
                    "   b) Solicitar a los alumnos, o recibir de ellos, dineros o dádivas de cualquier especie a cambio de modificaciones o preferencias en los procesos evaluativos, ó cuando sean valores correspondientes a la UNAB.\n" +
                    "   c) Efectuar evaluaciones a los alumnos fuera de los espacios o ámbitos propios de la Universidad. \n" +
                    "   d) Incurrir en inasistencia injustificada superior al 20 % o más del horario programado en cada período académico. \n" +
                    "   e) Cualquier comportamiento interno o externo que escandalice, contraríen la ética pública o la ley, o que sea objeto de sanción privativa de la libertad, salvo inculpaciones relativas a la libertad de expresión, pensamiento o credo religioso o político. \n" +
                    "   f) Portar armas de cualquier tipo, salvo en los casos excepcionales permitidos por la autoridad competente, ó por la Rectoría. \n" +
                    "   g) No realizar personalmente la labor académica, salvo en los eventos autorizados por la decanatura o Vicerrectoría académica. \n" +
                    "   h) Dar a conocer  temas  concretos  de evaluación de manera anticipada. \n" +
                    "   i) Utilizar la cátedra para hacer apología del delito, o para presionar a los estudiantes a votar por candidatos, grupos o partidos políticos determinados. O, valiéndose de su posición, hacer rifas, colectas, o suscripciones para provecho propio o de cualquier grupo o asociación de carácter filosófico, religioso, político o comercial. \n" +
                    "   j) Utilizar  los elementos de trabajo suministrados por la Universidad para destinarlos a fines distintos de la  actividad contratada. \n" +
                    "   k) Hacer proposiciones  indecorosas o incurrir  en comportamientos que atenten contra la libertad y el honor sexual de las personas.\n" +
                    "La violación por parte del profesor de las obligaciones, responsabilidades, deberes ó prohibiciones establcecidas en este reglamento, causa la terminación unilateral del contrato por parte de la Universidad, teniendo en cuenta en cada caso la naturaleza del vínculo jurídico.\n");
            listItem.put(listGroup.get(7), list8);
        }

//Titulo4

            if (numero==4){
                //Pregunta1
                List<String> list1 = new ArrayList<>();
                list1.add("La evaluación del profesorado tiene como objetivo calificar la actuación integral del profesor en el campo de la docencia y garantizar su mejoramiento permanente.\n" +
                        "La evaluación del desempeño del profesor en la UNAB tiene el carácter de proceso mediante el cual:\n\n" +
                        "   a) El profesor logre aumentar progresivamente su comprensión acerca de su propia labor y del papel que ésta desempeña en la tarea de hacer realidad los ideales educativos de la institución en cada Facultad. Por tanto, debe ayudarle a discernir para comprender sus responsabilidades en relación con el alumno, con el currículum, con la administración, a analizar sus propios logros y dificultades en cada una de las áreas de desempeño,  y a crear estrategias de mejoramiento. \n" +
                        "   b) La institución tenga información ágil y concreta que le permita: \n" +
                        "       I) Conocer oportunamente las dificultades que tienen los profesores al desarrollar las acciones de formación, enseñanza y administración del currículum, para aplicar los correctivos necesarios. \n" +
                        "       II) Ofrecer a los docentes programas de actualización y perfeccionamiento en las áreas débiles. \n" +
                        "       III) Elevar la cultura institucional y la calidad académica, mediante las aptitudes calificadas de sus docentes. \n" +
                        "       IV) Crear sistemas de estímulos y reconocimientos que propicien la permanencia de profesores de alta calidad.\n" +
                        "La evaluación del profesor se hará desde las siguientes perspectivas: hermenéutica, crítico-analitica, desarrollo intelectual y, adopción de decisiones. Además, tendrá en cuenta tres aspectos: \n\n" +
                        "   a) La autoevaluación.\n" +
                        "   b) La coevaluación.\n" +
                        "   c) La heteroevaluación.\n" +
                        "El profesor realiza su autoevaluación tomando como base el portafolio personal en el cual se registra su experiencia académica. Cada profesor debe responder de su propio progreso investigativo y de su saber pedagógico, mediante autoevaluación constante acerca de los procesos de docencia que, se desprenden de los planes de acción individual que haga desde la iniciación del semestre académico en su portafolio personal. Serán contenidos del portafolio del profesor: \n\n" +
                        "   a) Comentarios bibliográficos.\n" +
                        "   b) Síntesis de elaboraciones escritas: ensayos, artículos publicados, módulo de asignaturas, ponencias, cartillas, proyectos y tesis.\n" +
                        "   c) Autobiografía intelectual.\n" +
                        "   d) Certificados de asistencia a seminarios, cursos, encuentros, congresos, y demás eventos relacionados con el campo o área de su competencia profesional.\n" +
                        "El segundo momento de la evaluación docente es la coevaluación, que consiste en la apreciación de los logros del profesor por la comunidad académica. La  comunidad académica y científica de la universidad se basará en los seminarios investigativos de docentes de cada Facultad, y en los demás seminarios permanentes o temporales que se programen por cualquiera de las dependencias con fines dirigidos a ampliar conocimientos; deben producir resultados concretos, memorias, protocolos, que serán objeto de continua evaluación. \n" +
                        "Los seminarios serán espacios de investigación para el cuerpo docente, distribuidos por áreas de conocimientos, y organizados en su interior con arreglo a la adopción de los programas académicos, de acuerdo con las orientaciones generales y los fundamentos del plan curricular. \n" +
                        "Todo profesor que tenga a su cargo una cátedra, un seminario o un taller, deberá asistir y participar activamente en los seminarios de área o generales, con el propósito de conocer el proyecto educativo y traducir en su práctica las acciones, los valores y los principios de la visión y misión institucional.\n" +
                        "Las decanaturas, con el apoyo de los comités curriculares y Consejos de Facultad tienen la responsabilidad de planear y programar las agendas semestrales para los seminarios de área y generales, para dotarlos de los medios conducentes a su funcionamiento. \n" +
                        "La coevaluación o evaluación por pares se hará sobre los siguientes espacios:\n\n" +
                        "   a) El  seminario investigativo de área.\n" +
                        "   b) El seminario investigativo de carrera.\n" +
                        "   c) Los seminarios permanentes del Proyecto Educativo Institucional.\n" +
                        "   d) En las asociaciones gremiales de profesionales, o en organizaciones científicas con las cuales se establezcan convenios académicos.\n" +
                        "   e) En otras facultades similares de universidades nacionales o extranjeras con las cuales se celebren convenios e intercambios culturales o científicos.\n" +
                        "Para efectos de la aplicación de la coevaluación, las facultades deben organizar autónomamente las distintas instancias académicas que aseguren un espacio de interlocución permanente, para las diversas disciplinas o áreas de conocimiento que participen en un objetivo o proyecto común.\n" +
                        "La heteroevaluación constituye el tercer momento de la evaluación, y consiste en el intercambio de distintos registros provenientes de las instancias o estamentos académicos de estudiantes, coordinadores y decanos.\n" +
                        "La heteroevaluación es un juicio objetivo sobre la calidad integral del desempeño docente, que, unido a los datos aportados por la autoevaluación y la coevaluación, facilite emitir juicios de valor integrados, acerca de la forma como el profesor responde a las expectativas de la Facultad y  a las funciones que ésta le delega.\n" +
                        "La Institución debe evaluar al docente en aspectos básicos como:\n\n" +
                        "   a) Compromiso con la institución.\n" +
                        "   b) Compromiso con la formación del estudiante: como persona, como ser ético como ciudadano y como profesional.\n" +
                        "   c) Conocimiento de la disciplina a su cargo.\n" +
                        "   d) Conocimiento y habilidades para el ejercicio docente y la gestión del aprendizaje.\n" +
                        "   e) Actitud investigativa.\n" +
                        "   f) Calidades personales referentes al ejercicio ciudadano teniendo presente el ideal de la persona UNAB.\n" +
                        "El proceso de evaluación descrito en el presente Reglamento se realizará semestralmente para cada profesor. El resultado de la evaluación semestral se expresará en términos cualitativos y se calificará de excelente, buena, regular o mala. \n" +
                        "El proceso de evaluación lo adelantará en la Universidad el Comité de Evaluación Profesoral conformado en cada Facultad por:\n\n" +
                        "   a) El Decano.\n" +
                        "   b) El jefe del Departamento o área a la cual pertenezca el docente a quien se va a evaluar.\n" +
                        "   c) El representante de los profesores ante el Consejo de Facultad. \n" +
                        "   d) El Vicerrector Académico o su delegado, harán parte del Comité cuando se evalúe la actividad docente de los Jefes de Departamento o de Unidad Académica. El profesor que reciba una evaluación no satisfactoria,  dentro de los cinco (5) días hábiles siguientes al de la notificación, podrá interponer por escrito el recurso de reposición ante el Comité y subsidiariamente el de apelación ante la Vicerrectoría Académica. Cada recurso  deberá  resolverse en el término de diez (10) días hábiles, contados desde la fecha de su presentación.\n");
                listItem.put(listGroup.get(0), list1);
            }

//Titulo5

        if (numero==5){
            //Pregunta1
            List<String> list1 = new ArrayList<>();
            list1.add("Por acción disciplinaria se entiende la facultad de que está dotada la Universidad para investigar, y sancionar a los responsables de hechos violatorios del presente reglamento. En cada proceso disciplinario se garantizará al profesor el derecho a su defensa, para lo cual podrá presentar descargos, y solicitar la práctica de pruebas conducentes. \n" +
                    "Las siguientes acciones dan a lugar un proceso disciplinario: \n\n" +
                    "   a) Incumplimiento de los deberes del docente.\n" +
                    "   b) Incompatibilidades.\n" +
                    "   c) Inhabilidades previstas en este reglamento y las establecidas en la constitución o ley nacional. \n");
            listItem.put(listGroup.get(0), list1);
            //Pregunta2
            List<String> list2 = new ArrayList<>();
            list2.add(" a) Practicar evaluaciones no coherentes con el proceso ético formativo que el profesor desarrolle en su clase.\n" +
                    "   b) Faltas de puntualidad sin excusa válida a clases, talleres y seminarios.\n" +
                    "   c) No asistir sin excusa válida a reuniones de coordinación.\n" +
                    "   d) No colaborar en las actividades académicas de la Universidad.\n" +
                    "   e) No entregar notas de calificación dentro de los límites establecidos por el cronograma académico.\n" +
                    "   f) No acatar las instrucciones u órdenes dadas por las autoridades administrativas y académicas de la Universidad, cuando su carácter no constituya falta grave.\n" +
                    "   g) No atender las instrucciones y sugerencias derivadas de las evaluaciones docentes.\n" +
                    "   h) No desarrollar el currículum de la asignatura de acuerdo con la temática del plan de estudios.\n" +
                    "   i) Cualquier alusión o referencia pública o privada injustificada, respecto de un resultado evaluativo negativo para los alumnos.\n");
            listItem.put(listGroup.get(1), list2);
            //Pregunta3
            List<String> list3 = new ArrayList<>();
            list3.add(" a) Llamado de atención privada, por citación a la oficina del Decano.\n" +
                    "   b) Llamado de atención escrita por el Decano. \n");
            listItem.put(listGroup.get(2), list3);
            //Pregunta4
            List<String> list4 = new ArrayList<>();
            list4.add("Si el docente incurre en alguna de las faltas mencionadas previamente, esto dará pie para la cancelación de su contrato, ya sea laboral o de prestación de servicios. \n");
            listItem.put(listGroup.get(3), list4);
            //Pregunta5
            List<String> list5 = new ArrayList<>();
            list5.add("   a) El derecho del profesor a conocer el informe y las pruebas que se alleguen para el análisis del caso.\n" +
                    "   b) El derecho del profesor a ser oído en descargos y a solicitar la práctica de las pruebas que considere necesarias.\n" +
                    "   c) El derecho del profesor a estar asesorado y representado.\n");
            listItem.put(listGroup.get(4), list5);
            //Pregunta5
            List<String> list6 = new ArrayList<>();
            list6.add(" a) Conocida la queja, o el hecho, la Universidad se documentará acerca de lo ocurrido.\n" +
                    "   b) Si de la documentación examinada se concluye que existe falta disciplinaria se citará al profesor a audiencia de descargos ante el Decano respectivo, y concluida ésta se practicarán las pruebas conducentes por él solicitadas; el Decano estudiará y decidirá aplicando la sanción, si a ésta hubiere lugar.\n" +
                    "   c) La decisión del Decano es apelable ante la Vicerrectoría Académica dentro de los tres (3) días hábiles siguientes a la notificación personal de la sanción, de que se avisará al profesor a su dirección registrada en la Oficina de Personal de la Universidad.\n" +
                    "   d) Las sanciones disciplinarias no son acumulables. Tanto la sanción como su apelación se decidirán mediante resolución motivada, la cual se le entregará una copia al profesor, dejando otra agregada a su hoja de vida.\n");
            listItem.put(listGroup.get(5), list6);
        }

//Titulo6

        if (numero==6){
            //Pregunta1
            List<String> list1 = new ArrayList<>();
            list1.add(" a) La Junta Directiva de la UNAB puede hacer modificaciones cuando hayan propuestas o proyectos conducentes presentados por el rector y el Vicerrector Académico.\n" +
                    "   b) Bajo ninguna circunstancia este reglamento puede desmejorar la posición en el escalafón o el salario del profesor.\n" +
                    "   c) Queda facultado únicamente el Rector para expedir resoluciones que fueren pertinentes.\n");
            listItem.put(listGroup.get(0), list1);
        }


        /*List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();*/
        /*list1.add("i11");
        list1.add("i12");
        list1.add("i13");
        list2.add("i21");
        list2.add("i22");
        list2.add("i23");
        list3.add("i31");
        list3.add("i32");
        list3.add("i33");*/
        /*listItem.put(listGroup.get(0), list1);
        listItem.put(listGroup.get(1), list2);
        listItem.put(listGroup.get(2), list3);*/
        adapter.notifyDataSetChanged();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            new Intent(this, TitleFragment.class);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}