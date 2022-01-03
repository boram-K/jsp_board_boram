package edu.kosmo.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BSaveCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글번호저장중..");
		String bid = request.getParameter("bid");
		int cid = Integer.parseInt(bid);
		
		request.setAttribute("cid", cid);
				
	}

}
