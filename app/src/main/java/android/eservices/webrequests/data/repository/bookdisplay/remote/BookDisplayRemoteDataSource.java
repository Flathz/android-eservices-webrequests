package android.eservices.webrequests.data.repository.bookdisplay.remote;

import android.eservices.webrequests.BookApplication;
import android.eservices.webrequests.data.api.BooksDisplayService;
import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;

import io.reactivex.Single;

public class BookDisplayRemoteDataSource {
    BooksDisplayService booksDisplayService;
    public BooksDisplayService getBooksDisplayService() {
        return booksDisplayService;
    }

    public void setBooksDisplayService(BooksDisplayService booksDisplayService) {
        this.booksDisplayService = booksDisplayService;
    }

    public BookDisplayRemoteDataSource(BooksDisplayService booksDisplayService) {
        this.booksDisplayService = booksDisplayService;
    }

    public Single<BookSearchResponse> getBooksSearchResults(String keywords){
        return booksDisplayService.getBooksSearchResults(keywords, BookApplication.API_KEY);
    }

    public Single<Book> getBookDetails(String bookId){
        return booksDisplayService.getBookDetails(bookId, BookApplication.API_KEY);
    }


}
