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
     <form method="post" action="../goods/find.do">
      <select name="type" class="input-sm">
        <option value="1" ${type=='1'?"selected":"" }>전체상품</option>
        <option value="2" ${type=='2'?"selected":"" }>베스트상품</option>
        <option value="3" ${type=='3'?"selected":"" }>스페셜상품</option>
        <option value="4" ${type=='4'?"selected":"" }>신규상품</option>
      </select>
      <input type="text" name="ss" size="20" class="input-sm" value="${ss }">
      <input type="submit" value="검색" class="btn-sm btn-danger">
     </form>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <c:forEach var="vo" items="${list }">
       <a href="../goods/detail_before.do?no=${vo.no }&type=${type}">
        <div class="col-sm-3">
        <div class="panel panel-danger">
          <div class="panel-heading">${vo.goods_price}</div>
          <div class="panel-body text-center">
            <img src="${vo.goods_poster }" style="width: 180px;height: 200px">
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
		    <li><a href="../goods/find.do?page=${startPage-1 }&type=${type}&ss=${ss}">&lt;</a></li>
		  </c:if>
		  <c:forEach var="i" begin="${startPage }" end="${endPage }">
		    <li ${curpage==i?"class=active":"" }><a href="../goods/find.do?page=${i }&type=${type}&ss=${ss}">${i }</a></li>
		  </c:forEach>
		  <c:if test="${endPage<totalpage }">
		    <li><a href="../goods/find.do?page=${endPage+1 }&type=${type}&ss=${ss}">&gt;</a></li>
		  </c:if>
		</ul>
      </div>
    </div>
  </div>
</body>
</body>
</html>