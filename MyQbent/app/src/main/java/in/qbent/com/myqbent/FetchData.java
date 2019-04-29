package in.qbent.com.myqbent;

import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
import java.util.List;
import java.util.ArrayList;

public class FetchData extends AsyncTask<Void,Void,Void>
{
    private RecyclerView recyclerView;
    String data = " ";
    String dataParsed = " ";
    String singleParsed = " ";
    //private List<MyData> listItems;
    //private RecyclerView.Adapter adapter;
    //private RecyclerView recyclerView;
    //private RecyclerView recyclerView;
    //background operation on background thread//
    @Override
    protected Void doInBackground(Void... voids) {
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

//            for(int i=0; i<jsonArray.length();i++)
//            {
//                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//                MyData listItem = new MyData(
//                        jsonObject1.getString("name"),
//                        jsonObject1.getString("address"),
//                        jsonObject1.getString("company")
//                );
//                listItems.add(listItem);
//            }
//            adapter = new MyAdapter(listItems,getApplicationContext());
//            recyclerView.setAdapter(adapter);

            for(int i=0;i<jsonArray.length();i++)
            {
                //listdata.add(jsonArray.get(i));

                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
//                    MyData myData = new MyData();

                //listdata.add(jsonObject);
                singleParsed = "Employee name: " + jsonObject.get("name") + "\n" +
                        "Employee address: " + jsonObject.get("address") + "\n" +
                        "Company name: " + jsonObject.get("company") + "\n"+
                        "\n";

                dataParsed =dataParsed + singleParsed;
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

    //update UI of background operation result//
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.textView.setText(this.dataParsed);

    }
}

