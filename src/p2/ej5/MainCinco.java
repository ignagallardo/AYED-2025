package p2.ej5;
import p2.ej2.BinaryTree;
public class MainCinco {

	public static void main(String[] args) {
		
		BinaryTree<Integer> ab = new BinaryTree<Integer>(1);
		BinaryTree<Integer> hi = new BinaryTree<Integer>(3);
		BinaryTree<Integer> hd = new BinaryTree<Integer>(4);
		BinaryTree<Integer> nodo1 = new BinaryTree<Integer>(6);
		BinaryTree<Integer> nodo2 = new BinaryTree<Integer>(10);
		
		hi.addLeftChild(nodo1);
		hi.addRightChild(nodo2);
		ab.addLeftChild(hi);
		ab.addRightChild(hd);
		
	    ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario(ab);
	    System.out.println(prof.sumaElementosProfundidad(2));
	}
	
	
}
