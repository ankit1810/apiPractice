package models;

public class SupportPojo {
    @Override
    public String toString() {
        return "SupportPojo{" +
                "url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    private String url;
    private String text;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
