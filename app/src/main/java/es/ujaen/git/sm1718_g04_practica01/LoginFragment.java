package es.ujaen.git.sm1718_g04_practica01;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class LoginFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param_1";             //aqui declaramos cómo se llamarán los parámetros de entrada
    private static final String ARG_PARAM2 = "param_2";

    //Aqui definimos las preferencias compartidas:
    public static SharedPreferences preferencias;


    private String IP;
    private int PORT;


    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param ip Parameter 1.
     * @param port Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */

    public static LoginFragment newInstance(String ip, int port) {
        //Creamos un nuevo objeto
        LoginFragment fragment = new LoginFragment();
        //Creamos un nuevo paquete
        Bundle args = new Bundle();
        //Introducimos una cadena String y un entero Int
        args.putString(ARG_PARAM1, ip);
        args.putInt(ARG_PARAM2, port);
        fragment.setArguments(args);
        return fragment;
    }

    //El método onCreate nos crea la instancia
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //Guardamos este nuevo String en la variable que declaramos al principio "IP".
            IP = getArguments().getString(ARG_PARAM1);
            //Guardamos este nuevo Int en la variable que declaramos al principio "PORT".
            PORT = getArguments().getInt(ARG_PARAM2);
        }
    }

    //El método onCreateView nos crea la vista
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_login, container, false);

        Button connect = (Button) fragment.findViewById(R.id.button_login);
        final EditText user = (EditText) fragment.findViewById(R.id.editText_login_user);
        final EditText pass = (EditText) fragment.findViewById(R.id.editText_login_pass);
        final EditText ip = (EditText) fragment.findViewById(R.id.editText_login_ip);
        final EditText port = (EditText) fragment.findViewById(R.id.editText_login_port);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_user = user.getText().toString();
                String s_pass = pass.getText().toString();
                String s_ip = ip.getText().toString();
                String s_port = port.getText().toString();
                short port2 = 0;
                try {
                    port2 = Short.parseShort(s_port);
                } catch (java.lang.NumberFormatException ex) {
                    port2 = 6000;
                }
                ConnectionUserData data = new ConnectionUserData(
                        s_user, s_pass, s_ip, port2
                );
                Toast.makeText(getContext(), "Hola " + s_user + " " + s_pass + " " + s_ip + ":" + s_port, Toast.LENGTH_LONG).show();

                TareaAutentica tarea = new TareaAutentica();
                tarea.execute(data);

//                Intent nueva = new Intent(getActivity(), ServiceActivity.class);
//                nueva.putExtra(ServiceActivity.PARAM_USER,data.getUser());
//                nueva.putExtra("param_pass",data.getPass());
//                nueva.putExtra("param_ip",data.getConnectionIP());
//                nueva.putExtra("param_port",data.getConnectionPort());
//                startActivity(nueva);
            }
        });

        return fragment;
    }

    public class TareaAutentica extends AsyncTask<ConnectionUserData,Integer,String> {
        private ConnectionUserData data;
        public String doInBackground(ConnectionUserData... param){
            if(param!=null)
                if(param.length>=1)
                    data=param[0];
            //TODO proceso de autenticación
            return "OK";
        }

        /**
         *
         * @param result OK si la operación fue correcta y si no otor valor
         */
        public void onPostExecute(String result){

            if(result.compareToIgnoreCase("OK")==0) {
                Intent nueva = new Intent(getActivity(), ServiceActivity.class);
                nueva.putExtra(ServiceActivity.PARAM_USER, data.getUser());
                nueva.putExtra("param_pass", data.getPass());
                nueva.putExtra("param_ip", data.getConnectionIP());
                nueva.putExtra("param_port", data.getConnectionPort());
                startActivity(nueva);
            }else
            {
                Toast.makeText(getContext(), "Error autenticando a " +data.getUser(), Toast.LENGTH_LONG).show();

            }
        }

    }
}
