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
            list1.add("-Todo aspirante a ingresar a la UNAB deberá cumplir, dentro de las fechas establecidas, los requisitos y trámites determinados por la Institución y ceñirse al modelo educativo y plan curricular vigentes. \n" +
                    "-Quien no realice su matrícula en la fecha señalada, según el cronograma académico, podrá reservar cupo mediante solicitud formal al respectivo programa.\n\n");
            listItem.put(listGroup.get(0), list1);
            //Pregunta2
            List<String> list2 = new ArrayList<>();
            list2.add("-Inscribir los cursos en la plataforma académica institucional, de acuerdo con su plan de estudios y dentro de las fechas establecidas.\n" +
                    "-Legalizar el pago de los créditos inscritos, más los derechos pecuniarios exigidos dentro de las fechas establecidas en el cronograma académico, y antes del inicio de clases.\n\n");
            listItem.put(listGroup.get(1), list2);
            //Pregunta3
            List<String> list3 = new ArrayList<>();
            list3.add("-No ser procedente la solicitud del estudiante para ingresar al Programa de Recuperación Académica debido a la imposibilidad del restablecimiento de su PGA a un rango que permita su continuidad en el programa al que pertenece.\n" +
                    "-No aprobar satisfactoriamente el Programa de Recuperación Académica. \n" +
                    "-Obtener por segunda vez un PGA inferior a (3.00).\n" +
                    "-Ser sancionado disciplinariamente con pérdida inmediata y definitiva de la condición de estudiante UNAB.\n\n");
            listItem.put(listGroup.get(2), list3);
            //Pregunta4
            List<String> list4 = new ArrayList<>();
            list4.add("La solicitud de admisión por transferencia se realiza a través de la plataforma de admisiones de la institución, dentro de la fecha establecida en el cronograma académico, acompañada de los siguientes documentos:\n" +
                    "-Certificado de calificaciones detalladas por curso emitido por la Institución de procedencia, así como el Promedio General Acumulado (PGA), igual o superior a (3.50). \n" +
                    "-Certificado de competencias o contenidos programáticos de cada uno de los cursos cuya calificación sea igual o superior a (3.5)\n" +
                    "-Recibo de pago del valor del estudio de homologación y equivalen\n" +
                    "\n\n");
            listItem.put(listGroup.get(3), list4);
            //Pregunta5
            List<String> list5 = new ArrayList<>();
            list5.add("-Los programas de procedencia cuenten con reconocimiento aprobado por el Ministerio de Educación Nacional Colombiano o de la autoridad competente del país de origen, acompañado de la respectiva certificación. \n" +
                    "-Las actividades académicas cursadas en programas de la UNAB y aprobadas con una calificación final de (3.0) o superior.. \n" +
                    "-Las actividades académicas cursadas en programas de otras instituciones y aprobadas con una calificación final de (3.5) o superior, o su equivalente; con excepción de lo establecido en convenios vigentes interinstitucionales. \n\n");
            listItem.put(listGroup.get(4), list5);
            //Pregunta6
            List<String> list6 = new ArrayList<>();
            list6.add("-Activo. Estudiante que cuenta con uno o más cursos matriculados durante un periodo académico. \n" +
                    "-En reserva de cupo. Ha formalizado oportunamente la suspensión temporal de sus estudios. \n" +
                    "-En reintegro. Tras haber suspendido sus estudios temporalmente, solicita formalmente continuar con los mismos. \n" +
                    "-Desertor. No ha realizado matrícula en un período académico, ni formalización de reserva de cupo o retiro. \n" +
                    "-En sanción disciplinaria. Se encuentra cumpliendo la suspensión de estudios por sanción disciplinaria.\n" +
                    "-Inactivo. En los casos en que se presente una de las siguientes circunstancias: \n" +
                    "  (i) Solicitud de transferencia interna, \n" +
                    "  (ii) cuando habiendo sido admitido no se matricula ni solicita reserva de cupo dentro del siguiente año, \n" +
                    "  (iii) cuando pierde su derecho de renovar matrícula por bajo rendimiento académico o sanción disciplinaria. \n" +
                    "-g) Egresado. Ha cumplido con todos los requisitos establecidos en el currículo sin haber obtenido su título profesional. 16 \n" +
                    "-h) Graduado. Cuando la Universidad ha expedido el título y suscrito el acta de grado correspondiente.\n" +
                    "-i) Retirado. Ha formalizado su decisión voluntaria y definitiva de no continuar sus estudios en la Institución.\n\n");
            listItem.put(listGroup.get(5), list6);
            //Pregunta7
            List<String> list7 = new ArrayList<>();
            list7.add("-Normal: El estudiante con un PGA superior a (3.20). \n" +
                    "-Condicional: El estudiante que en un periodo académico obtiene un PGA entre (3.00) y (3.20). \n" +
                    "-En prueba académica: El estudiante que en un segundo periodo académico consecutivo obtiene un PGA entre (3.00) y (3.20); o el estudiante que obtiene en un periodo académico un PGA inferior a (3.00). \n" +
                    "-Fuera del Programa: El estudiante que ha perdido el derecho de renovar su matrícula por bajo rendimiento académico.\n\n");
            listItem.put(listGroup.get(6), list7);
            //Pregunta8
            List<String> list8 = new ArrayList<>();
            list8.add("Es el conjunto de políticas, criterios y orientaciones para la formación de personas, consignadas en el Proyecto Educativo Institucional, que la Universidad aplica en la ejecución de sus propuestas educativas.  Comprende los planes de estudio y actividades académicas complementarias. \n");
            listItem.put(listGroup.get(7), list8);
            //Pregunta9
            List<String> list9 = new ArrayList<>();
            list9.add("Es un esquema estructurado de contenidos de conocimientos y habilidades organizados por componentes de formación, áreas, unidades de aprendizaje, con sus respectivas actividades académicas, requeridas para una titulación debidamente reconocida por las autoridades educativas competentes.\n");
            listItem.put(listGroup.get(8), list9);
            //Pregunta10
            List<String> list10 = new ArrayList<>();
            list10.add("Es cada una de las unidades y componentes del plan de estudios que se desarrollan en un programa y dan cabida a núcleos de aprendizaje integrados a las actividades curriculares para el logro de competencias de formación. \n");
            listItem.put(listGroup.get(9), list10);
            //Pregunta11
            List<String> list11 = new ArrayList<>();
            list11.add("Los créditos académicos son la unidad de medida del trabajo académico para expresar todas las actividades que hacen parte del plan de estudios que deben cumplir los estudiantes. Un crédito académico equivale a (48) horas de trabajo académico del estudiante\n");
            listItem.put(listGroup.get(10), list11);
            //Pregunta12
            List<String> list12 = new ArrayList<>();
            list12.add("Las pruebas escritas, orales o prácticas de naturaleza cuantitativa se calificarán con notas comprendidas entre (0.0) y (5.0) y serán asignadas y registradas en el sistema académico por los profesores, en unidades y décimas. La calificación aprobatoria mínima para todas las pruebas será de (3.0). La prueba no presentada será calificada con (0.0). \n");
            listItem.put(listGroup.get(11), list12);
            //Pregunta13
            List<String> list13 = new ArrayList<>();
            list13.add("Los promedios de Período Académico (PPA) y General Acumulado (PGA) se obtienen de multiplicar la calificación final obtenida en cada módulo o curso, por el número de créditos respectivos. La suma de estos resultados se divide entre el total de créditos cursados. \n");
            listItem.put(listGroup.get(12), list13);
            //Pregunta14
            List<String> list14 = new ArrayList<>();
            list14.add("Se presentarán una sola vez por módulo o curso, cuando en el período académico obtenga una calificación final igual o superior a (2.5) y haya sido definido por el programa como habilitable.\n");
            listItem.put(listGroup.get(13), list14);
            //Pregunta15
            List<String> list15 = new ArrayList<>();
            list15.add("-Complementar los conocimientos adquiridos durante la formación académica. \n" +
                    "-Favorecer la adquisición de competencias útiles para el ejercicio profesional. \n" +
                    "-Facilitar la vinculación con organizaciones sociales y empresariales. \n" +
                    "-Fomentar la capacidad de emprendimiento. \n" +
                    "-Validar contenidos, procesos y estrategias utilizados en el currículo mediante la investigación y la estrecha relación con el entorno. \n\n");
            listItem.put(listGroup.get(14), list15);
            //Pregunta16
            List<String> list16 = new ArrayList<>();
            list16.add("Se realiza mediante una propuesta escrita de investigación en la cual el estudiante evidencia su capacidad de creatividad, análisis y producción e integración de conocimientos en la solución de problemas específicos del contexto productivo y social.\n");
            listItem.put(listGroup.get(15), list16);
            //Pregunta17
            List<String> list17 = new ArrayList<>();
            list17.add("-Tener todas las calificaciones de sus actividades académicas registradas y aprobadas en la historia académica institucional. \n" +
                    "-Acreditar el nivel de inglés exigido en el currículo y certificado por el Departamento de Lenguas de la UNAB o una prueba internacional avalada por el mismo. \n" +
                    "-Haber cursado y aprobado las actividades del componente instrumental en Informática y Bienestar Universitario definido por la Universidad. \n" +
                    "-Haber obtenido un Promedio General Acumulado igual o superior a (3.20) en el programa en que se solicita su titulación. \n" +
                    "-Diligenciar y entregar la solicitud de grado en las fechas establecidas en el cronograma académico de grados. \n" +
                    "-No estar siendo investigado dentro de un proceso disciplinario ni en cumplimiento de una sanción. \n" +
                    "-Acreditar los documentos legales y académicos exigidos para la obtención del respectivo título. Los estudiantes extranjeros deberán presentar pasaporte vigente. \n" +
                    "-Cumplir con los demás requisitos exigidos por cada programa.  \n" +
                    "-Estar a Paz y Salvo por todo concepto con la Institución y cancelar los derechos de grado exigidos por la Universidad.\n" +
                    "-Acreditar la presentación del Examen de Calidad de la Educación Superior establecido por el Estado colombiano.\n\n");
            listItem.put(listGroup.get(16), list17);
        }

