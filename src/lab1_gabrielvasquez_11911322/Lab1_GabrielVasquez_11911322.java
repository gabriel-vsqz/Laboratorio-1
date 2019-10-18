package lab1_gabrielvasquez_11911322;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Gabriel Vasquez
 */
public class Lab1_GabrielVasquez_11911322 {
    
    static Scanner input = new Scanner(System.in);
    static Random r = new Random();

    public static void main(String[] args) {
        
        System.out.print("Ingrese filas: ");
        int f = input.nextInt();
        System.out.print("Ingrese columnas: ");
        int c = input.nextInt();
        
        int[][] matriz = new int[f][c];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                matriz[i][j] = 1 + r.nextInt(10);
            }
        }
        
        int[] arreglo = new int[f*c];
        
        System.out.printf("\n%s\n", "Matriz Generada:");
        imprimeMatriz(matriz, 0, 0);
        
        System.out.println();
        
        System.out.print("La suma de los números es: ");
        System.out.println(sumaMatriz(matriz, 0, 0));
        
        System.out.printf("\n%s", "Ingrese número: ");
        int num = input.nextInt();
        
        System.out.printf("\n%s\n", "Arreglo Generado:");
        int[] a = divisibleMatriz(matriz, arreglo, 0, 0, num, 0);
        imprimeArreglo(a,0);
        System.out.println();
    }
    
    static void imprimeMatriz(int[][] matriz, int f, int c){
        if(f == matriz.length - 1 && c == matriz[0].length -1){
            System.out.print("[" + matriz[f][c] + "]");
        }
        else{
            if(c == matriz[0].length-1){
                System.out.println("[" + matriz[f][c] + "]");
                imprimeMatriz(matriz, f+1, 0);
            }
            else{
                System.out.print("[" + matriz[f][c] + "]");
                imprimeMatriz(matriz, f, c+1);
            }
        }
    }
    
    static void imprimeArreglo(int[] A, int p){
        if(p == A.length -1 ){
            if(A[p] != 0){
                System.out.print("[" + A[p] + "]");
                System.out.println();
            }
            
        }
        else{
            if(A[p] != 0){
                System.out.print( "[" + A[p] + "]");
            }
                imprimeArreglo(A, p + 1);
        }
    }
    
    static int sumaMatriz(int matriz[][], int f, int c){
        if(f == matriz.length - 1 && c == matriz[0].length - 1){
            return matriz[f][c];
        }
        else{
            if(c == matriz[0].length-1){
                return matriz[f][c] + sumaMatriz(matriz, f+1, 0);
            }
            else{
                return matriz[f][c] + sumaMatriz(matriz, f, c+1);
            }
        }
    }
    
    static int[] divisibleMatriz(int[][] matriz, int[] arreglo, int f, int c, int num, int p){
        if(f == matriz.length - 1 && c == matriz[0].length - 1){
            if(matriz[f][c]%num == 0)
                arreglo[p] = matriz[f][c];
            else
                arreglo[p] = 0;
            
            return arreglo;
        }
        else{
            if(c == matriz[0].length - 1){
                if(matriz[f][c]%num == 0)
                    arreglo[p] = matriz[f][c];
                else
                    arreglo[p] = 0;
                return divisibleMatriz(matriz, arreglo, f+1, 0, num, p+1);
            }
            else{
                if(matriz[f][c]%num == 0)
                    arreglo[p] = matriz[f][c];
                else
                    arreglo[p] = 0;
                return divisibleMatriz(matriz, arreglo, f, c+1, num, p+1);
            }
        }
    }
    
}