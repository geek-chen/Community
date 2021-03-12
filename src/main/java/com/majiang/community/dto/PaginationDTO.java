package com.majiang.community.dto;

import java.util.ArrayList;
import java.util.List;

public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean hasPrevious;
    private boolean showFirstPage;
    private boolean hasNext;
    private boolean showEndPage;
    private Integer currentPage;
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public boolean isShowFirstPage() {
        return showFirstPage;
    }

    public void setShowFirstPage(boolean showFirstPage) {
        this.showFirstPage = showFirstPage;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isShowEndPage() {
        return showEndPage;
    }

    public void setShowEndPage(boolean showEndPage) {
        this.showEndPage = showEndPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        //根据总记录数算出总页数
        if(totalCount % size ==0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        if(page < 1){
            page =1;
        }
        if(page > totalPage){
            page = totalPage;
        }
        this.currentPage = page;
        //计算要展示的页码
        pages.add(page);
        for(int i = 1; i <= 3; i++){
            if(page - i > 0){
                pages.add(0, page - i);
            }
            if(page + i <= totalPage){
                pages.add(i+page);
            }
        }

        //决策是否显示上一页
        if(page == 1){
            hasPrevious = false;
        }else {
            hasPrevious = true;
        }

        //决策是否显示最后一页
        if(page == totalPage){
            hasNext = false;
        }else {
            hasNext = true;
        }

        //决策是否展示第一页
        if(pages.contains(1)){
            showFirstPage = false;
        }else {
            showFirstPage = true;
        }

        //决策是否展示最后一页
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else {
            showEndPage = true;
        }
    }
}