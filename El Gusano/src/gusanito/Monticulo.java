package gusanito;


public class Monticulo {
	
	private Arista vector[];
	private int  tope;
	public Monticulo()
	{
		this.vector = new Arista[300];
		this.tope=0;
	}


	public void poner  (Arista a) 
	{
		
		if(this.tope >30)
		{
			//aca tiraria una excepcion
			return ;
		}
		this.vector[++this.tope] = a;
		int aux= this.tope;
		while( ( aux/2 != 0 ) && (this.vector[aux].getPeso() < this.vector[aux/2].getPeso())  )
		{
			Arista remplazo = this.vector[aux];
			this.vector[aux] = this.vector[aux/2];
			this.vector[aux/2] = remplazo;
			aux/=2;
		}
		
	}

	public Arista sacar()
	{
		int i=1,menor;
		if(tope==0)
			return null;
		Arista aux=this.vector[i];
		this.vector[i]=this.vector[this.tope--];
		
		//CASO PARTICULAR DONDE ME QUEDO SOLO UN ELEMENTO EN EL MONTICULO
		if( i*2 > this.tope) 
			return aux;
		//CASO PARTICULAR DONDE ME QUEDARON DOS ELEMENTOS EN EL MONTICULO
		if( i*2+1 > this.tope) 
		{
			if(this.vector[i].getPeso() > this.vector[this.tope].getPeso())
			{
				Arista remplazo=this.vector[i];
				this.vector[i]=this.vector[this.tope];
				this.vector[this.tope]=remplazo;
			}
			return aux;
		}
		else
			menor = (this.vector[i*2].getPeso() > this.vector[i*2+1].getPeso() )? i*2+1 : i*2;
		while( (this.vector[i].getPeso() > this.vector[menor].getPeso()) && (menor < this.tope) )
		{
			Arista remplazo = this.vector[i];
			this.vector[i] = this.vector[menor];
			this.vector[menor] = remplazo;
			i = menor;
			if(i*2 < this.tope)
			{
				menor = (this.vector[i*2].getPeso() > this.vector[i*2+1].getPeso() )? i*2+1 : i*2;
			}
		}
		return aux;
	}

	public boolean isEmpty()
	{
		return this.tope==0;
	}

}
