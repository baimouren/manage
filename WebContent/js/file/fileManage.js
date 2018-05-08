var con = "/file";
var searchName = con + "/searchFileName";
var searchUrl = con + "/searchFilePackage";
var insertUrl = con + "/editInsertsFilePackageName";

var pageSize = 10;

$(document).ready( function(){
	
	/* 查询文件夹 */
  $("#searchPackage").click(function(){
	  if($.trim($("#url").val()).length>0){

		  $("#sysTable").show();
		  $("#dbTable").hide(1000);
		  
		  $("#listFolder").datagrid({
			    url:basicUrl + searchUrl +"?url=" + $("#url").val(), 
			  	striped:true,
			  	pagination: true,
			  	rownumbers: true,
			  	pageSize: pageSize,
			  	pageList: [pageSize,pageSize*2,pageSize*3,pageSize*4],
			    columns:[[
//			        {field:'id',title:'id',width:100,align:'left',hidden:true},
			        {field:'name',title:'名称',width:350,align:'left'},
			        {field:'fileType',title:'类型',width:30,align:'left'},
//			        {field:'clicks',title:'点击量',width:30,align:'left'},
			        {field:'url',title:'路径',width:800,align:'left'},
//			        {field:'author',title:'作者',width:70,align:'left'},
//			        {field:'publicationDate',title:'出版日期',width:100,align:'right'},
//			        {field:'publication',title:'出版社',width:100,align:'left'},
//			        {field:'price',title:'价格',width:70,align:'left'},
//			        {field:'image',title:'图片',width:200,height:100,align:'left'},
//			        {field:'remark',title:'简介',width:200,align:'left'},
//			        {field:'notes',title:'备注',width:100,align:'left'},
//			        {field:'createTime',title:'创建时间',width:100,align:'right'}
			    ]]    
			}); 
	  }else{
		  $("#massage").text("不能为空！");
		  $("#massage").css({"color":"red"});
	  }

  })
	  
  /**
   * 获取焦点 删除内容
   */
  $("#url").focus(
	function(){
		if($("#url").val() === "输入需要保存文件的全路径"){
			$("#url").val("");
		}
		$("#massage").text("");
	}	  
  )
  
  
  /**
   *  查询数据库
   */
  $("#search").click(function(){
	  if($.trim($("#url").val()).length>0){

		  $("#sysTable").hide(1000);
		  $("#dbTable").show();
		
		  $("#listTable").datagrid({
			    url:basicUrl + searchName +"?url=" + $("#url").val()+"&pageSize="+pageSize+"&dateTime="+(new Date()).getTime(), 
			    columns:[[
			        {field:'id',title:'id',width:100,align:'left',hidden:true},
			        {field:'name',title:'名称',width:350,align:'left'},
			        {field:'fileType',title:'类型',width:30,align:'left'},
			        {field:'clicks',title:'点击量',width:40,align:'left'},
			        {field:'url',title:'路径',width:800,align:'left'},
//			        {field:'author',title:'作者',width:70,align:'left'},
//			        {field:'publicationDate',title:'出版日期',width:100,align:'right'},
//			        {field:'publication',title:'出版社',width:100,align:'left'},
//			        {field:'price',title:'价格',width:70,align:'left'},
//			        {field:'image',title:'图片',width:200,height:100,align:'left'},
//			        {field:'remark',title:'简介',width:200,align:'left'},
			        {field:'notes',title:'备注',width:100,align:'left'},
			        {field:'createTime',title:'创建时间',width:100,align:'right'}
			    ]],
			striped:true,
		  	pagination: true,
		  	rownumbers: true,
		  	pageNumber: 1,
		  	total: 100,
		  	pageSize: pageSize,
		  	pageList: [pageSize,pageSize*2,pageSize*3,pageSize*4]
			}); 

	  }else{
		  $("#massage").text("不能为空！");
		  $("#massage").css({"color":"red"});
	  }
  })
	  
  /* 新增到数据库 */
  $("#editPackage").click(function(){
	     $.ajax({
	         type: "POST",
	         url: basicUrl + insertUrl,
	         data: { url:$.trim($("#url").val()) },
	         dataType: "json",
	         success: function(data){
	        	 alert("保存成功！");
	         }
	     });
	})

});