package com.lenahartmann00.morpheus_challenges.logic.challenge.impl;

import com.google.gson.GsonBuilder;
import com.lenahartmann00.morpheus_challenges.logic.challenge.AbstractChallenge;
import com.lenahartmann00.morpheus_challenges.model.json.JsonModel;
import com.lenahartmann00.morpheus_challenges.logic.helper.HttpHelper;
import java.io.IOException;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * Represents a {@link AbstractChallenge} where the receiving challenge from the server is send in
 * JSON format.
 *
 * @param <C> model class that represents the JSON format that is received from the server when
 *            sending the GET request for the challenge.
 * @param <S> model class that represents the JSON object that is send to the server when sending
 *            the POST request (solution) for the challenge
 */
@State(Scope.Benchmark)
public abstract class AbstractJsonChallenge<C extends JsonModel, S extends JsonModel>
	extends AbstractChallenge<C, S> {

	private final Class<C> challengeClass;

	public AbstractJsonChallenge(Class<C> challengeClass, int challengeNumber) {
		super(challengeNumber);
		this.challengeClass = challengeClass;
	}

	/**
	 * Sends a GET request to the server (for receiving the challenge) and formats its json response
	 * to an object of type {@link C}. The response object represents the data of the given
	 * challenge.
	 *
	 * @return data object of the given challenge received by the server
	 */
	@Override
	protected C receiveChallenge() throws IOException, InterruptedException {
		final String jsonChallenge = HttpHelper.sendGET(challengeNumber);
		return new GsonBuilder().create()
			.fromJson(jsonChallenge, challengeClass);
	}

}
