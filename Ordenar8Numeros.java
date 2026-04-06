public class Ordenar8Numeros {

    // Método principal
    static void ordenar(int[] a, int inicio, int fin) {

        // Caso base
        if (inicio >= fin)
            return;

        int medio = (inicio + fin) / 2;

        // Dividir
        ordenar(a, inicio, medio);
        ordenar(a, medio + 1, fin);

        // Combinar
        combinar(a, inicio, medio, fin);
    }

    // Método para combinar
    static void combinar(int[] a, int inicio, int medio, int fin) {

        int[] temp = new int[fin - inicio + 1];

        int i = inicio, j = medio + 1, k = 0;

        while (i <= medio && j <= fin) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= medio)
            temp[k++] = a[i++];
        while (j <= fin)
            temp[k++] = a[j++];

        // Copiar al arreglo original
        for (int t = 0; t < temp.length; t++) {
            a[inicio + t] = temp[t];
        }
    }

    public static void main(String[] args) {

        int[] nums = { 82, 30, 2, 10, 9, 41, 27, 3 }; // 8 números

        ordenar(nums, 0, nums.length - 1);

        System.out.println("Ordenado:");
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
