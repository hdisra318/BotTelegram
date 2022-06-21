import java.util.ArrayList;


/**
 * Encuestas que te dice que tipo de pan eres  *
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class EncuestaPan extends Encuesta{



    /**
     * Constructor para EncuestaPan
     */
    public EncuestaPan(){
        nombreEncuesta = "ENCUESTA TIPO DE PAN";
        this.modo = "CREATIVO";
        generarPreguntas();

    }

    /**
     * Crea las preguntas de la encuesta
     */
    private void generarPreguntas(){

        preguntas = new ArrayList<>();

        Pregunta p1 = new Pregunta("¿No tienes varo?💸💸");
        preguntas.add(0,p1);

        Pregunta p2 = new Pregunta("El barrio te respalda ━╤デ╦︻⊂=﴾⎚。⎚﴿");
        preguntas.add(1,p2);

        Pregunta p3 = new Pregunta("Vives del y para el chismesito ヾ(˘⌣˘)〴");
        preguntas.add(2,p3);

        Pregunta p4 = new Pregunta("Flojo pero responsable (₇´ᥥ`)₇" );
        preguntas.add(3,p4);

        Pregunta p5 = new Pregunta("Tu lema es 'En fin, quienes somos nostros para juzgar' después de estar de criticón/a jeje ( •́_•́ )⋑⌐⍟-⍟");
        preguntas.add(4,p5);

        Pregunta p6 = new Pregunta("¿Superficial?⌐(🔳◠🔳)¬  ");
        preguntas.add(5,p6);

        Pregunta p7 = new Pregunta("Simple y humilde!! 乁(´ー｀)ㄏ ");
        preguntas.add(6,p7);

        Pregunta p8 = new Pregunta("Siempre estas comiendo jajajaja ~🍞⊂(•́ᴗ•́｀)");
        preguntas.add(7,p8);

        Pregunta p9 = new Pregunta("De baja estatura jeje");
        preguntas.add(8,p9);

        Pregunta p10 = new Pregunta("Eres él/la de los outfits 100/10 ✨✨");
        preguntas.add(9,p10);

        Pregunta p11 = new Pregunta("¿De caracter fuerte? ʕ(óꞈ òʔ)");
        preguntas.add(10,p11);

        Pregunta p12 = new Pregunta("Nadie se mete contigo, probablemente te tienen miedo. ( ͡ಠ ل͜ ͡ಠ)");
        preguntas.add(11,p12);
        Pregunta p13 = new Pregunta("¿No sabes bailar? ╮( ಠᴗಠ )╭");
        preguntas.add(12,p13);

        Pregunta p14 = new Pregunta("Re tranquil@ , intrivertid@, probablemente tímid@ también.");
        preguntas.add(13,p14);

        Pregunta p15 = new Pregunta("Te sientes extranjero ulala.");
        preguntas.add(14,p15);

        Pregunta p16 = new Pregunta("¿Eres poliamoros@?.");
        preguntas.add(15,p16);

        Pregunta p17 = new Pregunta("Te sientes inalcanzable y con varo.");
        preguntas.add(16,p17);

    }


    /**
     * Metodo auxiliar para obtener el resultado de la encuesta
     * @param respuestas las respuestas del usuario
     * @return el tipo de pan que resulto
     */
    private String auxResultados(ArrayList<Boolean> respuestas){

        if(respuestas.get(0) &&  respuestas.get(6)   )
            return "Bolillo";

        if(respuestas.get(15) || respuestas.get(14) && respuestas.get(16) )
            return "Cuernito";

        if(respuestas.get(2) || respuestas.get(4))
            return "Oreja";

        if(respuestas.get(10) && respuestas.get(11) )
            return "Pan de muerto";

        if(respuestas.get(3) && respuestas.get(7) )
            return "Concha";
        if(respuestas.get(8) &&  respuestas.get(9))
            return "Mantecada";

        if(respuestas.get(12) && respuestas.get(13))
            return "Bisquet";




        return "Dona";
    }


    @Override
    public String obtenerResultado(ArrayList<Boolean> respuestas) {

        String resultado ="";
        String pan = auxResultados(respuestas);
        switch (pan) {
            case "Bolillo":
                return resultado = pan + ": Sencillo y humilde, te adaptas a cualquier cosa!!\nPd: Probablemente seas barbie version pan :0 XD";

            case "Cuernito":
                return resultado = pan+": Te freseas, fuiste en escuelas privadas e infiel jajaja.";

            case "Oreja":
                return resultado =pan+": Vives por y para el chisme, también te gusta criticar a los demás, desconfiad@ de primera :)";

            case "Pan de muerto":
                return resultado = pan+": Temido y respetado. Te observo, te analizo y respeto.ˁ(🔲-🔲ᐟ)ˀ";

            case "Concha":
               return resultado = pan+": De los sentimientos no se come, te gusta lo easy, y comer. Eres re floj@, pero responsable (｡•̀‿ -｡)";

            case "Mantecada":
                return resultado = pan+": Besto outfits ( ͡╯ ͜ʖ ͡╰)👌. La altura no importa XD";

            case "Bisquet":
                return resultado = pan+": Asocial, raro y probablemente seas el matadito de la clase, fuerza!!.ヽ(^ ᗨ ^)ノ";



            default:
                return resultado =  pan+": 5mentarios, extravagante, extravagante...👍👍";

        }
        


    }



}



