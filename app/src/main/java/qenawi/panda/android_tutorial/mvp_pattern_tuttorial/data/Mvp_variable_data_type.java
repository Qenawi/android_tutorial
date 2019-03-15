package qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data;

public class Mvp_variable_data_type
{
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    private String movieName;
    public Mvp_variable_data_type(String movieName, int movieId) {
        this.movieName = movieName;
        this.movieId = movieId;
    }
    private int movieId;
    public Mvp_variable_data_type()
    {

    }
}
