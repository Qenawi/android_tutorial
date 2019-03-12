package qenawi.panda.android_tutorial.mvc_pattern_tutorial;

import android.arch.lifecycle.ViewModelStore;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class MvcView extends AppCompatActivity implements MvcControler.ViewToControlerCall {
    private MvcControler mvcControler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set content view
        // init Controller
        mvcControler = new MvcControler(this);
        // On Click Listener
        mvcControler.fetchMovies();
    }


    @Override
    public void notifyView() {
        ArrayList<String> data =
                mvcControler.getMovieList();
    }
}
