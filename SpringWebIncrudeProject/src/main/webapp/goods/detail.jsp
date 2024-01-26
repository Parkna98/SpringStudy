<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let bclick=true;
$(function(){
	$('.updates').click(function(){
		$('.ups').hide();
		let no=$(this).attr("data-no")
		if(bclick==true)
		{
		   bclick=false;
		   $(this).text("취소")
		   $('#u'+no).show()
		}
		else
		{
		   bclick=true;
		   $(this).text("수정")
		   $('#u'+no).hide()
		}
	})
})
</script>
</head>
<body>
<div class="container">
    <div class="row">
      <table class="table">
      
        <tr>
          <td width="30%" class="text-center" rowspan="7">
            <img src="${vo.goods_poster }" style="width: 290px;height: 400px">
          </td>
        </tr>
        <tr>
          <th width="20%" class="text-right">상품명</th>
          <td width="50%">${vo.goods_name }</td>
        </tr>
        <tr>
          <th width="20%" class="text-right">소개</th>
          <td width="50%">${vo.goods_sub }</td>
        </tr>
        <tr>
          <th width="20%" class="text-right">가격</th>
          <td width="50%">${vo.goods_price }</td>
        </tr>
        <tr>
          <th width="20%" class="text-right">첫구매</th>
          <td width="50%">${vo.goods_first_price }</td>
        </tr>
        <tr>
          <th width="20%" class="text-right">할인율</th>
          <td width="50%">${vo.goods_discount }%</td>
        </tr>
        <tr>
          <th width="20%" class="text-right">배송</th>
          <td width="50%">${vo.goods_delivery }</td>
        </tr>
        
        
        <tr>
          <td colspan="3" class="text-right">
            <a href="javascript:history.back()" class="btn btn-xs btn-primary">목록</a>
          </td>
        </tr>
      </table>
    </div>
    
    <div style="height: 20px"></div>
    <div class="col-sm-8">
      <table class="table">
        <tr>
          <td>
            <c:forEach var="rvo" items="${rList }">
              <table class="table">
                <tr>
                  <td class="text-left">◐${rvo.name}(${rvo.dbday})</td>
                  <td class="text-right">
                    <c:if test="${rvo.id==sessionScope.id }">
                      <span class="btn btn-xs btn-info updates" data-no="${rvo.no}">수정</span>
                      <a href="../goods/reply_delete.do?no=${rvo.no }&gno=${vo.no}&type=${type}" class="btn btn-xs btn-success">삭제</a>
                    </c:if>
                  </td>
                </tr>
                <tr>
                  <td colspan="2" class="text-left" valign="top">
                    <pre style="white-space: pre-wrap;border: none;background-color: white;">${rvo.msg }</pre>
                  </td>
                </tr>
                <tr style="display:none;" id="u${rvo.no }" class="ups">
			      <td colspan="2">
			        <form method="post" action="../goods/reply_update.do">
			          <input type="hidden" name=gno value="${vo.no }">
			          <input type="hidden" name=no value="${rvo.no }">
			          <input type="hidden" name=type value="${type }">
			          <textarea rows="5" cols="70" name="msg" style="float: left">${rvo.msg}</textarea>
			          <button class="btn-primary" style="width: 100px;height: 100px;float:left;">댓글수정</button>
			        </form>
			      </td>
			    </tr>
              </table>
            </c:forEach>
          </td>
        </tr>
      </table>
      <c:if test="${sessionScope.id!=null }">
	  <table class="table">
	    <tr>
	      <td>
	        <form method="post" action="../goods/reply_insert.do">
	          <input type="hidden" name=gno value="${vo.no }">
	          <input type="hidden" name=type value="${type}">
	          <textarea rows="5" cols="70" name="msg" style="float: left"></textarea>
	          <button class="btn-primary" style="width: 100px;height: 100px;float:left;">댓글쓰기</button>
	        </form>
	      </td> 
	    </tr>
	  </table>      
	  </c:if>
    </div>
  </div>
</body>
</html>