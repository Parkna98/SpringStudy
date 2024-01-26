<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.panel-heading{
   white-space: nowrap; /* 텍스트가 줄바꿈되지 않도록 함 */ 
   overflow: hidden; /* 초과된 텍스트를 감추기위해 오버플로우를 숨김 */
   text-overflow: ellipsis; /* 말줄임표 만드는 속성 */
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <c:forEach var="vo" items="${list }">
        <div class="col-md-3">
	       <div class="panel panel-primary">
	        <div class="panel-heading">${vo.title }</div>
	        <div class="panel-body"><img src="${vo.poster }" style="width: 100%; border-radius: 5px"></div>
	   	   </div>
         </div>
      </c:forEach>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <div class="text-center">
        <ul class="pagination">
          <c:if test="${startPage>1 }">
		    <li><a href="../seoul/list.do?page=${startPage-1 }">&lt;</a></li>
		  </c:if>
		  <c:forEach var="i" begin="${startPage }" end="${endPage }">
		    <li ${curpage==i?"class=active":"" }><a href="../seoul/list.do?page=${i }">${i }</a></li>
		  </c:forEach>
		  <c:if test="${endPage<totalpage }">
		    <li><a href="../seoul/list.do?page=${endPage+1 }">&gt;</a></li>
		  </c:if>
		</ul>
      </div>
    </div>
  </div>
</body>
</html>