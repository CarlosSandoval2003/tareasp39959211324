/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Totito;

import java.util.Scanner;

/**
 *
 * @author visitante
 */
public class Totito {

    /**
     * @param args the command line arguments
     */
    static Scanner teclado = new Scanner(System.in);
 
    public static void main(String[] args) {
        jugar();
    }
 
    /**
     * Metodo donde empezaremos a jugar
     */
    public static void jugar() {

        //Reprentaciones de los jugadores y del simbolo vacio
        char jugadorUno = 'X';
        char jugadorDos = 'O';
        char enBlanco = '-';
 
        //turno actual
        //true = J1, false = J2
        boolean turno = true;
 
        //tablero donde vamos a jugar
        char mapa[][] = new char[3][3];
 
        //rellenamos la matriz con los guiones
        llenarMatriz(mapa, enBlanco);
 
        int fila, columna;
        boolean posValida, correcto;
 
        //No salimos hasta que uno gane o no haya mas posibilidades
        while (!finJuego(mapa, enBlanco)) {
 
            do {
 
                //mostramos el jugador al que le toca
                turnoActual(turno);
 
                //muestro el tablero
                mostrarMapa(mapa);
 
                correcto = false;
                fila = pedirInteger("Dame la fila");
                columna = pedirInteger("Dame la columna");
 
                //Validamos la posicion
                posValida = validarPosicion(mapa, fila, columna);
 
                //Si es valido, comprobamos que no haya ninguna marca
                if (posValida) {
 
                    //Si no hay marca, significa que es correcto
                    if (!hayValorPosicion(mapa, fila, columna, enBlanco)) {
                        correcto = true;
                    } else {
                        System.out.println("Esta posición ya esta ocupada");
                    }
                } else {
                    System.out.println("Posición no valida");
                }
 
                //Mientras no sea correcto, no salgo
            } while (!correcto);
 
            //depende del turno, inserta un simbolo u otro
            if (turno) {
                insertarEn(mapa, fila, columna, jugadorUno);
            } else {
                insertarEn(mapa, fila, columna, jugadorDos);
            }
 
            //cambio de turno
            turno = !turno;
        }
 
        //Muestra el tablero
        mostrarMapa(mapa);
 
        //Mostramos el ganador
        mostrarGanador(mapa, jugadorUno, jugadorDos, enBlanco);
 
    }
 
    /**
     *
     */
    public static void mostrarGanador(char[][] matriz, char jugadorUno, char jugadorDos, char simDef) {
 
        char simbolo = coincidenciaLinea(matriz, simDef);
 
        if (simbolo != simDef) {
 
            ganador(simbolo, jugadorUno, jugadorDos, 1);
 
            return;
 
        }
 
        simbolo = coincidenciaColumna(matriz, simDef);
 
        if (simbolo != simDef) {
 
            ganador(simbolo, jugadorUno, jugadorDos, 2);
 
            return;
 
        }
 
        simbolo = coincidenciaDiagonal(matriz, simDef);
 
        if (simbolo != simDef) {
 
            ganador(simbolo, jugadorUno, jugadorDos, 3);
 
            return;
 
        }
 
        System.out.println("Hay empate");
 
    }
 
    /**
     */
    public static void ganador(char simbolo, char jugadorUno, char jugadorDos, int tipo) {
 
        switch (tipo) {
            case 1:
                if (simbolo == jugadorUno) {
                    System.out.println("Ha ganado el Jugador 1 por linea");
                } else {
                    System.out.println("Ha ganado el Jugador 2 por linea");
                }
 
                break;
            case 2:
                if (simbolo == jugadorUno) {
                    System.out.println("Ha ganado el Jugador 1 por columna");
                } else {
                    System.out.println("Ha ganado el Jugador 2 por columna");
                }
                break;
            case 3:
                if (simbolo == jugadorUno) {
                    System.out.println("Ha ganado el Jugador 1 por diagonal");
                } else {
                    System.out.println("Ha ganado el Jugador 2 por diagonal");
                }
                break;
        }
 
    }
 
    /**
     * Insertamos en una posicion de una matriz un simbolo en concreto
          */
    public static void insertarEn(char[][] matriz, int fila, int columna, char simbolo) {
        matriz[fila][columna] = simbolo;
    }
 
    /**
     * Mostramos el turno actual
          */
    public static void turnoActual(boolean turno) {
 
        if (turno) {
            System.out.println("Le toca al jugador 1");
        } else {
            System.out.println("Le toca al jugador 2");
        }
 
    }
 
