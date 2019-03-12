import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*Треба да изработите автоматски преведувач за зборови од анлиски јазик на македонски. 
 *Влезот се состои од парови од зборови разделени со празно место. Така прво е даден зборот на македонски, 
 *па има едно празно место, па преводот на зборот на англиски јазик. Потоа на влез се добиваат странски зборови 
 *(секој во посебен ред). За излез треба да се преведат овие зборови. Доколку не е познат преводот на зборот 
 *на излез се печати "/"

Влез. Прво се дава број N на поими кои ќе ги содржи речникот. Потоа во наредните N реда се дадени поимите,
      прв на македонски, потоа на англиски. Потоа следуваат зборови на англиски (секој збор во посебен ред),
      кои треба да се преведат на македонски. За означување на крај во редицата се дава зборот KRAJ

Излез. За секој од дадените зборови на англиски во посебен ред е даден преводот на зборот на македонски.
       Доколку не е познат преводот на зборот се печати /

Забелешка. Работете со хеш табела со отворени кофички. Сами треба да го одредите бројот на кофички и
           хеш функцијата.*/
public class Preveduvac {

	public static void main(String[] args) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		HashMap<String,String> map = new HashMap<String,String>();
		for(int i=0; i<N; i++) {
			String [] s = input.readLine().split(" ");
			map.put(s[1], s[0]);
		}
		
		String s = input.readLine();
		StringBuilder sb = new StringBuilder();
		
		while(!s.equals("KRAJ")) {
			if(map.containsKey(s)) {
				sb.append(map.get(s)+" ");
			}else {
				sb.append('/'+" ");
			}
			
			s = input.readLine();
		}
		
		String [] rez = sb.toString().split(" ");
		for(int i=0; i<rez.length; i++) {
			System.out.println(rez[i]);
		}
	}

}
