package it.polito.tdp.imdb.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.imdb.db.ImdbDAO;

public class Model {
private ImdbDAO dao;
private Map<Integer,Director> idMap;
private SimpleWeightedGraph<Director, DefaultWeightedEdge> grafo;
private List<Director> nodes;
 public Model(){
	this.dao= new ImdbDAO();
	this.idMap= new HashMap<>();
	nodes= new ArrayList<>();
	
}

public void creaGrafo(int anno) {
	this.grafo= new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
	nodes= this.dao.loadAllNodes(anno, idMap);
	Graphs.addAllVertices(grafo, nodes);
	for(Director d1:nodes) {
		for(Director d2:nodes) {
			if(d1!=d2) {
				DirettoriAttori l1= dao.allDirettoriArtisti(anno, d1.getId());
				DirettoriAttori l2= dao.allDirettoriArtisti(anno, d1.getId());
			int i=0;
				for(String s1:l1.getAttori()) {
				for(String s2:l2.getAttori()) {
					if(s1.compareTo(s2)==0) {i++;}
					
				}
			}
				if (i>0) {Graphs.addEdge(grafo, d1, d2, i);}
			}
			
		}
	}
	return;
}



public List<Director> getNodes() {
	return nodes;
}
public List<Coppie> allEdges(int id){
	List<Coppie> coppie= new ArrayList<>();
	if(this.grafo!=null) {
		for( Director e: Graphs.neighborListOf(grafo,this.idMap.get(id) )) {
			double peso=grafo.getEdgeWeight(grafo.getEdge(e, this.idMap.get(id)));
			coppie.add(new Coppie(this.idMap.get(id), e, peso));
			
		}
		Collections.sort(coppie);
	}
	return coppie;
}

public ImdbDAO getDao() {
	return dao;
}

public Map<Integer, Director> getIdMap() {
	return idMap;
}

public SimpleWeightedGraph<Director, DefaultWeightedEdge> getGrafo() {
	return grafo;
}


}
