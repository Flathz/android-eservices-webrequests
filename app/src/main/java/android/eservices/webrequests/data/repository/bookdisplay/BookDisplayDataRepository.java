package android.eservices.webrequests.data.repository.bookdisplay;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;
import android.eservices.webrequests.data.db.entities.BookEntity;
import android.eservices.webrequests.data.repository.bookdisplay.local.BookDisplayLocalDataSource;
import android.eservices.webrequests.data.repository.bookdisplay.mapper.BookToBookEntityMapper;
import android.eservices.webrequests.data.repository.bookdisplay.remote.BookDisplayRemoteDataSource;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class BookDisplayDataRepository {
    private BookDisplayRemoteDataSource bookDisplayRemoteDataSource;
    private BookDisplayLocalDataSource bookDisplayLocalDataSource;
    private BookToBookEntityMapper bookToBookEntityMapper;


    public BookDisplayDataRepository(BookDisplayRemoteDataSource bookDisplayRemoteDataSource, BookDisplayLocalDataSource bookDisplayLocalDataSource, BookToBookEntityMapper bookToBookEntityMapper) {
        this.bookDisplayRemoteDataSource = bookDisplayRemoteDataSource;
        this.bookDisplayLocalDataSource = bookDisplayLocalDataSource;
        this.bookToBookEntityMapper = bookToBookEntityMapper;
    }

    public BookDisplayLocalDataSource getBookDisplayLocalDataSource() {
        return bookDisplayLocalDataSource;
    }

    public void setBookDisplayLocalDataSource(BookDisplayLocalDataSource bookDisplayLocalDataSource) {
        this.bookDisplayLocalDataSource = bookDisplayLocalDataSource;
    }

    public BookToBookEntityMapper getBookToBookEntityMapper() {
        return bookToBookEntityMapper;
    }

    public void setBookToBookEntityMapper(BookToBookEntityMapper bookToBookEntityMapper) {
        this.bookToBookEntityMapper = bookToBookEntityMapper;
    }

    public BookDisplayRemoteDataSource getBookDisplayRemoteDataSource() {
        return bookDisplayRemoteDataSource;
    }

    public void setBookDisplayRemoteDataSource(BookDisplayRemoteDataSource bookDisplayRemoteDataSource) {
        this.bookDisplayRemoteDataSource = bookDisplayRemoteDataSource;
    }

    public BookDisplayDataRepository(BookDisplayRemoteDataSource bookDisplayRemoteDataSource) {
        this.bookDisplayRemoteDataSource = bookDisplayRemoteDataSource;
    }

    public Single<BookSearchResponse> getBooksSearchResults(String keyword){
        return bookDisplayRemoteDataSource.getBooksSearchResults(keyword);
    }

    public Flowable<List<BookEntity>> getFavoriteBooks(){
        return bookDisplayLocalDataSource.getFavorites();
    }

    public Completable addBookToFavorites(String bookId){
        //Aller chercher le book sur l'API
        return bookDisplayRemoteDataSource.getBookDetails(bookId).map(new Function<Book, BookEntity>() {
            @Override
            public BookEntity apply(@NonNull Book book) throws Exception {
                return bookToBookEntityMapper.map(book);
            }
        })

                //utiliser la réponse reçue
                .flatMapCompletable(new Function<BookEntity, CompletableSource>() {
                    @Override
                    public CompletableSource apply(@NonNull BookEntity book) throws Exception {
                        return bookDisplayLocalDataSource.insertBook(book);
                    }
                });
    }

}
