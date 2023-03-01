package practice4;

public class SelectReq {
    String name;
    String secondName;
    String BDay;
    String sex;
    String title;
    String rating;
    String idDirector;
    String idFilm;

    public SelectReq(String idDirector, String name, String secondName, String BDay, String sex, String idFilm, String title, String rating) {
        this.name = name;
        this.secondName = secondName;
        this.BDay = BDay;
        this.sex = sex;
        this.title = title;
        this.rating = rating;
        this.idDirector = idDirector;
        this.idFilm = idFilm;
    }

    public SelectReq(String idDirector, String name, String secondName, String BDay, String sex) {
        this.name = name;
        this.secondName = secondName;
        this.BDay = BDay;
        this.sex = sex;
        this.idDirector = idDirector;
    }

    public SelectReq(String idFilm, String title, String rating, String idDirector) {
        this.title = title;
        this.rating = rating;
        this.idFilm = idFilm;
        this.idDirector = idDirector;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getBDay() {
        return BDay;
    }

    public String getSex() {
        return sex;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }

    public String getIdDirector() {
        return idDirector;
    }

    public String getIdFilm() {
        return idFilm;
    }
}