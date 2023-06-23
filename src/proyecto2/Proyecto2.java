/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<InformacionPersonal> personas = new ArrayList();
        Scanner entrada = new Scanner(System.in);

        int exit = 1;
        while (exit == 1) {
            System.out.println("----MENU----");
            System.out.println("1.Juego(Buscar Tesoro)");
            System.out.println("2.Listar Jugadores");
            System.out.println("3.Salir");
            int sele = entrada.nextInt();

            switch (sele) {
                case 1: {

                    System.out.println("Ingrese el nombre: ");
                    String name = entrada.next();
                    System.out.println("Igrese la edad: ");
                    int age = entrada.nextInt();

                    InformacionPersonal datos = new InformacionPersonal(name, age);
                    System.out.println("Bienvenido: " + datos.nombre);
                    datos.Verificar(age);
                    personas.add(datos);

                    boolean opt = datos.ter;
                    while (opt == true) {
                        int cont = 1;
                        System.out.println("______");
                        System.out.println(" B U S C A N D O   E L   T E S O R O");
                        System.out.println("______");

                        System.out.println("Inicia el juego........");
                        int filas = 7, filaus;
                        int columnas = 7, colus;
                        boolean bandera = true;

                        String[][] tab = tablero(filas, columnas);
                        while (cont <= 5) {
                            System.out.println("Intento " + cont);
                            for (int i = 0; i < columnas; i++) {
                                System.out.print("  " + i);
                            }
                            System.out.println(" ");

                            //imprime la matriz
                            for (int i = 0; i < filas; i++) {
                                System.out.print(i);
                                for (int j = 0; j < columnas; j++) {
                                    if (tab[i][j] != "$") {
                                        System.out.print("[" + tab[i][j] + "]");
                                    } else {
                                        System.out.print("[ ]");
                                    }
                                }
                                System.out.println();
                            }

                            System.out.println("Ingrese la fila: ");
                            filaus = entrada.nextInt();
                            System.out.println("Ingrese la columnas: ");
                            colus = entrada.nextInt();
                            if (filaus > 7) {
                                System.out.println("Error fuera del rango");
                            } else if (colus > 7) {
                                System.out.println("Error fuera del rango");
                            } else if (filaus < 0) {
                                System.out.println("Error fuera del rango");
                            } else if (colus < 0) {
                                System.out.println("Error fuera del rango");
                            }

                            while (filaus > 7 || colus > 7 || filaus < 0 || colus < 0);
                            if (tab[filaus][colus] == "$") {
                                System.out.println("Felicidades " + name + " encontraste el tesoro ($)");
                                cont += 6;
                                bandera = false;
                            } else if (tab[filaus][colus] == "X") {
                                System.out.println("Ya eligio esta posicion, repita");
                            } else {
                                System.out.println("Siga intentando ");
                            }
                            tab[filaus][colus] = "X";

                            cont++;

                        }
                        opt = false;
                    }
                    System.out.println("Volviendo al menu......");

                    break;

                }
                case 2: {

                    System.out.println("Lista de personas: ");

                    mostrarArrayRecursivo(personas, 0);
                    System.out.println("Volviendo al menu....");
                    break;
                }
                case 3: {
                    exit++;
                    System.out.println("Gracias por jugar");
                    System.out.println("Saliendo...");
                    break;

                }
            }

        }

    }

    public static String[][] tablero(int filas, int columnas) {
        String[][] matriz = new String[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = " ";
            }
        }
        matriz = tesoro(matriz);
        return matriz;
    }

    public static String[][] tesoro(String[][] escoteso) {
        for (int i = 0; i < 1; i++) {
            Random tesoro = new Random();
            int pos_i;
            int pos_j;
            do {
                int max = escoteso.length - 1;
                pos_i = tesoro.nextInt(max);
                pos_j = tesoro.nextInt(max);

            } while (escoteso[pos_i][pos_j].equals("$"));
            escoteso[pos_i][pos_j] = "$";
        }
        return escoteso;
    }

    public static void mostrarArrayRecursivo(ArrayList<InformacionPersonal> personas, int indice) {
        if (indice == personas.size() - 1) {
            System.out.println(personas.get(indice));
        } else {
            System.out.println(personas.get(indice));
            mostrarArrayRecursivo(personas, indice + 1);
        }
    }
}
