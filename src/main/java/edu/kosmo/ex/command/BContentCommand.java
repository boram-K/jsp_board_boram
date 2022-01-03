package edu.kosmo.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosmo.ex.dao.BDao;
import edu.kosmo.ex.dto.BDto;
//작성글 보기
public class BContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		int cid = Integer.parseInt(bid);
		
		BDao bao = new BDao();
		BDto bto = bao.contentview(cid);
		
		request.setAttribute("content", bto);

	}

}
