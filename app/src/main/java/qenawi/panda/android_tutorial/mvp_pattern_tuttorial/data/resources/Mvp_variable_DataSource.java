package qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.resources;


import io.reactivex.Observable;
import qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.Mvp_variable_data_type;

import java.util.ArrayList;

public interface Mvp_variable_DataSource {
    /*
    What Should Repo Class LookLike
    // Repo to model Contract
     */
    Observable<ArrayList<Mvp_variable_data_type>> getDataList();
    void refreshList();
}
