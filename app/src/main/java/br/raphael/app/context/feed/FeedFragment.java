package br.raphael.app.context.feed;

import android.os.Bundle;
import android.view.View;
import br.raphael.app.base.BaseFragment;
import br.raphael.app.R;
import br.raphael.app.databinding.FragmentFeedBinding;


public class FeedFragment extends BaseFragment<FragmentFeedBinding>
        implements FeedPresenter.FeedViewInterface {

    private FeedPresenterInterface presenter;

    public FeedFragment() { }

    @Override
    public int setLayoutResource() {
        return R.layout.fragment_feed;
    }

    @Override
    public void onCreateView(View view, Bundle savedInstanceState) {
        this.presenter = new FeedPresenter(this);
    }

    @Override
    public void showLoadDialog() {

    }

    @Override
    public void hideLoadDialog() {

    }
}
