import java.util.ArrayList;

/**
 * Encuestas que realiza el bot
 * 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public abstract class Encuesta {
    
    /**
     * Preguntas de la encuesta
     */
    protected ArrayList<Pregunta> preguntas;

    /**
     * Modo de la encuesta
     */
    protected String modo;


    /**
     * Nombre de la encuesta
     */
    protected String nombreEncuesta;

    /**
     * Regresa la pregunta dado el numero de esta
     * @param numeroPregunta el numero de la pregunta
     * @return la pregunta asociada al numero
     */
    public Pregunta mostrarPregunta(int numeroPregunta){
        if(numeroPregunta<0 || numeroPregunta>=preguntas.size())
            return null;

        return preguntas.get(numeroPregunta);
    }


    /**
     * Evalua las respuestas proporcionadas el resultado
     * de la  encuesta en una cadena.
     * @param ArrayList<Boolean> Respuestas de un usuario.
     * @return String   resultado de encuesta realizada..
     */
    public abstract String obtenerResultado(ArrayList<Boolean> respuestas);


    /**
     * Obtiene el modo de la encuesta: Psicologico o recreativo.
     * @return Modo
     */
    public String getModo() {
        return modo;
    }

    /**
     * Obtiene el nombre de la encuesta
     * @return nombre de encuesta
     */
    public String getNombreEncuesta() {
        return nombreEncuesta;
    }
}
