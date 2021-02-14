
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class CajeroApp {

	// creamos una variable que almacenara el numero en stock (lo usaremos como
	// parametro en varios metodos)
	static int numStock = 0;
	
	//creamos una variable que nos dira si el almacen esta configurado
	static int stockVacio=0;
	
	//importamos DecimalFormat para redondear todos los resultados Double a dos decimales
	static DecimalFormat df = new DecimalFormat("#.##");
	
	

	// creamos dos hashtables, una con la lista de los articulos, y otra con la
	// lista el stock disponible de articulos (haremos una llamada de estos en
	// varios metodos)
	static Hashtable<String, Double> listaArticulos = new Hashtable<String, Double>();
	static Hashtable<String, Integer> stockArticulos = new Hashtable<String, Integer>();
	static Hashtable<String, Double> listaCompra = new Hashtable<String, Double>();

	public static void main(String[] args) {


		
		
		//  llamamos al metodo bienvenida y creamos una variable para contrastar las opciones
		int respuestaBienvenida = bienvenida();

		// si la respuesta es 1 (consultar el control de stock)
		if (respuestaBienvenida == 1) {

			controlStock(); // ejecutamos el metodo control de stock

			// si la respuesta es 2 (abrir la caja para hacer la compra)
		} else if (respuestaBienvenida == 2) {
			
				//si el stock esta vacio el programa nos obliga a configurarlo
				if(stockVacio==0) {
					
					
					JOptionPane.showMessageDialog(null,"Al ser la primera vez debes configurar el almacen!");
					controlStock();
				}
				

			cestaCompra(numStock); // entonces ejecutamos el metodo control de stock

			// en caso de que ninguna de las respuestas anteriores se haya ejecutado,
			// volvemos al inicio
		}else
			bienvenida(); // ejecutando de nuevo el metodo bienvenida
		
	}

	
	

	
	
	//LISTA DE METODOS
	
	//METODO de bienvenida, menu donde se pregunta al usuario que desea hacer
	
	public static int bienvenida() {
		
		
		// creamos el metodo bienvenida donde preguntamos al usuario si desea consultar
		// el control de stock o abrir la caja para realizar las compras

		// consultamos las opciones que se pueden hacer
		String respuestaString = JOptionPane.showInputDialog(
				"Bienvenido/a!\nQue deseas hacer?\n Consultar el control de Stock: presiona 1\n Abrir caja para realizar compras: presiona 2");
		int respuesta = Integer.parseInt(respuestaString);

		// retornamos una respuesta de tipo Entero
		return respuesta;

		
	}

	//METODO PRINCIPAL control de stock donde se almacenaran y consultaran todos articulos disponibles
	public static void controlStock() {
		
		//En este metodo podremos almacenar todos los datos en el stock de la tienda
		//Tambien podremos consultar los datos almacenados
		
		
		//Empezamos consultando si el usuario desea crear una lista por defecto (que la llamaremos desde el metodo "listaPorDefecto")
		int j = 0;
		do {
			String respuesta2String = JOptionPane.showInputDialog("Deseas crear una lista por defecto o crear una lista de stock manual?\n Escribe defecto o manual");

			// si la respuesta es afirmativa llamamos al metodo "listaPorDefecto"
			
			if (respuesta2String.equals("defecto")) {
				//llamamos a la lista por defecto
				j=5;
				listaPorDefecto();

				// en caso contrario se ejecutara el metodo para hacerla manual
			} else if (respuesta2String.equals("manual")) {
				j=5;
				listaManual();
			} else {
				
				//en caso de que la respuesta sea incorrecta se le comunica al usuario (tiene 5 intentos antes de romper el loop)
				JOptionPane.showMessageDialog(null, "has de escribir defecto o manual");
				j++;
			}
		} while (j < 5);
		
		
		// En este  loop preguntamos al usuario si desea consultar la lista entera
				// de articulos
				 j = 0;
				do {
					String respuesta2String = JOptionPane.showInputDialog("Deseas consultar la lista entera de articulos?\n escribe si o no");

					// si la respuesta es afirmativa indicamos a las hashtables que impriman todos los valores 
					
					if (respuesta2String.equals("si")) {
						j = 5;

						Enumeration<Double> precio = listaArticulos.elements();
						Enumeration<String> articulo = listaArticulos.keys();
						Enumeration<Integer> stock = stockArticulos.elements();

						while (articulo.hasMoreElements() && precio.hasMoreElements() && stock.hasMoreElements()) {
							System.out.println("Articulo: " + articulo.nextElement() + "     " + "precio: "
									+ precio.nextElement() + " " + "Euros     " + "Existencias: " + stock.nextElement());

						}

						// en caso contrario finalizamos el loop
					} else if (respuesta2String.equals("no")) {
						j = 5;

						// en el caso de que ninguna respuesta sea elegida o se elija una incorrecta
						// indicamos como se deben introducir los datos y sumamos en 1 al iterador hasta
						// 5 intentos
					} else {
						JOptionPane.showMessageDialog(null, "has de escribir si, o no");
						j++;
					}
				} while (j < 5);
				
				
				
		//A continuacion creamos el "Do" donde preguntamos al usuario si desea consultar algun articulo en concreto
		int i = 0;
		 
		do {
			String respuesta1String = JOptionPane.showInputDialog("Deseas consultar algun articulo en concreto?\n escribe si o no");

			// si la respuesta es que si
			if (respuesta1String.equals("si")) {

				// solicitaremos ingresar el nombre del articulo
				String consultaArticulo = JOptionPane
						.showInputDialog("escribe el nombre del articulo que deseas consultar");

				// entonces imprimiremos el valor que tiene la "hashtable" que contenga ese
				// "key"
				JOptionPane.showMessageDialog(null,
						consultaArticulo + " " + "vale " + listaArticulos.get(consultaArticulo) + " " + "Euros");

				// indicamos que el iterador vale 5 por lo tanto finalizaria este loop
				i = 5;

				// imprimimos el stock disponible para ese "key" tmabien
				JOptionPane.showMessageDialog(null,
						"Stock disponible: " + stockArticulos.get(consultaArticulo) + " Unidad/es ");

				// indicamos que el iterador vale 5 por lo tanto finalizaria este loop
				i = 5;

				// en caso de que la respuesta sea negativa
			} else if (respuesta1String.equals("no")) {

				// simplemente indicamos que el iterador vale 5 por lo tanto finalizaria este
				// loop
				i = 5;

				// En el caso de que ninguna respuesta sea elegida o se elija una incorrecta
				// indicamos como se deben introducir los datos y sumamos en 1 al iterador hasta
				// 5 intentos
			} else {
				JOptionPane.showMessageDialog(null, "has de escribir si, o no");
				i++;
			}
			// a los 5 intentos maximo, rompemos el loop
		} while (i < 5);

		

		// creamos el "Do while" donde preguntamos al usuario si desea realizar una compra
		do {
			String respuesta1String = JOptionPane.showInputDialog("Deseas realizar una compra?\n escribe si o no");

			// si la respuesta es que si
			if (respuesta1String.equals("si")) {

				//ejecutamos el metodo "cesta de la compra"
				cestaCompra(numStock);

				// en caso de que la respuesta sea negativa
			} else if (respuesta1String.equals("no")) {

				// simplemente indicamos que el iterador vale 5 por lo tanto finalizaria este
				// loop
				i = 5;

				// en el caso de que ninguna respuesta sea elegida o se elija una incorrecta
				// indicamos como se deben introducir los datos y sumamos en 1 al iterador hasta
				// 5 intentos
			} else {
				JOptionPane.showMessageDialog(null, "has de escribir si, o no");
				i++;
			}
			// a los 5 intentos maximo, rompemos el loop
		} while (i < 5);

		// al acabar indicamos que el stock se ha configurado,esto nos permitiria acceder directamente a la lista de la compra desde el inicio
		// sin tener que pasar por el control de stock
		//(en ese caso tendrian que quedar almacenados todos los datos introducidos en el  stock al cerrar el programa)
		stockVacio=1;
					
	}
	

	//METODO PRINCIPAL cesta de la compra donde el usuario podra realizar la compra completa de los productos
	// podra pagar y recibir cambio
	public static void cestaCompra(int numStock) {


		// preguntamos al usuario cuantos productos desea comprar
		String numeroArticulosString = JOptionPane.showInputDialog("Cuantos articulos deseas introducir en la cesta");
		
		// guardamos la cantidad en una variable numerica
		int numeroArticulos = Integer.parseInt(numeroArticulosString);

		// creamos variable donde indicaremos mas adelante la cantidad de cada producto
		// que se comprara
		int cantidadCompraArticulo = 0;
		
		
		// creamos un loop para indicar el nombre de los articulos que introduciremos en
		// la lista y guardaremos todos los valores en la lista de la compra (nombre y
		// precio)
		//iterador del loop 
		int i = 0;
			while (i< numeroArticulos)	{
			
			// solicitamos al usuario el nombre del articulo
			String nombreArticuloString = JOptionPane.showInputDialog("Introduce el nombre del articulo " + " " + (i + 1));
			
			
			// solicitamos al usuario la cantidad de ese mismo producto que desea comprar
			String cantidadCompraArticuloString = JOptionPane
					.showInputDialog("Introduce la cantidad de este producto que deseas comprar");
			// lo guardamos en una variable de tipo numerico
			cantidadCompraArticulo = Integer.parseInt(cantidadCompraArticuloString);
			
			
			// llamamos al metodo "consultaDisponible" para consultar en la lista de stock
			// si disponemos de ese producto
			
			// creamos una variable booleana para determinar si quedan unidades de ese articulo en el stock
			boolean hayArticulos = consultaDisponible(nombreArticuloString,cantidadCompraArticulo);

			if(hayArticulos) {
				
				//llamamos al metodo "introduccion de valores" para actualizar la lista de stock de los objetos que se han comprado
				// y para introducir los precios guardados a la lista de la compra
				introduccionDeValores(nombreArticuloString,cantidadCompraArticulo,i);
			
				i++;
				
			}else {
				
				// mientras la respuesta sea que no hay, se repite el loop
				JOptionPane.showMessageDialog(null,
						"Lo siento, no queda(n) " + nombreArticuloString + " prueba con otro articulo o una cantidad menor ");
			}
		}
				
				
			
		// una vez llena la lista de la compra vamos a calcular el valor total que ha de
		// pagar el cliente

		// creamos la variable "valorTotal" donde guardaremos la suma total de la lista
		// de la compra
		double valorTotal = 0;

		// recorremos  la lista de la compra
		Enumeration<Double> enumeration = listaCompra.elements();
		
		while(enumeration.hasMoreElements()) {
			valorTotal += enumeration.nextElement();
		}
		
		
		// imprimimos el valor total sin IVA de la lista deseada
		JOptionPane.showMessageDialog(null, "subtotal: " + valorTotal);
		
		for (int j = 0; j < numeroArticulos; j++) {

			//valorTotal += (listaCompra.get(j) * cantidadCompraArticulo);

			
			
		}

		// preguntamos el tipo de IVA que aplicaremos
		String tipodeIVAString = JOptionPane
				.showInputDialog("Que porcentaje de IVA aplicaras? opciones: 21% o 4%?\n escribe 21 o 4");

		// guardamos el valor numnerico en la variable "tipodeIVA"
		int tipodeIVA = Integer.parseInt(tipodeIVAString);

		// ahora calcularemos el valor total del producto con el IVA
		double valorTotalConIVA = (valorTotal * tipodeIVA / 100) + valorTotal;

		// imprimimos el valor total con IVA de la lista deseada, 
		JOptionPane.showMessageDialog(null, "el monto total con IVA es: " + df.format(valorTotalConIVA)); //convertimos el valor para que tenga 2 decimales

		// ahora solicitamos al cliente que introduzca la cantidad de dinero con la que
		// desea pagar
		String pagoString = JOptionPane.showInputDialog("introduce el dinero");

		// creamos la variable "bono" donde guardaremos el valor que queda por pagar
		// despues de lo introducido
		double abono = 0;

		// convertimos el valor de pago introducido a valor numerico
		double pago = Double.parseDouble(pagoString);

		// realizamos un loop para que se cumpla el pago total del importe en caso de
		// que se introduzca una cantidad inferior
		while (pago < valorTotalConIVA) {

			// si el valor de pago es inferior al monto total, guardamos la diferencia en la
			// variable "faltan"
			double faltan = valorTotalConIVA - pago;

			// indicamos la cantidad que falta, redondeamos esa cantidad para que nos de 2
			// decimales
			JOptionPane.showMessageDialog(null, "faltan " + df.format((faltan * 100.0) / 100.0) + " Euros");

			// ahora solicitamos que el usuario ingrese la cantidad restante
			String abonoString = JOptionPane.showInputDialog("introduzca la cantidad restante");

			// y lo guardamos en la variable "abono"
			abono = Double.parseDouble(abonoString);

			// luego sumamos la cantidad abonada al pago total
			pago += abono;
		}

		// creamos una variable donde guardaremos el cambio del dinero pagado por el
		// usuario, en caso de que haya pagado de mas
		double cambio = pago - valorTotalConIVA;

		// si hay cambio (cambio>0) indicamos la cantidad a devolver por pantalla
		if (cambio > 0) {
			JOptionPane.showMessageDialog(null,
					"su cambio es de " + Math.round((cambio * 100.0) / 100.0) + " Euros");
		}

		// y nos despedimos
		JOptionPane.showMessageDialog(null, "Gracias, vuelva pronto!");

	}


	//METODO SECUNDARIO consulta de productos disponibles
	public static boolean consultaDisponible(String nombreArticuloString, int cantidadCompraArticulo) {

		//en este metodo consultaremos el hashtable del stock para saber si la cantidad de articulo que el usuario desea comprar
		// se encuentra disponible
		int cantidadDisponible = stockArticulos.get(nombreArticuloString);

		//si la cantidad disponible es inferior a la que solicita el usuario retornamos un valor booleano FALSO
		if (cantidadDisponible < cantidadCompraArticulo) {

			return false;

			//en caso contrario retornamos un valor TRUE
		}else {

			return true;
		}

	}
	
	//MEOTODO SECUNDARIO introduccion De Valores
	public static void introduccionDeValores(String nombreArticuloString,int cantidadCompraArticulo, int i) {

		//en este metodo iremos introduciendo todos los valores en la lista de la compra 
		//tambien le indicamos al stock que reste la cantidad de articulos que se compraran
		
		
		// solicitamos el valor de ese articulo en la lista de articulos que creamos
		double precio = listaArticulos.get(nombreArticuloString);

		// introducimos ese valor a la  lista de la compra usando como key el
		// mismo nombre del producto
		listaCompra.put(nombreArticuloString, precio);

		

		// indicamos inmediatamente a lista de productos en stock que se le reste la
		// cantidad de ese producto a la cantidad que hay
		// indicando el producto al que nos referimos
		stockArticulos.put(nombreArticuloString, numStock - cantidadCompraArticulo);
} 

	//METODO SECUNDARIO  lista por defecto, para que no sea necesario introducir todos los datos en el stock desde 0
	public static void listaPorDefecto() {
		
		//creamos 3 arrays con los elementos por defecto
		
		
		String a[]=new String[3];
		double b[]=new double[3];
		int c[]=new int[3];
		
		
		
		//articulo
		a[0]="raton";
		a[1]="teclado";
		a[2]="pantalla";
		
		//precio
		b[0]=5;
		b[1]=20;
		b[2]=200;
		
		//numero de stock
		c[0]=2;
		c[1]=2;
		c[2]=2;
		
		//loop para introducir los datos de los Arrays en las hashtables

		int i=0;
		while (i<a.length) {
			
		String nombreArticulo = a[i];
		double precioArticulo = b[i];
		int stockArticulo = c[i];
		
		
		
		listaArticulos.put(nombreArticulo, precioArticulo);
		stockArticulos.put(nombreArticulo, stockArticulo);
		
		i++;
		}
		
		
		}

	//METODO SECUNDARIO lista manual para introducir todos los datos en el stock
	public static void listaManual() {

	// creamos una variable con el valor por defecto del numero de articulos = 1
	int numeroArticulos = 1;


// creamos un for loop para recorrer ambas hashtables introduciendo los datos
for (int i = 0; i < numeroArticulos; i++) {

// pedimos al usuario introducir el nombre del primer articulo y lo recogemos en
// la variable nombreArticuloString
String nombreArticuloString = JOptionPane.showInputDialog("introduce el NOMBRE del articulo " + (i + 1));

// pedimos al usuario introducir el valor del primer articulo
String valorArticuloString = JOptionPane.showInputDialog("introduce el VALOR del articulo " + (i + 1));

// recogemos ese valor en la variable valorArticulo
double valorArticulo = Double.parseDouble(valorArticuloString);

// introducimos las existencias en stock del articulo que hemos introducido
String numStockString = JOptionPane
		.showInputDialog("introduce las existencias en stock de ese articulo " + (i + 1));

// lo guardamos en la variable que hemos declarado al principio de esta clase
numStock = Integer.parseInt(numStockString);

// guardamos los datos que vamos recogiendo en la lista mientras vamos
// recorriendo el loop
listaArticulos.put(nombreArticuloString, valorArticulo);
stockArticulos.put(nombreArticuloString, numStock);

		}
	}

}












