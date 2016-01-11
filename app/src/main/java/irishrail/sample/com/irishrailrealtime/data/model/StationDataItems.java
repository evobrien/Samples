package irishrail.sample.com.irishrailrealtime.data.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by evano on 10/01/2016.
 */
@Root(name="ArrayOfObjStationData",strict = false)
public class StationDataItems {
    @ElementList(inline=true)
    private
    List<StationDataItem> stationDataItemList;

    public StationDataItems(){}


    public List<StationDataItem> getStationDataItemList() {
        return stationDataItemList;
    }

    public void setStationDataItemList(List<StationDataItem> stationDataItemList) {
        this.stationDataItemList = stationDataItemList;
    }
}
