package logic.helper;

public final class UrlHelper {

	private static final String BASE_URL = "https://cc.the-morpheus.de";

	private UrlHelper(){}

	public static String getChallengeUrl(final int challengeNumber) {
		return BASE_URL + "/challenges/" + challengeNumber + "/";
	}

	public static String getSolutionUrl(final int challengeNumber) {
		return BASE_URL + "/solutions/" + challengeNumber + "/";
	}

	public static String getChallengeUrl(final int challengeNumber, final String additionalPath){
		return getChallengeUrl(challengeNumber) + additionalPath +"/";
	}

	public static String getSolutionUrl(final int challengeNumber, final String additionalPath){
		return getSolutionUrl(challengeNumber) + additionalPath + "/";
	}

}
