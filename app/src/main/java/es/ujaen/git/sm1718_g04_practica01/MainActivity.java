package es.ujaen.git.sm1718_g04_practica01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String datosvolatiles = "Hola";  //es el mensaje que podemos observar cuando pulsamos el boton CONECTAR.
    private TextView volatil=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            datosvolatiles=savedInstanceState.getString("volatil",datosvolatiles);
        }

        volatil = (TextView) findViewById(R.id.volatil);
        volatil.setText(datosvolatiles);

    }

    public void onIcon(View vista){                    //cuando pulsamos el image view del icono de
        datosvolatiles=datosvolatiles.toUpperCase();   // android invocamos este metodo (onIcon), y veremos lo que tenemos
        volatil.setText(datosvolatiles);               // puesto en datos volátiles.

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("volatil",datosvolatiles);
    }


}
