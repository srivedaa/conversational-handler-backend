package com.example.demo;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

import java.util.*;

@RestController
@CrossOrigin(value="http://localhost:4200")
class ConversationalController {
	 @Autowired
	 private RestTemplate restTemplate;
	 List<UserDetails> userList = new ArrayList<UserDetails>();
	 int count=0;
	 String nextId; 
	 @GetMapping(value="/transition/{id}/{name}" , produces = "application/json")
	 public List<UserDetails> getDetails(@PathVariable("id") String id ,@PathVariable("name") String name) {
		
		 RestTemplate restTemplate = new RestTemplate();
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 
		

		 
		 Map<String,String> endPoints = new HashMap<String,String>();
		 endPoints.put("s2", "s3");
		 
		 endPoints.put("s3", "s9");
		 endPoints.put("s9", "s6");
		 endPoints.put("s6","s1");
		 
		 
		 if(id.equals("s2") || id.equals("s3") || id.equals("s9") || id.equals("s6")) {
			 UserDetails ud = new UserDetails();
			 ud.setName(name);
			 ud.setDate(new Date().toLocaleString());
			 ud.setTransition(id);
			 ud.setNextTransition(endPoints.get(id));
			 userList.add(ud);
			 return userList;
		 }
	
		 else {
			 UserDetails ud = new UserDetails();
			 ud.setName("null");
			 ud.setDate("null");
			 ud.setTransition("service denied");
			 int lsize = userList.size();
			 nextId = userList.get(lsize-1).getNextTransition();
			 ud.setNextTransition(nextId);
			 userList.add(ud);
			 return userList;
		 }
		
	 }
}
