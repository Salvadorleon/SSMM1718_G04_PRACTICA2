package es.ujaen.git.sm1718_g04_practica01;


/**
 * Created by usuario on 04/10/2017.
 */

public class ConnectionUserData extends PersonalData {
    protected String connectionIP="127.0.0.1";          //aquí se declara cuál será la IP a usar
    protected short connectionPort=6000;                // aquí se declara el puerto a usar

    public ConnectionUserData(String user,String pass,String ip,short port){
        super(user,pass);
        this.connectionIP=ip;
        this.connectionPort=port;
    }

    public String getConnectionIP() {
        return connectionIP;
    }     //hacemos uso del get y set para establecer la conexión

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
