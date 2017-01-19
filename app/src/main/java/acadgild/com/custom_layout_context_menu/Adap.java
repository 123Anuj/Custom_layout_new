package acadgild.com.custom_layout_context_menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 1/13/2017.
 */

class SingleRow{
    String name;
    String contact;
    public SingleRow(String name,String contact){
        this.name=name;
        this.contact=contact;
    }
}
public class Adap extends BaseAdapter {

    Context context;
    ArrayList<SingleRow> arrayList;

    public Adap(Context context){
        arrayList=new ArrayList<>();
        this.context=context;
        Resources res=context.getResources();
        String[] contact=res.getStringArray(R.array.Contacts);
      String[] name=  res.getStringArray(R.array.Names);

        for(int i=0;i<4;i++){
            arrayList.add(new SingleRow(name[i],contact[i]));
        }

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.child,parent,false);
        TextView nam= (TextView) row.findViewById(R.id.name_textView);
        TextView con=(TextView) row.findViewById(R.id.phone_textView);
        SingleRow r=arrayList.get(position);
        nam.setText(r.name);
        con.setText(r.contact);
        return row;
    }
}
