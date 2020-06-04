package com.pratham.skills.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.pratham.skills.modal.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase appDatabase;
    public static final String DATABASE_NAME = "skillAppDB";

    //public abstract UserDao getUserDoa();


    public static AppDatabase getDatabaseInstance(Context context) {
        try {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                        .allowMainThreadQueries().build();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appDatabase;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
