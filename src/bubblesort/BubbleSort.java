/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

/**
 *
 * @author Morad
 */
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el tamaño de la lista:");
        int tamanio = sc.nextInt();
        int[] lista = new int[tamanio];

        System.out.println("Ingrese los elementos de la lista uno por uno:");

        // Leer los elementos de la lista
        for (int i = 0; i < tamanio; i++) {
            lista[i] = sc.nextInt();
        }

        // Llamada al método de ordenamiento de burbuja
        bubbleSort(lista);

        // Mostrar la lista ordenada
        System.out.println("Lista ordenada:");
        for (int num : lista) {
            System.out.print(num + " ");
        }

        sc.close();
    }

    private static void bubbleSort(int[] lista) {
    int n = lista.length;
    for (int i = 0; i < n - 1; i++) { // Bucle externo que recorre la lista desde el primer elemento hasta el penúltimo
        for (int j = 0; j < n - i - 1; j++) { // Bucle interno que recorre la lista hasta el último elemento no ordenado
            // Compara elementos adyacentes y hace el swap si es necesario
            if (lista[j] > lista[j + 1]) { // Si el elemento actual es mayor que el siguiente
                int temp = lista[j];    // Realiza el swap utilizando una variable temporal
                lista[j] = lista[j + 1];
                lista[j + 1] = temp;
            }
        }
    }
}
}
/*
El algoritmo de ordenamiento de burbuja es un algoritmo de comparación que
recorre repetidamente una lista desde el principio hasta el penúltimo elemento, 
realizando comparaciones y haciendo swaps (intercambios) de elementos adyacentes
si están en el orden incorrecto. En cada iteración del bucle externo, el bucle 
interno recorre la lista hasta el último elemento no ordenado, y en cada comparación,
si el elemento actual es mayor que el siguiente, se realiza un swap utilizando una
variable temporal. De esta manera, el elemento más grande "burbujea" hacia el final
de la lista en cada iteración. El proceso continúa hasta que la lista esté completamente ordenada, 
y el método finaliza. Aunque es simple de implementar, el algoritmo de burbuja puede
ser ineficiente para listas grandes debido a su complejidad cuadrática O(n^2).
Sin embargo, para listas pequeñas o con pocos elementos,
puede ser útil para propósitos educativos o en situaciones donde el rendimiento no es crítico.
*/
