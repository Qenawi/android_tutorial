package qenawi.panda.android_tutorial.mvp_pattern_tuttorial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import qenawi.panda.android_tutorial.R;
import qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.Mvp_variable_data_type;
import qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.resources.Mvp_variable_Reposotry;
import qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.resources.local.Mvp_variable_DataSource_Local;
import qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.resources.remote.Mvp_variable_DataSourc_Remote;
import timber.log.Timber;

import java.util.List;

import static com.google.android.gms.common.internal.Preconditions.checkNotNull;

public class Mvp_view extends AppCompatActivity implements View_presenter_contract.View {
    /*
     the UI layer. Displays the data and notifies the Presenter about user actions.
     */
    private Mvp_presenter mPresenter;
    private View_presenter_contract.Presenter mmPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps1);
        mPresenter = new Mvp_presenter(Mvp_variable_Reposotry.getInistce(Mvp_variable_DataSourc_Remote.getInstance()
                , Mvp_variable_DataSource_Local.getInistance(getApplicationContext())), this);
    }

    @Override
    public void setLoadingindicator(boolean active) {
        Timber.tag(Mvp_view.class.getSimpleName()).v("%s", String.valueOf(active));
    }

    @Override
    public void show_movies(List<Mvp_variable_data_type> list) {
        Timber.tag(Mvp_view.class.getSimpleName()).v("%s", String.valueOf(list.size()));
    }

    @Override
    public void setPresenter(View_presenter_contract.Presenter presenter) {
     /*
     Can be USed From Any View  Fragment or Activity...
      */
        mmPresenter = presenter;
    }
}
