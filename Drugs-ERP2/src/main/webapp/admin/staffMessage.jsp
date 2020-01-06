<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>权限管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
  <script src="../layui/layui.js"></script>
  <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

 
<table class="layui-hide" id="test" lay-filter="test"></table>

	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container" style="padding-left:20px;">
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckData"><i class="layui-icon layui-icon-add-1"></i>新增员工 </button>
	<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="historyEmployee"><i class="layui-icon layui-icon-form"></i>离职员工</button>
  </div>
	
</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
layui.use(['table','laydate','form','tree', 'util','layer'], function(){
  var layer=layui.layer;	
  var table = layui.table;
  var laydate = layui.laydate;
  var form = layui.form;
  var tree = layui.tree,
  layer = layui.layer,
  util = layui.util
//模拟数据
  ,data = [{
    title: 'ALL',
    id: 2,
    spread: true,
    children: [{
      title: '系统信息管理',
      id: 5,
      spread: true,
      children: [{
        title: '员工管理',
        id: 11,
        spread: true,
        children: [{
            title: '新增',
            id: 11
          },{
        	  title:'删除',
        	  id:22
          }]
      },{
          title: '部门管理',
          id: 11,
          spread: true,
          children: [{
                  title: '新增',
                  id: 11
                },{
              	  title:'删除',
              	  id:22
                }]
            }]
    },{
        title: '采购管理',
        id: 5,
        spread: true,
        children: [{
              title: '采购申请',
              id: 11,
              spread: true,
              children: [{
                  title: '新增',
                  id: 11
                },{
              	  title:'删除',
              	  id:22
                }]
            },{
                title: '采购计划',
                id: 11,
                spread: true,
                children: [{
                        title: '新增',
                        id: 11
                      },{
                    	  title:'删除',
                    	  id:22
                      }]
                  }]
          }]
  }]
  laydate.render({
	  elem:'#outWorkTime',
	  type:'month'
  });
  
	//基本演示
  tree.render({
    elem: '#test12',
    data: data,
    showCheckbox: true ,  //是否显示复选框
    id: 'demoId1',
    isJump: true , //是否允许点击节点时弹出新窗口跳转
    click: function(obj){
      var data = obj.data;  //获取当前点击的节点数据
      layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(data));
    }
  });
  table.render({
    elem: '#test',
    url:'../getEmployee.do',
    toolbar: '#toolbarDemo',
    title: '员工管理' ,
    cols: [[
      {type: 'checkbox', fixed: 'left'},
      {field:'empId', title:'员工编号', unresize:true, width:'7%'},
      {field:'empName', title:'员工姓名',unresize:true ,width:'10%'},
      {field:'empSex', title:'员工性别', unresize:true ,width:'7%'},
      {field:'empAge', title:'员工年龄', unresize:true ,width:'7%'},
      {field:'empUser', title:'员工账号', unresize:true ,width:'7%'},
      {field:'empPassword', title:'员工密码', unresize:true ,width:'7%'},
      {field:'empWork', title:'员工职位', unresize:true ,width:'7%'},
      {field:'inWorkTime', title:'入职时间', unresize:true ,width:'15%'},
      {field:'outWorkTime', title:'离职时间', unresize:true ,width:'15%'},
      {fixed: 'right', align:'center', toolbar: '#barDemo',unresize:true}
    ]]
    ,page: true
  });
  laydate.render({
	  elem:'#date'
  });
//监听工具条1.0
  table.on('tool(test)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('请确认该员工已离职或辞退！', function(index){
        $.ajax({
        	url:'../delEmployee.do',
        	data:'empId='+data.empId,
        	success:function(getBack){
        		if(getBack==1){
        			table.reload('test');
        			table.reload('historyEmployeeList');
        			layer.alert("success");
        			layer.close(index);
        		}else{
        			layer.alert("Error");
        			layer.close(index);
        		}
        	}
        });
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
    	form.val('formAuthority',data);
    	var index = layer.open({
			title : '编辑员工',//标题
			type : 1,//样式
			shade: 0,
			offset: ['10%', '20%'],//设置位移
			btn: ['确认', '取消'],
			yes: function(index, layero){
				var employee=$("#newEmployee").serialize();
				$.ajax({
					url:'../changeEmployee.do',
					data:employee,
					success:function(getBack){
						if(getBack==1){
							table.reload('test');
							layer.close(index);
							layer.msg("修改成功");
						}else if(getBack==2){
							layer.msg("非法参数!");
						}else{
							layer.close(index);
							layer.msg("修改失败!");
						}
					}
				});
				layer.close(index);
				layer.msg('编辑成功');
			}
			,btn2: function(index, layero){
				  layer.close(index);
			},
			content :$("#branch"),
		});
    }
  });
  
  
