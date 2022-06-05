package testEx;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

public class Test {

	public static Integer getFirstDuplicate(List<Integer> lst) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Integer element : lst) {
			if (!map.containsKey(element))
				map.put(element, 1);
			else {
				map.put(element, map.get(element) + 1);
			}
		}
		for (Integer element : lst) {
			if (map.get(element) >= 2)
				return element;
		}
		return null;
	}

	public static void method2(List<Integer> lst) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Integer element : lst) {
			if (!map.containsKey(element))
				map.put(element, 1);
			else {
				map.put(element, map.get(element) + 1);
			}
		}
		System.out.println(map);
	}

	public static void main(String[] args) {
		String a, b, c;
		a = new String("MyString");
		b = a;
		c = a + b;
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		System.out.println(System.identityHashCode(c));

		
	}
}