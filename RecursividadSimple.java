public class RecursividadSimple {

    // Método recursivo para calcular el factorial de un número
    static int factorial(int n) {

        // Caso base: cuando n es 0 o 1, el factorial es 1
        if (n <= 1) {
            return 1;
        }

        // Caso recursivo:
        // n * factorial(n-1)
        // Se llama a sí misma con un valor más pequeño
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {

        int numero = 150;

        // Llamamos al método recursivo
        int resultado = factorial(numero);

        // Mostramos el resultado
        System.out.println("Factorial de " + numero + " es: " + resultado);
    }
}
