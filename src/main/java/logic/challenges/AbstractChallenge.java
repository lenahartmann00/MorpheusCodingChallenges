package logic.challenges;

import com.google.gson.GsonBuilder;
import java.io.IOException;
import logic.gson.JsonModel;
import logic.helper.HttpHelper;

public abstract class AbstractChallenge <C, S extends JsonModel> {

	protected final HttpHelper httpHelper;

	public AbstractChallenge(int challengeNumber) {
		this.httpHelper = new HttpHelper(challengeNumber);
	}

	//TODO find a way to benchmark the challenges
	public String benchmarkChallenge() throws IOException, InterruptedException {
		final C challenge = receiveChallenge();
		final S solution = solveChallenge(challenge);
		return getResponse(solution);
	}

	protected abstract C receiveChallenge() throws IOException, InterruptedException;

	protected abstract S solveChallenge(C challenge);

	private String getResponse(final S solution) throws IOException, InterruptedException {
		final String json = new GsonBuilder().create().toJson(solution);
		return httpHelper.sendPOST(json);
	}
}
