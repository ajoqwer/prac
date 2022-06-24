package com.prac.gw.board;

import java.util.List;

public interface BoardService {
    public UserVO login(UserVO vo);
    public String signup(UserVO vo);
    public List<BoardVO> boardList(BoardVO vo);   
    public BoardVO boardContent(BoardVO vo);   
    public void commentProc(CommentVO vo);
    public List<CommentVO> commentList(CommentVO vo);
}
