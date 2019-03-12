import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Се организира колоквиумска недела на ФИНКИ и за таа цел асистентите се доделуваат за чување на испити. 
За таа цел се прави редица од асистентите во која на почеток се најмладите асистенти, а на крај се највозрасните. 
Потоа се даваат предметите и по колку асистенти се потребни за чување на секој предмет. 
Има некои асистенти кои се отсутни во тековната колоквиумска недела. 
Затоа дополнително се дава список кои од асистентите се отсутни.
Асистентите се доделуваат на следниот начин: Прво се доделуваат најмладите, а на крај најстарите, 
со тоа што ако некој асистент е отсутен тој се игнорира во редицата. 
После секое доделување на предмет асистентот се сместува на крај на редицата
(т.е. ако на секој асистент му се доделил за чување предмет, а има потреба од уште асистенти, 
повторно се започнува од најмладите).*/
/*Sample input
4
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
HristinaMihajloska
3
APS 3
MIS 1
OOS 2
1
HristinaMihajloska

Sample output
APS
3
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
MIS
1
IlinkaIvanoska
OOS
2
IgorKulev
MagdalenaKostoska*/

public class Kolokvium2 {

	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		ArrayQueue<String> asistenti = new ArrayQueue<String>(100);
		ArrayQueue<String> predmeti = new ArrayQueue<String>(100);
		ArrayQueue<String> otsutni = new ArrayQueue<String>(100);
		ArrayQueue<String> prisutni = new ArrayQueue<String>(100);
		
		int brA = Integer.parseInt(input.readLine());
		for(int i=0; i<brA; i++) {
			asistenti.enqueue(input.readLine());
		}
		
	/*	int brP = Integer.parseInt(input.readLine());
		for(int i=0; i<brP; i++) {
			predmeti.enqueue(input.readLine());
		}*/
		
		int brO = Integer.parseInt(input.readLine());
		for(int i=0; i<brO; i++) {
			otsutni.enqueue(input.readLine());
		}
		
		int j = 0;
		while(!asistenti.isEmpty()) {
			String a = asistenti.dequeue();
			j = 0;
			
			while(!otsutni.isEmpty()) {
				j++;
				String o = otsutni.dequeue();
				if(a.equals(o)){
					otsutni.enqueue(o);
					break;
				}else {
					otsutni.enqueue(o);
				}
				if(j == otsutni.size()) {
					prisutni.enqueue(a);
					break;
				}
			}	
		}
		
		
		while(!prisutni.isEmpty()) {
			System.out.print(prisutni.dequeue()+" ");
		}
		
		while(!predmeti.isEmpty()) {
			String [] predmet = predmeti.dequeue().split(" ");
			System.out.println(predmet[0]+", asistenti("+predmet[1]+"):");
			for(int i=0; i<Integer.parseInt(predmet[1]); i++) {
				String a = prisutni.dequeue();
				System.out.println(a);
				prisutni.enqueue(a);
			}
		}
		

		

	}

}
