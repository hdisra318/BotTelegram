import java.util.HashMap;
import java.util.Scanner;

/**
 * Clase del bot 
 * 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class Bot {

    /** Usuario actual */
    private UsuarioProxy user;

    /** Controlador para la base de datos */
    private static ControladorBDD controlador = new ControladorBDD();

    /**
     * Registra al usuario
     */
    public void registar(){

        //Bajando la informacion de la base de datos
        System.out.println("\n--> Cargando la informacion, espere un momento.....\n");
        controlador.restaurarBDD();

        System.out.println("\n**************************************\n");
        Scanner s = new Scanner(System.in);
        String  nombre, usuario, telefono, carrera, contrasena, correo;
        long tel;
        String verficaUsuario, verificaContra;

        boolean registrar = false;
        while(!registrar){

            System.out.println("-> Escribe tu nombre de Usuario:");
            verficaUsuario = s.nextLine();
            System.out.println("-> Escribe tu contrasena:");
            verificaContra = s.nextLine();

            if(controlador.existeUsuario(verficaUsuario)){
                
                if(controlador.identificarUsuario(verficaUsuario, verificaContra)){
                    System.out.println("\n- Bienvenido de vuelta "+
                    verficaUsuario+"\n");
                    user = controlador.obtenerUsuario(verficaUsuario);
                    return;
                }


            }

            System.out.println("\n- Usuario o contrasena incorrecta, ¿Estas registrado?[Si/No]:");
                
            while(true){
                String resp = s.nextLine();

                if(resp.equalsIgnoreCase("si")){
                    System.out.println("\nDe acuerdo, intentalo de nuevo...\n");
                    break;

                }else if(resp.equalsIgnoreCase("no")){
                    System.out.println("\nDe acuerdo, te registrare a continuacion....\n");
                    registrar = true;
                    break;
                
                }else{
                    System.out.println("\nEscribe Si o No por favor:");
                }
            }   
            
        }
    
        System.out.println("- Escribe tu nombre: ");
        nombre = s.nextLine();
        System.out.println("- Escribe un nombre de usuario: ");
        usuario = s.nextLine();
        System.out.println("- Escribe una contrasena: ");
        contrasena = s.nextLine();

        System.out.println("- Escribe tu telefono: ");
        while(true){

            try{
                telefono = s.nextLine();
                tel = Long.parseLong(telefono);
                break;

            }catch(NumberFormatException nfe){
                System.out.print("\nDigita un numero por favor:  ");
                continue;
            }

        }

        System.out.println("- Escribe tu correo:  ");
        while(true){
            
            correo = s.nextLine();

            if(correo.contains("@") && correo.contains(".")){
                break;
            }else{
            
                System.out.println("\nEscribe correo valido por favor:");
            }
        }


        System.out.println("- Escribe la carrera que estas estudiando:  ");
        carrera = s.nextLine();
        

        HashMap<String, String> infoUsuario = new HashMap<>();
        infoUsuario.put("nombre", nombre);
        infoUsuario.put("usuario", usuario);
        infoUsuario.put("contrasena", contrasena);
        infoUsuario.put("telefono", telefono);
        infoUsuario.put("correo", correo);
        infoUsuario.put("carrera", carrera);
        
        controlador.agregarUsuario(infoUsuario);
        user = controlador.obtenerUsuario(usuario);

        System.out.println("- ¿Deseas dar tu consentimiento para compartir tu informacion a otros usuarios?[Si/No]:  ");

        while(true){
            String consen = s.nextLine();

                if(consen.equalsIgnoreCase("si")){
                    user.getUsuarioReal().setConsentimientoDeConexion(true);
                    break;

                }else if(consen.equalsIgnoreCase("no")){
                    user.getUsuarioReal().setConsentimientoDeConexion(false);
                    break;
                
                }else{
                    System.out.println("\nEscribe Si o No por favor:");
                }
        }

        System.out.println("\n-> Usuario registrado correctamente!\n");
        System.out.println("**************************************\n");
        
        

    }

    public static void main(String[] args) {
        
        /* Iniciando ejecucion */
        Bot bot = new Bot();
        Modo modo;
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        boolean wrongOpc;
        String opcion;
        int opc;



        System.out.println("\n>>>>>>>>>>>>> HOLA, BIENVENIDO A QUIZME! <<<<<<<<<<<<<\n"+
        ">>>>>>>>>>> SOY BUZZ, EL BOT QUE TE EVALUA ;^) <<<<<<<<<<<");
        System.out.println("---- Espero mis servicios te sirvan :D ----");
        System.out.println("--> Inicia sesion primero:");
        
        bot.registar();

        System.out.println("\n---> Tengo dos modos para ti:");
        System.out.println("\t1. Modo Psicologico: Te evaluare para ver como te encuentras psicologicamente");
        System.out.println("\t2. Modo Recreativo: Escoge de mis varias evaluaciones divertidas que tengo "+
        "preprarado para ti!");


        do{

            while(true){
                
                try{

                    System.out.print("Opcion:  ");
                    opcion = sc.nextLine();
                    opc = Integer.parseInt(opcion);
                    break;
                }catch(NumberFormatException nfe){

                    System.out.println("Escribe una opcion valida por favor:  ");
                    System.out.println("\t1. Modo Psicologico: Te evaluare para ver como te encuentras psicologicamente");
                    System.out.println("\t2. Modo Recreativo: Escoge de mis varias evaluaciones divertidas que tengo "+
                    "preprarado para ti!");
                }

            }  
            
            switch(opc){

                case 1:
                    System.out.println("\nPasando al Modo Psicologico....\n");
                    modo = new ModoPsicologico(controlador, bot.user);
                    modo.ejecutar();
                    wrongOpc = false;
                    break;

                case 2:
                    System.out.println("\nPasando al Modo Recreativo....\n");
                    modo = new ModoRecreativo(controlador, bot.user);
                    modo.ejecutar();
                    wrongOpc = false;
                    break;

                default:
                    System.out.println("Escoge una opcion valida por favor:  ");
                    System.out.println("\t1. Modo Psicologico: Te evaluare para ver como te encuentras psicologicamente");
                    System.out.println("\t2. Modo Recreativo: Escoge de mis varias evaluaciones divertidas que tengo "+
                    "preprarado para ti!");
                    wrongOpc = true;
                    break;

            }

            if(wrongOpc)
                continue;

            System.out.print("\n¿Deseas terminar por hoy?[Si/No]:  ");
            String opcSalida;
            while(true){

                opcSalida = sc.nextLine();
                opcSalida = opcSalida.toLowerCase();
                if(opcSalida.equals("si") || opcSalida.equals("no"))
                    break;
                    
                System.out.println("\nPor favor escribe Si o No:  ");
            }

            if(opcSalida.equals("si")){
            
                System.out.println("\n********* HASTA LUEGO, ESPERO MIS SERVICIOS HAYAN SIDO DE UTILIDAD :D *********\n");
                salir = true;
            }else {

                System.out.println("De acuerdo!, escoge de nuevo el modo con el que quieras que te evalue:");
                System.out.println("\t1. Modo Psicologico: Te evaluare para ver como te encuentras psicologicamente");
                System.out.println("\t2. Modo Recreativo: Escoge de mis varias evaluaciones divertidas que tengo "+
                "preprarado para ti!");
            }


        }while(!salir);

        controlador.respaldarBDD();
    }






}
