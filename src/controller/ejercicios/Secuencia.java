package controller.ejercicios;

import java.text.DecimalFormat;
import java.util.Scanner;



public class Secuencia {
    private Scanner sc = new Scanner(System.in);

    DecimalFormat formatodeciamal = new DecimalFormat("#.00");    
    
    private int generar_impar(int numero) {
        return 2 * numero - 1; 
    }

    
    private int generar_numerador(int numero) {
        if (numero <= 1) {
            return 1; 
        }

        int term1 = 1;   ///termonos finobacci
        int term2 = 1; 
        int numerador = 0;

        for (int i = 2; i <= numero; i++) {
            numerador = term1 + term2;
            term1 = term2;
            term2 = numerador;
        }

        return numerador;
    }


    public void secuenciagenerar() {
        int generar = 0;
        System.out.print("Ingrese cuántos términos desea generar: ");
        generar = sc.nextInt();

        if (generar > 0) {
            float suma = 0.0f;
            String serie = "S = ";

            int contador_signo = 0;

            for (int i = 1; i <= generar; i++) {
                int numerador = generar_numerador(i);
                int denominador = generar_impar(i + 1); 
                int potencia = 2 * i; 

     
                if (contador_signo < 2) {
                    serie += "(" + numerador + "/" + denominador + ")^" + potencia + " + ";
                    suma += Math.pow(((float) numerador) / ((float) denominador), potencia);
                    contador_signo++;
                } else {
                    serie += "(" + numerador + "/" + denominador + ")^" + potencia + " - ";
                    suma -= Math.pow(((float) numerador) / ((float) denominador), potencia);
                    contador_signo++;
                }

    
                if (contador_signo == 4) {
                    contador_signo = 0;
                }
            }

            System.out.print(serie.trim());
            System.out.println(" ");
            System.out.println("Resultado de la secuencia: " + formatodeciamal.format(suma));
        } else {
            System.out.println("Ingrese un número mayor a 0");
        }
    }
}