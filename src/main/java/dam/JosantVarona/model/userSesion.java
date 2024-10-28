package dam.JosantVarona.model;

/**
 * Esta Clase hace crea una instacia que la guarda en la memoria ram
 * y esto hace que usaemos esta variable en todo el programa,
 * en esta caso es para manter la sesion inicida del usuario
 */
public class userSesion {
    private static userSesion _instance;
    private static User userLoged;

    private userSesion() {
    }

    public static userSesion getInstancia() {
        if (_instance == null) {
            _instance = new userSesion();
            _instance.logIn(userLoged);
        }
        return _instance;
    }

    public void logIn(User user) {
        userLoged = user;
    }

    public User getUsuarioIniciado() {
        return userLoged;
    }

    public void logOut() {
        userLoged = null;
    }
}