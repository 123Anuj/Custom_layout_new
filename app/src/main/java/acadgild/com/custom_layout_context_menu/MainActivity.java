package acadgild.com.custom_layout_context_menu;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //private Cursor myCursor;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView) findViewById(R.id.list_View);
        /*SimpleCursorAdapter listAdapter= new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,null,new String[]{"Numbers","Names"},
                new int[]{android.R.id.text1,android.R.id.text2},0);*/ // This cannot be done


        listView.setAdapter(new Adap(this));
        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Select the Action");
        menu.add(0,0,1,"call");
        menu.add(0,1,2,"Sms");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getGroupId()==0||item.getItemId()==0){

             dialPhoneNumber();
        }
        else if(item.getGroupId()==0||item.getItemId()==1){

            composeMmsMessage();
        }
        return super.onContextItemSelected(item);
    }

    public void dialPhoneNumber() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void composeMmsMessage() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
