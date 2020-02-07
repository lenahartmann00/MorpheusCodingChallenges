package com.lenahartmann00.morpheus_challenges.challenges;

import com.lenahartmann00.morpheus_challenges.logic.gson.tokens.JsonTokenString;
import com.lenahartmann00.morpheus_challenges.logic.challenge.impl.AbstractStringChallenge;

public class Challenge1 extends AbstractStringChallenge<JsonTokenString> {

	public Challenge1() {
		super(1);
	}

	@Override
	protected JsonTokenString solveChallenge(final String challenge) {
		return new JsonTokenString(challenge);
	}
}
