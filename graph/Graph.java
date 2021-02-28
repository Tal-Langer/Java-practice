package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Graph<V> {
	private Set<V> vertices = new HashSet<V>();
	private Map<V, Set<V>> edges= new HashMap<V,Set<V>>();
	

	
	public void addVertex(V v) throws GraphException{
		Set<V> set;
		if(vertices.contains(v))
			throw new GraphException("Vertex is already part of a graph.");
		vertices.add(v);
		set= new HashSet<V>();
		edges.put(v, set);
	}
	
	public void addEdge(V v1, V v2) throws GraphException{
		if (!(vertices.contains(v1) && vertices.contains(v2)) || hasEdge(v1, v2)) {
			throw new GraphException("Can't add edge");}
		/*add Edge to both v1 and v2*/
		(edges.get(v1)).add(v2);
		(edges.get(v2)).add(v1);
	}
	public boolean hasEdge(V v1, V v2) {

		if (!(vertices.contains(v1) && vertices.contains(v2)))
			return false;
		if (!(edges.get(v1).contains(v2) || edges.get(v2).contains(v2))) {
			return false;
		}
		return true;
	}
	
	
	public boolean connected(V v1, V v2) throws GraphException{
		Set<V> used_list = new HashSet<V>();
		used_list.add(v1);
		if (!(vertices.contains(v1) && vertices.contains(v2)))
			throw new GraphException("Can't add edge");
		if(v1.equals(v2))
			return true;
		
		 for (V neighbor : edges.get(v1)) {
				if (v2.equals(neighbor))
					return true;
				used_list.add(neighbor);
				if (neighbor_connected(neighbor, v2, used_list))
					return true;
			}
			return false;
		}
		
	
	private boolean neighbor_connected(V v1, V v2, Set<V> used_list) throws GraphException{
		
		if (edges.get(v1) == null)// v1 has no nighbors
			return false;
		for (V v : edges.get(v1)) {
			if (!(used_list.contains(v))) 
				if (v.equals(v2))
					return true;
			if (!used_list.contains(v)){
				used_list.add(v);
				return neighbor_connected(v, v2, used_list);
			}
		}//for
		return false;
	}
		
	
}//class
