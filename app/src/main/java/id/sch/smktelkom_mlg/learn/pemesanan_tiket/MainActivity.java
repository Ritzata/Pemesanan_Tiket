package id.sch.smktelkom_mlg.learn.pemesanan_tiket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioButton laki, Perempuan;
    TextView tvHasil;
    EditText etNama,etUsia;
    Button btpesan;
    CheckBox cebox1,cebox2,cebox3,cebox4;
    Spinner spp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editTextNama);
        btpesan = (Button) findViewById(R.id.button);
        etUsia.setText("");
        laki = (RadioButton) findViewById(R.id.rbL);
        Perempuan = (RadioButton) findViewById(R.id.rbP);
        cebox1= (CheckBox) findViewById(R.id.cb1);
        cebox2=(CheckBox) findViewById(R.id.cb2);
        cebox3=(CheckBox) findViewById(R.id.cb3);
        cebox4=(CheckBox) findViewById(R.id.cb4);
        spp=(Spinner) findViewById(R.id.spinner);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

       btpesan.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           doClick();
                                           doProcess();
                                       }
                                   }
        );

    }

    private void doProcess() {
        if(isValid())
        {
            String nama = etNama.getText().toString();
            tvHasil.setText("Nama Pemesan : "+ nama);
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();

        if(nama.isEmpty())
        {
         etNama.setError("Nama Belum Diisi");
            valid = false;
        }
        else if(nama.length()<3)
        {
            etNama.setError("Nama Minimal 3 karakter");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }
        return valid;
    }


    private void doClick() {
        String hasil4="JURUSAN : \n";
        int startln = hasil4.length();

        if(cebox1.isChecked()) hasil4+=cebox1.getText()+"ok";
        if(cebox2.isChecked()) hasil4+=cebox2.getText()+"ok";
        if(cebox3.isChecked()) hasil4+=cebox3.getText()+"ok";
        if(cebox4.isChecked()) hasil4+=cebox4.getText()+"ok";

        if(hasil4.length()==startln) hasil4+="GAGAL (X)";

        {
            String hasil2 = null;
            if(laki.isChecked()){
                hasil2 = laki.getText().toString();
            }
            else if(Perempuan.isChecked()){
                hasil2 = Perempuan.getText().toString();
            }
            if (hasil2 == null){
                tvHasil.setText("Konten belum diisi");
            }
            else{
                tvHasil.setText("Jenis Kelamin : "+hasil2);
            }
            tvHasil.setText(hasil4);
            tvHasil.setText("Kelas :"+spp.getSelectedItem().toString());

        }
    }
}



