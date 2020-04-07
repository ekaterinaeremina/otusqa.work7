package otusqa.cases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Epics;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import otusqa.enums.*;
import otusqa.pages.MainPage;
import otusqa.steps.*;
import otusqa.steps.settings.ProfileSettingsSteps;
import otusqa.testData.SettingsTestData;

public class SettingsTests extends BaseTest {

    private static final Logger log = Logger.getLogger(SettingsTests.class);
    private static SettingsTestData config = ConfigFactory.create(SettingsTestData.class);

    @Test
    @Epics(value = {@Epic(value = "Профиль"), @Epic(value = "Атрибуты элементов")})
    @Description("Тест на проверку максимальной длины поля Настоящее имя в настройках профиля")
    public void CheckMaxLengthFullNameTest() throws Exception {
        log.info("Start CheckMaxLengthFullNameTest");
        String realName=config.realName();
        CommonSteps commonSteps = new CommonSteps(driver);
        MainSteps mainSteps = commonSteps.signIn(login, password);
        ProfileSettingsSteps profileSettingsSteps = commonSteps.signIn(login, password)
                .goToProfileSettings()
                .inputRealName(realName);

        String actualRealName = profileSettingsSteps.getRealName();

        Assert.assertEquals(actualRealName.length(), config.exceptedMaxValueRealName());
        log.info("End CheckMaxLengthFullNameTest");
    }
}
