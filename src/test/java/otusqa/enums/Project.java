package otusqa.enums;

public enum Project {
    Hubr("/habr"),
    QnA("qna"),
    Career("career"),
    Freelance("freelance");

    private String name;

    Project(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public static Project fromString(String n) {
        for (Project b : Project.values()) {
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
            case "/habr":
                return "https://habr.com/ru/";
            case "qna":
                return "https://qna.habr.com";
            case "career":
                return "https://career.habr.com";
            case "freelance":
                return "https://freelance.habr.com";
            default:
                return "https://habr.com/ru/";
        }
    }

}
