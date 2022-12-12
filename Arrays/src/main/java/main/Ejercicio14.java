package main;

public class Ejercicio14 {
    public static void main(String[] args) {
        Ejercicio14 ej14 = new Ejercicio14();
        ej14.ejercicio14();
    }

    public void ejercicio14() {

        int[] array = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int[] array2 = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int[] array3 = new int[20];
        int contador1 = 0;
        int contador2 = 0;


        for (int i = 0; i < array3.length && contador1 < 10 && contador2 < 10; i++) {
            if (array[contador1] > array2[contador2]) {
                array3[i] = array2[contador2];
                contador2++;
            } else if (array[contador1] < array2[contador2]) {
                array3[i] = array[contador1];
                contador1++;
            } else if (array[contador1] == array2[contador2]) {
                array3[i] = array[contador1];
                array3[i + 1] = array2[contador2];
                i++;
                contador1++;
                contador2++;
            }
        }
        if (contador1 == 10) {
            for (int i = 0; i < (10 - contador2); i++) {
                array3[contador1 + contador2] = array2[contador2];
            }
        } else if (contador2 == 10) {
            for (int i = 0; i < (10 - contador1); i++) {
                array3[contador1 + contador2] = array[contador1];
            }
        }
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + " ");
        }
    }
}
