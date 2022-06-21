import java.util.ArrayList;

/**
 * Encuesta que te dice que facultad de la UNAM eres 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class EncuestaFacultad extends Encuesta{

    /**
     * Constructor para EncuestaFacultad
     */
    public EncuestaFacultad(){
        modo = "CREATIVO";
        nombreEncuesta = "ENCUESTA FAC UNAM";
        generarPreguntas();
    }


    /**
     * Crea las preguntas de la encuesta
     */
    private void generarPreguntas(){

        preguntas = new ArrayList<Pregunta>();

        Pregunta p1 = new Pregunta("sad pero horny 24/7. Demuestras teoremas, pero no le demuestras tus emociones xD");
        preguntas.add(0,p1);

        Pregunta p2 = new Pregunta(" Te freseas, sientes que los demás no te merecen. ");
        preguntas.add(1,p2);

        Pregunta p3 = new Pregunta(" Pilar de la UNAM si que si ");
        preguntas.add(2,p3);

        Pregunta p4 = new Pregunta("Buena onda con la banda");
        preguntas.add(3,p4);

        Pregunta p5 = new Pregunta("Medio emo");
        preguntas.add(4,p5);

        Pregunta p6 = new Pregunta("Otaku jeje");
        preguntas.add(5,p6);

        Pregunta p7 = new Pregunta("Vas a todas las fiestas y caes bien");
        preguntas.add(6,p7);

        Pregunta p8 = new Pregunta("Te la sabes: .... sin panza no genera confianza");
        preguntas.add(7,p8);

        Pregunta p9 = new Pregunta("PARO!?");
        preguntas.add(8,p9);

        Pregunta p10 = new Pregunta("Te gusta llevar la vida relax xD");
        preguntas.add(9,p10);

        Pregunta p11 = new Pregunta("'Aquí hay marihuanos. Ah, caray!, soy yo");
        preguntas.add(10,p11);

        Pregunta p12 = new Pregunta("PARACETAMOL!!");
        preguntas.add(11,p12);

        Pregunta p13 = new Pregunta("De hecho hay un trauma que lo explica...");
        preguntas.add(12,p13);




    }


    @Override
    public String obtenerResultado(ArrayList<Boolean> respuestas) {
        if(respuestas.get(2))
            return "Eres la Facultad de Derecho!";

        if(respuestas.get(12) )
            return "Eres la Facultad de Psicología!";

        if(respuestas.get(0) )
            return "Eres la Facultad de Ciencias!(Wuuu)";

        if(respuestas.get(7))
            return "Eres la Facultad de Ingenieria! >:v";

        if(respuestas.get(11) )
            return "Eres la Facultad de Medicina!";
        if(respuestas.get(10) )
            return "Eres FILOS!";

        if(respuestas.get(12) && respuestas.get(13))
            return "Eres POLAKAS!";




        return "Eres versátil✨, culquier fac de la UNAM se acómoda a tus excentridades¯\\(º_o)/¯";
    }

}
