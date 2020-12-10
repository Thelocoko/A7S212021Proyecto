package mx.edu.tesoem.isc.ecr.a7s212021proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetallesActivity2 extends AppCompatActivity {

    TextView lblmatricula, lblnombre, lblcorreo, lblpromedio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles2);

        lblmatricula = findViewById(R.id.dlblmta);
        lblnombre = findViewById(R.id.dlblnom);
        lblcorreo = findViewById(R.id.dlblcor);
        lblpromedio = findViewById(R.id.dlblpf);

        String nombre = getIntent().getExtras().get("Nombre").toString();
        DatosParcelable dato = getIntent().getParcelableExtra("DatosParcelable");

        lblmatricula.setText(dato.getMatricula());
        lblnombre.setText(dato.getNombre());
        lblcorreo.setText(dato.getCorreo());
        lblpromedio.setText(dato.getPromedio());

        getSupportActionBar().setTitle(nombre);
    }
}