package qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.resources;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import qenawi.panda.android_tutorial.mvp_pattern_tuttorial.data.Mvp_variable_data_type;

import java.util.ArrayList;
import java.util.List;

public class Mvp_variable_Reposotry implements Mvp_variable_DataSource {

    public static Mvp_variable_Reposotry INISTANCE = null;
    Mvp_variable_DataSource remoteDataSrc;
    Mvp_variable_DataSource localDataSrc;
    ArrayList<Mvp_variable_data_type> Cache;

    public Mvp_variable_Reposotry(Mvp_variable_DataSource remoteDataSrc, Mvp_variable_DataSource localDataSrc) {
        this.localDataSrc = localDataSrc;
        this.remoteDataSrc = remoteDataSrc;
    }


    public static Mvp_variable_Reposotry getInistce(Mvp_variable_DataSource remoteDataSrc, Mvp_variable_DataSource localDataSrc) {
        if (INISTANCE == null) {
            INISTANCE = new Mvp_variable_Reposotry(remoteDataSrc, localDataSrc);
        }
        return INISTANCE;
    }

    public static void destroyInistance() {
        INISTANCE = null;
    }

    @Override
    public Observable<ArrayList<Mvp_variable_data_type>> getDataList() {
        if (Cache != null) {
            return Observable.just(Cache);
        } else if (Cache == null) {
            Cache = new ArrayList<>();
        }
        Observable<List<Mvp_variable_data_type>> remoto = getAndSaveRemoteTasks();
        if (Cache.isEmpty()) {
            return remoto.flatMap((Function<List<Mvp_variable_data_type>, ObservableSource<ArrayList<Mvp_variable_data_type>>>) mvp_variable_data_types -> Observable.just((ArrayList<Mvp_variable_data_type>) mvp_variable_data_types));
        } else {
            Observable<ArrayList<Mvp_variable_data_type>> local = getAndCacheLocalTasks().flatMap((Function<List<Mvp_variable_data_type>, ObservableSource<ArrayList<Mvp_variable_data_type>>>) mvp_variable_data_types -> Observable.just((ArrayList<Mvp_variable_data_type>) mvp_variable_data_types));
            return local;
        }
    }

    @Override
    public void refreshList() {

    }


    private Observable<List<Mvp_variable_data_type>> getAndSaveRemoteTasks()
    {
        return remoteDataSrc
                .getDataList()
                .flatMap(new Function<ArrayList<Mvp_variable_data_type>, Observable<List<Mvp_variable_data_type>>>() {
                    @Override
                    public Observable<List<Mvp_variable_data_type>> apply(ArrayList<Mvp_variable_data_type> tasks) throws Exception {
                        return Observable.fromIterable(tasks).doOnNext(new Consumer<Mvp_variable_data_type>() {
                            @Override
                            public void accept(Mvp_variable_data_type task) throws Exception {
                                //        save Data On Local Repo
                                //      add To Cache
                                Cache.add(task);
                            }
                        }).toList().toObservable();
                    }
                })
                .doOnComplete(() ->
                 {
                    // Data Loaded
                });
                 }
    private Observable<List<Mvp_variable_data_type>> getAndCacheLocalTasks()
    {
        return localDataSrc.getDataList().flatMap(new Function<ArrayList<Mvp_variable_data_type>, ObservableSource<List<Mvp_variable_data_type>>>() {
            @Override
            public ObservableSource<List<Mvp_variable_data_type>> apply(ArrayList<Mvp_variable_data_type> task) throws Exception {
                return Observable.fromIterable(task).doOnNext(new Consumer<Mvp_variable_data_type>() {
                    @Override
                    public void accept(Mvp_variable_data_type mvp_variable_data_type) throws Exception {
                        Cache.add(mvp_variable_data_type);

                    }
                }).toList().toObservable();
            }
        }).doOnComplete(() -> {
        });
    }
}
