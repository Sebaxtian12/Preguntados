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
            list1.add("Estimular y orientar el desarrollo humano y profesional hacia el cumplimiento de su misi??n particular, para consolidar una comunidad cient??fica y profesoral de excelencia en sus funciones. \n");
            listItem.put(listGroup.get(0), list1);
            //Pregunta2
            List<String> list2 = new ArrayList<>();
            list2.add("Es el conjunto de principios, valores y reglas b??sicas que rige la relaci??n Universidad-profesores, donde se establecen las responsabilidades, derechos, deberes y lo referente a la carrera profesoral (perfil, selecci??n, vinculaci??n, remuneraci??n, evaluaci??n, promoci??n, inhabilidades, incompatibilidades, est??mulos, distinciones y retiro.\n");
            listItem.put(listGroup.get(1), list2);
            //Pregunta3
            List<String> list3 = new ArrayList<>();
            list3.add("Persona que desarrolla la actividad de docencia e investigaci??n, consciente del importante rol que desempe??a, vinculado a una Facultad Acad??mica de la Universidad y cumplidor del Reglamento del profesorado, entre sus caracter??sticas particulares se destacan:\n\n" +
                    "   a) Su preparaci??n acad??mica e idoneidad profesional.\n" +
                    "   b) Su tolerancia y respeto a las ideas divergentes.\n" +
                    "   c) Su creatividad y esp??ritu cr??tico.\n" +
                    "   d) Su compromiso con los principios que definen la Visi??n y Misi??n de la Universidad.\n" +
                    "   e) Sus habilidades pedag??gicas para orientar los procesos de formaci??n e instrucci??n del estudiante.\n" +
                    "   f) Su capacidad para generar, desde la c??tedra, soluciones a la problem??tica regional y nacional.\n" +
                    "   g) El ejercicio de la docencia en la investigaci??n y en el di??logo amplio.\n" +
                    "   h) La ??tica en el desempe??o integral de sus actividades personales, profesionales y pedag??gicas.\n" +
                    "   i) La actitud positiva y continua hacia su actualizaci??n cient??fica, pedag??gica y profesional.\n" +
                    "   j) Su integraci??n al proceso de conformaci??n de la comunidad acad??mica UNAB.\n");
            listItem.put(listGroup.get(2), list3);
            //Pregunta4
            List<String> list4 = new ArrayList<>();
            list4.add("A todo el profesorado de la UNAB, y tambi??n a profesores que asuman responsabilidades administrativas o acad??mico-administrativas en la instituci??n, o se encuentren en cumplimiento de una comisi??n. Autom??ticamente el docente al firmar el respectivo contrato declara conocerlo y acatarlo.\n");
            listItem.put(listGroup.get(3), list4);
        }

