import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* Податоците за плати на вработените во една компанија привремено се чуваат во еднострано поврзана листа. 
 * Во секој јазол од листата се чува единствен ID на вработениот и неговата плата. Потребно е да се отстранат
 * сите вработени со помали плати од даден износ, а остатокот да се прикажат во опаѓачки редослед во однос на 
 * ID-то. Во првиот ред од влезот е даден бројот на вработени, потоа наизменично се дадени ID и плата за 
 * секој од вработените и во последниот ред е износот во однос на кој ќе се отстрануваат вработените.
 * На излез се печати листа (ID, плата) во опаѓачки редослед според ID на секој од вработените.
 * Доколку нема вработени со плата поголема од дадената да се испечати: nema
 * VLEZ:
3
1111
19000
2222
22000
1155
60000
30000
  * IZLEZ:
1155 60000*/

class Vraboten{
	public int ID;
	public int Plata;
	
	Vraboten(){}
	Vraboten(int id, int plata){
		ID = id;
		Plata = plata;
	}
	
	public int getPlata() { return Plata; }
	public int getID() { return ID; }
	public void setPlata(int p) { Plata = p; } 
	public void setID(int id) { ID = id; }
}

public class SLLKompanija {
	
	public static void pecati(SLL<Vraboten> lista) {
		SLLNode<Vraboten> node = lista.getFirst();
		while(node != null) {
			System.out.println(node.element.ID+","+node.element.Plata);
			node = node.succ;
		}
	}

	public static void main(String[] args)throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		SLL<Vraboten> lista = new SLL<Vraboten>();
		int N = Integer.parseInt(input.readLine());
		for(int i = 0; i<N; i++) {
			int id = Integer.parseInt(input.readLine());
			int plata = Integer.parseInt(input.readLine());
			Vraboten vraboten = new Vraboten(id, plata);
			lista.insertLast(vraboten);
		}
		
		int iznos = Integer.parseInt(input.readLine());
				
		SLLNode<Vraboten> node = lista.getFirst();
		
		 while(node != null) {
			if(node.element.Plata < iznos) {
				lista.delete(node);
			}
			
			node = node.succ;
		}
		 //pecati(lista);
		 if(lista.length() != 0) {
			 node = lista.getFirst();
			 SLLNode<Vraboten> snode = null;
			 while(node != null) {
				 snode = node.succ;
				 while(snode != null) {
					 if(node.element.ID < snode.element.ID) {
						 int tmpID = node.element.ID;
						 int tmpPlata = node.element.Plata;
						 node.element.ID = snode.element.ID;
						 node.element.Plata = snode.element.Plata;
						 snode.element.ID = tmpID;
						 snode.element.Plata = tmpPlata;
					 }
					 
					 snode = snode.succ;
				 }
				 
				 node = node.succ; 
			 }
			 pecati(lista);
			 
		 }else {
			 System.out.println("nema");
		 }
		 
		 
		
		

	}

}
