package gusanito;

import java.io.*;
import java.util.*;
public class RedComputadoras {
	
	
	public void resolver(Grafo g,String nameo,ArrayList<Pares> lp)
	{
		
		
		int []dist=new int[g.getCantN()];
		boolean band=true;
		int nodosProcesados=0;
		try {
			FileWriter fr=new FileWriter(nameo);
			PrintWriter pw=new PrintWriter(fr); 
		int nodoini=1;
		while(nodosProcesados < g.getCantN())
		{
			g.disjktra(nodoini,dist);
			
			for(int i=0;(i< lp.size())&&band;i++)
			{
				if(lp.get(i).getTiempo()!=dist[lp.get(i).getNodo()-1])
					band=false;
			}
			if(band)
			{
				pw.print(nodoini);
			}
			nodoini++;
			nodosProcesados++;
			band=true;
		}
		pw.close();
		}catch(Exception e ) {e.printStackTrace();}
	
		
	}

}
