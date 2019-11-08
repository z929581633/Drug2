<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>采购记录</title>
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
	<div id="table3Div">
					<table class="layui-hide" style="display:none;" id="test3"
			lay-data="{id: 'idTest'}" lay-filter="test3"></table>
	</div>
			<div style="display: none" id="divTable">
			<table class="layui-hide" id="detailsTable" lay-filter="test"></table>
		</div>
	<script type="text/html" id="toolbarDemo">
  					<div class="layui-btn-container" style="margin-top:10px;padding-left:20px;">
    					<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="addWarehouse"><i class="layui-icon layui-icon-add-1"></i>新增</button>
						<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="addWarehouse3"><i class="layui-icon layui-icon-add-1"></i>采购</button>  				
	
  					</div>
	
				</script>
	<script type="text/html" id="toolbarDemo2">
  					<div class="layui-btn-container" style="margin-top:10px;padding-left:20px;">
    					<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="addWarehouse2"><i class="layui-icon layui-icon-add-1"></i>新增</button>
  					</div>
	
				</script>

					<script type="text/html" id="toolbarDemo3">
  					<div class="layui-btn-container" style="margin-top:10px;padding-left:20px;">
    					<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="addWarehouse4"><i class="layui-icon layui-icon-add-1"></i>确认采购</button>
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
						url : '../../selectAllPurchaseOrders.do',
						toolbar : '#toolbarDemo',
						title : '用户数据表',
						cols : [ [ {
							type : 'checkbox',
							fixed : 'left'
						}, {
							field : 'poId',
							title : '采购订单号',
							unresize : true
						}, {
							field : 'poName',
							title : '采购人',
							unresize : true
						}, {
							field : 'poTime',
							title : '采购时间',
							unresize : true
						}, {
							field : 'poPaymentStatus',
							title : '付款状态',
							unresize : true
						}, {
							field : 'poAuditState',
							title : '审核状态',
							unresize : true
						},{
							field : 'poSupplier',
							title : '供应商',
							unresize : true
						}, {
							field : 'perpare1',
							title : '采购状态',
							unresize : true
						}, {
							field : 'perpare2',
							title : '入库状态',
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
										          url: "../../addpurchaseOrdersDetails.do",
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
 					table.on('toolbar(test3)', function(obj) {
 						var checkStatus = table.checkStatus(obj.config.id);
 						//获得选择的对象
 						var data = checkStatus.data;
						switch (obj.event) {
						case 'addWarehouse4':	//新增
							if(data.length > 0){
							alert(data.chineseName);
						}else{
							layer.msg('请选择要购买的药品');
						}
							break;
						}
					}); 
 					  //监听单元格编辑
 					  table.on('edit(test3)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
 						  $.ajax({
 							  url:'../updateMenu.do',
 							  data:obj.data,
 							  type:'post',
 							  dataType:'html',
 							  success:function(data){
 								if(data == '1'){
 									layer.msg('修改成功');
 								}else{
 									layer.msg('修改失败');
 								}
 							  }
 						  });
 						});
					table.on('toolbar(test)', function(obj) {
						var checkStatus = table.checkStatus(obj.config.id);
						switch (obj.event) {
						case 'addWarehouse':	//新增
							layer.open({
								title: '新增',
								type: 1, //Page层类型
								//area: ['500px', '520px'], //宽高
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
									          url: "../../addPurchaseOrders.do",
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
								content: $("#addDetails"),
								success: function(layero, index){
									  form.render();
									  }
							});
							break;
 						case  'addWarehouse3':
								layer.open({
									title : '商品',//标题
									type : 1,//样式
									shade : 0,
									offset : [ '5%', '15%' ],//设置位移
									area : [ '880px', '433px' ],
									content : $("#table3Div"),
									success : function(layero) {
										var mask = $(".layui-layer-shade");
										mask.appendTo(layero.parent());
										//其中：layero是弹层的DOM对象
										  table.render({
											    elem: '#test3'
											    ,toolbar : '#toolbarDemo3'
												,url: '../../getDrugsNumProduct.do'//数据接口
											    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
											    ,cols: [[
													{
														type : 'checkbox',
														fixed : 'left'
													},
											      {field:'chineseName', title: '药品名称', align:'center'}
												,{field:'fginumber', title: '药品数量', align:'center'}
											      
											      ,{field:'retailPrice',title: '药品价格',align:'center'}
											      ,{field:'number', title: '购买数量',edit: 'text',templet:function(d){
											    	  var left = (d.menuType-1)*40;
											    	  
											    	  var num = "";
											    	  if(d.menuType == 1){
											    		  num = "bold";
											    	  }else{
											    		  num = "normal";
											    	  }
											    	  return '<span style="margin-left:'+left+'px;font-weight:'+num+';">'+d.number+'</span>'
											      }}
											    ]]

											  });
									},
									end : function() {
										$('[lay-id="test3"]')
												.css("display", "none");
									}
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
								url : '../../selectAllPurchaseOrdersDetails.do?poId='+data.poId+'',
								toolbar : '#toolbarDemo2',
								totalRow : true,
								cols : [ [ {
									type : 'checkbox',
									fixed : 'left'
								},{
									type : 'numbers'
								}, {
									field : 'detailsId',
									title : '采购订单详情id',
									unresize : true
								},{
									field : 'detailsName',
									title : '药品名称',
									unresize : true
								}, {
									field : 'detailsNumber',
									totalRow : true,
									title : '药品数量',
									unresize : true
								},  {
									field : 'detailsPrice',
									title : '药品单价',
									totalRow : true,
									unresize : true
								}, {
									field : 'poId',
									title : '采购订单id 外键',
									unresize : true
								}, {
									field : 'detailsTotal',
									title : '总价',
									totalRow : true,
									unresize : true
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
						              url: "../../deletePurchaseOrders.do",
						              type: "POST",
						              data:{"poId":data.poId},
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
							              url: "../../deletepurchaseOrdersDetails.do",
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
					          url: "../../updatePurchaseOrders.do",
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
					          url: "../../updatepurchaseOrdersDetails.do",
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
				<label class="layui-form-label" style="font-size: 13px;">采购订单详情id</label>
				<div class="layui-input-block">
					<input name="detailsId" class="layui-input" type="text"
						autocomplete="off" lay-verify="title" readonly="readonly">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">药品名称</label>
				<div class="layui-input-block">
					<input name="detailsName" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>

			<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">药品数量</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="" name="detailsNumber"
						>
				</div>
			</div>
						<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">药品单价</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="" name="detailsPrice"
						>
				</div>
			</div>



			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">采购订单id</label>
				<div class="layui-input-block">
					<input name="poId" class="layui-input" type="text"
						placeholder="" autocomplete="off">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">总价</label>
				<div class="layui-input-block">
					<input name="detailsTotal" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>
						<div class="layui-form-item" hidden>
				<label class="layui-form-label" style="font-size: 13px;"></label>
				<div class="layui-input-block">
					<input name="perpare1" class="layui-input" type="text"
						autocomplete="off" >
				</div>
			</div>
			<div class="layui-form-item" hidden>
				<label class="layui-form-label" style="font-size: 13px;">/label>
				<div class="layui-input-block">
					<input name="perpare2" class="layui-input" type="text"
						autocomplete="off" >
				</div>
			</div>
			<div class="layui-form-item" hidden>
				<label class="layui-form-label" style="font-size: 13px;"></label>
				<div class="layui-input-block">
					<input name="perpare3" class="layui-input" type="text"
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
				<label class="layui-form-label" style="font-size: 13px;">采购订单id</label>
				<div class="layui-input-block">
					<input name="poId" class="layui-input" type="text"
						autocomplete="off" lay-verify="title" readonly="readonly">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">采购人</label>
				<div class="layui-input-block">
					<input name="poName" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>

			<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">采购时间</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="" name="poTime"
						placeholder="yyyy-MM-dd">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">支付状态</label>
				<div class="layui-input-inline">
					<select name="poPaymentStatus" lay-verify="">
						<option value="已支付">已支付</option>
						<option value="未支付" selected="selected">未支付</option>
					</select>
				</div>
			</div>
			<div>
				<label class="layui-form-label" style="font-size: 13px;">审核状态</label>
				<div class="layui-input-inline">
					<select name="poAuditState" lay-verify="">
						<option value="未审核" selected="selected">未审核</option>
						<option value="审核未通过">审核未通过</option>
						<option value="审核通过">审核通过</option>
						<option value="已审核">已审核</option>
					</select>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">供货商</label>
				<div class="layui-input-block">
					<input name="poSupplier" class="layui-input" type="text"
						placeholder="" autocomplete="off">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">采购状态</label>
				<div class="layui-input-block">
					<input name="perpare1" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">入库状态</label>
				<div class="layui-input-block">
					<input name="perpare2" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>
			<div class="layui-form-item" hidden>
				<label class="layui-form-label" style="font-size: 13px;"></label>
				<div class="layui-input-block">
					<input name="perpare3" class="layui-input" type="text"
						autocomplete="off">
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
				<label class="layui-form-label" style="font-size: 13px;">采购人</label>
				<div class="layui-input-block">
					<input name="poName" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>

			<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">采购时间</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="test1" name="poTime"
						placeholder="yyyy-MM-dd">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">支付状态</label>
				<div class="layui-input-inline">
					<select name="poPaymentStatus" lay-verify="">
						<option value="已支付">已支付</option>
						<option value="未支付" selected="selected">未支付</option>
					</select>
				</div>
			</div>
			<div>
				<label class="layui-form-label" style="font-size: 13px;">审核状态</label>
				<div class="layui-input-inline">
					<select name="poAuditState" lay-verify="">
						<option value="未审核" selected="selected">未审核</option>
					</select>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">供货商</label>
				<div class="layui-input-block">
					<input name="poSupplier" class="layui-input" type="text"
						placeholder="" autocomplete="off">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">采购状态</label>
				<div class="layui-input-inline">
					<select name="perpare1" lay-verify="">
						<option value="未发货" selected="selected">未发货</option>
					</select>
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">入库状态</label>
				<div class="layui-input-inline">
					<select name="perpare2" lay-verify="">
						<option value="未支付" selected="selected">未入库</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item" hidden>
				<label class="layui-form-label" style="font-size: 13px;"></label>
				<div class="layui-input-block">
					<input name="perpare3" class="layui-input" type="text"
						autocomplete="off">
				</div>
			</div>

		</form>
	</div>
	
		<div class="site-text" style="margin: 5%; display: none"
		id="addDetails2" target="test123">
		<form class="layui-form" lay-filter="formAuthority2" id="formIdOne2">

			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">药品名称</label>
				<div class="layui-input-block">
					<input name="detailsName" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">药品数量</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="" name="detailsNumber"
						>
				</div>
			</div>
				<div class="layui-inline">
				<label class="layui-form-label" style="font-size: 13px;">药品单价</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="" name="detailsPrice"
						>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">采购订单id</label>
				<div class="layui-input-block">
					<input name="poId" class="layui-input" type="text"
						placeholder="" autocomplete="off">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="font-size: 13px;">总价</label>
				<div class="layui-input-block">
					<input name="detailsTotal" class="layui-input" type="text"
						autocomplete="off" lay-verify="required">
				</div>
			</div>
		</form>
	</div>
</body>
</html>
