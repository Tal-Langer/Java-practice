package graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ConnectionChecker<V> {
private GraphInterface<V> g;
	
	public ConnectionChecker(GraphInterface<V> g) {
		this.g=g;
	}
	
	public boolean check(V v1, V v2)  {
		Set<V> used_list = new HashSet<V>();
		used_list.add(v1);
		return neighbor_connected(v1,v2,used_list);
		
	
	
	
	}//check(V v1, V v2)
	
	private boolean neighbor_connected(V v1, V v2, Set<V> used_list) {
		
		if (v1.equals(v2))
			return true;
		
		Collection<V> neighbors = g.neighbours(v1);

		for (V v : neighbors) {
			if (!(used_list.contains(v))) {
				used_list.add(v);
				if(neighbor_connected(v, v2, used_list))
					return true;
			}
		}
		return false;
	}
}//class
