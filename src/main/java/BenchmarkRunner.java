import challenges.Challenge2;
import org.openjdk.jmh.Main;

public class BenchmarkRunner {

	public static void main(String[] args) throws Exception {
		Main.main(args);
		new Challenge2().benchmarkChallenge();
	}

}
