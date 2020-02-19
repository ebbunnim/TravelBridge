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
public class SubCourse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1626347136486674983L;
    @Getter
    private int subcourse_no;//
    @NonNull
    @Getter
    @Setter
    private String course_no; //
    @NonNull
    @Getter
    @Setter
    private String subcourse_title;// varchar(200) NOT NULL, # 계획
    @Getter
    @Setter
    private boolean subcourse_del_check;// boolean DEFAULT FALSE,
    @Getter
    @Setter
    private List<SubCourse> course_subcourse_List;
}
