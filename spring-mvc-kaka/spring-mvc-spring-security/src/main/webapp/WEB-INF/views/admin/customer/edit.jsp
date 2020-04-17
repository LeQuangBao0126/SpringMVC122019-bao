<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
</head>

<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Cập
							Nhật Thông Tin Toà Nhà Và Quản Lý Các Giao Dịch</a></li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="widget-box">
						<div class="widget-header">
							<h4 class="widget-title">Cập Nhật Thông Tin Toà Nhà Và Quản
								Lý Các Giao Dịch</h4>
							<div class="widget-toolbar">
								<a href="#" data-action="collapse"> <i
									class="ace-icon fa fa-chevron-up"></i>
								</a>
							</div>
						</div>
						<div class="widget-body">
							<div class="widget-main">
								<div class="row">
									<div class="col-xs-12">
										<div class="row">
											<!-- truyền model qua ben kia -->

											<div class="col-sm-6">
												<div>
													<label for="name"> Tên Khách Hàng</label> <input
														type="text" id="name" name="name" class="form-control" />
												</div>
											</div>
											<div class="col-sm-6">
												<div>
													<label for=""> Số Điện Thoại </label> <input type="number"
														id="floorArea" name="floorArea" class="form-control" />
												</div>
											</div>
											<div class="col-sm-12">
												<div class="pull-left" title="Cập Nhật Toà Nhà">
													<button class="btn btn-sucess btn-info btn-bold">
														Cập Nhật Khách Hàng</button>
												</div>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="row">
					<div class="col-xs-8">
						<h4 class="">Các Giao Dịch</h4>
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Chăm Sóc Khách Hàng</h4>
								<a href="" class="label label-warning arrowed-in-right arrowed">Thêm
									Ghi Chú</a>
							</div>
							<div class="widget-body">
								<div class="widget-main">
									<div class="row">
										<div class="col-sm-12">
											<div>
												<table id="" class="table table-bordered table-hover">
													<tr>
														<td>Ngày tạo</td>
														<td>Ghi chú</td>
													</tr>
													<tr>
														<td>11/12/2020</td>
														<td>Tư vấn cho anh A toà nhà B</td>
													</tr>
													<tr>
														<td></td>
														<td><span class="input-icon input-icon-right">
																<input type="text" id=""> <i
																class="ace-icon fa fa-leaf green"></i>
														</span></td>
													</tr>

												</table>

											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
						<!--  -->
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Dẫn Khách Hàng Đi Xem</h4>
								<a href="" class="label label-warning arrowed-in-left arrowed">Thêm
									Ghi Chú</a>
							</div>
							<div class="widget-body">
								<div class="widget-main">
									<div class="row">
										<div class="col-sm-12">
											<div>
												<table id="" class="table table-bordered table-hover">
													<tr>
														<td>Ngày tạo</td>
														<td>Ghi chú</td>
													</tr>
													<tr>
														<td>11/12/2020</td>
														<td>Tư vấn cho anh A toà nhà B</td>
													</tr>
													<tr>
														<td></td>
														<td><span class="input-icon input-icon-right">
																<input type="text" id=""> <i
																class="ace-icon fa fa-leaf green"></i>
														</span></td>
													</tr>
												</table>

											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.main-content -->
</body>


</html>