package lists;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;

@FunctionalInterface
interface OrderSort {

	public List<Number> exec(List<Number> nums);

}

public class SortOps {

	static OrderSort os = n -> {

		var map = new HashMap<Number, Integer>(n.size());
		n.forEach(o -> map.merge(o, 1, Integer::sum));
		// sort keys by ascending value.
		return map.entrySet().stream().sorted(comparingByValue()).map(Entry::getKey).collect(toList());

	};

	/**
	 * 
	 * @param lst
	 * @return
	 */
	static Optional<List<Number>> calcNumberFrequency(List<Number> lst) {

		return lst == null || lst.isEmpty() ? Optional.empty() : Optional.of(os.exec(lst));

	}

}
