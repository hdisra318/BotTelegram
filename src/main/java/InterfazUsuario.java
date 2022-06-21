/**
 * Interfaz para el usuario
 * 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public interface  InterfazUsuario {
    
    /**
     * Agrega la respuesta dada por el usuario.
     * @param respuesta la respuesta que el usuario dio.
     * @return true si se agrego la respuesta a la estructura de datos, false en otro caso.
     */
    public boolean anadirRespuesta(String respuesta);

    /**
     * Limpia las respuestas actuales del usuario.
     * @return true si se borraron las respuestas del usuario, false en otro caso.
     */
    public boolean limpiarRespuestas();

    /**
     * Se establecen los problemas del usuario
     * @return boolean si se establecieron correctamente los problemas.
     * En caso de ser no la encuesta no ha sido terminada o no se tienen
     * suficientes datos del usuario.
     */
    public boolean establecerProblemas();
}
