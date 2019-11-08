<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>采购退换</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<script src="../layui/layui.js"></script>
<script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->


<style>
/*table外边距*/
.layui-table, .layui-table-view {
	margin: 0px 0;
}
/*弹出层table外边距*/
.layui-table, .layui-table-view {
	margin: 0px;
	padding: 0px;
	margin-bottom: 0px;
}
</style>
</head>
<body>
	<table class="layui-hide" id="test" lay-filter="test"></table>
	<div id="table2Div">
		<table class="layui-hide" style="display: none" id="test2"
			lay-data="{id: 'idTest'}" lay-filter="test2"></table>
	</div>

	<script type="text/html" id="toolbarDemo">
  					<div class="layui-btn-container" style="margin-top:10px;padding-left:20px;">
    					<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="addWarehouse"><i class="layui-icon layui-icon-add-1"></i>新增</button>
	</div>
	
				</script>
	<script type="text/html" id="toolbarDemo2">
  					<div class="layui-btn-container" style="margin-top:10px;padding-left:20px;">
    					<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="addWarehouse2"><i class="layui-icon layui-icon-add-1"></i>新增</button>
	<
  					  					
</div>
	
				</script>
	<script type="text/html" id="barDemo2">
  <a class="layui-btn layui-btn-xs" lay-event="edit2">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del2">删除</a>
