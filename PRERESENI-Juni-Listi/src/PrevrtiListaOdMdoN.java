import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Dadena e ednostrana povrzana lista i pozicii m i n. Prevrti ja listata od pozicija m do pozicija n.
 * Vo prviot red e br na jazli na vleznata lista.
 * vo vtortiot red se dadeni cifrite od koi se sostaveni jazlite so prazno mesto
 * vo tretiot red se dadeni broevite m i n so prazno mesto
 * Ne se dozvoleni pomosni strukturi i ne e dozvoleno menuvanje na vrednostite na jazlite
 * na raspolaganje ima samo EDNA ednostrana povrzana lista
 * pr:
 * 10 20 30 40 50 60 70 
 * 3 6 
 * izlez:
 * 10 20 60 50 40 30 70*/

public class PrevrtiListaOdMdoN {

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		String [] s = input.readLine().split(" ");
		SLL<Integer> lista = new SLL<Integer>();
		for(int i=0; i<N; i++) {
			lista.insertLast(Integer.parseInt(s[i]));
		}
		
		String s1 = input.readLine();
		char [] c = s1.toCharArray();
		int m = Character.getNumericValue(c[0]);
		int n = Character.getNumericValue(c[2]);
		
		SLLNode<Integer> node = lista.getFirst();
		SLLNode<Integer> tmpM = null;
		int i = 0;
		boolean isInterval = false;
		while(node != null) {
			i++;
			
			if(isInterval) {
				lista.insertBefore(node.element, tmpM);
				tmpM = lista.find(node.element);
				lista.delete(node);
			}
			
			if(i == m) {
			    tmpM = node;
				isInterval = true;
			}
			
			
			if(i == n) {
				isInterval = false;
			}
			
			node = node.succ;
			
		}
		
		
		System.out.println(lista.toString());

	}

}
