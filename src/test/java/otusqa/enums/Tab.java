package otusqa.enums;

public enum Tab {
    Companies("Компании"),
    Top("Статьи"),
    News("Новости"),
    Hubs("Хабы"),
    Users("Авторы");

    private String name;

    Tab(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public static Tab fromString(String n) {
        for (Tab b : Tab.values()) {
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
            case "Компании":
                return "https://habr.com/ru/companies/";
            case "Статьи":
                return "https://habr.com/ru/top/";
            case "Новости":
                return "https://habr.com/ru/news/";
            case "Хабы":
                return "https://habr.com/ru/hubs/";
            case "Авторы":
                return "https://habr.com/ru/users/";
            default:
                return "https://habr.com/ru/";
        }
    }
}
