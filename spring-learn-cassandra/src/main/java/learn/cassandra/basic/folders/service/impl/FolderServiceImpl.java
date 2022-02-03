package learn.cassandra.basic.folders.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.cassandra.basic.folders.model.Folder;
import learn.cassandra.basic.folders.repository.FolderRepository;
import learn.cassandra.basic.folders.service.FolderService;

@Service
public class FolderServiceImpl implements FolderService {

	@Autowired
	private FolderRepository repository;

	public Folder addFolder(Folder request) {
		return repository.save(request);
	}

	@Override
	public List<Folder> getFolders() {
		return repository.findAll();
	}
}
