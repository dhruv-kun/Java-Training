import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class Numbers implements Callable<Integer> {
	
	private int start;
	private int end;
	
	public Numbers(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public Integer call() throws Exception {
		return IntStream.range(start, end + 1).sum();
	}

}
