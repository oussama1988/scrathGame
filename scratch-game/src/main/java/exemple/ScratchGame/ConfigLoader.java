package exemple.ScratchGame;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ConfigLoader {
	 public static GameConfig loadConfig(String configFilePath) throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	        return mapper.readValue(new File(configFilePath), GameConfig.class);
	    }
}
