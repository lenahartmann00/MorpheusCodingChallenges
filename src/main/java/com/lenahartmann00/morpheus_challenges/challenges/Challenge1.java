package com.lenahartmann00.morpheus_challenges.challenges;

import com.lenahartmann00.morpheus_challenges.logic.challenge.impl.AbstractStringChallenge;
import com.lenahartmann00.morpheus_challenges.model.json.tokens.JsonToken;

public class Challenge1 extends AbstractStringChallenge<JsonToken<String>> {

	public Challenge1() {
		super(1);
	}

	@Override
	protected JsonToken<String> solveChallenge(String challenge) {
		return new JsonToken<>(challenge);
	}
}
