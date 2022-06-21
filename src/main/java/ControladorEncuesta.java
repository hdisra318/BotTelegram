import java.util.ArrayList;

/**
 * Controlador de la encuesta
 *
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class ControladorEncuesta {
    
    /** Encuesta actual */
    private Encuesta encuesta;

    /**
     * Constructor del controlador de la encuesta
     * @param encuesta encuesta a la que se creara el controlador
     */
    public ControladorEncuesta(Encuesta encuesta){

        this.encuesta = encuesta;
    }

    /**
     * Obtiene el resultado de la encuesta en base a las respuestas
     * @param respuestas las respuestas de la encuesta
     * @return Problemas psicologicos, siendo 
     * la cadena vacia el caso en el que no hay tales.
     */
    public String obtenerResultado(ArrayList<Boolean> respuestas){

        return encuesta.obtenerResultado(respuestas);

    }

    /**
     * Muestra la pregunta de la encuesta dado el indice
     * @param numeroPregunta el numero de la pregunta
     * @return la pregunta
     */
    public Pregunta mostrarPregunta(int numeroPregunta){

        return encuesta.mostrarPregunta(numeroPregunta);
    }


    /**
     * Regresa el numero de preguntas de la encuesta
     * @return el numero de preguntas de la encuesta
     */
    public int numeroPreguntas(){

        return encuesta.preguntas.size();
    }

    /**
     * Da las recomendaciones de acuerdo a los problemas psicologicos que se pasen
     * @param problemas los problemas a los que se daran la recomendacion
     * @param control el controlador de la base de datos
     * @param usuario el usuario de los problemas
     * @return la recomendacion de los problemas
     */
    public String darRecomendaciones(ArrayList<String> problemas, ControladorBDD control, UsuarioProxy usuario){

        return ((EncuestaPsicologica)this.encuesta).darRecomendaciones(problemas, control, usuario);
    }

    /**
     * Regresa una lista de los problemas psicologicos
     * @param respuestas las respuestas del usuario
     */
    public ArrayList<String> obtenerProblemas(ArrayList<Boolean> respuestas){

        return ((EncuestaPsicologica)this.encuesta).obtenerProblemas(respuestas);
    }


}
