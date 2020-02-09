package com.lenahartmann00.morpheus_challenges.logic.challenge;

import com.google.gson.GsonBuilder;
import com.lenahartmann00.morpheus_challenges.logic.helper.HttpHelper;
import com.lenahartmann00.morpheus_challenges.logic.helper.PropertiesHelper;
import com.lenahartmann00.morpheus_challenges.model.json.JsonModel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents and executes the steps that have to be done every time when solving a
 * challenge.<br> Those steps are:
 * <ol>
 *     <li>receiving the challenge data (GET request) {@link #receiveChallenge()}</li>
 *     <li>solving the challenge {@link #solveChallenge(Object)}</li>
 *     <li>sending the solution as a POST request to the server and returning the response
 *         {@link #checkSolution(JsonModel)}</li>
 * </ol>
 * The method responsible for executing those steps is {@link #benchmarkChallenge()}.
 *
 * @param <C> represents the format of the server response when sending the GET request for
 *            receiving the challenge
 * @param <S> class of the solution represents the json format that is send to the server
 */
public abstract class AbstractChallenge<C, S extends JsonModel> {

	private static final Logger LOGGER = Logger.getLogger(AbstractChallenge.class.getName());

	protected final int challengeNumber;
	private PropertiesHelper propertiesHelper;

	/**
	 * The number of the current challenge. It is used to reference the correct server url.
	 *
	 * @param challengeNumber number of the current challenge
	 */
	public AbstractChallenge(int challengeNumber) {
		this.challengeNumber = challengeNumber;
		this.propertiesHelper = PropertiesHelper.getInstance();
	}

	/**
	 * Method that executes the steps for solving the challenge such as sending the http requests
	 * and solving the challenge. Also calculates and prints out the average time of how long {@link
	 * #solveChallenge(Object)} took.
	 */
	public void benchmarkChallenge() throws IOException, InterruptedException {
		final int benchmarkRounds = getBenchmarkRounds();
		System.out.println(String
			.format("Starting benchmark of challenge %s...", challengeNumber));

		long measuredTime = 0;
		for (int i = 0; i < benchmarkRounds; i++) {
			LOGGER.log(Level.INFO, "Round {0}", i);
			final C challenge = receiveChallenge();

			final long start = System.nanoTime();
			final S solution = solveChallenge(challenge);
			final long finish = System.nanoTime();

			checkSolution(solution);
			measuredTime += finish - start;

			Thread.sleep(250); // relieve pressure on the server
		}

		final long averageTime = measuredTime / benchmarkRounds;

		System.out.println(String
			.format("Benchmarking of challenge %s took %s ns / %s ms on average", challengeNumber,
				averageTime , averageTime / 1e+6));
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
	 * Returns the benchmark rounds set in the properties file ({@code benchmark.rounds}). If those
	 * are not set it returns the default value 100.
	 *
	 * @return number of times the benchmark should be executed
	 */
	private int getBenchmarkRounds() {
		return Integer
			.parseInt(propertiesHelper.getProperties().getProperty("benchmark.rounds", "100"));
	}

	/**
	 * Sends a POST request to the server holding the solution in the requested json format.
	 *
	 * @param solution solution data object that represents the requested json format
	 */
	private void checkSolution(final S solution) throws IOException, InterruptedException {
		final String json = new GsonBuilder().create().toJson(solution);
		final String response = HttpHelper.sendPOST(challengeNumber, json);
		checkResponse(response);
	}

	/**
	 * Checks whether the solution sent to the server was right. If not throws an {@link
	 * IllegalStateException}.
	 *
	 * @param response response from the server (POST request)
	 */
	private void checkResponse(final String response) {
		if (!response.contains("Success")) {
			throw new IllegalStateException(
				String.format("The given solution for challenge %s is wrong",
					challengeNumber));
		}
	}
}
