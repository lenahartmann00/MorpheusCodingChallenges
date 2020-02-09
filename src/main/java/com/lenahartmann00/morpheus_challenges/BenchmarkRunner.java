package com.lenahartmann00.morpheus_challenges;

import com.lenahartmann00.morpheus_challenges.challenges.Challenge2;
import org.openjdk.jmh.Main;

/**
 * Class that contains the main method and is used to start the challenge benchmarks. Starting the
 * benchmarks is done by calling the main method of {@link Main}.
 */
public class BenchmarkRunner {

	public static void main(String[] args) throws Exception {
		//new Challenge1().benchmarkChallenge();
		new Challenge2().benchmarkChallenge();
	}

}