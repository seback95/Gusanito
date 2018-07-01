package gusanito;

public class Arista implements Comparable<Arista>{
private int nodoOrigen;
private int nodoDestino;
private int costo;
public Arista (int nodoOrigen, int nodoDestino, int costo ) {
	this.nodoOrigen = nodoOrigen;
	this.nodoDestino = nodoDestino;
	this.costo = costo;
}
@Override
public String toString() {
	return "Arista [nodoOrigen=" + (nodoOrigen + 1) + ", nodoDestino=" + (nodoDestino + 1) + ", peso=" + costo + "]";
}

public int getNodoOrigen() {
	return nodoOrigen;
}

public void setNodoOrigen(int nodoOrigen) {
	this.nodoOrigen = nodoOrigen;
}

public int getNodoDestino() {
	return nodoDestino;
}

public void setNodoDestino(int nodoDestino) {
	this.nodoDestino = nodoDestino;
}

public int getPeso() {
	return costo;
}

public void setPeso(int peso) {
	this.costo = peso;
}
public int compareTo(Arista o) {
	return this.costo - o.getPeso();
}
}