</script>

	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

	<script>
		layui.use([ 'table', 'laydate', 'element', 'form', 'layer' ],
				function() {
					var layer = layui.layer;
					var element = layui.element;
					var table = layui.table;
					var laydate = layui.laydate;
					var form = layui.form;
					laydate.render({
						elem: '#test1', //指定元素
					});
					table.render({
						elem : '#test',
						url : '../../selectAllSalesReturn.do',
						toolbar : '#toolbarDemo',
						title : '用户数据表',
						cols : [ [ {
							type : 'checkbox',
							fixed : 'left'
						}, {
							field : 'returnId',
							title : '退换ID',
							unresize : true
						}, {
							field : 'orderNumber',
							title : '订单编号',
							unresize : true
						}, {
							field : 'returnSupplier',
							title : '供应商名称',
							unresize : true
						}, {
							field : 'returnMoney',
							title : '订单金额',
							unresize : true
						}, {
							field : 'returnCause',
							title : '退货金额',
							unresize : true
						},{
							field : 'returnTime',
							title : '退货时间',
							unresize : true
						},{
							field : 'returnPerpare1',
							title : '审核状态',
							unresize : true
						}, {
							fixed : 'right',
							width : 178,
							align : 'center',
							toolbar : '#barDemo',
							unresize : true
						} ] ],
						page : true
					});


					//常规用法
					laydate.render({
						elem : '#test2'
					});

					//工具栏事件
					table.on('toolbar(test2)',function(obj){
						var checkStatus = table.checkStatus(obj.config.id);
						switch (obj.event){
							case 'addWarehouse2':	//新增
								layer.open({
									title: '新增',
									type: 1, //Page层类型
									//area: ['500px', '520px'], //宽高
									closeBtn: 0,
									btn: ['确定', '关闭'], //可以无限个按钮
									content: $("#addDetails2"),
									yes: function(index, layero) {
										var order = $('#formIdOne2').serialize();
										layer.close(index);
										//执行清空
										$("#warehouseOperator").empty();
										$("#storageWarehouse").empty();
										form.render("select");
										if(index > 0){
											  $.ajax({
										          url: "../../addReturnDetails.do",
										          type: "POST",
										          data: order,
										          success: function(back){
										              if(back == '1'){
										                  //关闭弹框
										                  layer.msg("新增成功", {icon: 6});
										                  table.reload('test2',{  });
										                  layer.close(ed);
										              }else{
										                  layer.msg("新增失败", {icon: 5});
										                  table.reload('test2',{  });
										              }
										          }
										      });
										}
									},
									success: function(layero, index){
										  form.render();
										  }
								});
								break;
						}
					});
					table.on('toolbar(test)', function(obj) {
						var checkStatus = table.checkStatus(obj.config.id);
						switch (obj.event) {
						case 'addWarehouse':	//新增
							layer.open({
								title: '新增',
								type: 1, //Page层类型
								area: ['400px', '450px'], //宽高
								closeBtn: 0,
								btn: ['确定', '关闭'], //可以无限个按钮
								yes: function(index, layero) {
									var order = $('#formIdOne').serialize();
									layer.close(index);
									//执行清空
									$("#warehouseOperator").empty();
									$("#storageWarehouse").empty();
									form.render("select");
									if(index > 0){
										  $.ajax({
									          url: "../../addSalesReturn.do",
									          type: "POST",
									          data: order,
									          success: function(back){
									              if(back == '1'){
									                  //关闭弹框
									                  layer.msg("新增成功", {icon: 6});
									                  table.reload('test',{  });
									                  layer.close(ed);
									              }else{
									                  layer.msg("新增失败", {icon: 5});
									                  table.reload('test',{  });
									              }
									          }
									      });
									}
								},
								content: $("#addDetails")
							});
							break;

						}
						;
					});
					var ed;
					//监听工具条
					table.on('tool(test)', function(obj) {
						var data = obj.data;
						if (obj.event === 'detail') {
							layer.open({
								title : '详情',//标题
								type : 1,//样式
								shade : 0,
								offset : [ '5%', '15%' ],//设置位移
								area : [ '880px', '433px' ],
								content : $("#table2Div"),
								success : function(layero) {
									var mask = $(".layui-layer-shade");
									mask.appendTo(layero.parent());
									//其中：layero是弹层的DOM对象
								},
								end : function() {
									$('[lay-id="test2"]')
											.css("display", "none");
								}
							});

							table.render({
								elem : '#test2',
								url : '../../selectAllReturnDetails.do?returnId='+data.returnId+'',
								toolbar : '#toolbarDemo2',
								totalRow : true,
								cols : [ [ {
									type : 'checkbox',
									fixed : 'left'
								}, {
									field : 'detailsId',
									title : '采购订单详情id',
									unresize : true
								},{
									field : 'detailsName',
									title : '产品名称',
									unresize : true
								}, {
									field : 'detailsQuantity',
									totalRow : true,
									title : '产品数量',
									unresize : true
								},  {
									field : 'detailsUnitPrice',
									title : '产品单价',
									totalRow : true,
									unresize : true
								}, {
									field : 'detailsTotalPrice',
									title : '产品总价',
									totalRow : true,
									unresize : true
								}, {
									field : 'returnId',
									title : '退货ID外键',
									totalRow : true,
									
								}, {
									fixed : 'right',
									width : 178,
									align : 'center',
									toolbar : '#barDemo2',
									unresize : true
								}  ] ]
							});
							
						}else if (obj.event === 'del') {
							layer.confirm('确认删除吗？', function(index) {
						    	  $.ajax({
						              url: "../../deleteSalesReturn.do",
						              type: "POST",
						              data:{"returnId":data.returnId},
						              success: function(data){
						                  if(data == "1"){
						                      //关闭弹框
						                      layer.msg("删除成功", {icon: 6});
						                      table.reload('test',{  });
						                  }else{
						                      layer.msg("删除失败", {icon: 5});
						                  }
						              }
						          });
								obj.del();
								layer.close(index);
							});
						}  else if (obj.event === 'edit') {
							ed=layer.open({
								type : 1,
								title : '修改',
								area : [ '500px', '300px' ],
								content : $('#div'),
					   		  	//成功后的回调
					   			success: function(layero, index){
					   			form.val("forms",data);
					        	} 
							});
						}
					});
					table.on('tool(test2)', function(obj) {
						var checkStatus2 = table.checkStatus("test2");
						var data2 = obj.data;
						switch (obj.event) {
							case 'del2':
								layer.confirm('确认删除吗？', function(index) {
							    	  $.ajax({
							              url: "../../deleteReturnDetails.do",
							              type: "POST",
							              data:{"detailsId":data2.detailsId},
							              success: function(data2){
							                  if(data2 == "1"){
							                      //关闭弹框
							                      layer.msg("删除成功", {icon: 6});
							                      table.reload('test2',{  });
							                  }else{
							                      layer.msg("删除失败", {icon: 5});
							                  }
							              }
							          });
									obj.del();
									layer.close(index);
								});
							break;
							case 'edit2':
								ed2=layer.open({
									type : 1,
									title : '修改',
									area : [ '500px', '300px' ],
									content : $('#div2'),
						   		  	//成功后的回调
						   			success: function(layero, index){
						   			form.val("orderd",data2);
						        	} 
								});
								break;
						}
					});
					  //form表单的提交事件
					  form.on("submit(demo1)",function(data){
						  console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
						  console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
						  console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
						  $.ajax({
					          url: "../../updateSalesReturn.do",
					          type: "POST",
					          data: data.field,
					          success: function(back){
					              if(back == '1'){
					                  //关闭弹框
					                  layer.msg("更新成功", {icon: 6});
					                  table.reload('test',{  });
					                  layer.close(ed);
					              }else{
					                  layer.msg("更新失败", {icon: 5});
					                  table.reload('test',{  });
					              }
					          }
					      });
						  return false;
					  });
					  //form表单的提交事件
					  form.on("submit(demo2)",function(data2){
						  console.log(data2.elem) //被执行事件的元素DOM对象，一般为button对象
						  console.log(data2.form) //被执行提交的form对象，一般在存在form标签时才会返回
						  console.log(data2.field) //当前容器的全部表单字段，名值对形式：{name: value}
						  $.ajax({
					          url: "../../updateReturnDetails.do",
					          type: "POST",
					          data: data2.field,
					          success: function(back){
					              if(back == '1'){
					                  //关闭弹框
					                  layer.msg("更新成功", {icon: 6});
					                  table.reload('test2',{  });
					                  layer.close(ed2);
					              }else{
					                  layer.msg("更新失败", {icon: 5});
					                  table.reload('test2',{  });
					              }
					          }
					      });
						  return false;
					  });
			});
	</script>

	<div id="div2" style="display: none;">
		<form class="layui-form" action="" id="orderd" lay-filter="orderd">
			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">退货详情ID</label>
				<div class="layui-input-block">
					<input name="detailsId" class="layui-input" type="text"
						autocomplete="off" lay-verify="title" readonly="readonly">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">产品名称</label>
				<div class="layui-input-block">
					<input name="detailsName" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>

			<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">产品数量</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="" name="detailsQuantity"
						>
				</div>
			</div>
						<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">产品单价</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="" name="detailsUnitPrice"
						>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">产品总价</label>
				<div class="layui-input-block">
					<input name="detailsTotalPrice" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>
						<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">退货ID外键</label>
				<div class="layui-input-block">
					<input name="returnId" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>
						<div class="layui-form-item" hidden>
				<label class="layui-form-label" style="font-size: 13px;"></label>
				<div class="layui-input-block">
					<input name="detailsPerpare1" class="layui-input" type="text"
						autocomplete="off" >
				</div>
			</div>
			<div class="layui-form-item" hidden>
				<label class="layui-form-label" style="font-size: 13px;"></label>
				<div class="layui-input-block">
					<input name="detailsPerpare2" class="layui-input" type="text"
						autocomplete="off" >
				</div>
			</div>
			<div class="layui-form-item" hidden>
				<label class="layui-form-label" style="font-size: 13px;"></label>
				<div class="layui-input-block">
					<input name="detailsPerpare3" class="layui-input" type="text"
						autocomplete="off" >
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-filter="demo2" lay-submit="">立即提交</button>
					<button class="layui-btn layui-btn-primary" type="reset">重置</button>
				</div>
			</div>
		</form>
	</div>

	<div id="div" style="display: none;">
		<form class="layui-form" action="" id="form1" lay-filter="forms">
			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">退换ID</label>
				<div class="layui-input-block">
					<input name="returnId" class="layui-input" type="text"
						autocomplete="off" lay-verify="title" readonly="readonly">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">订单编号</label>
				<div class="layui-input-block">
					<input name="orderNumber" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>

			<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">供应商名称</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="" name="returnSupplier"
						placeholder="yyyy-MM-dd">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">订单金额</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="" name="returnMoney"
						placeholder="yyyy-MM-dd">
				</div>
			</div>


			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">退货金额</label>
				<div class="layui-input-block">
					<input name="returnCause" class="layui-input" type="text"
						placeholder="" autocomplete="off">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">退货时间</label>
				<div class="layui-input-block">
					<input name="returnTime" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>
			<div>
				<label class="layui-form-label" style="font-size: 13px;">审核状态</label>
				<div class="layui-input-inline">
					<select name="returnPerpare1" lay-verify="">
						<option value="未审核" selected="selected">未审核</option>
						<option value="审核未通过">审核未通过</option>
						<option value="审核通过">审核通过</option>
						<option value="已审核">已审核</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-filter="demo1" lay-submit="">立即提交</button>
					<button class="layui-btn layui-btn-primary" type="reset">重置</button>
				</div>
			</div>
		</form>
	</div>
	<div class="site-text" style="margin: 5%; display: none"
		id="addDetails" target="test123">
		<form class="layui-form" lay-filter="formAuthority" id="formIdOne">

			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">订单编号</label>
				<div class="layui-input-block">
					<input name="orderNumber" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>
						<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">供应商名称</label>
				<div class="layui-input-block">
					<input name="returnSupplier" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>
						<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">订单金额</label>
				<div class="layui-input-block">
					<input name="returnMoney" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">退货金额</label>
				<div class="layui-input-block">
					<input name="returnCause" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>
						<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">退货时间</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="test1" name="returnTime"
						placeholder="yyyy-MM-dd">
				</div>
			</div>

			<div>
				<label class="layui-form-label" style="font-size: 13px;">审核状态</label>
				<div class="layui-input-inline">
					<select name="returnPerpare1" lay-verify="">
						<option value="未审核" selected="selected">未审核</option>
						<option value="审核未通过">审核未通过</option>
						<option value="审核通过">审核通过</option>
						<option value="已审核">已审核</option>
					</select>
				</div>
			</div>
		</form>
	</div>
	
		<div class="site-text" style="margin: 5%; display: none"
		id="addDetails2" target="test123">
		<form class="layui-form" lay-filter="formAuthority2" id="formIdOne2">

			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">产品名称</label>
				<div class="layui-input-block">
					<input name="detailsName" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">产品数量</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="" name="detailsQuantity"
						>
				</div>
			</div>
				<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">产品单价</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="" name="detailsUnitPrice"
						>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">产品总价</label>
				<div class="layui-input-block">
					<input name="detailsTotalPrice" class="layui-input" type="text"
						placeholder="" autocomplete="off">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">退货ID</label>
				<div class="layui-input-block">
					<input name="returnId" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>
		</form>
	</div>
</body>
</html>