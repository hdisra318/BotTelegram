import java.util.ArrayList;


/**
 * Encuestas que te dice que animal eres  
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class EncuestaAnimal extends Encuesta{


    /**
     * Constructor para EncuestaAnimal
     */
    public EncuestaAnimal(){
        nombreEncuesta = "ENCUESTA ANIMAL";
        this.modo = "CREATIVO";
        generarPreguntas();

    }


    /**
     * Crea las preguntas de la encuesta
     */
    private void generarPreguntas(){

        preguntas = new ArrayList<Pregunta>();

        Pregunta p1 = new Pregunta("Tu lema antes de tomar malas decisiones es: 'El que tenga miedo a morir que no nazca (╯´〇`）╯︵ ┻━┻");
        preguntas.add(0,p1);

        Pregunta p2 = new Pregunta(" No energy en el día, pero al full en la noche (▀◡ ▀-͠)");
        preguntas.add(1,p2);
        Pregunta p3 = new Pregunta(" ¿Te consideras sepsi? ԅ(≖‿≖ԅ)");
        preguntas.add(2,p3);

        Pregunta p4 = new Pregunta("Todos te observan, te analizan y te respetan: Eres el/la boss (─ᗢ ─)");
        preguntas.add(3,p4);

        Pregunta p5 = new Pregunta("Tú no te conformas con cualquier cosa ʕ$__$ʔ");
        preguntas.add(4,p5);

        Pregunta p6 = new Pregunta("Eres tranquil@  (∪｡∪)｡｡｡ zzZ");
        preguntas.add(5,p6);

        Pregunta p7 = new Pregunta("Protector con tus cercanos ✨(✪ㅅ✪)✨");
        preguntas.add(6,p7);

        Pregunta p8 = new Pregunta("Siempre estás en la lela ＼(ꈍ .̮ ꈍ)ゝ");
        preguntas.add(7,p8);

        Pregunta p9 = new Pregunta("No importa los medios, siempre con sigues salirte con  la tuya jeje  ʅ(˵◡‿◡⑅ ʅ)");
        preguntas.add(8,p9);

        Pregunta p10 = new Pregunta("Eres versatil ¯\\\\_( ͡~ ͜ゝ°)_/¯");
        preguntas.add(9,p10);

        Pregunta p11 = new Pregunta("Eres el humor del grupo ♪＼(´ꇴ `˵)／♪");
        preguntas.add(10,p11);

        Pregunta p12 = new Pregunta("A ti nadie de baja el autoestima!! (ง'̀ꞈ'́)ง");
        preguntas.add(11,p12);

        Pregunta p13 = new Pregunta("Leal!!.⊂(◪ܫ ◪)⊃");
        preguntas.add(12,p13);

        Pregunta p14 = new Pregunta("Posesiv@, no te gusta que toquen lo que es tuyo!! (ง ᓀ‸ᓂ)ง");
        preguntas.add(13,p14);

        Pregunta p15= new Pregunta("Eres shy, so shy (bien tímid@ xD) (•̀﹏•́〣)⋉(ᗒ.̮ ᗕ)⋊");
        preguntas.add(14,p15);

        Pregunta p16 = new Pregunta("Eres matadito, ya sea en la escuela o en el trabajo, alch duerme un poco (⚆︿⚆)");
        preguntas.add(15,p16);

        Pregunta p17 = new Pregunta("Humilde y sencillo (´•‿•`)ฅ♡");
        preguntas.add(16,p17);

        Pregunta p18 = new Pregunta("Fit, porque el fisico si importa jeje ᕕ(ᐛ)ᕗ");
        preguntas.add(17,p18);

        Pregunta p19 = new Pregunta("Ay, ya me dio amsiedad (˵⩹ ﮧ ⩺˵) （／｡•́ ═╗•̀｡＼）");
        preguntas.add(18,p19);

        Pregunta p20 = new Pregunta("La ojeras son parte de tu outfit orgullozamente ahre ლ(˘⌣˘)ლ");
        preguntas.add(19,p20);


    }

    /**
     * Metodo auxiliar para la obtencion del resultado
     * @param respuestas las respuestas del usuario
     * @return el tipo de animal que resulto
     */
    private String auxResultados(ArrayList<Boolean> respuestas) {

        if(respuestas.get(19))
            return  "Mapache";

        if (respuestas.get(2) && respuestas.get(4)  || respuestas.get(1) && respuestas.get(4) )
            return "Gato";

        if (respuestas.get(6) || respuestas.get(7))
            return "Oso";
        if (respuestas.get(10) || respuestas.get(8) && respuestas.get(11) )
            return "Mono";

        if (respuestas.get(12))
            return "Perro";

        if (respuestas.get(14) && !respuestas.get(18) || respuestas.get(16))
            return "Ratón";

        if(respuestas.get(18))
            return "Conejo";

        if(respuestas.get(17) || respuestas.get(3))
            return "León";
        return "Gallo";
    }




    @Override
    public String obtenerResultado(ArrayList<Boolean> respuestas) {
        String animal= auxResultados(respuestas);
        String resultado;


        switch (animal) {
            case "Mapache":
                return resultado = animal + ": 🦝 Una persona agil, inteligente, responsable, y lo mas importante nocturno." +
                        "\nNo confias en nadie." ;

            case "Gato":
                return resultado = animal + ": 🐱 Bien cute (๑´•ε •`๑) xD. Independiente, sexy, libre pensador, nocturno, \nlider" +
                        "y sobre todo demandante👀  ";

            case "Oso":
                return resultado = animal + ": 🐻 Eres risueñ@ , meditativ@, protector/a, territorial y callad@.๑( ˘▽˘) ✰✰ ";

            case "Mono":
                return resultado = animal + ": 🐵 Eres segur@ de ti mism@, alegre, divertid@, versátil, hábil y trampos@.ˁ(🔲-🔲ᐟ)ˀ";

            case "Perro":
                return resultado = animal + ": 🐶 Eres super fiel, carismatic@, sencill@, territorial,protector@, valiente y " +
                        "\nmedio sumis@.✽乁(｡•̀ᴗ-)ㄏ✽";
            case "Ratón":
                return resultado = animal + ": 🐭Trabajador/a, confiable, modest@, sencillo, pero timid@. (｡•̀‿ -｡)";

            case "Conejo":
                return resultado = animal + ": 🐰 Eres una persona astuta, agil, re-humilde, tranquila, pero muy nerviosa.(੭ ´･╭╮･)੭";
            case "León":
                return resultado = animal + ": 🦁Fuerte, porque el gym si hace su efecto. Eres una persona segura, paciente," +
                        "\ncalmada y protectora. Das miedo a primera impresión, pero por dentro eres soft(｡•̀‿ -｡)";

            default:
                return resultado = animal + ": 🐔 Talentoso (aunque aun no este descubierto tu talento  xD), creativ@, excéntrico," +
                        "\nmuy social.✨✨";

        }

    }

}
