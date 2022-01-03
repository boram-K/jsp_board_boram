package edu.kosmo.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosmo.ex.command.BCommand;
import edu.kosmo.ex.command.BContentCommand;
import edu.kosmo.ex.command.BDCheckCommand;
import edu.kosmo.ex.command.BDeleteCommand;
import edu.kosmo.ex.command.BMCheckCommand;
import edu.kosmo.ex.command.BModifyCommand;
import edu.kosmo.ex.command.BPListCommand;
import edu.kosmo.ex.command.BReplyCommand;
import edu.kosmo.ex.command.BReply_viewCommand;
import edu.kosmo.ex.command.BSaveCommand;
import edu.kosmo.ex.command.BSerchCommand;
import edu.kosmo.ex.command.BWriteCommand;



/**
 * Servlet implementation class BController
 */
@WebServlet("*.do")
public class BController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doget"); // 디버깅용 문구
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post"); // 디버깅용 문구
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("action....");
	
		request.setCharacterEncoding("UTF-8");
	
		String viewPage = null;
		BCommand command = null;
		
		String uri = request.getRequestURI();
		String conpath = request.getContextPath();
		String com = uri.substring(conpath.length());
		
		if(com.equals("/pList.do")) { //리스트보기
			command = new BPListCommand();
			command.execute(request,response);
			viewPage = "pList.jsp";			
		}else if(com.equals("/write_view.do")) { //글작성화면
			viewPage ="write_view.jsp";
		}else if(com.equals("/write.do")) {//작성버튼 눌렀을 때
			command = new BWriteCommand();
			command.execute(request,response);
			viewPage="pList.do";
		}else if(com.equals("/content_view.do")) {//글 확인
			command = new BContentCommand();
			command.execute(request,response);
			viewPage="content_view.jsp";
		}else if(com.equals("/modify_view.do")) {//글 수정화면보기
			viewPage = "modify_view.jsp";
		}else if(com.equals("/modify.do")) {//글 수정확인누르면
			command = new BModifyCommand();
			command.execute(request,response);
			viewPage = "pList.do";
		}else if(com.equals("/mpwCheckForm.do")) {//수정 버튼 눌렀을 때,
			command = new BSaveCommand();
			command.execute(request, response);
			viewPage="mpwCheckForm.jsp";
		}else if(com.equals("/mpwCheck.do")) {
			command = new BMCheckCommand();
			command.execute(request,response);
			String view = (String)request.getAttribute("viewM");
			viewPage = view;			
		}else if(com.equals("/delete.do")) { //삭제 버튼 눌렀을 때
			command = new BDeleteCommand();
			command.execute(request,response);
			viewPage = "pList.do";
		}else if(com.equals("/dpwCheckForm.do")) {//글 삭제 버튼 눌렀을 때
			command = new BSaveCommand();
			command.execute(request, response);
			viewPage = "dpwCheckForm.jsp";
		}else if(com.equals("/dpwCheck.do")) { //비번 입력시 다음으로 어느페이지로 갈 것인가.			
			command = new BDCheckCommand();
			command.execute(request,response);
			String view = (String)request.getAttribute("viewD");
			viewPage = view;
		}else if(com.equals("/reply_view.do")){//답변 글보기
			command = new BReply_viewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		}else if(com.equals("/reply.do")){ //답변 올리기 버튼 눌렀을 적에
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "pList.do";	
		}else if(com.equals("/serch.do")){ //답변 올리기 버튼 눌렀을 적에
			command = new BSerchCommand();
			command.execute(request, response);
			viewPage = "serchList.jsp";	
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response); 
	}
}
