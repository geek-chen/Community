package com.majiang.community.Service;
import com.majiang.community.dto.PaginationDTO;
import com.majiang.community.dto.QuestionDTO;
import com.majiang.community.mapper.QuestionMapper;
import com.majiang.community.mapper.UserMapper;
import com.majiang.community.model.Question;
import com.majiang.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 问题分页展示逻辑
     * @param page
     * @param size
     * @return
     */
    public PaginationDTO list(Integer page, Integer size){
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();


        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.list(offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
            paginationDTO.setQuestions(questionDTOList);

        }
        paginationDTO.setPagination(totalCount, page, size);
        return  paginationDTO;
    }


    public PaginationDTO list(int userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.countById(userId);

        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.listByUserId(userId,offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
            paginationDTO.setQuestions(questionDTOList);

        }
        paginationDTO.setPagination(totalCount, page, size);
        return  paginationDTO;
    }

    public QuestionDTO getById(Integer id) {
        QuestionDTO questionDTO = new QuestionDTO();
        Question question = questionMapper.getById(id);
        User user = userMapper.findById(question.getCreator());
        BeanUtils.copyProperties(question, questionDTO);
        questionDTO.setUser(user);
        return questionDTO;
    }
}
