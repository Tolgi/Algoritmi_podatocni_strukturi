import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Дадена е двојно поврзана листа и со N јазли кои во себе содржат по еден природен број.
 * Треба да се подели листата на две резултантни листи.Во првата резултантна листа треба да се преместат
 * јазлите со непарни броеви, а во втората со парните.
 * Во првиот ред од влезот е даден бројот на јазли во листата, а потоа во вториот ред се 
 * дадени јазлите од кои е составена. На излез треба да се испечатат во еден ред јазлите на првата листа
 * со непарни броеви, а во вториот ред јазлите на втората листа со парните броеви.*/
class DLLNode<E> {
	protected E element;
	protected DLLNode<E> pred, succ;

	public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
		this.element = elem;
		this.pred = pred;
		this.succ = succ;
	}

 

	@Override
	public String toString() {
		return element.toString();
	}
}

class DLL<E> {
	private DLLNode<E> first, last;

	public DLL() {
		// Construct an empty SLL
		this.first = null;
		this.last = null;
	}

	public void deleteList() {
		first = null;
		last = null;
	}

	public int length() {
		int ret;
		if (first != null) {
			DLLNode<E> tmp = first;
			ret = 1;
			while (tmp.succ != null) {
				tmp = tmp.succ;
				ret++;
			}
			return ret;
		} else
			return 0;

	}

	public void insertFirst(E o) {
		DLLNode<E> ins = new DLLNode<E>(o, null, first);
		if (first == null)
			last = ins;
		else
			first.pred = ins;
			first = ins;
	}

	public void insertLast(E o) {
		if (first == null)
			insertFirst(o);
		else {
			DLLNode<E> ins = new DLLNode<E>(o, last, null);
			last.succ = ins;
			last = ins;
		}
	}

	public void insertAfter(E o, DLLNode<E> after) {
		if (after == last) {
			insertLast(o);
			return;
		}
		DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
		after.succ.pred = ins;
		after.succ = ins;
	}

	public void insertBefore(E o, DLLNode<E> before) {
		if (before == first) {
			insertFirst(o);
			return;
		}
		DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
		before.pred.succ = ins;
		before.pred = ins;
	}

	public E deleteFirst() {
		if (first != null) {
            if (first.succ == null){
				last = null;
                first = null;
            }
			else{
				DLLNode<E> tmp = first;
				first = first.succ;
				first.pred = null;
				return tmp.element;
			}			
		}  
		return null;
	}

	public E deleteLast() {
		if (first != null) {
			if (first.succ == null)
				return deleteFirst();
			else {
				DLLNode<E> tmp = last;
				last = last.pred;
				last.succ = null;
				return tmp.element;
			}
		}
		// else throw Exception
		return null;
	}

	@Override
	public String toString() {
		String ret = new String();
		if (first != null) {
			DLLNode<E> tmp = first;
			ret += tmp + "<->";
			while (tmp.succ != null) {
				tmp = tmp.succ;
				ret += tmp + "<->";
			}
		} else
			ret = "Prazna lista!!!";
		return ret;
	}

	public DLLNode<E> getFirst() {
		return first;
	}

	public DLLNode<E> getLast() {

		return last;
	}
public E delete(DLLNode<E> node) {
        if(node==first){
            deleteFirst();
            return node.element;
        }
        if(node==last){
            deleteLast();
            return node.element;
        }
       
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;
       
    }

}
public class RazdeliPoParnost {

	public static void main(String[] args) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		String [] s = input.readLine().split(" ");
		
		DLL<Integer> lista = new DLL<Integer>();
		for(int i=0; i<N; i++) {
			lista.insertLast(Integer.parseInt(s[i]));
		}
		
		DLLNode<Integer> node = lista.getFirst();
		DLL<Integer> lparni = new DLL<Integer>();
		//DLL<Integer> lneparni = new DLL<Integer>();

		while(node != null) {
			if(node.element % 2 == 0) {
				lparni.insertLast(node.element);
				lista.delete(node);
			}
			
			node = node.succ;
		}
		
		System.out.println(lista.toString());
		System.out.println(lparni.toString());

	}

}
