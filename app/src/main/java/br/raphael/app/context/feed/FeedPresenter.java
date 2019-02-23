package br.raphael.app.context.feed;

import android.support.annotation.NonNull;

public class FeedPresenter implements FeedPresenterInterface  {

    private FeedViewInterface view;

    public FeedPresenter(@NonNull FeedViewInterface view){
        this.view = view;
    }

    public interface FeedViewInterface{
        void showLoadDialog();
        void hideLoadDialog();
    }
}
