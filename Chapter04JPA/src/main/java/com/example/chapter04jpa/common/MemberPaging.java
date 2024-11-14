package com.example.chapter04jpa.common;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberPaging {
    private int currentPage; // 현재페이지
    private int pageBlock; // [이전][1][2][3][다음]
    private int pageSize; // 1페이지당 3개씩
    private int totalA; //총글자수
    private StringBuffer pagingHTML;

    public void makePagingHTML() {
        pagingHTML = new StringBuffer();

        // 글이 하나도 없을 경우 처리
        if (totalA == 0) {
            pagingHTML.append("<span id='noContent'>1</span>");
            return;
        }

        int totalP = (totalA + pageSize-1) / pageSize;

        int startPage = (currentPage-1) / pageBlock * pageBlock + 1;
        int endPage = startPage + pageBlock - 1;
        if(endPage > totalP) endPage = totalP;

        if(startPage != 1)
            pagingHTML.append("<span id='paging' onclick='memberPaging(" + (startPage-1) + ")'>이전</span>");

        for(int i=startPage; i<=endPage; i++) {
            if(i-1 == currentPage)
                pagingHTML.append("<span id='currentPaging' onclick='memberPaging(" + i + ")'>" + i + "</span>");
            else
                pagingHTML.append("<span id='paging' onclick='memberPaging(" + i + ")'>" + i + "</span>");
        }//for

        if(endPage < totalP)
            pagingHTML.append("<span id='paging' onclick='memberPaging(" + (endPage+1) + ")'>다음</span>");
    }
}
