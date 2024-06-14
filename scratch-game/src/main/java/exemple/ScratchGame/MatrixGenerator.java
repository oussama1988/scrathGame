package exemple.ScratchGame;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class MatrixGenerator {
	private final int rows;
    private final int columns;
    private final Map<String, Integer> standardProbabilities;
    private final Map<String, Integer> bonusProbabilities;
    private final Random random;

    public MatrixGenerator(int rows, int columns, List<ProbabilityConfig> list, List<ProbabilityConfig> list2) {
        this.rows = rows;
        this.columns = columns;
        this.standardProbabilities = (Map<String, Integer>) list;
        this.bonusProbabilities = (Map<String, Integer>) list2;
        this.random = new Random();
    }

    public String[][] generateMatrix() {
        String[][] matrix = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = getRandomSymbol(standardProbabilities);
            }
        }
        // Add a bonus symbol randomly in the matrix
        int bonusRow = random.nextInt(rows);
        int bonusCol = random.nextInt(columns);
        matrix[bonusRow][bonusCol] = getRandomSymbol(bonusProbabilities);

        return matrix;
    }

    private String getRandomSymbol(Map<String, Integer> probabilities) {
        int totalProbability = probabilities.values().stream().mapToInt(Integer::intValue).sum();
        int randomValue = random.nextInt(totalProbability) + 1;
        int cumulativeProbability = 0;
        for (Map.Entry<String, Integer> entry : probabilities.entrySet()) {
            cumulativeProbability += entry.getValue();
            if (randomValue <= cumulativeProbability) {
                return entry.getKey();
            }
        }
        return null; // This should never happen if probabilities are correctly defined
    }

}
