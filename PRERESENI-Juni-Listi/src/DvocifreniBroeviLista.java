import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Дадена е двострана поврзана листа чии што јазли содржат по една цифра. 
 * Во дадената листа треба да се пронајдат сите скриени двоцифрени броеви поголеми од 50 
 * (двоцифрен број се формира од два последователни јазли), да се избришат од листата и на 
 * нивно место да фигурира јазол со добиениот двоцифрен број. Листата се процесира еднаш од 
 * лево кон десно и кога ќе се најде ваков пар од јазли веднаш се заменува со јазол што го содржи
 * двоцифрениот број креиран од парот на јазли.
 
Влез: Во првиот ред од влезот е даден бројот на јазли на влезната листа, потоа во вториот ред се 
      дадени цифрите од кои се составени јазлите по редослед разделени со празно место.
 
Излез: На излез треба да се испечатат јазлите на резултантната листа.
 
Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.
Забелешка: При реализација на задачите не е дозволено да се користат помошни структури како 
           низи или сл. На располагање од структурите има само ЕДНА двострано поврзана листа.
Пример: Од листата 4 5 4 6 6 7 се добива листата 4 54 66 7*/
public class DvocifreniBroeviLista {

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		String [] s = input.readLine().split(" ");
		
		DLL<Integer> lista = new DLL<Integer>();
		for(int i=0; i<N; i++) {
			lista.insertLast(Integer.parseInt(s[i]));
		}
		
		DLLNode<Integer>node = lista.getFirst();
		int br = 0;
		
		while(node.succ != null) {
			br = node.element*10 + node.succ.element;
			if(br > 50) {
				node.element = br;
				lista.delete(node.succ);
			}
			
			if(node.succ != null)
				node = node.succ;
			else
				break;
		}
		
		
		System.out.println(lista.toString());

	} 

}
