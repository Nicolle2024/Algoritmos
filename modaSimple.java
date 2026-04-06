public static int modaSimple(int[] a) {
    // 1. Ordenar (El paso más costoso pero necesario)
    mergeSort(a, 0, a.length - 1);

    int moda = a[0];
    int maxRepeticiones = 0;
    int contadorActual = 1;

    // 2. Proceso de comparación lineal
    for (int i = 1; i < a.length; i++) {
        if (a[i] == a[i - 1]) {
            contadorActual++;
        } else {
            // ¿El grupo que acabamos de terminar es el más grande?
            if (contadorActual > maxRepeticiones) {
                maxRepeticiones = contadorActual;
                moda = a[i - 1];
            }
            contadorActual = 1; // Reiniciar para el nuevo número
        }
    }

    // Comparación final (para el último grupo de números)
    return (contadorActual > maxRepeticiones) ? a[a.length - 1] : moda;
}
