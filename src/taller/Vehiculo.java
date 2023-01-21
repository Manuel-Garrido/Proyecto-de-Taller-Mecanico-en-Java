/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.util.Scanner;

/**
 *
 * @author Manu
 */
//Método Vehiculo que hereda de una clase abstracta llamada Mecanico.
public class Vehiculo extends Mecanico {

    //Variables globales para cada vehículo.
    private String matricula;
    private String modelo;
    private String marca;
    private int caballos;
    
    
    //Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCaballos() {
        return caballos;
    }

    public void setCaballos(int caballos) {
        this.caballos = caballos;
    }
    
    //Constructor que inicializa las variables globales.
    public Vehiculo() {
        matricula = "";
        modelo = "";
        marca = "";
        caballos = 0;
    }

    //Método del la clase abstracta Mecanico que nos permite elegir un mecánico que se encargue de nuestro vehículo.
    @Override
    public String elegirMecanico() {
        //Variables locales del método.
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        String nombre = "";
        //Bucle que valida que se introduzca una opción válida.
        do {
            //Se le debe introducir un valor entero que devolverá el mecánico elegido para el trabajo.
            System.out.println("¿Qué mecánico desea elegir?");
            System.out.println("1.Juan\n2.Roberto\n3.Mario");
            opcion = sc.nextInt();
            //Switch que permite devolver un nombre de mecánico en base a la opción elegida.
            switch (opcion) {
                case 1:
                    nombre = "Juan";
                    break;
                case 2:
                    nombre = "Roberto";
                    break;
                case 3:
                    nombre = "Mario";
                    break;
                default:
                    System.err.println("Has introducido un mecánico que no está disponible o no existe...");
            }
        } while (opcion < 1 || opcion > 3);
        //Devuelve el nombre del mecánico.
        return nombre;
    }
}
