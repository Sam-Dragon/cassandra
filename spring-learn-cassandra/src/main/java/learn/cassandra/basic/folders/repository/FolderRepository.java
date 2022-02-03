package learn.cassandra.basic.folders.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import learn.cassandra.basic.folders.model.Folder;

@Repository
public interface FolderRepository extends CassandraRepository<Folder, String> {

	List<Folder> findAllById(String id);
}
