/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hackathon2;

/**
 *
 * @author pc
 */
public class Hackathon2 {
    //Uso de OVERLOADTING con misma fución pero distinto parametro
// Función auxiliar para intercambiar dos posiciones
    public static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // Búsqueda lineal
    public static int busquedaLineal(int[] arr, int objetivo) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }
    
    // Búsqueda binaria (requiere array ordenado)
    public static int busquedaBinaria(int[] arr, int objetivo) {
        int inicio = 0;
        int fin = arr.length - 1;
        
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            
            if (arr[medio] == objetivo) {
                return medio;
            } else if (arr[medio] < objetivo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }
    
    // Ordenamiento por burbuja
    public static void ordenamientoBurbuja(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    intercambiar(arr, j, j + 1);
                }
            }
        }
    }
    
    // Ordenamiento por selección
    public static void ordenamientoSeleccion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                intercambiar(arr, i, minIndex);
            }
        }
    }
    
    // Ordenamiento por inserción
    public static void ordenamientoInsercion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int clave = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > clave) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = clave;
        }
    }
    
    // Mostrar array con formato
    public static void mostrarArray(int[] arr, String etiqueta) {
        System.out.print(etiqueta + ": [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    // Método principal para pruebas
    public static void main(String[] args) {
        // Crear array desordenado
        int[] numeros = {64, 34, 25, 12, 22, 11, 90, 5, 77, 33};
        
        // Mostrar array original
        mostrarArray(numeros, "Array original");
        
        // Ordenar usando burbuja (puedes cambiar por selección o inserción)
        ordenamientoBurbuja(numeros);
        
        // Mostrar array ordenado
        mostrarArray(numeros, "Array ordenado");
        
        // Buscar un elemento
        int objetivo = 25;
        
        // Búsqueda lineal (funciona con array ordenado o desordenado)
        int resultadoLineal = busquedaLineal(numeros, objetivo);
        if (resultadoLineal != -1) {
            System.out.println("Búsqueda lineal: " + objetivo + " encontrado en índice " + resultadoLineal);
        } else {
            System.out.println("Búsqueda lineal: " + objetivo + " no encontrado");
        }
        
        // Búsqueda binaria (requiere array ordenado)
        int resultadoBinario = busquedaBinaria(numeros, objetivo);
        if (resultadoBinario != -1) {
            System.out.println("Búsqueda binaria: " + objetivo + " encontrado en índice " + resultadoBinario);
        } else {
            System.out.println("Búsqueda binaria: " + objetivo + " no encontrado");
        }
        
        // Probar búsqueda con elemento inexistente
        int objetivoInexistente = 100;
        resultadoLineal = busquedaLineal(numeros, objetivoInexistente);
        if (resultadoLineal != -1) {
            System.out.println("Búsqueda lineal: " + objetivoInexistente + " encontrado en índice " + resultadoLineal);
        } else {
            System.out.println("Búsqueda lineal: " + objetivoInexistente + " no encontrado");
        }
    }
}