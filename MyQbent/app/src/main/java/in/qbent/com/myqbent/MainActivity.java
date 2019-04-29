package in.qbent.com.myqbent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    public static TextView textView;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.getJson);
        textView = (TextView) findViewById(R.id.txt);
       button1 = (Button) findViewById(R.id.getList);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                FetchData fetchData = new FetchData();
                fetchData.execute();
            }
        });
    }

    public void moveList(View view)
    {
        Intent intent = new Intent(getApplicationContext(),RecycleActivity.class);
        startActivity(intent);
    }
}
