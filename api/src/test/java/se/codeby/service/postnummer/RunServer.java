package se.codeby.service.postnummer;

public class RunServer {

    public static void main(String[] args) throws Exception {
        PostnummerApplication.main("db", "migrate", "api/config.yml");
        PostnummerApplication.main("server", "api/config.yml");
    }
}
