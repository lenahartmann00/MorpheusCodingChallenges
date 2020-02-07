package com.lenahartmann00.morpheus_challenges;

import com.lenahartmann00.morpheus_challenges.challenges.Challenge1;
import com.lenahartmann00.morpheus_challenges.challenges.Challenge2;
import org.openjdk.jmh.Main;

/**
 * Class that contains the main method and is used to start the challenge benchmarks.
 * Starting the benchmarks is done by calling the main method of {@link Main}.
 */
public class BenchmarkRunner {

	public static void main(String[] args) throws Exception {
//		Main.main(args);
		final Challenge1 challenge1 = new Challenge1();
		System.out.println(challenge1.benchmarkChallenge());
		final Challenge2 challenge2 = new Challenge2();
		System.out.println(challenge2.benchmarkChallenge());
	}

}