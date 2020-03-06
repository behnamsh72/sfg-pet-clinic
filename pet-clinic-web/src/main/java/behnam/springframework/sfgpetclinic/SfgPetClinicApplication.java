package behnam.springframework.sfgpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

@SpringBootApplication
public class SfgPetClinicApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context=SpringApplication.run(SfgPetClinicApplication.class, args);
        System.out.println("Hi start truly");
        BufferedReader keybd=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(keybd.readLine());
    }

}
