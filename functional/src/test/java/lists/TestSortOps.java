package lists;

import static lists.SortOps.calcNumberFrequency;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class TestSortOps {
	List<Number> ints = List.of(1, 1, 1, 1, 4, 3, 3, 3, 3, 3, 5, 5);

	List<Number> dubs = List.of(3.9, 3.9, 1.0, 5.9, 1.0, 1.00);

	List<Number> floats = List.of(5.9f, 3.9f, 1.0f, 1.0f);

	@Test
	void with_int() {
		long st = System.nanoTime();
		var res = calcNumberFrequency(ints).orElseGet(Collections::emptyList);
		long durationInMs = TimeUnit.MILLISECONDS.convert(System.nanoTime() - st, TimeUnit.NANOSECONDS);
		System.out.println("Duration ms: " + durationInMs);
		assertEquals(List.of(4, 5, 1, 3), res);
	}

	@Test
	void with_completable_future() {

		long st = System.nanoTime();

		for (int i = 0; i < 10000; i++) {

			CompletableFuture.supplyAsync(() -> calcNumberFrequency(ints)).whenCompleteAsync((nums, th) -> {
				if (th == null) {
					assertEquals(List.of(4, 5, 1, 3), nums.get());
				} else {
					throw new RuntimeException(th);
				}
			}).toCompletableFuture().join();

		}

		long ms = System.nanoTime() - st;
		System.out.println("Average CompletableFuture Duration nano: " + ms / 10000);
	}

	@Test
	void with_single_int() {
		assertEquals(List.of(4), calcNumberFrequency(List.of(4)).get());
	}

	@Test
	void with_double() {
		assertEquals(List.of(5.9, 3.9, 1.0), calcNumberFrequency(dubs).get());
	}

	@Test
	void with_float() {
		assertEquals(List.of(5.9f, 3.9f, 1.0f), calcNumberFrequency(floats).get());
	}

	@Test
	void exp_empty() {
		assertEquals(Optional.empty(), calcNumberFrequency(List.of()));
	}

	@Test
	void exp_empty_given_null() {
		assertEquals(Optional.empty(), calcNumberFrequency(null));
	}

}
