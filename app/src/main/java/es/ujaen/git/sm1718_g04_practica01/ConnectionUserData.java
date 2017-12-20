package es.ujaen.git.sm1718_g04_practica01;


/**
 * Created by Salvadorleon on 18/12/2017.
 */

public class ConnectionUserData extends PersonalData {
    protected String connectionIP="127.0.0.1";          //aquí se declara cuál será la IP a usar
    protected short connectionPort=80;                // aquí se declara el puerto a usar

    public ConnectionUserData(String user,String pass,String ip,short port){
        //Con este super podemos usar los parámetros de la clase padre "PersonaData".
        super(user,pass);
        this.connectionIP=ip;
        this.connectionPort=port;
    }

    public ConnectionUserData(String user,String pass){
        super(user,pass);
    }
    //hacemos uso del get y set para establecer la conexión

    public String getConnectionIP() {
        return connectionIP;
    }

    public void setConnectionIP(String connectionIP) {

        this.connectionIP = connectionIP;
    }

    public short getConnectionPort() {

        return connectionPort;
    }

    public void setConnectionPort(short connectionPort) {

        this.connectionPort = connectionPort;
    }
}
