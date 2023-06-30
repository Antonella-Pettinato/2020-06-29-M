package it.polito.tdp.imdb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DirettoriAttori {
private int idRegista;
private List<String>  attori;
public DirettoriAttori(int idRegista, ArrayList<String> arrayList) {
	super();
	this.idRegista = idRegista;
	this.attori = arrayList;
}
public int getIdRegista() {
	return idRegista;
}
public void setIdRegista(int idRegista) {
	this.idRegista = idRegista;
}
public List<String> getAttori() {
	return attori;
}
public void setAttori(List<String> attori) {
	this.attori = attori;
}
@Override
public int hashCode() {
	return Objects.hash(idRegista);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	DirettoriAttori other = (DirettoriAttori) obj;
	return idRegista == other.idRegista;
}

}
