package gusanito;

public class ColaPrioridad {

	private Monticulo rickAndMonty;
	
	public ColaPrioridad(){
	this.rickAndMonty = new Monticulo();
	}
	
	public void add( Arista a )
	{
		this.rickAndMonty.poner(a);
	}
	
	public Arista poll()
	{
		return this.rickAndMonty.sacar();
	}
	
	public boolean isEmpty()
	{
		return this.rickAndMonty.isEmpty();
	}

}
