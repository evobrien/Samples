package irishrail.sample.com.irishrailrealtime.ui.interfaces;

/**
 * Created by evano on 13/12/2015.
 * Base view interface for MVP
 */
public interface IView {
    //every view must register a presenter (this could be injected with dagger instead)
    void registerPresenter();
}
