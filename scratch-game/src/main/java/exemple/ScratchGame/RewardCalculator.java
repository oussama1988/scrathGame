package exemple.ScratchGame;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap; 

public class RewardCalculator {
	private final String[][] matrix;
    private final Map<String, SymbolConfig> symbolConfigs;
    private final Map<String, WinCombination> winCombinations;
    private final double betAmount;

    public RewardCalculator(String[][] matrix, Map<String, SymbolConfig> symbolConfigs, Map<String, WinCombination> winCombinations, double betAmount) {
        this.matrix = matrix;
        this.symbolConfigs = symbolConfigs;
        this.winCombinations = winCombinations;
        this.betAmount = betAmount;
    }

    public RewardResult calculateReward() {
        double reward = 0;
        Map<String, List<String>> appliedWinningCombinations = new HashMap<>();
        String appliedBonusSymbol = null;

        // Check for winning combinations and calculate reward
        for (String symbol : symbolConfigs.keySet()) {
            List<String> winningCombinations = getWinningCombinations(symbol);
            if (!winningCombinations.isEmpty()) {
                double symbolReward = betAmount * symbolConfigs.get(symbol).getRewardMultiplier();
                for (String combination : winningCombinations) {
                    symbolReward *= winCombinations.get(combination).getRewardMultiplier();
                }
                reward += symbolReward;
                appliedWinningCombinations.put(symbol, winningCombinations);
            }
        }

        // Apply bonus symbols if there is any winning combination
        if (reward > 0) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    String symbol = matrix[i][j];
                    if (symbolConfigs.get(symbol).getType().equals("bonus")) {
                        switch (symbolConfigs.get(symbol).getImpact()) {
                            case "multiply_reward":
                                reward *= symbolConfigs.get(symbol).getRewardMultiplier();
                                appliedBonusSymbol = symbol;
                                break;
                            case "extra_bonus":
                                reward += symbolConfigs.get(symbol).getExtra();
                                appliedBonusSymbol = symbol;
                                break;
                            case "miss":
                                appliedBonusSymbol = symbol;
                                break;
                        }
                    }
                }
            }
        }

        return new RewardResult(matrix, reward, appliedWinningCombinations, appliedBonusSymbol);
    }

    private List<String> getWinningCombinations(String symbol) {
        List<String> winningCombinations = new ArrayList<>();
        // Check for various win combinations
        for (Map.Entry<String, WinCombination> entry : winCombinations.entrySet()) {
            WinCombination combination = entry.getValue();
            if (combination.getWhen().equals("same_symbols") && countSymbolOccurrences(symbol) >= combination.getCount()) {
                winningCombinations.add(entry.getKey());
            } else if (combination.getWhen().equals("linear_symbols") && checkLinearSymbols(symbol, combination.getCoveredAreas())) {
                winningCombinations.add(entry.getKey());
            }
        }
        return winningCombinations;
    }

    private int countSymbolOccurrences(String symbol) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals(symbol)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean checkLinearSymbols(String symbol, List<String[]> coveredAreas) {
        for (String[] area : coveredAreas) {
            boolean match = true;
            for (String pos : area) {
                String[] coords = pos.split(":");
                int row = Integer.parseInt(coords[0]);
                int col = Integer.parseInt(coords[1]);
                if (!matrix[row][col].equals(symbol)) {
                    match = false;
                    break;
                }
            }
            if (match) return true;
        }
        return false;
    }
}
