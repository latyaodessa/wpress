package wpress.post;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.enterprise.inject.New;
import javax.inject.Inject;

import wpress.core.db.MySQLAccess;
import wpress.post.dto.PostDTO;

public class PostService {
	
	@Inject
	@New
	private MySQLAccess sql;
	@Inject
	private WooCommercePostConverter converter;
	
	public ArrayList<PostDTO> getStorePosts(final String amount, final String offset){
		
		String query = getPostQuery(amount, offset);
		ResultSet resultSet = sql.execQuery(query);
		
		ArrayList<PostDTO> postDtoList = converter.convertToDto(resultSet);
		getAttachments(postDtoList);
		
		return postDtoList;
	}
	
	private void getAttachments(ArrayList<PostDTO> postDtoList){
		postDtoList.stream().forEach( dto -> {
			String query = getAttachQuery(dto.getPost_id());
			ResultSet resultSet = sql.execQuery(query);
			dto.setPostAttachments(converter.convertAttachmentsToDto(resultSet));
		});
		
	}
	
	
	private String getPostQuery(final String amount, final String offset){
		return  "SELECT p.id post_id, Date(p.post_date) post_date, p.post_title, p.post_content, p.post_name, p.guid post_link"
				+ " FROM tem_posts as p WHERE post_type = 'product' AND post_status = 'publish' "
				+ "ORDER BY p.post_date DESC LIMIT "+ amount + " offset "+ offset;
	}
	
	private String getAttachQuery(final Long parent_post_id){
		return "SELECT attach.post_title attach_title, attach.post_name attach_name, attach.guid attach_link "
				+ "FROM tem_posts as attach"
				+ " WHERE attach.post_type = 'attachment' AND attach.post_parent = " + parent_post_id;
	}
}
