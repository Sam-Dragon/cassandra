package learn.cassandra.basic.folders.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import learn.cassandra.basic.folders.model.Folder;
import learn.cassandra.basic.folders.repository.FolderRepository;
import learn.cassandra.basic.folders.service.FolderService;

@Controller
public class InboxController {

	@Autowired
	private FolderRepository repository;
	
	@Autowired
	private FolderService service;

	@PostConstruct
	public void init() {
		repository.saveAll(List.of(new Folder("Rahul", "inbox", "white"), new Folder("Rahul", "sent", "yellow"),
				new Folder("Rahul", "recieved", "red")));
	}

	@GetMapping("/")
	public String homePage(@AuthenticationPrincipal OAuth2User principal, Model model) {
		if (!StringUtils.isEmpty(principal) && StringUtils.hasText(principal.getAttribute("name"))) {
			String userId = principal.getAttribute("name");
			model.addAttribute("userFolders", repository.findAllById(userId));

			model.addAttribute("defaultFolders",service.getFolders());
			
			return "inbox-page";
		} else
			return "index";
	}
}
