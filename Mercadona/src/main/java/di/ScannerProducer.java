package di;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;

import java.util.Scanner;

public class ScannerProducer {
    @Produces
    @Singleton
    public Scanner produceScanner() {
        return new Scanner(System.in);
    }
}
