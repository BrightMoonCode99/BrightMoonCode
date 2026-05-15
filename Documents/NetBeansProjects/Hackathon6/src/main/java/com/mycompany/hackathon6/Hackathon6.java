/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hackathon6;

/**
 *
 * @author pc
 */
public class Hackathon6 {

    static String[] historial = new String[50];
    static int contadorHistorial = 0;
    
    // 32. Función potencia usando recursión
    public static int potencia(int base, int exp) {
        if (exp < 0) {
            String operacion = "potencia(" + base + ", " + exp + ")";
            agregarAlHistorial(operacion, "Error: Exponente negativo");
            return -1;
        }
        
        int resultado;
        if (exp == 0) { // Caso base
            resultado = 1;
        } else {
            resultado = base * potencia(base, exp - 1);
        }
        
        String operacion = "potencia(" + base + ", " + exp + ")";
        agregarAlHistorial(operacion, resultado);
        return resultado;
    }
    
    // 33. Función MCD usando algoritmo de Euclides recursivo
    public static int mcd(int a, int b) {
        int resultado;
        if (b == 0) { // Caso base
            resultado = Math.abs(a);
        } else {
            resultado = mcd(b, a % b);
        }
        
        String operacion = "mcd(" + a + ", " + b + ")";
        agregarAlHistorial(operacion, resultado);
        return resultado;
    }
    
    // 34. Función esPrimo
    public static boolean esPrimo(int n) {
        if (n <= 1) {
            String operacion = "esPrimo(" + n + ")";
            agregarAlHistorial(operacion, false);
            return false;
        }
        
        boolean resultado = esPrimoHelper(n, 2);
        String operacion = "esPrimo(" + n + ")";
        agregarAlHistorial(operacion, resultado);
        return resultado;
    }
    
    // Helper recursivo privado para esPrimo
    private static boolean esPrimoHelper(int n, int divisor) {
        if (divisor * divisor > n) { // Caso base: no encontró divisores
            return true;
        }
        if (n % divisor == 0) { // Encontró un divisor
            return false;
        }
        return esPrimoHelper(n, divisor + 1); // Probar siguiente divisor
    }
    
    // 35. Función para generar serie Fibonacci
    public static void generarSerieFibonacci(int n) {
        if (n <= 0) {
            System.out.println("La serie Fibonacci requiere n > 0");
            agregarAlHistorial("generarSerieFibonacci(" + n + ")", "Error: n debe ser positivo");
            return;
        }
        
        System.out.print("Serie Fibonacci (" + n + " términos): ");
        String serie = "";
        for (int i = 0; i < n; i++) {
            int fib = fibonacciRecursivo(i);
            System.out.print(fib);
            serie += fib;
            if (i < n - 1) {
                System.out.print(", ");
                serie += ", ";
            }
        }
        System.out.println();
        
        agregarAlHistorial("generarSerieFibonacci(" + n + ")", "[" + serie + "]");
    }
    
    // Función auxiliar recursiva para Fibonacci
    private static int fibonacciRecursivo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
    }
    
    // 36. Método para agregar al historial
    private static void agregarAlHistorial(String operacion, Object resultado) {
        if (contadorHistorial < historial.length) {
            historial[contadorHistorial] = operacion + " = " + resultado;
            contadorHistorial++;
        } else {
            // Si el historial está lleno, desplazar y agregar al final
            for (int i = 0; i < historial.length - 1; i++) {
                historial[i] = historial[i + 1];
            }
            historial[historial.length - 1] = operacion + " = " + resultado;
            // contadorHistorial se mantiene en 50
        }
    }
    
    // 38. Método para mostrar el historial
    public static void mostrarHistorial() {
        System.out.println("\n=== HISTORIAL DE OPERACIONES ===");
        if (contadorHistorial == 0) {
            System.out.println("No hay operaciones registradas.");
        } else {
            for (int i = 0; i < contadorHistorial; i++) {
                System.out.println((i + 1) + ". " + historial[i]);
            }
        }
        System.out.println("================================\n");
    }
    
    // Método main para probar todas las funciones
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DE FUNCIONES RECURSIVAS ===\n");
        
        // Probar potencia
        System.out.println("potencia(2, 10) = " + potencia(2, 10));
        System.out.println("potencia(3, 4) = " + potencia(3, 4));
        System.out.println("potencia(5, 0) = " + potencia(5, 0));
        
        // Probar MCD
        System.out.println("\nmcd(48, 18) = " + mcd(48, 18));
        System.out.println("mcd(100, 25) = " + mcd(100, 25));
        System.out.println("mcd(17, 13) = " + mcd(17, 13));
        
        // Probar esPrimo
        System.out.println("\nesPrimo(7) = " + esPrimo(7));
        System.out.println("esPrimo(10) = " + esPrimo(10));
        System.out.println("esPrimo(17) = " + esPrimo(17));
        System.out.println("esPrimo(1) = " + esPrimo(1));
        
        // Probar Fibonacci
        System.out.println();
        generarSerieFibonacci(10);
        generarSerieFibonacci(5);
        
        // Mostrar historial completo
        mostrarHistorial();
        
        // Probar más operaciones para demostrar el historial
        System.out.println("=== MÁS OPERACIONES ===");
        System.out.println("potencia(4, 3) = " + potencia(4, 3));
        System.out.println("mcd(144, 60) = " + mcd(144, 60));
        System.out.println("esPrimo(97) = " + esPrimo(97));
        generarSerieFibonacci(8);
        
        // Mostrar historial actualizado
        mostrarHistorial();
    }
}
