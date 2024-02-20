package sn.ucad.covid19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sn.ucad.covid19.entities.Cas;
import sn.ucad.covid19.repository.ICas;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Covid19Application implements CommandLineRunner {
	@Autowired
    private ICas icasrepository;
	public static void main(String[] args) {
		SpringApplication.run(Covid19Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
      Cas cas = new Cas();
	  cas.setVille("Test ville");
	  cas.setQuartier("Test quartier");
	  Date date =null;
		SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
		date = date1.parse("2024-02-20");
		cas.setDate(date);
	  icasrepository.save(cas);
	  icasrepository.findAll().forEach(c->System.out.println(c.getVille()));
	}
}
