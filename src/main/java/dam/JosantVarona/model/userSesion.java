package dam.JosantVarona.model;

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