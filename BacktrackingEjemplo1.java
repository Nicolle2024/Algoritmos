import java.util.ArrayList;
import java.util.List;

public class BacktrackingEjemplo {

    public static void main(String[] args) {

        int[] conjunto = { 1, 2, 3 };

        System.out.println("=== SUBCONJUNTOS ===");
        generarSubconjuntos(conjunto, 0, new ArrayList<>());

        System.out.println("\n=== PERMUTACIONES ===");
        generarPermutaciones(conjunto, 0);
    }

    // =========================
    // SUBCONJUNTOS
    // =========================
    public static void generarSubconjuntos(int[] arr, int index, List<Integer> actual) {

        // Caso base: llegamos al final del arreglo
        if (index == arr.length) {
            System.out.println(actual);
            return;
        }

        // 1. NO incluir el elemento actual
        generarSubconjuntos(arr, index + 1, actual);

        // 2. INCLUIR el elemento actual
        actual.add(arr[index]);

        generarSubconjuntos(arr, index + 1, actual);

        // BACKTRACKING: deshacer la decisión
        actual.remove(actual.size() - 1);
    }

    // =========================
    // PERMUTACIONES
    // =========================
    public static void generarPermutaciones(int[] arr, int index) {

        // Caso base: se formó una permutación completa
        if (index == arr.length) {
            imprimirArreglo(arr);
            return;
        }

        for (int i = index; i < arr.length; i++) {

            // Intercambiar (decisión)
            intercambiar(arr, index, i);

            // Llamada recursiva
            generarPermutaciones(arr, index + 1);

            // BACKTRACKING: deshacer intercambio
            intercambiar(arr, index, i);
        }
    }

    // Método para intercambiar elementos
    public static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Método para imprimir arreglo
    public static void imprimirArreglo(int[] arr) {
        for (int num : arr) {
            System.out.print(num);
        }
        System.out.println();
    }
}
