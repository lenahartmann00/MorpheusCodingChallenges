package challenges;

import logic.gson.tokens.JsonTokenString;
import logic.challenges.impl.AbstractStringChallenge;

public class Challenge1 extends AbstractStringChallenge<JsonTokenString> {

	public Challenge1() {
		super(1);
	}

	@Override
	protected JsonTokenString solveChallenge(final String challenge) {
		return new JsonTokenString(challenge);
	}
}
