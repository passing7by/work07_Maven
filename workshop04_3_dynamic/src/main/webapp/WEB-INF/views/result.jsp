<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>

    <style>
      form {
        display: flex;
        flex-direction: column;
        gap: 20px;
        border: 1px solid black;
        padding: 20px;
        width: 320px;
      }
      h2 {
        margin: 0;
      }
    </style>
    
  </head>

  <body>
    <form action="addProduct.do">
      <div>상품명 : <input type="text" name="name" /></div>
      <div>제조사 : <input type="text" name="maker" /></div>
      <div>가격 : <input type="text" name="price" /></div>
      <div><button type="submit" name="addProdBtn">상품등록</button></div>
    </form>

    <div></div>

    <form action="findProduct.do">
      <h2>상품명(제조사별) 검색하기</h2>
      <div>
        <select name="select">
          <option value="name">상품명으로 검색</option>
          <option value="maker">제조사별로 검색</option>
        </select>
        <input type="search" name="search" />
      </div>
      <div><button type="submit" name="searchBtn">상품검색</button></div>
    </form>
   
    <div></div>
    
    <table>
    	<thead>
	    	<tr>
	    		<th>상품번호</th>
	    		<th>상품명</th>
	    		<th>제조사</th>
	    		<th>가격</th>
	    	</tr>
    	</thead>
    	
    	<tbody>
    		<c:forEach var="myProduct" items="${list}" >
	    		<tr>
	    			<td>${myProduct.id}</td>
	    			<td>${myProduct.name}</td>
	    			<td>${myProduct.maker}</td>
	    			<td>${myProduct.price}</td>
	    		</tr>
    		</c:forEach>
    	</tbody>
    </table>
  </body>
</html>
