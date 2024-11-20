import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int count;
    static boolean[] columns;
    static boolean[] leftDiagonals;
    static boolean[] rightDiagonals;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        columns = new boolean[n];
        leftDiagonals = new boolean[2 * n - 1];
        rightDiagonals = new boolean[2 * n - 1];

        solve(0);
        System.out.println(count);
    }

    static void solve(int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                placeQueen(row, col);
                solve(row + 1);
                removeQueen(row, col);
            }
        }
    }

    static boolean isSafe(int row, int col) {
        return !columns[col] && !leftDiagonals[row - col + n - 1] && !rightDiagonals[row + col];
    }

    static void placeQueen(int row, int col) {
        columns[col] = true;
        leftDiagonals[row - col + n - 1] = true;
        rightDiagonals[row + col] = true;
    }

    static void removeQueen(int row, int col) {
        columns[col] = false;
        leftDiagonals[row - col + n - 1] = false;
        rightDiagonals[row + col] = false;
    }
}
