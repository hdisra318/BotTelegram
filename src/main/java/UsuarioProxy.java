/**
 * Clase para tener una representacion del usuario.
 * 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class UsuarioProxy implements InterfazUsuario {

    /** Usuario al que apunta la representacion */
    private Usuario usuarioReal;

    /**
     * Constructor con un parametro.
     * @param Usuario usuario que guarda la representacion.
     */
    public UsuarioProxy(Usuario usuario){
        usuarioReal = usuario;
    }

    /**
     * Retorna el usuario que guarda la representacion.
     * @return Usuario usuario real.
     */
    public Usuario getUsuarioReal(){
        return usuarioReal;
    }

    @Override
    public boolean anadirRespuesta(String respuesta){
        respuesta = respuesta.replaceAll ("[^a-zA-Z0-9]","");
        return usuarioReal.anadirRespuesta(respuesta);
    }

    @Override
    public boolean limpiarRespuestas(){
        return usuarioReal.limpiarRespuestas();
    }

    /**
     * Se establece el modo de la encuesta que se va a contestar.
     * @param String modo "psicologico" o "recreativo" segun la 
     * categoria de la encuesta.
     * @return boolean si se agrego correctamente la encuesta o no,
     * en caso de ser no la encuesta a agregar no es valida.
     */
    public boolean establecerModoActual(String modo){
        return usuarioReal.establecerModoActual(modo);
    }

    @Override
    public boolean establecerProblemas() {
        return usuarioReal.establecerProblemas();
    }

}
