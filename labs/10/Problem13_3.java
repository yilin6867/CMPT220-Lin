import java.util.ArrayList;

public class Problem13_3 {
	public static void main(String[] args) {
		ArrayList<Number> list = new ArrayList<Number>();
		list.add(1);
		list.add(5);
		list.add(9);
		list.add(1);
		list.add(0);
		list.add(-1.1);
		sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	public static ArrayList<Number> sort(ArrayList<Number> list) {
		Number num = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (num.doubleValue() > list.get(i).doubleValue()) {
				list.remove(num);
				list.add(num);
				i = 0;
			}
			num = list.get(i);
		}
		return list;
	}
}
