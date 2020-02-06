package logic.challenges.impl;

import com.google.gson.GsonBuilder;
import java.io.IOException;
import logic.challenges.AbstractChallenge;
import logic.gson.JsonModel;
import logic.helper.HttpHelper;

/**
 * Represents a {@link AbstractChallenge} where the receiving challenge from the server is send in
 * JSON format.
 *
 * @param <C> model class that represents the JSON format that is received from the server when
 *            sending the GET request for the challenge.
 * @param <S> model class that represents the JSON object that is send to the server when sending
 *            the POST request (solution) for the challenge
 */
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

	/**
	 * This method should solve the challenge and return the solution in the given Json format.
	 *
	 * @param challenge received challenge object
	 * @return solution object that should be send to the server
	 */
	protected abstract S solveChallenge(C challenge);

}
