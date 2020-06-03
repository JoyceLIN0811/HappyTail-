<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>商品管理</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">


<script>
	
</script>
</head>

<body class="hold-transition sidebar-mini">
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
					<a href="adminIndex" class="nav-link">Home</a>
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
				<img src="${pageContext.request.contextPath}/admin/dist/img/AdminLTELogo.png"
					alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
				<span class="brand-text font-weight-light">AdminLTE 3</span>
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
									<a href="admin-ShoppingIndex" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>總覽</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="admin-AllProjects" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>商品列表</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="admin-InsertProject" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>新增商品</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="admin-AllOrders" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>訂單列表</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="admin-OrderInfo" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>訂單狀態</p>
									</a>
								</li>
							</ul>
						</li>

						<li class="nav-item">
							<a href="" class="nav-link">
								<i class="nav-icon fas fa-table"></i>
								<p>預約管理</p>
							</a>
						</li>

						<li class="nav-item">
							<a href="#" class="nav-link">
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
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>商品資料</h1>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">

							<div class="card">
								<!-- /.card-header -->
								<div class="card-body">
									<table id="projects" class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>商品名稱</th>
												<th>商品價格</th>
												<th>商品描述</th>
												<th>商品數量</th>
												<th>商品照片</th>
												<th>商品狀態</th>
												<th>修改</th>

											</tr>
										</thead>

										<tbady> </tbady>

										<tfoot>
											<tr>
												<th>商品名稱</th>
												<th>商品價格</th>
												<th>商品描述</th>
												<th>商品數量</th>
												<th>商品照片</th>
												<th>商品狀態</th>
												<th>修改</th>

											</tr>
										</tfoot>
									</table>
								</div>
								<!-- /.card-body -->
							</div>
							<!-- /.card -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="float-right d-none d-sm-block">
				<b>Version</b>
				3.0.5
			</div>
			<strong>
				Copyright &copy; 2014-2019
				<a href="http://adminlte.io">AdminLTE.io</a>
				.
			</strong>
			All rights reserved.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->
	
	<!-- 會員更新表單 -->
	<div class="modal fade" id="member-update">
		<div class="modal-dialog  modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">修改商品資料</h4>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!-- Form表單 -->
					<form method='POST'>

						<div class="card-body">
							<div class="row">
								<div class="col-sm-6">
									<!-- text input -->
									<div class="form-group">
										<label>名稱</label>
										<input type="text" class="form-control" id="upadte-name" />
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<label>價格</label>
										<input type="text" class="form-control" id="upadte-age" />
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<label>描述</label>
										<input type="date" class="form-control" id="upadte-bday" />
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<label>數量</label>
										<input type="date" class="form-control" id="upadte-bday" />
									</div>
								</div>

							</div>
							<div class="modal-footer justify-content-between">
								<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
								<button type="submit" class="btn btn-primary">修改</button>
							</div>
						</div>

					</form>

				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</div>
	<!-- /.modal -->




	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/admin/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- DataTables -->
	<script src="${pageContext.request.contextPath}/admin/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/admin/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/admin/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/admin/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
	<!-- AdminLTE App -->
	<script src="${pageContext.request.contextPath}/admin/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="${pageContext.request.contextPath}/admin/dist/js/demo.js"></script>
	<!-- page script -->
	<script>
		$(document)
				.ready(
						function() {
							$('#projects')
									.DataTable(

											{
												searching : false,
												"ajax" : {
													"url" : "<c:url value='admin-AllProjects-json' />",
													"dataSrc" : ""
												},

												"columns" : [
														{
															"data" : "name"
														},
														{
															"data" : "price"
														},
														{
															"data" : "descriptrion"
														},
														{
															"data" : "amount"
														},
														{
															"data" : "biPhoto",
															render : function(
																	data, type,
																	row) {
																return '<img src="data:image/jpeg;base64,'+ data + '" width="150px" height="150px">';
															}
														},
														{
															"data" : "status",
															"render" : function(
																	data, type,
																	full, meta) {
																if (data == "0") {
																	return data = '<span class="badge badge-danger">下架</span>';
																} else {
																	return data = '<span class="badge badge-success">供貨中</span>';
																}
															}

														}

												],
												columnDefs : [ {
													//最後一行加上修改按鈕
													"data" : "productId",
													targets : 6,
													orderable : false,
													render : function(data,
															type, row, meta) {
														return "<button type='button' class='btn btn-info btn-sm' id='" + data + "'><i class='fas fa-pencil-alt'></i>修改</button>&nbsp"
															 + "<button type='button' class='btn btn-info btn-sm' data-toggle='modal' data-target='#member-update'><i class='fas fa-pencil-alt'></i>測試</button>";
																
													}
												} ]
											});
						});
	</script>


</body>

</html>