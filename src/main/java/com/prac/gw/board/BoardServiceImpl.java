package com.prac.gw.board;

import com.prac.gw.mapper.BoardMapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardMapper boardMapper;



    @Override
    public UserVO login(UserVO vo) {
        UserVO result = new UserVO();
        System.out.println("엣헴 " +vo.toString());
        try {
            result = boardMapper.login(vo);
            if( result.getId() != null) {
                result.setResult("1");
            } else {
                result.setResult("0");
            }
        }catch(Exception e) {
            result.setResult("2");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String signup(UserVO vo) {
        String result = "1";
        try {
            boardMapper.signup(vo);
        } catch(Exception e) {
            e.printStackTrace();
            return "2";
        }
        return result;
    }

    @Override
    public List<BoardVO> boardList(BoardVO vo) {
        // TODO Auto-generated method stub 페이징처리 안함
        List<BoardVO> list = new ArrayList<>();
        try{
            list = boardMapper.boardList(vo);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public BoardVO boardContent(BoardVO vo) {
        BoardVO result = new BoardVO();
        try{
            result = boardMapper.boardContent(vo);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void commentProc(CommentVO vo) {
        
        try {
            boardMapper.commentProc(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<CommentVO> commentList(CommentVO vo) {
        List<CommentVO> list = new ArrayList<>();
        try {
            list = boardMapper.commentList(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    
}