//Titulo2

        if (numero==2){
            //Pregunta1
            List<String> list1 = new ArrayList<>();
            list1.add(
                    "   a. Conocer el Proyecto Educativo Institucional\n" +
                    "   b. Recibir la educaci??n integral propuesta en el Proyecto Educativo Institucional y en los planes de estudio de cada programa.\n\n" +
                    "   c. Acceder antes del inicio del periodo acad??mico correspondiente a la gu??a de c??tedra de cada uno de los cursos y durante su duraci??n, al resultado de su evaluaci??n acad??mica y de su proceso formativo.\n" +
                    "   d. Recibir de manera oportuna el resultado de su evaluaci??n acad??mica y tener efectivo acceso a los procesos de revisi??n y recalificaci??n de evaluaciones, todo ello de acuerdo con el PEI y el presente reglamento.\n" +
                    "   e. Exponer y discutir en libertad y en los espacios correspondientes las ideas, teor??as, conocimientos, preferencias, reconociendo y respetando el pluralismo, la diversidad y la particularidad de las formas culturales.\n" +
                    "   f. Usar adecuada y responsablemente los espacios y dem??s materiales e implementos educativos que la UNAB ofrece para el desarrollo de sus competencias y contribuir al buen funcionamiento y desarrollo de los servicios y recursos que ofrece la Universidad para su proceso formativo.\n" +
                    "   g. Participar responsablemente en la evaluaci??n de las actividades institucionales cuando sean convocados, lo que incorpora el proceso de evaluaci??n del programa, de sus docentes y de los de registro calificado y acreditaci??n de alta calidad. 35\n" +
                    "   h. Elegir y ser elegido representante de los estudiantes en los organismos de direcci??n de la UNAB. \n" +
                    "   i. Recibir est??mulos que la Universidad defina como reconocimiento a su desempe??o acad??mico, deportivo, cultural y liderazgo estudiantil. \n" +
                    "   j. Ser sujeto de respeto y reconocimiento de sus derechos materiales y/o morales derivados de los procesos de investigaci??n y creatividad realizados dentro de su proceso formativo o fuera del mismo.\n" +
                    "   k. Recibir informaci??n y participar en las convocatorias para becas, pasant??as, programas de intercambio que instituciones de orden nacional e internacional ofrezcan a la UNAB. \n" +
                    "   l. Representar a la Universidad en eventos acad??micos, cient??ficos, art??sticos, culturales o deportivos.\n" +
                    "   m. Participar en los eventos acad??micos, culturales, recreativos y deportivos que programe la UNAB.\n" +
                    "   n. Recibir copia del presente reglamento al inicio de su programa de formaci??n.\n\n");



            listItem.put(listGroup.get(0), list1);
            //Pregunta2
            List<String> list2 = new ArrayList<>();
            list2.add("a. Cumplir las normas y reglamentos de la UNAB.\n" +
                    "b. Conocer y cumplir los t??rminos establecidos en el cronograma de actividades acad??micas, administrativas y financieras publicado en los medios institucionales. \n" +
                    "c. Asistir a clase y dem??s actividades acad??micas programadas, de acuerdo con su matr??cula dentro de un periodo acad??mico, incluyendo las pr??cticas, salidas t??cnicas, pasant??as, intercambios y las horas de estudio personal y su evaluaci??n como parte de las actividades del proceso educativo en el aula o fuera de ella.\n" +
                    "d. Asumir los compromisos acad??micos y financieros derivados de su matr??cula.\n" +
                    "e. Informarse de los resultados de su proceso acad??mico en los medios de comunicaci??n institucionales dispuestos para ello. \n" +
                    "f. Abstenerse de utilizar el nombre, imagen y s??mbolos de la Universidad sin autorizaci??n o en forma indebida.\n" +
                    "g. Guardar una conducta de respeto hacia el medio ambiente y todos los seres vivos y los derechos que les corresponden.\n" +
                    "h. Respetar las normas sobre propiedad intelectual, deber que incluye la abstenci??n de cualquier forma de plagio y hacer en los trabajos acad??micos la correcta citaci??n de los autores consultados.\n" +
                    "i. Guardar, en su vida acad??mica y como miembro de la sociedad, un comportamiento ajustado a la ??tica ciudadana, al respeto hacia s?? mismo y hacia los dem??s, a la tolerancia hacia la diversidad y al cumplimiento de la ley, sin perjuicio de la posibilidad de expresar su disenso en materias filos??ficas, religiosas o pol??ticas y de crear su propio conocimiento.\n" +
                    "j. Velar por la seguridad personal y la de todos los miembros de la comunidad de la UNAB.\n" +
                    "k. Portar el uniforme y/o los elementos de seguridad, cuando a ello haya lugar, y asumir el cumplimiento de las obligaciones de seguridad y prevenci??n de accidentes, en el desarrollo de actividades curriculares y extracurriculares ya sea que se realicen dentro o fuera del entorno f??sico de la Universidad.\n" +
                    "l. Mantener un trato respetuoso con los miembros de la comunidad acad??mica o personal al servicio de la Instituci??n. \n" +
                    "m. Mantener el nivel acad??mico exigido por la UNAB.\n" +
                    "n. Participar en los procesos de evaluaci??n institucional y de profesores.\n" +
                    "o. Cuidar y mantener en buen estado las instalaciones de la UNAB, los bienes de uso de la comunidad universitaria y responder por los da??os que ocasione. Este deber incorpora lo relacionado con el buen uso de laboratorios, libros, sistemas y cualquier otro equipo que la Universidad tenga a la disposici??n general o particular de los estudiantes como herramienta del proceso de aprendizaje.\n" +
                    "p. Cumplir con las actividades institucionales en que sea incluido para beneficio de su formaci??n.\n" +
                    "q. Poner en conocimiento de la autoridad institucional competente la conducta de cualquier miembro de la UNAB que por acci??n, omisi??n o extralimitaci??n atente contra la integridad de la comunidad universitaria o el normal desarrollo del proceso formativo.\n" +
                    "r. Abstenerse de actuar dentro del campus universitario bajo el efecto de sustancias que alteren su comportamiento y pongan en riesgo la seguridad, la tranquilidad, la salubridad y el prestigio de la comunidad universitaria. \n" +
                    "s. Asistir a los programas de acompa??amiento acad??mico y psicol??gico a los que sea remitido. \n" +
                    "t. Usar debidamente el carn?? y dem??s distintivos que lo acreditan como estudiante UNAB. \n" +
                    "u. Mantener los usuarios y contrase??as de acceso a los sistemas institucionales de manera confidencial e intransferible.\n" +
                    "v. Usar el correo electr??nico institucional como medio de comunicaci??n con la instituci??n para el cumplimiento de actividades acad??micas y/o administrativas, de acuerdo con lo establecido en los procesos.\n" +
                    "w. Como miembro de la UNAB, usar de manera responsable y respetuosa las redes sociales. \n" +
                    "x. Llevar en alto el nombre de la UNAB en actividades acad??micas, escenarios de pr??ctica y pasant??as nacionales e internacionales\n \n");
            listItem.put(listGroup.get(1), list2);

        }

