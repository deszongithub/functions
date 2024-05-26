package palindrome;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import static java.util.stream.Collectors.toList;

public class Palindrome<T> {

	private Palindrome() {
	}

	static UnaryOperator<String> randomise = s -> {

		List<Character> list = s.chars().mapToObj(c -> ((char) c)).collect(toList());
		Collections.shuffle(list);
		var sb = new StringBuilder(list.size());
		list.forEach(sb::append);

		var str = sb.toString();

		System.out.println(String.format("%s = random string", str));

		return str;

	};

	static Predicate<String> isPalindrome = s -> {

		var pal = s.replaceAll("\\s+", "").toLowerCase();
		var len = pal.length();

		if (len < 2)
			return false;

		int a = 0;
		int b = len - 1;
		int mid = len / 2;

		while (a < mid & pal.charAt(a) == pal.charAt(b)) {

			a++;
			b--;

		}
		return a == mid;
	};

	static BiPredicate<Set<String>, String> bip = (set, str) -> {
		return set.add(str) & isPalindrome.test(str);

	};

	static ToIntFunction<Set<String>> intFunc = set -> {
		return set.stream().map(s -> s.length()).max(Integer::max).get();

	};
}
