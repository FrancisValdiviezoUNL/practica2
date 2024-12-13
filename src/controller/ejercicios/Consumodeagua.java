package controller.ejercicios;

import java.text.DecimalFormat;
import java.util.Scanner;

import controller.util.Utilidades;

/*La empresa municipal de agua potable de Loja desea cobrar y 
calcular mensualmente el valor exacto de consumo del agua potable 
de cada medidor que pertenece a un contribuyente, de acuerdo a 
la ordenanza vigente, la cual establece la planilla de acuerdo a 
los siguientes rubros:
*/

public class Consumodeagua {
    private Scanner sc = new Scanner(System.in);
    private DecimalFormat formato = new DecimalFormat("#0.00");

    public double descuentoEspecial (int opcion_desc_edad_disc, int agua_consumo){
        double desc_edad_disc = 0.0;
        String porcentaje_discapacidad = "";
        if (opcion_desc_edad_disc == 3) {
            System.out.println("Ingrese el porcentaje de discapacidad: ");
            porcentaje_discapacidad = sc.nextLine();
            desc_edad_disc = Utilidades.transformStringDouble(porcentaje_discapacidad);
        } else if (opcion_desc_edad_disc == 2) {
            if (agua_consumo <= 15) {
                desc_edad_disc = 50.00;
            } else if (agua_consumo > 15) {
                desc_edad_disc = 30.00;
            }
        } else if (opcion_desc_edad_disc == 1) {
            desc_edad_disc = 0.0;
        }
        return desc_edad_disc;
    }

    public void planillaPagar (double pagar_aguapotable, double tasa_alcantarillado, double tasa_recoleccion, double tasa_tramite, double descuento, double desc_edad_disc){
        
        double valor_planilla = pagar_aguapotable + tasa_alcantarillado + tasa_recoleccion + tasa_tramite;

        System.out.println("----------------TU PLANILLA ES LA SIGUIENTE----------------");
        System.out.println(" ");
        System.out.println("Consumo de agua potable          = " + formato.format(pagar_aguapotable) + " USD");
        System.out.println("Tasa por alcantarillado          = " + formato.format(tasa_alcantarillado) + " USD");
        System.out.println("Tasa por recoleccion de residuos = " + formato.format(tasa_recoleccion) + " USD");
        System.out.println("Tasa por procesamiento de datos  = " + formato.format(tasa_tramite) + " USD");
        System.out.println("Descuento especial:              = " + formato.format(descuento) + " USD");
        System.out.println("Descuento aplicado:              = " + desc_edad_disc + " %");
        System.out.println(" ");
        System.out.println("Valor total de la planilla       = " + formato.format(valor_planilla) + " USD");
        System.out.println("-----------------------------------------------------------");
    }


    public void consumodeagua (){
        
        System.out.println("BIENVENIDOS, SOMOS LA EMPRESA DE AGUA POTABLE DE LOJA");
        System.out.println(" ");
        System.out.println("Ingrese el valo de litros de agua consumidos en el mes");
        System.out.print("Consumo: "); int agua_consumo = sc.nextInt();
        double tarifa_anterior_sindesc, tarifa_rubro, tarifa_anterior;
        double pagar_aguapotable = 0.0;
        int consumo_anterior, consumo_nuevo, opcion_desc_edad_disc;
        double desc_edad_disc = 0.0;

        System.out.println(" ");
        System.out.println("--------------------------------------------");
        System.out.println("Tiene alguna condicion especial: ");
        System.out.println("");
        System.out.println("1. Persona Normal");
        System.out.println("2. Persona de la Tercera Edad");
        System.out.println("3. Persona con dicapacidad");
        System.out.println("");
        System.out.print("OPCION: "); opcion_desc_edad_disc = sc.nextInt(); sc.nextLine();
        System.out.println("--------------------------------------------");


        // funcion para calcular el descuento especial para  personas de tercera edad o discapacidad.
        desc_edad_disc = descuentoEspecial(opcion_desc_edad_disc, agua_consumo);        

        double descuento = 0.0;
        
        if (agua_consumo <= 15){
            descuento = 3.00 * (desc_edad_disc/100) ;
            pagar_aguapotable = 3.00 - descuento; 
        } else if (agua_consumo > 15 && agua_consumo <= 25) {
            tarifa_rubro = 0.10; 
            tarifa_anterior_sindesc = 3.00;
            descuento = tarifa_anterior_sindesc * (desc_edad_disc / 100);
            tarifa_anterior = tarifa_anterior_sindesc - descuento;
            consumo_anterior = 15;
            consumo_nuevo = agua_consumo - consumo_anterior;
            pagar_aguapotable = tarifa_anterior + (consumo_nuevo * tarifa_rubro);
        } else if (agua_consumo > 25 && agua_consumo <= 40) {
            tarifa_rubro = 0.20; 
            tarifa_anterior_sindesc = 4.00;
            descuento = tarifa_anterior_sindesc * (desc_edad_disc / 100);
            tarifa_anterior = tarifa_anterior_sindesc - descuento;
            consumo_anterior = 25;
            consumo_nuevo = agua_consumo - consumo_anterior;
            pagar_aguapotable = tarifa_anterior + (consumo_nuevo * tarifa_rubro);

        } else if (agua_consumo > 40 && agua_consumo <= 60) {
            tarifa_rubro = 0.30; 
            tarifa_anterior_sindesc = 7.00;
            descuento = tarifa_anterior_sindesc * (desc_edad_disc / 100);
            tarifa_anterior = tarifa_anterior_sindesc - descuento;
            consumo_anterior = 40;
            consumo_nuevo = agua_consumo - consumo_anterior;
            pagar_aguapotable = tarifa_anterior + (consumo_nuevo * tarifa_rubro);

        } else if (agua_consumo > 60) {
            tarifa_rubro = 0.35; 
            tarifa_anterior_sindesc = 13.00;
            descuento = tarifa_anterior_sindesc * (desc_edad_disc / 100);
            tarifa_anterior = tarifa_anterior_sindesc - descuento;
            consumo_anterior = 60;
            consumo_nuevo = agua_consumo - consumo_anterior;
            pagar_aguapotable = tarifa_anterior + (consumo_nuevo * tarifa_rubro);

        }
       
        double tasa_alcantarillado = pagar_aguapotable * 0.35;
      
        double tasa_recoleccion = 0.50;
     
        double tasa_tramite = 0.75;

        //funcion para imprimir la planilla a pagar
        
        planillaPagar(pagar_aguapotable, tasa_alcantarillado, tasa_recoleccion, tasa_tramite, descuento, desc_edad_disc);
        
        
        
    }

    
}
