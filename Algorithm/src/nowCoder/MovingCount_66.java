package nowCoder;

public class MovingCount_66 {
    public int movingCount(int threshold, int rows, int cols)
    {
        int count = 0;
        if(threshold < 0 || rows <= 0 || cols <= 0) return 0;
        boolean[] visited = new boolean[rows * cols];
        count = movingCount(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private int movingCount(int threshold, int rows, int cols, int i, int j, boolean[] visited){
        int index = i * cols + j;
        if(threshold < 0 || i < 0 || i >= rows || j < 0 || j >=cols || getSum(i, j) > threshold || !visited[index]) return 0;

        int count = 0;

        count++;
        visited[index] = true;


        count += movingCount(threshold, rows, cols, i - 1, j, visited);
        count += movingCount(threshold, rows, cols, i + 1, j, visited);
        count += movingCount(threshold, rows, cols, i, j - 1, visited);
        count += movingCount(threshold, rows, cols, i, j + 1, visited);

        return count;
    }

    private int getSum(int i, int j){
        int sum = 0;
        while(i > 0){
            sum += i % 10;
            i /= 10;
        }
        while(j > 0){
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }
}
