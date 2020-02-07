package com.lenahartmann00.morpheus_challenges.challenges;

import com.lenahartmann00.morpheus_challenges.logic.challenge.impl.AbstractJsonChallenge;
import com.lenahartmann00.morpheus_challenges.logic.gson.lists.impl.JsonListKLong;
import com.lenahartmann00.morpheus_challenges.logic.gson.tokens.impl.JsonTokenInt;

public class Challenge2 extends AbstractJsonChallenge<JsonListKLong, JsonTokenInt> {

	public Challenge2() {
		super(JsonListKLong.class, 2);
	}

	@Override
	protected JsonTokenInt solveChallenge(JsonListKLong challenge) {
		final int index = challenge.getList().indexOf(challenge.getK());
		return new JsonTokenInt(index);
	}
}
