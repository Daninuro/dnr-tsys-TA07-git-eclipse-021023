package Act2;

import java.util.*;

public class VentasSupermercado 
{
	
	public static void main(String[] args) 
	{
		
		Hashtable <String, Double> lista_articulos = new Hashtable <String, Double> ();
		
		ArrayList <Double> carrito = new ArrayList <> ();

		// Fill the currently available items
		listaArticulos(lista_articulos);
		
		// Show the filled students structure
		menuApp(lista_articulos, carrito);

	}
	
	
	public static void menuPrincipal() 
	{
		
		System.out.println("Que operacion desea realizar?");
		System.out.println("-------------------------------------------");
		System.out.println("'1' Para añadir un articulo al carrito");
		System.out.println("'2' Para ver todos los articulos del carrito");
		System.out.println("'3' Para comprar el carrito actual");
		System.out.println("'4' Para ver este menu");
		System.out.println("'5' Para salir de la app");
		
	}
	
	
	public static void añadirArticulosCarrito(Hashtable <String, Double> listaArticulos, ArrayList <Double> art_carrito) 
	{
		
		boolean condicion = true;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String opcion;
		
		// Bucle para seguir agregando elementos
		while (condicion)
		{
			System.out.println("Ingrese el producto que desea agregar; ingrese '1' para ver todos los productos, ingrese '2' para regresar al menú principal");
			System.out.print("-> ");
			
			opcion = scanner.next();
			
			// Comprueba si lo que escribimos no es igual a 'exit'
			if (!opcion.equals("2"))
			{
				// Comprueba si lo que escribimos no es igual a 'ver'
				if (!opcion.equals("1"))
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
		
	
	public static void menuApp(Hashtable <String, Double> listaArticulos, ArrayList <Double> art_carrito) 
	{
		
		boolean condicion = true;
		Scanner scanner = new Scanner(System.in);
		String opcion;
		
		System.out.println("Pulse '4' para abrir el menu de la aplicacion");
		System.out.print("-> ");
		
		
		// Bucle que garantiza que el usuario aún quiera agregar elementos
		
		while (condicion)
		{
			
			opcion = scanner.next();
		
		
			switch (opcion)
			{
				case "1":
					// Añadimos articulos al carrito
					añadirArticulosCarrito(listaArticulos, art_carrito);
					
					System.out.println("Pulse '4' para abrir el menu de la aplicacion");

					break;
				case "2": 
					// Vemos que tenemos en el carrito
					verCarrito(art_carrito);
					
					System.out.println("Pulse '4' para abrir el menu de la aplicacion");

					break;
				case "3":
					// Compra el carrito
					comprarCarrito(art_carrito);
					condicion = false;
					
					System.out.println("Pulse '4' para abrir el menu de la aplicacion");

					break;
				case "4":
					// Muestra el menu principal
					menuPrincipal();
					break;
				case "5":
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
	
	
	public static void listaArticulos(Hashtable <String, Double> lista_articulos) 
	{
		
		lista_articulos.put("pan", 1.89);
		lista_articulos.put("pizza", 2.31);
		lista_articulos.put("tomate", 1.59);
		lista_articulos.put("leche", 1.10);
		lista_articulos.put("carne", 3.56);
		lista_articulos.put("galletas", 1.29);
		lista_articulos.put("pulpo", 10.99);
		lista_articulos.put("pescado", 2.99);
		lista_articulos.put("cereales", 1.29);
		lista_articulos.put("zanahoria", 0.99);	
		
	}
	
	
	
}
