import java.util.HashMap;
import java.util.Iterator;

/**
 * Controlador de la base de datos
 *
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class ControladorBDD{

    /**
     * Base de datos a la que se hace referencia.
     */
    private BDDUsuarios bdd;

    /** 
    * Constructor sin parametros.
    */
    public ControladorBDD(){
        this.bdd = new BDDUsuarios();
    }

    /**
     * Agrega un usuario a la base de datos.
     * @param HashMap<String,String> diccionario de String a String,
     * con los datos del usuario, ejemplo:
     * "nombre"    : "John Doe"
     * "usuario"   : "user2586"
     * "contrasena": "Patito2011"
     * "telefono"  : "5534542398"
     * "correo"    : "frutilla_25@gmail.com"
     * "carrera"   : "Ciencias de la computacion"
     * @return boolean true si se agrego correctamente false en otro caso.
     * El metodo regresara false si alguno de los campos tiene un valor nulo 
     * en el diccionario o no fue considerado.
     */
    public boolean agregarUsuario(HashMap<String,String> datosUsuario){
        String[] campos = {"nombre","usuario","contrasena",
                            "telefono","correo","carrera"};
    
        // Verificamos tanto que no se la pasen datos null como que 
        // en el diccionario esten todos los parametros necesarios.
        for(String cadena: campos){
            if( datosUsuario.get(cadena) == null )
                return false;
        }
    
        bdd.agregarUsuario(datosUsuario);
        return true;
    }

    /**
     * Retorna una representacion de un  usuario.
     * @param String nombre de usuario de la persona.
     * @return UsuarioProxy representacion del usuario real, null
     * en caso de no encontrarse en la BDD.
     */
    public UsuarioProxy obtenerUsuario(String nombreUsuario){
        nombreUsuario = limpiaCadena(nombreUsuario);   

        return bdd.obtenerUsuario(nombreUsuario);
    }

    /**
     * Retorna una representacion de un usuario con problemas 
     * similares al que se proporcione.
     * @param usuario usuario para el que se va a buscar
     * un usuario similar.
     * @return UsuarioProxy representacion del usuario real similar
     * al proporcionado,null en caso de que el usuario proporcionado
     * no tenga habilitado el consentimiento de conexion, aun no se hayan 
     * identificado sus problemas o no exista otro usuario similar 
     * disponible en ese momento.
     */
    public UsuarioProxy obtenerUsuarioSimilar(UsuarioProxy usuario){

        return bdd.obtenerUsuarioSimilar(usuario);
    }

    /**
     * Verifica a un usuario por nombre de usuario y contrasena.
     * @param String nombre de usuario de la persona.
     * @param String contrasena de la persona.
     * @return boolean si tanto la contrasena como el nombre de usuario
     * se corresponden con la informacion de un usuario de la base.
     */
    public boolean identificarUsuario(String nombreUsuario, String contrasena){

        nombreUsuario = limpiaCadena(nombreUsuario);

        return bdd.identificarUsuario(nombreUsuario, contrasena);
    }

    /**
     * Verifica si un usuario se encuentra en la base de datos
     * por nombre de usuario.
     * @param String nombre de usuario para buscar al usuario.
     * @return boolean si el usuario esta registrado en la base 
     * de datos.
     */
    public boolean existeUsuario(String nombreUsuario){

        return bdd.existeUsuario(nombreUsuario);
    }

    /**
     * Retorna la encuesta especifica buscada.
     * @param String nombre de la encuesta a buscar.
     * @return Encuesta encuesta deseada, null si no 
     * existe una encuesta con ese nombre en la base de datos.
     */
    public Encuesta obtenerEncuesta(String nombreEncuesta){
        
        Iterator<Encuesta> iterador = bdd.obtenerIteradorEncuestas();

        while(iterador.hasNext()){
            Encuesta encuesta = iterador.next();
            if(encuesta.getNombreEncuesta().equals(nombreEncuesta))
                return encuesta;
        }

        return null;        
    }

    /**
     * Guarda un JSON correspondiente a los usuarios y 
     * uno correspondiente a las encuestas.
     */
    public void respaldarBDD(){
        bdd.respaldarBDD();
    }

    /**
     * Lee y llena la base de datos apartir un JSON  
     * correspondiente a los usuarios y uno correspondiente 
     * a las encuestas.
     */
    public void restaurarBDD(){
        bdd.restaurarBDD();
    }

    /**
     * Obtiene un iterador de las encuestas.
     * @return Iterator de encuestas
     */
    public Iterator obtenerIteradorEncuestas(){
        return bdd.obtenerIteradorEncuestas();
    }

    /**
     * Obtiene un iterador de los usuarios.
     * @return Iterator de usuarios.
     */
    public Iterator obtenerIteradorUsuarios(){
        return bdd.obtenerIteradorUsuarios();
    }

    /**
     * Limpia la cadena pasada removiendo los espacios en blanco
     * @param nombreUsuario la cadena a limpiar
     * @return la cadena sin espacios en blanco ni mayusculas.
     */
    private String limpiaCadena(String nombreUsuario){
        return nombreUsuario.toLowerCase().replace(" ","");
    }
}
