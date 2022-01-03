package edu.kosmo.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosmo.ex.dao.BDao;

//삭제 시 비밀번호 체크
public class BDCheckCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		int cid = Integer.parseInt(bid);
		
		String upw = request.getParameter("num");
		int num = Integer.parseInt(upw);
		
		BDao bao = new BDao();
		int pw = bao.pwCheck(cid);
		
		if(pw==num) { //맞으면 삭제 실행
			request.setAttribute("viewD", "delete.do");
		}else { //틀리면 다시 목록으로
			request.setAttribute("viewD", "pList.do");
		}

	}

}
