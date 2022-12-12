package ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        try (FileInputStream f = new FileInputStream("config/juancarlos.properties")) {
            Properties p = new Properties();
            p.load(f);
            System.out.println(p.getProperty("juancarlos_ip"));
        } catch (FileNotFoundException e) {
            System.out.println("no hay");
        }
        catch (IOException e) {
            System.out.println("fallo terrible");
        }
        catch (Exception e) {
            System.out.println("error 404");
        }
    }
}
