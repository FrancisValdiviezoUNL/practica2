package views;


import java.util.Scanner;

import controller.ejercicios.Consumodeagua;
import controller.ejercicios.Secuencia;
import controller.ejercicios.Sueldovendedores;
import controller.ejercicios.Tarifatelefono;


public class App {
    Scanner sc = new Scanner(System.in);
    boolean menu_bucle = true;

    public void regresarMenu (){

        System.out.println(" ");
        System.out.println("¿Desea volver al menu?");
        System.out.println("1. SI");
        System.out.println("2. NO");
        System.out.print("Ingrese su respuesta: ");
        int reg_menu = sc.nextInt();
        if (reg_menu == 1) {
            System.out.println("Regresando al menu");
            System.out.println(" ");
        } else if (reg_menu == 2){
            System.out.println("Saliendo del programa ........");
            menu_bucle = false;
        } 

    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        Scanner sc = app.sc;

        while (app.menu_bucle) {
            System.out.println("------------------BIENVENIDOS----------------------");
            System.out.println(" ");
            System.out.println("--------------SELECCIONA UN OPCIÓN-----------------");
            System.out.println("1. SUELDO DE VENDEDORES DE VEHICULOS");
            System.out.println("2. TARIFA DE LLAMADA");
            System.out.println("3. COBRO DE AGUA");
            System.out.println("4. SECUENCIA");
            System.out.println("5. SALIR");
            System.out.println("---------------------------------------------------");
            System.out.print("Menu: ");
            int menu = sc.nextInt();
            System.out.println(" ");

            switch (menu) {
                case 1:
                    Sueldovendedores sv = new Sueldovendedores();
                    sv.sueldoEmpleados();
                    app.regresarMenu(); // clase para retornar al menu
                    
                    break;
                case 2:
                    Tarifatelefono tt = new Tarifatelefono();  
                    tt.tarifaTelefono();
                    app.regresarMenu(); // clase para retornar al menu

                    break;
                case 3:
                    Consumodeagua ca = new Consumodeagua();
                    ca.consumodeagua();
                    app.regresarMenu(); // clase para retornar al menu

                    break;
                case 4:
                    Secuencia sec = new Secuencia();
                    sec.secuenciagenerar();
                    app.regresarMenu(); // clase para retornar al menu

                    break;
                case 5:

                    System.out.println(" ");
                    System.out.println("Gracias por ocupar nuestro sistema, esperamos volverle a ver pronto");
                    System.out.println(" ");
                    app.menu_bucle = false; 
                    break;
            
                default:
                    System.out.println("Porfavor, sea muy amable de ingresar una opción valida del menu");
                    
                    break;
            }
        }
        
    }
}
