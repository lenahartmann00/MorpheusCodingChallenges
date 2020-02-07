package com.lenahartmann00.morpheus_challenges.logic.helper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * Helper class that is responsible for sending http requests to the server.
 */
public class HttpHelper {

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
			.build();
		return HTTP_CLIENT.send(request, BodyHandlers.ofString())
			.body();
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
		return HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString())
			.body();
	}


}
