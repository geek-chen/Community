package com.majiang.community.controller;

import com.majiang.community.mapper.QuestionMapper;
import com.majiang.community.mapper.UserMapper;
import com.majiang.community.model.Question;
import com.majiang.community.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
@Controller
public class PublishController {
    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;
    @PostMapping("/publish")
    public String doPublish(@Param("title") String title,
                            @Param("description") String description,
                            @Param("tag") String tag,
                            HttpServletRequest request,
                            Model model) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        if(title==null||title == "")
        {
          model.addAttribute("Error", "标题不能为空");
            return "publish";
        }
        if(description==null||description==""){
            model.addAttribute("Error", "问题补充不能为空");
            return "publish";
        }
        if(tag==null||tag==""){
            model.addAttribute("Error", "标签不能为空");
            return "publish";
        }
        Cookie[] cookies = request.getCookies();
        User user = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.selectByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        if (user == null) {
            System.out.println("user=null");
            model.addAttribute("Error", "用户未登录");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmt_creat(System.currentTimeMillis());
        question.setGmt_modified(question.getGmt_creat());
        questionMapper.creat(question);
            return "redirect:/";
        }





}
