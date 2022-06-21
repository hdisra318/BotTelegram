import java.util.ArrayList;


/**
 * Encuestas que te dice que tipo meme de eres
 *
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class EncuestaBebida extends  Encuesta {


    /**
     * Constructor para EncuestaBebida
     */
    public EncuestaBebida(){
        nombreEncuesta = "ENCUESTA TIPO DE BEBIDA";
        this.modo = "CREATIVO";
        generarPreguntas();
    }

    /**
     * Crea las preguntas de la encuesta
     */
    private void generarPreguntas(){

        preguntas = new ArrayList<Pregunta>();

        Pregunta p1 = new Pregunta("Eres de poca tolerancia xD");
        preguntas.add(0,p1);

        Pregunta p2 = new Pregunta("Amad@ y odiad@ ( ͡° ͜ʖ ͡°) ");
        preguntas.add(1,p2);

        Pregunta p3 = new Pregunta("Eres adictiv@, a veces sacas lo peor de la gente LOL. (っˆڡˆς)");
        preguntas.add(2,p3);

        Pregunta p4 = new Pregunta("Eres super activ@ y social cuado entras en confianza, pero cuando " +
                "\nte enfrias pierdes el efecto. F ( ་ ⍸ ་ )" );
        preguntas.add(3,p4);

        Pregunta p5 = new Pregunta("Eres medio amargad@ jeje, pero buena onda en el fondo." +
                "\nToma tiempo entenderse bien contigo xD (͡o‿O͡)");
        preguntas.add(4,p5);

        Pregunta p6 = new Pregunta("Vas al GYM y te alimentas saludable. Super fit. ୧(´•‿•`)୨");
        preguntas.add(5,p6);

        Pregunta p7 = new Pregunta("Popular, la gente siente que contigo puden sacar lo que lleva dentro (｡◝‿◜ ｡)ゞ");
        preguntas.add(6,p7);

        

    }

    /**
     * Metodo auxliar para la obtencion del resultado
     * @param respuestas las respuestas del usuario
     * @return el tipo de bebida que resulto
     */
    private String auxResultados(ArrayList<Boolean> respuestas) {

        if(respuestas.get(6))
            return  "Laxante liquido";

        if (respuestas.get(0))
            return "Leche";

        if (respuestas.get(2))
            return "Cerveza";
        if (respuestas.get(3))
            return "Café";

        if (respuestas.get(4))
            return "Vino";

        if (respuestas.get(5))
            return "Juguito natural";



        return "Awa";
    }


    @Override
    public String obtenerResultado(ArrayList<Boolean> respuestas) {

        String bebida = auxResultados(respuestas);
        String resultado;
        switch (bebida) {
            case "Leche":
                return resultado = bebida + ": 🥛 Puede que los demás no te toleren jaja, pero tu tampoco los toleras. \n" +
                        "Tiendes a irritar fácilmente a los otros, pero en el fondo te aman. (ↄ◔̯ ◔)ↄ" ;

            case "Cerveza":
                return resultado = bebida+ ": 🍺 POPULAR y muy social. Tú ex sigue sin superarte xd. La gente  te tiene tanta confianza que " +
                        "\nte muestra su peor cara sin pena. ✧◝(◍⌣◍)◜✧";

            case "Café":
                return resultado = bebida+ ": ☕ Introvertido, pero te desconoces cuando entras en confianza. Se te agota la energía después de " +
                        "tanta actividad social lol. (=ᗝ =′ )";

            case "Vino":
                return resultado = bebida+ ": 🍷 Medio pesadito al principio, pero buena onda cuando te conocen bien. Eres elegante y de gustos refinados jajaˁ(🔲-🔲ᐟ)ˀ";

            case "Juguito natural":
                return resultado = bebida+ ": 🧃 FIT ✨✨";
            case "Laxante liquido":
                return resultado = bebida+ ": JAJAJAA eres el alivio de muchos, sigue así. No sé que  haríamos sin ti (｡◝‿◜ ｡)ゞ.)";


            default:

                return resultado = bebida+ ": ✨ ó  "+ bebida +" loka, jaja, todos te aman ntp, y si no, por lo menos te necesitan jeje ლ(˘⌣˘)ლ";

        }


    }


}
