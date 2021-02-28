package equiv;

import java.util.ArrayList;
import java.util.List;

public class Equiv<E> {
	List<ArrayList> list_arrylist;

	public Equiv() {
		list_arrylist = new ArrayList<ArrayList>();
	}

	public void add(E e1, E e2) {
		int index_of_e1 = find(e1);
		int index_of_e2 = find(e2);

		if (e1.equals(e2))// case that e1 and e2 are equal
			return;

		/*
		 * e1 and e2 does not belong to any Equiv list , we will make a new one for them
		 */
		if (index_of_e1 == -1 && index_of_e2 == -1) {

			ArrayList<E> new_Equiv = new ArrayList<>();
			new_Equiv.add(e1);
			new_Equiv.add(e2);
			list_arrylist.add(new_Equiv);
			return;
		}
		/* case that only e2 exist */
		if (index_of_e1 == -1 && index_of_e2 != -1) {

			list_arrylist.get(index_of_e2).add(e1);
			// add e1 to the list of e2
			return;
		}
		/* case that only e1 exist */
		if (index_of_e1 != -1 && index_of_e2 == -1) {

			list_arrylist.get(index_of_e1).add(e2);
			// add e2 to the list of e1
			return;
		}
		/* case that both e1 and e2 exist */
		if (index_of_e1 != -1 && index_of_e2 != -1) {

			list_arrylist.get(index_of_e1).addAll(list_arrylist.get(index_of_e2));
			// add list of e2 to the list of e1
			list_arrylist.get(index_of_e2).clear();
			// the list of e2 have been deleted from list_arrylist
			return;
		}
	}

	/* find return index of e1 in list_arrylist , returns -1 if does not exist */
	private int find(E e1) {
		for (int i = 0; i < list_arrylist.size(); i++) {
			/* find the index of the list that contains e1 */
			if ((list_arrylist.get(i)).contains(e1))
				return i;// return index of list that contains e1
		}
		return -1;// e1 was not found
	}

	/* return true if e1 and e2 in the same list */
	public boolean are(E e1, E e2) {
		return find(e1) == find(e2);
	}

}// class
