/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prestamo;

import java.util.Scanner;

public final class Prestamo {
    
    private final double montoSolicitado;
    private final double tasaInteresMensual;
    private final int cantidadCuotas;
    private final double totalInteres;
    private final double totalPagar;
    
    public Prestamo(double montoSolicitado, double tasaInteresMensual, int cantidadCuotas) {
        this.montoSolicitado = montoSolicitado;
        this.tasaInteresMensual = tasaInteresMensual;
        this.cantidadCuotas = cantidadCuotas;
        this.totalInteres = calcularTotalInteres();
        this.totalPagar = calcularTotalPagar();
    }
    
    public double calcularTotalInteres() {
        return montoSolicitado * tasaInteresMensual * cantidadCuotas;
    }
    
    public double calcularTotalPagar() {
        return montoSolicitado + totalInteres;
    }
    
    public void mostrarResumen() {
        System.out.println("\nResumen del préstamo:");
        System.out.println("Monto solicitado: $" + montoSolicitado);
        System.out.println("Tasa de interés mensual a pagar: " + (tasaInteresMensual * 100) + "%");
        System.out.println("Cantidad de cuotas solicitadas: " + cantidadCuotas);
        System.out.println("Total de interés a pagar: $" + totalInteres);
        System.out.println("Total préstamo a pagar: $" + totalPagar);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese por favor el monto de dinero solicitado: ");
            double montoSolicitado = scanner.nextDouble();
            
            System.out.print("Ingrese por favor la cantidad de cuotas a pagar: ");
            int cantidadCuotas = scanner.nextInt();
            
            System.out.println("Digite un número para elegir el tipo de préstamo:");
            System.out.println("1. Personal");
            System.out.println("2. Hipotecario");
            System.out.println("3. Automotriz");
            int tipoPrestamo = scanner.nextInt();
            
            double tasaInteresMensual;
            switch (tipoPrestamo) {
                case 1 -> tasaInteresMensual = 0.03; // Tasa de interés mensual para préstamo personal
                case 2 -> tasaInteresMensual = 0.015; // Tasa de interés mensual para préstamo hipotecario
                case 3 -> tasaInteresMensual = 0.02; // Tasa de interés mensual para préstamo automotriz
                default -> {
                    System.out.println("Tipo de préstamo no válido. Se utilizará la tasa por defecto.");
                    tasaInteresMensual = 0.02; // Tasa de interés mensual por defecto
                }
            }
            
            Prestamo prestamo = new Prestamo(montoSolicitado, tasaInteresMensual, cantidadCuotas);
            prestamo.mostrarResumen();
        }
    }
}