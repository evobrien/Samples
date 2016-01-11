package irishrail.sample.com.irishrailrealtime.ui.interfaces;

import android.support.v4.app.Fragment;

/**
 * Created by evano on 14/12/2015.
 */
public interface IFragmentNavigation {

    void addFragment(Fragment fragment);
    void replaceFragment(Fragment fragment);
    void removeFragment(Fragment fragment);
}
