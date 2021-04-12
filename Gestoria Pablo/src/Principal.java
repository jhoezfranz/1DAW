import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Principal {
	public static Factura[] cargaFacturas() {

		File dirFacturas = new File("Facturas");
		if (dirFacturas.exists()) {
			String[] nomFacturas = dirFacturas.list();
			Factura[] facturas = new Factura[nomFacturas.length];
			for (int i = 0; i < nomFacturas.length; i++) {
				facturas[i] = new Factura("Facturas\\" + nomFacturas[i]);

			}
			return facturas;

		}

		else {
			return new Factura[0];

		}
	}
	public static Cliente[] cargaClientes() {

		File dirClientes = new File("Clientes");
		if (dirClientes.exists()) {
			String[] nomClientes = dirClientes.list();
			Cliente[] clientes = new Cliente[nomClientes.length];
			for (int i = 0; i < nomClientes.length; i++) {
				clientes[i] = new Cliente("Clientes\\" + nomClientes[i]);

			}
			return clientes;

		}

		else {
			return new Cliente[0];

		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Factura[] facturas = cargaFacturas();
		Cliente[] clientes = cargaClientes();
		int opc = 0;
		do {

			System.out.println("1. Introducir nuevo cliente.");
			System.out.println("2. Introducir nueva factura.");
			System.out.println("3. Buscar cliente.");
			System.out.println("4. Buscar factura.");
			System.out.println("5. Ver todas las facturas de un cliente");
			System.out.println("0. Salir.");

			boolean encontrado = false;
			Scanner teclado = new Scanner(System.in);
			opc = teclado.nextInt();
			teclado.nextLine();
			switch (opc) {
			case 1:
				Cliente nuevo = new Cliente();
				System.out.println("A continuación, introduzca los datos del nuevo cliente.");
				System.out.print("Nombre: ");

				nuevo.nombre = teclado.nextLine();
				System.out.print("Identificador: ");
				nuevo.id = teclado.nextLine();

				for (int i = 0; i < clientes.length; i++) {
					if (clientes[i].id.equals(nuevo.id)) {
						encontrado = true;
					}
				}
				if (encontrado) {

					System.out.println("El cliente ya existe.");
				} else {
					nuevo.guardar();
					//clientes = cargaClientes();
					ArrayList<Cliente> listaclientes=new ArrayList(Arrays.asList(clientes));
					listaclientes.add(nuevo);
					clientes=listaclientes.toArray(clientes);
				}
				break;

			case 2:
				Factura nueva = new Factura();
				System.out.println("A continuación, introduzca los datos de la nueva factura.");
				System.out.print("Nombre del cliente: ");
				nueva.cliente.nombre = teclado.nextLine();
				System.out.print("Identificador del cliente: ");
				nueva.cliente.id = teclado.nextLine();

				for (int i = 0; i < clientes.length; i++) {
					if (clientes[i].id.equals(nueva.cliente.id) && clientes[i].nombre.equals(nueva.cliente.nombre)) {
						encontrado = true;
					}
				}
				if (!encontrado) {

					System.out.println("El cliente no existe.");
				} else {

					System.out.print("Fecha de la factura: ");
					nueva.fecha = new Fecha(teclado.nextLine());
					System.out.print("Importe de la factura: ");
					nueva.importe = teclado.nextFloat();
					teclado.nextLine();
					nueva.numero = facturas.length + 1;
					nueva.guardar();
					//facturas = cargaFacturas();
					ArrayList<Factura>listafacturas=new ArrayList(Arrays.asList(facturas));
					listafacturas.add(nueva);
					facturas=listafacturas.toArray(facturas);
				}
				break;

			case 3:
				System.out.print("Introduce el identificador del cliente que deseas buscar: ");
				String id = teclado.nextLine();

				for (int i = 0; i < clientes.length; i++) {
					if (clientes[i].id.equals(id)) {
						encontrado = true;
						clientes[i].info();
					}
				}
				if (!encontrado) {

					System.out.println("El cliente no existe.");
				}

				break;
			case 4:

				System.out.print("Introduce el numero de la factura que deseas buscar: ");
				int num = teclado.nextInt();
				teclado.nextLine();

				for (int i = 0; i < facturas.length; i++) {
					if (facturas[i].numero == num) {
						encontrado = true;
						facturas[i].info();
					}
				}
				if (!encontrado) {

					System.out.println("La factura no existe.");
				}

				break;

			case 5:
				System.out.print("Introduce el identificador del cliente: ");
				String id2 = teclado.next();

				for (int i = 0; i < facturas.length; i++) {
					if (facturas[i].cliente.id.equals(id2)) {
						encontrado = true;
						facturas[i].info();
					}
				}

				if (!encontrado) {
					System.out.println("Este cliente aún no tiene facturas.");

				}
			case 0:
				System.out.println("Gracias por usar este programa.");
				break;
			default:
				System.out.println("Opción incorrecta.");
			}

		} while (opc != 0);
		
	}	
}
//Como crear lista.
//ArrayList<Cliente> nombrevariable=new ArrayList(Arrays.asList(clientes));
//nombrevariable.add(nuevo)nuevo es el nombre del objeto que se crea del tipo de ArrayList;
//clientes=nombrevariable.toArray(clientes);
//
