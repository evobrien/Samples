package irishrail.sample.com.irishrailrealtime.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by evano on 10/01/2016.
 */
@Root(name="objStationData")
public class StationDataItem {

    @Element(required=false)
    private String Locationtype;
    @Element(required=false)
    private String Servertime;
    @Element
    private String Traintype;
    @Element(required=false)
    private String Late;
    @Element(required=false)
    private String Origintime;
    @Element(required=false)
    private String Scharrival;
    @Element(required=false)
    private String Schdepart;
    @Element(required=false)
    private String Origin;
    @Element(required=false)
    private String Exparrival;
    @Element(required=false)
    private String Direction;
    @Element(required=false)
    private String Destinationtime;
    @Element(required=false)
    private String Querytime;
    @Element(required=false)
    private String Stationfullname;
    @Element(required=false)
    private String Status;
    @Element(required=false)
    private String Duein;
    @Element(required=false)
    private String Expdepart;
    @Element(required=false)
    private String Stationcode;
    @Element(required=false)
    private String Traincode;
    @Element(required=false)
    private String Traindate;
    @Element(required=false)
    private String Destination;
    @Element(required=false)
    private String Lastlocation;

    public StationDataItem(){

    }

    public String getLocationtype ()
    {
        return Locationtype;
    }

    public void setLocationtype (String Locationtype)
    {
        this.Locationtype = Locationtype;
    }

    public String getServertime ()
    {
        return Servertime;
    }

    public void setServertime (String Servertime)
    {
        this.Servertime = Servertime;
    }

    public String getTraintype ()
    {
        return Traintype;
    }

    public void setTraintype (String Traintype)
    {
        this.Traintype = Traintype;
    }

    public String getLate ()
    {
        return Late;
    }

    public void setLate (String Late)
    {
        this.Late = Late;
    }

    public String getOrigintime ()
    {
        return Origintime;
    }

    public void setOrigintime (String Origintime)
    {
        this.Origintime = Origintime;
    }

    public String getScharrival ()
    {
        return Scharrival;
    }

    public void setScharrival (String Scharrival)
    {
        this.Scharrival = Scharrival;
    }

    public String getSchdepart ()
    {
        return Schdepart;
    }

    public void setSchdepart (String Schdepart)
    {
        this.Schdepart = Schdepart;
    }

    public String getOrigin ()
    {
        return Origin;
    }

    public void setOrigin (String Origin)
    {
        this.Origin = Origin;
    }

    public String getExparrival ()
    {
        return Exparrival;
    }

    public void setExparrival (String Exparrival)
    {
        this.Exparrival = Exparrival;
    }

    public String getDirection ()
    {
        return Direction;
    }

    public void setDirection (String Direction)
    {
        this.Direction = Direction;
    }

    public String getDestinationtime ()
    {
        return Destinationtime;
    }

    public void setDestinationtime (String Destinationtime)
    {
        this.Destinationtime = Destinationtime;
    }

    public String getQuerytime ()
    {
        return Querytime;
    }

    public void setQuerytime (String Querytime)
    {
        this.Querytime = Querytime;
    }

    public String getStationfullname ()
    {
        return Stationfullname;
    }

    public void setStationfullname (String Stationfullname)
    {
        this.Stationfullname = Stationfullname;
    }

    public String getStatus ()
    {
        return Status;
    }

    public void setStatus (String Status)
    {
        this.Status = Status;
    }

    public String getDuein ()
    {
        return Duein;
    }

    public void setDuein (String Duein)
    {
        this.Duein = Duein;
    }

    public String getExpdepart ()
    {
        return Expdepart;
    }

    public void setExpdepart (String Expdepart)
    {
        this.Expdepart = Expdepart;
    }

    public String getStationcode ()
    {
        return Stationcode;
    }

    public void setStationcode (String Stationcode)
    {
        this.Stationcode = Stationcode;
    }

    public String getTraincode ()
    {
        return Traincode;
    }

    public void setTraincode (String Traincode)
    {
        this.Traincode = Traincode;
    }

    public String getTraindate ()
    {
        return Traindate;
    }

    public void setTraindate (String Traindate)
    {
        this.Traindate = Traindate;
    }

    public String getDestination ()
    {
        return Destination;
    }

    public void setDestination (String Destination)
    {
        this.Destination = Destination;
    }

    public String getLastlocation ()
    {
        return Lastlocation;
    }

    public void setLastlocation (String Lastlocation)
    {
        this.Lastlocation = Lastlocation;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Locationtype = "+Locationtype+", Servertime = "+Servertime+", Traintype = "+Traintype+", Late = "+Late+", Origintime = "+Origintime+", Scharrival = "+Scharrival+", Schdepart = "+Schdepart+", Origin = "+Origin+", Exparrival = "+Exparrival+", Direction = "+Direction+", Destinationtime = "+Destinationtime+", Querytime = "+Querytime+", Stationfullname = "+Stationfullname+", Status = "+Status+", Duein = "+Duein+", Expdepart = "+Expdepart+", Stationcode = "+Stationcode+", Traincode = "+Traincode+", Traindate = "+Traindate+", Destination = "+Destination+", Lastlocation = "+Lastlocation+"]";
    }

}
