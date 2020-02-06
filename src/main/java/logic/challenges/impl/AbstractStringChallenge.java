package logic.challenges.impl;

import java.io.IOException;
import logic.challenges.AbstractChallenge;
import logic.gson.JsonModel;

/**
 * Represents a {@link AbstractChallenge} where the receiving challenge from the server is send as a
 * simple text.
 *
 * @param <S> model class that represents the JSON format that is send to the server as a POST
 *            request (solution) for the challenge
 */
public abstract class AbstractStringChallenge<S extends JsonModel>
	extends AbstractChallenge<String, S> {

	public AbstractStringChallenge(int challengeNumber) {
		super(challengeNumber);
	}

	/**
	 * Sends a GET request to the server (for receiving the challenge) and returns its response.
	 *
	 * @return response of the server
	 */
	@Override
	protected String receiveChallenge() throws IOException, InterruptedException {
		return httpHelper.sendGET();
	}

}
