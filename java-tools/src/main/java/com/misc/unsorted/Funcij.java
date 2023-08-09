package com.misc.unsorted;

import java.math.BigInteger;

public class Funcij {

	public static BigInteger sumin(int n) {
		if (n == 1) {
			return BigInteger.ONE;
		} else {
			BigInteger sum = BigInteger.valueOf(0);

			for (int i = 1; i <= n - 1; i++) {
				sum = sum.add(BigInteger.valueOf(2L * i));
			}
			sum = sum.add(BigInteger.valueOf(n));
			return sum.add(sumin(n - 1));
		}
	}

	public static BigInteger sumax(int n) {
		if (n == 1) {
			return BigInteger.ONE;
		} else {
			BigInteger sum = BigInteger.ZERO;
			sum = sum.add(BigInteger.valueOf(n * (2L * n - 1)));
			System.out.println(sum);
			return sum.add(sumax(n - 1));
		}
	}

	public static BigInteger sumsum(int n) {
		return BigInteger.ZERO;
	}
}
