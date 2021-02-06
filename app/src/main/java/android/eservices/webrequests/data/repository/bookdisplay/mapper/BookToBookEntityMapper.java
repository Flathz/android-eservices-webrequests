package android.eservices.webrequests.data.repository.bookdisplay.mapper;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.db.entities.BookEntity;
import android.text.TextUtils;

public class BookToBookEntityMapper {

    public BookEntity map(Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(book.getVolumeInfo().getTitle());
        if (book.getVolumeInfo().getAuthorList() == null) {
            bookEntity.setAuthor("N.C.");
        } else {
            bookEntity.setAuthor(TextUtils.join(", ", book.getVolumeInfo().getAuthorList()));
        }
        bookEntity.setDescription(book.getVolumeInfo().getDescription());
        bookEntity.setUid(book.getId());
        bookEntity.setLanguage(book.getVolumeInfo().getLanguage());
        bookEntity.setPublishedDate(book.getVolumeInfo().getPublishedDate());
        bookEntity.setUrl(book.getVolumeInfo().getImageLinks().getThumbnail());
        return bookEntity;
    }


}

