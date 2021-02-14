import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class controlStockApp {

	public static void main(String[] args) {
		
		
		
		//En esta App podremos almacenar todos los datos en el stock de una tienda
		//Tambien podremos consultar los datos almacenados
				

		//empezamos creando dos hashtables donde usaremos como KEY el nombre del producto 
		int numeroArticulos = 1;

		//en una pondremos el nombre y el precio
		Hashtable<String, Double> listaArticulos = new Hashtable<String, Double>();
		//y en otra pondremos el mismo nombre y la cantidad de ese mismo articulo
		Hashtable<String,Integer> stockArticulos = new Hashtable<String,Integer>();

		//creamos un loop para recorrer las tablas e introducir los datos mediante JoptionPane
		for (int i = 0; i < numeroArticulos; i++) {

			String nombreArticuloString = JOptionPane.showInputDialog("introduce el nombre del articulo " + (i + 1));

			String valorArticuloString = JOptionPane.showInputDialog("introduce el valor del articulo " + (i + 1));
			double valorArticulo = Double.parseDouble(valorArticuloString);
			
			String numStockString = JOptionPane.showInputDialog("introduce las existencias en stock de ese articulo " + (i + 1));
			int numStock = Integer.parseInt(numStockString);

			//introducimos los datos en las hashtables mientras se recorre el loop
			listaArticulos.put(nombreArticuloString, valorArticulo);
			stockArticulos.put(nombreArticuloString, numStock);


		}
		
		
		//creamos un do while para preguntar si se desea consultar los articulos introducidos
		int i = 0;

		do {
			String respuesta1String = JOptionPane.showInputDialog("Deseas consultar algun articulo?\n escribe si o no");

			//si la respuesta es afirmativa imprimimos el nombre del articulo 
			if (respuesta1String.equals("si")) {
				
				//pedimos el nombre del producto y lo guardamos en una variable
				String consultaArticulo = JOptionPane
						.showInputDialog("escribe el nombre del articulo que deseas consultar");

				//solicitamos al hashtable que nos muestre el valor que hay con el key que le damos guardado en la variable "consultaArticulo"
				JOptionPane.showMessageDialog(null,consultaArticulo+" "+"vale "+listaArticulos.get(consultaArticulo)+" "+"Euros");
				i=5;
				
				//imprimimos la cantidad disponible usando el otro hashtable (el de stock) y la misma key 
				JOptionPane.showMessageDialog(null,"Stock disponible: "+stockArticulos.get(consultaArticulo)+ "Unidad/es");
				i=5;
				
				//en caso de que no se desee consultar finalizamos el loop
			} else if (respuesta1String.equals("no")){
				i=5;
				
				//en caso de que se introduzca una respuesta diferente se comunica al usuario las posibles respuestas correctas
			} else {
				JOptionPane.showMessageDialog(null, "has de escribir si, o no");
				//y sumamos 1 al iterador
				i++;
			}
			//tiene hasta 5 intentos para poner una respuesta valida
		} while (i<5);
		
		
		//creamos otro do while para preguntar al usuario si desea consultar la lista entera de los articulos
		int j=0;
			do {
			String respuesta2String = JOptionPane.showInputDialog("Deseas consultar la lista entera de articulos?");

			//en caso afirmativo recorremos las hashtables 
			if (respuesta2String.equals("si")) {
				j=5;

				Enumeration<Double> precio = listaArticulos.elements();
				Enumeration<String> articulo = listaArticulos.keys();
				Enumeration<Integer> stock = stockArticulos.elements();
				
				//Imprimimos los datos en la terminal	
				while(articulo.hasMoreElements() && precio.hasMoreElements() && stock.hasMoreElements()) {
				System.out.println("Articulo: "+articulo.nextElement()+"     "+"precio: " +precio.nextElement()+" "+"Euros     "+"Existencias: "+stock.nextElement());
							
						}
				//si no se desea consultar finalizamos el loop
			} else if (respuesta2String.equals("no")) {
				j=5;
				
				
				//en caso de que se introduzca una respuesta diferente se comunica al usuario las posibles respuestas correctas
			} else {
				JOptionPane.showMessageDialog(null, "has de escribir si, o no");
				j = 0;
			}
		}    //tiene hasta 5 intentos para poner una respuesta valida
			while(j<5);
	}

}
