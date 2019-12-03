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

<table class="layui-hide" id="test"></table>
<!--  -->
<script id="barDemo" type="text/html">
  <a class="layui-btn layui-btn-xs" lay-event="edit">详情</a>
</script>
              
          
<script src="../../layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
 
<script>
layui.use('table', function (){
  var table = layui.table;
  
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
		});
</script>

</body>
</html>