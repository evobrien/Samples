package irishrail.sample.com.irishrailrealtime.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by evano on 10/01/2016.
 */
@Root(name="objStation")
public class Station {
    @Element(required=false)
    private String StationDesc;
    @Element(required=false)
    private String StationId;
    @Element(required=false)
    private String StationAlias;
    @Element(required=false)
    private String StationLatitude;
    @Element(required=false)
    private String StationCode;
    @Element(required=false)
    private String StationLongitude;

    public String getStationDesc ()
    {
        return StationDesc;
    }

    public void setStationDesc (String StationDesc)
    {
        this.StationDesc = StationDesc;
    }

    public String getStationId ()
    {
        return StationId;
    }

    public void setStationId (String StationId)
    {
        this.StationId = StationId;
    }

    public String getStationAlias ()
    {
        return StationAlias;
    }

    public void setStationAlias (String StationAlias)
    {
        this.StationAlias = StationAlias;
    }

    public String getStationLatitude ()
    {
        return StationLatitude;
    }

    public void setStationLatitude (String StationLatitude)
    {
        this.StationLatitude = StationLatitude;
    }

    public String getStationCode ()
    {
        return StationCode;
    }

    public void setStationCode (String StationCode)
    {
        this.StationCode = StationCode;
    }

    public String getStationLongitude ()
    {
        return StationLongitude;
    }

    public void setStationLongitude (String StationLongitude)
    {
        this.StationLongitude = StationLongitude;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [StationDesc = "+StationDesc+", StationId = "+StationId+", StationAlias = "+StationAlias+", StationLatitude = "+StationLatitude+", StationCode = "+StationCode+", StationLongitude = "+StationLongitude+"]";
    }
}
