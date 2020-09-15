package APA;


import java.util.Scanner; //import clasa Scanner din package-ul util

class lab1 
{
	static int num_iteratii1 = 0; //creez variabile care pastreaza numarul de iteratii pentru fiecare functie
	static int num_iteratii2 = 0;
	static int num_iteratii3 = 0;
	
	static long fib1(int num) //functia care implemeteaza un algoritm recursiv 
	{
		num_iteratii1++;
		
		if(num<2) // In caz pozitia numarului cautat coincide cu numarul (valabil doar pentru num = 0, num = 1 ), returnez acest numar 
		{
			return num;
		}
			else
			{
				return fib1(num-1) + fib1(num-2); //In caz contrar adun toate numerele din sirul lui Fibonacci in ordine decrescatoare, recursiv
			}
	}
	
	static long fib2(int num) //functie cu complexitatea liniara
	{
		long i = 1;
		long j = 0;
		for(int k = 0; k < num; k++)
		{
			j = i + j;
			i = j - i; //are loc adunarea de num ori a elementului de pe pozitia j cu predecesorul sau
			num_iteratii2++;
		}
		return j;
	}
	
	static long fib3(int num) //functia de complexiatate logaritmica
	{
		long i, j, k, h, t;
		i = 1;
		j = 0;
		k = 0;
		h = 1;
		while(num > 0)
		{
			if(num % 2 != 0)
			{
				t = j * h;
				j = i * h + j * k + t;
				i = i * k + t;
			}
			t = h * h;
			h = 2 * k * h + t;
			k = k * k + t;
			num = num / 2; //pentru fiecare pas reducem in jumatate num
			
			num_iteratii3++;
		}
		return j;
	}
}

class APA_lab1
{
	public static void main(String args[])
	{
		int n;
		long rezult1, rezult2, rezult3;
		System.out.println("Dati numarul pozitiei numarului din sirul lui Fibonacci: ");
		Scanner sc = new Scanner(System.in); //creez un obiect de tip Scanner
		n = sc.nextInt();//citim de la tastatura al catelea termen dorim sa il aflam
		sc.close(); //dezalocam memoria destinata pentru pastrarea obiectului
		
		//in continuare atribuim valoarea returnata de functii variabilelor cu care vom afisa rezultatele, afisam numarul de iteratii pentru fiecare functie
		rezult1 = lab1.fib1(n);
		System.out.println("Metoda cu complexiate recursiva: ");
		System.out.println("Numarul de pe pozitia " + n + " din sirul lui Fibonacci este " + rezult1);
		System.out.println("Numarul de iteratii este: " + lab1.num_iteratii1);
		System.out.println();
		
		rezult2 = lab1.fib2(n);
		System.out.println("Metoda cu complexiate liniara: ");
		System.out.println("Numarul de pe pozitia " + n + " din sirul lui Fibonacci este " + rezult2);
		System.out.println("Numarul de iteratii este: " + lab1.num_iteratii2);
		System.out.println();
		
		rezult3 = lab1.fib3(n);
		System.out.println("Metoda cu complexiate logaritmica: ");
		System.out.println("Numarul de pe pozitia " + n + " din sirul lui Fibonacci este " + rezult3);
		System.out.println("Numarul de iteratii este: " + lab1.num_iteratii3);
		System.out.println();
	}

}
