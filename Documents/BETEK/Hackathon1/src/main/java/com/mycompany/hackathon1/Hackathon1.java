/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hackathon1;

/**
 *
 * @author pc
 */
public class Hackathon1 {
    // Función sin retorno mediante (void)
    public static void saludar(String nombre, int edad){
        System.out.println("Hola, " + nombre + "! " + "Tienes " + edad + " años.");
    }
    
    // Funcion con retorno (String)
    public static String obtenerSaludo(int hora){
        if (hora >= 0 && hora <= 11){
            return "Buenos Dias";
        }else if (hora >= 12 && hora <= 17){
            return "Buenas Tardes";
        }else if (hora >= 18 && hora <= 23){
            return "Buenas Noches";
        }else{
            return "Hora no valida";
        }
    }
    //Funcion que imprime el saludo completo
    public static void saludarCompleto(String nombre, int edad, int hora){
        String saludo = obtenerSaludo (hora);
        System.out.println(saludo + ", " + nombre + ". Tiene" + edad + " años.");        
    }
     public static void main(String[] args) {
        saludarCompleto("Carlos", 20, 9);
        saludarCompleto("Ana", 25, 15);
        saludarCompleto("Luis", 30, 21);
     }
}
