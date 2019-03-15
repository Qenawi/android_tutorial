package qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.resources.remote;

import io.reactivex.Observable;
import qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.Mvp_variable_data_type;
import qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.resources.Mvp_variable_DataSource;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Mvp_variable_DataSourc_Remote implements Mvp_variable_DataSource {
    private static Mvp_variable_DataSourc_Remote INSTANCE;
    private static final int SERVICE_LATENCY_IN_MILLIS = 5000;


    public static Mvp_variable_DataSourc_Remote getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Mvp_variable_DataSourc_Remote();
        }
        return INSTANCE;
    }


    private Mvp_variable_DataSourc_Remote() {
    }

    @Override
    public Observable<ArrayList<Mvp_variable_data_type>> getDataList() {
        return Observable.just(new ArrayList<Mvp_variable_data_type>() {
            {
                add(new Mvp_variable_data_type("NameRemote", 0));
                add(new Mvp_variable_data_type("Name2", 1));
                add(new Mvp_variable_data_type("Name3", 2));
                add(new Mvp_variable_data_type("Name4", 3));


            }
        });

    }

    @Override
    public void refreshList() {

    }
}