//Titulo3

        if (numero==3) {
            //Pregunta1
            List<String> list1 = new ArrayList<>();
            list1.add("Un profesor en la UNAB tiene las siguientes responsabilidades:\n\n" +
                    "   a) Aportar lo necesario para fortalecer la relaci??n profesor-estudiante.\n" +
                    "   b) Asumir total responsabilidad de sus tareas como docente.\n" +
                    "   c) Contribuir a la formaci??n de los estudiantes con su ejemplo y dedicaci??n.\n" +
                    "   d) Ejercer su labor docente de acuerdo a los lineamientos de la Instituci??n.\n" +
                    "   e) Mantener comunicaci??n con el personal administrativo del programa respecto al desarrollo de las asignaturas.\n" +
                    "   f) Promover y desarrollar actividades investigativas en la instituci??n.\n" +
                    "   g) Colaborar cuando la universidad lo considere necesario en actividades fuera de su ??rea de experticia.\n" +
                    "   h) Participar en la programaci??n y ejecuci??n de evaluaciones de las asignaturas de la facultad a la que pertenece.\n" +
                    "   i) Promover y contribuir a la buena imagen de la Universidad delante de la comunidad.\n");
            listItem.put(listGroup.get(0), list1);
            //Pregunta2
            List<String> list2 = new ArrayList<>();
            list2.add("Son derechos del profesor:\n\n" +
                    "   a) El ejercicio de todos los derechos y garant??as consagrados en la Constituci??n Pol??tica de Colombia.\n" +
                    "   b) El pleno ejercicio de la libertad de ense??anza, aprendizaje, investigaci??n y c??tedra de acuerdo con la Ley Fundamental, los Estatutos y los Reglamentos de la Universidad.\n" +
                    "   c) Participar en la elaboraci??n de propuestas en materia acad??mica, acordes con las pol??ticas institucionales.\n" +
                    "   d) Participar en los planes de capacitaci??n y mejoramiento pedag??gicos, cient??ficos y t??cnicos, de acuerdo con los planes y pol??ticas de la Instituci??n y del campo de formaci??n del profesor.\n" +
                    "   e) Elegir y ser elegido para las representaciones profesorales ante el Consejo Acad??mico, los Consejos de Facultad, y otros en los que la Universidad establezca representaci??n del profesorado.\n" +
                    "   f) Recibir tratamiento respetuoso por parte de todos los miembros de la comunidad acad??mica.\n" +
                    "   g) Participar y usufructuar de la propiedad intelectual y derechos de autor, en su propiedad intelectual, conforme a las prescripciones legales y a los reglamentos de la Universidad.\n" +
                    "   h) Disponer de los medios necesarios para la realizaci??n de la actividad acad??mica, en condiciones de calidad, eficiencia, y seguridad industrial.\n" +
                    "   i) Recibir oportunamente la retribuci??n en dinero y el reconocimiento que le correspondan conforme a su categor??a dentro del escalaf??n, y a las disposiciones legales vigentes que rijan la modalidad contractual de su vinculaci??n.\n" +
                    "   j) Solicitar la promoci??n en el escalaf??n docente de acuerdo con lo establecido en el presente Reglamento.\n" +
                    "   k) Disfrutar de las licencias y permisos solicitados con causa justificada.\n" +
                    "   l) Gozar de las actividades de bienestar universitario ofrecidas por la Universidad.\n" +
                    "   m) Gozar de los est??mulos consagrados en este Reglamento y de los que adicionalmente pueda reconocer la Universidad.\n" +
                    "   n) Conocer y hacer parte del proceso de evaluaci??n de su desempe??o: ser notificado oportunamente del resultado, y utilizar los recursos de reposici??n y apelaci??n que sean del caso.\n\n");
            listItem.put(listGroup.get(1), list2);
            //Pregunta3
            List<String> list3 = new ArrayList<>();
            list3.add("Son deberes de los profesores:\n\n" +
                    "   a) Conocer y cumplir las obligaciones que se derivan de la Constituci??n Pol??tica de Colombia, de las leyes de la Rep??blica, de los Estatutos y reglamentos de la Universidad.\n" +
                    "   b) Observar las normas inherentes a la ??tica profesional y a su condici??n de docente.\n" +
                    "   c) Cumplir su compromiso con la Misi??n y el Proyecto Educativo de la Universidad.\n" +
                    "   d) Desempe??ar con responsabilidad y eficiencia las funciones inherentes a su ejercicio docente y a las actividades que le sean confiadas.\n" +
                    "   e) Participar en el proceso de evaluaci??n integral de aprendizaje del estudiante, e informar oportunamente sus resultados a los alumnos y a la Facultad correspondiente.\n" +
                    "   f) Cumplir el horario convenido en el contrato celebrado con la Universidad.\n" +
                    "   g) Elaborar, presentar y actualizar oportunamente, los programas de las asignaturas a su cargo, y desarrollarlos de acuerdo con los lineamientos definidos por las Facultades y la Universidad.\n" +
                    "   h) Dar tratamiento respetuoso a todos los miembros de la comunidad acad??mica.\n" +
                    "   i) Preservar las instalaciones, equipos y elementos de apoyo acad??mico de la Universidad y, responder por los da??os y p??rdidas de los bienes confiados a su guarda o administraci??n.\n" +
                    "   j) Coordinar la actividad acad??mica con los profesores de la misma asignatura atendiendo criterios de gesti??n curricular que permitan articular sus contenidos con las l??neas, niveles y soportes pertinentes.\n" +
                    "   k) Participar en los grupos de trabajo que le sean asignados en desarrollo de los programas y planes institucionales.\n" +
                    "   l) Contribuir, con elevado ejercicio de sus responsabilidades acad??micas, al buen uso, a la guarda, engrandecimiento del nombre y del patrimonio cultural, cient??fico, t??cnico, social y f??sico de la Universidad.\n" +
                    "   m) Fomentar la educaci??n para la conservaci??n de los recursos naturales y del ambiente.\n" +
                    "   n) Participar en las actividades de perfeccionamiento docente y de capacitaci??n profesional.\n" +
                    "   o) Respetar los derechos de producci??n intelectual, la propiedad industrial y derechos de autor que correspondan a la Universidad, o a terceros, de acuerdo con la Ley y las normas institucionales.\n" +
                    "   p) Ejercer la actividad acad??mica con dinamismo intelectual, respetando diferencias de credos e ideolog??as de los educandos.\n" +
                    "   q) Participar en el proceso de evaluaci??n de su desempe??o acad??mico.\n" +
                    "   r) Participar activamente en la construcci??n y actualizaci??n de su portafolio docente.\n");
            listItem.put(listGroup.get(2), list3);
            //Pregunta4
            List<String> list4 = new ArrayList<>();
            list4.add("S??, los est??mulos tienen como objetivo elevar la excelencia del profesorado y en tal virtud, el profesor tiene derecho a participar en los programas de estudios avanzados, actualizaci??n de conocimientos, capacitaci??n, complementaci??n y desarrollo human??stico, cient??fico, t??cnico o art??stico, de acuerdo con los planes y pol??ticas institucionales y con sus propios intereses.\n");
            listItem.put(listGroup.get(3), list4);
            //Pregunta5
            List<String> list5 = new ArrayList<>();
            list5.add(" S??, la universidad reconocer?? calidades docentes, investigativas y de proyecci??n al profesorado. Son reconocimientos para los profesores:\n \n" +
                    "   a) Profesor Distinguido: Aquel profesor que destaque por sus contribuciones sobresalientes a la ciencia, arte y tecnolog??a. Igualmente se podr?? otorgar esta distinci??n al profesor que destaque en la actualizaci??n de los planes curriculares de la instituci??n o que de iniciativas meritorias a la modernizaci??n  de la actividad administrativa  de la Universidad.\n" +
                    "   b) Profesor Laureado: Aquel profesor que haya desempe??ado meritoriamente labores como Profesor Titular por un per??odo no menor de cinco a??os y que haya recibido el reconocimiento de la comunidad acad??mica por sus trabajos de investigaci??n, sus publicaciones en revistas de reconocido prestigio, su producci??n de textos acogidos por la comunidad acad??mica nacional, y por propiedad de patentes.\n" +
                    "   c) Profesor Em??rito: Aquel profesor retirado para disfrutar su pensi??n cuando haya sobresalido en el ??mbito nacional o internacional por sus contribuciones a la ciencia, al arte, a la t??cnica, a la administraci??n p??blica o a la educaci??n superior a lo largo de su carrera.\n");
            listItem.put(listGroup.get(4), list5);
            //Pregunta6
            List<String> list6 = new ArrayList<>();
            list6.add("No podr?? ser profesor de la universidad:\n\n" +
                    "   a) Quien haya sido condenado por sentencia judicial a pena privativa de la libertad, excepto por delitos culposos.\n" +
                    "   b) Quien haya sido miembro de corporaciones p??blicas y en ejercicio de sus funciones haya perdido la investidura por hechos re??idos con la ??tica p??blica.\n" +
                    "   c) Los extranjeros que hayan perdido la nacionalidad colombiana por adopci??n, excepto el caso de renuncia (Art. 24 Ley 43/93).\n" +
                    "   d) Quien haya renunciado a la nacionalidad colombiana y act??e contra los intereses del Estado.\n" +
                    "   e) Quien por acto de autoridad competente, haya recibido cancelaci??n o suspensi??n de su t??tulo profesional, ?? de la licencia para ejercer la profesi??n.\n" +
                    "   f) Quien haya sido destituido o desvinculado de instituciones de educaci??n oficial o privada por faltas graves en el ejercicio de la actividad docente.\n" +
                    "   g) Quien sea adicto al alcohol, o a cualquier tipo de f??rmaco que produzca dependencia.\n" +
                    "   h) Quien por faltas contra la ??tica, haya sido suspendido temporal o definitivamente del ejercicio profesional.\n" +
                    "   i) Quien estando sujeto a la ley 200 de 1995 (C??digo Disciplinario), haya sido sancionado disciplinariamente con suspensi??n o destituci??n en el empleo, como consecuencia de una falta grave.\n" +
                    "   j) Quien haya sido autor o part??cipe de esc??ndalo que atente contra la moralidad p??blica o las buenas costumbres.\n" +
                    "   k) Quien incurra en comportamientos que atenten contra la buena imagen de la Universidad, de sus directivas o de su cuerpo docente.\n" +
                    "   l) Quien con su conducta d?? mal ejemplo a los educandos o lesione la dignidad, libertades y derechos individuales de los estudiantes.\n");
            listItem.put(listGroup.get(5), list6);
            //Pregunta7
            List<String> list7 = new ArrayList<>();
            list7.add("Los funcionarios de la instituci??n con labores de direcci??n acad??mica o administrativa no podr??n ejercer en otras instituciones educativas a menos que tengan convenio con la UNAB.\n");
            listItem.put(listGroup.get(6), list7);
            //Pregunta8
            List<String> list8 = new ArrayList<>();
            list8.add("Los profesores les est?? prohibido: \n\n" +
                    "   a) Acudir a la Universidad bajo los efectos del alcohol, de sustancias alucin??genas o psicoactivas. \n" +
                    "   b) Solicitar a los alumnos, o recibir de ellos, dineros o d??divas de cualquier especie a cambio de modificaciones o preferencias en los procesos evaluativos, ?? cuando sean valores correspondientes a la UNAB.\n" +
                    "   c) Efectuar evaluaciones a los alumnos fuera de los espacios o ??mbitos propios de la Universidad. \n" +
                    "   d) Incurrir en inasistencia injustificada superior al 20 % o m??s del horario programado en cada per??odo acad??mico. \n" +
                    "   e) Cualquier comportamiento interno o externo que escandalice, contrar??en la ??tica p??blica o la ley, o que sea objeto de sanci??n privativa de la libertad, salvo inculpaciones relativas a la libertad de expresi??n, pensamiento o credo religioso o pol??tico. \n" +
                    "   f) Portar armas de cualquier tipo, salvo en los casos excepcionales permitidos por la autoridad competente, ?? por la Rector??a. \n" +
                    "   g) No realizar personalmente la labor acad??mica, salvo en los eventos autorizados por la decanatura o Vicerrector??a acad??mica. \n" +
                    "   h) Dar a conocer  temas  concretos  de evaluaci??n de manera anticipada. \n" +
                    "   i) Utilizar la c??tedra para hacer apolog??a del delito, o para presionar a los estudiantes a votar por candidatos, grupos o partidos pol??ticos determinados. O, vali??ndose de su posici??n, hacer rifas, colectas, o suscripciones para provecho propio o de cualquier grupo o asociaci??n de car??cter filos??fico, religioso, pol??tico o comercial. \n" +
                    "   j) Utilizar  los elementos de trabajo suministrados por la Universidad para destinarlos a fines distintos de la  actividad contratada. \n" +
                    "   k) Hacer proposiciones  indecorosas o incurrir  en comportamientos que atenten contra la libertad y el honor sexual de las personas.\n" +
                    "La violaci??n por parte del profesor de las obligaciones, responsabilidades, deberes ?? prohibiciones establcecidas en este reglamento, causa la terminaci??n unilateral del contrato por parte de la Universidad, teniendo en cuenta en cada caso la naturaleza del v??nculo jur??dico.\n");
            listItem.put(listGroup.get(7), list8);
        }

