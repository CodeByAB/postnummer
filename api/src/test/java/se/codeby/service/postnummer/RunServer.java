package se.codeby.service.postnummer;

public class RunServer {

    public static void main(String[] args) throws Exception {
        ZipCodeApplication.main("server", "api/config.yml");
    }
}
