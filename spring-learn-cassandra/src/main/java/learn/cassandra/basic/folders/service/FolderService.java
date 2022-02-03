package learn.cassandra.basic.folders.service;

import java.util.List;

import learn.cassandra.basic.folders.model.Folder;

public interface FolderService {

	Folder addFolder(Folder request);

	List<Folder> getFolders();
}
