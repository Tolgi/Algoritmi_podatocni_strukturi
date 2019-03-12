import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*Луѓето доаѓаат наутро во МВР за да извадат еден или повеќе документи.
Документите може да бидат:
1. Лична карта
2. Пасош
3. Возачка дозвола
Кога се отвора шалтерот прво се услужуваат луѓето кои чекаат за лична карта, па потоа оние за пасош и на
крај оние за возачка дозвола. Секој човек кога ќе дојде си застанува во редицата за соодветната исправа која 
ја вади (т.е. или во редицата за лични карти или во редицата за пасоши или во редицата за возачки дозволи). 4
Доколку еден човек има повеќе документи за вадење прво вади лична карта, па пасош и на крај возачка. 
Така ако еден човек треба да вади и лична карта и возачка дозвола прво застанува во редицата за лични карти и
откако ќе заврши таму оди на крајот на редицата за возачки дозволи.

Влез: Првиот ред означува колку луѓе вкупно дошле во МВР. 
      Потоа за секој човек се внесуваат четири реда, во првиот е името и презимето на човекот,
      а во останатите три реда се кажува кој документ соодветно (лична карта, пасош и возачка) треба да се земе,
      притоа 1 значи дека треба да се земе тој документ, 0 значи дека не треба да се земе.

На пример:

Aleksandar Aleksandrovski
1
0
1
  означува дека Александар Александровски ќе вади и лична карта и возачка дозвола, но нема да вади пасош.
Излез: Ги печати имињата на луѓето по редоследот по кој завршуваат со вадење на документи.*/

class Covek{
	public String ime;
	public int licna;
	public int pasos;
	public int vozacka;
	
	Covek(){}
	Covek(String i, int l, int p, int v){
		ime = i;
		licna = l;
		pasos = p;
		vozacka = v;
	}
}
public class MVR {

	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayQueue<Covek> lred = new ArrayQueue<Covek>(100);
		ArrayQueue<Covek> pred = new ArrayQueue<Covek>(100);
		ArrayQueue<Covek> vred = new ArrayQueue<Covek>(100);
		ArrayQueue<Covek> redosled = new ArrayQueue<Covek>(100);
		int N = Integer.parseInt(input.readLine());
		for(int i=0; i<N; i++) {
			String ime = input.readLine();
			int l = Integer.parseInt(input.readLine());
			int p = Integer.parseInt(input.readLine());
			int v = Integer.parseInt(input.readLine());
			Covek covek = new Covek(ime, l, p, v);
			
			if(l == 1) {
				lred.enqueue(covek);
			}else if(p == 1) {
				pred.enqueue(covek);
			}else{
				vred.enqueue(covek);
			}
		}
		
		while(!lred.isEmpty()) {
			Covek c = lred.dequeue();
			if(c.pasos == 1) {
				pred.enqueue(c);
			}else if(c.vozacka == 1) {
				vred.enqueue(c);
			}else {
				redosled.enqueue(c);
			}
		}
		
		while(!pred.isEmpty()) {
			Covek c = pred.dequeue();
			if(c.vozacka == 1) {
				vred.enqueue(c);
			}else {
				redosled.enqueue(c);
			}
		}
		
		while(!vred.isEmpty()) {
			Covek c = vred.dequeue();
			redosled.enqueue(c);
		}
		
		while(!redosled.isEmpty()) {
			System.out.println(redosled.dequeue().ime);
		}

	}

}
