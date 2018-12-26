//Thomas Gruszecki
//Base clase for prime sieves

import java.util.ArrayList;
import java.io.*;
public class SieveOfEratosthenes
{
    private boolean[] sieve;
    private ArrayList<Integer> primes;
    public SieveOfEratosthenes(int n)
    {
        sieve = new boolean[n];
        initialize();
        primes = new ArrayList<Integer>();
    }
    private void initialize()
    {
        for(int i = 0; i < sieve.length; i++)
        {
            sieve[i] = true;
        }
    }
    
    public void sieve()
    {
        int stop = (int)(Math.sqrt(sieve.length));
        for(int i = 2; i < stop; i++)
        {
            if(sieve[i])
            	for(int j = i * i; j < sieve.length; j+=i)
             		sieve[j] = false;
        }
        translateBooleans();
    }
    
    public void translateBooleans()
    {
        for(int i = 2; i < sieve.length; i++)
        {
            if(sieve[i])
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
