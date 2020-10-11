/*package fi.pajunen.BabyDiary;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.pajunen.BabyDiary.domain.Category;
import fi.pajunen.BabyDiary.domain.Entry;
import fi.pajunen.BabyDiary.domain.EntryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EntryRepositoryTest {
	
	@Autowired
	private EntryRepository repository;
	
    @Test
    public void findByEntrydateShouldFindOneEntry() {
        List<Entry> entries = repository.findByEntrydate("2020-10-05");
        
        assertThat(entries).hasSize(1);
        assertThat(entries.get(0).getOther()).isEqualTo("Perus päivä");
    }
    
    @Test
    public void createNewEntry() {
    	Entry entry = new Entry("2020-10-04", 2, 2, 2, 2, "Kiva päivä", new Category("Päivittäiset"));
    	repository.save(entry);
    	assertThat(entry.getId()).isNotNull();
    }    

}*/