//Titulo4

            if (numero==4){
                //Pregunta1
                List<String> list1 = new ArrayList<>();
                list1.add("La evaluaci??n del profesorado tiene como objetivo calificar la actuaci??n integral del profesor en el campo de la docencia y garantizar su mejoramiento permanente.\n" +
                        "La evaluaci??n del desempe??o del profesor en la UNAB tiene el car??cter de proceso mediante el cual:\n\n" +
                        "   a) El profesor logre aumentar progresivamente su comprensi??n acerca de su propia labor y del papel que ??sta desempe??a en la tarea de hacer realidad los ideales educativos de la instituci??n en cada Facultad. Por tanto, debe ayudarle a discernir para comprender sus responsabilidades en relaci??n con el alumno, con el curr??culum, con la administraci??n, a analizar sus propios logros y dificultades en cada una de las ??reas de desempe??o,  y a crear estrategias de mejoramiento. \n" +
                        "   b) La instituci??n tenga informaci??n ??gil y concreta que le permita: \n" +
                        "       I) Conocer oportunamente las dificultades que tienen los profesores al desarrollar las acciones de formaci??n, ense??anza y administraci??n del curr??culum, para aplicar los correctivos necesarios. \n" +
                        "       II) Ofrecer a los docentes programas de actualizaci??n y perfeccionamiento en las ??reas d??biles. \n" +
                        "       III) Elevar la cultura institucional y la calidad acad??mica, mediante las aptitudes calificadas de sus docentes. \n" +
                        "       IV) Crear sistemas de est??mulos y reconocimientos que propicien la permanencia de profesores de alta calidad.\n" +
                        "La evaluaci??n del profesor se har?? desde las siguientes perspectivas: hermen??utica, cr??tico-analitica, desarrollo intelectual y, adopci??n de decisiones. Adem??s, tendr?? en cuenta tres aspectos: \n\n" +
                        "   a) La autoevaluaci??n.\n" +
                        "   b) La coevaluaci??n.\n" +
                        "   c) La heteroevaluaci??n.\n" +
                        "El profesor realiza su autoevaluaci??n tomando como base el portafolio personal en el cual se registra su experiencia acad??mica. Cada profesor debe responder de su propio progreso investigativo y de su saber pedag??gico, mediante autoevaluaci??n constante acerca de los procesos de docencia que, se desprenden de los planes de acci??n individual que haga desde la iniciaci??n del semestre acad??mico en su portafolio personal. Ser??n contenidos del portafolio del profesor: \n\n" +
                        "   a) Comentarios bibliogr??ficos.\n" +
                        "   b) S??ntesis de elaboraciones escritas: ensayos, art??culos publicados, m??dulo de asignaturas, ponencias, cartillas, proyectos y tesis.\n" +
                        "   c) Autobiograf??a intelectual.\n" +
                        "   d) Certificados de asistencia a seminarios, cursos, encuentros, congresos, y dem??s eventos relacionados con el campo o ??rea de su competencia profesional.\n" +
                        "El segundo momento de la evaluaci??n docente es la coevaluaci??n, que consiste en la apreciaci??n de los logros del profesor por la comunidad acad??mica. La  comunidad acad??mica y cient??fica de la universidad se basar?? en los seminarios investigativos de docentes de cada Facultad, y en los dem??s seminarios permanentes o temporales que se programen por cualquiera de las dependencias con fines dirigidos a ampliar conocimientos; deben producir resultados concretos, memorias, protocolos, que ser??n objeto de continua evaluaci??n. \n" +
                        "Los seminarios ser??n espacios de investigaci??n para el cuerpo docente, distribuidos por ??reas de conocimientos, y organizados en su interior con arreglo a la adopci??n de los programas acad??micos, de acuerdo con las orientaciones generales y los fundamentos del plan curricular. \n" +
                        "Todo profesor que tenga a su cargo una c??tedra, un seminario o un taller, deber?? asistir y participar activamente en los seminarios de ??rea o generales, con el prop??sito de conocer el proyecto educativo y traducir en su pr??ctica las acciones, los valores y los principios de la visi??n y misi??n institucional.\n" +
                        "Las decanaturas, con el apoyo de los comit??s curriculares y Consejos de Facultad tienen la responsabilidad de planear y programar las agendas semestrales para los seminarios de ??rea y generales, para dotarlos de los medios conducentes a su funcionamiento. \n" +
                        "La coevaluaci??n o evaluaci??n por pares se har?? sobre los siguientes espacios:\n\n" +
                        "   a) El  seminario investigativo de ??rea.\n" +
                        "   b) El seminario investigativo de carrera.\n" +
                        "   c) Los seminarios permanentes del Proyecto Educativo Institucional.\n" +
                        "   d) En las asociaciones gremiales de profesionales, o en organizaciones cient??ficas con las cuales se establezcan convenios acad??micos.\n" +
                        "   e) En otras facultades similares de universidades nacionales o extranjeras con las cuales se celebren convenios e intercambios culturales o cient??ficos.\n" +
                        "Para efectos de la aplicaci??n de la coevaluaci??n, las facultades deben organizar aut??nomamente las distintas instancias acad??micas que aseguren un espacio de interlocuci??n permanente, para las diversas disciplinas o ??reas de conocimiento que participen en un objetivo o proyecto com??n.\n" +
                        "La heteroevaluaci??n constituye el tercer momento de la evaluaci??n, y consiste en el intercambio de distintos registros provenientes de las instancias o estamentos acad??micos de estudiantes, coordinadores y decanos.\n" +
                        "La heteroevaluaci??n es un juicio objetivo sobre la calidad integral del desempe??o docente, que, unido a los datos aportados por la autoevaluaci??n y la coevaluaci??n, facilite emitir juicios de valor integrados, acerca de la forma como el profesor responde a las expectativas de la Facultad y  a las funciones que ??sta le delega.\n" +
                        "La Instituci??n debe evaluar al docente en aspectos b??sicos como:\n\n" +
                        "   a) Compromiso con la instituci??n.\n" +
                        "   b) Compromiso con la formaci??n del estudiante: como persona, como ser ??tico como ciudadano y como profesional.\n" +
                        "   c) Conocimiento de la disciplina a su cargo.\n" +
                        "   d) Conocimiento y habilidades para el ejercicio docente y la gesti??n del aprendizaje.\n" +
                        "   e) Actitud investigativa.\n" +
                        "   f) Calidades personales referentes al ejercicio ciudadano teniendo presente el ideal de la persona UNAB.\n" +
                        "El proceso de evaluaci??n descrito en el presente Reglamento se realizar?? semestralmente para cada profesor. El resultado de la evaluaci??n semestral se expresar?? en t??rminos cualitativos y se calificar?? de excelente, buena, regular o mala. \n" +
                        "El proceso de evaluaci??n lo adelantar?? en la Universidad el Comit?? de Evaluaci??n Profesoral conformado en cada Facultad por:\n\n" +
                        "   a) El Decano.\n" +
                        "   b) El jefe del Departamento o ??rea a la cual pertenezca el docente a quien se va a evaluar.\n" +
                        "   c) El representante de los profesores ante el Consejo de Facultad. \n" +
                        "   d) El Vicerrector Acad??mico o su delegado, har??n parte del Comit?? cuando se eval??e la actividad docente de los Jefes de Departamento o de Unidad Acad??mica. El profesor que reciba una evaluaci??n no satisfactoria,  dentro de los cinco (5) d??as h??biles siguientes al de la notificaci??n, podr?? interponer por escrito el recurso de reposici??n ante el Comit?? y subsidiariamente el de apelaci??n ante la Vicerrector??a Acad??mica. Cada recurso  deber??  resolverse en el t??rmino de diez (10) d??as h??biles, contados desde la fecha de su presentaci??n.\n");
                listItem.put(listGroup.get(0), list1);
            }

