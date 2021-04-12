import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Factura {
	Cliente cliente;
	Fecha fecha;
	float importe;
	int numero;

	Factura() {

		this.cliente = new Cliente();
		this.fecha = new Fecha();
		this.importe = 0;
		this.numero = 0;
	}

	Factura(String nombre_archivo) {

		File archivo = new File(nombre_archivo);
		try {
			Scanner leer = new Scanner(archivo);
			this.cliente = new Cliente();
			this.cliente.nombre = leer.nextLine();
			this.cliente.id = leer.nextLine();
			this.fecha = new Fecha(leer.nextLine());
			this.importe = Float.parseFloat(leer.nextLine());
			this.numero = Integer.parseInt(leer.nextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	void guardar() {

		try {
			File carpeta = new File("Facturas");
			if (carpeta.exists() == false) {
				carpeta.mkdir();
			}
			FileWriter archivo = new FileWriter("Facturas\\Factura " + this.numero + ".txt");
			archivo.write(this.cliente.nombre + "\r\n" + this.cliente.id + "\r\n" + this.fecha.dia + "/"
					+ this.fecha.mes + "/" + this.fecha.ano + "\r\n" + this.importe + "\r\n" + this.numero);
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
		System.out.println("Numero de factura: " + this.numero);
		System.out.println("Nombre del cliente: " + this.cliente.nombre);
		System.out.println("Identificador del cliente: " + this.cliente.id);
		System.out.println("Fecha de la factura: " + this.fecha.dia+"/"+this.fecha.mes+"/"+this.fecha.ano);
		System.out.println("Importe de la factura: " + this.importe);
		System.out.println("———————————————————————————————————————————————");
		System.out.println();
	}
}
