<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>後臺管理系統</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<!-- Navbar -->
		<nav class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" data-widget="pushmenu" href="#" role="button">
						<i class="fas fa-bars"></i>
					</a>
				</li>
				<li class="nav-item d-none d-sm-inline-block">
					<a href="admin-Index" class="nav-link">Home</a>
				</li>
				<li class="nav-item d-none d-sm-inline-block">
					<a href="#" class="nav-link">Contact</a>
				</li>
			</ul>

			<!-- SEARCH FORM -->
			<form class="form-inline ml-3">
				<div class="input-group input-group-sm">
					<input class="form-control form-control-navbar" type="search" placeholder="Search"
						aria-label="Search">
					<div class="input-group-append">
						<button class="btn btn-navbar" type="submit">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
			</form>

			<!-- Right navbar links -->
			<ul class="navbar-nav ml-auto">
				<!-- Messages Dropdown Menu -->
				<li class="nav-item dropdown">
					<a class="nav-link" data-toggle="dropdown" href="#">
						<i class="far fa-comments"></i>
						<span class="badge badge-danger navbar-badge">3</span>
					</a>
					<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
						<a href="#" class="dropdown-item">
							<!-- Message Start -->
							<div class="media">
								<img src="dist/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle">
								<div class="media-body">
									<h3 class="dropdown-item-title">
										Brad Diesel
										<span class="float-right text-sm text-danger">
											<i class="fas fa-star"></i>
										</span>
									</h3>
									<p class="text-sm">Call me whenever you can...</p>
									<p class="text-sm text-muted">
										<i class="far fa-clock mr-1"></i>
										4 Hours Ago
									</p>
								</div>
							</div>
							<!-- Message End -->
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item">
							<!-- Message Start -->
							<div class="media">
								<img src="dist/img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
								<div class="media-body">
									<h3 class="dropdown-item-title">
										John Pierce
										<span class="float-right text-sm text-muted">
											<i class="fas fa-star"></i>
										</span>
									</h3>
									<p class="text-sm">I got your message bro</p>
									<p class="text-sm text-muted">
										<i class="far fa-clock mr-1"></i>
										4 Hours Ago
									</p>
								</div>
							</div>
							<!-- Message End -->
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item">
							<!-- Message Start -->
							<div class="media">
								<img src="dist/img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
								<div class="media-body">
									<h3 class="dropdown-item-title">
										Nora Silvester
										<span class="float-right text-sm text-warning">
											<i class="fas fa-star"></i>
										</span>
									</h3>
									<p class="text-sm">The subject goes here</p>
									<p class="text-sm text-muted">
										<i class="far fa-clock mr-1"></i>
										4 Hours Ago
									</p>
								</div>
							</div>
							<!-- Message End -->
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
					</div>
				</li>
				<!-- Notifications Dropdown Menu -->
				<li class="nav-item dropdown">
					<a class="nav-link" data-toggle="dropdown" href="#">
						<i class="far fa-bell"></i>
						<span class="badge badge-warning navbar-badge">15</span>
					</a>
					<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
						<span class="dropdown-item dropdown-header">15 Notifications</span>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item">
							<i class="fas fa-envelope mr-2"></i>
							4 new messages
							<span class="float-right text-muted text-sm">3 mins</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item">
							<i class="fas fa-users mr-2"></i>
							8 friend requests
							<span class="float-right text-muted text-sm">12 hours</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item">
							<i class="fas fa-file mr-2"></i>
							3 new reports
							<span class="float-right text-muted text-sm">2 days</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
					</div>
				</li>
			</ul>
		</nav>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="adminIndex" class="brand-link">
				<img src="admin/dist/img/AdminLTELogo.png" alt="AdminLTE Logo"
					class="brand-image img-circle elevation-3" style="opacity: .8">
				<span class="brand-text font-weight-light">後臺管理</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">

				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
						data-accordion="false">
						<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
						<li class="nav-item">
							<a href="admin-Index" class="nav-link">
								<i class="nav-icon fas fa-tachometer-alt"></i>
								<p>首頁</p>
							</a>
						</li>

						<li class="nav-item">
							<a href="admin-AllMembers" class="nav-link">
								<i class="nav-icon fas fa-table"></i>
								<p>會員資料管理</p>
							</a>
						</li>

						<li class="nav-item has-treeview">
							<a href="#" class="nav-link active">
								<i class="nav-icon fas fa-tachometer-alt"></i>
								<p>
									線上商城
									<i class="right fas fa-angle-left"></i>
								</p>
							</a>
							<ul class="nav nav-treeview">
								<li class="nav-item">
									<a href="admin-AllProjects" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>商品列表</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="admin-AllProjects" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>新增商品</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="#" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>訂單列表</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="#" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>訂單狀態</p>
									</a>
								</li>
							</ul>
						</li>

						<li class="nav-item">
							<a href="admin-AllProjects-json" class="nav-link">
								<i class="nav-icon fas fa-table"></i>
								<p>預約管理</p>
							</a>
						</li>

						<li class="nav-item">
							<a href="admin-allMembersJSON" class="nav-link">
								<i class="nav-icon fas fa-table"></i>
								<p>討論區管理</p>
							</a>
						</li>
					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>



		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-3 col-6">
							<!-- small box -->
							<div class="small-box bg-info">
								<div class="inner">
									<h3>${countProjects}</h3>


									<p>總商品數</p>
								</div>
								<div class="icon">
									<i class="ion ion-bag"></i>
								</div>
								<a href="#" class="small-box-footer">
									More info
									<i class="fas fa-arrow-circle-right"></i>
								</a>
							</div>
						</div>
						<!-- ./col -->
						<div class="col-lg-3 col-6">
							<!-- small box -->
							<div class="small-box bg-warning">
								<div class="inner">
									<h3>${count}</h3>
									<p>註冊人數</p>
								</div>
								<div class="icon">
									<i class="ion ion-person-add"></i>
								</div>
								<a href="admin-AllMembers" class="small-box-footer">
									More info
									<i class="fas fa-arrow-circle-right"></i>
								</a>
							</div>
						</div>

						<div class="col-lg-3 col-6">
							<!-- small box -->
							<div class="small-box bg-success">
								<div class="inner">
									<h3>
										53
										<sup style="font-size: 20px">%</sup>
									</h3>

									<p>Bounce Rate</p>
								</div>
								<div class="icon">
									<i class="ion ion-stats-bars"></i>
								</div>
								<a href="#" class="small-box-footer">
									More info
									<i class="fas fa-arrow-circle-right"></i>
								</a>
							</div>
						</div>

						<div class="col-lg-3 col-6">
							<!-- small box -->
							<div class="small-box bg-danger">
								<div class="inner">
									<h3>65</h3>

									<p>Unique Visitors</p>
								</div>
								<div class="icon">
									<i class="ion ion-pie-graph"></i>
								</div>
								<a href="#" class="small-box-footer">
									More info
									<i class="fas fa-arrow-circle-right"></i>
								</a>
							</div>
						</div>
						<!-- ./col -->
					</div>
				</div>
				<!-- PIE CHART -->
				<div class="row">
					<div class="col-md-6">
						<div class="card card-danger">
							<div class="card-header">
								<h3 class="card-title">男女比例</h3>

								<div class="card-tools">
									<button type="button" class="btn btn-tool" data-card-widget="collapse">
										<i class="fas fa-minus"></i>
									</button>
									<button type="button" class="btn btn-tool" data-card-widget="remove">
										<i class="fas fa-times"></i>
									</button>
								</div>
							</div>
							<div class="card-body">
								<canvas id="pieChart"
									style="min-height: 250px; height: 250px; max-height: 250px; max-width: 100%;"></canvas>
							</div>
							<!-- /.card-body -->
						</div>
					</div>
					<!-- /.card -->
					<div class="col-md-6">
						<!-- BAR CHART -->

						<div class="card card-success">
							<div class="card-header">
								<h3 class="card-title">年齡分布</h3>

								<div class="card-tools">
									<button type="button" class="btn btn-tool" data-card-widget="collapse">
										<i class="fas fa-minus"></i>
									</button>
									<button type="button" class="btn btn-tool" data-card-widget="remove">
										<i class="fas fa-times"></i>
									</button>
								</div>
							</div>
							<div class="card-body">
								<div class="chart">
									<canvas id="barChart"
										style="min-height: 250px; height: 250px; max-height: 250px; max-width: 100%;"></canvas>
								</div>
							</div>
							<!-- /.card-body -->
						</div>
						<!-- /.card -->

					</div>
				</div>



			</section>

		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<strong>
				Copyright &copy; 2014-2019
				<a href="http://adminlte.io">AdminLTE.io</a>
				.
			</strong>
			All rights reserved.
			<div class="float-right d-none d-sm-inline-block">
				<b>Version</b>
				3.0.5
			</div>
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/admin/plugins/jquery/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="${pageContext.request.contextPath}/admin/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script>
	<!-- Bootstrap 4 -->
	<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- ChartJS -->
	<script src="${pageContext.request.contextPath}/admin/plugins/chart.js/Chart.min.js"></script>
	<!-- Sparkline -->
	<script src="${pageContext.request.contextPath}/admin/plugins/sparklines/sparkline.js"></script>
	<!-- AdminLTE App -->
	<script src="${pageContext.request.contextPath}/admin/dist/js/adminlte.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="${pageContext.request.contextPath}/admin/dist/js/pages/dashboard.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="${pageContext.request.contextPath}/admin/dist/js/demo.js"></script>

	//圓餅圖
	<script>
		$(function() {
			var pieChartCanvas = $('#pieChart').get(0).getContext('2d')
			var pieData = {
				labels: [
			          '女性', 
			          '男性',
			      ],
			      datasets: [
			        {
			          data: [${female},${male}],
			          backgroundColor : ['#f56954','#00c0ef'],
			        }
			      ]
				}
			var pieOptions = {
				maintainAspectRatio : false,
				responsive : true,
			}
			var pieChart = new Chart(pieChartCanvas, {
				type : 'pie',
				data : pieData,
				options : pieOptions
			})
		})
	</script>

	//年齡分布
	<script>
	$(function() {
		var ctx = $('#barChart').get(0).getContext('2d')
		var barChart = new Chart(ctx, {
			
			type: 'bar',
			data: {
			  labels: ['10-19', '20-29', '30-39', '40-49', '50-59', '60-69'],
			  datasets: [{
			   borderWidth: 1,
			     label: '人數',
			     data: [${list[0]}, ${list[1]}, ${list[2]}, ${list[3]}, ${list[4]}, ${list[5]}]
			  }]
			  }
		    
			});
	})
	</script>
</body>
</html>