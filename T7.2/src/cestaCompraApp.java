import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.text.DecimalFormat;
public class cestaCompraApp {
	
	
	//importamos DecimalFormat para redondear todos los resultados Double a dos decimales
		static DecimalFormat df = new DecimalFormat("#.##");

	public static void main(String[] args) {

		//creamos un programa que nos permita usar una cesta de la compra
		//el usuario podra comprar productos introduciendo sus datos y luego podra pagar
		// y recibir un cambio por el dinero pagado o se le solicitara que introduzca mas dinero
		
		
		//consultamos al usuario cuantos articulos desea introducir y lo guardamos en una variable
		String numeroArticulosString = JOptionPane.showInputDialog("Cuantos articulos deseas introducir en la cesta?");

		int numeroArticulos = Integer.parseInt(numeroArticulosString);
		
		//consultamos el porcentaje de IVA que desea aplicar a los productos y lo guardamos en una variable
		String tipodeIVAString = JOptionPane.showInputDialog("Que porcentaje de IVA aplicaras? opciones: 21% o 4% \n escribe 21 o 4");
		int tipodeIVA = Integer.parseInt(tipodeIVAString);
		
		
		//creamos una ArrayList donde almacenaremos estos datos introducidos
		ArrayList<Double> PrecioArticulos=new ArrayList<Double>();
		
		
		//creamos un loop que rompa cuando se hayan acabado la cantidad de articulos antes consultada
		//donde solicitaremos el valor del articulo
		for (int i = 0; i <numeroArticulos; i++) {
			
			
			//solicitamos el valor  y lo guardamos en una variable
			String valorArticuloString = JOptionPane
					.showInputDialog("Introduce el valor del articulo " + " "+(i+1));
			Double valorArticulo = Double.parseDouble(valorArticuloString);
			
			//guardamos el valor capturado por la variable en el ArrayList
			PrecioArticulos.add(valorArticulo);
			
		}
		
		//crearemos un loop para recorrer el ArrayList y sumar el valor de todos los productos guardados
		double valorTotal = 0;
		for (int j =0; j<PrecioArticulos.size();j++) {
			
			
			
			valorTotal = valorTotal + PrecioArticulos.get(j);
					
			
			}
		
		//aplicamos el iva del producto y lo guardamos en una variable
		double valorTotalConIVA=(valorTotal*tipodeIVA/100)+valorTotal;
		
		//imprimimos el valor total con IVA
		JOptionPane.showMessageDialog(null,"el monto total con IVA es: " +valorTotalConIVA);
		
		//solicitamos que el usuario introduzca el dinero a pagar
		String pagoString = JOptionPane.showInputDialog("introduce la cantidad de pago");
		double abono=0;
		//lo guardamos en una variable
		double pago = Double.parseDouble(pagoString);
		
		
		//creamos un loop para que mientras el pago sea inferior al precio total de los productos 
		// el usuario deba seguir abonando dinero hasta completar la cantidad total de los productos
		while(pago<valorTotalConIVA) {
			
			//creamos una variable donde guardamos la cantidad que  falta por pagar
			double faltan = valorTotalConIVA-pago;
			
			//indicamos al usuario cuanto falta por pagar
			JOptionPane.showMessageDialog(null,"faltan "+df.format(faltan)+" "+"Euros");
			
			//y le indicamos que introduzca la cantidad restante
			String abonoString = JOptionPane.showInputDialog("introduzca la cantidad restante");
			abono = Double.parseDouble(abonoString);
			pago = pago+abono;
		}
		//en caso de que el pago sea superior al monto total de los productos, se le indicara al usuario el cambio
		double cambio = pago-valorTotalConIVA;
		
		//indicamos el cambio al usuario
		if(cambio>0) {
		JOptionPane.showMessageDialog(null,"su cambio es de " + df.format(cambio)+" "+"Euros");
		}
		
		//despedimos al usuario y finalizamos programa
		JOptionPane.showMessageDialog(null,"Gracias, vuelva pronto!");

	}
}
		





