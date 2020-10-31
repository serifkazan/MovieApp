package com.nese.movieapp.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nese.movieapp.model.movie.MovieResults;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {MovieResults.class}, version = 1)
public abstract class MovieDatabase extends RoomDatabase {
    public static volatile MovieDatabase INSTANCE;

    public abstract MovieDao movieDao();

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(1);

    public static MovieDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MovieDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieDatabase.class,
                            "movies.db").build();
                }
            }
        }
        return INSTANCE;
    }
}
