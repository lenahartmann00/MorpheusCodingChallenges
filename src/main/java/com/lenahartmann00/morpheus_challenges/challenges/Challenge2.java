package com.lenahartmann00.morpheus_challenges.challenges;

import com.lenahartmann00.morpheus_challenges.logic.challenge.impl.AbstractJsonChallenge;
import com.lenahartmann00.morpheus_challenges.logic.gson.lists.k.JsonListLongK;
import com.lenahartmann00.morpheus_challenges.logic.gson.tokens.JsonTokenInt;

public class Challenge2 extends AbstractJsonChallenge<JsonListLongK, JsonTokenInt> {

	public Challenge2() {
		super(JsonListLongK.class, 2);
	}

	@Override
	protected JsonTokenInt solveChallenge(JsonListLongK challenge) {
		final int index = challenge.getList().indexOf(challenge.getK());
		return new JsonTokenInt(index);
	}
}
