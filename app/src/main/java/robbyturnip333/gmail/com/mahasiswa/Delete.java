package robbyturnip333.gmail.com.mahasiswa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import robbyturnip333.gmail.com.mahasiswa.Util.AppController;
import robbyturnip333.gmail.com.mahasiswa.Util.ServerAPI;

public class Delete extends AppCompatActivity {
    EditText deleteID ;
    Button btnDelete;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        deleteID =findViewById(R.id.nim);
        btnDelete =findViewById(R.id.btn_delete);
        pd = new ProgressDialog(Delete.this);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteData();
            }
        });
    }



    private void deleteData()
    {
        pd.setMessage("Delete Data ...");
        pd.setCancelable(false);
        pd.show();

        StringRequest delReq = new StringRequest(Request.Method.POST, ServerAPI.URL_DELETE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.cancel();
                        Log.d("tampil","response : " + response.toString());
                        try {
                            JSONObject res = new JSONObject(response);
                            Toast.makeText(Delete.this,"pesan : " +res.getString("message"), Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        startActivity(new Intent(Delete.this,MainActivity.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Log.d("tampil", "error : " + error.getMessage());
                        Toast.makeText(Delete.this, "pesan : gagal menghapus data", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("nim",deleteID.getText().toString());
                return map;
            }
        };

        AppController.getInstance().addToRequestQueue(delReq);
    }
}
