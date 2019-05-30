<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
        <title>Chart js</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style type="text/css">
        	
        </style>
    </head>
    <body>
    	<div class="container">
    		<div class="row">
	    		<div class="col-6">
    				<canvas id="cac" class="chartjs-render-monitor" width="200" height="200" style="display: block;width: 200px;height: 200px; ">
    			</div>
    			<div class="col-6">
    				<canvas id="cac1" class="chartjs-render-monitor" width="200" height="200" style="display: block; width: 200px;height: 200px;">
    			</div>
    		</div>
    	</div>
    	<script>
    		
    		var ca = document.getElementById('cac').getContext('2d');
    		var ca1 = document.getElementById('cac1').getContext('2d');
    		var user = ${users};
    		var uc = ${uc};
			var lan = ${lan};
			var lc = ${lc};
    		let pop =  new Chart(ca,{
    		  type: 'bar',
    		  data: {
    		    labels:  user,
    		    datasets: [{
    		      label: 'Users',
    		      data: uc,
    		      borderWidth: 1
    		    }]
    		  },
    		  options: {
    		    responsive: false,
    		    scales: {
    		      xAxes: [{
    		        ticks: {
    		          maxRotation: 90,
    		          minRotation: 80
    		        }
    		      }],
    		      yAxes: [{
    		        ticks: {
    		          beginAtZero: true
    		        }
    		      }]
    		    }
    		  }
    		});
    		
    		let pop1 = new Chart(ca1,{
    		  type: 'bar',
    		  data: {
    		    labels:  lan,
    		    datasets: [{
    		      label: 'Languages',
    		      data:  lc ,
    		      borderWidth: 1
    		    }]
    		  },
    		  options: {
    		    responsive: false,
    		    scales: {
    		      xAxes: [{
    		        ticks: {
    		          maxRotation: 90,
    		          minRotation: 80
    		        }
    		      }],
    		      yAxes: [{
    		        ticks: {
    		          beginAtZero: true
    		        }
    		      }]
    		    }
    		  }
    		});
    	</script>
    </body>
</html>