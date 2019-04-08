package net.example.volley3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    Button button;
    TextView f1,f2,f3;
    String server_url="http://192.168.43.30/volley/showdata/showdata.php";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.btn);
        f1=(TextView) findViewById(R.id.firstvalue);
        f2=(TextView) findViewById(R.id.secondvalue);
        f3=(TextView) findViewById(R.id.thirdvalue);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, server_url,  null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response)
                            {
                               try
                               {
                                   f1.setText(response.getString("name"));
                                   f2.setText(response.getString("email"));
                                   f3.setText(response.getString("mobile"));
                               }
                               catch (JSONException e)
                               {
                                   e.printStackTrace();
                               }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                    }
                });
                MySingleton.getInstance(MainActivity.this).addToRequest(jsonObjectRequest);
            }
        });

    }
}

