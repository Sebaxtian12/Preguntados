package co.edu.unab.parra.cristian.reprofunab.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.unab.parra.cristian.reprofunab.Adapters.AdapterDetalle;
import co.edu.unab.parra.cristian.reprofunab.Model.Title;
import co.edu.unab.parra.cristian.reprofunab.R;

public class Detalle extends AppCompatActivity {
    ExpandableListView expandibleListView;
    List<String> listGroup;
    HashMap<String, List<String>> listItem;
    AdapterDetalle adapter;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

          ImageView atras=findViewById(R.id.flecha);

        atras.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        finish();
                        break;
                    case MotionEvent.ACTION_UP:
                        view.performClick();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        Bundle datos= getIntent().getExtras();
        Title myTitle= (Title) datos.getSerializable("Titulosxd");
        int numero = Integer.parseInt(myTitle.getNumero());
        List<String> preguntas = myTitle.getPreguntas();
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
                    "   a. Conocer el Proyecto Educativo Institucional\n" +
                    "   b. Recibir la educación integral propuesta en el Proyecto Educativo Institucional y en los planes de estudio de cada programa.\n\n" +
                    "   c. Acceder antes del inicio del periodo académico correspondiente a la guía de cátedra de cada uno de los cursos y durante su duración, al resultado de su evaluación académica y de su proceso formativo.\n" +
                    "   d. Recibir de manera oportuna el resultado de su evaluación académica y tener efectivo acceso a los procesos de revisión y recalificación de evaluaciones, todo ello de acuerdo con el PEI y el presente reglamento.\n" +
                    "   e. Exponer y discutir en libertad y en los espacios correspondientes las ideas, teorías, conocimientos, preferencias, reconociendo y respetando el pluralismo, la diversidad y la particularidad de las formas culturales.\n" +
                    "   f. Usar adecuada y responsablemente los espacios y demás materiales e implementos educativos que la UNAB ofrece para el desarrollo de sus competencias y contribuir al buen funcionamiento y desarrollo de los servicios y recursos que ofrece la Universidad para su proceso formativo.\n" +
                    "   g. Participar responsablemente en la evaluación de las actividades institucionales cuando sean convocados, lo que incorpora el proceso de evaluación del programa, de sus docentes y de los de registro calificado y acreditación de alta calidad. 35\n" +
                    "   h. Elegir y ser elegido representante de los estudiantes en los organismos de dirección de la UNAB. \n" +
                    "   i. Recibir estímulos que la Universidad defina como reconocimiento a su desempeño académico, deportivo, cultural y liderazgo estudiantil. \n" +
                    "   j. Ser sujeto de respeto y reconocimiento de sus derechos materiales y/o morales derivados de los procesos de investigación y creatividad realizados dentro de su proceso formativo o fuera del mismo.\n" +
                    "   k. Recibir información y participar en las convocatorias para becas, pasantías, programas de intercambio que instituciones de orden nacional e internacional ofrezcan a la UNAB. \n" +
                    "   l. Representar a la Universidad en eventos académicos, científicos, artísticos, culturales o deportivos.\n" +
                    "   m. Participar en los eventos académicos, culturales, recreativos y deportivos que programe la UNAB.\n" +
                    "   n. Recibir copia del presente reglamento al inicio de su programa de formación.\n\n");



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
}