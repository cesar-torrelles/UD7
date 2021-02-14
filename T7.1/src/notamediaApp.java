import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class notamediaApp {

	//importamos DecimalFormat para redondear todos los resultados Double a dos decimales
		static DecimalFormat df = new DecimalFormat("#.##");
		
	public static void main(String[] args) {

		
		/*creamos un programa que nos calcula la nota media de unos alumnos que introduciremos manualmente
		la nota media de cada alumno es sobre 3 trimestres
		
		*/
		
		//primero solicitamos al usuario que ingrese la cantidad de alumnos que desea apuntar
		String numeroAlumnosString = JOptionPane.showInputDialog("Cuantos alumnos son?");
		//guardamos el valor en una variable
		int numeroAlumnos = Integer.parseInt(numeroAlumnosString);

		
		//creamos tres arrays donde guardaremos los datos
		
		//en la primera guardamos los nombres de los alumnos
		String arrayNombre[] = new String[numeroAlumnos];
		
		//en las siguientes guardamos las notas del primer segundo y tercer trimestre
		double arrayNota1[] = new double[numeroAlumnos];
		double arrayNota2[] = new double[numeroAlumnos];
		double arrayNota3[] = new double[numeroAlumnos];
		
		
		//creamos un loop para recorrer y almacenar todos los valores en los arrays
		for (int i = 0; i <numeroAlumnos; i++) {

			//solicitamos el nombre del alumno
			String NombreString = JOptionPane.showInputDialog("Introduce el nombre del alumno" + " "+(i + 1));
			//lo guardamos en una variable que usaremos para imprimir el nombre cuando solicitemos sus notas
			String NombreAux = NombreString;
			
			//solicitamos las notas del primer segundo y tercer trimestre de ese alumno
			//guardamos los valores en 3 variables 
			String nota1String = JOptionPane
					.showInputDialog("Introduce la nota del primer trimestre de " + NombreAux);
			
			Double nota1 = Double.parseDouble(nota1String);

			String nota2String = JOptionPane
					.showInputDialog("Introduce la nota del segundo trimestre de " + NombreAux);
			Double nota2 = Double.parseDouble(nota2String);

			String nota3String = JOptionPane
					.showInputDialog("Introduce la nota del tercer trimestre de " + NombreAux);
			Double nota3 = Double.parseDouble(nota3String);


			//ingresamos los datos en los ArrayList para cada valor del iterador
			arrayNombre[i] = NombreString;
			arrayNota1[i] = nota1;
			arrayNota2[i] = nota2;
			arrayNota3[i] = nota3;

			

		}
		//llamamos al metodo de calculo de nota media
		calculoMedia(arrayNombre, arrayNota1, arrayNota2, arrayNota3, numeroAlumnos);
	}
	//creamos un metodo donde calcularemos la nota media e imprimiremos una lista con nombres y notas
	//usamos como parametros los Arrays creados
	public static void calculoMedia(String[] arrayNombre, double[] arrayNota1, double[] arrayNota2, double[] arrayNota3,
			int numeroAlumnos) {

		//creamos una hashtable donde guardaremos nombre y nota media 
		Hashtable<String, Double> mediaAlumno = new Hashtable<String, Double>();
		
		//creamos un Array que ingresara automaticamente la media de los alumnos 
		double media[] = new double[numeroAlumnos];

		//recorremos el array con un loop
		for (int i = 0; i < numeroAlumnos; i++) {

			//indicamos la formula de la media con los arrays de las notas en funcion de la posicion del iterador
			media[i] = (arrayNota1[i] + arrayNota2[i] + arrayNota3[i]) / 3;

			//guardamos ese valor en la hashtable antes creada
			mediaAlumno.put(arrayNombre[i], media[i]);

		}
		//finalmente, recorremos la hashtable  que contiene nombres y nota media para cada alumno
		Enumeration<Double> enumeration = mediaAlumno.elements();
		Enumeration<String> nombres = mediaAlumno.keys();
		
		
			while(enumeration.hasMoreElements() && nombres.hasMoreElements()) {
				
				//convertimos los valores a dos decimales
				double dosDecimales = enumeration.nextElement();
				
				//Imprimimos los elementos ingresados en la terminal
				System.out.println(""+"la nota media de "+nombres.nextElement()+" "+"es: " +df.format(dosDecimales));
			}
	}

}



