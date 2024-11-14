
package com.example.chapter04jpa.common;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberPaging {
    
/*    private int currentPage;//현재페이지
    private int pageBlock; //[이전][1][2][3][다음]
    private int pageSize; //1페이지당 5개씩
    private int totalA; //총글수
    private StringBuffer pagingHTML;

    public void makePagingHTML() {
        pagingHTML = new StringBuffer();

        int totalP = (totalA + pageSize - 1) / pageSize; // 총 페이지 수
        int startPage = (currentPage) / pageBlock * pageBlock + 1;
        int endPage = startPage + pageBlock - 1;
        if (endPage > totalP) endPage = totalP;

        // "이전" 버튼 - 시작 페이지가 1 이상일 때만 이전 버튼 표시
        if (startPage > 1) {
            pagingHTML.append("<span id='paging' onclick='memberPaging(" + (startPage - 2) + ")'>이전</span>");
        }

        // 페이지 번호
        for (int i = startPage; i <= endPage; i++) {
            if (i - 1 == currentPage) // currentPage와 비교할 때 1을 빼서 맞춤
                pagingHTML.append("<span id='currentPaging' onclick='memberPaging(" + (i - 1) + ")'>" + i + "</span>");
            else
                pagingHTML.append("<span id='paging' onclick='memberPaging(" + (i - 1) + ")'>" + i + "</span>");
        }

        // "다음" 버튼 - 마지막 페이지보다 더 많은 페이지가 있을 때만 다음 버튼 표시
        if (endPage < totalP) {
            pagingHTML.append("<span id='paging' onclick='memberPaging(" + endPage + ")'>다음</span>");
        }

    }*/
}

