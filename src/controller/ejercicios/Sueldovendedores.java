package controller.ejercicios;



import java.text.DecimalFormat;
import java.util.Scanner;

import controller.util.Utilidades;

public class Sueldovendedores {
    private Scanner sc = new Scanner(System.in);
    DecimalFormat formato_decimal = new DecimalFormat("#.00");
    public void sueldoEmpleados (){
        
        int vehiculos_vendidos = 0;
        int vehiculos_vendidos_concomision = 0;
        String ingresar_valor_vehiculos = "";
        double valor_vehiculos = 0.0;
        double comision_venta_valor = 0.0, comision_venta_valor_total = 0.0, sueldo_inicial = 2500.00;
        double sueldo_total = 0.0;
        double ventas_total = 0.0;
        double comision_ventastotal_porcentaje = 5.0;
        double comision_ventatotal_total = 0.0;
        boolean ingresar_vehiculos = true;
        int agregar_tarea = 0;
        
        System.out.println("--------------SUELDO DE VENDEDORES DE VEHICULOS---------------");
  

        while (ingresar_vehiculos){

            System.out.println(" ");
            System.out.println("¿Deseas ingresar la venta de un vehiculo? ");
            System.out.println("1. Si");
            System.out.println("2. No");
            System.out.print("Menu: ");
            agregar_tarea = sc.nextInt();
            sc.nextLine();
            System.out.println(" ");


            if (agregar_tarea == 1){

                vehiculos_vendidos++;
                

                System.out.println("-----------------------------------------------------");
    
                System.out.println("Valor del vehiculo " + vehiculos_vendidos + ": ");
                ingresar_valor_vehiculos = sc.nextLine(); 

                valor_vehiculos = Utilidades.transformStringDouble(ingresar_valor_vehiculos);

                if (valor_vehiculos > 10000) {
                    comision_venta_valor = 250;
                    vehiculos_vendidos_concomision++;
                } else if (valor_vehiculos <= 10000) {
                    comision_venta_valor = 0.0;
                }
                    
                ventas_total += valor_vehiculos;

                comision_ventatotal_total = ventas_total * (comision_ventastotal_porcentaje / 100);

                comision_venta_valor_total += comision_venta_valor;

                sueldo_total = sueldo_inicial + comision_ventatotal_total + comision_venta_valor_total;
        
                System.out.println("-----------------------------------------------------");
            } else if (agregar_tarea != 1) {
                ingresar_vehiculos = false;
            }


            
    
            
        }
        if (!ingresar_vehiculos) {
            System.out.println("--------------Informe de ventas--------------");
            System.out.println("Vehiculos vendidos:                       " +  vehiculos_vendidos );
            System.out.println("Vehiculos vendidos con comision:          " +  vehiculos_vendidos_concomision );
            System.out.println("Comision de ventas por vehiculo:  " + " $ " +  formato_decimal.format(comision_venta_valor_total) );
            System.out.println("Comision por ventas totales:      " + " $ " +  formato_decimal.format(comision_ventatotal_total) );
            System.out.println("Sueldo del empleado:              " + " $ " +  formato_decimal.format(sueldo_total) );
            System.out.println("----------------------------------------------");
        }
        

        
    }
}
