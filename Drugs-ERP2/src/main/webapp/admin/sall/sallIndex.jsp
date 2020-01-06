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
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<table class="layui-hida" id="test" lay-filter="test"></table>


<script id="toolbarDemo" type="text/html">
	<div class="layui-inline">
		<button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon layui-icon-add-1"></i>新增</button>
	<div>
</script>
 
<script id="barDemo" type="text/html">
  <a class="layui-btn layui-btn-xs" lay-event="edit">详情</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script id="thisBarDemo" type="text/html">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
</script>             
          
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 --> 
 
<script>
layui.use(['table','layer','jquery'], function(){
  var table = layui.table;
  var layer=layui.layer;
  var $ = layui.jquery;
  table.render({
    elem: '#test',
    url:'getAllSailList.do',
    data:'',
    toolbar: '#toolbarDemo',
    
    cols: [[
      {field:'drugId', title:'商品码ID', width:'11%'},
      {field:'drugName', title:'药品名', width:'15%'},
      {field:'drugType', title:'药品类型', width:'15%'},
      {field:'drugDesc', title:'描述', width:'25%'},
      {field:'drugOutRoomPrice', title:'售价', width:'10%'},
      {field:'drugInRoomNumber', title:'库存', width:'8%'},
      {fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
    ]],
    page: true
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'add':
    	$("#allPrice").attr("value",0);//重置总价
		$("#payMoney").val("0");//重置支付金额
    	$("#newBuyList")[0].reset();
  	    var index=layer.open({
  	    	type: 1, 
  	    	title:'详细信息',
  	    	shade: 0,
  	    	offset: ['0px', '50px'],//出现位移
  	    	area: ['800px', '500px'],//窗口大小
  	    	btn: ['确定','取消'],
  	    	yes:function(index, layero){
  	    		var empId=$("#empId").val();
  	    		var vipNo=$("#VIPNo").val();
  	    		var allPrice=$("#allPrice").val();
  	    		var payMoney=$("#payMoney").val();
  	    		$.ajax({
  	    			url:'newBuyList.do',
  	    			//data: {'empId':empId, "vipNo":vipNo, "allPrice":allPrice, "payMoney" : payMoney},
  	    			data: 'empId='+empId+"&vipNo="+vipNo+"&allPrice="+allPrice+"&payMoney="+payMoney,
  	    			type:'post',
  	    			success:function(getBack){
  	    				if(getBack==0){
  	    					layer.msg("请重新确认收入金额");
  	    				}else if(getBack==1){
  	    					layer.msg("库存不足！！");
  	    				}else{
  	    					layer.alert("找零"+getBack+"元。");//提示找零
  	    					table.reload('test');//重载销售页面
  	    					table.reload('buyList');
  	    					layer.close(index);//关闭购物清单页面
  	    					//location.reload();//刷新整个jsp页面
  	    				}
  	    				
  	    			}
  	    		});
  	    	},btn2:function(index, layero){
  	    		$.ajax({
  	    			url:'resetBuyList.do',
  	    			data:'',
  	    			type:'post',
  	    			success:function(getBack){
  	    				table.reload('buyList');
  	    				layer.close(index);
  	    			}
  	    		});
  	    	},content:$("#branch"),
  	    });
    	  break;
      case 'select':
    	  var findSail=$('#findSail').val();
    	  $.ajax({
    		  url:'getAllSailList.do',
    		  data:"finSail="+FindPage,
    		  success:function(){
    			  
    		  }
    	  });
    	  break;
    };
  });
});

</script>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form,
  layer = layui.layer,
  layedit = layui.layedit,
  laydate = layui.laydate;
  
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
<!-- 商品清单Sc -->
<script>
layui.use(['table','layer','jquery'], function(){
  var table = layui.table;
  var layer=layui.layer;
  var $ = layui.jquery;
  $(function(){
		$("#searchNo").click(function(){
			var data=$("#searchShopNo").val();
			$.ajax({
				url:'findShopNo.do',
				data:"search="+data,
				success:function(getBack){
					if(getBack==0){
						$("#searchShopNo").val("");
						table.reload('buyList');
					}else if(getBack==1){
						layer.msg('查无此货');
					}
				}
			});
		});
	});
  	table.render({
	    elem:'#buyList',
	    url:'getBuyList.do',
	    data:'buyListFlag='+1,
	    width:710,
	    done: function(data){
	    	$("#allPrice").attr("value",data.msg);
	    },
	    cols: [[
	      {field:'buyDrugId', title:'商品码ID',templet:'#usernameTpl', width:90},
	      {field:'buyDrugName', title:'药品名', width:170},
	      {field:'buyDrugType', title:'药品类型', width:120},
	      {field:'buyDrugPrice', title:'单价', width:80},
	      {field:'buyDrugNumber', title:'数量', width:80},
	      {field:'buyDrugTotlePrice', title:'小计', width:80},
	      {fixed: 'right', title:'操作', toolbar: '#thisBarDemo', width:80}
	    ]]
	  }); 

  //监听行工具事件
  table.on('tool(buyList)', function(obj){
    var data = obj.data;
    if(obj.event === 'delete'){
		$.ajax({
			url:'delBuyList.do',
			data:'buyDrugId='+data.buyDrugId,
			success:function(getBack){
				if(getBack==0){
					table.reload('buyList');
				}else if(gatBack==null){
					layer.msg("删除失败，请重试");
				}
			}
		});
    }
  });
});

</script>

<!-- html块 -->
	<div class="site-text" style="margin: 5%; display: none" id="branch" target="test123">
	<h2 align="center"><b>订单清单</b></h2>
		<form class="layui-form layui-form-pane" lay-filter="newBuyList" id="newBuyList">
			<div class="layui-form-item">
    		<label class="layui-form-label">员工号</label>
    			<div class="layui-input-inline">
      				<input type="text" name="empId" id="empId" value="1004" readonly="readonly" style="width:200px" class="layui-input">
    			</div>
    		<label class="layui-form-label">会员号</label>
    			<div class="layui-input-inline">
      				<input type="text" name="VIPNo" id="VIPNo" lay-verify="required" style="width:200px" placeholder="如果没有会员号，则此处不填" class="layui-input">
    			</div>	
  			</div>
  			<div class="layui-form-item">
    		<label class="layui-form-label">总价</label>
    			<div class="layui-input-inline">
      				<input type="text" name="allPrice" id="allPrice" value="0" lay-verify="required" readonly="readonly" style="width:200px" class="layui-input">
    			</div>
    		<label class="layui-form-label">收款</label>
    			<div class="layui-input-inline">
      				<input type="text" name="payMoney" id="payMoney" value="0" lay-verify="required" style="width:200px" class="layui-input">
    			</div>
  			</div>
      		<div class="demoTable">
  				<div class="layui-inline">
    				<input class="layui-input" name="searchInput" id="searchShopNo" placeholder="请输入商品码" style="width:580px;"  autocomplete="off">
  				</div>
  				<button type="button" id="searchNo" class="layui-btn layui-btn-normal" style="width:105px;">Search</button>
			</div>
			<div class="listTable">
			<table class="layui-table" id="buyList" lay-filter="buyList"></table>
			</div>
		</form>
	</div>

</body>
</html>