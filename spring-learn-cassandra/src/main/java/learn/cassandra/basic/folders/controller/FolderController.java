package learn.cassandra.basic.folders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learn.cassandra.basic.folders.model.Folder;
import learn.cassandra.basic.folders.service.FolderService;

@RestController
@RequestMapping("/folder")
public class FolderController {

	@Autowired
	private FolderService service;

	@PostMapping
	public ResponseEntity<Folder> addFolder(@RequestBody Folder request) {
		return ResponseEntity.ok(service.addFolder(request));
	}

	@GetMapping
	public ResponseEntity<List<Folder>> getFolders() {
		return ResponseEntity.ok(service.getFolders());
	}
}
