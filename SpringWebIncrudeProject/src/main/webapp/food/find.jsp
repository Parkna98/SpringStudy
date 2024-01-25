<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="container">
    <div class="row">
     <form method="post" action="../food/find.do">
      <select name="col_name" class="input-sm">
        <option value="type" ${col_name=='type'?"selected":"" }>음식종류</option>
        <option value="address" ${col_name=='address'?"selected":"" }>주소</option>
        <option value="name" ${col_name=='name'?"selected":"" }>업체명</option>
      </select>
      <input type="text" name="ss" size="20" class="input-sm" value="${ss }">
      <input type="submit" value="검색" class="btn-sm btn-danger">
     </form>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <c:forEach var="vo" items="${list }">
       <a href="../food/detail_before.do?fno=${vo.fno }">
        <div class="col-sm-3">
        <div class="panel panel-danger">
          <div class="panel-heading">${vo.name}</div>
          <div class="panel-body text-center">
            <img src="https://www.menupan.com${vo.poster }" style="width: 180px;height: 200px">
          </div>
        </div>
        </div>
       </a>
      </c:forEach>
    </div>
    
    <div style="height: 20px"></div>
    <div class="row">
      <div class="text-center">
        <ul class="pagination">
          <c:if test="${startPage>1 }">
		    <li><a href="../food/find.do?page=${startPage-1 }&col_name=${col_name}&ss=${ss}">&lt;</a></li>
		  </c:if>
		  <c:forEach var="i" begin="${startPage }" end="${endPage }">
		    <li ${curpage==i?"class=active":"" }><a href="../food/find.do?page=${i }&col_name=${col_name}&ss=${ss}">${i }</a></li>
		  </c:forEach>
		  <c:if test="${endPage<totalpage }">
		    <li><a href="../food/find.do?page=${endPage+1 }&col_name=${col_name}&ss=${ss}">&gt;</a></li>
		  </c:if>
		</ul>
      </div>
    </div>
  </div>
</body>
</html>