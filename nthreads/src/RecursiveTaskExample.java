import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class RecursiveSum extends RecursiveTask<Long> {
	static final int THRESHOLD = 10;
	List<Integer> list;
	int begin;
	int end;

	public RecursiveSum(List<Integer> list, int begin, int end) {
		this.list = list;
		this.begin = begin;
		this.end = end;
	}

	@Override
	protected Long compute() {
		final int size = end - begin;
		if (size < THRESHOLD) {
			long sum = 0;
			for (int i = begin; i < end; i++)
				sum += list.get(i);
			return sum;
		} else {
			final int middle = begin + ((end - begin) / 2);
			RecursiveSum left = new RecursiveSum(list, begin, middle);
			left.fork();
			RecursiveSum right = new RecursiveSum(list, middle, end);
			return right.compute() + left.join();
		}
	}
}

public class RecursiveTaskExample {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			int random = 1 + (int) (Math.random() * ((100 - 1) + 1));
			list.add(random);
		}

		ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		RecursiveSum recursiveSum = new RecursiveSum(list, 0, list.size());
		long recSum = forkJoinPool.invoke(recursiveSum);
		System.out.println("recursive-sum: " + recSum);
	}

}
