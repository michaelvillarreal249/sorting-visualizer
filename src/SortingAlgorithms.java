public class SortingAlgorithms {

    // Bubble Sort algorithm
    public static void bubbleSort(int[] arr, VisualizerPanel panel) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    panel.refresh();
                }
            }
        }
    }

    // Selection Sort algorithm
    public static void selectionSort(int[] arr, VisualizerPanel panel) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            panel.refresh();
        }
    }

    // Insertion Sort algorithm
    public static void insertionSort(int[] arr, VisualizerPanel panel) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;

                panel.refresh();
            }

            arr[j + 1] = key;

            panel.refresh();
        }
    }
}
