package irishrail.sample.com.irishrailrealtime.ui.activities;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import irishrail.sample.com.irishrailrealtime.RailApp;
import irishrail.sample.com.irishrailrealtime.R;
import irishrail.sample.com.irishrailrealtime.ui.interfaces.IProgressActivity;
import irishrail.sample.com.irishrailrealtime.utils.L;

/**
 * Created by evano on 13/12/2015.
 */
public abstract class BaseActivity extends AppCompatActivity implements IProgressActivity {

    /*
    This is the id of the main fragment placeholder in the view
    e.g. R.id.main, R.id.placeholder etc
     * */
    protected int mMainFragmentId;
    protected Dialog mProgressDialog;

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    TextView mToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    public void addFragment(Fragment fragment) {
        // add
        try{
            FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
            ft.replace(getMainFragmentId(), fragment, fragment.getTag());
            ft.addToBackStack(null);
            ft.commit();
            getSupportFragmentManager().executePendingTransactions();
        }catch (IllegalStateException se) {//happens in onResume if an activity has been destroyed
            L.e(se);
        }
    }


    public void replaceFragment(Fragment fragment) {
        // replace
        try {
            FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
            ft.replace(getMainFragmentId(), fragment, fragment.getTag());
            ft.commit();
            getSupportFragmentManager().executePendingTransactions();
        } catch (IllegalStateException se) {//happens in onResume if an activity has been destroyed
            L.e(se);
        }
    }

    public void removeFragment(Fragment fragment) {
        // remove
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
        getSupportFragmentManager().executePendingTransactions();
    }

    public int getMainFragmentId() {
        return mMainFragmentId;
    }

    public void setMainFragmentId(int mainFragmentId) {
        this.mMainFragmentId = mainFragmentId;
    }

    @Override
    public void setupDialog(final String displayText) {

        mProgressDialog = new Dialog(this);
        mProgressDialog = new Dialog(this, R.style.dialog) {
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.dialog_progress);
                TextView tvStatus = (TextView) ButterKnife.findById(mProgressDialog, R.id.tv_status_text);
                tvStatus.setText(displayText);
                getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
            }
        };
        mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mProgressDialog.setCancelable(false);
        Drawable d = new android.graphics.drawable.ColorDrawable(Color.BLACK);
        d.setAlpha(30);

        mProgressDialog.getWindow().setBackgroundDrawable(d);

    }

    @Override
    public void showProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }

    public void onStop() {
        super.onStop();
        try {
            if (mProgressDialog != null) {
                hideProgress();
                mProgressDialog.dismiss();
                mProgressDialog = null;
            }
        } catch (Exception expected) {

        }

    }

    public Toolbar getToolbar() {
        return this.mToolbar;
    }

    public TextView getToolbarTitle() {
        return this.mToolbarTitle;
    }

    protected RailApp getIRailApplication() {
        return (RailApp) this.getApplication();
    }

}

