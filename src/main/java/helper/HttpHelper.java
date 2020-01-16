package helper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpHelper {

	private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

	private final int challengeNumber;

	public HttpHelper(final int challengeNumber) {
		this.challengeNumber = challengeNumber;
	}

	public String sendGET() throws IOException, InterruptedException {
		final HttpRequest request = HttpRequest
			.newBuilder(URI.create(helper.UrlHelper.getChallengeUrl(challengeNumber)))
			.build();
		return HTTP_CLIENT.send(request, BodyHandlers.ofString())
			.body();
	}

	public String sendPOST(final String solution) throws IOException, InterruptedException {
		final String jsonSolution = String.format("{\"token\":\"%s\"}", solution);
		final HttpRequest request = HttpRequest
			.newBuilder(URI.create(helper.UrlHelper.getSolutionUrl(challengeNumber)))
			.POST(HttpRequest.BodyPublishers.ofString(jsonSolution))
			.build();
		return HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString())
			.body();
	}


}
