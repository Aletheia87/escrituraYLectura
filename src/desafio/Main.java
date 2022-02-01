package desafio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String directorio = "directorio";
		String fichero="fichero";
		String texto="Perro"; 
		
		//crearArchivo(directorio,fichero);
		buscarTexto(crearArchivo(directorio,fichero),texto);
	}

	public static String crearArchivo(String carpeta, String archivo) {
		File directorio = new File("src/" + carpeta);
		File fichero = new File("src/" + carpeta + "/" + archivo + ".txt");

		if (!directorio.exists()) {
			if (directorio.mkdir()) {
				System.out.println("El directorio se ha creado con éxito");
				try {
					fichero.createNewFile();
					FileWriter fw = new FileWriter(fichero);
					BufferedWriter bw = new BufferedWriter(fw);
					ArrayList<String> lista = crearLista();
					for (int i = 0; i < lista.size(); i++) {
						bw.write(lista.get(i));
						if (i < lista.size() - 1) {
							bw.newLine();
						}
					}
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Error al crear directorio");
				}
			}
		} else {
			System.out.println("Directorio ya existe");
		}
		return fichero.getPath();
	}

	public static ArrayList<String> crearLista() {
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Perro");
		lista.add("Gato");
		lista.add("Juan");
		lista.add("Daniel");
		lista.add("Juan");
		lista.add("Gato");
		lista.add("Perro");
		lista.add("Camila");
		lista.add("Daniel");
		lista.add("Camila");
		return lista;
	}

	public static void buscarTexto(String archivo, String texto) {
		File buscar = new File(archivo);

		if (!buscar.exists()) {
			System.out.println("El fichero ingresado no existe");
		} else {
			try {
				FileReader fr = new FileReader(buscar);
				BufferedReader br = new BufferedReader(fr);
				String linea = br.readLine();
				int contador = 0;
				while (linea != null) {
					if(linea.equals(texto)) {
						contador++;
						}
					//System.out.println(linea);
					linea=br.readLine();
					}
				br.close();
				System.out.println("Cantidad de repeticiones del texto -> " + contador);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
