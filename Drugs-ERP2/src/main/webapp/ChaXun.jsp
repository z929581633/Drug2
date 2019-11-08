<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>历史记录</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
           
<div class="demoTable">
  搜索详情ID：
  <div class="layui-inline">
    <input class="layui-input" name="slmId" id="demoReload" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload">搜索</button>
</div>
 
<table class="layui-hide" id="LAY_table_user" lay-filter="user"></table> 

<table class="layui-hide" id="test"></table>
              
          
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
 
<script>
layui.use('table', function (){
  var table = layui.table;
  
  //方法级渲染
  table.render({
    elem: '#test'
    ,url:'getAllMaketing.do'
    ,cellMinWidth: '80' //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    ,cols: [[
      {field:'slmId', title: '药品详情单id',width: '15%', minWidth: 100}
      ,{field:'salId',  title: '药品订单id',width: '15%', minWidth: 100}
      ,{field:'slmDrugId', title: '药品id',  width: '15%', minWidth: 100}
      ,{field:'slmDrugName',  title: '药品名称 ',width: '15%', minWidth: 100}
      ,{field:'slmDrugPrice', title: '药品价格', width: '15%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
      ,{field:'slmDrugNumber', title: '购买数量', width: '15%', minWidth: 100}
      ,{field:'slmDrugTotlePrice', title: '购买小计', width: '15%', minWidth: 100}
    ]]
  ,id: 'testReload'
	    ,page: true
	    ,height: 210
  });
  
  		var $ = layui.$, active = {
		    reload: function(){
		 var demoReload = $('#demoReload');
		      
		      //执行重载
		      table.reload('testReload', {
		        page: {
		          curr: 1 //重新从第 1 页开始
		        }
		        ,where: {
		            id: demoReload.val()
		        }
		      }, 'data');
		    }
		  };
		  
		  $('.demoTable .layui-btn').on('click', function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		  });
		});
</script>

</body>
</html>