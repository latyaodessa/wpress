package wpress.post.dto;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

public class PostDTO {
	private long post_id;
	private Date post_date;
	private String post_title;
	private String post_content;
	private String post_name;
	private String post_link;
	private Set<PostAttachmentDTO> postAttachments;
	
	public static PostDTO createPostDTOObject(){
		PostDTO dto = new PostDTO();
		dto.setPostAttachments(Collections.emptySet());
		return dto;
	}
	
	public Set<PostAttachmentDTO> getPostAttachments() {
		return postAttachments;
	}

	public void setPostAttachments(Set<PostAttachmentDTO> postAttachments) {
		this.postAttachments = postAttachments;
	}


	public long getPost_id() {
		return post_id;
	}
	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public String getPost_link() {
		return post_link;
	}
	public void setPost_link(String post_link) {
		this.post_link = post_link;
	}

	
}
