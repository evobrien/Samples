package irishrail.sample.com.irishrailrealtime.ui.fragments;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by eobrien
 * all fragments that include the pull to refresh behaviour should derive from this
 * (not all fragments will have this functionality which is why it's not in the base fragment
 */
public abstract class RefreshableFragment extends BaseFragment {

    protected SwipeRefreshLayout mSwipeLayout;
    protected View mRoot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRoot = inflater.inflate(this.getLayoutId(), container, false);
        ButterKnife.inject(this, mRoot);
        /*
        * hook up the layout
        * */
        mSwipeLayout = ButterKnife.findById(mRoot, this.getRefreshElementId());

        //setSwipeLayout();
        return mRoot;
    }

    private void setSwipeLayout() {


        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                mSwipeLayout.setRefreshing(true);
                doRefreshAction();

            }


        });

        mSwipeLayout.setProgressBackgroundColorSchemeResource(
                this.getColorSchemeResource());
        /*mSwipeLayout.setColorScheme(color.purple,
                color.blue,
                color.green,
                color.purple);*/
    }

    /*
    * call this in the base class when you're done
    * */
    public void setRefreshComplete() {
        if(mSwipeLayout!=null) {
            mSwipeLayout.setRefreshing(false);
        }

    }

    /*
        return the layout id of the layout
    */
    public abstract int getLayoutId();

    /*
    * get the color resource to use in the refresh disc [we're using the material UI approach]
    * */
    public abstract int getColorSchemeResource();

    /*
    * call the refresh method you wish to execute
    * */
    public abstract void doRefreshAction();

    /*the id of the swipe to refresh layout control*/
    public abstract int getRefreshElementId();
}

