import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

/*Да се напише алгоритам кој ќе врши евалуација на израз во постфикс нотација.
 *На влез се чита низа од знаци за изразот (стринг), а на излез се 
 *печати вредноста на изразот по евалуацијата.*/


public class PostfiksNotacija {

	public static void main(String[] args)throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String []izraz = input.readLine().split(" ");
		ArrayStack<Integer> stek = new ArrayStack<Integer>(100);
		for(int i=0; i<izraz.length; i++) {
			if(izraz[i].charAt(0) == '+' || izraz[i].charAt(0) == '-' || izraz[i].charAt(0) == '*' || izraz[i].charAt(0) == '/') {
				if(izraz[i].charAt(0) == '+') {
					int b = stek.pop();
					int a = stek.pop();
					int rez = a + b;
					stek.push(rez);
				}
				
				if(izraz[i].charAt(0) == '-') {
					int b = stek.pop();
					int a = stek.pop();
					int rez = a - b;
					stek.push(rez);
				}
				
				if(izraz[i].charAt(0) == '/') {
					int b = stek.pop();
					int a = stek.pop();
					int rez = a / b;
					stek.push(rez);
				}
				
				if(izraz[i].charAt(0) == '*') {
					int b = stek.pop();
					int a = stek.pop();
					int rez = a * b;
					stek.push(rez);
				}
				
			}else {
				stek.push(Integer.parseInt(izraz[i]));
			}
		}
		
		while(!stek.isEmpty()) {
			System.out.println(stek.pop());
		}
		
		
	}

}
