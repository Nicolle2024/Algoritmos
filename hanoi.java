public class hanoi {

    public static void main(String[] args) {

        int n = 3; // número de discos (puedes cambiarlo)

        System.out.println("=== Torres de Hanoi con " + n + " discos ===\n");

        torresHanoi(n, "Origen", "Auxiliar", "Destino");
    }

    // Método recursivo
    public static void torresHanoi(int discos, String origen, String auxiliar, String destino) {

        // Caso base
        if (discos == 1) {
            System.out.println("Mover disco 1 de " + origen + " a " + destino);
        } else {
            // Paso 1
            torresHanoi(discos - 1, origen, destino, auxiliar);

            // Paso 2
            System.out.println("Mover disco " + discos + " de " + origen + " a " + destino);

            // Paso 3
            torresHanoi(discos - 1, auxiliar, origen, destino);
        }
    }
}
