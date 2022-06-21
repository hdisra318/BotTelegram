import java.util.ArrayList;

/**
 * Encuestas para saber que tipo de tamal eres
 *
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */

public class EncuestaTamal extends Encuesta {


    /**
     * Constructor para EncuestaTamal
     */
    public EncuestaTamal() {
        nombreEncuesta = "ENCUESTA TIPO DE TAMAL";
        this.modo = "CREATIVO";
        generarPreguntas();

    }


    /**
     * Crea las preguntas de la encuesta
     */
    private void generarPreguntas() {

        preguntas = new ArrayList<Pregunta>();

        Pregunta p1 = new Pregunta("Amas las fiestas 🎉");
        preguntas.add(0, p1);

        Pregunta p2 = new Pregunta("Te encanta bailar y le sabes (ㄏ `ᴗゝ´)ㄏ ");
        preguntas.add(1, p2);

        Pregunta p3 = new Pregunta("Le caes bien a todos, re social ๑( ˘▽˘) ✰✰");
        preguntas.add(2, p3);

        Pregunta p4 = new Pregunta("Tiern@ y medio fresa, pero siempre amable ฅ(^•ܫ•^)ฅ");
        preguntas.add(3, p4);

        Pregunta p5 = new Pregunta("A veces no le caes bien a todos, pero meh la vida sigue. De pocos amigos ┐〈-。ー;》┌");
        preguntas.add(4, p5);

        Pregunta p6 = new Pregunta("Te sabes adaptar a todo, versátil 10/10 ✨ ");
        preguntas.add(5, p6);

        Pregunta p7 = new Pregunta("¡Simple y humilde! ✨");
        preguntas.add(6, p7);

        Pregunta p8 = new Pregunta("Eres super atrevid@, no te acobardas ante ningún reto (͡ ͡° ͜ つ ͡͡°)");
        preguntas.add(7, p8);

        Pregunta p9 = new Pregunta("Lo tuyo son las emociones fuertes y nuevas experiencias ｡゜(｀Д´)゜｡");
        preguntas.add(8, p9);

        Pregunta p10 = new Pregunta("Eres direct@, sin rodeos, siempre al grano -_-");
        preguntas.add(9, p10);

        Pregunta p11 = new Pregunta("Eres rar@ (•̃̾、•̃̾)");
        preguntas.add(10, p11);

        Pregunta p12 = new Pregunta("Forane@? (´-、-｀❜)");
        preguntas.add(11, p12);

        Pregunta p13 = new Pregunta("A todo dar, pones casa para las fiestas ∖(＾ヮ＾) ∕");
        preguntas.add(12, p13);


    }


    /**
     * Metodo auxiliar para la obtencion del resultado
     * @param respuestas las respuestas del usuario
     * @return el tipo de tamal que resulto
     */
    private String auxResultados(ArrayList<Boolean> respuestas) {
        if (respuestas.get(11))
            return "Oaxaqueño";

        if (respuestas.get(3))
            return "Dulce";
        if (respuestas.get(4) && respuestas.get(11) || respuestas.get(4) && respuestas.get(9))
            return "Mole";

        if (respuestas.get(7) && respuestas.get(8))
            return "Rajas";

        if (respuestas.get(0) && respuestas.get(12))
            return "Verde";


        return "Elote";
    }


    @Override
    public String obtenerResultado(ArrayList<Boolean> respuestas) {

        String tamal = auxResultados(respuestas);
        String resultado;


        switch (tamal) {
            case "Oaxaqueño":
                return resultado = tamal + ":Hecho en Pueblo Magico, eres a todo dar. Popular. Vimes con 4+ roomies. \n" +
                        "Las maruchan te han mantenido en pie hasta hoy jeje (ↄ◔̯ ◔)ↄ" ;

            case "Dulce":
                return resultado = tamal + ": Bien cute (๑´•ε •`๑), siempre alegra. Le caes bien a las señoras👀  ";

            case "Mole":
                return resultado = tamal + ": Medio pesadito, pero buena persona. Te quejas de todo. Extravagante (raro jaja) !!!¯\\_(°_°)_/¯ ";

            case "Rajas":
                return resultado = tamal + ": Le entras a todo. El que tenga miedo a morir mejor que no nazca..ˁ(🔲-🔲ᐟ)ˀ";

            case "Verde":
                return resultado = tamal + ": A todo dar!! Les gustas a todos, Alma de las fiestas. (｡•̀‿ -｡)";
            default:
                return resultado = tamal + ": Sencillo y humilde, te adaptas a cualquier cosa!!\nPd: Tienes tu propia extravagancia✨✨";

        }


    }


}