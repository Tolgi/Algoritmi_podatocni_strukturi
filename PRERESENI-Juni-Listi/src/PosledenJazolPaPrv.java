import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Dadena e linearno povrzana lista. Da se napise funkcija koja vo listata kje go pronajde posledniot jazol so informacija*/
/* x i kje go prefrli na celo na listata. Kako rezultat funkcijata da ja vrakja pozicijata(broeno od pocetokot na listata)*/
/* na koja bil pronajden baraniot jazol ili -1 ako takov jazol ne bil pronajden vo listata.
 * Pr:  3->4->7->6->4->7->3->2;    x=7 
 *      7->3->4->7->6->4->3->2;    pozicija 6;*/

public class PosledenJazolPaPrv {

	public static void main(String[] args) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		String [] s = input.readLine().split(" "); 
		SLL<Integer> lista = new SLL<Integer>();
		
		for(int i=0; i<N; i++) {
			lista.insertLast(Integer.parseInt(s[i]));
		}
		
		int x = Integer.parseInt(input.readLine());
		
		SLLNode<Integer> node = lista.getFirst();
		SLLNode<Integer> nodeX = null;
		int i=0, pozicija = -1;
		while(node != null) {
			i++;
			if(node.element == x) {
				nodeX = node;
				pozicija = i;
			}
			
			node = node.succ;
		}
		
		if(pozicija != (-1)) {
			lista.insertFirst(nodeX.element);
			lista.delete(nodeX);
		}
		
		System.out.println(lista.toString());
		if(pozicija != (-1)) {
			System.out.println("Pozicija: "+ pozicija);
		}else {
			System.out.println("Ne postoi takov element!");
		}

	}

}
