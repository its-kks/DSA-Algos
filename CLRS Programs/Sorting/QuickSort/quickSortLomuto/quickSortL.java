class quickSortL {
    static void Swap(int[] array,
            int position1,
            int position2) {
        int temp = array[position1];
        array[position1] = array[position2];
        array[position2] = temp;
    }
static int partition(int[] arr, int low,
            int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++)
        {
            if (arr[j] <= pivot)
            {
                i++; 
                Swap(arr, i, j);
            }
        }
        Swap(arr, i + 1, high);
        return (i + 1);
    }
    static void quickSort(int[] arr, int low,int high) {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    static void printArray(int[] arr, int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(" " + arr[i]);
            System.out.println();
        }
    static public void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}