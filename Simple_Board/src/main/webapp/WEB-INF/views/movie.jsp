<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>영화 뷰</title>

	<link rel="stylesheet" href="/resources/css/bootstrap.css">
	<link class="include" rel="stylesheet" type="text/css" href="/resources/css/jquery.jqplot.min.css" />
	<link class="include" rel="stylesheet" type="text/css" href="/resources/css/movie.css" />

	<script type="text/javascript" src="/resources/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/resources/script/jquery.jqplot.min.js"></script>
	<script type="text/javascript" src="/resources/plugins/jqplot.pieRenderer.min.js"></script>
	<script type="text/javascript" src="/resources/plugins/jqplot.barRenderer.js"></script>
	<script type="text/javascript" src="/resources/plugins/jqplot.dateAxisRenderer.js"></script>
	<script type="text/javascript" src="/resources/plugins/jqplot.categoryAxisRenderer.js"></script>
	<script type="text/javascript" src="/resources/plugins/jqplot.pointLabels.js"></script>
	<script type="text/javascript" src="/resources/script/movie.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){

		$.jqplot ('graph1', [[['긍정', ${movie.senti}], ['부정', (100- ${movie.senti}) ]]]
					, {
          				seriesDefaults: {
            								renderer: $.jqplot.PieRenderer
            								,rendererOptions: {
              													showDataLabels: true
            								}
          				  }
						, legend: { show:true, location: 's' }
						, grid: {
							drawBorder: false, 
							background: '#ffffff',
							shadow: false
						  }
						, seriesColors: [ '#ffc0cb', '#b0e0e6']
        				}
				  );
	
		
	        var s1 = [${movie.story}, ${movie.act}, ${movie.video}];
	        var ticks = ['스토리/연출', '배우/연기', '영상/음악'];
	         
	        $.jqplot('chart1', [s1], {
	            animate: !$.jqplot.use_excanvas,
	            seriesDefaults:{
	                renderer:$.jqplot.BarRenderer,
	                pointLabels: { show: true },
	                rendererOptions: {
	                    varyBarColor: true
	                }
	            },
	            seriesColors:['#ffc0cb', '#b0e0e6', '#dda0dd'],
	            axes: {
	                xaxis: {
	                    renderer: $.jqplot.CategoryAxisRenderer,
	                    ticks: ticks
	                }
	            },
	            highlighter: { show: false },
				grid: {
					drawBorder: false, 
					background: '#ffffff',
					shadow: false
				}
	        });

	});
	</script>

</head>
	<body>
		<div id="contents">
			<a href="/">홈으로</a>
			<div id="movie_detail">
				<div class="movie_left">
					<img class="poster" src="http://35.194.131.5:9999/files/img/${movie.mid}.jpg">
				</div>
				<div class = "movie_left movie_right">
					<h2> ${movie.name}</h2>
					<h4> 개요: ${movie.genre} | ${movie.country} | ${movie.playdate} 개봉 | ${movie.rate} </h4>
					<h4>
						감독: 
						<c:forEach items="${directors}" var="director" varStatus="status">
							${director.name}
							<c:if test="${status.count < directors.size()}">
							, 
							</c:if>
						</c:forEach>			
					</h4>			
					<h4> 
						주연:
						<c:forEach items="${actors}" var="actor" varStatus="status">
							${actor.name}
							<c:if test="${status.count %4 eq 0}">
							<br/>&nbsp;&nbsp;&nbsp;&nbsp; 
							</c:if>				
							<c:if test="${status.count < actors.size()}">
							, 
							</c:if>
						</c:forEach>
					</h4>
					<h4> 배급사: ${movie.company}</h4>
					<h4> 흥행: 누적관객 ${movie.ticket} 명 </h4>						
				</div>
			</div>
			<hr/>
			<div id="wordcloud_wrapper">
				<img class="wordcloud" src="http://35.194.131.5:9999/files/wordcloud/${movie.mid}.png">
			</div>
			<hr/>
			<br/><br/>
			<!-- <div id="graph" style="width:600px; height:300px;"></div> -->
			<div id="senti" >
				<div id="graph1"></div>
				<div>
					<h3 class="good">좋아요 </h3>
					(&nbsp;<a id= "pprev" href="#">이전</a> &nbsp;| &nbsp;
					<a id= "pnext" href="#">다음</a>&nbsp;) 
					
					<table id="positive" class="class_table">
						<c:forEach items="${pcomments}" var="pcomment" varStatus="status">
							<tr>
								<td>${pcomment.comments} | ${pcomment.regdate }</td>
							</tr>
						</c:forEach>			
					</table>
					
					<h3 class="bad">글쎄요 </h3>
					(&nbsp;<a id= "nprev" href="#">이전</a> &nbsp;| &nbsp;
					<a id= "nnext" href="#">다음</a>&nbsp;) 
					<table id="negative" class="class_table">
						<c:forEach items="${ncomments}" var="ncomment" varStatus="status">
							<tr>
								<td>${ncomment.comments} | ${ncomment.regdate }</td>
							</tr>
						</c:forEach>			
					</table>
				</div>		
			</div>
			<hr/>
			<br/><br/>
			<div id="topic">
				<div id="chart1"></div>
				<div id="topics">
					<h3 class="story">스토리/연출 </h3>
					(&nbsp;<a id= "sprev" href="#">이전</a> &nbsp;| &nbsp;
					<a id= "snext" href="#">다음</a>&nbsp;) 
					<table id="story" class="class_table">
						<c:forEach items="${stories}" var="story" varStatus="status">
							<tr>
								<td>${story.comments} | ${story.regdate }</td>
							</tr>
						</c:forEach>			
					</table>		
					
					<h3 class="acting">배우/연기 </h3>
					(&nbsp;<a id= "aprev" href="#">이전</a> &nbsp;| &nbsp;
					<a id= "anext" href="#">다음</a>&nbsp;) 
					<table id="act" class="class_table">
						<c:forEach items="${actings}" var="acting" varStatus="status">
							<tr>
								<td>${acting.comments} | ${acting.regdate }</td>
							</tr>
						</c:forEach>			
					</table>		
					
					<h3 class="video">영상/음악 </h3>
					(&nbsp;<a id= "vprev" href="#">이전</a> &nbsp;| &nbsp;
					<a id= "vnext" href="#">다음</a>&nbsp;) 
					<table id="video" class = "class_table">
						<c:forEach items="${videos}" var="video" varStatus="status">
							<tr>
								<td>${video.comments} | ${video.regdate }</td>
							</tr>
						</c:forEach>			
					</table>	
				</div>
			</div>
			<br/><br/>
			<a href="/">홈으로</a>
		</div>	
	</body>
</html>
