import java.util.ArrayList;

/**
 * Encuesta para obtener posibles problemas del usuario. 
 * 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class EncuestaPsicologica extends Encuesta{

    private final String CONTACTO_CENTRO_SALUD = 
            "• Centro Integral de Salud Mental\n" + 
            "Periferico Sur 2905, San Jerónimo Lídice, La Magdalena Contreras, 10200 Ciudad de México, CDMX\n" + 
            "Contacto: 55 5377 2700\n";
        
    private final String CONTACTO_CENTRO_UNAM = 
            "• UNAM - Centro de Servicios Psicológicos 'Dr. Guillermo Dávila'\n" + 
            "Av. Universidad 3004, Edificio D, Sotano, Copilco Universidad, 04360 Ciudad de México, CDMX\n" +
            "Contacto: 55 5622 2309\n";

    private final String LINK_BECAS_UNAM = "https://www.becarios.unam.mx/Portal2018/";

    private final String LINK_PORTAL_EMPLEO = "https://mx.indeed.com/?from=gnav-homepage";

    /**
     * Constructor sin parametros.
     */
    public EncuestaPsicologica(){
        nombreEncuesta = "ENCUESTA PSICOLOGICA";
        super.modo = "psicologico";
        super.preguntas = new ArrayList<Pregunta>();

        llenarPreguntas();
    }

    /**
     * Crea las preguntas de la encuesta
     */
    private void llenarPreguntas(){
        preguntas.add( new Pregunta("¿Cuando te encuentras solo en vez de disfrutarlo " + 
                                    "tus pensamientos comienzan a sobrepasarte y " + 
                                    "te sientes saturado?"));
        preguntas.add( new Pregunta("¿Llegas a pensar en por qué escogiste tu carrera " + 
                                    "al grado de llorar o casi llorar por una materia?"));
        preguntas.add( new Pregunta("¿Consideras que la relación con tu familia es mala "+
                                    "al nivel de llegar a afectar tu día a día?"));
        preguntas.add( new Pregunta("¿Tienes alguna relación amorosa, de amistad, o que aun "+
                                    "que no exista ya la relación le reste paz a tu vida?"));
        preguntas.add( new Pregunta("¿Alguna vez al tener que hablar con un grupo de personas "+
                                    "te ha comenzado a faltar el aire o a temblar el cuerpo?"));
        preguntas.add( new Pregunta("¿Has tenido un ataque de desesperación en el que tu mente "+
                                    "llego al punto de simplemente no poder reaccionar?"));
        preguntas.add( new Pregunta("¿Las personas llegan a percibir tu trato como hostil o "+
                                    "agresivo de manera frecuente?"));
        preguntas.add( new Pregunta("¿Tienes que trabajar y estudiar o el dinero es un "+ 
                                    "problema constante en tu vida?"));
        preguntas.add( new Pregunta("¿Justo ahora sientes que la vida solo pasa, no sabes lo "+
                                    "que tienes, solo continuas pero sin motivación alguna?"));
    }

    /**
     * Evalua las respuestas proporcionadas y obtiene 
     * los problemas psicologicos que reflejan en una lista.
     * @param ArrayList<Boolean> Respuestas de un usuario.
     * @return ArrayList<String> Problemas psicologicos, siendo 
     * la lista vacia el caso en el que no hay tales.
     */
    public ArrayList<String> 
    obtenerProblemas(ArrayList<Boolean> respuestas){
        ArrayList<String> l = new ArrayList<>();
        anadirProblema(0,"Soledad"                  ,respuestas,l);
        anadirProblema(1,"Estres escolar"           ,respuestas,l);
        anadirProblema(2,"Problemas familiares"     ,respuestas,l);
        anadirProblema(3,"Problemas interpersonales",respuestas,l);
        anadirProblema(4,"Ansiedad leve"                 ,respuestas,l);
        anadirProblema(5,"Ansiedad moderada"                 ,respuestas,l);
        anadirProblema(6,"Ansiedad grave"                 ,respuestas,l);
        anadirProblema(7,"Problemas economicos"     ,respuestas,l);
        anadirProblema(8,"Depresion"                ,respuestas,l);

        return l;
    }

    /**
     * Agrega un problema a la lista de problemas
     * @param indicePregunta el indice de la pregunta
     * @param problema el problema a agregar
     * @param respuestas las respuestas del usuario
     * @param problemas la lista de problemas
     */
    private void anadirProblema(int indicePregunta, String problema,
                                ArrayList<Boolean> respuestas, ArrayList<String> problemas){
        if(respuestas.get(indicePregunta))
            problemas.add(problema);
    }

    
    @Override
    public String obtenerResultado(ArrayList<Boolean> respuestas){
        String c = "Te detecte los siguientes problemas:\n";
        c = anadirProblemaACadena(0,"Soledad"                  ,respuestas,c);
        c = anadirProblemaACadena(1,"Estres escolar"           ,respuestas,c);
        c = anadirProblemaACadena(2,"Problemas familiares"     ,respuestas,c);
        c = anadirProblemaACadena(3,"Problemas interpersonales",respuestas,c);
        c = anadirProblemaACadena(4,"Ansiedad leve"                 ,respuestas,c);
        c = anadirProblemaACadena(5,"Ansiedad moderada"                 ,respuestas,c);
        c = anadirProblemaACadena(6,"Ansiedad grave"                 ,respuestas,c);
        c = anadirProblemaACadena(7,"Problemas economicos"     ,respuestas,c);
        c = anadirProblemaACadena(8,"Depresion"                ,respuestas,c);

        if(c.equals("Te detecte los siguientes problemas:\n")){
            return "No se encontro ningun problema contigo :)\n";
        }

        return c;
    }

    /**
     * Regresa el problema encontrado dada la respuesta
     * @param indicePregunta el indice de la pregunta
     * @param problema el nombre del problema
     * @param respuestas la lista de respuestas
     * @param problemas la cadena de problemas
     * @return el problema hayado dada la respuesta
     */
    private String anadirProblemaACadena(int indicePregunta, String problema,
                                ArrayList<Boolean> respuestas, String problemas){
        if(respuestas.get(indicePregunta))
            problemas += "* " + problema + "\n";

        return problemas;
    }

    /**
     * Da las recomendaciones de acuerdo a los problemas que se pasen
     * @param problemas los problemas a los que se daran la recomendacion
     * @param control el controlador de la base de datos
     * @param usuario el usuario de los problemas
     * @return la recomendacion de los problemas
     */
    public String darRecomendaciones(ArrayList<String> problemas, ControladorBDD control, UsuarioProxy usuario){

        String recomendaciones = "";
        int contAnsiedad = 0;
        
        for(int i = 0; i<problemas.size(); ++i){

            switch(problemas.get(i)){

                case "Soledad":
                    recomendaciones += "+ A veces es bueno estar un tiempo solo, pero nada es mejor que convivir con otros "+
                    "seres. Y recuerda, las personas que viven solas siempre tienen algo en su mente que estarian dispuestos "+
                    "a compartir. Además la ayuda nunca esta demás\n\n" + CONTACTO_CENTRO_SALUD + "\n";
                    break;

                case "Estres escolar":
                    recomendaciones += "+ No te presiones tanto por entregar todo, las calificaciones solo son un numero que no "+
                    "define tu conocimiento, son tus acciones la que lo definen. Los profesores o tus companeros te pueden ayudar con esto "+
                    "si se los compartes :)\n\nY la ayuda nunca viene mal\n\n"+ CONTACTO_CENTRO_SALUD + "\n" + CONTACTO_CENTRO_UNAM + "\n";
                    
                    break;

                case "Problemas familiares":
                    recomendaciones += "+ No te enfoques mucho en los problemas familiares, ya que estos te afectan aunque no lo sepas, "+
                    "sacudete de todas las penas y vuelve a ver la vida con mas con otros ojos, no estas solo\n\n" + CONTACTO_CENTRO_SALUD + "\n";
                    break;

                case "Problemas interpersonales":
                    recomendaciones += "+ Recuerda esto, cualquier persona que te dedique tiempo y esfuerzo llenara tu vida de alegria y paz.\n\n" + 
                    CONTACTO_CENTRO_SALUD + "\n" + CONTACTO_CENTRO_UNAM + "\n";
                    break;

                case "Ansiedad":
                    if(contAnsiedad<1){
                        recomendaciones += "+ Para cualquier ataque o malestar no dudes en contarselo a alguien, lo peor que puedes hacer es guardartelo, "+
                        "en el momento en que decidimos y empezamos a afrontar y tratar nuestro problema de ansiedad, empezamos a sentirnos mejor :)\n\n" + 
                        CONTACTO_CENTRO_SALUD + "\n" + CONTACTO_CENTRO_UNAM + "\n";
                        contAnsiedad++;
                    }
                    break;

                case "Problemas economicos":
                    recomendaciones += "+ ¿Haz pensado en pedir ayuda acerca de tu situacion economica actual?  No tengas miedo o pena de hacerlo, puedes pedirle a un familiar "+
                    "o amigo que te ayude, ellos con gusto lo harán. Puedes intentar vender cosas que no necesites como "+
                    "ropa, mochilas, etc.; todo eso servirá.\nBusca apoyos como becas o trabajos freelance que no te tomen mucho tiempo,\n TIP: Busca en los portales de empleo " + 
                    "'Medio tiempo' o 'Estudiantes' : \n\n" + 
                    "Portal de empleo: " + LINK_PORTAL_EMPLEO + "\n" + 
                    "Becarios UNAM: " + LINK_BECAS_UNAM + "\n";
                    break;

                case "Depresion":
                    recomendaciones += "La depresion es uno de los problemas mas comunes, no eres el unico, descuida, intenta despejar tu mente cada vez que te sientas "+
                    "abrumado o sin sentido de continuar, realizando caminatas por tu colonia, ver atardeceres, convivir con muchas personas. Lo importante es crecer positivamente "+
                    "y no recaer. Animo, tu puedes!!! :D\n\nPero sobre todo la fortaleza mas grande esta en entender cuando buscar ayuda <3\n\n"+
                    CONTACTO_CENTRO_SALUD + "\n" + CONTACTO_CENTRO_UNAM + "\n" ;
                    break;
            }

        }


        if(recomendaciones.equals("")){
            return "Sigue asi!! :)\n";
        }

        UsuarioProxy user = control.obtenerUsuarioSimilar(usuario);
        if(user != null){
            
            if(!user.getUsuarioReal().getUsuario().equals(usuario.getUsuarioReal().getUsuario())){
                        recomendaciones += "\nAqui tienes a alguien con quien puedes compartir tus experiencias :) : \n";
                        recomendaciones += "- Nombre: "+
                        user.getUsuarioReal().getNombre()+"\n Correo: "+user.getUsuarioReal().getCorreo()+
                        "\n Telefono: "+user.getUsuarioReal().getTelefono()+"\n";
            }
        }
        

        return recomendaciones;

    }
}
