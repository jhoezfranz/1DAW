import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Cliente {
	String nombre;
	String id;

	Cliente() {

		this.nombre = "";
		this.id = "";
	}

	Cliente(String nombre_archivo) {

		File archivo = new File(nombre_archivo);
		try {
			Scanner leer = new Scanner(archivo);
			this.nombre = leer.nextLine();
			this.id = leer.nextLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void guardar() {

		try {
			File carpeta = new File("Clientes");
			if (carpeta.exists() == false) {
				carpeta.mkdir();
			}
			FileWriter archivo = new FileWriter("Clientes\\" + this.id + ".txt");
			archivo.write(this.nombre + "\r\n" + this.id);
			archivo.flush();
			archivo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void info() {
		System.out.println();
		System.out.println("———————————————————————————————————————————————");
		System.out.println("Nombre del cliente: "+this.nombre);
		System.out.println("Identificador del cliente: "+this.id);
		System.out.println("———————————————————————————————————————————————");
		System.out.println();
	}
}
