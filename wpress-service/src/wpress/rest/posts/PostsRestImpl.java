package wpress.rest.posts;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import wpress.post.PostService;
import wpress.post.dto.PostDTO;


@Path("/post")
@Produces(MediaType.APPLICATION_JSON)
@Stateless 
public class PostsRestImpl {
	
	@Inject
	private PostService postService;
	
	@GET
	@Path("alive")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public String aliveMethod(){
		return "Yes baby, i'm alive";
	}
	
	@GET
	@Path("store/posts/{amount}/{offset}")
	public ArrayList<PostDTO> getStorePosts(@PathParam("amount") String amount, 
							  @PathParam("offset") String offset){
		return postService.getStorePosts(amount, offset);
	}
	
}
