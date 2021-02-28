package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Maze implements GraphInterface<Place> {

	private Place start, end, maze[][];
	private int size;

	public Maze(int size, int startx, int starty, int endx, int endy) {
		try {
		start = new Place(startx, starty, size);
		end = new Place(endx, endy, size);
		this.size = size;

		maze = new Place[size][size];
		maze[startx][starty] = start;
		maze[endx][endy] = end;
		} catch (IllegalArgumentException e) { 
			throw new IllegalArgumentException();
		}
	}

	public boolean addWall(int x, int y) {
		Place wall = new Place(x, y, size);
		try {
		if (maze[x][y] != null)
			return false;
		maze[x][y] = wall;
		return true;
		} catch (Exception e) { 
			throw new IllegalArgumentException();
		}
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (maze[i][j] == null)
					str += ".";
				else if (maze[i][j].equals(start))
					str += "S";
				else if (maze[i][j].equals(end))
					str += "E";
				else if (maze[i][j] != null)// wall
					str += "@";

			}
			str += "\n";// new line

		}
		return str;
	}

	public boolean isSolvable() {
		Graph<Place> graph = new Graph<Place>();
		try {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					Place p = maze[i][j];
					if (p == null || p.equals(start) || p.equals(end))
						/* its not a wall add it to Vertex */
						graph.addVertex(new Place(i, j, size));
				}
			}

			/* add Edges */

			for (int i = 0; i < size; i++)
				for (int j = 0; j < size; j++) {
					Place p = maze[i][j];
					if (p == null || p.equals(start) || p.equals(end))
					/* its not a wall check for neighbors */
					{

						if (i > 0 && !graph.hasEdge(new Place(i, j, size), new Place(i - 1, j, size)))// not first row , check up
						{
							Place neighbor = maze[i - 1][j];
							if (neighbor == null || neighbor.equals(start) || neighbor.equals(end))
								/* its not a wall add it to Edge */
								graph.addEdge(new Place(i, j, size), new Place(i - 1, j, size));
						}

						if (i < size - 1 && !graph.hasEdge(new Place(i, j, size), new Place(i + 1, j, size)))// not last row , check down
						{
							Place neighbor = maze[i + 1][j];
							if (neighbor == null || neighbor.equals(start) || neighbor.equals(end))
								/* its not a wall add it to Edge */
								graph.addEdge(new Place(i, j, size), new Place(i + 1, j, size));
						}

						if (j > 0 && !graph.hasEdge(new Place(i, j, size), new Place(i, j - 1, size)))// not first col , check left
						{
							Place neighbor = maze[i][j - 1];
							if (neighbor == null || neighbor.equals(start) || neighbor.equals(end))
								/* its not a wall add it to Edge */
								graph.addEdge(new Place(i, j, size), new Place(i, j - 1, size));
						}

						if (j < size - 1 && !graph.hasEdge(new Place(i, j, size), new Place(i, j + 1, size)))// not last col , check right
						{
							Place neighbor = maze[i][j + 1];
							if (neighbor == null || neighbor.equals(start) || neighbor.equals(end))
								/* its not a wall add it to Edge */
								graph.addEdge(new Place(i, j, size), new Place(i, j + 1, size));
						}

					} // if neighbor (not wall)
				} // for
		// try
			/*check if solvable*/                    
			if(graph.connected(start, end))
					return true;
		 
		}
		catch (GraphException e) {
			e.printStackTrace();
		}
		return false;
		
		

	}// isSolvable()

	

	@Override
	public Collection<Place> neighbours(Place p) { 
		List<Place> neighbors = new ArrayList<Place>();

		if (p.getX() != 0)
			if (maze[p.getX() - 1][p.getY()] == null || maze[p.getX() - 1][p.getY()] == start
					|| maze[p.getX() - 1][p.getY()] == end)
				neighbors.add(new Place(p.getX() - 1, p.getY(), size));

		if (p.getX() != size - 1)
			if (maze[p.getX() + 1][p.getY()] == null || maze[p.getX() + 1][p.getY()] == start
					|| maze[p.getX() + 1][p.getY()] == end)
				neighbors.add(new Place(p.getX() + 1, p.getY(), size));

		if (p.getY() != size - 1)
			if (maze[p.getX()][p.getY() + 1] == null || maze[p.getX()][p.getY() + 1] == start
					|| maze[p.getX()][p.getY() + 1] == end)
				neighbors.add(new Place(p.getX(), p.getY() + 1, size));

		if (p.getY() != 0)
			if (maze[p.getX()][p.getY() - 1] == null || maze[p.getX()][p.getY() - 1] == start
					|| maze[p.getX()][p.getY() - 1] == end)
				neighbors.add(new Place(p.getX(), p.getY() - 1, size));

		return neighbors;
	}
	
	
	

}// class
