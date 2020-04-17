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
					<li><a href="#">Cập Nhật Thông Tin Toà Nhà</a></li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="widget-box">
						<div class="widget-header">
							<h4 class="widget-title">Cập Nhật Thông Tin Toà Nhà</h4>
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
										<!-- PAGE CONTENT BEGINS -->
										<form id="formedit" >
											<div class="row">
												<div class="col-sm-7">
												<input type="hidden" id="id" name="id" value="${buildingDto.id }" />
													<div>
														<label for="name"> Tên Toà Nhà </label> <input type="text"
															id="name" name="name" value="${buildingDto.name}" class="form-control" />
													</div>
												</div>
												<div class="col-sm-4">
													<label for="">Phường</label> <input type="text" id="ward"
														name="ward"  value="${buildingDto.ward}" class="form-control" />
												</div>
												<div class="col-sm-4">
													<label for="">Đường</label> <input type="text"
														name="street" name="street"  value="${buildingDto.street}" class="form-control" />
												</div>
												<div class="col-sm-4">
													<label for="">Số Tầng Hầm</label> <input type="number"
														id="numberOfBasement" name="numberOfBasement"  value="${buildingDto.numberOfBasement}"
														class="form-control" />
												</div>

												<div class="col-sm-3">
													<label for="">Diện tích thuê</label> <input type="text"
														id="rentAreas" name="rentAreas" value="${buildingDto.rentAreas}"  class="form-control" />
												</div>
												<div class="col-sm-3">
													<label for="">Diện tích sàn</label> <input type="number"
														id="floorArea" name="floorArea" value="${buildingDto.floorArea}"  class="form-control" />
												</div>
												<div class="col-sm-3">
													<label for="">Tên Quản Lý Toà Nhà</label> <input
														type="text" id="managerName" name="managerName" value="${buildingDto.managerName}" 
														class="form-control" />
												</div>
												<div class="col-sm-3">
													<label for="">SĐT Quản Lý Toà Nhà</label> <input
														type="text" id="managerPhone" name="managerPhone" value="${buildingDto.managerPhone}"
														class="form-control" />
												</div>
												<div class="col-sm-3">
													<label for="">Giá Thuê</label> <input type="number"
														id="rentCost" name="rentCost"  value="${buildingDto.rentCost}" class="form-control" />
												</div>
												<div class="col-sm-12">
													<div class="control-group">
														<label class="control-label bolder blue">Loại toà
															nhà</label>
														<div class="checkbox">
															<label> <input name="buildingTypes"
																value="TANG_TRET" type="checkbox" class="ace"> <span
																class="lbl">Tầng Trệt</span>
															</label> <label> <input name="buildingTypes"
																value="NGUYEN_CAN" type="checkbox" class="ace">
																<span class="lbl">Nguyên Căn</span>
															</label> <label> <input name="buildingTypes"
																value="NOI_THAT" type="checkbox" class="ace"> <span
																class="lbl">Nội Thất</span>
															</label>
														</div>
													</div>
												</div>
												<div class="col-sm-12">

													<button class="pull-left" id="btnCapNhatToaNha" type="submit"
														title="Cập Nhật Toà Nhà"
														class="btn btn-sucess btn-info btn-bold">Cập Nhật Toà
														Nhà</button>

												</div>
											</div>
										</form>
										<!-- PAGE CONTENT ENDS -->
									</div>
									<!-- /.col -->
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->
</body>


</html>