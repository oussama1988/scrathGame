package exemple.ScratchGame;

import java.util.List;
import java.util.Map;

public class Probabilities {
	private List<ProbabilityConfig> standardSymbols;
    private Map<String, Integer> bonusSymbols;

    // Getters and setters

    public List<ProbabilityConfig> getStandardSymbols() {
        return standardSymbols;
    }

    public void setStandardSymbols(List<ProbabilityConfig> standardSymbols) {
        this.standardSymbols = standardSymbols;
    }

    public Map<String, Integer> getBonusSymbols() {
        return bonusSymbols;
    }

    public void setBonusSymbols(Map<String, Integer> bonusSymbols) {
        this.bonusSymbols = bonusSymbols;
    }
}
