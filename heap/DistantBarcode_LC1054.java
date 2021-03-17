import java.util.*;

public class DistantBarcode_LC1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes == null || barcodes.length == 0)
            return new int[] {};
        if (barcodes.length == 1)
            return barcodes;

        Map<Integer, Integer> freqArr = new HashMap<>();
        for (int barcode : barcodes) {
            freqArr.put(barcode, freqArr.getOrDefault(barcode, 0) + 1);
        }
        // This is a max-heap sorted by their frequency
        Queue<Integer> bars = new PriorityQueue<>((a, b) -> freqArr.get(b) - freqArr.get(a));
        bars.addAll(freqArr.keySet());
        int k = 0;
        while (bars.size() > 1) {
            int barA = bars.poll();
            int barB = bars.poll();

            barcodes[k++] = barA;
            barcodes[k++] = barB;

            int updatedFreq = freqArr.get(barA) - 1;
            if (updatedFreq > 0) {
                freqArr.put(barA, updatedFreq);
                bars.add(barA);
            }

            updatedFreq = freqArr.get(barB) - 1;
            if (updatedFreq > 0) {
                freqArr.put(barB, updatedFreq);
                bars.add(barB);
            }
        }
        // Odd length array handling
        if (!bars.isEmpty())
            barcodes[k] = bars.poll();
        return barcodes;
    }

    public static void main(String[] args) {
        DistantBarcode_LC1054 d = new DistantBarcode_LC1054();
        int[] barcodes = { 1, 1, 1, 2, 2, 2 };
        int[] result = d.rearrangeBarcodes(barcodes);
        System.out.println(Arrays.toString(result));
    }

}
