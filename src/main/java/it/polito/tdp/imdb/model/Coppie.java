package it.polito.tdp.imdb.model;

public class Coppie  implements Comparable<Coppie>{
Director d1;
Director d2;
double i;
public Director getD1() {
	return d1;
}
public void setD1(Director d1) {
	this.d1 = d1;
}
public Director getD2() {
	return d2;
}
public void setD2(Director d2) {
	this.d2 = d2;
}
public double getI() {
	return i;
}
public void setI(int i) {
	this.i = i;
}
public Coppie(Director d1, Director d2, double i) {
	super();
	this.d1 = d1;
	this.d2 = d2;
	this.i = i;
}
@Override
public int compareTo(Coppie o) {
	
	return (int) (this.i-o.i);
}
@Override
public String toString() {
	return "Coppie [d2=" + d2 + ", i=" + i + "]";
}

}
