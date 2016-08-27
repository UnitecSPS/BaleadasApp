package android.unitec.baleadasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etcli, etcant;
    private Spinner spllevar;

    static final String CLIENTE = "cliente";
    static final String CANTIDAD = "cantidad";
    static final String LLEVAR = "llevar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etcant = (EditText)findViewById(R.id.etCant);
        etcli = (EditText)findViewById(R.id.etCliente);
        spllevar = (Spinner)findViewById(R.id.spLlevar);
    }

    public void pagar(View view) {
        Intent ifact = new Intent(getBaseContext(), FacturaActivity.class);
        String error = "";

        try{
            int cant = Integer.parseInt(etcant.getText().toString());

            if(cant >= 0){
                //poner los extras
                ifact.putExtra(CLIENTE, etcli.getText().toString());
                ifact.putExtra(LLEVAR, spllevar.getSelectedItem().toString());
                ifact.putExtra(CANTIDAD, cant);
                startActivity(ifact);
            }
            else
                error = "Por favor ingrese un numero positivo.";
        }
        catch (Exception e){
            error = e.toString();
        }

        Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG).show();
    }
}
