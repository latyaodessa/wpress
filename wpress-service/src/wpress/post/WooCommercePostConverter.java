package wpress.post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

import wpress.post.dto.PostAttachmentDTO;
import wpress.post.dto.PostDTO;

public class WooCommercePostConverter {
	
	public ArrayList<PostDTO> convertToDto(ResultSet rs){
		
		ArrayList<PostDTO> dtoList = new ArrayList<PostDTO>();
		
		   try {
			    while(rs.next()){
					PostDTO dto = PostDTO.createPostDTOObject();
					
					dto.setPost_id(rs.getLong("post_id"));
					dto.setPost_title(rs.getString("post_title"));
					dto.setPost_date(rs.getDate("post_date"));
					dto.setPost_content(rs.getString("post_content"));
					dto.setPost_name(rs.getString("post_name"));
					dto.setPost_link(rs.getString("post_link"));
					dtoList.add(dto);
			    }

			} catch (SQLException e) {
				e.printStackTrace();
			}		
		
		return dtoList;
	}
	
	public Set<PostAttachmentDTO> convertAttachmentsToDto(ResultSet rs){
		Set<PostAttachmentDTO> dtoSet = new HashSet<PostAttachmentDTO>();
		   try {
			    while(rs.next()){
			    	PostAttachmentDTO dto = new PostAttachmentDTO();
			    	
			    	dto.setAttach_title(rs.getString("attach_title"));
			    	dto.setAttach_name(rs.getString("attach_name"));
			    	dto.setAttach_link(rs.getString("attach_link"));		
					dtoSet.add(dto);
			    }

			} catch (SQLException e) {
				e.printStackTrace();
			}
		   return dtoSet;
	}
	
	public String convertToString(ResultSet rs) {
		
        ObjectMapper mapper = new ObjectMapper();
	    ArrayNode array = mapper.createArrayNode();
	    
	    try {
		    while(rs.next()){
		        ObjectNode node = mapper.createObjectNode();
			node.put("post_id", rs.getString("post_id"));
			node.put("post_date", rs.getString("post_date"));
			node.put("post_title", rs.getString("post_title"));
			node.put("post_content", rs.getString("post_content"));
			node.put("post_name", rs.getString("post_name"));
			node.put("post_link", rs.getString("post_link"));
			node.put("attach_title", rs.getString("attach_title"));
			node.put("attach_name", rs.getString("attach_name"));
			node.put("attach_link", rs.getString("attach_link"));
			
			array.add(node);
		    }

		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return array.toString(); 
	}
}
