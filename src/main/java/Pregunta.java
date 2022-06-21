/**
 * Modela una prregunta para una encuesta.
 *
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class Pregunta {

    /** La pregunta asociada */
    private String pregunta;

    //Constructores

    /**
     * Constructor de pregunta .
     * @param pregunta Pregunta
     */
    public Pregunta( String pregunta){
        this.pregunta  = pregunta;
    }


    @Override
    public String toString() {
        return pregunta;
    }
}
