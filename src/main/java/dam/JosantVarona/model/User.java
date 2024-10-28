    package dam.JosantVarona.model;

    import javax.xml.bind.annotation.XmlAccessType;
    import javax.xml.bind.annotation.XmlAccessorType;
    import javax.xml.bind.annotation.XmlElement;
    import javax.xml.bind.annotation.XmlRootElement;
    import java.security.MessageDigest;
    import java.security.NoSuchAlgorithmException;
    import java.util.Objects;

    @XmlRootElement (name = "user")
    @XmlAccessorType (XmlAccessType.FIELD)


    public class User {

        @XmlElement
        public String username;
        @XmlElement
        public String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
        public User (){

        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(username, user.username);
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';

        }
        public static String segurity(String pass){
            String result = null;
            try {

                MessageDigest digest = MessageDigest.getInstance("SHA-256");

                byte[] hashedBytes = digest.digest(pass.getBytes());

                StringBuilder stringBuilder = new StringBuilder();
                for (byte b : hashedBytes) {
                    stringBuilder.append(String.format("%02x", b));
                }
                String hashedPassword = stringBuilder.toString();

                result = hashedPassword;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return result;
        }
    }
