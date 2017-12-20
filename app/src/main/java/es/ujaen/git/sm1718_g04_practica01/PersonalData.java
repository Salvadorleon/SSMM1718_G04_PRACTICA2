package es.ujaen.git.sm1718_g04_practica01;

/**
 * Created by Salvaddorleon on 18/12/2017.
 */

public class PersonalData {         //declaramos los parámetros user y pass que deberán ser introducidos por el usuario.

    protected String user="";
    protected String pass="";
    protected String hola="";

    //Hago constructor con parámetros, para poder inicializar user y pass.
    public PersonalData(String user,String pass){
        this.user=user;
        this.pass=pass;
    }

    //Hago constructor por defecto.
    public PersonalData(){

    }

    //haciendo uso del get y set hacemos posible la conexión


    public String getUser() {

        return user;
    }

    public void setUser(String user) {

        this.user = user;
    }

    public String getPass() {

        return pass;
    }

    public void setPass(String pass) {

        this.pass = pass;
    }
}
