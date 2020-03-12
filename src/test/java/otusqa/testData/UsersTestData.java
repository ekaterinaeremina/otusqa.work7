package otusqa.testData;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:UsersTestData.properties"})
public interface UsersTestData extends Config {

    @DefaultValue("test")
    @Key("nameForSubscribe")
    String nameForSubscribe();

    @DefaultValue("Иван Белокаменцев")
    @Key("nameForTestdisplay")
    String nameForTestdisplay();

}
