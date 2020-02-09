package com.lenahartmann00.morpheus_challenges.logic.helper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Helper class that is responsible for sending http requests to the server.
 */
public final class HttpHelper {

	private static final Logger LOGGER = Logger.getLogger(HttpHelper.class.getName());
	private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

	private HttpHelper() {
	}

	/**
	 * Sends a GET request to the server for receiving the challenge data.
	 *
	 * @param challengeNumber number of the challenge
	 * @return response of the server
	 */
	public static String sendGET(final int challengeNumber)
		throws IOException, InterruptedException {
		final HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(UrlHelper.getChallengeUrl(challengeNumber)))
			.GET()
			.build();
		return sendRequest(request);
	}

	/**
	 * Sends a POST request to the server that holds the solution as a String. Note: the given
	 * String has to be in the expected format of the server.
	 *
	 * @param challengeNumber number of the challenge
	 * @param solutionJson    solution of the challenge that is formatted as the server expects it
	 *                        to be.
	 * @return response of the server
	 */
	public static String sendPOST(final int challengeNumber, final String solutionJson)
		throws IOException, InterruptedException {
		final HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(UrlHelper.getSolutionUrl(challengeNumber)))
			.POST(HttpRequest.BodyPublishers.ofString(solutionJson))
			.build();
		return sendRequest(request);
	}

	/**
	 * Send the given {@code request} to the server. If the {@code request} is interrupted it tries
	 * sending it again after waiting one second. If it is still interrupted it throws the {@link
	 * InterruptedException}.
	 *
	 * @param request request that should be send
	 * @return response of the server
	 * @throws IOException          when an I/O error occurred while sending
	 * @throws InterruptedException when the second request is also interrupted
	 */
	private static String sendRequest(final HttpRequest request)
		throws IOException, InterruptedException {
		try {
			return HTTP_CLIENT.send(request, BodyHandlers.ofString()).body();
		} catch (InterruptedException e) {
			LOGGER.log(Level.WARNING, "GET request for challenge {0} has been interrupted");
			Thread.currentThread().interrupt();
			// Wait a second, then try again. If still interrupted throw the exception.
			Thread.sleep(1000);
			return HTTP_CLIENT.send(request, BodyHandlers.ofString()).body();
		}
	}


}
