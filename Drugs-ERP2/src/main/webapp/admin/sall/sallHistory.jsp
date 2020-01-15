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
  <link rel="stylesheet" href="../../layui/css/layui.css"  media="all">
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
<!-- 主页面表格 -->
<table class="layui-hide" id="test" lay-filter="test"></table>

<!-- 详情信息表单 -->
<div class="site-text" style="margin: 5%; display: none" id="sailListMessage" target="sailListMessage">
		<form class="layui-form layui-form-pane" lay-filter="sailListMessage" id="sailListMessage">
			<div class="listTable">
			<table class="layui-table" id="sailMessage" lay-filter="sailMessage"></table>
			</div>
		</form>
</div>

<!--  -->
<script id="barDemo" type="text/html">
  <a class="layui-btn layui-btn-xs" lay-event="message">详情</a>
</script>
              
          
<script src="../../layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
 
<script>
layui.use(['table','layer','jquery'], function (){
	var table = layui.table;
	var layer=layui.layer;
	var $ = layui.jquery;
  //方法级渲染
  table.render({
    elem: '#test',
    url:'../../getAllSailChange.do',
    cols: [[
    	{field:'salId', title: '订单号', width: '9%'},
    	{field:'empId', title: '店员号', width: '9%'},
    	{field:'salType', title: '支付类型', width: '12%'},
    	{field:'salTime', title: '交易时间', width: '15%'},
    	{field:'salAllPrice', title: '总金额', width: '9%'},
    	{field:'salPayprice', title: '支付金额', width: '9%'},
    	{field:'salGetMoney', title: '收款', width: '9%'},
		{field:'salChangePrice', title: '找零', width: '9%'},
    	{field:'salVIPNo', title: '会员号', width: '10%'},
    	{fixed: 'right', title:'操作', toolbar: '#barDemo', width:'9%'}
    ]],
    page: true,
  });
  //监听工具条
  table.on('tool(test)',function(obj){
	  var data=obj.data;
	  if(obj.event==='message'){
		  var index=layer.open({
			  type:1,
			  title:'订单号'+data.salId,
			  shade:0,
			  offset:['0px','50px'],
			  area:['700px','500px'],
			  btn:['关闭'],
			  yes:function(index){
				  layer.close(index);
			  },content:$("#sailListMessage"),
		  });
	  }
	  table.render({
		  elem:'#sailMessage',
		  url:'../../findSailMessage.do',
		  where:{
			  sailId:data.salId
		  },
		  cols:[[
			  {field:'slmId', title: '详情单号', width: '9%'},
			  {field:'salId', title: '订单号', width: '14%'},
			  {field:'slmDrugId', title: '商品码', width: '20%'},
			  {field:'slmDrugName', title: '商品名', width: '25%'},
			  {field:'slmDrugPrice', title: '商品单价', width: '9%'},
			  {field:'slmDrugNumber', title: '购买数量', width: '15%'},
			  {field:'slmDrugTotlePrice', title: '小计', width: '9%'}
		  ]],
		  page:false,
	  });
  });
});
</script>

<!-- 销售详情单sc块 -->


</body>
</html>