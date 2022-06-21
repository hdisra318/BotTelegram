import java.util.Scanner;

/**
 * Modo Psicologico del bot
 * 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class ModoPsicologico extends Modo {

    /**
     * Crea el Modo Psicologico
     * @param controller el controlador
     * @param user el usuario proxy
     */
    public ModoPsicologico(ControladorBDD controller, UsuarioProxy user){
        super(controller, user);
    }

    @Override
    public void mostrarIntroduccion() {
        
        System.out.println("\n************ HOLA Y BIENVENIDO AL MODO PSICOLOGICO ************\n");
        System.out.println("- En este modo analizaremos tu estatus actual psicologico :)\n"+
        "- Responde con un \"Si\" o un \"No\"\n\n");
    }

    @Override
    public void iniciarModo() {

        
        Scanner sc = new Scanner(System.in);
        String resp;
        usuario.establecerModoActual("psicologico");
        
        System.out.println("Te voy a realizar la siguiente encuesta para analizar tu situacion, "+
        "no te preocupes, esto no es un examen\n");
        controlador = new ControladorEncuesta(new EncuestaPsicologica());
    
        Pregunta p;
        for(int i = 0; i< controlador.numeroPreguntas(); ++i){

            p = controlador.mostrarPregunta(i);
            System.out.print((i+1)+". "+p+":  ");
            

            while(true){

                resp = sc.nextLine();
                if(resp.equalsIgnoreCase("si") || resp.equalsIgnoreCase("no")){

                    if(resp.equalsIgnoreCase("si")){
                        usuario.anadirRespuesta(resp);
                    }else{
                        usuario.anadirRespuesta(resp);
                    }
                    break;
                }else{

                    System.out.println("- Respuesta no valida, por favor escribe \"Si\" o \"No\" a las preguntas:");
                }

            }

        }
        
        //Obteniendo respuesta de la encuesta
        usuario.establecerProblemas();
        System.out.println("\n----------------> RESULTADOS <---------------- \n"+
        controlador.obtenerResultado(usuario.getUsuarioReal().getRespuestasEncuesta()));
        
        System.out.println("---> RECOMENDACIONES: <---");
        System.out.println(controlador.darRecomendaciones(controlador.obtenerProblemas(usuario.getUsuarioReal().getRespuestasEncuesta()), 
        this.controladorBDD, this.usuario));
        
    
        
    }

    @Override
    public void despedirse() {
        
        usuario.limpiarRespuestas();
        System.out.println("\n************ ESPERO TE HAYA SERVIDO MI INFORMACION, HASTA PRONTO!! ************\n");
    }
    
}
