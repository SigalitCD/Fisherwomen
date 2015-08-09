package com.fisherwomen.fisherwomen;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private SearchModel mModel;
    private ListView listView;
    private SimpleCursorAdapter simpleCursorAdapter =null;
    private FragmentManager fManager = null;
    private SearchFragment fragment = null;


    AdapterView.OnItemClickListener mDetailsListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            // if the item is closed -> openDetails();
//            fManager = getFragmentManager();
//            fragment = (SearchFragment) fManager.findFragmentById(R.id.fragment);
//            fragment.openDetails(view);
//
//            // if the item is opened -> closeDetails();
//            fragment.closeDetails(view);

            Toast.makeText(MainActivity.this, "On this place will be detailed notice", Toast.LENGTH_SHORT).show();
            simpleCursorAdapter.notifyDataSetChanged();

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mModel = new SearchModel(this);
        simpleCursorAdapter = mModel.getCursorAdapter();

        listView = (ListView)findViewById(R.id.searchView);
        listView.setOnItemClickListener(mDetailsListener);
        listView.setAdapter(simpleCursorAdapter);
    }

    // buttons listeners:
    public void openFilterView(View view){
//        Intent detailIntent = new Intent(this, FilterActivity.class);
//        startActivityForResult(detailIntent, 1);

    }

    @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK && requestCode==1){
            // get Bundle with new Filter data
            // make search by SearchModel according to the new filter
            // show new results in main activity
            //mNoticeAdapter.notifyDataSetChanged();
            simpleCursorAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            openSettings();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

    }

    public void openSettingsView(View view){
        // ask Sigalit about interface
    }

    public void updateData(View view){
//        // go to SearchModel
//        // ask Model to bring updated results
        simpleCursorAdapter.notifyDataSetChanged();
    }

    public void sortBy(View view){
        Button b = (Button) view;
        String title = b.getText().toString();
        mModel.sortByButton(title);
        simpleCursorAdapter.notifyDataSetChanged();
    }
}

///* TESTING JSOUP:*/
//        import java.io.IOException;
//        import java.io.InputStream;
//
//        import org.jsoup.Jsoup;
//        import org.jsoup.nodes.Document;
//        import org.jsoup.select.Elements;
//
//        import android.content.Context;
//        import android.os.AsyncTask;
//        import android.os.Bundle;
//        import android.app.Activity;
//        import android.app.ProgressDialog;
//        import android.graphics.Bitmap;
//        import android.graphics.BitmapFactory;
//        import android.view.View;
//        import android.view.View.OnClickListener;
//        import android.widget.Button;
//        import android.widget.ImageView;
//        import android.widget.TextView;
//
//
//public class MainActivity extends Activity {
//
//    // URL Address
//    String url = "http://www.yad2.co.il/Nadlan/sales.php?City=%F4%FA%E7+%FA%F7%E5%E5%E4&Neighborhood=%E0%ED+%E4%EE%E5%F9%E1%E5%FA&HomeTypeID=&fromRooms=&untilRooms=&fromPrice=&untilPrice=&PriceType=1&FromFloor=&ToFloor=&Info=";
//    //String url = "http://www.androidbegin.com/";
//    ProgressDialog mProgressDialog;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Locate the Buttons in activity_main.xml
//        Button titlebutton = (Button) findViewById(R.id.titlebutton);
//        Button descbutton = (Button) findViewById(R.id.descbutton);
//        Button logobutton = (Button) findViewById(R.id.logobutton);
//
//        // Capture button click
//        titlebutton.setOnClickListener(new OnClickListener() {
//            public void onClick(View arg0) {
//                // Execute Title AsyncTask
//                new Title().execute();
//            }
//        });
//
//        // Capture button click
//        descbutton.setOnClickListener(new OnClickListener() {
//            public void onClick(View arg0) {
//                // Execute Description AsyncTask
//                new Description().execute();
//            }
//        });
//
//        // Capture button click
//        logobutton.setOnClickListener(new OnClickListener() {
//            public void onClick(View arg0) {
//                // Execute Logo AsyncTask
//                new Logo().execute();
//            }
//        });
//
//    }
//
//    // Title AsyncTask
//    private class Title extends AsyncTask<Void, Void, Void> {
//        String title;
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            mProgressDialog = new ProgressDialog(MainActivity.this);
//            mProgressDialog.setTitle("Android Basic JSoup Tutorial");
//            mProgressDialog.setMessage("Loading...");
//            mProgressDialog.setIndeterminate(false);
//            mProgressDialog.show();
//        }
//
//        @Override
//        protected Void doInBackground(Void... params) {
//            try {
//                // Connect to the web site
//                Document document = Jsoup.connect(url).get();
//                // Get the html document title
//                title = document.title();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void result) {
//            // Set title into TextView
//            TextView txttitle = (TextView) findViewById(R.id.titletxt);
//            txttitle.setText(title);
//            mProgressDialog.dismiss();
//        }
//    }
//
//    // Description AsyncTask
//    private class Description extends AsyncTask<Void, Void, Void> {
//        String desc;
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            mProgressDialog = new ProgressDialog(MainActivity.this);
//            mProgressDialog.setTitle("Android Basic JSoup Tutorial");
//            mProgressDialog.setMessage("Loading...");
//            mProgressDialog.setIndeterminate(false);
//            mProgressDialog.show();
//        }
//
//        @Override
//        protected Void doInBackground(Void... params) {
//            try {
//                // Connect to the web site
//                Document document = Jsoup.connect(url).get();
//                // Using Elements to get the Meta data
//                Elements description = document
//                        .select("meta[name=description]");
//                // Locate the content attribute
//                desc = description.attr("content");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void result) {
//            // Set description into TextView
//            TextView txtdesc = (TextView) findViewById(R.id.desctxt);
//            txtdesc.setText(desc);
//            mProgressDialog.dismiss();
//        }
//    }
//
//    // Logo AsyncTask
//    private class Logo extends AsyncTask<Void, Void, Void> {
//        Bitmap bitmap;
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            mProgressDialog = new ProgressDialog(MainActivity.this);
//            mProgressDialog.setTitle("Android Basic JSoup Tutorial");
//            mProgressDialog.setMessage("Loading...");
//            mProgressDialog.setIndeterminate(false);
//            mProgressDialog.show();
//        }
//
//        @Override
//        protected Void doInBackground(Void... params) {
//
//            try {
//            //
//
//                // Connect to the web site
//                Document document = Jsoup.connect(url).get();
//                // Using Elements to get the class data
//                Elements img = document.select("a[class=brand brand-image] img[src]");
//                // Locate the src attribute
//                String imgSrc = img.attr("src");
//                // Download image from URL
//                InputStream input = new java.net.URL(imgSrc).openStream();
//                // Decode Bitmap
//                bitmap = BitmapFactory.decodeStream(input);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void result) {
//            // Set downloaded image into ImageView
//            ImageView logoimg = (ImageView) findViewById(R.id.logo);
//            logoimg.setImageBitmap(bitmap);
//            mProgressDialog.dismiss();
//        }
//    }}
