package qenawi.panda.android_tutorial.mvc_pattern_tutorial;

import android.content.Context;

import java.util.ArrayList;

public class MvcControler implements MvcModel.ControlerContract {
    /*
 The Model classes don’t have any reference to Android classes
 and are therefore straightforward to unit test. The Controller doesn’t extend or implement any Android
 classes and should have a reference to an interface class of the MvcView. In this way, unit testing of the Controller is also possible.
     */
    private MvcModel model;
    private ViewToControlerCall viewToControler;

    public MvcControler(Context c)
    {
        viewToControler = (ViewToControlerCall) c;
        model = new MvcModel(c, this);
    }

    @Override
    final public void updateResult(boolean result)
    {
        //C->V Notify MvcView To Re update Its Data From Model
        viewToControler.notifyView();
    }

    public ArrayList<String> getMovieList() {
        return model.getMovieList();
    }

    public void fetchMovies() {
        // V->C Request  FetchMovies
        // C->M  MockNetWorkReuest
        model.mockNetWorkReuest();
    }

    protected interface ViewToControlerCall {
        void notifyView();
    }
}
