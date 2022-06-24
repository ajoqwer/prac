package com.prac.gw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.prac.gw.board.BoardVO;
import com.prac.gw.board.CommentVO;
import com.prac.gw.board.UserVO;

@Mapper
public interface BoardMapper {
    
    public UserVO login(UserVO vo);
    public void signup(UserVO vo);
    public List<BoardVO> boardList(BoardVO vo);
    public BoardVO boardContent(BoardVO vo);
    public void commentProc(CommentVO vo);
    public List<CommentVO> commentList(CommentVO vo);
}
