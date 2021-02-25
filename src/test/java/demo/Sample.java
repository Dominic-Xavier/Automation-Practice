package demo;

import java.util.ArrayList;
import java.util.List;

public class Sample {

	public static void main(String[] args) {
		List<Integer> ls = Sample.show();
		System.out.println(ls.indexOf(80));
	}
	
	public static List<Integer> show() {
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(20);
		ls.add(50);
		List<Integer> lss = new ArrayList<Integer>(ls);
		lss.add(60);
		lss.add(80);
		return lss;
	}

}
