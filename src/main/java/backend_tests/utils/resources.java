package backend_tests.utils;

public class resources {
    public static String baseURL() {
        String base = "http://85.93.17.135:9000";
        return base;
    }

    public static String placePostData() {
        String res = "/user/save";
        return res;
    }

    public static String getUsers(){
        String users = "/user/all/json";
        return users;
    }

    public static String deleteUsers(){
        String del = "/user/all";
        return del;
    }
}
