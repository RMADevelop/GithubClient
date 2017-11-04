package com.example.romanm.githubclient.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.romanm.githubclient.data.local.Local;
import com.example.romanm.githubclient.data.local.LocalDataRoom;
import com.example.romanm.githubclient.data.local.LocalRoomDAO;
import com.example.romanm.githubclient.data.remote.Service;
import com.example.romanm.githubclient.domain.interactors.ReposInteractor;
import com.example.romanm.githubclient.domain.interactors.ReposInteractorImpl;
import com.example.romanm.githubclient.presentation.mvp.presenter.ReposPresenter;
import com.example.romanm.githubclient.repository.ReposRepository;
import com.example.romanm.githubclient.repository.ReposRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class DataModule {

//    String baseUrl;
//
//    public DataModule(String baseUrl) {
//        this.baseUrl = baseUrl;
//    }
//
//    @Provides
//    @Singleton
//    Retrofit provideRetrofit() {
//        return new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//    }

    @Provides
    @Singleton
    Service provideApi(Retrofit retrofit) {
        return retrofit.create(Service.class);
    }

    @Singleton
    @Provides
    LocalDataRoom provideLocalDataRoom(Context context) {
        return Room.databaseBuilder(context, LocalDataRoom.class, "database").build();
    }

    @Singleton
    @Provides
    LocalRoomDAO provideDao(LocalDataRoom localDataRoom) {
        return localDataRoom.getDAO();
    }

    @Singleton
    @Provides
    Local provideLocal(LocalRoomDAO dao) {
        return new Local(dao);
    }

    @Singleton
    @Provides
    ReposRepositoryImpl provideReposRepository(Local local) {
        return new ReposRepositoryImpl(local);
    }

    @Singleton
    @Provides
    ReposInteractorImpl provideInteractor(ReposRepositoryImpl reposRepository) {
        return new ReposInteractorImpl(reposRepository);
    }


    @Singleton
    @Provides
    ReposPresenter providePresenter(ReposInteractorImpl reposInteractor) {
        return new ReposPresenter(reposInteractor);
    }
//    @Singleton
//    @Provides
//    ReposPresenter providePr(ReposPresenter reposPresenter) {
//        return reposPresenter;
//    }

}
