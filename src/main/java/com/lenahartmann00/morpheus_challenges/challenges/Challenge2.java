package com.lenahartmann00.morpheus_challenges.challenges;

import com.lenahartmann00.morpheus_challenges.logic.challenge.impl.AbstractJsonChallenge;
import com.lenahartmann00.morpheus_challenges.model.json.lists.impl.JsonListKLong;
import com.lenahartmann00.morpheus_challenges.model.json.tokens.impl.JsonTokenInt;

public class Challenge2 extends AbstractJsonChallenge<JsonListKLong, JsonTokenInt> {

	public Challenge2() {
		super(JsonListKLong.class, 2);
	}

	@Override
	public JsonTokenInt solveChallenge(JsonListKLong challenge) {
		final int index = challenge.getList().indexOf(challenge.getK());
		return new JsonTokenInt(index);
	}
}
