package challenges;

import java.util.ArrayList;
import logic.challenge.AbstractChallenge;
import logic.challenge.JsonChallenge;
import logic.challenge.JsonSolution;

class Challenge implements JsonChallenge {
	long k;
	ArrayList<Long> list;
}

class Solution implements JsonSolution {
	int token;

	public Solution(int token) {
		this.token = token;
	}
}

public class Challenge2 extends AbstractChallenge<Challenge, Solution> {

	public Challenge2() {
		super(Challenge.class, 2);
	}

	@Override
	protected Solution solveChallenge(Challenge challenge) {
		final int index = challenge.list.indexOf(challenge.k);
		return new Solution(index);
	}
}
