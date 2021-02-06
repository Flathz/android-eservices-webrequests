package android.eservices.webrequests.data.api;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BooksDisplayService {
    String API_KEY = "AIzaSyAKcmqmHHlnPOtw69A4ul_8EX1o7vymhvA";
    @GET("volumes")
    Single<BookSearchResponse> getBooksSearchResults(@Query("q") String query, @Query("key") String apiKey);

    @GET("volumes/{bookId}")
    Single<Book> getBookDetails(@Path("bookId") String bookId, @Query("key") String apiKey);
}
