package challenges;

import com.google.gson.GsonBuilder;
import helper.HttpHelper;
import java.io.IOException;
import java.util.ArrayList;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

public class Challenge2 {

	private static final HttpHelper HTTP_HELPER = new HttpHelper(2);

	private static class Challenge {

		long k;
		ArrayList<Long> list;

	}

	private static class Solution {

		int token;

		Solution(int solution) {
			this.token = solution;
		}

	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@Fork(value = 2, warmups = 2)
	@Warmup(iterations = 5)
	public static void challengeTwo() throws IOException, InterruptedException {
		final Challenge challenge = receiveChallenge();

		final Solution solution = solveChallenge(challenge);

		System.out.println(sendSolution(solution));
	}

	private static Challenge receiveChallenge() throws IOException, InterruptedException {
		final String jsonChallenge = HTTP_HELPER.sendGET();
		return new GsonBuilder().create()
			.fromJson(jsonChallenge, Challenge.class);
	}

	private static Solution solveChallenge(final Challenge challenge) {
		final int index = challenge.list.indexOf(challenge.k);
		return new Solution(index);
	}


	private static String sendSolution(final Solution solution)
		throws IOException, InterruptedException {
		final String json = new GsonBuilder().create().toJson(solution);
		return HTTP_HELPER.sendPOST(json);
	}

}
