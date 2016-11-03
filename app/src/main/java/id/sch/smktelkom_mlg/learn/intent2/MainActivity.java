package id.sch.smktelkom_mlg.learn.intent2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static final String NAMA = "Nama";
    public static final String TAHUN_LAHIR = "Tahun Lahir";
    public static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonInput).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, InputActivity.class),
                        REQUEST_CODE);
            }
        }));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE)
        {
            if(resultCode==RESULT_OK)
            {
                String nama = data.getStringExtra(InputActivity.NAMA);
                int thnLhr = data.getIntExtra(InputActivity.TAHUN_LAHIR, 0);

                TextView tvBiodata = (TextView) findViewById(R.id.textViewBiodata);
                tvBiodata.setText("Nama\t\t\t\t\t\t: "+nama
                + "\nTahun Kelahiran\t : "+thnLhr);
            }
        }
    }
}
