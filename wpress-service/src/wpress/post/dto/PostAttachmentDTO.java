package wpress.post.dto;

public class PostAttachmentDTO {
	
	private String attach_title;
	private String attach_name;
	private String attach_link;
		
	public PostAttachmentDTO() {
		super();
	}
	
	public String getAttach_title() {
		return attach_title;
	}

	public void setAttach_title(String attach_title) {
		this.attach_title = attach_title;
	}

	public String getAttach_name() {
		return attach_name;
	}
	public void setAttach_name(String attach_name) {
		this.attach_name = attach_name;
	}
	public String getAttach_link() {
		return attach_link;
	}
	public void setAttach_link(String attach_link) {
		this.attach_link = attach_link;
	}

}
