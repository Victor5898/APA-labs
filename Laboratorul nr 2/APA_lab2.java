package APA;
import java.util.Scanner;

class Main 
{
  static int iteratii = 0;
	
	static boolean[] Complex_nloglogn(int n)
	{
		boolean[] isprime = new boolean[1000];
		for(int i = 0; i < 1000; i++)
		{
			isprime[i] = true;
		}
		for(int i = 2; i * i <= n; i++)
		{
				if(isprime[i] == true)
				{
					for(int j = i * i; j <= n; j += i)
					{
						isprime[j] = false;
						iteratii++;
					}
				}
		}
		return isprime;
	}
	
	static boolean[] Complex_n(int n)
	{
		int[] prime = new int[1000];
		int[] minFactorPrim = new int[1000];
		boolean[] isprime = new boolean[1000];
		int incr = 0;
		for(int i = 0; i < 1000; i++)
		{
			isprime[i] = true;
			minFactorPrim[i] = 2; 
		}
		for(int i = 2; i <= n; i++)
		{
			if(isprime[i] == true)
			{
				prime[incr] = i;
				minFactorPrim[i] = i;
				incr++;
			}
			for(int j = 0; j < incr && i * prime[j] < n && prime[j] <= minFactorPrim[i]; j++)
			{
				isprime[i * prime[j]] = false;
				minFactorPrim[i * prime[j]] = prime[j];
				iteratii++;
			}
		}
		return isprime;
	}
	
  static boolean Complex_npow2(int n)
  {
    for(int i = 2; i < n; i++)
    {
      if(n % i == 0)
      {
        return false;
      }
      iteratii++;
    }
    return true;
  }


  public static void main(String[] args) 
  {
    int limita;
		Scanner sc = new Scanner(System.in);
		System.out.println("Dati numarul pana la care vom afisa numerele prime: ");
		limita = sc.nextInt();
		sc.close();
		boolean[] sirulPrim = Complex_nloglogn(limita);
    System.out.println("Rezultatul algoritmului O(nloglogn): ");
		for(int i = 2; i < limita; i++)
		{
			if(sirulPrim[i])
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Numarul de iteratii pentru algoritmul cu O(nloglogn) este " + Main.iteratii);
    System.out.println();
		iteratii = 0;
    System.out.println("Rezultatul algoritmului O(n): ");
		sirulPrim = Complex_n(limita);
		for(int i = 2; i < limita; i++)
		{
			if(sirulPrim[i])
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Numarul de iteratii pentru algoritmul cu O(n) este " + iteratii);
    System.out.println();
		iteratii = 0;
    System.out.println("Rezultatul algoritmului O(n^2): ");
		for(int i = 2; i < limita; i++)
		{
			if(Complex_npow2(i) == true)
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Numarul de iteratii pentru algoritmul cu O(n^2) este " + Main.iteratii);

  }
}