//Titulo2

        if (numero==2){
            //Pregunta1
            List<String> list1 = new ArrayList<>();
            list1.add(
                    "a. Conocer el Proyecto Educativo Institucional\n" +
                    "b. Recibir la educación integral propuesta en el Proyecto Educativo Institucional y en los planes de estudio de cada programa.\n" +
                    "c. Acceder antes del inicio del periodo académico correspondiente a la guía de cátedra de cada uno de los cursos y durante su duración, al resultado de su evaluación académica y de su proceso formativo.\n" +
                    "d. Recibir de manera oportuna el resultado de su evaluación académica y tener efectivo acceso a los procesos de revisión y recalificación de evaluaciones, todo ello de acuerdo con el PEI y el presente reglamento.\n" +
                    "e. Exponer y discutir en libertad y en los espacios correspondientes las ideas, teorías, conocimientos, preferencias, reconociendo y respetando el pluralismo, la diversidad y la particularidad de las formas culturales.\n" +
                    "f. Usar adecuada y responsablemente los espacios y demás materiales e implementos educativos que la UNAB ofrece para el desarrollo de sus competencias y contribuir al buen funcionamiento y desarrollo de los servicios y recursos que ofrece la Universidad para su proceso formativo.\n" +
                    "g. Participar responsablemente en la evaluación de las actividades institucionales cuando sean convocados, lo que incorpora el proceso de evaluación del programa, de sus docentes y de los de registro calificado y acreditación de alta calidad. 35\n" +
                    "h. Elegir y ser elegido representante de los estudiantes en los organismos de dirección de la UNAB. \n" +
                    "i. Recibir estímulos que la Universidad defina como reconocimiento a su desempeño académico, deportivo, cultural y liderazgo estudiantil. \n" +
                    "j. Ser sujeto de respeto y reconocimiento de sus derechos materiales y/o morales derivados de los procesos de investigación y creatividad realizados dentro de su proceso formativo o fuera del mismo.\n" +
                    "k. Recibir información y participar en las convocatorias para becas, pasantías, programas de intercambio que instituciones de orden nacional e internacional ofrezcan a la UNAB. \n" +
                    "l. Representar a la Universidad en eventos académicos, científicos, artísticos, culturales o deportivos.\n" +
                    "m. Participar en los eventos académicos, culturales, recreativos y deportivos que programe la UNAB.\n" +
                    "n. Recibir copia del presente reglamento al inicio de su programa de formación.\n\n");
            listItem.put(listGroup.get(0), list1);
            //Pregunta2
            List<String> list2 = new ArrayList<>();
            list2.add("a. Cumplir las normas y reglamentos de la UNAB.\n" +
                    "b. Conocer y cumplir los términos establecidos en el cronograma de actividades académicas, administrativas y financieras publicado en los medios institucionales. \n" +
                    "c. Asistir a clase y demás actividades académicas programadas, de acuerdo con su matrícula dentro de un periodo académico, incluyendo las prácticas, salidas técnicas, pasantías, intercambios y las horas de estudio personal y su evaluación como parte de las actividades del proceso educativo en el aula o fuera de ella.\n" +
                    "d. Asumir los compromisos académicos y financieros derivados de su matrícula.\n" +
                    "e. Informarse de los resultados de su proceso académico en los medios de comunicación institucionales dispuestos para ello. \n" +
                    "f. Abstenerse de utilizar el nombre, imagen y símbolos de la Universidad sin autorización o en forma indebida.\n" +
                    "g. Guardar una conducta de respeto hacia el medio ambiente y todos los seres vivos y los derechos que les corresponden.\n" +
                    "h. Respetar las normas sobre propiedad intelectual, deber que incluye la abstención de cualquier forma de plagio y hacer en los trabajos académicos la correcta citación de los autores consultados.\n" +
                    "i. Guardar, en su vida académica y como miembro de la sociedad, un comportamiento ajustado a la ética ciudadana, al respeto hacia sí mismo y hacia los demás, a la tolerancia hacia la diversidad y al cumplimiento de la ley, sin perjuicio de la posibilidad de expresar su disenso en materias filosóficas, religiosas o políticas y de crear su propio conocimiento.\n" +
                    "j. Velar por la seguridad personal y la de todos los miembros de la comunidad de la UNAB.\n" +
                    "k. Portar el uniforme y/o los elementos de seguridad, cuando a ello haya lugar, y asumir el cumplimiento de las obligaciones de seguridad y prevención de accidentes, en el desarrollo de actividades curriculares y extracurriculares ya sea que se realicen dentro o fuera del entorno físico de la Universidad.\n" +
                    "l. Mantener un trato respetuoso con los miembros de la comunidad académica o personal al servicio de la Institución. \n" +
                    "m. Mantener el nivel académico exigido por la UNAB.\n" +
                    "n. Participar en los procesos de evaluación institucional y de profesores.\n" +
                    "o. Cuidar y mantener en buen estado las instalaciones de la UNAB, los bienes de uso de la comunidad universitaria y responder por los daños que ocasione. Este deber incorpora lo relacionado con el buen uso de laboratorios, libros, sistemas y cualquier otro equipo que la Universidad tenga a la disposición general o particular de los estudiantes como herramienta del proceso de aprendizaje.\n" +
                    "p. Cumplir con las actividades institucionales en que sea incluido para beneficio de su formación.\n" +
                    "q. Poner en conocimiento de la autoridad institucional competente la conducta de cualquier miembro de la UNAB que por acción, omisión o extralimitación atente contra la integridad de la comunidad universitaria o el normal desarrollo del proceso formativo.\n" +
                    "r. Abstenerse de actuar dentro del campus universitario bajo el efecto de sustancias que alteren su comportamiento y pongan en riesgo la seguridad, la tranquilidad, la salubridad y el prestigio de la comunidad universitaria. \n" +
                    "s. Asistir a los programas de acompañamiento académico y psicológico a los que sea remitido. \n" +
                    "t. Usar debidamente el carné y demás distintivos que lo acreditan como estudiante UNAB. \n" +
                    "u. Mantener los usuarios y contraseñas de acceso a los sistemas institucionales de manera confidencial e intransferible.\n" +
                    "v. Usar el correo electrónico institucional como medio de comunicación con la institución para el cumplimiento de actividades académicas y/o administrativas, de acuerdo con lo establecido en los procesos.\n" +
                    "w. Como miembro de la UNAB, usar de manera responsable y respetuosa las redes sociales. \n" +
                    "x. Llevar en alto el nombre de la UNAB en actividades académicas, escenarios de práctica y pasantías nacionales e internacionales\n \n");
            listItem.put(listGroup.get(1), list2);
        }

