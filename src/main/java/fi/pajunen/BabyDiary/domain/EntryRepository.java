package fi.pajunen.BabyDiary.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, Long>{

	List<Entry> findByEntrydate(String string);

}
