package irishrail.sample.com.irishrailrealtime.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import irishrail.sample.com.irishrailrealtime.R;
import irishrail.sample.com.irishrailrealtime.data.model.StationDataItem;
import irishrail.sample.com.irishrailrealtime.ui.adapters.TrainListAdapter;
import irishrail.sample.com.irishrailrealtime.ui.interfaces.IProgressActivity;
import irishrail.sample.com.irishrailrealtime.ui.presenters.TrainListPresenter;

/**
 * Created by evano on 10/01/2016.
 */
public class TrainListFragment extends BaseFragment implements TrainListPresenter.ITrainView {

    @InjectView(R.id.content)
    View mContentView;

    @InjectView(R.id.train_list)
    ListView mTrainList;

    @InjectView(R.id.error_layout)
    View mErrorLayout;

    @InjectView(R.id.tv_filter)
    AutoCompleteTextView mFilterText;

    @InjectView(R.id.btnFilter)
    Button btnFilter;

    View mRoot;
    //private RecyclerView.LayoutManager mLayoutManager;
    TrainListPresenter mPresenter;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        mRoot = inflater.inflate(R.layout.fragment_train_list, container, false);
        ButterKnife.inject(this, mRoot);
        return mRoot;
       // mLayoutManager = new LinearLayoutManager(this.getActivity());
       /// mTrainList.setLayoutManager(mLayoutManager);

       // return mRoot;
    }



  /*  @Override
    public int getLayoutId() {
        return R.layout.fragment_train_list;
    }

    @Override
    public int getColorSchemeResource() {
        return R.color.white;
    }

    @Override
    public void doRefreshAction() {
        mPresenter.refresh();
    }

    @Override
    public int getRefreshElementId() {
        return R.id.root;
    }*/

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setDefaultLayout();
        registerPresenter();
        this.btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.filter(mFilterText.getText().toString());
            }
        });

    }

    public void loadStations(List<String> stationNames){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),
                android.R.layout.simple_dropdown_item_1line, stationNames);
        this.mFilterText.setAdapter(adapter);


    }

    @Override
    public void loadSchedule(List<StationDataItem> items) {

        TrainListAdapter adapter=new TrainListAdapter(this.getContext(),R.layout.item_train_data,items);
        this.mTrainList.setAdapter(adapter);

    }

    @Override
    public void showProgress() {
        ((IProgressActivity)getActivity()).showProgress();
    }

    @Override
    public void hideProgress() {
        ((IProgressActivity)getActivity()).hideProgress();
    }

    @Override
    public void showError(){
        //setRefreshComplete();
        this.mContentView.setVisibility(View.GONE);
        this.mErrorLayout.setVisibility(View.VISIBLE);
    }

    private void setDefaultLayout(){
        this.mContentView.setVisibility(View.VISIBLE);
        this.mErrorLayout.setVisibility(View.GONE);
    }

    @Override
    public void registerPresenter() {
        mPresenter=new TrainListPresenter(getActivity(),this);
        mPresenter.bind();

    }
}
