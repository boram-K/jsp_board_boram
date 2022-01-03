package edu.kosmo.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosmo.ex.dao.BDao;
import edu.kosmo.ex.dto.BDto;


public class BSerchCommand implements BCommand {

	// 한 화면에 보여줄 리스트 갯수, 페이징 범위의 갯수
	public static final int pagePerList = 10;
	public static final int pagingCount = 15;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		String serch = request.getParameter("serch");
		
		
		
		String page = request.getParameter("pageNum");
		if(page ==null) {
			page = "1";
		}
		int pagenum = Integer.valueOf(page);
		
		
		
		BDao dao = new BDao();
		
		int[] paging = dao.serchpaging(pagenum, serch);
		
		ArrayList<BDto> btos = dao.serchList(pagenum, serch);
		
		request.setAttribute("pageS", paging);
		request.setAttribute("pList", btos);
		request.setAttribute("s", serch);

	}

}
