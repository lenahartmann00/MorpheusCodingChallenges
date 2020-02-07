package com.lenahartmann00.morpheus_challenges.logic.helper;

/**
 * Helper class that holds the urls of the server.
 */
public final class UrlHelper {

	private static final String BASE_URL = "https://cc.the-morpheus.de";

	private UrlHelper() {
	}

	public static String getChallengeUrl(final int challengeNumber) {
		return BASE_URL + "/challenges/" + challengeNumber + "/";
	}

	public static String getSolutionUrl(final int challengeNumber) {
		return BASE_URL + "/solutions/" + challengeNumber + "/";
	}

}
