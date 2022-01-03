package edu.kosmo.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosmo.ex.dao.BDao;


//글 수정시 비밀번호 체크
public class BMCheckCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bid = request.getParameter("mid");
		int cid = Integer.parseInt(bid);

		String upw = request.getParameter("num");
		int num = Integer.parseInt(upw);
		
		BDao bao = new BDao();
		int pw = bao.pwCheck(cid);
		request.setAttribute("modifyID", cid);
		if(pw==num) {
			request.setAttribute("viewM", "modify_view.do");
			
		}else {
			request.setAttribute("viewM", "list.do");
		}
		
	}

}
