package kodluyoruz.com.sharedpreferenceeasy;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvSavedData;
    Button btnApply, btnSave;
    EditText etUser;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        etUser = (EditText) findViewById(R.id.activity_main_etUser);
        btnApply = (Button) findViewById(R.id.activity_main_btnApply);
        btnSave = (Button) findViewById(R.id.activity_main_btnSave);
        tvSavedData = (TextView) findViewById(R.id.activity_main_tvSavedData);

        btnSave.setOnClickListener(this);
        btnApply.setOnClickListener(this);
    }

    private void initEvent() {
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_main_btnSave:
                SharedPreferences sharedPreferences = getSharedPreferences("FILE", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String saveData = etUser.getText().toString();
                editor.putString("data", saveData);
                Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
                editor.commit();


                break;
            case R.id.activity_main_btnApply:

                sharedPreferences = getSharedPreferences("FILE", MODE_PRIVATE);
                String data = sharedPreferences.getString("data", "Data Not Found");
                tvSavedData.setText(data);
                break;
        }
    }
}
