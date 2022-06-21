import java.util.Scanner;

/**
 * Modo Recreativo del bot
 * 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class ModoRecreativo extends Modo {


    /**
     * Crea el Modo Psicologico
     * @param controller el controlador
     * @param user el usuario proxy
     */
    public ModoRecreativo(ControladorBDD controller, UsuarioProxy user){
        super(controller, user);
    }

    @Override
    public void mostrarIntroduccion() {

        System.out.println("\n************ HOLA Y BIENVENIDO AL MODO RECREATIVO :D ************\n");
        System.out.println("- En este modo analizaremos tu estatus actual de una forma divertida :)\n"+
        "- Responde con un \"Si\" o un \"No\" a las preguntas o afirmaciones\n\n");
        
    }

    @Override
    public void iniciarModo() {

        Scanner sc = new Scanner(System.in);
        String resp, opcTest;
        int test;
        boolean testEscogido = false;
        
        do{

            System.out.println("Escoge el test que quieras realizar: ");
            System.out.println("1. ¿Que tipo de tamal eres?....");
            System.out.println("2. ¿Que tipo de bebida eres?....");
            System.out.println("3. ¿Que animal te representa?....");
            System.out.println("4. ¿Que tipo de pan eres?....");
            System.out.println("5. ¿Que Facultad de la  UNAM eres?....");
            
            while(true){

                try{
                    System.out.print("Opcion:  ");
                    opcTest = sc.nextLine();
                    test = Integer.parseInt(opcTest);
                    break;
                }catch(NumberFormatException nfe){

                    System.out.println("\nEscribe una opcion valida:");
                    System.out.println("1. ¿Que tipo de tamal eres?....");
                    System.out.println("2. ¿Que tipo de bebida eres?....");
                    System.out.println("3. ¿Que animal te representa?....");
                    System.out.println("4. ¿Que tipo de pan eres?....");
                    System.out.println("5. ¿Que Facultad la UNAM eres?....");

                }

            }

            switch(test){

                case 1:
                    System.out.println("\nBien! Veamos que tipo de tamal eres....");
                    testEscogido = true;
                    controlador = new ControladorEncuesta(controladorBDD.obtenerEncuesta("ENCUESTA TIPO DE TAMAL"));
                    break;

                case 2:
                    System.out.println("\nBien! Veamos que tipo de bebida eres....");
                    testEscogido = true;
                    controlador = new ControladorEncuesta(controladorBDD.obtenerEncuesta("ENCUESTA TIPO DE BEBIDA"));
                    break;

                case 3:
                    System.out.println("\nBien! Veamos que animal te representa según tu personalidad....");
                    testEscogido = true;
                    controlador = new ControladorEncuesta(controladorBDD.obtenerEncuesta("ENCUESTA ANIMAL"));
                    break;

                case 4:
                    System.out.println("\nBien! Veamos que tipo de pan eres....");
                    testEscogido = true;
                    controlador = new ControladorEncuesta(controladorBDD.obtenerEncuesta("ENCUESTA TIPO DE PAN"));
                    break;

                case 5:
                    System.out.println("\nBien! Veamos que Facultad eres....");
                    testEscogido = true;
                    controlador = new ControladorEncuesta(controladorBDD.obtenerEncuesta("ENCUESTA FAC UNAM"));
                    break;

                default:
                    System.out.println("\n\nPor favor escoge una opcion valida:\n");
                    break;
            }

        }while(!testEscogido);

        System.out.println("Te voy a realizar la siguiente encuesta para analizar tu situacion, "+
        "tranquilo, no es un examen XD\n\n\tRecuerda:- Responde con un \"Si\" o un \"No\" a las preguntas o afirmaciones\n\n");

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

                    System.out.println("- Respuesta no valida, por favor escribe \"Si\" o \"No\" a las preguntas/afirmaciones:");
                }

            }

        }

        /* Imprime resultado en base a sus respuestas */
        System.out.println("\n---------------> ¡¡RESULTADOS!! <--------------- \n"+
        controlador.obtenerResultado(usuario.getUsuarioReal().getRespuestasEncuesta()));
    }

    @Override
    public void despedirse() {

        usuario.limpiarRespuestas();
        System.out.println("\n************ ESPERO HAYAS SIDO LO QUE ESPERABAS (XD), HASTA PRONTO!! ************\n");
    }
    

}
