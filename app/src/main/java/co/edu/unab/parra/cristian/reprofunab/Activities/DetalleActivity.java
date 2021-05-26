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