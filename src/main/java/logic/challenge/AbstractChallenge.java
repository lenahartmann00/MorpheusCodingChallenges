package logic.challenge;

import com.google.gson.GsonBuilder;
import java.io.IOException;
import logic.helper.HttpHelper;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@State(Scope.Benchmark)
public abstract class AbstractChallenge<C extends JsonChallenge, S extends JsonSolution> {

	private final Class<C> challengeClass;
	private final int challengeNumber;

	public AbstractChallenge(Class<C> challengeClass, int challengeNumber) {
		this.challengeClass = challengeClass;
		this.challengeNumber = challengeNumber;
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@Fork(value = 2, warmups = 2)
	@Warmup(iterations = 5)
	public void benchmarkChallenge() throws IOException, InterruptedException {
		final C challenge = receiveChallenge();
		final S solution = solveChallenge(challenge);
		sendAndPrintSolution(solution);
	}

	private C receiveChallenge() throws IOException, InterruptedException {
		final String jsonChallenge = new HttpHelper(challengeNumber).sendGET();
		return new GsonBuilder().create()
			.fromJson(jsonChallenge, challengeClass);
	}

	protected abstract S solveChallenge(C challenge);

	private void sendAndPrintSolution(final S solution) throws IOException, InterruptedException {
		final String json = new GsonBuilder().create().toJson(solution);
		System.out.println(new HttpHelper(challengeNumber).sendPOST(json));
	}

}
