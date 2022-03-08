package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Likes;
import tn.esprit.spring.entity.NotificationObject;
import tn.esprit.spring.entity.Notifications;
import tn.esprit.spring.service.ILikesService;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikesController {
	@Autowired
	ILikesService LikesService;
	@Autowired
    public JavaMailSender emailSender;
	
	NotificationObject NotificationObject;
	Notifications Notifications;
	
	//http://localhost:8083/PIDEV/likes/retrieve-all-likes
	@GetMapping("/retrieve-all-likes")
	public List<Likes> getLikes() {
	List<Likes> listLikes = LikesService.retrieveAllLikes();
	return listLikes;
	}
	
	public void LikeNotification(String poster, String liker) {
		
		//forumpostid tjib beha forum
		//forum tjib menou id luser(poster)
		//like tjib menha id luser(liker)

    	//String poster = "esmek";//esm eli habet lpost
    	//String liker = "esmou";//esm eli 7at like
    	
    	// Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
        
        message.setTo("farouk.belhassine@esprit.tn");//mail ta3 luser(poster)
        message.setSubject("Like notification!");
        message.setText("Hello "+poster+", your post was liked by "+liker+", go check it out!");

        // Send Message!
        this.emailSender.send(message);
    }
	
	//http://localhost:8083/PIDEV/likes/add-like
	@PostMapping("/add-like")
	@ResponseBody
	public Likes addLike(@RequestBody Likes L)
	{
		Likes Like = LikesService.addLike(L);
		
		NotificationObject no = new NotificationObject(L.getForumPost().getId(),L.getNewsFeedPostId(), 2, new Timestamp(System.currentTimeMillis()));
		
		LikesService.addobjnotif(no);
		
		no.setId(LikesService.findlastobj());
		
		if(L.getForumPost().getId()!=null){
			Notifications N = new Notifications(LikesService.retrieveForumPostUserId(L.getForumPost().getId()),no);
			System.out.println(no.toString());
			LikesService.addNotification(N);
		}
		else if(L.getNewsFeedPostId()!=null){
			Notifications N = new Notifications(LikesService.retrieveForumPostUserId(L.getNewsFeedPostId()),no);
			//Notifications N = new Notifications(LikesService.retrieveNewsFeedPostUserId(L.getNewsFeedPostId()),LikesService.findlastobj());
			LikesService.addNotification(N);
		}
		
		LikeNotification("esm moula lpost","esm li 7at like");
		
		return Like;
	}
	
	//http://localhost:8083/PIDEV/likes/remove-like/{id}
	@DeleteMapping("/remove-like/{id}")
	@ResponseBody
	public void removeLike(@PathVariable("id") Long id) {
		LikesService.deleteLike(id);
	}
	
	//http://localhost:8083/PIDEV/likes/modify-like
	@PutMapping("/modify-like")
	@ResponseBody
	public Likes modifyLike(@RequestBody Likes Like) {
	return LikesService.updateLike(Like);
	}
}
