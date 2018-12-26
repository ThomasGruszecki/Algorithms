//Thomas Gruszecki
//Sieve of Atkins
import java.util.ArrayList;
import java.io.*;
public class SieveOfAtkin
{
    private boolean[] sieveList;
    private ArrayList<Integer> primes;

    public SieveOfAtkin(int n)
    {
        sieveList = new boolean[n+1];
        primes = new ArrayList<Integer>();
        initialize();
    }

    private void initialize()
    {
        for(int i = 0; i < sieveList.length; i++)
        {
            sieveList[i] = false;
        }
        sieveList[2] = true;
        sieveList[3] = true;
        sieveList[5] = true;
    }

    public void sieve()
    {
        //Essentially, the way this code works is the following:
        //There are three equations. The total possible solutions to these systems of equations is either even or odd
        //If it's even, then the result to that system of equations is false
        //If it's false, then the result to that system of equations is true
        //Which equation used is determined by r, which is equal to n (the left side of the equation, or what it equals) modulo 60
        
        //The way we implement this is by 'toggling' the state of the potential prime every time we find a solution for that number for their respective equation
        //We start each potential state at false
        //We then run a loop where in we input every possible set of X's and Y's we can input into our equations within certain parameters
        //Every time that the equation equals a potential prime n, we check it against r and if it equals any of those numbers on the r hitlist--
        //--we set the primes state to the opposite boolean, toggling it.
        
        //As far as how we figure out our parameters, well, I couldn't tell you.
        
        //Then, we just clean up the primes by clearing out all the perfect squares and their multiples, which this algorithm doesn't hit.
        
        //first equation
        
        int size = sieveList.length-1,
            lengthSqrt = (int)Math.sqrt(size);
        
        int root1 = (int)Math.sqrt(size / 4.0);
        for(int x = 1; x <= root1; x++)
        {
            int xPart = 4 * x * x,
                root2 = (int)Math.sqrt(size - xPart);
            for(int y = 1; y <= root2; y++)
            {
                    int n = xPart + (y * y),
                        r = n % 60;
                    if( r == 1  ||
                        r == 13 ||
                        r == 17 ||
                        r == 29 ||
                        r == 37 ||
                        r == 41 ||
                        r == 49 ||
                        r == 53 )
                        sieveList[n] = !sieveList[n];
            }
        }
        
        root1 = (int)Math.sqrt(size / 3.0);
        for(int x = 1; x <= root1; x++)
        {
            int xPart = 3 * x * x,
                root2 = (int)Math.sqrt(size - xPart);
            for(int y = 1; y <= root2; y++)
            {
                    int n = xPart + (y * y),
                        r = n % 60;
                    if( r == 7  ||
                        r == 19 ||
                        r == 31 ||
                        r == 43)
                        sieveList[n] = !sieveList[n];
            }
        }
        
        for(int x = 1; x <= lengthSqrt; x++)
        {
            int xPart = 3 * x * x,
                root2 = (int)Math.sqrt(3) * x;
            for(int y = (int)Math.sqrt(xPart - size); y <= root2; y++)
            {
                    int n = xPart - (y * y),
                        r = n % 60;
                    if( n <= size && (r == 11  ||
                                     r == 23 ||
                                     r == 47 ||
                                     r == 59))
                        sieveList[n] = !sieveList[n];
            }
        }
          
        for (int i = 5; i <= lengthSqrt; i++)
        {
            if(sieveList[i])
            {
                int square = i * i;
                for (int j = square; j <= size; j += square)
                {
                    sieveList[j] = false;
                }
            }
        }
        
        translateBooleans();
    }

    private void translateBooleans()
    {
        for(int i = 2; i < sieveList.length; i++)
        {
            if(sieveList[i])
                primes.add(i);
        }
    }

    public String toString()
    {
        String str = new String("");
        for(int k : primes)
            str += ("\n" + k);
        str += "\nTotal Primes : " + primes.size();
        return str;
    }

    public void toFile()
    {
        PrintWriter writer = null;
        try
        {
            writer = new PrintWriter("Primes.txt", "UTF-8");
        }
        catch(IOException e)
        {

        }

        for(int p : primes)
            writer.println(p);

        writer.close();
    }
}

//UNOPTOMIZED IMPLEMENTATION
/*public void sieve()
    {
        //Essentially, the way this code works is the following:
        //There are three equations. The total possible solutions to these systems of equations is either even or odd
        //If it's even, then the result to that system of equations is false
        //If it's false, then the result to that system of equations is true
        //Which equation used is determined by r, which is equal to n (the left side of the equation, or what it equals) modulo 60
        
        //The way we implement this is by 'toggling' the state of the potential prime every time we find a solution for that number for their respective equation
        //We start each potential state at false
        //We then run a loop where in we input every possible set of X's and Y's we can input into our equations within certain parameters
        //Every time that the equation equals a potential prime n, we check it against r and if it equals any of those numbers on the r hitlist--
        //--we set the primes state to the opposite boolean, toggling it.
        
        //As far as how we figure out our parameters, well, I couldn't tell you.
        
        //Then, we just clean up the primes by clearing out all the perfect squares and their multiples, which this equation doesn't hit.
        
        //first equation
        
        int lengthSqrt = (int)Math.sqrt((double)sieveList.length);
        int n, x, y; //variables for solving systems of equations
        int r; //remainder variable
        int square, i, j; //variables for dealing with squares
        
        for (x = 1; x <= lengthSqrt; x++) 
        {
            for (y = 1; y <= lengthSqrt; y++) 
            {
                n = (4 * x * x) + (y * y);
                r = n % 60;
                if(n < sieveList.length && (r == 1 ||
                                            r == 13 ||
                                            r == 17 ||
                                            r == 29 ||
                                            r == 37 ||
                                            r == 41 ||
                                            r == 49 ||
                                            r == 53)) 
                    sieveList[n] = !sieveList[n];
                n = (3 * x * x) + (y * y);
                r = n % 60;
                if (n < sieveList.length && (r == 7 ||
                                             r == 19 ||
                                             r == 31 ||
                                             r == 43)) 
                    sieveList[n] = !sieveList[n];
                n = (3 * x * x) - (y * y);
                r = n % 60;
                if (n < sieveList.length && (r == 11 ||
                                             r == 23 ||
                                             r == 47 ||
                                             r == 59)) 
                    sieveList[n] = !sieveList[n];
            }
        }
          
        for (i = 5; i <= lengthSqrt; i++)
        {
            if(sieveList[i])
            {
                square = i * i;
                for (j = square; j <= sieveList.length; j += square)
                {
                    sieveList[j] = false;
                }
            }
        }
        
        translateBooleans();
    }*/
