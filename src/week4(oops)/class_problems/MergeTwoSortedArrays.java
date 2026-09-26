public class MergeTwoSortedArrays {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int first = 0;
        int second = 0;
        int resultIndex = 0;

        while (first < arr1.length && second < arr2.length) {
            if (arr1[first] < arr2[second]) {
                result[resultIndex] = arr1[first];
                first++;
            } else {
                result[resultIndex] = arr2[second];
                second++;
            }
            resultIndex++;
        }

        while (first < arr1.length) {
            result[resultIndex] = arr1[first];
            first++;
            resultIndex++;
        }

        while (second < arr2.length) {
            result[resultIndex] = arr2[second];
            second++;
            resultIndex++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] result = mergeSortedArrays(arr1, arr2);

        for (int number : result) {
            System.out.print(number + " ");
        }
    }
}
