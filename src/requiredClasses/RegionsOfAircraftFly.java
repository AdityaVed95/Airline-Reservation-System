package requiredClasses;

import java.util.Map;

public class RegionsOfAircraftFly
{
    public static Map<String, Region> regionsMap = Map.of(
            "Mumbai", new Region("Mumbai"),
            "New York", new Region("New York"),
            "Toronto" , new Region("Toronto"),
            "Sydney", new Region("Sydney"),
            "Moscow" , new Region("Moscow"),
            "Singapore" , new Region("Singapore"),
            "Beijing",  new Region("Beijing"),
            "Tokyo" , new Region("Tokyo"),
            "London" , new Region("London")
    );


    public static Region getRegion(String regionName)
    {
        return regionsMap.get(regionName);
    }

}
