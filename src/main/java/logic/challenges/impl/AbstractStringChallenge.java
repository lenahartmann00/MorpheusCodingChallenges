package logic.challenges.impl;

import java.io.IOException;
import logic.challenges.AbstractChallenge;
import logic.gson.JsonModel;

public abstract class AbstractStringChallenge<S extends JsonModel>
	extends AbstractChallenge<String, S> {

	public AbstractStringChallenge(int challengeNumber) {
		super(challengeNumber);
	}

	@Override
	protected String receiveChallenge() throws IOException, InterruptedException {
		return httpHelper.sendGET();
	}

}
