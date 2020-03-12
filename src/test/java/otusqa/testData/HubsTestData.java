package otusqa.testData;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:HubsTestData.properties"})
public interface HubsTestData extends Config {

    @DefaultValue("Тестирование IT-систем")
    @Key("hubName")
    String hubName();
}