//Titulo3

        if (numero==3) {
            //Pregunta1
            List<String> list1 = new ArrayList<>();
            list1.add("a. Apoyar al estudiante en el análisis y toma de decisiones sobre inscripción y cancelaciones de actividades y cursos, rutas electivas, homologaciones y, en general, en todos los trámites de la gestión académica.\n" +
                    "b. Difundir oportunamente procedimientos y trámites académicos.\n" +
                    "c. Dar respuestas ágiles a solicitudes de información del estudiante.\n" +
                    "d. Brindar a los estudiantes información sobre la gestión académica y administrativa.\n" +
                    "e. Identificar necesidades e intereses de los estudiantes. \n" +
                    "f. Identificar otras formas de apoyo y acompañamiento. \n" +
                    "g. Disponer de los recursos didácticos, técnicos y físicos para el logro de la formación. \n" +
                    "h. Apoyar al estudiante para su permanencia en la Universidad y propi ciar su sentido de pertenencia. \n" +
                    "i. Contribuir al desarrollo de la autonomía del estudiante en la toma de decisiones sobre su futuro.\n" +
                    "j. Promover el uso de las estrategias de estudio independiente del estudiante en beneficio de su aprendizaje y rendimiento académico.\n");

            listItem.put(listGroup.get(0), list1);
            //Pregunta2
            List<String> list2 = new ArrayList<>();
            list2.add("Para los estudios de pregrado profesional:\n" +
                    "a) Distinción CUM LAUDE al estudiante que al terminar su programa de pregrado alcance un promedio general acumulado de cuatro, punto, dos, cinco (4.25) a cuatro, punto, cinco, cero (4.50) y éste se encuentre igual o por encima del percentil noventa y cinco (95) de los graduados de su programa en los últimos cinco años. \n" +
                    "b) Si el promedio fuere de cuatro, punto, cinco, uno (4.51) a cuatro, punto, siete, cinco (4.75) y éste se encuentre igual o por encima del percentil noventa y cinco (95) de los graduados de su programa en los últimos cinco años, se otorgará la distinción MAGNA CUM LAUDE.\n" +
                    "c) El estudiante con promedio superior a cuatro, punto, siete, cinco (4.75) y que se encuentre igual o por encima del percentil noventa y cinco (95) de los graduados de su programa en los últimos cinco años, recibirá la distinción SUMMA CUM LAUDE.\n" +
                    "2. Para los estudios de pregrado técnicos y tecnológicos:\n" +
                    "Al término de los estudios se concederá MENCIÓN DE HONOR a aquellos estudiantes que durante la carrera hubiesen obtenido un promedio general acumulado de cuatro, punto, cinco, cero (4.50) o superior y un percentil igual o superior a noventa y ocho (98) de los graduados de su programa en los últimos cinco años.\n");
            listItem.put(listGroup.get(1), list2);
            //Pregunta3
            List<String> list3 = new ArrayList<>();
            list3.add("El estudiante que obtenga una de las distinciones señaladas en este capítulo tendrá derecho por una única vez a una beca para adelantar estudios de posgrado en programas propios ofrecidos por la UNAB, según la directiva rectoral de becas vigente. Se excluyen las especialidades medico quirúrgicas.\n");
            listItem.put(listGroup.get(2), list3);
        }

