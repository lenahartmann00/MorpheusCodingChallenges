package challenges;

import logic.helper.HttpHelper;
import java.io.IOException;

/**
 * Hint: This challenge does not use the @link{ChallengeAbstract.class} since the Get Response from
 * the server is a plain number and not in json format on which the abstraction is based on
 */
public class Challenge1 {

	public static void challengeOne() throws IOException, InterruptedException {
		final HttpHelper httpHelper = new HttpHelper(1);
		final String get = httpHelper.sendGET();
		final String solutionJson = String.format("{\"token\":\"%s\"}", get);
		System.out.println(httpHelper.sendPOST(solutionJson));
	}

}
