package com.majiang.community.mapper;

import com.majiang.community.model.Question;

public interface QuestionExtMapper {
    void incViewCount(Question question);

    void incCommentCount(Question record);
}
