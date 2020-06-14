package provaalgoritmo;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.FileNotFoundException;


/**
 *
 * @author franc
 */
public class ProvaAlgoritmo_Questão2 {
    static private String caminho = "C://Users//paulo//Documents//Prova1//file2.txt";
	
	public static void main(String... args) throws FileNotFoundException {
		
		int vertices = NumeroVertices();
		
		
		List<Integer>[] grafo = new ArrayList[vertices]; 
                
		carregarGrafoEmMemoria(grafo);
                
               
		print(grafo);
		
                
                nulo(grafo, vertices);
	
		
	}
	
        
        
	static int NumeroVertices() throws FileNotFoundException {
		int contador = 0;
		Scanner input = new Scanner (new FileReader(caminho));
		while (input.hasNext()) {
			contador++;
			input.nextLine();
		}
		return contador;
	}
	
        
	static void ligarGrafo(List[] grafo) {
		for (int i=0; i < grafo.length; i++) {
			grafo[i] = new ArrayList<Integer>();
		}
	}
	
        
	static void carregarGrafoEmMemoria(List[] grafo) throws FileNotFoundException {
		Scanner input = new Scanner (new FileReader(caminho));
		ligarGrafo(grafo);
		int contador = 0;
		while (input.hasNext()) {
			String line = input.nextLine();
			String[] vertices = line.split("\t");
			for (String vertice: vertices) {
				grafo[contador].add(vertice);
			}
			contador++;
		}
	}
	
	
	
        static void print(List[] grafo){
            for(int i=0;i<grafo.length;i++){
                System.out.print(grafo[i].get(0) + ": ");
                for(int j=1;j<grafo[i].size();j++){
                    System.out.print(grafo[i].get(j)+ " ");
                }
                System.out.print("(quantidade de arestas adjacentes: ");
                System.out.print(grafo[i].size()-1 + ")");
                
                System.out.println("");
                
            }
        
        }
        
        static void nulo(List[] grafo, int vertices){
            int arestas = 0;
            for (int i = 0; i < grafo.length; i++){
                arestas += grafo[i].size() - 1;
            }
            if (arestas == 0){
                System.out.println("\nEste Grafo é nulo");
            }
            
        }
        

}