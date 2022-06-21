import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Base de datos del programa.
 * 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class BDDUsuarios{

    /** Usuarios registrados */
    private HashMap<String, Usuario> usuarios;
    /** Encuestas disponibles para contestar */
    private LinkedList<Encuesta> encuestas;

    /** Constructor sin parametros */
    public BDDUsuarios(){
        usuarios = new HashMap<>();
        encuestas = new LinkedList<>();

        encuestas.add(new EncuestaTamal());
        encuestas.add(new EncuestaBebida());
        encuestas.add(new EncuestaAnimal());
        encuestas.add(new EncuestaPan());
        encuestas.add(new EncuestaFacultad());
        encuestas.add(new EncuestaPsicologica());
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
     */
    public void agregarUsuario(HashMap<String,String> datosUsuario){
        Usuario usuario = new Usuario(datosUsuario);
        usuarios.put(usuario.getUsuario(), usuario);
    }

    /**
     * Retorna una representacion de un  usuario.
     * @param String nombre de usuario de la persona.
     * @return UsuarioProxy representacion del usuario real.
     */
    public UsuarioProxy obtenerUsuario(String nombreUsuario){
        for(Usuario i: usuarios.values())
            if(i.getUsuario().equals(nombreUsuario))
                return new UsuarioProxy(i);

        return null;
    }

    /**
     * Retorna una representacion de un usuario con problemas 
     * similares al que se proporcione.
     * @param UsuarioProxy usuario para el que se va a buscar
     * un usuario similar.
     * @return UsuarioProxy representacion del usuario real similar
     * al proporcionado.
     */
    public UsuarioProxy obtenerUsuarioSimilar(UsuarioProxy usuario){
        
        if(!usuario.getUsuarioReal().getConsentimientoDeConexion())
            return null;

        if(usuario.getUsuarioReal().getProblemas().isEmpty())
            return null;
        
        if(usuario.getUsuarioReal().getProblemas().contains("Soledad")){
            UsuarioProxy usuario2 = obtenerUsuarioConProblema("Soledad");
            if(usuario2 != null){
                return usuario2;
            }
        }
        
        UsuarioProxy usuario2 = null;
        for(String problema: usuario.getUsuarioReal().getProblemas()){
            usuario2 = obtenerUsuarioConProblema(problema);
            if(usuario2 != null){
                return usuario2;
            }
        }
        
        return null;
    }

    /**
     * Obtiene un usuario que sufra del problema dado
     * @param problema el problema a verificar
     * @return el usuario que sufre del problema
     */
    private UsuarioProxy obtenerUsuarioConProblema(String problema){
        ArrayList<Usuario> l = new ArrayList<Usuario>(usuarios.values());
        // Revolvemos para que sea al azar 
        Collections.shuffle(l);
        for(Usuario usuario: l)
            if(usuario.getProblemas().contains(problema))
                return new UsuarioProxy(usuario);

        return null;
    }

    /**
     * Verifica a un usuario por nombre de usuario y contrasena.
     * @param String nombre de usuario de la persona.
     * @param String contrasena de la persona.
     * @return boolean si tanto la contrasena como el nombre de usuario
     * se corresponden con la informacion de un usuario de la base.
     */
    public boolean identificarUsuario(String nombreUsuario, String contrasena){
        for(Usuario i: usuarios.values())
            if(i.getUsuario().equals(nombreUsuario))
                if(i.getContrasena().equals(contrasena))
                    return true;

        return false;
    }

    /**
     * Verifica si un usuario se encuentra en la base de datos
     * por nombre de usuario.
     * @param String nombre de usuario para buscar al usuario.
     * @return boolean si el usuario esta registrado en la base 
     * de datos.
     */
    public boolean existeUsuario(String usuario){
        return obtenerUsuario(usuario) != null;
    }

    /**
     * Guarda un JSON correspondiente a la BDD de usuarios.
     */
    public void respaldarBDD(){
        guardarJsonUsuarios();
    }

    /**
     * Lee y llena la base de datos de datos 
     * apartir un JSON correspondiente a los usuarios.
     */
    public void restaurarBDD(){
        leerJsonUsuarios();
    }

    /**
     * Guarda el JSON correspondiente a los usuarios.
     */
    private void guardarJsonUsuarios(){
        Parser parser = new Parser();

		parser.crearJSONDeHashMap(usuarios);
    }

    /**
     * Lee y llena la base datos de usuarios con el JSON.
     */
    private void leerJsonUsuarios(){
        Parser parser = new Parser();

        usuarios = parser.parseDeHashMap();
    }

    /**
     * Obtiene un iterador de las encuestas.
     * @return Iterator de encuestas
     */
    public Iterator obtenerIteradorEncuestas(){
        return encuestas.iterator();
    }

    /**
     * Obtiene un iterador de los usuarios.
     * @return Iterator de usuarios.
     */
    public Iterator obtenerIteradorUsuarios(){
        Collection<Usuario> collection = usuarios.values(); 
        return collection.iterator();
    }
}
