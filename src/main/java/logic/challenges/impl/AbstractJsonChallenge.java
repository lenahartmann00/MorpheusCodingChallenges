package logic.challenges.impl;

import com.google.gson.GsonBuilder;
import java.io.IOException;
import logic.challenges.AbstractChallenge;
import logic.gson.JsonModel;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public abstract class AbstractJsonChallenge<C extends JsonModel, S extends JsonModel>
	extends AbstractChallenge<C, S> {

	private final Class<C> challengeClass;

	public AbstractJsonChallenge(Class<C> challengeClass, int challengeNumber) {
		super(challengeNumber);
		this.challengeClass = challengeClass;
	}

	@Override
	protected C receiveChallenge() throws IOException, InterruptedException {
		final String jsonChallenge = httpHelper.sendGET();
		return new GsonBuilder().create()
			.fromJson(jsonChallenge, challengeClass);
	}

	protected abstract S solveChallenge(C challenge);

}
