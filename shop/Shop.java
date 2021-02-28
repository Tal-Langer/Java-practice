package shop;

import java.util.List;
import java.util.ArrayList;

public class Shop {
	List<Instrument> elements = new ArrayList<Instrument>();

	public void add(Instrument i) {
		elements.add(i);
	}

	public Instrument get(int serial) {

		int i = 0;
		while (i < elements.size()) {

			if (serial == elements.get(i).getSerial())

				return elements.get(i);
			i++;
		}
		return null;

	}

	public List<Integer> allSerials() {

		List<Integer> s = new ArrayList<>();
		for (Instrument i : elements)
			s.add(i.getSerial());
		return s;

	}

	public List<Integer> guitarsOfType(Type t) {// return the serial number of the guitar

		List<Integer> g = new ArrayList<>();

		for (Instrument i : elements) {
			if (i instanceof Guitar)// check if its Guitar then check if he's equal
				if (t.equals(((Guitar) i).getType()))
					g.add(i.getSerial());
		}
		return g;

	}

	public void sell(int serial) throws MusicShopException {

		int remove = 0;
		for (Instrument i : elements) {

			if (serial == i.getSerial()) {// id the same serial number
				if (i instanceof Guitar) {// if it id guitar
					int count = 0;
					for (Instrument j : elements) {
						if (j instanceof Guitar)
							count++;// if it is guitar count++
					}

					if (count == 1)
						throw new MusicShopException("there is only one guitar in the shop");
				}

				elements.remove(i);
				remove = 1;
				break;
			}

		}
		if (remove == 0)
			throw new MusicShopException("no serial number");

	}

	public int sellAll(int[] serials) {
		int count = 0;

		int i = 0;
		for (i = 0; i < serials.length; i++) {
			try {

				sell(serials[i]);// sells the instrument

			} catch (MusicShopException e) {
				System.out.println(e.getMessage());
				count++;
			}

		}

		return count;
	}

}
