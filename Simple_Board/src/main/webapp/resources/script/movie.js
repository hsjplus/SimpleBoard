
$(document).ready(function(){

			/*
			 * 긍정 후기 다음 버튼 
			 * */
			$('#pnext').click(function(){
				$.ajax ({
				url:'/ajax/resBody',
				type: 'GET',
				data: 'num=1&type=0',
				dataType: 'json',
				success: function(data){
					$('#positive').empty();
					$.each(data, function(index, mem){
						var html = "<tr><td>"+mem.comments+"|"+mem.regdate +"<td/><tr/>";
						$('#positive').append(html);
					});
				}
			    }); 						
				return false;
			});
			
			/*
			 * 긍정 후기 이전 버튼
			 * */
			$('#pprev').click(function(){
				$.ajax ({
				url:'/ajax/resBody',
				type: 'GET',
				data: 'num=-1&type=0',
				dataType: 'json',
				success: function(data){
					$('#positive').empty();
					$.each(data, function(index, mem){
						var html = "<tr><td>"+mem.comments+"|"+mem.regdate +"<td/><tr/>";
						$('#positive').append(html);
					});
				}
			    }); 						
				return false;
			});		
			
			/*
			 * 부정 후기 다음 버튼 
			 * */
			$('#nnext').click(function(){
				$.ajax ({
				url:'/ajax/resBody',
				type: 'GET',
				data: 'num=1&type=1',
				dataType: 'json',
				success: function(data){
					$('#negative').empty();
					$.each(data, function(index, mem){
						var html = "<tr><td>"+mem.comments+"|"+mem.regdate +"<td/><tr/>";
						$('#negative').append(html);
					});
				}
			    }); 						
				return false;
			});
			
			/*
			 * 부정 후기 이전 버튼
			 * */
			$('#nprev').click(function(){
				$.ajax ({
				url:'/ajax/resBody',
				type: 'GET',
				data: 'num=-1&type=1',
				dataType: 'json',
				success: function(data){
					$('#negative').empty();
					$.each(data, function(index, mem){
						var html = "<tr><td>"+mem.comments+"|"+mem.regdate +"<td/><tr/>";
						$('#negative').append(html);
					});
				}
			    }); 						
				return false;
			});		
			
			/*
			 * 스토리 후기 다음 버튼 
			 * */
			$('#snext').click(function(){
				$.ajax ({
				url:'/ajax/resBody',
				type: 'GET',
				data: 'num=1&type=2',
				dataType: 'json',
				success: function(data){
					$('#story').empty();
					$.each(data, function(index, mem){
						var html = "<tr><td>"+mem.comments+"|"+mem.regdate +"<td/><tr/>";
						$('#story').append(html);
					});
				}
			    }); 						
				return false;
			});
			
			/*
			 * 스토리 후기 이전 버튼
			 * */
			$('#sprev').click(function(){
				$.ajax ({
				url:'/ajax/resBody',
				type: 'GET',
				data: 'num=-1&type=2',
				dataType: 'json',
				success: function(data){
					$('#story').empty();
					$.each(data, function(index, mem){
						var html = "<tr><td>"+mem.comments+"|"+mem.regdate +"<td/><tr/>";
						$('#story').append(html);
					});
				}
			    }); 						
				return false;
			});	
			
			/*
			 * 연기 후기 다음 버튼 
			 * */
			$('#anext').click(function(){
				$.ajax ({
				url:'/ajax/resBody',
				type: 'GET',
				data: 'num=1&type=3',
				dataType: 'json',
				success: function(data){
					$('#act').empty();
					$.each(data, function(index, mem){
						var html = "<tr><td>"+mem.comments+"|"+mem.regdate +"<td/><tr/>";
						$('#act').append(html);
					});
				}
			    }); 						
				return false;
			});
			
			/*
			 * 연기 후기 이전 버튼
			 * */
			$('#aprev').click(function(){
				$.ajax ({
				url:'/ajax/resBody',
				type: 'GET',
				data: 'num=-1&type=3',
				dataType: 'json',
				success: function(data){
					$('#act').empty();
					$.each(data, function(index, mem){
						var html = "<tr><td>"+mem.comments+"|"+mem.regdate +"<td/><tr/>";
						$('#act').append(html);
					});
				}
			    }); 						
				return false;
			});	
			
			/*
			 * 영상 후기 다음 버튼 
			 * */
			$('#vnext').click(function(){
				$.ajax ({
				url:'/ajax/resBody',
				type: 'GET',
				data: 'num=1&type=4',
				dataType: 'json',
				success: function(data){
					$('#video').empty();
					$.each(data, function(index, mem){
						var html = "<tr><td>"+mem.comments+"|"+mem.regdate +"<td/><tr/>";
						$('#video').append(html);
					});
				}
			    }); 						
				return false;
			});
			
			/*
			 * 영상 후기 이전 버튼
			 * */
			$('#vprev').click(function(){
				$.ajax ({
				url:'/ajax/resBody',
				type: 'GET',
				data: 'num=-1&type=4',
				dataType: 'json',
				success: function(data){
					$('#video').empty();
					$.each(data, function(index, mem){
						var html = "<tr><td>"+mem.comments+"|"+mem.regdate +"<td/><tr/>";
						$('#video').append(html);
					});
				}
			    }); 						
				return false;
			});	
			
			
			
});
