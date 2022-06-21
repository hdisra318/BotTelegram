import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Clase para la creacion y lectura de archivos JSON.
 * 
 * @author Reyes Ramos Luz Maria.
 * @author Flores Rojas Tenoch Itzin
 * @author Hernandez Dorantes Israel
 * @version 1.0 May 2022
 * @since Modeling and Programming 2022-2
 */
public class Parser{

	/**
	* Metodo que crea un archivo Json a partir de
	* una lista de datos.
	* @param datos La lista de datos a guardar.
	*/
	public void crearJSONDeLista(LinkedList<Encuesta> datos){

		/*Este constructor permite la interpretacion de una estructura
		de datos a una cadena. Ademas, se le da un formato mas
		legible.*/
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		/*Aqui se traduce una estructura de datos a un formato de
		cadena como un archivo json.*/
		String json = gson.toJson(datos);

		try {
			/*Aqui se escribe el archivo json a partir de la
			cadena anterior.*/
			FileWriter writer = new FileWriter("Encuestas.json");
			writer.write(json);
			writer.close();
		  
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	* Metodo que crea un archivo Json a partir de
	* un HashMap de datos.
	* @param datos El HashMap de datos a guardar.
	*/
	public void crearJSONDeHashMap(HashMap<String,Usuario> datos){
		
		/*Este constructor permite la interpretacion de una estructura
		de datos a una cadena. Ademas, se le da un formato mas
		legible.*/
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		/*Aqui se traduce una estructura de datos a un formato de
		cadena como un archivo json.*/
		String json = gson.toJson(datos);

		try {
			/*Aqui se escribe el archivo json a partir de la
			cadena anterior.*/
			FileWriter writer = new FileWriter("Usuarios.json");
			writer.write(json);
			writer.close();
		  
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	* Metodo que convierte un archivo Json a una estrucura
	* de datos LinkedList de java para su manipulacion.
	*/
	public LinkedList<Encuesta> parseDeLista(){

		/*Este objeto sirve para leer el archivo Json
		en una estructura de datos.*/
		Gson gson = new Gson();

		try{
			/*Aqui se lee el archivo y se guarda 
			en una variable.*/
			BufferedReader br = new BufferedReader(
				new FileReader("Encuestas.json"));

			Type listType = new TypeToken<LinkedList<Encuesta>>(){}.getType();
			
			/*Aqui se interpretar el archivo guardado 'br' con el
			tipo de objeto 'listType'*/

			LinkedList<Encuesta> encuestas = gson.fromJson(br, listType);
			return encuestas;
		} catch (IOException e) {
   			e.printStackTrace();
  		}

		return null;
	}

	/**
	* Metodo que convierte un archivo Json a una estrucura
	* de datos HashMap de java para su manipulacion.
	*/
	public HashMap<String,Usuario> parseDeHashMap(){

		/*Este objeto sirve para leer el archivo Json
		en una estructura de datos.*/
		Gson gson = new Gson();

		try{
			/*Aqui se lee el archivo y se guarda 
			en una variable.*/
			BufferedReader br = new BufferedReader(
				new FileReader("Usuarios.json"));

			Type listType = new TypeToken<HashMap<String,Usuario>>(){}.getType();
			
			/*Aqui se interpretar el archivo guardado 'br' con el
			tipo de objeto 'listType'*/
			HashMap<String,Usuario> usuarios = gson.fromJson(br, listType);

			return usuarios;
		} catch (IOException e) {
   			e.printStackTrace();
  		}

		return null;
	}

}