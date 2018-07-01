package gusanito;

import java.util.ArrayList;
public class main {

	public static void main(String[] args) {
		Grafo g=new Grafo();
		ArrayList<Pares> listp =new ArrayList<Pares>();
		g.cargarGrafoyListaPares("gusano.in", listp);
		RedComputadoras r=new RedComputadoras();
		r.resolver(g, "gusano2.out",listp);
	}

}
