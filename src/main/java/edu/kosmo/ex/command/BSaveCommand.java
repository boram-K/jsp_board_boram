package edu.kosmo.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//글 수정이나 삭제를 위해 중간에 글 번호 저장하기
public class BSaveCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글번호저장중..");
		String bid = request.getParameter("bid");
		int cid = Integer.parseInt(bid);
		
		request.setAttribute("cid", cid);
				
	}

}