//Titulo4
            if (numero==4){
                //Pregunta1
                List<String> list1 = new ArrayList<>();
                list1.add("1. Realizar cualquier conducta tipificada objetivamente en la ley penal como delito, siempre y cuando afecte los valores y principios institucionales, la con vivencia universitaria, el proceso educativo y el buen nombre de la universidad. Se excluyen todas las formas de delitos políticos y de opinión.\n" +
                        "2. Todas aquellas conductas que violen los principios y valores fundamentales de la UNAB de acuerdo con sus estatutos, el proyecto educativo institucional, la normativa interna o que afecten su buen nombre.\n" +
                        "3. Promover o participar en actividades que atenten contra el orden y seguridad de la UNAB y de los miembros de la comunidad universitaria.\n" +
                        "4. Falsificar o adulterar cualquier documento de la UNAB.\n" +
                        "5. Suplantar o hacerse suplantar para cualquier actividad relacionada con los requisitos o formalidades para la graduación previstos en el proceso educativo de la Universidad.\n" +
                        "6. Portar, usar o utilizar explosivos, armas de fuego o armas blancas o cualquier otro elemento, susceptible de causar daños a personas o bienes, en los predios o actividades universitarias.49\n" +
                        "7. La conducta intencional que tenga por efecto una grave lesión o ponga en grave riesgo la seguridad, la integridad personal o moral, la libertad, la intimidad y el honor sexual, de un miembro de la comunidad académica o personal al servicio de la Universidad.\n" +
                        "8. Comercializar, consumir o inducir al consumo de licor o de sustancias psicoactivas en los predios de la institución o en desarrollo de las actividades académicas e institucionales sin importar el lugar en donde se realizan. Se exceptúa de esta conducta el consumo moderado de bebidas alcohólicas que haya sido autorizado en eventos organizados por la UNAB.\n" +
                        "9. Engañar a las autoridades universitarias sobre el cumplimiento de requisitos académicos, administrativos y financieros establecidos por la Universidad.\n" +
                        "10. Hacer plagio o fraude académico en el desarrollo o presentación de trabajos de grado o los productos derivados del mismo. \n" +
                        "11. Recibir, dar, solicitar u ofrecer dinero, promesa remuneratoria, o cualquier tipo de provecho o ventaja, con el propósito de obtener calificaciones, beneficios o reconocimientos que no correspondan a los logros obtenidos en el proceso de aprendizaje.\n" +
                        "12. Adquirir, sustraer, divulgar o cambiar los contenidos de las evaluaciones académicas, calificaciones, o cualquier otro documento que incida en el resultado de la evaluación.\n" +
                        "13. Cualquier conducta destinada a desacatar la sanción disciplinaria o a burlar sus efectos.\n");
                listItem.put(listGroup.get(0), list1);
//pregunta2
                List<String> list2 = new ArrayList<>();
                list2.add("1. Propiciar, instigar o participar en riñas dentro de LA UNAB, salvo que constituya la falta gravísima establecida en el ordinal 3 del artículo precedente.\n" +
                        "2. Cualquier conducta de acoso sobre un miembro de la comunidad académica o personal al servicio de la Universidad que no esté determinada como gravísima.\n" +
                        "3. Incurrir en fraude académico o plagio en cualquier tipo de evaluación, trabajo o actividad académica.\n" +
                        "4. Usar el nombre, la insignia o la marca de la UNAB, el carné universitario, el uniforme, u otro documento o emblema institucional en forma fraudulenta para realizar actividades no relacionadas con el proceso académico.\n" +
                        "5. Suplantar, hacerse suplantar o simular la asistencia a evaluaciones académicas, actividades o eventos institucionales distintos a los mencionados como falta gravísima.\n" +
                        "6. Usar o permitir el uso de los códigos y claves de acceso a los servicios informáticos ofrecidos por la universidad en forma fraudulenta para la sustitución o suplantación de la identidad.\n" +
                        "7. El manejo indebido o inadecuado de documentos de uso privado, historias clínicas, expedientes judiciales o bases de datos, de acuerdo con las disposiciones particulares fijadas al respecto.\n" +
                        "8. La ausencia, el incumplimiento o el cambio no autorizado de actividades académicas programadas en los diferentes escenarios de práctica.\n" +
                        "9. Causar daños intencionales a los bienes muebles o inmuebles de la UNAB, de los escenarios de práctica, o de los lugares en que se realicen actividades académicas.\n" +
                        "10. Utilizar las instalaciones o entornos virtuales de aprendizaje dispuestos por la UNAB para fines diferentes de los académicos, salvo que haya expresa autorización por parte de la Universidad. \n" +
                        "11. El uso de las redes de información de la Universidad para fines diferentes al uso educativo.\n" +
                        "12. Toda acción que impida el libre acceso a la Universidad o a sus dependencias, o que obstaculice el desarrollo de sus actividades, la aplicación de los reglamentos vigentes, el ejercicio de los derechos o el cumplimiento de los deberes de los miembros de la comunidad educativa.\n" +
                        "13. Toda conducta que atente contra el ecosistema, la fauna o la flora del campus universitario o de su zona de influencia que no constituya falta gravísima\n\n");
                listItem.put(listGroup.get(1), list2);
//Pregunta3
                List<String> list3 = new ArrayList<>();
                list3.add("Constituye falta disciplinaria leve el incumplimiento de los deberes y el abuso de los derechos establecidos en los reglamentos de la institución, la violación al régimen de prohibiciones consagrado en la Constitución Política, la ley y los Reglamentos institucionales, la afectación a la armonía, la convivencia pacífica y el normal desarrollo académico, que incluye la participación en juegos de azar dentro de los predios de la UNAB, salvo que cualquiera de estas conductas se hayan tipificado en este reglamento como falta gravísima o grave. \n");
                listItem.put(listGroup.get(2), list3);

            }

