package challenges;

import helper.HttpHelper;
import java.io.IOException;
import org.openjdk.jmh.annotations.Benchmark;

public class Challenge1 {

	@Benchmark
	public static void challengeOne() throws IOException, InterruptedException {
		final HttpHelper httpHelper = new HttpHelper(1);
		final String get = httpHelper.sendGET();
		System.out.println(httpHelper.sendPOST(get));
		Thread.sleep(1000L);
	}

}
