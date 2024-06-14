package exemple.ScratchGame;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameConfig {
    private int columns;
    private int rows;

    @JsonProperty("symbolConfigs")
    private Map<String, SymbolConfig> symbolConfigs;

    @JsonProperty("standardProbabilities")
    private List<ProbabilityConfig> standardProbabilities;

    @JsonProperty("bonusProbabilities")
    private List<ProbabilityConfig> bonusProbabilities;

    @JsonProperty("winCombinations")
    private Map<String, WinCombination> winCombinations;

    @JsonProperty("probabilities")
    private Probabilities probabilities;

    // Getters and setters
    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Map<String, SymbolConfig> getSymbolConfigs() {
        return symbolConfigs;
    }

    public void setSymbolConfigs(Map<String, SymbolConfig> symbolConfigs) {
        this.symbolConfigs = symbolConfigs;
    }

    public List<ProbabilityConfig> getStandardProbabilities() {
        return standardProbabilities;
    }

    public void setStandardProbabilities(List<ProbabilityConfig> standardProbabilities) {
        this.standardProbabilities = standardProbabilities;
    }

    public List<ProbabilityConfig> getBonusProbabilities() {
        return bonusProbabilities;
    }

    public void setBonusProbabilities(List<ProbabilityConfig> bonusProbabilities) {
        this.bonusProbabilities = bonusProbabilities;
    }

    public Map<String, WinCombination> getWinCombinations() {
        return winCombinations;
    }

    public void setWinCombinations(Map<String, WinCombination> winCombinations) {
        this.winCombinations = winCombinations;
    }

    public Probabilities getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(Probabilities probabilities) {
        this.probabilities = probabilities;
    }
}