//Titulo5

        if (numero==5){
            //Pregunta1
            List<String> list1 = new ArrayList<>();
            list1.add("-Expulsión de la Universidad que significa la pérdida inmediata y definitiva de su condición de estudiante de la UNAB, y tiene como consecuencia la pérdida del derecho a matricularse en cualquiera de sus programas académicos y la imposibilidad de obtener el grado.\n" +
                    "-Suspensión inmediata de estudios de tres (3) a cuatro (4) períodos académicos regulares consecutivos. En el evento de que el estudiante haya finalizado sus estudios o tenga la condición de egresado se tendrán en cuenta las previsiones contenidas en el art. 105 del presente reglamento, en lo pertinente.\n" +
                    "-Revocatoria del título académico otorgado para cuya aplicación la universidad deberá iniciar las acciones legales para obtener una decisión en tal sentido.\n");
            listItem.put(listGroup.get(0), list1);
            //Pregunta2
            List<String> list2 = new ArrayList<>();
            list2.add("a. Suspensión inmediata de estudios hasta por dos (2) períodos académicos regulares consecutivos. En el evento en que el estudiante ya haya finalizado el plan de estudios se tendrá en cuenta lo dispuesto en el art. 105, del presente reglamento, en lo pertinente.\n" +
                    "b. Calificación de cero, cero (0.0) en el curso.\n" +
                    "c. Calificación de cero, cero (0.0) en la prueba\n\n");
            listItem.put(listGroup.get(1), list2);
            //Pregunta3
            List<String> list3 = new ArrayList<>();
            list3.add("a. Amonestación verbal con compromiso firmado por el estudiante y sin anotación en la hoja de vida.\n" +
                    "b. Amonestación privada acompañada de un compromiso firmado por el estudiante con copia a la hoja de vida\n\n");
            listItem.put(listGroup.get(2), list3);
            //Pregunta4
            List<String> list4 = new ArrayList<>();
            list4.add("1. La identidad del posible autor o autores.\n" +
                    "2. La relación de los hechos conocidos que dieron lugar a la apertura de la investigación, la posibilidad de que sean constitutivos de falta disciplinable.\n" +
                    "3. La relación de las pruebas en que se sustentan dichos hechos y la de aquellas cuya práctica se ordena.\n\n");
            listItem.put(listGroup.get(3), list4);
            //Pregunta5
            List<String> list5 = new ArrayList<>();
            list5.add("1. Identificación del estudiante.\n" +
                    "2. Actuaciones surtidas en el término de investigación.\n" +
                    "3. La descripción de la conducta investigada indicando las circunstancias de tiempo, modo y lugar de su ocurrencia.\n" +
                    "4. Las disposiciones que se consideren eventualmente vulneradas.\n" +
                    "5. Análisis o valoración de la prueba para cada uno de los cargos.\n" +
                    "6. Falta(s) disciplinaria(s) que se considera(n) configurada(s) enunciando las posibles sanciones que correspondan a éstas.\n" +
                    "7. Respuesta a los argumentos expuestos por el estudiante, en el evento de que los hubiere hecho conocer con antelación.\n\n");
            listItem.put(listGroup.get(4), list5);
            //Pregunta6
            List<String> list6 = new ArrayList<>();
            list6.add("1. Resumen de los hechos indicando las circunstancias de tiempo, modo y lugar de su ocurrencia.\n" +
                    "2. Análisis de las pruebas en que se basa la decisión\n" +
                    "3. Análisis de la versión rendida por el estudiante, si la hubo.\n" +
                    "4. Calificación de la falta y análisis de la culpabilidad del estudiante.\n" +
                    "5. Graduación de la sanción.\n" +
                    "6. Parte resolutiva que contiene la decisión adoptada que, según el caso y con sustento en los análisis de que se da cuenta en este artículo, podrá ser absolutoria o sancionadora.\n\n");
            listItem.put(listGroup.get(5), list6);
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