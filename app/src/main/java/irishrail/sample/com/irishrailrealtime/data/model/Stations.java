package irishrail.sample.com.irishrailrealtime.data.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by evano on 10/01/2016.
 */
@Root(name="ArrayOfObjStation",strict = false)
public class Stations {

    @ElementList(inline=true)
    private
    List<Station> stationList;

    public Stations(){

    }


    public List<Station> getStationList() {
        return stationList;
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
    }
}
