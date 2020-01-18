package challenges;

import helper.HttpHelper;
import java.io.IOException;

public class Challenge1 {

	public static void challengeOne() throws IOException, InterruptedException {
		final HttpHelper httpHelper = new HttpHelper(1);
		final String get = httpHelper.sendGET();
		final String solutionJson = String.format("{\"token\":\"%s\"}", get);
		System.out.println(httpHelper.sendPOST(solutionJson));
	}

}
