<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp" %>
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
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="/admin/building/list">Trang chủ</a>
                            </li>
                        </ul>
                        <!-- /.breadcrumb -->
                    </div>
                    <div class="page-content">
                        <div class="row">
                            <div class="widget-box">
                                <div class="widget-header">
                                    <h4 class="widget-title">Tìm Kiếm</h4>
                                    <div class="widget-toolbar">
                                        <a href="#" data-action="collapse">
                                            <i class="ace-icon fa fa-chevron-up"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="widget-body">
                                    <div class="widget-main">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <!-- PAGE CONTENT BEGINS -->
                                                <form action="/admin/building/seach" method="GET" id="formSearchBuilding">
                                                    <div class="row">
                                                        <div class="col-sm-6">
                                                            <div>
                                                                <label for="name"> Tên Toà Nhà </label>
                                                                <input type="text" id="name" name="name" value="${model.name}" class="form-control" />
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <div>
                                                                <label for=""> Diện Tích Sàn </label>
                                                                <input type="number" id="floorarea"  name="floorArea" class="form-control" />
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <label for="">Quận Huyện</label>
                                                            <select class="form-control" id="district" name="district">
														<option value="">--Chọn Quận Huyện--</option>
														<c:forEach items="${mapdistrict}" var="item">
															<option value="${item.key}" ${item.key eq model.district ?'selected':''}>${item.value}</option>
														</c:forEach>
													</select>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <label for="">Phường</label>
                                                            <input type="text" id="ward" name="ward" class="form-control" />
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <label for="">Đường</label>
                                                            <input type="text" id="street" name="street" class="form-control" />
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <label for="">Số Tầng Hầm</label>
                                                            <input type="number" id="numberOfBasement" name="numberOfBasement" class="form-control" />
                                                        </div>
                                                    
                                                        <div class="col-sm-3">
                                                            <label for="">Diện tích thuê từ</label>
                                                            <input type="number" id="rentAreaFrom" name="rentAreaFrom" class="form-control" />
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <label for="">Diện tích thuê đến</label>
                                                            <input type="number" id="rentAreaTo" name="rentAreaTo" class="form-control" />
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <label for="">Giá thuê từ</label>
                                                            <input type="number" id="rentCostFrom" name="rentCostFrom" class="form-control" />
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <label for="">Giá thuê đến</label>
                                                            <input type="number" id="rentCostTo" name="rentCostTo" class="form-control" />
                                                        </div>
                                                 
                                                        <div class="col-sm-3">
                                                            <label for="">Chọn nhân viên phụ trách</label>
                                                            <select class="form-control" name="staffId">
																<option value="-1">--Chọn Nhân Viên Phụ Trách--</option>
															<option value="1">Nguyễn Văn A</option>
																<option value="2">Nguyễn Văn B</option>
																<option value="3">Nguyễn Văn C</option>
															</select>
                                                        </div>
                                                     <div class="col-sm-12">
                                                            <div class="control-group">
                                                                <label class="control-label bolder blue">Loại toà nhà</label>
                                                                <div class="checkbox">
                                                                    <c:forEach items="${mapbuildingtype}" var="item">
                                                                        <label>
																<input name="buildingTypes" value="${item.key}" class="ace"
																type="checkbox" ${fn:contains(fn:join(model.buildingTypes,','),item.key) ?'checked':''}  >
																<span class="lbl">${item.value}</span>
															</label>
                                                                    </c:forEach>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-12">
                                                            <div class="pull-left" title="Thêm Toà Nhà">
                                                                <button id="btnSearchBuilding" type="submit" class="btn btn-sucess btn-info btn-bold">
											           	Tìm Kiếm
											           </button>
                                                            </div>
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
                            <div class="pull-left" data-toggle="tooltip" title="Thêm Toà Nhà">
                                <a href="/admin/building/insert" class="btn btn-sucess btn-info btn-bold">
                                    <i class="ace-icon glyphicon glyphicon-plus"></i> Thêm
                                </a>
                            </div>
                            <div class="pull-left" title="Xoá Nhiều Toà Nhà">
                                <button class="btn btn-danger btn-info btn-bold" id="btnDeleteBuildings">
									<i class="ace-icon fa fa-trash-o icon-only"></i>
									Xoá
							</button>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <table id="buildingList" class="table table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>Tên Toà Nhà</th>
                                                <th>Địa Chỉ</th>
                                                <th>Tên Quản Lý</th>
                                                <th>Số Điện Thoại</th>
                                                <th>Diện Tích Sàn</th>
                                                <th>Diện Tích Thuê</th>
                                                <th>Giá Thuê</th>
                                                <th>Loại toà nhà</th>
                                                <th>Thao Tác</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="item">
                                                <tr id="tr_${item.id }">
                                                    <td class="center">
                                                        <input type="checkbox" value="${item.id }" id="checkbox_${item.id}" />
                                                    </td>
                                                    <td>${item.name}</td>
                                                    <td>${item.street}</td>
                                                    <td>${item.managerName}</td>
                                                    <td>${item.managerPhone}</td>
                                                    <td>${item.floorarea}</td>
                                                    <td>${item.rentAreas} m2</td>
                                                    <td>${item.rentCost} triệu/m2</td>
                                                    <td>${item.type}</td>
                                                    <td>
                                                        <div class="hidden-sm hidden-xs btn-group">
                                                            <button class="btn btn-xs btn-success" title="giao toà nhà" onclick="Assignmentbuilding(${item.id})">
																<i class="ace-icon fa fa-check bigger-120"></i>
													</button>

                                                            <a href="<c:url value='/admin/building/edit?id=${item.id}'/>" class="btn btn-xs btn-info" title="Sửa toà nhà">
                                                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                            </a>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.page-content -->
                </div>

            </div>
            <!-- /.main-content -->


            <!-- Modal -->
            <div class="modal fade" id="assignmentbuildingmodal" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        </div>
                        <div class="modal-body">
                            <h3>Tích để giao toà nhà cho nhân viên</h3>
                            <table id="staffList">
                                <thead>
                                    <tr>Chọn nhân viên</tr>
                                    <tr>Tên nhân vien</tr>
                                </thead>
                                <tbody>
                                   
                                </tbody>
                            </table>
                            <input type="hidden" value="" name="buildingid" id="buildingid" />
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="btnAssignBuilding">Giao</button>
                        </div>
                    </div>
                </div>
            </div>

        </body>

        </html>