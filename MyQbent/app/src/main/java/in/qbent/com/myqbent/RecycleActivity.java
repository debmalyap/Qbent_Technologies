package in.qbent.com.myqbent;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends AppCompatActivity
{

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<MyData> listItems;
    String data = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();
        new FetchView().execute();

//        FetchData fetchData = new FetchData();
//        fetchData.execute();
//
//        data = textView1.toString();

       // loadRecyclerViewData();
//        MyData listItem1 = new MyData("Debmalya","Murshidabad","  Technologies");
//        listItems.add(listItem1);
//
//        MyData listItem2 = new MyData("Chandan","Kolkata","Qbent Technologies");
//        listItems.add(listItem2);
//
//        MyData listItem3 = new MyData("Shubendu","Kolkata","Qbent Technologies");
//        listItems.add(listItem3);
//
//        MyData listItem4 = new MyData("Anurag","South 24 Pargana","Qbent Technologies");
//        listItems.add(listItem4);
//
//        MyData listItem5 = new MyData("Debabrata","Dunlop","Qbent Technologies");
//        listItems.add(listItem5);
//
//        MyData listItem6 = new MyData("Debasish","Kolkata","Qbent Technologies");
//        listItems.add(listItem6);
//
//        MyData listItem7 = new MyData("Arup","Birbhum","Qbent Technologies");
//        listItems.add(listItem7);
//
//        MyData listItem8 = new MyData("Bikash","Jharkhand","Qbent Technologies");
//        listItems.add(listItem8);
//
//        MyData listItem9 = new MyData("Gourab","Burdwan","Qbent Technologies");
//        listItems.add(listItem9);
//
//        MyData listItem10 = new MyData("Kalyan","Hooghly","Qbent Technologies");
//        listItems.add(listItem10);


//        adapter = new MyAdapter(listItems,this);
//        recyclerView.setAdapter(adapter);
    }

    public class FetchView extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected Void doInBackground(Void... voids)
        {
            try
            {
                URL url = new URL("https://api.myjson.com/bins/1b703k");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();//established a connection//
                InputStream inputStream = httpURLConnection.getInputStream();//read the data//
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));//read the data from input stream//
                String line = " ";
                while(line != null)
                {
                    line=bufferedReader.readLine();//read each lines of the JSON file//
                    data =data + line;//All JSON file will be in data//
                }
                JSONArray jsonArray = new JSONArray(data);
                for(int i=0;i<jsonArray.length();i++)
                {
                    //listdata.add(jsonArray.get(i));

                    JSONObject jsonObject = (JSONObject)jsonArray.get(i);

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//                    MyData myList = new MyData(
//                            jsonObject1.getString("name"),
//                            jsonObject1.getString("address"),
//                            jsonObject1.getString("company")
//                    );
                    MyData myList = new MyData(
                            jsonObject1.getString("name"),
                            jsonObject1.getString("address"),
                            jsonObject1.getString("company")
                    );
//                    myList.setName(myList.getName());
//                    myList.setAddress(myList.getAddress());
//                    myList.setCompany(myList.getCompany());

                    listItems.add(myList);
                }

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
//            adapter = new MyAdapter(listItems,RecycleActivity.this);
//            recyclerView.setAdapter(adapter);
            recyclerView = (RecyclerView) findViewById(R.id.myRecycler);
            adapter = new MyAdapter(listItems, RecycleActivity.this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(RecycleActivity.this));
        }
    }


}
