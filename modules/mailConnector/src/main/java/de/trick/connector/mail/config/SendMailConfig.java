package de.trick.connector.mail.config;

/**
 * Konfigurationsklasse für die SendMail-Klasse
 *
 * Created with IntelliJ IDEA.
 * User: dehmann
 * Date: 04.02.15
 * Time: 17:07
 * To change this template use File | Settings | File Templates.
 */
public class SendMailConfig {

    private String host;
    private int port;
    private boolean tls;
    private boolean debug;
    private boolean auth;
    private String user;
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isTls() {
        return tls;
    }

    public void setTls(boolean tls) {
        this.tls = tls;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
