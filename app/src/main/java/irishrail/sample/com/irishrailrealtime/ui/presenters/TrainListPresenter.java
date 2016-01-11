package irishrail.sample.com.irishrailrealtime.ui.presenters;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

import irishrail.sample.com.irishrailrealtime.data.model.Station;
import irishrail.sample.com.irishrailrealtime.data.model.StationDataItems;
import irishrail.sample.com.irishrailrealtime.data.model.StationDataItem;
import irishrail.sample.com.irishrailrealtime.data.model.Stations;
import irishrail.sample.com.irishrailrealtime.data.request.GetStationDataRequest;
import irishrail.sample.com.irishrailrealtime.data.request.GetStationsRequest;
import irishrail.sample.com.irishrailrealtime.ui.interfaces.ITrainListPresenter;
import irishrail.sample.com.irishrailrealtime.ui.interfaces.IView;
import irishrail.sample.com.irishrailrealtime.utils.L;

/**
 * Created by evano on 10/01/2016.
 */
public class TrainListPresenter implements ITrainListPresenter {


    private Context mContext;
    private ITrainView mView;
    StationDataItems data;

    public TrainListPresenter(Context context, ITrainView view){
        this.mContext=context;
        this.mView=view;
    }

    public void bind(){

        if(data==null){
            getStationList();

        }

    }

    @Override
    public void refresh() {

    }

    public void filter(String stationName){
        if(stationName!=null){
            getTrainData(stationName);
        }
    }

    private void getTrainData(String stationName){
        mView.showProgress();
        GetStationDataRequest stationDataRequest=new GetStationDataRequest(this.mContext,
                new Response.Listener<StationDataItems>(){

                    @Override
                    public void onResponse(StationDataItems stationData) {
                        mView.hideProgress();
                        List<StationDataItem> dataItems=stationData.getStationDataItemList();

                        for(StationDataItem item: dataItems){
                            String itemData="Destination=" + item.getDestination() +
                                    " DestinationTime=" + item.getDestinationtime() +
                                    " Direction=" +item.getDirection() + "\n";
                            L.d(itemData);
                        }

                        mView.loadSchedule(stationData.getStationDataItemList());

                    }
                },
                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        mView.hideProgress();
                    }
                },stationName);

        stationDataRequest.execute();

    }

    private void getStationList(){

        mView.showProgress();

        GetStationsRequest stationsRequest =  new GetStationsRequest(this.mContext,
                new Response.Listener<Stations>() {
                    @Override
                    public void onResponse(Stations stations) {
                        mView.hideProgress();
                        List<Station> stationList= stations.getStationList();
                        List<String> stationNames=new ArrayList<>();
                        for(Station station:stationList){
                            stationNames.add(station.getStationDesc());
                            mView.loadStations(stationNames);
                            L.d(station.getStationDesc());
                        }

                    }
                },new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        mView.hideProgress();
                    }
                });

        stationsRequest.execute();

    }

    public interface ITrainView extends IView {
        void loadStations(List<String> stationNames);
        void loadSchedule(List<StationDataItem> items);
        void showProgress();
        void hideProgress();
        void showError();


    }
}