//工具栏事件
	table.on('toolbar(test)', function(obj) {
		var checkStatus = table.checkStatus(obj.config.id);
		switch (obj.event) {
		case 'getCheckData':
            $("#newEmployee")[0].reset();
			var index = layer.open({
				title : '新增员工',//标题
				type : 1,//样式
				shade: 0,
				area:['370px','470px'],
				offset: ['5%', '20%'],//设置位移
				btn: ['确认提交','取消'],
				yes: function(index, layero){
					var newEmployee=$("#newEmployee").serialize();
					 $.ajax({
						url:'../newEmployee.do',
						data:newEmployee,
						success:function(getBack){
							if(getBack==1){
								table.reload('test');
								layer.close(index);
								layer.msg("新增成功");
							}else if(getBack==2){
								layer.msg("不允许为空");
							}else{
								layer.msg("新增失败");
							}
						}
					}); 
				}
				,btn2: function(index, layero){
					  layer.close(index);
				},
				content :$("#branch"),
			});
			break;
			
		case 'historyEmployee':
			$("#historyEmployee")[0].reset();
			var index = layer.open({
				title : '历史员工',//标题
				type : 1,//样式
				shade: 0,
				area:['800px','560px'],
				offset: ['0', '0'],//设置位移
				btn: ['关闭'],
				yes: function(index, layero){
					layer.close(index);
				},content :$("#testHisEmployee"),
			});
			break;
		};
	});
});
</script>
<script>
layui.use(['table','layer','jquery'], function(){
	  var table = layui.table;
	  var layer=layui.layer;
	  var $ = layui.jquery;
	  var index=table.render({
		    elem:'#historyEmployeeList',
		   	url:'../getHistoryEmployee.do',
		    cols: [[
		    	{field:'empId', title:'员工号',width:80},
		    	{field:'empName', title:'姓名',width:110},
		    	{field:'empSex', title:'性别',width:80},
		    	{field:'empAge', title:'年龄',width:80},
		    	{field:'inWorkTime', title:'入职时间',width:180},
		    	{field:'outWorkTime', title:'离职时间',width:180}
		    ]],
		    page: true
		  });
	  $(function(){
			$("#beginSearch").click(function(){
				var findId=$("#findEmpId").val();
				var findName=$("#findEmpName").val();
				table.reload('historyEmployeeList',{
					url:'../getHistoryEmployee.do',
					where:{
						id:findId,
						name:findName
					}
				});
				/* $.ajax({
					url:'../getHistoryEmployee.do',
					data:"id="+findId+"&name="+findName,
					success:function(getBack){
						if(getBack==0){
							$("#searchShopNo").val("");
							table.reload('buyList');
						}else if(getBack==1){
							layer.msg('查无此货');
						}
					}
				}); */
			});
		});
});
</script>
<!-- 在职员工 -->
		<div id="test12" class="demo-tree-more" style="display:none;"></div>
		<div class="site-text" style="margin: 5%; display: none" id="branch" target="test123">
		<form class="layui-form" lay-filter="formAuthority" id="newEmployee">
			<input type="hidden" name="empId" class="layui-input">
			<div class="layui-input-inline">
				<label style="margin:0 10px 0 20px;font-size:13px;">员工姓名</label>
				<div class="layui-input-inline">
      				<input type="text" name="empId" lay-verify="required" placeholder="请输入员工的编号" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline">
				<label style="margin:0 10px 0 20px;font-size:13px;">员工姓名</label>
				<div class="layui-input-inline">
      				<input type="text" name="empName" lay-verify="required" placeholder="请输入员工的真实姓名" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">员工年龄</label>
				<div class="layui-input-inline">
      				<input type="text" name="empAge" lay-verify="required" placeholder="请输入18-60" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">员工性别</label>
				<div class="layui-input-inline">
					<input type="radio" name="empSex" value="男" title="男"/>
					<input type="radio" name="empSex" value="女" title="女"/>
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">员工职位</label>
				<div class="layui-input-inline">
       	 			<select name="empWork" lay-search="">
          				<option value="店员">直接选择</option>
          				<option value="店员">店员</option>
          				<option value="副店长">副店长</option>
        			</select>
      				</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">员工账号</label>
				<div class="layui-input-inline">
      				<input type="text" name="empUser" lay-verify="required" placeholder="请输入员工账号" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">账号密码</label>
				<div class="layui-input-inline">
      				<input type="text" name="empPassword" placeholder="请输入匹配的密码" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">入职时间</label>
				<div class="layui-input-inline">
      				<input type="text" name="inWorkTime" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<input type="hidden" name="outWorkTime" class="layui-input">
			</form>
		</div>

<!-- 离职员工 -->
<div class="site-text" style="margin: 5%; display: none" id="testHisEmployee" target="testHisEmployee">
	<h2 align="center"><b>离职员工</b></h2>
		<form class="layui-form layui-form-pane" lay-filter="historyEmployee" id="historyEmployee">
      		<div class="demoTable">
  				<div class="layui-inline">
    				<input class="layui-input" name="findEmpId" id="findEmpId" placeholder="在此输入员工号" style="width:200px;"  autocomplete="off">
  				</div>
  				<div class="layui-inline">
    				<input class="layui-input" name="findEmpName" id="findEmpName" placeholder="在此输入员工姓名" style="width:200px;"  autocomplete="off">
  				</div>
  				<button type="button" id="beginSearch" class="layui-btn layui-btn-normal" style="width:90px;">Search</button>
			</div>
			<div class="historyList">
				<table class="layui-table" id="historyEmployeeList" lay-data="{id:'historyEmployeeList'}" lay-filter="historyEmployeeList"></table>
			</div>
		</form>
	</div>

</body>
</html>