package controller.ejercicios;

import java.text.DecimalFormat;
import java.util.Scanner;
/*El costo de las llamadas telefónicas internacionales depende
de la zona geográfica en la que se encuentre el país destino y
del número de minutos hablados. En la siguiente tabla se presenta
el costo del minuto por hora. Cada zona se le ha asociado con una
clave (Use tipos de datos ENUMERADOS PARA LA ZONA).
*/
//Tarifas
/*Zona
Clave
Precio Minuto (USD)
AMÉRICA DEL NORTE
12  2.75
AMÉRICA CENTRAL
15  1.89
AMÉRICA DEL SUR
18  1.60
EUROPA
19  3.5
ASIA
23  4.5
ÁFRICA
25  3.1
OCEANÍA
29  3
RESTO DEL MUNDO
31  6

 */

import controller.util.Utilidades;

public class Tarifatelefono {
  public int prefijo (String numero_telef_ingresado) {
    int prefijo = 0;
    String numero_telef = Utilidades.validadorEspacios(numero_telef_ingresado);
    int inicio_prefijo = numero_telef.indexOf("+") + 1;
    int final_prefijo = numero_telef.indexOf("+") + 3;
    if (numero_telef.contains("+")) {
      prefijo = Utilidades.transformStringInt(numero_telef.trim().substring( inicio_prefijo, final_prefijo));
    } else if (numero_telef.length() == 4 && numero_telef.contains(("("))){
      prefijo = Utilidades.transformStringInt(numero_telef.trim().substring(1, 3));
    }else {
      prefijo = Utilidades.transformStringInt(numero_telef.trim().substring( 0, 2));
    }
    
    return prefijo;
  }


  private Scanner sc = new Scanner(System.in);
  public void tarifaTelefono () {
    DecimalFormat formatodecimal = new DecimalFormat("#.00");
    System.out.println("BIENVENIDOS A NUESTRO SISTEMA");
    System.out.println("Ingrese el numero a llamar con el prefijo del pais, ejemplo (+00) o +00");
    System.out.print("INGRESE EL NUMERO: "); 
    String numero_telef_ingresado = sc.nextLine();


    
    System.out.print("Ingrese el tiempo de la llamada: ");
    String minutos_llamada_1 = sc.nextLine();
    double minutos_llamada = Utilidades.transformStringDouble(minutos_llamada_1);

    int prefijo = 0;
    
    // funcion para poder obtener el prefijo ingresado
    prefijo = prefijo(numero_telef_ingresado);

    double pagar = 0.0;    String zona = "";
    double tarifa = 0.0;

    
    if (prefijo == 12) {
      tarifa = 2.75;
      pagar = tarifa * minutos_llamada;
      zona = "AMERICA DEL NORTE";
    } else if (prefijo == 15) {
      tarifa = 1.89;
      pagar = tarifa * minutos_llamada;
      zona = "AMERICA CENTRAL";
    } else if (prefijo == 18) {
      tarifa = 1.60;
      pagar = tarifa * minutos_llamada;
      zona = "AMERICA DEL SUR";
    } else if (prefijo == 19) {
      tarifa = 3.50;
      pagar = tarifa * minutos_llamada;
      zona = "EUROPA";
    } else if (prefijo == 23) {
      tarifa = 4.50;
      pagar = tarifa * minutos_llamada;
      zona = "ASIA";
    } else if (prefijo == 25) {
      tarifa = 3.10;
      pagar = tarifa * minutos_llamada;
      zona = "AFRICA";
    } else if (prefijo == 29) {
      tarifa = 3.00;
      pagar = tarifa * minutos_llamada;
      zona = "OCEANIA";
    } else {
      tarifa = 6;
      pagar = tarifa * minutos_llamada;
      zona = "RESTO DEL MUNDO";
    }

    System.out.println(" ");
    System.out.println("--------------------------------------------------------------------");
    System.out.println("Estas llamando a "+ zona + " con el prefijo (+" + prefijo + ")" );
    System.out.println("El valor por minuto es de: " + tarifa + " USD" );
    System.out.println("El valor que tiene que cancelar es de " + formatodecimal.format(pagar) + " USD por " + minutos_llamada + " minutos de llamada" );
    System.out.println("--------------------------------------------------------------------");
    System.out.println(" ");
    
  }  

}
