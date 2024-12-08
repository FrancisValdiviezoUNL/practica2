package controller.util;

import java.util.Random;

public class Utilidades {

// boolean 
//Boolean envuelve a boolean es la clases
    public static boolean validar (String num){
        boolean band = true; 
        if (num.charAt(0) == '-'){
            num = num.substring(1);
        }

        int cont_p = 0;

        for (int i = 0; i < num.length(); i++){
            if (!Character.isDigit(num.charAt(i)) && num.charAt(i) != '.' ) {
                band = false; 
                break;
            } else if (num.charAt(i) == '.')
                cont_p++;
        } 
        if (cont_p >= 2){
            band = false; 
        }
        return band;
    } 
    public static int transformStringInt (String num) {
        int resp = 0;
        if (Utilidades.validar(num)) {
            resp  = (int) Utilidades.transformStringFloat(num);
        }
        return resp;
    }

    public static double transformStringDouble (String num) {
        double resp = 0;
        if (Utilidades.validar(num)) {
            resp  = Double.parseDouble(num);
        }
        return resp;
    }

    public static float transformStringFloat (String num) {
        float resp = 0;
        if (Utilidades.validar(num)) {
            resp  = Float.parseFloat(num);
        }
        return resp;
    }

    public static int generarNumeroRango (int minimo, int maximo){
       Random randown = new Random();
       return minimo + randown.nextInt((maximo + 1) - minimo);
 
    }

    public static float generarNumeroRangoFloat (float minimo, float maximo){
        Random randown = new Random();
        return minimo + randown.nextFloat((maximo + 1) - minimo);
  
     }
     public static float redondear (float num){
        float aux = num * 100.00f;
        float aux1 = (float) ((int)aux);
        return (aux1/100.00f);
     }
     public static String validadorEspacios (String txt){
        String txt_validado= "";


        for (int i = 0; i < txt.length(); i++){
            char txt_posicion = txt.charAt(i); 

            if (txt_posicion != ' '){
                txt_validado += txt_posicion;
            }
        }

        return txt_validado;
    }
}
