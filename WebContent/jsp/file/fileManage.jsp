<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../../lib/jquery-easyui-1.5.4.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../lib/jquery-easyui-1.5.4.4/themes/icon.css">
<script type="text/javascript" src="../../lib/jquery-easyui-1.5.4.4/jquery.min.js"></script>
<script type="text/javascript" src="../../lib/jquery-easyui-1.5.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../lib/jquery-easyui-1.5.4.4/locale/easyui-lang-zh_CN.js"></script>

<link rel="stylesheet" type="text/css" href="../../css/file/fileManage.css">
<script type="text/javascript" src="../../js/file/fileManage.js" charset="UTF-8"></script>
<script type="text/javascript" src="../../js/getRootPath.js" charset="UTF-8"></script>
<title>欢迎:${user.userName}-${cookie.JSESSIONID.value}</title>
</head>
<body>
	<div id="div_body">
		<div id="tool" class="tool">
			<button id="search">库查询</button>
			<button id="edit">修改</button>
			<button id="save">保存 </button>
		</div>
		<input type="text" id="url" calss="url" value="输入需要保存文件的全路径"/><span id="massage"></span>
		<br>
		
		<div>
			<button id="searchPackage">文件夹查询</button>
			<button id="editPackage">全路径更新</button>
		</div>

		<div id="sysTable">
			<table id="listFolder" class="table"></table>
		</div>
		<div id="dbTable">
			<table id="listTable" class="table"></table>
		</div>
		
	</div>
</body>
</html>