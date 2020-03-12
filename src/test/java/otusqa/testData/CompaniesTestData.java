package otusqa.testData;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:CompaniesTestData.properties"})
public interface CompaniesTestData extends Config {

    @DefaultValue("МТС")
    @Key("companyName")
    String companyName();

    @DefaultValue("Консалтинг и поддержка")
    @Key("filterName")
    String filterName();

    @DefaultValue("https://tmtm.ru/services/corpblog/")
    @Key("techMediaURL")
    String techMediaURL();

}
