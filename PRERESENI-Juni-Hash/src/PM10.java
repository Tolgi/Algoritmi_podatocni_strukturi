import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/*Квалитет на воздух Problem 1 (0 / 0)
Дадени се мерења на PM10 честички за населбите во Скопје. Ваша задача е за дадена населба да се најде просечната концентрација на PM10 честички.
Влез: Во првиот ред од влезот е даден бројот на мерења N (N<=10 000), а во секој нареден ред е прво дадена населбата и концентрацијата на PM10 разделени со празно место. 
Во последниот ред е дадена населбата за која треба да најдете просечна концентрација на PM10 честички.
Излез: Просечната концентрација на PM10 честички за дадената населба (заокружена на 2 децимали).
Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.
Забелешка: При реализација на задачите не е дозволено да се користат помошни структури како низи или сл. На располагање од структурите имате само хеш структура.
Sample input
8
Centar 319.61
Karposh 296.74
Centar 531.98
Karposh 316.44
GaziBaba 384.05
GaziBaba 319.3
Karposh 393.18
GaziBaba 326.42
Karposh
 
Sample output
335.45*/
public class PM10 {

	public static void main(String[] args)throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, ArrayList<Float>> map = new HashMap<String, ArrayList<Float>>();
		DecimalFormat df = new DecimalFormat("####.##");
		int N = Integer.parseInt(input.readLine());
		for(int i=0; i<N; i++) {
			String [] s = input.readLine().split(" ");
			if(map.containsKey(s[0])) {
				ArrayList<Float> lista = map.get(s[0]);
				lista.add(Float.parseFloat(s[1]));
				map.put(s[0], lista);
				
			}else {
				ArrayList<Float> lista = new ArrayList<Float>();
				lista.add(Float.parseFloat(s[1]));
				map.put(s[0], lista);
			}
			
		}
		
		String opstina = input.readLine();
		if(map.containsKey(opstina)) {
			ArrayList<Float> lista = map.get(opstina);
			float zbir = 0;
			for(int i=0; i<lista.size(); i++) {
				zbir += lista.get(i);
			}
			
			System.out.println(df.format(zbir / lista.size()));
		}
		
		
		
	}

}
