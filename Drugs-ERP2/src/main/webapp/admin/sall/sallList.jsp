<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>采购计划列表</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>          
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<table class="layui-hida" id="test" lay-filter="test"></table>


<iframe id="addPurchasePlan" src="admin/purchase/addPurchasePlan.jsp" style="display: none;" frameborder="0" width="1000px;" height="500px" ></iframe>




<script id="toolbarDemo" type="text/html">
	<div class="layui-inline">
		<input type="text" name="findSail" placeholder="在此输入客户VIP号" style="height:32px;"/>
		<button class="layui-btn layui-btn-sm" lay-event="select"><i class="layui-icon layui-icon-search"></i>查询</button>
		<button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon layui-icon-add-1"></i>新增</button>
	<div>
		
</script>
 
<script id="barDemo" type="text/html">
  <a class="layui-btn layui-btn-xs" lay-event="edit">详情</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
              
          
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 --> 
 
<script>
layui.use(['table','layer'], function(){
  var table = layui.table;
  var layer=layui.layer;
  table.render({
    elem: '#test'
    ,url:'admin/json/demo1.json'
    ,toolbar: '#toolbarDemo'
    /* ,title: '用户数据表'
    	,parseData:function(res){
        	console.log(res);
        	return{
        		code: 0, //解析接口状态
        		msg:"", //解析提示文本
        		count: 1000, //解析数据长度
        		data: res //解析数据列表
        	}
        } */
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
      ,{field:'username', title:'用户名', width:120, edit: 'text'}
      ,{field:'email', title:'邮箱', width:150, edit: 'text', templet: function(res){
        return '<em>'+ res.email +'</em>'
      }}
      ,{field:'sex', title:'性别', width:80, edit: 'text', sort: true}
      ,{field:'city', title:'城市', width:100}
      ,{field:'sign', title:'签名'}
      ,{field:'experience', title:'积分', width:80, sort: true}
      ,{field:'ip', title:'IP', width:120}
      ,{field:'logins', title:'登入次数', width:100, sort: true}
      ,{field:'joinTime', title:'加入时间', width:120}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
    ]]
    ,page: true
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'add':
    	  var layer = layui.layer;
  	    layer.open({
  	    	type: 1, 
  	    	title:'详细信息',
  	    	offset: ['0px', '50px'],
  	    	area: ['auto', 'auto'],
  	    	content: $('#addPurchasePlan') //这里content是一个普通的String
  	    });
    	  break;
      case 'select':
    	  layer.alert(data.findSail);
    	  /* $.ajax({
    		  url:'../../',
    		  data:'finSail=',
    		  success:function(getBack){
    			  
    		  }
    	  }); */
    	  
    	  break;
    };
  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
    	
    	var layer = layui.layer;
	    layer.open({
	    	type: 1, 
	    	title:'详细信息',
	    	area: ['auto', 'auto'],
	    	offset: ['0px', '50px'],
	    	content: $('#addPurchasePlan') //这里content是一个普通的String
	    });
    }
  });
});
</script>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //日期
  laydate.render({
    elem: '#date'
  });

  
  
 
  
  
});
</script>
<script type="text/javascript">
	function checkForm(frm){
		/* alert(frm.a.value); */
		return false;
	}
</script>

</body>
</html>