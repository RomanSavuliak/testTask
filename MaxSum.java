import java.nio.file.*;
import static java.util.Arrays.stream;

public class MaxSum {

    public static void main(String[] args) throws Exception {

        int[][] data = readArray("simple_triangle.txt");
        System.out.println("simple triangle max sum: " + maxSum(data));
        int[][] data1 = readArray("triangle.txt");
        System.out.println("triangle max sum: " + maxSum(data1));
    }

    public static int[][] readArray(String name)throws Exception{
        return Files.lines(Paths.get(name)).map(s -> stream(s.trim().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
    };

    public static int maxSum(int [][] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < arr[i].length - 1; j++) {
                arr[i - 1][j] += Math.max(arr[i][j], arr[i][j + 1]);
            }
        }
        return arr[0][0];
    };
}
