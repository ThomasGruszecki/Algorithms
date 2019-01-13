public class MergeSort
{
    public static void sort(int[] array)
    {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int start, int end)
    {
        if(start >= end)
            return;
        int mid = (start+end) / 2,
        firstIndex = start,
        secondIndex = mid + 1;
        int[] mergeArray = new int[(end - start) + 1];

        sort(array, 0, mid);
        sort(array, mid + 1, end);

        for(int i = 0; i < mergeArray.length; i++)
        {
            mergeArray[i] = (secondIndex > end) || 
                            ((firstIndex <= mid) && (array[firstIndex] < array[secondIndex])) ? 
                            array[firstIndex++] : 
                            array[secondIndex++];
        }

        int j = 0;
        for(int i = start; i <= end; i++)
        {
            array[i] = mergeArray[j++];
        }
    }
}
