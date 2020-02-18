package com.pjt1.demo.model.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

//도시 테이블
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Course {

    @Getter
    private int course_no;// int PRIMARY KEY AUTO_INCREMENT, # 코스 관리번호
    @NonNull
    @Getter
    @Setter
    private String post_no; // int NOT NULL, # 참조하는 게시글 번호
    @NonNull
    @Getter
    @Setter
    private String course_title;// varchar(100) NOT NULL, # 코스 제목(방문 장소 (ex) 송화마을)
    @Getter
    @Setter
    private String course_description; // course_description varchar(300) NOT NULL, # 간략한 첨부 내용
    @Getter
    @Setter
    private boolean course_del_check;// boolean DEFAULT FALSE,
    @Getter
    @Setter
    private List<String> course_sub;

}
