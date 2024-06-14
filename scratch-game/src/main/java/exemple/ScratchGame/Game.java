package exemple.ScratchGame;

import java.io.IOException;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 if (args.length != 2) {
	            System.err.println("Usage: java -jar <your-jar-file> --config config.json --betting-amount 100");
	            System.out.println(args.length);
	            return;
	        }

	        String configFilePath = args[0];
	        double betAmount = Double.parseDouble(args[1]);

	        try {
	            GameConfig config = ConfigLoader.loadConfig(configFilePath);
	            MatrixGenerator generator = new MatrixGenerator(config.getRows(), config.getColumns(), config.getStandardProbabilities(), config.getBonusProbabilities());
	            String[][] matrix = generator.generateMatrix();

	            RewardCalculator calculator = new RewardCalculator(matrix, config.getSymbolConfigs(), config.getWinCombinations(), betAmount);
	            RewardResult result = calculator.calculateReward();

	            System.out.println(result);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}
