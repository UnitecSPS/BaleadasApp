package android.unitec.baleadasapp;

import android.content.Intent;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class FacturaActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        TextView tvCli = (TextView)findViewById(R.id.tvCliente);
        TextView tvCant = (TextView)findViewById(R.id.tvCant);
        TextView tvllevar = (TextView)findViewById(R.id.tvLLevar);
        TextView tvTotal = (TextView)findViewById(R.id.tvTotal);

        Intent i = getIntent();

        //set los valores
        int cant = i.getIntExtra(MainActivity.CANTIDAD,0);
        String llevar = i.getStringExtra(MainActivity.LLEVAR);
        tvCli.setText(i.getStringExtra(MainActivity.CLIENTE));
        tvCant.setText(""+cant);
        tvllevar.setText(llevar);

        //calcular el pago
        int total = (20*cant)+(llevar.equals("SI") ? 5 : 0);
        tvTotal.setText("Lps. "+total);

    }

    public void share(View view) {
        String url = "http://www.facebook.com";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);
    }
}
