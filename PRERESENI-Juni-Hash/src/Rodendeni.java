import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/*Во заводот на статистика се прави ново истражување каде што се открива зависноста на месецот на раѓање 
 *со имињата на луѓето родени во тој месец. Ваша задача е за даден месец да ги прикажете сите различни имиња 
 *на луѓе родени во тој месец.

Влез: Во првиот ред од влезот е даден бројот на луѓе N (N<=10 000), а во секој нареден ред се дадени името
 	  на човекот и датумот на неговото раѓање разделени со празно место. Во последниот ред е даден месецот
 	  за кој треба да се прикажат сите различни имиња на луѓето родени во тој месец.

Излез: Листа со различни имиња на луѓе родени во дадениот месец. Доколку нема луѓе родени во тој месец да 
	   се испечати Nema.

Делумно решение: Задачата се смета за делумно решена доколку се поминати 3 тест примери.

Забелешка: При реализација на задачите не е дозволено да се користат помошни структури како низи или сл.
 		   На располагање од структурите имате само една хеш структура.
Пример:
4 
Ivan 20.7.1976 
Ivan 16.7.1988
Ana 18.7.1966
Ivan 5.6.1988
7
Ivan Ana*/

public class Rodendeni {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
		int N = Integer.parseInt(input.readLine());
		for(int i = 0; i<N; i++) {
			String [] s = input.readLine().split(" ");
			String [] data  = s[1].split("\\.");
			int kluc = Integer.parseInt(data[1]);
			String ime = s[0];
			
			if(map.containsKey(kluc)) {
				ArrayList<String> lista = map.get(kluc);
				if(!lista.contains(ime)) {
					lista.add(ime);
					map.put(kluc, lista);
				}

			}else {
				ArrayList<String> lista = new ArrayList<String>();
				lista.add(ime);
				map.put(kluc, lista);
			}			
		}
		
		int mesec = Integer.parseInt(input.readLine());
		//System.out.println(map.toString());
		if(map.containsKey(mesec)) {
			ArrayList<String> lista = map.get(mesec);
			for(int i=0; i<lista.size(); i++) {
				System.out.print(lista.get(i)+" ");
			}
		}else {
			System.out.print("Nema");
		}
		
	}

}
