<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>영화 뷰</title>

	<link rel="stylesheet" href="/resources/css/bootstrap.css">
	<link class="include" rel="stylesheet" type="text/css" href="/resources/css/jquery.jqplot.min.css" />

	<script type="text/javascript" src="/resources/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/resources/script/jquery.jqplot.min.js"></script>
	<script type="text/javascript" src="/resources/plugins/jqplot.pieRenderer.min.js"></script>
	<script type="text/javascript" src="/resources/plugins/jqplot.dateAxisRenderer.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			/*  
			var line1=[['2010.01.01',10], ['2010.01.02',15], ['2010.01.03',30], ['2010.01.04',40], ['2010.01.05',60]];
			$.jqplot('graph', [line1], {
    									title: '${movieVO.name}'
    									, axes:{
        										xaxis:{
            											renderer:$.jqplot.DateAxisRenderer
        											  }
    									  }
										, series:[{lineWidth:4, markerOptions:{style:'square'}}]
  						});
			*/
			$.jqplot ('graph1', [[['긍정', 80], ['부정', 20]]]
						, {
							title: '감성분석'
	          				, seriesDefaults: {
	            								renderer: $.jqplot.PieRenderer
	            								,rendererOptions: {
	              													showDataLabels: true
	            								}
	          				  }
							, legend: { show:true, location: 'e' }
	        				}
					  );

		});
	</script>
	<style>
		#contents{
			clear: both;
			overflow: hidden;
		}
		
		#graph, #graph1{
			float: left;
			margin-right: 50px;
		}
	</style>
</head>
	<body>

		<h1> 영화 정보 </h1>
		<h2> 영화 정보 상세  </h2>
		<h4> 영화 이름: ${movie.mname}</h4>
		<h4> 개봉일: ${movie.sdate}</h4>
		<h4> 장르: ${movie.genre}</h4>
		<h4> 관람 등급: ${movie.rate}</h4>
		<h4> 감독: ${movie.dname}</h4>
		<h4> 주연 배우: ${movie.aname}</h4>
		
		<br/><br/>
		<div id='contents'>
			<!-- <div id="graph" style="width:600px; height:300px;"></div> -->
			<div id="graph1" style="width:300px; height:300px;"></div>
		</div>
		
	</body>
</html>
