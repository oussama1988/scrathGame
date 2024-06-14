package exemple.ScratchGame;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SymbolConfig {
	@JsonProperty("reward_multiplier")
	private double rewardMultiplier;
	
	@JsonProperty("type")
    private String type;
    
    @JsonProperty("impact")
    private String impact;
    
    @JsonProperty("extra")
    private int extra;

    // Getters and Setters
    public double getRewardMultiplier() { return rewardMultiplier; }
    public void setRewardMultiplier(double rewardMultiplier) { this.rewardMultiplier = rewardMultiplier; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getImpact() { return impact; }
    public void setImpact(String impact) { this.impact = impact; }
    public int getExtra() { return extra; }
    public void setExtra(int extra) { this.extra = extra; }
}
