 package qenawi.panda.android_tutorial.mvp_pattern_tuttorial;

import com.google.android.gms.common.internal.Preconditions;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;
import qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.resources.Mvp_variable_Reposotry;

import static com.google.android.gms.common.internal.Preconditions.checkNotNull;

public class Mvp_presenter implements View_presenter_contract.Presenter {
    /*
     retrieves the data from the Model, a
     pplies the UI logic and manages the state of the View,
     decides what to display and reacts to user input notifications from the View.
     */
    Mvp_variable_Reposotry reposotry;
    View_presenter_contract.View view;
    CompositeDisposable disposable;
    private boolean mFirstLoad = true;

    public Mvp_presenter(@NotNull Mvp_variable_Reposotry reposotry, View_presenter_contract.View view) {
        this.reposotry = checkNotNull(reposotry);
        this.view = Preconditions.checkNotNull(view);
        disposable = new CompositeDisposable();
        view.setPresenter(Mvp_presenter.this);

    }

    @Override
    public void get_movies(boolean forceUpdate) {
        // Simplification for sample: a network reload will be forced on first load.
        get_movies(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;

    }

    private void get_movies(boolean force, boolean showLoadingUI) {
        if (showLoadingUI) {
            view.setLoadingindicator(true);
        }
        if (force) {
            reposotry.refreshList();
        }

        // The network request might be handled in a different thread so make sure Espresso knows
        // that the app is busy until the response is handled.
        // EspressoIdlingResource.increment(); // App is busy until further notice

        disposable.add
                (
                        reposotry.getDataList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(s ->
                                {
                                    view.show_movies(s);
                                }, e ->
                                {
                                    e.printStackTrace();
                                }));
    }

    @Override
    public void start() {
        get_movies(false);
    }
}
