/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.io.File;
import static java.lang.Thread.sleep;
import java.text.DecimalFormat;
import java.util.*;

/**
 *
 * @authors Hugo, Pedro, Pablo y Manu
 */
//Implementa una interfaz predefinida de Java.
public class Datos implements Comparator {

    //Variables globales privadas.
    private int opcion;
    private Coche c;
    private Moto m;
    private String nombre;
    private double presupuesto;
    private final double tarifaTrabajo = 12.50;

    //Método constructor que inicializa las variables globales.
    public Datos() {
        opcion = 0;
        c = new Coche();
        m = new Moto();
        nombre = "";
        presupuesto = 0.0 + tarifaTrabajo;
    }

    //Método privado que no devuelve nada y nos permite elegir nuestro vehículo a reparar en base a si es una moto o coche.
    private void elegirVehiculo() {
        Scanner decirVehiculo = new Scanner(System.in);
        System.out.println("Bienvenido al taller de reparaciones:");
        //Bucle que comprueba que solo introduzcas una opción correcta entre 1 y 2.
        do {
            System.out.println("Dinos, ¿cúal es tu vehículo?\n1.Coche\n2.Moto\n3.Ambos");
            opcion = decirVehiculo.nextInt();
            /*Switch que devuelve un método propio de moto o coche para iniciar los datos codificado en cada clase.
                1-Solo ingresa los datos del coche.
                2-Solo ingresa los datos de la moto.
                3-Ingresa los datos de ambos y llama al método validarComparacion() para ver si ambas matriculas son iguales./*
             */
            switch (opcion) {
                case 1:
                    c.ingresarDatos();
                    break;
                case 2:
                    m.ingresarDatos();
                    break;
                case 3:
                    c.ingresarDatos();
                    System.out.println("........................");
                    m.ingresarDatos();
                    validarComparacion();
                    break;
                default:
                    System.err.println("El vehículo introducido no está disponible o no existe...");
            }
        } while (opcion <= 0 || opcion > 3);

    }

    //Método privado que no devuelve nada que muestra tu vehículo en base a los datos insertados y la opción elegida ya almacenada.
    private void mostrarVehiculo() {
        //Condición if que comprueba si introduciste la opción 1 o 2 para mostrar coche o moto o 3 para mostrar ambos.
        if (opcion == 1) {
            c.mostrar();
        } else if (opcion == 2) {
            m.mostrar();
        } else if (opcion == 3) {
            System.out.println("Su coche:");
            c.mostrar();
            System.out.println("Su moto:");
            m.mostrar();
        }
    }

    /*
    Método público que no devuelve nada y comprueba si los datos introducidos son correctos.
        -Si es correcto, terminará el bucle.
        -No es correcto, volverá a pedir desde el principio los datos del vehículo.
     */
    public void validarVehiculo() {
        Scanner sc = new Scanner(System.in);
        String validar = "";
        //Bucle do while que comprueba que se introduzca un SI o NO para salir o no del bucle.
        do {
            elegirVehiculo();
            mostrarVehiculo();
            System.out.println("¿Los datos son correctos? SI/NO");
            validar = sc.nextLine();
        } while (validar.equalsIgnoreCase("NO"));
    }

    /*
    Método público que no devuelve nada y en base a si has elegido coche o moto guarda en variable global nombre:
        -Si es la primera opción el mecánico elegido será para coche.
        -Si es la segunda opción el mecánico elegido será para moto.
     */
    public void mostrarMecanico() {
        if (nombre.length() == 0) {
            if (opcion == 1) {
                nombre = c.elegirMecanico();
            } else {
                nombre = m.elegirMecanico();
            }
        }

    }

    /*
    Método público que no devuelve nada y solo añade a la variable presupuesto el valor.
        -Si has elegido coche le ingresará al presupuesto el valor double devuelto del método precioTotal.
        -Si has elegido moto le ingresará al presupuesto el valor double devuelto del método precioTotal.
        -Si has elegido ambos cálcula el precio de ambos, tanto coche como moto y lo suma a la variable presupuesto.
     */
    public void calcularPrecio() {
        //Condición if que muestra la opción a elegir
        if (opcion == 1) {
            presupuesto += c.precioTotal();
        } else if (opcion == 2) {
            presupuesto += m.precioTotal();
        } else if (opcion == 3) {
            presupuesto += c.precioTotal();
            presupuesto += m.precioTotal();
        }
    }

    /*
    Método público que no devuelve nada y solo muestra los datos de las reparaciones elegidas.
        -Si has elegido coche mostrará en la factura final las reparaciones elegidas.
        -Si has elegido moto mostrará en la factura final las reparaciones elegidas.
        -Si has elegido ambos muestra las reparaciones por separado para ambos vehículos.
     */
    public void mostrarReparacion() {
        //Condición if que muestra la opción a elegir
        if (opcion == 1) {
            c.mostrarReparaciones();
        } else if (opcion == 2) {
            m.mostrarReparaciones();
        } else if (opcion == 3) {
            System.out.println("-----------------------");
            System.out.println("Para coche:");
            c.mostrarReparaciones();
            System.out.println("Para moto:");
            m.mostrarReparaciones();
        }
    }

    //Método que cálcula el IVA del presupuesto total
    public double calcularIva() {
        final double IVA = 21;
        double precioFactura = presupuesto * IVA / 100;
        return presupuesto + precioFactura;
    }

    //Método público que muestra el resultado como forma de factura y con esperar de 1 a 2 segundos para tornar una experiencia más realista.
    public void mostrarResultado() throws InterruptedException {
        //Objeto que sirve para transformar los formatos decimales a 2 decimas.
        DecimalFormat df = new DecimalFormat("#.00");
        if (presupuesto > 12.50) {
            System.out.println("Efectuando reparaciones...");
            sleep(3000);
            System.out.println("Reparando...");
            sleep(1000);
            System.out.println("Efectuando cambios en o los vehículos...");
            sleep(1000);
            System.out.println("Reparaciones y cambios efectuados con exito...");
            sleep(2000);
            System.out.println("Imprimiendo el recibo de la factura...");
            sleep(2000);
        }
        System.out.println("-----------------------");
        System.out.println("-----FACTURA TOTAL-----");
        mostrarVehiculo();
        System.out.println("Lista de reparaciones efectuadas:");
        mostrarReparacion();
        System.out.println("-----------------------");
        System.out.println("Fue realizado por el mecánico: " + nombre);
        System.out.println("-----------------------");
        System.out.println("El precio de tarifa por el mantenimiento y gestión: " + tarifaTrabajo + "€ con IVA incluído");
        System.out.println("Precio sin IVA: " + presupuesto + "€");
        System.out.println("El total de su factura es: " + df.format(calcularIva()) + "€");
        System.out.println("Gracias por su visita");
        System.out.println("-----------------------");
    }

    //Método que devuelve un valor entero comparando 2 objetos, Esté método nacé de una interfaz predefinida arriba.
    @Override
    public int compare(Object o1, Object o2) {
        if (o1.equals(o2)) {
            return 1;
        } else {
            return 0;
        }
    }

    /*Válida si la matrícula de ambos vehículos es igual y si es igual vuelve a pedir los datos de los vehículos introducidos.
    Y eso lo implementa llamando al método de la interfaz predefinida que compara 2 objetos.*/
    public void validarComparacion() {
        int validado;
        do {
            validado = compare(c.getMatricula(), m.getMatricula());
            if (validado == 1) {
                System.err.println("No puede tener la misma matrícula ambos vehículos.");
                c.ingresarDatos();
                m.ingresarDatos();
            }
        } while (validado == 1);
    }
    
}
