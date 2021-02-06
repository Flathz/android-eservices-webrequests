package android.eservices.webrequests.presentation.viewmodel;


import android.eservices.webrequests.data.repository.bookdisplay.BookDisplayDataRepository;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final BookDisplayDataRepository bookDisplayRepository;

    public ViewModelFactory(BookDisplayDataRepository bookDisplayRepository) {
        this.bookDisplayRepository = bookDisplayRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(BookSearchViewModel.class)) {
            return (T) new BookSearchViewModel(bookDisplayRepository);
        }
        //Handle favorite view model case
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}