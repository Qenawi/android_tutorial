package qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.resources.local;

import android.content.Context;
import io.reactivex.Observable;
import qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.Mvp_variable_data_type;
import qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.resources.Mvp_variable_DataSource;

import java.util.ArrayList;

public class Mvp_variable_DataSource_Local implements Mvp_variable_DataSource {

    static Mvp_variable_DataSource_Local INSTANCE;
    //    // Prevent direct instantiation

    public Mvp_variable_DataSource_Local(Context context)
    {


    }
    public static Mvp_variable_DataSource_Local getInistance(Context context)
    {
        if (INSTANCE == null) {
            INSTANCE = new Mvp_variable_DataSource_Local(context);
        }
        return INSTANCE;
    }

    @Override
    public Observable<ArrayList<Mvp_variable_data_type>> getDataList() {
        return Observable.just(new ArrayList<Mvp_variable_data_type>() {
            {
                add(new Mvp_variable_data_type("NameLocal", 0));
                add(new Mvp_variable_data_type("Name2", 1));
                add(new Mvp_variable_data_type("Name3", 2));
                add(new Mvp_variable_data_type("Name4", 3));


            }
        });
    }

    @Override
    public void refreshList()
    {

    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
