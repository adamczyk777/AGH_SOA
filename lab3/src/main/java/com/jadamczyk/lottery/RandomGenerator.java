package com.jadamczyk.lottery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named("RandomGenerator")
@ApplicationScoped
public class RandomGenerator {
    private static int lotteryOutcome = (int) (Math.random() * 5 + 1);

    public static void setLotteryOutcome(int lotteryOutcome) {
        RandomGenerator.lotteryOutcome = lotteryOutcome;
    }

    public static int getLotteryOutcome() {
        return lotteryOutcome;
    }

    private static Map<Integer, Integer> visitCounts = new HashMap<>();

    public static void setVisitCounts(Map<Integer, Integer> visitCounts) {
        RandomGenerator.visitCounts = visitCounts;
    }

    public static Map<Integer, Integer> getVisitCounts() {
        return visitCounts;
    }

    private void random() {
        lotteryOutcome = (int) (Math.random() * 5 + 1);
    }

    private int recordVisit(Integer i) {
        visitCounts.put(i, visitCounts.getOrDefault(i, 0) + 1);
        return visitCounts.getOrDefault(i, 1);
    }

    public String bet(Integer i) {
        boolean testResult = lotteryOutcome == i;
        this.random();
        return testResult ? "boom" : String.valueOf(i);
    }

    public int getVisitCountFor(Integer i) {
        return this.recordVisit(i);
    }
}
