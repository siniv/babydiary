package fi.pajunen.BabyDiary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.pajunen.BabyDiary.domain.Category;
import fi.pajunen.BabyDiary.domain.CategoryRepository;
import fi.pajunen.BabyDiary.domain.Entry;
import fi.pajunen.BabyDiary.domain.EntryRepository;
import fi.pajunen.BabyDiary.domain.User;
import fi.pajunen.BabyDiary.domain.UserRepository;

@SpringBootApplication
public class BabyDiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabyDiaryApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(EntryRepository erepository, CategoryRepository crepository, 
			UserRepository urepository) {
		
		return (args) -> {
			crepository.save(new Category("Päivittäiset"));
			crepository.save(new Category("Uusi taito"));
			crepository.save(new Category("Huoli"));
			
			erepository.save(new Entry("2020-10-05", 3, 5, 6, 8, "perus päivä", crepository.findByName("Päivittäiset").get(0)));
			//erepository.save(new Entry("JokuToinen", "ToinenKirjoittaja", 2019, "ISBN1235", 90, crepository.findByName("Horror").get(0)));
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			User user3 = new User("äiti", "$2a$10$HuVnU/8mQVLQrJZzve8Ege5b8SeM7Oh9banozmyeCI.bgnten1q.u", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			
		};
	}

}
