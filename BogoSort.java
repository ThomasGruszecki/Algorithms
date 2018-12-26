//Bogosort/RandomSort
//Depending on how long the array is, the average time this is can be
//several billion magnitudes more iterations than there are particles in the sun.
//O(N!) average. On the other hand, O(n) optimal. Buy a lottery ticket if it works out that way,
//would you?

public class BogoSort
{
    public static void sort(int[] array)
    {
        Integer n;
        int r;
        while(!isSorted(array))
        {
            for(int i = array.length - 1; i >= 0; i--)
            {
                r = (int)(Math.random() * array.length);
                n = array[i];
                array[i] = array[r];
                array[r] = n;
            }
        }
    }
    
    public static boolean isSorted(int[] array)
    {
        for(int i = 1; i < array.length; i++)
        {
            if(array[i-1] <= array[i])
                continue;
            else
                return false;
        }
        return true; //Congrats! It only took a billion more iterations than bubble sort too!
    }
}
