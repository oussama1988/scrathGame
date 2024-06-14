package exemple.ScratchGame;


import java.util.List;
import java.util.Map;

public class RewardResult {
	private final String[][] matrix;
    private final double reward;
    private final Map<String, List<String>> appliedWinningCombinations;
    private final String appliedBonusSymbol;

    public RewardResult(String[][] matrix, double reward, Map<String, List<String>> appliedWinningCombinations, String appliedBonusSymbol) {
        this.matrix = matrix;
        this.reward = reward;
        this.appliedWinningCombinations = appliedWinningCombinations;
        this.appliedBonusSymbol = appliedBonusSymbol;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrix:\n");
        for (String[] row : matrix) {
            for (String cell : row) {
                sb.append(cell).append(" ");
            }
            sb.append("\n");
        }
        sb.append("Reward: ").append(reward).append("\n");
        sb.append("Applied Winning Combinations: ").append(appliedWinningCombinations).append("\n");
        sb.append("Applied Bonus Symbol: ").append(appliedBonusSymbol).append("\n");
        return sb.toString();
    }
}
