package edu.kosmo.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosmo.ex.dao.BDao;
import edu.kosmo.ex.dto.BDto;


//답글 보기
public class BReply_viewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String uid = request.getParameter("bid");
		int cid = Integer.parseInt(uid);
		BDao bao = new BDao();
		BDto bto = bao.reply_view(cid);
		
		request.setAttribute("reply_view", bto);

	}

}
