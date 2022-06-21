/**
 * Modo del bot
 * 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public abstract class Modo {

    /**
     * Usuario al que hace referencia
     */
    protected UsuarioProxy usuario;

    /**
     * Controlador para las encuestas
     */
    protected ControladorEncuesta controlador;

    /**
     * Controlador de la base de datos
     */
    protected ControladorBDD controladorBDD;

    /**
     * Construye el modo
     * @param controller controlador base de datos
     * @param user usuario proxy
     */
    public Modo(ControladorBDD controller, UsuarioProxy user){
        
        controladorBDD = controller;
        usuario = user;
    }


    /**
     * Metodo template que ejecuta el modo
     */
    public void ejecutar(){

        mostrarIntroduccion();
        iniciarModo();
        despedirse();

    }


    /**
     * Muestra una introduccion al modo
     */
    public abstract void mostrarIntroduccion();

    /**
     * Inicia el modo
     */
    public abstract void iniciarModo();

    /**
     * Muestra una despedida del modo
     */
    public abstract void despedirse();
}