//Titulo5

        if (numero==5){
            //Pregunta1
            List<String> list1 = new ArrayList<>();
            list1.add("Por acci??n disciplinaria se entiende la facultad de que est?? dotada la Universidad para investigar, y sancionar a los responsables de hechos violatorios del presente reglamento. En cada proceso disciplinario se garantizar?? al profesor el derecho a su defensa, para lo cual podr?? presentar descargos, y solicitar la pr??ctica de pruebas conducentes. \n" +
                    "Las siguientes acciones dan a lugar un proceso disciplinario: \n\n" +
                    "   a) Incumplimiento de los deberes del docente.\n" +
                    "   b) Incompatibilidades.\n" +
                    "   c) Inhabilidades previstas en este reglamento y las establecidas en la constituci??n o ley nacional. \n");
            listItem.put(listGroup.get(0), list1);
            //Pregunta2
            List<String> list2 = new ArrayList<>();
            list2.add(" a) Practicar evaluaciones no coherentes con el proceso ??tico formativo que el profesor desarrolle en su clase.\n" +
                    "   b) Faltas de puntualidad sin excusa v??lida a clases, talleres y seminarios.\n" +
                    "   c) No asistir sin excusa v??lida a reuniones de coordinaci??n.\n" +
                    "   d) No colaborar en las actividades acad??micas de la Universidad.\n" +
                    "   e) No entregar notas de calificaci??n dentro de los l??mites establecidos por el cronograma acad??mico.\n" +
                    "   f) No acatar las instrucciones u ??rdenes dadas por las autoridades administrativas y acad??micas de la Universidad, cuando su car??cter no constituya falta grave.\n" +
                    "   g) No atender las instrucciones y sugerencias derivadas de las evaluaciones docentes.\n" +
                    "   h) No desarrollar el curr??culum de la asignatura de acuerdo con la tem??tica del plan de estudios.\n" +
                    "   i) Cualquier alusi??n o referencia p??blica o privada injustificada, respecto de un resultado evaluativo negativo para los alumnos.\n");
            listItem.put(listGroup.get(1), list2);
            //Pregunta3
            List<String> list3 = new ArrayList<>();
            list3.add(" a) Llamado de atenci??n privada, por citaci??n a la oficina del Decano.\n" +
                    "   b) Llamado de atenci??n escrita por el Decano. \n");
            listItem.put(listGroup.get(2), list3);
            //Pregunta4
            List<String> list4 = new ArrayList<>();
            list4.add("Si el docente incurre en alguna de las faltas mencionadas previamente, esto dar?? pie para la cancelaci??n de su contrato, ya sea laboral o de prestaci??n de servicios. \n");
            listItem.put(listGroup.get(3), list4);
            //Pregunta5
            List<String> list5 = new ArrayList<>();
            list5.add("   a) El derecho del profesor a conocer el informe y las pruebas que se alleguen para el an??lisis del caso.\n" +
                    "   b) El derecho del profesor a ser o??do en descargos y a solicitar la pr??ctica de las pruebas que considere necesarias.\n" +
                    "   c) El derecho del profesor a estar asesorado y representado.\n");
            listItem.put(listGroup.get(4), list5);
            //Pregunta5
            List<String> list6 = new ArrayList<>();
            list6.add(" a) Conocida la queja, o el hecho, la Universidad se documentar?? acerca de lo ocurrido.\n" +
                    "   b) Si de la documentaci??n examinada se concluye que existe falta disciplinaria se citar?? al profesor a audiencia de descargos ante el Decano respectivo, y concluida ??sta se practicar??n las pruebas conducentes por ??l solicitadas; el Decano estudiar?? y decidir?? aplicando la sanci??n, si a ??sta hubiere lugar.\n" +
                    "   c) La decisi??n del Decano es apelable ante la Vicerrector??a Acad??mica dentro de los tres (3) d??as h??biles siguientes a la notificaci??n personal de la sanci??n, de que se avisar?? al profesor a su direcci??n registrada en la Oficina de Personal de la Universidad.\n" +
                    "   d) Las sanciones disciplinarias no son acumulables. Tanto la sanci??n como su apelaci??n se decidir??n mediante resoluci??n motivada, la cual se le entregar?? una copia al profesor, dejando otra agregada a su hoja de vida.\n");
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