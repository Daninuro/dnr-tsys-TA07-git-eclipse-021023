package Act1;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class NotaMedia 
{
	
	public static void main(String[] args) 
	{
		
		Hashtable <String, Float> nombre_alumno = new Hashtable <String, Float> ();
		
		ArrayList <Float> nota_alumno = new ArrayList <Float> ();

		rellenarAlumno(nombre_alumno, nota_alumno);
		
		mostrarAlumno(nombre_alumno);
		
	}

	
	public static void rellenarAlumno(Hashtable <String, Float> nombre_alumno, ArrayList <Float> nota_alumno) 
	{
		
		int cantidad_alumnos, cantidad_notas, cont1, cont2;
		String nombre_alumn;
		float nota_alumn;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Escriba cuantos alumnos hay en total: ");
		
		// lee y guarda la cantidad de estudiantes que hay
		cantidad_alumnos = scanner.nextInt();
		
		System.out.println("Escriba cuantas notas hay para poner a cada alumno: ");
		
		// lee y guarda la cantidad de notas que hay por alumno
		cantidad_notas = scanner.nextInt();
		
		// Mientras haya alumnos....
		for (cont1 = 0; cont1 < cantidad_alumnos; cont1++)
		{
			
			System.out.println("Escribe cual es el nombre del alumno " +(cont1 + 1)+":");
			
			// lee y guarda el nombre del alumno
			nombre_alumn = scanner.next();
			
			// Mientras haya notas....
			
			for (cont2 = 0; cont2 < cantidad_notas; cont2++)
			{
				
				System.out.println("Escriba la nota de " + nombre_alumn + " ---> Nota: " + (cont2 + 1));
				
				//  lee y guarda la nota del alumno
				nota_alumn = scanner.nextFloat();
				
				// se añade a la ArrayList
				nota_alumno.add(nota_alumn);
				
			}
			
			// Calculamos la nota media
			nota_alumn = calculaNotaMedia(nota_alumno);
			
			//Si no limpiamos la lista, el siguiente estudiante también tendrá las calificaciones del estudiante anterior en el cálculo
			nota_alumno.clear();

			// Añadimos nombre y la nota en el Hashtable
			nombre_alumno.put(nombre_alumn, nota_alumn);
			
		}

	}
	
	
	public static float calculaNotaMedia(ArrayList <Float> cantidad_notas) 
	{
		
		float resultado = 0;
	
		for (int cont1 = 0; cont1 < cantidad_notas.size(); cont1++)
		{	// incrementa resultado con valor de cada posicion
			resultado += cantidad_notas.get(cont1);
		}
		
		
		//Devuelve el resultado dividido por el tamaño total de ArrayList para sacar la media	
		return (resultado / cantidad_notas.size());
		
	}

	
	public static void mostrarAlumno(Hashtable <String, Float> nombre_alumno) 
	{
		//Se ejecuta por cada elemento de la arraylist
		nombre_alumno.forEach((nombre_alumn, nota_alumn) -> System.out.println("La nota media de "+nombre_alumn+ " es: "+Math.round(nota_alumn*100.0)/100.0));
		
	}
	
	
	

}
