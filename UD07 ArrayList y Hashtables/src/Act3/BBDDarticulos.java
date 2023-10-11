package Act3;

import java.util.Hashtable;
import java.util.Scanner;

public class BBDDarticulos 
{
	
	public static void main(String[] args) 
	{
		Hashtable <String, Double> inventario = new Hashtable <String, Double> ();
		
		Hashtable <String, Integer> tamaño_inventario = new Hashtable <String, Integer> ();
		
		menuApp(inventario, tamaño_inventario);

	}

	public static void menuPrincipal() 
	{
		
		System.out.println("Que operacion desea realizar?");
		System.out.println("-------------------------------------------");
		System.out.println("'1' Para ver el inventario actual");
		System.out.println("'2' Para buscar un artículo del inventario actual");
		System.out.println("'3' Para quitar un articulo del inventario");
		System.out.println("'4' Para agregar un articulo al inventario");
		System.out.println("'5' Para ver este menu");
		System.out.println("'6' Para salir de la app");
		System.out.println("->");
		
	}
	
	public static boolean compruebaInventario(Hashtable <String, Double> inventario, Hashtable <String, Integer> tamaño_inventario) 
	{

		boolean ret = false;

		// Verifica el tamaño de ambas Hashtables, si exceden el tamaño predeterminado, devuelve true
		if (inventario.size() >= 10 || tamaño_inventario.size() >= 10)
		{
			ret = true;
		}
		
		// True = lleno; False = no completo
		return ret;
	}
	
	
	public static void compruebaArticulos(String art_nombre, Hashtable <String, Double> inventario, Hashtable <String, Integer> tamaño_inventario) {
		
		// Comprueba si el inventario tiene el artículo
		
		if (inventario.containsKey(art_nombre) == true)
		{
			System.out.println("Articulo: " + art_nombre + "\nPrecio: " + inventario.get(art_nombre)
				+ "€\nNumero en Stock: " + tamaño_inventario.get(art_nombre));
		}
		else
		{
			System.out.println("Articulo no encontrado!");
		}
	}
	
	
	public static void eliminaArticulo(String art_nombre, Hashtable <String, Double> inventario, Hashtable <String, Integer> tamaño_inventario) 
	{
		// Comprueba si Hashtable contiene el elemento a eliminar
		if (inventario.containsKey(art_nombre) == true)
		{
			// Elimina las referencias de ambas Hashtables
			inventario.remove(art_nombre);
			tamaño_inventario.remove(art_nombre);
			
			System.out.println("Articulo: " + art_nombre + " borrado!");
		}
		else
		{
			System.out.println("Articulo no encontrado!");
		}	
	}
	
	public static void menuApp(Hashtable <String, Double> inventario, Hashtable <String, Integer> tamaño_inventario) {
		boolean condicion = true;
		Scanner scanner = new Scanner(System.in);
		String opcion;
		Double precio;
		Integer cantidad;
		
		
		System.out.println("Pulse '5' para abrir el menu de la aplicacion");
		System.out.print("-> ");
		
		// Bucle que garantiza que el usuario aún quiera agregar elementos
		
		while (condicion)
		{
					
			opcion = scanner.next();
					
			switch (opcion) 
					{
				case "1":
					// Imprime todos los artículos disponibles del inventario
					for (String m_item: inventario.keySet()) 
					{
						System.out.println("Articulo: " + m_item + "; Precio: " + inventario.get(m_item) +
								"€; Cantidad en Stock: " + tamaño_inventario.get(m_item));
					}
					System.out.println("Pulse '5' para abrir el menu de la aplicacion");

					break;
					
				case "2":
					// Busca el artículo disponible del inventario
					System.out.println("Ingrese el artículo para encontrar");
					System.out.print("-> ");
					opcion = scanner.next();
					
					compruebaArticulos(opcion, inventario, tamaño_inventario);
					
					System.out.println("Pulse '5' para abrir el menu de la aplicacion");
					
					break;

				case "3":
					// Eliminael articulo del inventario
					System.out.println("Escriba el articulo que quiera eliminar:");
					System.out.print("-> ");
					opcion = scanner.next();
					
					eliminaArticulo(opcion, inventario, tamaño_inventario);
					
					System.out.println("Pulse '5' para abrir el menu de la aplicacion");
					
					break;
					
				case "4":
					// Comprobamos si nos queda espacio en el inventario
					if (compruebaInventario(inventario, tamaño_inventario) == false)
					{
						System.out.println("Ingresa el producto que deseas agregar");
						System.out.print("-> ");
						
						opcion = scanner.next();
						
						System.out.println("Escriba precio de " + opcion);
						System.out.print("-> ");
						
						precio = scanner.nextDouble();
						
						System.out.println("Escriba cantidad de " + opcion);
						System.out.print("-> ");
						
						cantidad = scanner.nextInt();
						
						// Añadimos el nuevo articulo al inventario
						inventario.put(opcion, precio);
						tamaño_inventario.put(opcion, cantidad);
					}
					else
					{
						System.out.println("El inventario esta lleno!");
					}
					
					System.out.println("Pulse '5' para abrir el menu de la aplicacion");
					
					break;
				
				case "5":
					// Muestra el menu principal
					menuPrincipal();
					break;
					
				case "6":
					//Salir de la app
					System.out.println("Vuelva pronto!");
					condicion = false;
					break;
					
				default:
					System.out.println("Opcion no valida");
					break;
					
			}
	
		}
		scanner.close();
		
	}
	
	

}

