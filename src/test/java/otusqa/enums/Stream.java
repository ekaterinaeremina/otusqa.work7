package otusqa.enums;

public enum Stream {
    all("Все потоки"),
    develop("Разработка"),
    popsci("Научпоп"),
    admin("Администрирование"),
    design("Дизайн"),
    management("Менеджмент");

    private String name;

    Stream(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public static Stream fromString(String n) {
        for (Stream b : Stream.values()) {
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
            case "Все потоки":
                return "https://habr.com/ru/all";
            case "Разработка":
                return "https://habr.com/ru/flows/develop/";
            case "Научпоп":
                return "https://habr.com/ru/flows/popsci/";
            case "Администрирование":
                return "https://habr.com/ru/flows/admin/";
            case "Дизайн":
                return "https://habr.com/ru/flows/design/";
            case "Менеджмент":
                return "https://habr.com/ru/flows/management/";
            default:
                return "https://habr.com/ru/";
        }
    }
}
