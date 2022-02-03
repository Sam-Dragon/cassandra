package learn.cassandra.basic.folders.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import learn.cassandra.basic.folders.model.Folder;

@Service
public class FolderService {

	public List<Folder> fetchDefaultFolders(String userId) {
		return Arrays.asList(new Folder(userId, "Inbox", "white"), new Folder(userId, "Sent Items", "Green"),
				new Folder(userId, "Important", "Red"));
	}
}
