/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

/**
 *
 * @authors Hugo, Pedro, Pablo y Manu
 */
public class Taller {
    //Método Main para iniciar el programa con InterruptedException por el uso de sleep en un método.
    public static void main(String[] args) throws InterruptedException{
        Datos p = new Datos();
        p.validarVehiculo();
        p.calcularPrecio();
        p.mostrarMecanico();
        p.mostrarResultado();
    }
}
