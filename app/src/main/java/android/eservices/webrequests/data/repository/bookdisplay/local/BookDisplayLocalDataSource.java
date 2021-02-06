package android.eservices.webrequests.data.repository.bookdisplay.local;
import android.eservices.webrequests.data.db.BookDatabase;
import android.eservices.webrequests.data.db.entities.BookEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;


public class BookDisplayLocalDataSource {
    private BookDatabase bookDatabase;

    public BookDisplayLocalDataSource(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    public Flowable<List<BookEntity>> getFavorites(){
        return this.bookDatabase.getBookDao().getAll();
    }

    public Completable insertBook(BookEntity book){
        return this.bookDatabase.getBookDao().insert(book);
    }

    public Completable updateBook(BookEntity book){
        return this.bookDatabase.getBookDao().update(book);
    }

    public Completable deleteBook(BookEntity book){
        return this.bookDatabase.getBookDao().delete(book);
    }
}