    /**
     * Pedimos un numero y lo devolvemos
          */
    public static int pedirInteger(String mensaje) {
 
        System.out.println(mensaje);
        int numero = teclado.nextInt();
 
        return numero;
 
    }
 
    /**
     * Rellena la matriz con un simbolo
          */
    public static void llenarMatriz(char[][] mapa, char simbolo) 
    {
         for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa.length; j++) { mapa[i][j] = simbolo; } 
         } 
    } /** * Validamos la posicion que nos insertan * * @param tablero * @param fila * @param columna * @return */ 
    public static boolean validarPosicion(char[][] mapa, int fila, int columna) 
    { 
        if (fila >= 0 && fila < mapa.length && columna >= 0 && columna < mapa.length) {
            return true;
        }
        return false;
    }
 
    /**
     * Indicamos si en una posicion hay una marca
     */
    public static boolean hayValorPosicion(char[][] matriz, int fila, int columna, char simboloDef) {
        if (matriz[fila][columna] != simboloDef) {
            return true;
        }
         return false;
    }
 
    /**
     * Muestra la matriz
     *
          */
    public static void mostrarMapa(char[][] matriz) {
 
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
 
    }
 
    /**
     * Indica si la matriz esta llena cuando el simbolo por defecto aparezca, no
     * esta llena
      */
    public static boolean matrizLlena(char[][] matriz, char simboloDef) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == simboloDef) {
                    return false;
                }
            }
        }
 
        return true;
 
    }
 
    /**
     * La partida acaba cuando la matriz esta llena o hay un ganador
      */
    public static boolean finJuego(char[][] matriz, char simboloDef) {
 
        if (matrizLlena(matriz, simboloDef) || coincidenciaLinea(matriz, simboloDef) != simboloDef
                || coincidenciaColumna(matriz, simboloDef) != simboloDef
                || coincidenciaDiagonal(matriz, simboloDef) != simboloDef)
        {
            return true;
        }
 
        return false;
    }
 
    /**
     * Indica si hay un ganador en una linea
     *
      */
    public static char coincidenciaLinea(char[][] matriz, char simboloDef) {
 
        char simbolo;
        boolean coincidencia;
 
        for (int i = 0; i < matriz.length; i++) {
 
            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la fila
            simbolo = matriz[i][0];
            if (simbolo != simboloDef) {
                for (int j = 1; j < matriz[0].length; j++) {
                    //sino coincide ya no habra ganadro en esta fila
                    if (simbolo != matriz[i][j]) {
                        coincidencia = false;
                    }
                }
 
                //Si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }
 
            }
 
        }
 
        //Si no hay ganador, devuelvo el simbolo por defecto
        return simboloDef;
 
    }
 
    public static char coincidenciaColumna(char[][] matriz, char simboloDef) {
 
        char simbolo;
        boolean coincidencia;
 
        for (int j = 0; j < matriz.length; j++) {
 
            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la columna
            simbolo = matriz[0][j];
            if (simbolo != simboloDef) {
                for (int i = 1; i < matriz[0].length; i++) {
                    //sino coincide ya no habra ganadro en esta fila
                    if (simbolo != matriz[i][j]) {
                        coincidencia = false;
                    }
                }
 
                //Si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }
 
            }
 
        }
 
        //Si no hay ganador, devuelvo el simbolo por defecto
        return simboloDef;
 
    }
 
    public static char coincidenciaDiagonal(char[][] matriz, char simboloDef) {
 
        char simbolo;
        boolean coincidencia = true;
 
        //Diagonal principal
        simbolo = matriz[0][0];
        if (simbolo != simboloDef) {
            for (int i = 1; i < matriz.length; i++) {
                //sino coincide ya no habra ganadro en esta fila
                if (simbolo != matriz[i][i]) {
                    coincidencia = false;
                }
            }
 
            //Si no se mete en el if, devuelvo el simbolo ganador
            if (coincidencia) {
                return simbolo;
            }
 
        }
 
        //Diagonal inversa
        simbolo = matriz[0][2];
        if (simbolo != simboloDef) {
            for (int i = 1, j = 1; i < matriz.length; i++, j--) {
                //sino coincide ya no habra ganadro en esta fila
                if (simbolo != matriz[i][j]) {
                    coincidencia = false;
                }
            }
 
            //Si no se mete en el if, devuelvo el simbolo ganador
            if (coincidencia) {
                return simbolo;
            }
        }
 
        //Si no hay ganador, devuelvo el simbolo por defecto
        return simboloDef;
 
    }
}
