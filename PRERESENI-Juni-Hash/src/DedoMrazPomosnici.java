import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*Помошниците на Дедо Мраз направиле компјутерски систем во кој се чуваа список на сите добри деца и
 нивната желба за подарок за Нова Година, 
само што за македонските деца употребиле стара транскрипција на специфичните македонски букви, па така буквата ч ја чуваат како c, 
буквата ж како z и ш како s. Но, кога треба да проверат дали некое дете било добро, неговото име го добиваат според новата транскрипција 
каде буквата ч се преставува како ch, буквата ж како zh и ш како sh. Помогнете им на помошниците на Дедо Мраз да проверат дали детете било добро , 
и доколку било, кој подарок треба да го добие.

Влез: Во првата линија е даден број N на деца кои биле добри. Во наредните N линии се дадени името на детете и поклонот кој го сака. 
Во последниот ред е дадено името на детете кое треба да се провери.

Излез: Ако даденото дете не било добро (т.е. го нема во списокот на добри деца) да се испечати Nema poklon, а ако било добро да се испечати кој подарок го сакало.

Име на класа: DedoMrazPomoshnici

Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.

Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не да користат помошни структури како низи или сл.*/
/*5
JohnDoe dog
JaneDoe cat
TomceZarkovski bike
MartaMartevska sonyplaystation
EstebanPerez brother
TomcheZharkovski

Пример излез
bike*/

public class DedoMrazPomosnici {

	public static void main(String[] args)throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		HashMap<String,String>map = new HashMap<String,String>();
		
		for(int i=0; i<N; i++) {
			String [] s = input.readLine().split(" ");
			map.put(s[0], s[1]);
		}
		
		String ime = input.readLine();

		boolean isUpperCase = false;
		String kluc ="";
		
		if(map.containsKey(ime)) {
			System.out.println(map.get(ime));
		}else {
		
			for(int i=0; i<ime.length(); i++) {
				
				if((ime.charAt(i) == 'c' && ime.charAt(i+1) == 'h') || (ime.charAt(i) == 'C' && ime.charAt(i+1) == 'h')) {
					ime = ime.substring(0, i+1) + ime.substring(i+2);
				}
				
				if((ime.charAt(i) == 'z' && ime.charAt(i+1) == 'h') || (ime.charAt(i) == 'Z' && ime.charAt(i+1) == 'h')) {
					ime = ime.substring(0, i+1) + ime.substring(i+2);
				}
				
				if((ime.charAt(i) == 's' && ime.charAt(i+1) == 'h') || (ime.charAt(i) == 'S' && ime.charAt(i+1) == 'h')) {
					ime = ime.substring(0, i+1) + ime.substring(i+2);
				}

			}
	
		}
		
		if(map.containsKey(ime)) {
			System.out.println(map.get(ime));
		}else {
			System.out.println("Nema");
		}
	}
}
			
	



