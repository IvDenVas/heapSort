import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[25];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println("Рандомно созданный массив: ");
        System.out.println(Arrays.toString(array));
        heapSort(array);
        System.out.println("Массив после сортировки:");
        System.out.println(Arrays.toString(array));
    }
    public static void heapSort(int[] array){
        for (int i = array.length / 2 - 1; i >= 0; i-- ){
            heapify(array, array.length, i);
        }

        for (int i = array.length - 1; i >= 0; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int heapSize, int rootIndex){
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && array[leftChild] > array[largest]){
            largest = leftChild;
        }
        if (rightChild < heapSize && array[rightChild] > array[largest]){
            largest = rightChild;
        }
        if (largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            heapify(array, heapSize, largest);
        }
    }
}