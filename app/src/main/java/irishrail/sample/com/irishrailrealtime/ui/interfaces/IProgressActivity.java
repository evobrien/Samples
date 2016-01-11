package irishrail.sample.com.irishrailrealtime.ui.interfaces;

/**
 * Created by evano on 13/12/2015.
 * interface describing the lifecycle of a dialog associated
 * with an activity
 */
public interface IProgressActivity {
    void setupDialog(String displayText);
    void showProgress();
    void hideProgress();
}
