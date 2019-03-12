package qenawi.panda.android_tutorial.mvc_pattern_tutorial;

import android.content.Context;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MvcModel {
    private CompositeDisposable disposable;
    private ControlerContract model_To_Contraler;

    public String getPremative_typeString() {
        return premative_typeString;
    }

    public void setPremative_typeString(String premative_typeString) {
        this.premative_typeString = premative_typeString;
    }

    public int getPremative_type_int() {
        return premative_type_int;
    }

    public void setPremative_type_int(int premative_type_int) {
        this.premative_type_int = premative_type_int;
    }

    public ArrayList<String> getMovieList() {
        return MovieList;
    }

    private void setMovieList(ArrayList<String> movieList) {
        MovieList = movieList;
        // M->C Update Result
        model_To_Contraler.updateResult(true);
        // Notify  Controller With List Update
    }

    //  the data layer, responsible for managing the business logic and handling network or database API.
    private String premative_typeString;
    private int premative_type_int;
    private ArrayList<String> MovieList;

    public MvcModel(Context context, ControlerContract call) {
        //
        this.model_To_Contraler = call;
        disposable = new CompositeDisposable();
        MovieList = new ArrayList<>();
        premative_type_int = 0;
        premative_typeString = "null";
    }

    protected void mockNetWorkReuest() {
        //C->M Update Data
        disposable.add(
                Observable.timer(300, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                        subscribe(t ->
                        {
                            setMovieList(new ArrayList<String>() {

                                {
                                    add("mv1");
                                    add("mv2");
                                    add("mv3");
                                    add("mv4");
                                    add("mv5");
                                }
                            });
                        }, f ->
                        {

                        }));

    }

    protected interface ControlerContract {
        void updateResult(boolean result);
    }
}
