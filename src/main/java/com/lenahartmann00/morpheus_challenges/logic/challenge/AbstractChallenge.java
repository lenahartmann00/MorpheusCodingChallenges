package com.lenahartmann00.morpheus_challenges.logic.challenge;

import com.google.gson.GsonBuilder;
import java.io.IOException;
import com.lenahartmann00.morpheus_challenges.logic.gson.JsonModel;
import com.lenahartmann00.morpheus_challenges.logic.helper.HttpHelper;

/**
 * This class represents and executes the steps that have to be done every time when solving a
 * challenge.<br> Those steps are:
 * <ol>
 *     <li>receiving the challenge data (GET request) {@link #receiveChallenge()}</li>
 *     <li>solving the challenge {@link #solveChallenge(Object)}</li>
 *     <li>sending the solution as a POST request to the server and returning the response
 *         {@link #sendSolution(JsonModel)}</li>
 * </ol>
 * The method responsible for executing those steps is {@link #benchmarkChallenge()}.
 *
 * @param <C> represents the format of the server response when sending the GET request for
 *            receiving the challenge
 * @param <S> class of the solution represents the json format that is send to the server
 */
public abstract class AbstractChallenge<C, S extends JsonModel> {

	protected final int challengeNumber;

	/**
	 * The number of the current challenge. It is used to reference the correct server url.
	 *
	 * @param challengeNumber number of the current challenge
	 */
	public AbstractChallenge(int challengeNumber) {
		this.challengeNumber = challengeNumber;
	}

	/**
	 * Method that executes the steps for solving the challenge solves such as sending the Http
	 * requests and solving the challenge
	 *
	 * @return response of the server that tells whether the solution was correct or not
	 */
	public String benchmarkChallenge() throws IOException, InterruptedException {
		final C challenge = receiveChallenge();
		final S solution = solveChallenge(challenge);
		return sendSolution(solution);
	}

	/**
	 * This method should send a GET request to the server and return its response.
	 *
	 * @return response of the server
	 */
	protected abstract C receiveChallenge() throws IOException, InterruptedException;

	/**
	 * Core function that solves the given {@code challenge} and returns its solution {@link S}. It
	 * is implement for each challenge itself.
	 *
	 * @param challenge data object that holds the challenge data.
	 * @return solution object in the expected format that is used to send a POST request to the
	 * server.
	 */
	protected abstract S solveChallenge(C challenge);

	/**
	 * Sends a POST request to the server holding the solution in the requested json format.
	 *
	 * @param solution solution data object that represents the requested json format
	 * @return response of the server
	 */
	private String sendSolution(final S solution) throws IOException, InterruptedException {
		final String json = new GsonBuilder().create().toJson(solution);
		return HttpHelper.sendPOST(challengeNumber, json);
	}
}
