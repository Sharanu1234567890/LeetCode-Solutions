import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max heap based on gain in pass ratio
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> 
            Double.compare(b[0], a[0])
        );

        // Initialize heap with gain and class info
        for (int[] cls : classes) {
            int pass = cls[0], total = cls[1];
            double gain = gain(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }

        // Assign extra students greedily
        while (extraStudents-- > 0) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1] + 1;
            int total = (int) top[2] + 1;
            double gain = gain(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }

        // Compute final average pass ratio
        double sum = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] cls = maxHeap.poll();
            sum += cls[1] / cls[2];
        }

        return sum / classes.length;
    }

    // Helper to compute gain from adding one student
    private double gain(int pass, int total) {
        return ((double)(pass + 1) / (total + 1)) - ((double) pass / total);
    }
}
