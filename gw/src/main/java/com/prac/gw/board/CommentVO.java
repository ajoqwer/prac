package com.prac.gw.board;

import lombok.Data;

@Data
public class CommentVO {
    
    int commentId;
    int boardId;
    String userId;
    String commentContent;
    int replyLevel;
    String nickname;
    int replyId;

}
