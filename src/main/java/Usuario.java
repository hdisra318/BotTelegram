import java.util.HashMap;
import java.util.ArrayList;

/**
 * Clase para guardar la informacion del usuario.
 * 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class Usuario implements InterfazUsuario {

    /** Nombre real del usuario */
    private String nombre;
    /** Nombre de usuario unico */
    private String usuario;
    /** Contrasena para identificarse */
    private String contrasena;
    /** Contacto del usuario via telefonica */
    private String telefono; 
    /** Contacto del usuario via email */
    private String correo; 
    /** Licenciatura que cursa el usuario */
    private String carrera;
    /** Modo de la encuesta que se esta respondiendo */
    private String modoActual;
    /** Respuestas del usuario a la encuesta actual */
    private ArrayList<Boolean> respuestasEncuesta;
    /** Posibles padecimeintos psicologicos del usuario */
    private ArrayList<String> problemas;
    /** Si la encuesta ya se termino de contestar */
    private boolean encuestaTerminada;
    /** 
    * Si el usuario ha dado consentimiento para ser visto
    * y ver a otros usuarios con problemas similares.
    */
    private boolean consentimientoDeConexion;

    /**
     * Construye un usuario con los datos proporcionados en
     * un diccionario de String a String, ejemplo:
     * "nombre"    : "John Doe"
     * "usuario"   : "user2586"
     * "contrasena": "Patito2011"
     * "telefono"  : "5534542398"
     * "correo"    : "frutilla_25@gmail.com"
     * "carrera"   : "Ciencias de la computacion"
     * @param ArrayList<Boolean> Respuestas de un usuario.
     */
    public Usuario(HashMap<String, String> datos){
        try{
            this.nombre     = datos.get("nombre").toLowerCase().replace(" ","");
            this.usuario    = datos.get("usuario").toLowerCase().replace(" ","");
            this.contrasena = datos.get("contrasena").replace(" ","");
            this.telefono   = datos.get("telefono").replace(" ","");
            this.correo     = datos.get("correo").toLowerCase().replace(" ","");
            this.carrera    = datos.get("carrera").toLowerCase().replace(" ","");
           
        } catch(NullPointerException npe){
            System.out.println("Los datos básicos necesarios para "+ 
                                "crear un usuario, no fueron proporcionados: "+
                                "* Nombre" + 
                                "* Usuario" +
                                "* Contraseña" +
                                "* Teléfono" +
                                "* Correo" +
                                "* Carrera");
        }

        this.modoActual = "recreativo";
        this.respuestasEncuesta = new ArrayList<>();
        this.problemas = new ArrayList<>();
        this.encuestaTerminada = true;
        this.consentimientoDeConexion = false;
    }
    
    @Override
    public boolean anadirRespuesta(String respuesta){
        respuesta = respuesta.toLowerCase().replace(" ","");

        if(respuesta.charAt(0) == 's'){
            respuestasEncuesta.add(true);
            return true;
        }
        else if(respuesta.charAt(0) == 'n'){
            respuestasEncuesta.add(false);
            return true;
        }

        return false;    
    }

    @Override
    public boolean limpiarRespuestas(){
        if(encuestaTerminada == false)
            return false;

        respuestasEncuesta.clear();
        return true;
    }

    /**
     * Se establece la encuesta que se va a contestar.
     * @param Encuesta encuesta para se contestada.
     * @return boolean si se agrego correctamente la encuesta o no,
     * en caso de ser no la encuesta a agregar no es valida.
     */
    public boolean establecerModoActual(String modoEncuesta) {
        if(encuestaTerminada == false)
            return false;

        modoActual = modoEncuesta;
        return true;
    }

    @Override
    public boolean establecerProblemas() {
        if(encuestaTerminada == false)
            return false;

        if(!modoActual.equals("psicologico"))
            return false;

        ControladorBDD controlador = new ControladorBDD();
        EncuestaPsicologica encuesta = (EncuestaPsicologica) controlador.obtenerEncuesta("ENCUESTA PSICOLOGICA");

        problemas = encuesta.obtenerProblemas(respuestasEncuesta);

        if(problemas == null)
            return false;
            
        return true;
    }

    /**
     * Regresa el nombre del usuario.
     * @return String nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Regresa el nombre de usuario de la persona.
     * @return String nombre del usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Regresa la contrasena del usuario.
     * @return String contrasena del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Regresa el telefono del usuario.
     * @return String telefono del usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Regresa el cooreo del usuario.
     * @return String contrasena del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Regresa la carrera que esta cursando el usuario.
     * @return String carrera del usuario.
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Regresa la encuesta que va a constestar el usuario.
     * @return String encuesta para el usuario.
     */
    public String getModoActual() {
        return modoActual;
    }

    /**
     * Regresa las respuestas que ha dado el usuario.
     * @return ArrayList<Boolean> respuestas del usuario.
     */
    public ArrayList<Boolean> getRespuestasEncuesta() {
        return respuestasEncuesta;
    }

    /**
     * Regresa los posibles problemas psicologicos identificados
     * en el usuario.
     * @return ArrayList<String> problemas del usuario.
     */
    public ArrayList<String> getProblemas() {
        return problemas;
    }

    /**
     * Regresa si el usuario dió consentimiento o no de ser visto 
     * y ver otros usuario con los mismos problemas.
     * @return boolean true si dió consentimiento, false si no.
     */
    public boolean getConsentimientoDeConexion() {
        return consentimientoDeConexion;
    }

    /**
     * Establece el nombre del usuario.
     * @param String nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el nombre de usuario de la persona.
     * @param String nombre de usuario de la persona.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Establece la contrasena del usuario.
     * @param String contrasena del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Establece el telefono del usuario.
     * @param String telefono del usuario.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Establece el correo del usuario.
     * @param String correo del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Establece la carrera que cursa el usuario.
     * @param String carrera del usuario.
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Establece la lista de las respuestas que dió
     * el usuario.
     * @param String carrera del usuario.
     */
    public void setRespuestasEncuesta(ArrayList<Boolean> respuestasEncuesta) {
        this.respuestasEncuesta = respuestasEncuesta;
    }

    /**
     * Establece si la encuesta en turno ya fue terminada.
     * @param boolean true si fue terminada false en otro caso.
     */
    public void setEncuestaTerminada(boolean encuestaTerminada) {
        this.encuestaTerminada = encuestaTerminada;
    }

    /**
     * Establece si se da consentimiento para ser conectado con 
     * otros usuarios.
     * @param boolean true si se dió consentimiento, false si no.
     */
    public void setConsentimientoDeConexion(boolean consentimientoDeConexion) {
        this.consentimientoDeConexion = consentimientoDeConexion;
    }
}
