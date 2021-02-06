package android.eservices.webrequests.data.db;

import android.eservices.webrequests.data.db.entities.BookEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = BookEntity.class)
public abstract class BookDatabase extends RoomDatabase{
    abstract public BookDao getBookDao();
}
