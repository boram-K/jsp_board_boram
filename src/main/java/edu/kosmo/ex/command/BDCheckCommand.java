package edu.kosmo.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosmo.ex.dao.BDao;

public class BDCheckCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		int cid = Integer.parseInt(bid);
		
		String upw = request.getParameter("num");
		int num = Integer.parseInt(upw);
		
		BDao bao = new BDao();
		int pw = bao.pwCheck(cid);
		
		if(pw==num) {
			request.setAttribute("viewD", "delete.do");
		}else {
			request.setAttribute("viewD", "list.do");
		}

	}

}
