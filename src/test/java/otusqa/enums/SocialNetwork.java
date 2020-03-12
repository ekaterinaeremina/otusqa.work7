package otusqa.enums;

public enum SocialNetwork {
    Twitter("twitter"),
    Facebook("facebook"),
    VK("vkontakte"),
    Telegram("telegram"),
    Youtube("youtube"),
    Zen("zen");

    private String name;

    SocialNetwork(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public static SocialNetwork fromString(String n) {
        for (SocialNetwork b : SocialNetwork.values()) {
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
                return "https://twitter.com/habr_com";
            case "facebook":
                return "https://www.facebook.com/habrahabr.ru";
            case "vkontakte":
                return "https://vk.com/habr";
            case "telegram":
                return "https://telegram.me/habr_com";
            case "youtube":
                return "https://www.youtube.com/channel/UCd_sTwKqVrweTt4oAKY5y4w";
            case "zen":
                return "https://zen.yandex.ru/habr";
            default:
                return "https://habr.com/ru/";
        }
    }
}
