import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Кај асистентот Игор се одржуваат консултации по два предмети АСП и ММС во еден термин.
 * Бидејќи по АПС колоквиумот е следниот ден, Игор им рекол на студентите кои што чекаат дека 
 * прво ќе ги услужи студентите по АПС, а после студентите по ММС. 
 * Студентите се подготвиле со прашања и прашањата за АПС можат да бидат од тип А, B, C или D. 
 * Асистентот им напоменал на студентите по АПС, ако дојде некој студент и праша прашање од 
 * тип X (X e A,B,C или D) и веднаш после него дојде студент со прашање од тип X 
 * (т.е. со прашање од ист тип), вториот студент ќе биде ставен на крајот од редот и истовремено ќе биде пуштен 
 * еден студент од другата редица за ММС (ако таа редица не е празна). 
 * Генерално, ако последното одговорено прашање по АПС е од тип X, и дојде студент со прашање од тип X, 
 * тој се преместува на крајот од редот и се пушта еден студент од другата редица за ММС (ако таа редица не е празна).
 * Кој ќе биде конечниот распоред за влегување? 
 * 
 * Влез: Се дава прво бројот на студенти кои се пријавиле за консултации АПС, 
 * а потоа се наведуваат студентите според редоследот на пријавување и се дава за кој тип прашање се 
 * пријавиле (A, B, C или D). 
 * Следно се дава бројот на студенти кои се пријавиле за консултации ММС,
 * а потоа се наведуваат студентите според редоследот на пријавување. 
 * 
 * На излез се печатат студентите според редоследот по кој влегле на консултации.
 * Sample input
3
IlinkaIvanoska A
MagdalenaKostoska A
HristinaMihajloska B
1
IgorKulev
Sample output
IlinkaIvanoska
IgorKulev
HristinaMihajloska
MagdalenaKostoska

 * */
class Ucenik{
	public String ime;
	public char tip;
	
	public Ucenik() {}
	public Ucenik(String i, char t) {
		ime = i;
		tip = t;
	}
}
public class KonsultaciiIgor {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int brA = Integer.parseInt(input.readLine());
		ArrayQueue<Ucenik> aps = new ArrayQueue<Ucenik>(100);
		for(int i=0; i<brA; i++) {
			String [] s = input.readLine().split(" ");
			Ucenik u = new Ucenik(s[0], s[1].charAt(0));
			aps.enqueue(u);;
		}
		
		int brMMS = Integer.parseInt(input.readLine());
		ArrayQueue<String> mms = new ArrayQueue<String>(100);
		for(int i=0; i<brMMS; i++) {
			mms.enqueue(input.readLine());
		}
		
		
		char poslednoP= ' ';
		ArrayQueue<String> raspored = new ArrayQueue<String>(100);
		while(!aps.isEmpty()) {
			Ucenik u = aps.dequeue();
			if(poslednoP == u.tip) {
				if(!mms.isEmpty()) {
					aps.enqueue(u);
					raspored.enqueue(mms.dequeue());
				}else {
					raspored.enqueue(u.ime);
				}
			}else {
				raspored.enqueue(u.ime);
				poslednoP = u.tip;
				if(!aps.isEmpty() && (aps.peek().tip == u.tip)){
					
					if(!mms.isEmpty()) {
						raspored.enqueue(mms.dequeue());
					}
					aps.enqueue(aps.dequeue());
					
				}
			}
			
			if(poslednoP == ' ') {
				poslednoP = u.tip;
			}
		}
		
		while(!mms.isEmpty()) {
			raspored.enqueue(mms.dequeue());
		}
		
		
		while(!raspored.isEmpty()) {
			System.out.println(raspored.dequeue());
		}
	}

}
