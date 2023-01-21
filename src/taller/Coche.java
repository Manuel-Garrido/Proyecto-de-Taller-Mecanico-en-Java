/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.util.*;

/**
 *
 * @authors Manu
 */
//Clase Coche que hereda de la clase Vehiculo e implementa la interfaz Reparaciones.
public class Coche extends Vehiculo implements Reparaciones {
    private String[] elementos;
    private double precio;

    //Método que permite ingresar tus datos del coche.
    public void ingresarDatos() {
        Scanner ingreso = new Scanner(System.in);
        System.out.print("Ingrese la matricula de su coche: ");
        setMatricula(ingreso.nextLine());

        System.out.print("Ingrese la marca del coche: ");
        setMarca(ingreso.nextLine());

        System.out.print("Ingrese el modelo del coche: ");
        setModelo(ingreso.nextLine());

        System.out.print("Ingrese los caballos del coche: ");
        setCaballos(ingreso.nextInt());
    }

    //Método mostrar que muestra los datos del coche.
    public void mostrar() {
        System.out.println("--------------------------------");
        System.out.println("Su coche con la matricula: " + getMatricula() + " tiene los siguientes datos:");
        System.out.println("Su coche es de la marca: " + getMarca());
        System.out.println("Su modelo es: " + getModelo());
        System.out.println("Sus caballos son: " + getCaballos() + "cc");
        System.out.println("--------------------------------");
    }

    //Interfaz implementada con su método reparaciones que te permite elegir la opción que desea hasta 4 elementos.
    /*
        -Usa un vector para almacenar cada elemento introducido.
        -Usa un contador para tener en cuenta cuantos elementos han sido insertados y como posición para el vector.
        -Uso de un String validar que permite indicar si continuar introducciendo valores o no.
    */
    @Override
    public void reparaciones() {
        elementos = new String[4];
        Scanner pedirOpcion = new Scanner(System.in);
        Scanner pedirValidar = new Scanner(System.in);
        int cont = 0, opcion = 0;
        String validar = "";
        //Bucle do-while que permite insertar los elementos de reparaciones.
        do {
            System.out.println("Indique las reparaciones o cambios para su coche:(Max: 4)");
            System.out.println("1.Motor 800€");
            System.out.println("2.Chasis 250€");
            System.out.println("3.Puertas 125€");
            System.out.println("4.Asientos 80€");
            System.out.println("5.Claxón de coche 22,95€");
            System.out.println("6.Ninguna");
            opcion = pedirOpcion.nextInt();
            //Switch que comprueba si en base al valor pedido es válido y si es válido, incrementa el contador y guarda el precio.
            switch (opcion) {
                case 1:
                    precio += 800 ;
                    elementos[cont] = "Motor 800€";
                    cont++;
                    break;
                case 2:
                    precio += 250;
                    elementos[cont] = "Chasis 250€";
                    cont++;
                    break;
                case 3:
                    precio += 125;
                    elementos[cont] = "Puertas 125€";
                    cont++;
                    break;
                case 4:
                    precio += 80;
                    elementos[cont] = "Asientos 80€";
                    cont++;
                    break;
                case 5:
                    precio += 22.95;
                    elementos[cont] = "Claxón 22,95€";
                    cont++;
                    break;
                case 6:
                    break;
                default:
                    System.err.println("No has elegido ningún elemento válido.");
            }
            if(opcion==6){
                break;
            }
            System.out.println("Lleva: " + (cont) + " elementos comprados y un total de: " + precio + "€");
            System.out.println("¿Desea implementar más reparaciones? (SI/NO)");
            validar = pedirValidar.nextLine();
            
            //Condición que comprueba si contador es igual a 4 y si validar es SI.
            if (cont == 4 && validar.equalsIgnoreCase("SI")) {
                System.err.println("Has alcanzado el máximo de elementos para añadir en su lista en este vehículo.");
            }

        } while (validar.equalsIgnoreCase("SI") && cont < 4);
    }
    
    //Método que devuelve un double e inicializa reparaciones para devolver el precio.
    @Override
    public double precioTotal() {
        reparaciones();
        return precio;
    }

    //Método void que muestra el vector con un bucle for.
    @Override
    public void mostrarReparaciones() {
        String[] mostrar = {"1.", "2.", "3.", "4."};
        for (int i = 0; i < mostrar.length; i++) {
            if(elementos[i]==null){
                System.out.println(mostrar[i]+"No comprado.");
            }else{
            System.out.println(mostrar[i] + elementos[i]);
            }
        }
    }
}
