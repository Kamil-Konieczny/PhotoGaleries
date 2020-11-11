package pl.kamil.PhotoGaleries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.kamil.PhotoGaleries.DBConnection.ClientRepository;
import pl.kamil.PhotoGaleries.DBConnection.ClientService;
import pl.kamil.PhotoGaleries.Entities.Client;

@SpringBootApplication
public class PhotoGaleriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoGaleriesApplication.class, args);

	}

}
