package irishrail.sample.com.irishrailrealtime.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import irishrail.sample.com.irishrailrealtime.R;
import irishrail.sample.com.irishrailrealtime.data.model.StationDataItem;

/**
 * Created by evano on 10/01/2016.
 */
public class TrainListAdapter extends BaseAdapter{

    List<StationDataItem> mItems;
    Context mContext;
    int layoutResourceID;

    public TrainListAdapter(Context context, int layoutResourceID, List<StationDataItem> items) {
        this.mContext = context;
        this.mItems = items;
        this.layoutResourceID = layoutResourceID;
    }

    @Override
    public int getCount() {
        return mItems!=null?mItems.size():0;
    }

    @Override
    public Object getItem(int position) {
        return mItems!=null?mItems.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;

        if(null==view){
            view = LayoutInflater.from(mContext).inflate(layoutResourceID, viewGroup, false);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)view.getTag();
        }

        StationDataItem item=this.mItems.get(position);


        viewHolder.tv_line_item1.setText(mContext.getString(R.string.line1_text, item.getOrigin(), item.getDestination()));
        viewHolder.tv_line_item1.setTextColor(mContext.getResources().getColor(android.R.color.primary_text_light));
        viewHolder.tvDueIn.setText(mContext.getString(R.string.due_text, item.getDuein()));
        viewHolder.tvExpected.setText(mContext.getString(R.string.arrival_time, item.getExparrival()));

        if(item.getLate()==null || Integer.parseInt(item.getLate())==0){
            viewHolder.tvLate.setText(mContext.getString(R.string.on_time));
            viewHolder.tvLate.setTextColor(mContext.getResources().getColor(android.R.color.primary_text_light));
        }else{
            viewHolder.tvLate.setText(mContext.getString(R.string.late_text, item.getLate()));
            viewHolder.tvLate.setTextColor(mContext.getResources().getColor(R.color.red));
        }
        if(item.getLastlocation()==null){
            viewHolder.tvLastLocation.setVisibility(View.GONE);
        }else{
            viewHolder.tvLastLocation.setText(mContext.getString(R.string.last_location_text, item.getLastlocation()));
            viewHolder.tvStatus.setText(item.getStatus());
            viewHolder.tvLastLocation.setVisibility(View.VISIBLE);
        }

        if(position % 2 == 0){
          view.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        }else{
            view.setBackgroundColor(mContext.getResources().getColor(R.color.light_gray));
        }

        return view;
    }

    static class ViewHolder{

        @InjectView(R.id.tv_line_item1)
        TextView tv_line_item1;
        @InjectView(R.id.tv_expected)
        TextView tvExpected;
        @InjectView(R.id.tv_late)
        TextView tvLate;
        @InjectView(R.id.tv_status)
        TextView tvStatus;
        @InjectView(R.id.tv_last_location)
        TextView tvLastLocation;
        @InjectView(R.id.tv_due_in)
        TextView tvDueIn;

        public ViewHolder(View view){
            ButterKnife.inject(this, view);
        }
    }
}
