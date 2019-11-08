<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
	<title>同人堂医药分店销售数量报表</title>
	<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js" charset="utf-8"></script> 
   	<script src="http://code.highcharts.com/highcharts.js"></script> 
   	<script src="http://code.highcharts.com/modules/data.js"></script>  
</head>
<body>
	<div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
	
	<table id="datatable" lay-filter="datatable"></table>
	<script type="text/javascript">
	$().ready(function(){
		$.ajax({
			url: "getMaketing.do"
			, dataType: "json"
			, error: function(xhr, err){ alert(err); }
			, success: datadone
		});
		function datadone(backdata) { 
			//alert(debugObj(backdata.data));
 	   		var series = new Array();
 	   		for (var i in backdata.data) {
 	   			var one = {};
 	   			one.name = backdata.data[i].slmDrugName;
 	   			one.data = [];
 	   			one.data.push(backdata.data[i].slmDrugNumber);
 	   			series.push(one);
 	   		}
 	   		var chart = {
 	      		type: 'column'
 	   		};
 	   		var title = {
 	      		text: '同人堂医药分店销售报表'   
 	   		};      
 	   		var yAxis = {
 		      	allowDecimals: false,
 		      	title: {
 		        	text: '销量（份）'
 		      	}
 		   	};  
 	   	var xAxis = {
 		   		categories: [""]
 	   			, crosshair: true
 			};   
	      
 	   		var json = {};   
 	   		json.chart = chart; 
 	   		json.title = title; 
 	   		json.series = series ;
 	   		json.xAxis = xAxis;
 	   		json.yAxis = yAxis; 
	   		$('#container').highcharts(json);
		}
	});
	</script>
	
</body>
</html>