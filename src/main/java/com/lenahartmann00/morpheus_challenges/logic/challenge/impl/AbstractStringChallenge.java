package com.lenahartmann00.morpheus_challenges.logic.challenge.impl;

import com.lenahartmann00.morpheus_challenges.logic.challenge.AbstractChallenge;
import com.lenahartmann00.morpheus_challenges.model.json.JsonModel;
import com.lenahartmann00.morpheus_challenges.logic.helper.HttpHelper;
import java.io.IOException;

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
		return HttpHelper.sendGET(challengeNumber);
	}

}
