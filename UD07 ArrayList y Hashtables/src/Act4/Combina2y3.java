package Act4;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Combina2y3 
{
	
	
	public static void main(String[] args)
	{
		
		Hashtable <String, Double> inventario = new Hashtable <String, Double> ();
		
		Hashtable <String, Integer> tamaño_inventario = new Hashtable <String, Integer> ();
		
		ArrayList <Double> carrito = new ArrayList <Double> ();
		
		menuApp(inventario, tamaño_inventario, carrito);
		
	}
	
	
	public static void menuPrincipal() 
	{
		
		System.out.println("Que operacion desea realizar?");
		System.out.println("-------------------------------------------");
		System.out.println("'1' Para ver el inventario actual");
		System.out.println("'2' Para buscar un artículo del inventario actual");
		System.out.println("'3' Para quitar un articulo del inventario");
		System.out.println("'4' Para agregar un articulo al inventario");
		System.out.println("'5' Para añadir un articulo al carrito");
		System.out.println("'6' Para ver todos los articulos del carrito");
		System.out.println("'7' Para comprar el carrito actual");
		System.out.println("'8' Para ver este menu");
		System.out.println("'9' Para salir de la app");
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
	
	
	public static void añadirArticulosCarrito(Hashtable <String, Double> listaArticulos, ArrayList <Double> art_carrito) 
	{
		boolean condicion = true;
		Scanner scanner = new Scanner(System.in);
		String opcion;
		
		// Bucle que garantiza que el usuario aún quiera agregar elementos
		while (condicion)
		{
			System.out.println("Ingrese el producto que desea agregar; ingrese 'ver' para ver todos los productos, ingrese 'exit' para regresar al menú principal");
			System.out.print("-> ");
			
			opcion = scanner.next();
			
			// Comprueba si lo que escribimos no es igual a 'exit'
			if (!opcion.equals("exit"))
			{
				// Comprueba si lo que escribimos no es igual a 'ver'
				if (!opcion.equals("ver"))
				{
					// Comprueba si el artículo está disponible en el inventario
					if (listaArticulos.containsKey(opcion))
					{
						// Agregamos el producto
						art_carrito.add(listaArticulos.get(opcion));
						System.out.println("Articulo " + opcion + " añadido al carrito!");
					}
					else
					{
						System.out.println("Articulo no disponible");
					}
				}
				else
				{
					// Si escribimos 'ver', imprime todos los artículos disponibles del inventario
					for (String m_item: listaArticulos.keySet()) 
					{  
						System.out.println(m_item + " -> " + listaArticulos.get(m_item) + "€");
					}
				}

			}
			else
			{
				condicion = false;
			}
		}
		scanner.close();

		
	}
	
	
	public static void verCarrito(ArrayList <Double> art_carrito) 
	{
		Double sum = 0.0;
		
		// Calcula el precio total del 'carrito'
		for (Double i : art_carrito) 
		{
			sum += i;
		}
		
		// Imprime el total de artículos y el total de dinero a pagar del carrito actual
		System.out.println("Total de articulos en el carrito : " + art_carrito.size());
		System.out.println("Total a pagar: " + (sum + (sum * 0.21)) + "€ (21% IVA)");
	}
	
	
	public static void comprarCarrito(ArrayList <Double> art_carrito) 
	{
		Scanner scanner = new Scanner(System.in);
		boolean condicion = true;
		Double opcion;
		System.out.println("Aplicando el 21% de IVA...");
		
		Double m_sum = 0.0;
		
		// Calcula el precio total del 'carrito'
		for (Double i : art_carrito) 
		{
			m_sum += i;
		}

		// Calcular el precio total (2 decimales y suma el 21% del IVA)
		System.out.println("Total a pagar: " + (Math.round((m_sum + (m_sum * 0.21)) * 100.0) / 100.0) + "€ (21% IVA)");
		
		// Imprime el precio total del 'carrito'
		System.out.println("Total de articulos al carrito: " + art_carrito.size());
		
		// Se asegura que se da suficiente dinero como para dar el cambio
		while (condicion)
		{
			System.out.println("Introduce la cantidad para pagar ");
			System.out.print("-> ");
			
			opcion = scanner.nextDouble();
			
			// Comprobar si la cantidad es suficiente
			if (opcion >= (Math.round((m_sum + (m_sum * 0.21)) * 100.0) / 100.0)) 
			{
				// Imprime el cambio
				System.out.println("Cambio: " + String.format("%.02f", Math.abs((m_sum + (m_sum * 0.21)) - opcion)) + "€\nTenga un buen dia!");
				condicion = false;
			}
			else
			{
				System.out.println("Cantidad insuficiente!");
			}

		}
		scanner.close();

		
	}
	
	
	public static void menuApp(Hashtable <String, Double> inventario, 
			Hashtable <String, Integer> tamaño_inventario, ArrayList <Double> art_cesta) {
		boolean condicion = true;
		Scanner scanner = new Scanner(System.in);
		String opcion;
		Double precio;
		Integer cantidad;
		
		System.out.println("Pulse '8' para abrir el menu de la aplicacion");
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
					
					System.out.println("Pulse '8' para abrir el menu de la aplicacion");

					break;
		
				case "2":
					// Busca el artículo disponible del inventario
					System.out.println("Ingrese el artículo para encontrar");
					System.out.print("-> ");
					opcion = scanner.next();
					
					compruebaArticulos(opcion, inventario, tamaño_inventario);
					
					System.out.println("Pulse '8' para abrir el menu de la aplicacion");

					break;
					
				case "3":
					// Eliminael articulo del inventario
					System.out.println("Escriba el articulo que quiera eliminar:");
					System.out.print("-> ");
					opcion = scanner.next();
					
					eliminaArticulo(opcion, inventario, tamaño_inventario);
					
					System.out.println("Pulse '8' para abrir el menu de la aplicacion");

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
					
					System.out.println("Pulse '8' para abrir el menu de la aplicacion");

					break;
					
				case "5":
					// Añadimos articulos al carrito
					añadirArticulosCarrito(inventario, art_cesta);
					
					System.out.println("Pulse '8' para abrir el menu de la aplicacion");

					break;
					
				case "6":
					// Vemos que tenemos en el carrito
					verCarrito(art_cesta);
					
					System.out.println("Pulse '8' para abrir el menu de la aplicacion");
					
					break;
					
				case "7":
					// Compra el carrito
					comprarCarrito(art_cesta);
					condicion = false;
					
					System.out.println("Pulse '8' para abrir el menu de la aplicacion");

					break;
									
				case "8":
					// Muestra el menu principal
					menuPrincipal();
					break;
					
				case "9":
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
