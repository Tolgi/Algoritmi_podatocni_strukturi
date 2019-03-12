import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Dvostrano povrzana lista od karakteri. Pocnuva od napred i se brise 2,4,6... jazol
 * Potoa pocnuva od nazad pa se brise pretposledniot, pret-pretposledniot itn. Se dodeka ne ostane
 * 1 jazol vo listata. Pomosni listi ne se dozvoleni.
 * Primer: a b c d e f g
 * posle prvo brisenje: a c e g
 * posle vtoro brisenje: c g
 * finalno brisenje(od napred): c
 * da se ispecati: f
 * */
/*There is a double linked list containing characters (each node contains one character).
You should do the following until there is only one node left in the list: starting from
the beginning of the list each second node should be deleted (ie. 2nd, 4th, 6th, etc),
then starting from the end of the list each second node should be deleted (ie. the one
before the last, 2 nodes before that, etc). You should repeat this (deleting from the
beginning, then from the end) in each iteration, until there is only one node in the list
left.
Input: One line of input containing the elements of the list (characters separated by a
blank space).
Output: You should print the value of the remaining node.*/

public class RazigranaLista {

	public static void main(String[] args) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		String s = input.readLine();
		char [] c = s.toCharArray();
		DLL<Character>lista = new DLL<Character>();
		for(int i=0; i<c.length; i++) {
			lista.insertLast(c[i]);
		}
		
		//System.out.println(lista.toString());
		DLLNode<Character> node = lista.getFirst();
		int i = 0;
		boolean napred = true;
		while(lista.length() > 1) {
			
			while(node != null) {
				i++;
				if(i % 2 == 0) {
					lista.delete(node);
				}
				if(napred) {
					node = node.succ;
				}else {
					node = node.pred;
				}
			}
			
			i = 0;
			if(napred) {
				node = lista.getLast();
			}else {
				node = lista.getFirst();
			}
			napred = !napred;
			
		}
		
		System.out.println(lista.toString());
		

	}

}
