package edu.kis.vh.nursery;

import edu.kis.vh.nursery.DefaultCountingOutRyhmer;
import edu.kis.vh.nursery.HanoiRyhmer;
import edu.kis.vh.nursery.factory.ArrayRyhmersFactory;
import edu.kis.vh.nursery.factory.DefaultRyhmersFactory;
import edu.kis.vh.nursery.factory.LinkedListRyhmersFactory;
import edu.kis.vh.nursery.factory.Ryhmersfactory;

class RyhmersDemo {

	public static void main(String[] args) {
		Ryhmersfactory factory = new DefaultRyhmersFactory();
		Ryhmersfactory arrayRyhmersFactory = new ArrayRyhmersFactory();
		Ryhmersfactory linkedListRyhmersFactory = new LinkedListRyhmersFactory();
		testRhymers(factory);
		testRhymers(arrayRyhmersFactory);
		testRhymers(linkedListRyhmersFactory);
 	}
	
 	private static void testRhymers(Ryhmersfactory factory) {
		
		DefaultCountingOutRyhmer[] ryhmers = { factory.getStandardRyhmer(), factory.getFalseRyhmer(),
				factory.getFIFORyhmer(), factory.getHanoiRyhmer()};
		
		for (int i = 1; i < 15; i++)
			for (int j = 0; j < 3; j++)
				ryhmers[j].countIn(i);
		
		java.util.Random rn = new java.util.Random();
		for (int i = 1; i < 15; i++)
			ryhmers[3].countIn(rn.nextInt(20));
		
		for (int i = 0; i < ryhmers.length; i++) {
			while (!ryhmers[i].callCheck())
				System.out.print(ryhmers[i].countOut() + "  ");
			System.out.println();
		}
		
		System.out.println("total rejected is "
				+ ((HanoiRyhmer) ryhmers[3]).reportRejected());
		
	}
	
}