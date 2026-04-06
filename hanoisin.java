public class hanoisin {

    public static void main(String[] args) {

        int n = 3; // número de discos

        hanoiSin(n, "Origen", "Auxiliar", "Destino");
    }

    public static void hanoiSin(int n, String origen, String auxiliar, String destino) {

        int totalMovimientos = (int) Math.pow(2, n) - 1;

        // Si n es par, intercambiar destino y auxiliar
        if (n % 2 == 0) {
            String temp = destino;
            destino = auxiliar;
            auxiliar = temp;
        }

        for (int i = 1; i <= totalMovimientos; i++) {

            if (i % 3 == 1) {
                System.out.println("Mover disco entre " + origen + " y " + destino);
            } else if (i % 3 == 2) {
                System.out.println("Mover disco entre " + origen + " y " + auxiliar);
            } else {
                System.out.println("Mover disco entre " + auxiliar + " y " + destino);
            }
        }
    }
}
