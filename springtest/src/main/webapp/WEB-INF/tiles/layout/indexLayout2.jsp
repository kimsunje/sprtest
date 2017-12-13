<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	#content{
		width:100%;
		float: left;
	}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here(IndexLayout2)</title>

</head>
<body>

<div id="content">
		<tiles:insertAttribute name="content"/>
	</div>

</body>
</html>