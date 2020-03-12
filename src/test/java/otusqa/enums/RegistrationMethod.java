package otusqa.enums;

public enum RegistrationMethod {
    Twitter("twitter"),
    Facebook("facebook"),
    VK("vkontakte"),
    Google("#"),
    Github("github"),
    LiveID("liveid");

    private String name;

    RegistrationMethod(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public static RegistrationMethod fromString(String n) {
        for (RegistrationMethod b : RegistrationMethod.values()) {
            if (b.name.equalsIgnoreCase(n)) {
                return b;
            }
        }
        return null;
    }

    public String getUrl()
    {
        switch (name)
        {
            case "twitter":
                return "https://api.twitter.com/oauth/authorize";
            case "facebook":
                return "https://www.facebook.com/login.php";
            case "vkontakte":
                return "https://oauth.vk.com/authorize";
            case "#":
                return "https://accounts.google.com/signin/oauth/";
            case "github":
                return "https://github.com/login";
            case "liveid":
                return "https://login.live.com/oauth20_authorize.srf";
            default:
                return "https://habr.com/ru/";
        }
    }
}
