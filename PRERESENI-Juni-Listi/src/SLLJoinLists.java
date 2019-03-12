import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Дадени се две еднострано поврзани листи чии јазли содржат по еден природен број.
Листите се сортирани во растечки редослед. Треба да се спојат двете листи во
една така што резултантната листа да е сортирана. Сортирањето е подредување со
слевање. Јазлите кои се јавуваат како дупликати (од иста листа или од различна)
да се отстранат.
Во првиот ред од влезот е даден бројот на јазли во првата листа,
потоа во вториот ред се дадени броевите од кои се составени јазлите по редослед
во првата листа, па во третиот ред е даден бројот на јазли во втората листа,
и на крај во четвртиот ред броевите од кои се составени јазлите по редослед во
втората листа. На излез треба да се испечатат јазлите по редослед во
резултантната споена листа.
Име на класата (Java): SLLJoinLists
Забелешка: Да се креира податочна структура еднострано поврзана листа и истата
да се искористи во задачата.
 
 */
public class SLLJoinLists {

	public static void main(String[] args) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		SLL<Integer> prva = new SLL<Integer>();
		SLL<Integer> vtora = new SLL<Integer>();
		
		int N = Integer.parseInt(input.readLine());
		String[] s = input.readLine().split(" ");
		for(int i=0; i<N; i++) {
			prva.insertLast(Integer.parseInt(s[i]));
		}
		
		int M = Integer.parseInt(input.readLine());
		String[] p = input.readLine().split(" ");
		for(int i=0; i<M; i++) {
			vtora.insertLast(Integer.parseInt(p[i]));
		}
		
		SLL<Integer> rezultat = new SLL<Integer>();
		SLLNode<Integer> node = prva.getFirst();
		while(node != null) {
			rezultat.insertLast(node.element);
			node = node.succ;
		}
		
		node = vtora.getFirst();
		while(node != null) {
			rezultat.insertLast(node.element);
			node = node.succ;
		}
		
		System.out.println(rezultat.toString());
		node = rezultat.getFirst();
		SLLNode<Integer>snode = rezultat.getFirst();
		
		while(node != null) {
			snode = node.succ;
			while(snode != null) {
				if(node.element == snode.element) {
					rezultat.delete(snode);
				}
				if(node.element < snode.element) {
					snode = snode.succ;
				}else {
					int tmp = node.element;
					node.element = snode.element;
					snode.element = tmp;
					
					snode = snode.succ;
				}
			}
			
			node = node.succ;
		}
		
		System.out.println(rezultat.toString());
		
		

	}

}
