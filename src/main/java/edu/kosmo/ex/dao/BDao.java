package edu.kosmo.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.kosmo.ex.command.BPListCommand;
import edu.kosmo.ex.command.BSerchCommand;
import edu.kosmo.ex.dto.BDto;

public class BDao {
	private DataSource datasource;

	public BDao() {
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//글 작성
	public void write(String bname, String btitle, String bcontent, int bpw) {
		System.out.println("write..");

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = datasource.getConnection();
			String query = "insert into board (bId, bName, bTitle, bContent,bpw, bHit, bGroup, bStep, bIndent)"
					+ "VALUES (BOARD_SEQ.nextval, ?, ?, ?,?, 0, BOARD_SEQ.currval, 0, 0)";
			pstm = con.prepareStatement(query);

			pstm.setString(1, bname);
			pstm.setString(2, btitle);
			pstm.setString(3, bcontent);
			pstm.setInt(4, bpw);

			int rn = pstm.executeUpdate();
			System.out.println("갯수: " + rn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	//글 확인하기
	public BDto contentview(int cid) {
		upHit(cid);

		System.out.println("contentview...");

		BDto dto = null;

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM board WHERE bid = ?";

			con = datasource.getConnection();
			pstm = con.prepareStatement(query);
			pstm.setInt(1, cid);
			rs = pstm.executeQuery();

			if (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				int bpw = rs.getInt("bpw");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				dto = new BDto(bid, bname, btitle, bcontent, bpw, bdate, bhit, bgroup, bstep, bindent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					rs.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return dto;
	}
	
	//글 수정하기
	public void modify(int cid, String bname, String btitle, String bcontent) {
		System.out.println("modify....");

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			String query = "UPDATE board SET bname = ?, btitle=? , bcontent =? WHERE bid =?";
			con = datasource.getConnection();
			pstm = con.prepareStatement(query);
			pstm.setString(1, bname);
			pstm.setString(2, btitle);
			pstm.setString(3, bcontent);
			pstm.setInt(4, cid);

			int rn = pstm.executeUpdate();
			System.out.println("갯수" + rn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	//비밀번호 확인을 위해 해당 게시글의 비밀번호를 뽑아내는 함수
	public int pwCheck(int cid) {
		System.out.println("pwcheck..");
		int pass = 0;

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String query = "SELECT bpw FROM board WHERE bid=?";

			con = datasource.getConnection();
			pstm = con.prepareStatement(query);
			pstm.setInt(1, cid);
			rs = pstm.executeQuery();

			if (rs.next()) {
				pass = rs.getInt("bpw");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					rs.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return pass;

	}

	//글 삭제 
	public void delete(int cid) {
		System.out.println("delete..");

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			String query = "DELETE FROM board WHERE bid = ?";

			con = datasource.getConnection();
			pstm = con.prepareStatement(query);
			pstm.setInt(1, cid);

			int rn = pstm.executeUpdate();

			System.out.println("갯수: " + rn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	//답글이 원본글 아래에 달릴 수 있도록 모양을 잡아주는 것
	private void replyShape(int group, int step) {
		System.out.println("replyshape....");

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			String query = "update board set bStep = bStep + " + "1 where bGroup = ? and bStep > ?";
			con = datasource.getConnection();
			pstm = con.prepareStatement(query);
			pstm.setInt(1, group);
			pstm.setInt(2, step);

			int rn = pstm.executeUpdate();
			System.out.println("갯수:" + rn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	//답변달기
	public void reply(String bname, String btitle, String bcontent, int bpw, int bgroup, int bstep, int bindent) {

		System.out.println("reply.....");

		replyShape(bgroup, bstep);

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			String query = "insert into board (bId, bname, btitle, bcontent,bpw,bGroup, bStep, bIndent)"
					+ "VALUES (BOARD_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)";

			con = datasource.getConnection();
			pstm = con.prepareStatement(query);
			pstm.setString(1, bname);
			pstm.setString(2, btitle);
			pstm.setString(3, bcontent);
			pstm.setInt(4, bpw);
			pstm.setInt(5, bgroup); // 원본
			pstm.setInt(6, bstep + 1);// 세로+1
			pstm.setInt(7, bindent + 1);// 가로+1

			int rn = pstm.executeUpdate();

			System.out.println("갯수: " + rn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	//답변 글 보기.. 하지만 컨텐트 뷰로 대체해도 상관없을 듯...?
	public BDto reply_view(int cid) {
		upHit(cid);

		System.out.println("reply_view...");

		BDto dto = null;

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM board WHERE bid = ?";
			con = datasource.getConnection();
			pstm = con.prepareStatement(query);
			pstm.setInt(1, cid);
			rs = pstm.executeQuery();

			if (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				int bpw = rs.getInt("bpw");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				dto = new BDto(bid, bname, btitle, bcontent, bpw, bdate, bhit, bgroup, bstep, bindent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					rs.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return dto;
	}

	//조회수 올리는 함수 글을 볼 때마다 bhit가 +1이 된다
	public void upHit(int cid) {
		System.out.println("uphit...");

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			String query = "UPDATE board SET bhit = bhit +1 WHERE bid = ?";

			con = datasource.getConnection();
			pstm = con.prepareStatement(query);

			pstm.setInt(1, cid);

			int rn = pstm.executeUpdate();

			System.out.println("갯수: " + rn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	// 페이지 번호와, 보여줄 게시글 수
	public ArrayList<BDto> pageList(int pageNum) {

		System.out.println("pageList...");

		ArrayList<BDto> btos = new ArrayList<BDto>();

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM (SELECT ROWNUM rn, A.* FROM "
					+ "(SELECT * FROM board ORDER by bgroup DESC, bstep asc )" + " A) WHERE rn BETWEEN ? and ?";

			con = datasource.getConnection();
			pstm = con.prepareStatement(query);
			int start = (pageNum - 1) * BPListCommand.pagePerList + 1; // 시작게시글
			int end = start + BPListCommand.pagePerList - 1; // 끝 게시글
			pstm.setInt(1, start);
			pstm.setInt(2, end);
			rs = pstm.executeQuery();

			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				int bpw = rs.getInt("bpw");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				BDto dto = new BDto(bid, bname, btitle, bcontent, bpw, bdate, bhit, bgroup, bstep, bindent);
				btos.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return btos;

	}
	
	//페이징 배열에 첫페이지와 마지막 페이지를 담았다
	public int[] paging(int pageNum) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		int[] startEnd = new int[2]; // 결과전달

		try {
			String query = "select count(*) as total from board";
			con = datasource.getConnection();
			pstm = con.prepareStatement(query);
			rs = pstm.executeQuery();

			int totalContent = 0; // 전체 게시글 수
			int totalPage = 0;// 총 페이지 수

			if (rs.next()) {
				totalContent = rs.getInt("total");
				System.out.println("총 게시글 수는 " + totalContent);
			}

			totalPage = totalContent / BPListCommand.pagePerList; // 최종 페이지수
			if (totalContent % BPListCommand.pagePerList > 0) {
				totalPage++;
			}
			System.out.println("총 페이지 수:" + totalPage);

			// 페이지 범위 계산
			int startPage, endPage;

			startPage = ((pageNum - 1) / BPListCommand.pagingCount) * BPListCommand.pagingCount + 1;
			endPage = startPage + BPListCommand.pagingCount - 1;
			if (endPage > totalPage) {
				endPage = totalPage;
			}

			startEnd[0] = startPage;
			startEnd[1] = endPage;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return startEnd;
	}
	//게시글 검색용. 
	public ArrayList<BDto> serchList(int pageNum,String title) {

		System.out.println("serchList...");

		ArrayList<BDto> btos = new ArrayList<BDto>();

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String query ="SELECT * FROM (SELECT ROWNUM rn, A.* FROM "
					+ "(SELECT * FROM board WHERE btitle "
					+ "LIKE ? ORDER by bgroup DESC, bstep asc ) "
					+ "A) WHERE rn BETWEEN ? and ?";

			con = datasource.getConnection();
			pstm = con.prepareStatement(query);
			int start = (pageNum - 1) * BPListCommand.pagePerList + 1; // 시작게시글
			int end = start + BPListCommand.pagePerList - 1; // 끝 게시글
			pstm.setString(1, "%"+title+"%");
			pstm.setInt(2, start);
			pstm.setInt(3, end);
			rs = pstm.executeQuery();

			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				int bpw = rs.getInt("bpw");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				BDto dto = new BDto(bid, bname, btitle, bcontent, bpw, bdate, bhit, bgroup, bstep, bindent);
				btos.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println(btos);
		return btos;

	}
	//검색용 페이징 
	public int[] serchpaging(int pageNum,String serch) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		int[] startEnd = new int[2]; // 결과전달

		try {
			String query = "select count(*) as total from board WHERE btitle LIKE ?";
			con = datasource.getConnection();
			pstm = con.prepareStatement(query);
			pstm.setString(1, serch);
			rs = pstm.executeQuery();

			int totalContent = 0; // 전체 게시글 수
			int totalPage = 0;// 총 페이지 수

			if (rs.next()) {
				totalContent = rs.getInt("total");
				System.out.println("검색 게시글 수는 " + totalContent);
			}

			totalPage = totalContent / BPListCommand.pagePerList; // 최종 페이지수
			if (totalContent % BPListCommand.pagePerList > 0) {
				totalPage++;
			}
			System.out.println("검색 페이지 수:" + totalPage);

			// 페이지 범위 계산
			int startPage, endPage;

			startPage = ((pageNum - 1) / BSerchCommand.pagingCount) * BSerchCommand.pagingCount + 1;
			endPage = startPage + BSerchCommand.pagingCount - 1;
			if (endPage > totalPage) {
				endPage = totalPage;
			}

			startEnd[0] = startPage;
			startEnd[1] = endPage;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return startEnd;
	}
}
