package com.prac.gw.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping("/")
    public ModelAndView lolgin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
    
    @RequestMapping("/loginProc")
    @ResponseBody
    public UserVO loginProc(HttpServletRequest request){
        UserVO vo = new UserVO();
        vo.setId(request.getParameter("id"));
        vo.setPw(request.getParameter("pw"));
        UserVO result = boardService.login(vo);
        if(result.getResult().equals("1")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("id", result.getId());
            session.setAttribute("nickname", result.getNickname());
            session.setMaxInactiveInterval(3600);
        };
        return result;
    }
    
    @RequestMapping("/signup")
    @ResponseBody
    public String signup(HttpServletRequest request){
        UserVO vo = new UserVO();
        vo.setId(request.getParameter("id"));
        vo.setPw(request.getParameter("pw"));
        vo.setNickname(request.getParameter("nickname"));
        return boardService.signup(vo);
    }
    
    @RequestMapping("/board")
    public ModelAndView board(HttpServletRequest request) {
        BoardVO vo = new BoardVO();
        ModelAndView mav = new ModelAndView();
        mav.addObject("boardList", boardService.boardList(vo)) ;
        mav.setViewName("board");
        return mav;
    }

    @RequestMapping("/content")
    public ModelAndView content(HttpServletRequest request) {
        BoardVO vo = new BoardVO();
        ModelAndView mav = new ModelAndView();

        vo.setIdx(Integer.parseInt(request.getParameter("idx")));
        mav.addObject("content", boardService.boardContent(vo)) ;
        mav.setViewName("content");

        return mav;
    }

    @RequestMapping("/commentList")
    @ResponseBody
    public List<CommentVO> commentList(HttpServletRequest request) {
        CommentVO vo = new CommentVO();
        vo.setBoardId(Integer.parseInt(request.getParameter("boardId")));
        return boardService.commentList(vo);
    }

    @RequestMapping("/commentProc")
    @ResponseBody
    public void commentProc(HttpServletRequest request) {
        CommentVO vo = new CommentVO();
        int replyId;
        vo.setReplyLevel(Integer.parseInt(request.getParameter("replyLevel")));
        if(!request.getParameter("replyId").isEmpty() ){
            replyId = Integer.parseInt(request.getParameter("replyId"));
            vo.setReplyId( replyId );
        }
        vo.setUserId(request.getSession().getAttribute("id").toString());
        vo.setCommentContent(request.getParameter("commentContent"));
        vo.setBoardId(Integer.parseInt(request.getParameter("boardId")));
        boardService.commentProc(vo);
    }
}
