var controller = "/menue";
var searchUrl = controller + "/searchMenue";
var insertUrl = controller + "/searchMenue";

$(document).ready(function(){
	var menueName = $("#menueName").val();
	
	$("#table").datagrid({
		url:basicUrl+searchUrl+"?menueName="+menueName,
		columns:[[
			{field:'id',title:'id',width:100,hidden:true},
			{field:'menueName',title:'名称',width:100},
			{field:'menueUrl',title:'路径',width:350},
			{field:'image',title:'图片',width:100},
			{field:'remark',title:'简介',width:100},
			{field:'notes',title:'备注',width:100},
			{field:'createTime',title:'创建时间',width:150}
		]],
		onClickCell: function(index,field,value){
			
			if(field==="menueUrl"){
				window.open(basicUrl+value +"?dateTime = " + (new Date()).getTime());
			}
		}
		
		
		
	})
});