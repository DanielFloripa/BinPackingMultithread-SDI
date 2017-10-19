package bpp;

import java.util.Arrays;
import java.util.List;

public class BinPacking {

    public static void main(String[] args) {
        List<Integer> in = Arrays.asList(1, 1, 2, 3, 7, 8, 7, 10, 1, 1, 2, 3, 4);

        BinPackingBruteforce bf = new BinPackingBruteforce(in, 10);
        testBinPacking(bf, "brute force");

        FirstFitDecreasing ffd = new FirstFitDecreasing(in, 10);
        testBinPacking(ffd, "first fit decreasing");
    }

    private static void testBinPacking(AbstractBinPacking algo, String algoName) {
        long startTime;
        long estimatedTime;

        startTime = System.currentTimeMillis();
        System.out.println("needed bins (" + algoName + "): " + algo.getResult());
        algo.printBestBins();
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("in " + estimatedTime + " ms");

        System.out.println("\n\n");
    }

}
