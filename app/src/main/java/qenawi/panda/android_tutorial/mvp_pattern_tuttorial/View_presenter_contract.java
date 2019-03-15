package qenawi.panda.android_tutorial.mvp_pattern_tuttorial;

import qenawi.panda.android_tutorial.mvp_pattern_tuttorial.base.BasePresenter;
import qenawi.panda.android_tutorial.mvp_pattern_tuttorial.base.BaseView;
import qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.Mvp_variable_data_type;

import java.util.List;

public class View_presenter_contract {
    public interface View extends BaseView<Presenter> {

        void setLoadingindicator(boolean active);

        void show_movies(List<Mvp_variable_data_type> list);

    }

    public interface Presenter extends BasePresenter {
        void get_movies(boolean forceUpdate);

    }
}
