package challenges;

import logic.challenges.impl.AbstractJsonChallenge;
import logic.gson.lists.JsonListLong;
import logic.gson.tokens.JsonTokenInt;

public class Challenge2 extends AbstractJsonChallenge<JsonListLong, JsonTokenInt> {

	public Challenge2() {
		super(JsonListLong.class, 2);
	}

	@Override
	protected JsonTokenInt solveChallenge(JsonListLong challenge) {
		final int index = challenge.getList().indexOf(challenge.getK());
		return new JsonTokenInt(index);
	}
}
