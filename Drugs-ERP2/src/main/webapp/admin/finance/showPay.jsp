<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出库信息表</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<script src="../layui/layui.js"></script>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
		<!-- <div class="layui-inline">
      		<label class="layui-form-label">编号：</label>
      		<div class="layui-input-inline">
        	<input type="text" name="moName" id="moName"   autocomplete="off" class="layui-input">
           </div>
           <button type="button" class="layui-btn layui-btn-normal layui-btn-radius  layui-icon layui-icon-search"  id="selectName">查询</button>
           
        </div> -->
	<!-- 数据表格 -->
	<div style="width: 100%;">
		<table class="layui-hide" id="userTable" lay-filter="userTable"></table>
	</div>
	<!-- 表格toolbar -->
	<div style="display: none;" id="userToolBar">
		<div >
   			<button type="button" class="layui-btn layui-btn-normal layui-btn-radius  layui-icon layui-icon-add-circle-fine"  lay-event="add">增加一条数据</button>
		</div>
	</div>
	<!-- 表格行内toolbar -->
	<div style="display: none;" id="barDemo">
		<a class="layui-btn layui-btn-xs  layui-btn-radius layui-icon layui-icon-edit"
			lay-event="edit">编辑</a> <a
			class="layui-btn layui-btn-danger   layui-btn-radius layui-btn-xs layui-icon layui-icon-delete"
			lay-event="del">删除</a>
	</div>
	<!-- 弹出层div(修改) -->
	<div id="mydiv"  style="display: none">
		<form  class="layui-form" lay-filter="dataform" id="dataform" method="post">
			<input type="hidden" name="outId">
				
			<div class="layui-inline">
					<label class="layui-form-label">审核</label>
					<div class="layui-input-inline">
						<select lay-verify="" name="status">
							<option value="">审核</option>
							<option value="已出库" >已出库</option>
							<option value="未出库" >未出库</option>
						</select>
					</div>
			</div>

			<div class="layui-inline">
					<label class="layui-form-label">审核人</label>
					<div class="layui-input-inline">
						<select name="reviewer" lay-verify="">
							<option value="">审核人</option>
							<option value="王五" selected>王五</option>
							<option value="张三" >张三</option>
							<option value="李四" >李四</option>
						</select>
					</div>
			</div>
				
			<div class="layui-inline">
					<label class="layui-form-label">出库时间</label>
					<div class="layui-input-inline">
						<input type="text"  id="date" name="outTime"
							placeholder="yyyy-MM-dd HH:mm:ss" autocomplete="off" class="layui-input">
					</div>
			</div>
			
			<div class="layui-inline">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-inline"">
						<input type="text" name="note" lay-verify="required"
							autocomplete="off" class="layui-input">
					</div>
			</div>
				
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button type="submit" class="layui-btn" lay-submit=""
						lay-filter="dosubmit">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>
	<!-- 弹出层div(新增) -->
	<div id="mydivAdd"  style="display: none">
		<form  class="layui-form" lay-filter="dataform" id="dataform" method="post">
			
			
			<div class="layui-form-item" >
				<label class="layui-form-label">货物类型：</label>
				<div class="layui-input-inline">
					<input type="text" name="typeGoods"  lay-verify="required"
						autocomplete="off" placeholder="货物类型" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item" >
				<label class="layui-form-label">货物数量：</label>
				<div class="layui-input-inline">
					<input type="number" name="goodsNumber"  lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			
			<div class="layui-inline">
					<label class="layui-form-label">下单时间：</label>
					<div class="layui-input-inline">
						<input type="text" id="date" name="goodsTime"
							placeholder="yyyy-MM-dd HH:mm:ss" autocomplete="off" class="layui-input">
					</div>
			</div>
			
			
			<div class="layui-inline">
					<label class="layui-form-label">审核</label>
					<div class="layui-input-inline">
						<select lay-verify="" name="status">
							<option value="">审核</option>
							<option value="未出库">未出库</option>
						</select>
					</div>
			</div>
			
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button type="submit" class="layui-btn" lay-submit=""
						lay-filter="dosubmit">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>
	<script>
		layui
				.use(
						['laydate'],
						function() {
							var laydate = layui.laydate;
							//日期
							laydate.render({
								elem : '#date'
								,type: 'datetime'
							});
						
						});
	</script>
	
	<script type="text/javascript">
		layui.use([ "element", "jquery", "layer", "form", "table" ],
				function() {
					var $ = layui.jquery;
					var element = layui.element;
					var layer = layui.layer;
					var form = layui.form;
					var table = layui.table;
                    var url;
                    var tanIndex;
					//数据表格渲染
					var tableIns = table.render({
						elem : '#userTable' //代表渲染的目标对象
						,
						url : '../../getAllOutBound.do'//'moSelectName.do?moName='+$("#moName").val() //数据接口
						,
						title : '出库数据表' //数据导出的标题
						,
						toolbar : "#userToolBar" //表格工具条
						//,height: 'full-100'////高度最大化减去差值
						,
						cellMinWidth : 100 //设置列的最小默认宽度
						/* ,limit:20    //设置每页显示的条数 默认是10
						,limits:[20,40,60]   */
						,
						text : {
							none : '暂无相关数据' //默认：无数据。注：该属性为 layui 2.2.5 开始新增
						}
						//defaultToolbar : [ 'filter', 'exports' ]
						// ,totalRow:true//开启合并行
						,
						page : true //是否启用分页
						,
						cols : [ [//列数据
						{
							type : 'checkbox',
							fixed : 'left'
						} //启动复选框
						, {
							type : 'numbers'
						}, {
							field : 'outId',
							title : '出库编号',
							align: 'center'
						}, {
							field : 'typeGoods',
							title : '货物类型'
						}, {
							field : 'goodsNumber',
							title : '货物数量 ',
							align: 'center'
						}, {
							field : 'goodsTime',
							title : '订单生成时间 ',
							align: 'center'
						},{
							field : 'status',
							title : '审核状态',
							align: 'center'
						}, {
							field : 'outTime',
							title : '出库时间',
							align: 'center'
						},{
							field : 'reviewer',
							title : '审核人',
							align: 'center'
						},{
							field : 'note',
							title : '备注',
							align: 'center'
						},{
							fixed : 'right',
							title : '操作',
							toolbar : '#barDemo'
						} ] ],
					});
					
					
					 //监听头部工具栏事件
				      table.on('toolbar(userTable)', function(obj){
						  var checkStatus = table.checkStatus(obj.config.id);
						  switch(obj.event){
						    case 'add':
						    	openAdd();
						    break;
						    case 'delete':
						    	var checkStatus = table.checkStatus('userTable'); //idTest 即为基础参数 id 对应的值
						    	console.log(checkStatus.data) //获取选中行的数据
						    	console.log(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件
						    	console.log(checkStatus.isAll ) //表格是否全选
						    	var id="";
						    	if(checkStatus.data.length>0){
						    		for(var i=0;i<checkStatus.data.length;i++){
						    			if(i==0){
						    				id=checkStatus.data[i].outId+id;
						    			}else{
						    				id=checkStatus.data[i].outId+","+id;
						    			}
						    			
						    		}
						    		 $.post("../../delOutBound.do","outId="+id,function(back){
										//刷新数据表格
										tableIns.reload();
									 }); 
						    	}else{
						    		layer.msg("没有选择数据",{  icon: 2,
						    			  time: 1000});
						    	}
						    break;
					  };
				    });	
					 //打开新增页面
					 function openAdd(){
						 tanIndex= layer.open({
			   				 type:1,  //设置类型 默认为0 1 页面层 2 iframe层
			   				 title:'新增一条出库信息',  //标题
			   				 content:$("#mydivAdd"),//内容  type=0 的内容
			   				 skin:'layui-layer-molv',//skin - 样式类名
			   				 area:['340px'],  //area - 宽高
			   				 //offset:'lt',//offset - 坐标 默认：垂直水平居中
			   				 btnAlign:'c',//按钮排列
			   				 closeBtn:2,  //设置关闭按钮的样式 默认是1  0是没有 
			   			     shade:[0.8, '#000'],//shade - 遮罩
			   			     shadeClose:true,//点击遮罩 是否关闭弹层
			   			     anim: 4,//设置动画
			   				 maxmin:true,//该参数值对type:1和type:2有效。默认不显示最大小化按钮。需要显示配置maxmin: true即可
			   				 success:function(index){
			   					 url= "../../addOutBound.do";
								  //清空表单数据
								  $("#dataform")[0].reset();
								  
							  }		  
			   		});
					 }
					 //打开修改页面
					  function  openUpdate(data){
						  tanIndex=layer.open({
				   				 type:1,  //设置类型 默认为0 1 页面层 2 iframe层
				   				 title:'审核出库信息',  //标题
				   				 content:$("#mydiv"),//内容  type=0 的内容
				   				 skin:'layui-layer-molv',//skin - 样式类名
				   				 area:['340px'],  //area - 宽高
				   				 //offset:'lt',//offset - 坐标 默认：垂直水平居中
				   				 btnAlign:'c',//按钮排列
				   				 closeBtn:2,  //设置关闭按钮的样式 默认是1  0是没有 2
				   			     shade:[0.8, '#000'],//shade - 遮罩
				   			     shadeClose:true,//点击遮罩 是否关闭弹层
				   			     anim: 4,//设置动画
				   				 maxmin:true,//该参数值对type:1和type:2有效。默认不显示最大小化按钮。需要显示配置maxmin: true即可
				   				 success:function(index){
									  form.val("dataform",data);
									  url="../../changeOutBound.do";
								  }
						  });	
						 
					   }	
					 //提交数据
					 form.on("submit(dosubmit)",function(obj){
						 //序列化表单数据
						 var params=$("#dataform").serialize();
					
						  $.post(url,params,function(data){
							//刷新数据表格
							tableIns.reload();
							//关闭弹出层
							layer.close(tanIndex);
							
							
						 }); 
					 })
					
				/* 	 $("#selectName").click(function(){
						 table.render({
								elem : '#userTable' //代表渲染的目标对象
								,
								url : '../../getAllOutBound.do'//'moSelectName.do?moName='+$("#moName").val() //数据接口	
								,
								title : '出库信息表' //数据导出的标题
								,
								toolbar : "#userToolBar" //表格工具条
								,
								cellMinWidth : 100 //设置列的最小默认宽度
								,
								text : {
									none : '暂无相关数据' //默认：无数据。注：该属性为 layui 2.2.5 开始新增
								}
								,
								page : true //是否启用分页
								,
								cols : [ [//列数据
								{
									type : 'checkbox',
									fixed : 'left'
								} //启动复选框
								, {
									type : 'numbers'
								},  {
									field : 'outId',
									title : '出库编号',
									align: 'center'
								}, {
									field : 'typeGoods',
									title : '货物类型'
								}, {
									field : 'goodsNumber',
									title : '货物数量 ',
									align: 'center'
								}, {
									field : 'goodsTime',
									title : '订单生成时间 ',
									align: 'center'
								},{
									field : 'status',
									title : '审核状态',
									align: 'center'
								}, {
									field : 'outTime',
									title : '出库时间',
									align: 'center'
								},{
									field : 'reviewer',
									title : '审核人',
									align: 'center'
								},{
									field : 'note',
									title : '备注',
									align: 'center'
								},{
									fixed : 'right',
									title : '操作',
									toolbar : '#barDemo'
								} ] ],
							});
						 
					 }) */
				  	//监听行工具条事件
				      table.on('tool(userTable)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
				    	  var data = obj.data; //获得当前行数据
				    	  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
				    	  var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
				    	 if(layEvent === 'del'){ //删除
				    	    layer.confirm('真的删除行么', function(index){
				    	   	 $.post("../../delOutBound.do","outId="+data.outId,function(back){
									//刷新数据表格
									tableIns.reload();
								 });
				    	      layer.close(index);
				    	    });
				    	  } else if(layEvent === 'edit'){ //编辑
				    	      openUpdate(data);
				    	  } 
				    	});

				})
	</script>
</body>
</html>