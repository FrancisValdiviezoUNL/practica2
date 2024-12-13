package controller.ejercicios;

/*Pseudocodigo

 * Iniciar
 * 
 * contador = 1
 * Veces a repetir = 10
 * Mientras contador sea menor que (las veces que repita), Entonces:
 * 
 * presentar (El contador es: + (variable) contador)
 * 
 * Fin del programa
*/

public class EjerciciosEnsayo {
    public void cont_Miemtras (){
        int cont = 1; //Declarado el contador
        int veces_repetir = 10; //La condicion que quiero que cumpla

        while (cont <= veces_repetir) {
            System.out.println("El Contador es: " + cont); //Para que imprima las veces del contador
        }
    }



/*Pseudocodigo

   Iniciar
  
   contador = 1
   bandera = verdadero (true)
  
   Hacer {
        presentar (El Contador es: + contador)
        contador = contador + contador

        Si contador > 5 
            bandera = falso (false)

   } Mientres bandera sea verdadero

   
   Fin del programa
*/


    public void cont_Miemtras1 (){
        int cont = 1; //Declarado el contador
        boolean bandera = true; // bandera que sea verdadera
        do {
            System.out.println("El contador es: " + cont);
            cont++;

            if (cont >= 5){
                bandera = false;
            }
        } while (bandera);
    }


    public int numeroselevar(int numero, int multipicador) {
        int num_multiplicar = 0;

        num_multiplicar = numero * multipicador;

        return num_multiplicar;
    }


    public void pasodevalores(){
        int numero = 3;
        int multipicador = 5;

        System.out.println("EL numero es: " + numero + " y el multiplicador: " + multipicador );

        int resultado = numeroselevar(numero, multipicador);

        System.out.println("El resultado es: " +resultado);


    }

    //*Ejercicio ensayo 8 */
    public void funcionparametro(){

         Persona persona = new Persona(25);
         System.out.println("Edad original: " + persona.edad);

         incrementarEdad(persona);
 
         System.out.println("Edad después de incrementar: " + persona.edad);
    }
    public static void incrementarEdad(Persona persona) {
        persona.incrementarEdad();
    }

    
}
class Persona {
    int edad;

    Persona(int edad) { //es un constructor
        this.edad = edad;
    }

    public void incrementarEdad() {
        this.edad++;
    }
}





