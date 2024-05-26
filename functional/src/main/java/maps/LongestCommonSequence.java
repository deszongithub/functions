package maps;

import static java.util.Arrays.asList;
import static java.util.Collections.min;
import static java.util.Map.Entry.comparingByValue;
import static java.util.Objects.isNull;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.LongStream;

public class LongestCommonSequence {

	BiPredicate<Set<String>, String> isMatched = (ks, str) -> {
		return ks.size() == ks.stream().filter(s -> s.contains(str)).count();

	};

	Predicate<String> isNullOrBlank = (str) -> {
		return isNull(str) || str.isBlank() ? Boolean.FALSE : Boolean.TRUE;

	};

	public Optional<String> exec(String[] in) {

		if (in == null || in.length < 2)
			return Optional.empty();

		// filter null values -> map.

		var map = asList(in).stream().filter(isNullOrBlank).collect(toMap(identity(), String::length));

		return map.size() < 2 ? Optional.empty() : execIt(map);

	}

	private Optional<String> execIt(Map<String, Integer> map) {

		var minLenKey = min(map.entrySet(), comparingByValue()).getKey();
		var keys = map.keySet();
		keys.remove(minLenKey);

		var sb = new StringBuilder();

		return minLenKey.chars().mapToObj(c -> (char) c).filter(k -> isMatched.test(keys, sb.append(k).toString()))
				.map(Object::toString).collect(reducing(String::concat)).or(Optional::empty);

	}

	public long findFact(int n) {

		return LongStream.rangeClosed(1, n).reduce(1, (x, y) -> x * y);

	}
}
