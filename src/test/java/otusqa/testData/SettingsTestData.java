package otusqa.testData;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:UsersTestData.properties"})
public interface SettingsTestData extends Config {

    @DefaultValue("Сообщение, длина которого немного больше 40")
    @Key("inputValue")
    String realName();

    @DefaultValue("40")
    @Key("exceptedMaxValue")
    int exceptedMaxValueRealName();

}
