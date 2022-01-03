package edu.kosmo.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosmo.ex.dao.BDao;

public class BReplyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//String bname, String btitle, String bcontent, int bpw, int bgroup, int bstep, int bindent
		
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bpw = request.getParameter("bpw");
		String bgroup = request.getParameter("bgroup");
		String bstep = request.getParameter("bstep");
		String bindent = request.getParameter("bindent");
		
		int pw = Integer.parseInt(bpw);
		int group = Integer.parseInt(bgroup);
		int step = Integer.parseInt(bstep);
		int indent = Integer.parseInt(bindent);
		
		BDao bao = new BDao();
		bao.reply(bname, btitle, bcontent, pw, group, step, indent);
		
		request.setAttribute("reply", bao);
		
		
	}

}
