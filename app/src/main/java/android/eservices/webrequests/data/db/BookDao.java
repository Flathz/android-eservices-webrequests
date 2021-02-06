package android.eservices.webrequests.data.db;

import android.eservices.webrequests.data.db.entities.BookEntity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;


@Dao
public interface BookDao {
    @Query("SELECT * FROM BookEntity")
    Flowable<List<BookEntity>> getAll();

    @Insert
    Completable insert(BookEntity book);

    @Update
    Completable update(BookEntity book);

    @Delete
    Completable delete(BookEntity book);

}
