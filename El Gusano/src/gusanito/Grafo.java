package gusanito;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Grafo {
	private int[][] grafo;
	private int cantN;

	public Grafo() {
		grafo = new int[300][300]; // declaro la matriz de adyacencia de un tamaño maximo de cantidad de
									// aristas(nunca va a haber mas nodos que aristas)
		for (int i = 0; i < 300; i++) {
			for (int j = 0; j < 300; j++)
				grafo[i][j] = 0;
		}
	}

	public int getGrafo(int f, int c) {
		return grafo[f][c];
	}

	public void setGrafo(int f, int c, int cost) {
		grafo[(f) - 1][(c) - 1] = cost;
	}

	public void cargarGrafoyListaPares(String name, ArrayList<Pares> listp) {
		// carga el grafo y devuelve la lista de pares (computado;hora de llegada del
		// virus) tambien cargo el cantN
		TreeSet<Integer> nodos = new TreeSet<Integer>();
		;
		try {
			File f = new File(name);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			String datos[];
			datos = linea.split(" ");
			int cantAristas = Integer.parseInt(datos[0]);
			int aristas = 0;
			while (aristas < cantAristas) {
				linea = br.readLine();
				datos = linea.split(" ");
				nodos.add(Integer.parseInt(datos[0]));
				nodos.add(Integer.parseInt(datos[2]));
				grafo[Integer.parseInt(datos[0]) - 1][Integer.parseInt(datos[2]) - 1] = Integer.parseInt(datos[1]);
				grafo[Integer.parseInt(datos[2]) - 1][Integer.parseInt(datos[0]) - 1] = Integer.parseInt(datos[1]);
				aristas++;
			}
			cantN = nodos.size();
			linea = br.readLine();
			while ((linea = br.readLine()) != null) {
				datos = linea.split(" ");
				listp.add(new Pares(Integer.parseInt(datos[0]), Integer.parseInt(datos[1])));
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

public void disjktra(int nodoini, int[] dist) {
	int nodosProcesados=0;
	Arista arista;
	TreeSet <Integer>marca=new TreeSet<Integer>();
	for(int i=0;i<cantN;i++)
	{
		dist[i]=9999;
	}
	dist[nodoini-1]=0;
	int actual=nodoini;
	int anterior=nodoini;
	ColaPrioridad c=new ColaPrioridad();
	agregarAristas(c,this,actual,anterior);
	int cost;
	while(nodosProcesados < cantN)
	{
		for(int i=0;i < cantN ; i++)
		{
			if((cost=grafo[actual-1][i])!=0)
			min(actual,i+1,dist,cost);
		}
		marca.add(actual);
		anterior=actual;
		actual=c.poll().getNodoDestino();
		if(marca.size()!=cantN)
		{
		while((marca.contains(actual)))
			actual=c.poll().getNodoDestino();
		}
		agregarAristas(c,this,actual,anterior);
		nodosProcesados++;
	}	
}

	public static void agregarAristas(ColaPrioridad c, Grafo g, int actual, int anterior) {
		int cost;

		for (int i = 0; i < g.getCantN(); i++) {
			if (i != anterior - 1) {
				if ((cost = g.getGrafo(actual - 1, i)) != 0)
					c.add(new Arista(actual, i + 1, cost));
			}
		}
	}

	public static void min(int actual, int nodo, int[] dist, int cost) {

		if (dist[nodo - 1] > (dist[actual - 1] + cost)) // ACTUALIZO
		{
			dist[nodo - 1] = dist[actual - 1] + cost;
		}
	}

	public int getCantN() {
		return cantN;
	}

	public void setCantN(int n) {
		cantN = n;
	}

}