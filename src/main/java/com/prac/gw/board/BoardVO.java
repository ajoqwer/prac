package com.prac.gw.board;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {

    int idx;
    String title;
    String content;
    String writerId;
    Date regDate;
}
