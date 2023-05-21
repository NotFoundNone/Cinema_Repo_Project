package cinema.demo.Entity;

public class Session {
    private Integer id;
    private String title;
    private String startFilm;
    private Integer price;
    private String duration;

    public Session(String title, String startFilm, Integer price, String duration) {
        this.title = title;
        this.startFilm = startFilm;
        this.price = price;
        this.duration = duration;
    }

    public Session(Integer id, String title, String startFilm, Integer price, String duration) {
        this.id = id;
        this.title = title;
        this.startFilm = startFilm;
        this.price = price;
        this.duration = duration;
    }

    public Session() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartFilm() {
        return startFilm;
    }

    public void setStartFilm(String startFilm) {
        this.startFilm = startFilm;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startFilm='" + startFilm + '\'' +
                ", price=" + price +
                ", duration='" + duration + '\'' +
                '}';
    }
}
