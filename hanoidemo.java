public class hanoidemo {

    public static void main(String[] args) {
        // Llamada al método con 3 discos y 3 torres
        torresHanoi(3, 1, 2, 3);
    }

    // Método recursivo para resolver Torres de Hanoi
    public static void torresHanoi(int discos, int torre1, int torre2, int torre3) {

        // 🔹 Caso base: si hay un solo disco
        if (discos == 1) {
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
        } else {

            // 🔹 Paso 1: mover n-1 discos de torre1 a torre2 (usando torre3)
            torresHanoi(discos - 1, torre1, torre3, torre2);

            // 🔹 Paso 2: mover el disco grande a torre3
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);

            // 🔹 Paso 3: mover los n-1 discos de torre2 a torre3 (usando torre1)
            torresHanoi(discos - 1, torre2, torre1, torre3);
        }
    }
}
