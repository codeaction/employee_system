<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
	<base href="${pageContext.request.contextPath}/"/>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
	<title>人员管理</title>
	<link rel="icon" href="favicon.ico" type="image/ico">
	<meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
	<meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
	<meta name="author" content="yinqi">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/materialdesignicons.min.css" rel="stylesheet">
	<link href="css/style.min.css" rel="stylesheet">
	<!--对话框-->
	<link rel="stylesheet" href="js/jconfirm/jquery-confirm.min.css">
	<!--日期选择插件-->
	<link rel="stylesheet" href="js/bootstrap-datepicker/bootstrap-datepicker3.min.css">
</head>

<body data-theme="dark">
<div class="lyear-layout-web">
	<div class="lyear-layout-container">
		
		<jsp:include page="/WEB-INF/common.jsp"/>
		
		<!--页面主要内容-->
		<main class="lyear-layout-content">
			
			<div class="container-fluid">
				
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-toolbar clearfix">
								<form class="pull-right search-bar" method="get" action="#!" role="form">
									<div class="input-group">
										<input id="searchName" type="text" class="form-control" placeholder="请输入姓名" oninput="findByPage(1)" />
									</div>
								</form>
								<div class="toolbar-btn-action">
									<button class="btn btn-primary btn-info btn-label btn-sm" onclick="showAddModal()">
										<label>
											<i class="mdi mdi-plus"></i>
										</label>
										新增
									</button>
								</div>
							</div>
							<div class="card-body">
								<div class="table-responsive text-center" id="employee_table">
									<!-- 在此次放置表格 -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
		<!--End 页面主要内容-->
	</div>
</div>

<!-- 添加模态框 -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">添加员工</h4>
			</div>
			<div class="modal-body">
				<form id="addForm" class="form-horizontal" action="#" method="post" onsubmit="return false;">
					<div class="form-group">
						<label class="col-md-2 control-label" for="enameAdd">姓名</label>
						<div class="col-md-9">
							<input class="form-control" type="text" id="enameAdd" placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label" for="eageAdd">年龄</label>
						<div class="col-md-9">
							<input class="form-control" type="number" id="eageAdd" placeholder="请输入年龄">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">性别</label>
						<div class="col-sm-10">
							<label class="lyear-radio radio-inline radio-primary">
								<input type="radio" name="egenderAdd" value="男" checked="checked"><span>男</span>
							</label>
							<label class="lyear-radio radio-inline radio-primary">
								<input type="radio" name="egenderAdd" value="女"><span>女</span>
							</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label" for="ejobAdd">职务</label>
						<div class="col-md-9">
							<input class="form-control" type="text" id="ejobAdd" placeholder="请输入职务">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label" for="eentrydateAdd">入职日期</label>
						<div class="col-md-9">
							<input class="form-control js-datepicker m-b-10" type="text" id="eentrydateAdd" name="example-datepicker" placeholder="请选择入职日期" value="" data-date-format="yyyy年mm月dd日" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label" for="esalaryAdd">薪资</label>
						<div class="col-md-9">
							<input class="form-control" type="number" id="esalaryAdd" placeholder="请输入薪资">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label" for="didAdd">所在部门</label>
						<div class="col-md-9">
							<select class="form-control" type="number" id="didAdd">
							</select>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary btn-info btn-sm" onclick="add()">添加</button>
			</div>
		</div>
	</div>
</div>
<!-- 添加模态框 -->

<!-- 修改模态框 -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">修改员工</h4>
			</div>
			<div class="modal-body">
				<form id="updateForm" class="form-horizontal" action="#" method="post" onsubmit="return false;">
					<input type="hidden" id="eidUpdate" />
					<input type="hidden" id="currentPage" />
					<div class="form-group">
						<label class="col-md-2 control-label" for="enameUpdate">姓名</label>
						<div class="col-md-9">
							<input class="form-control" type="text" id="enameUpdate" placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label" for="eageUpdate">年龄</label>
						<div class="col-md-9">
							<input class="form-control" type="number" id="eageUpdate" placeholder="请输入年龄">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">性别</label>
						<div class="col-sm-10">
							<label class="lyear-radio radio-inline radio-primary">
								<input type="radio" name="egenderUpdate" value="男" checked="checked"><span>男</span>
							</label>
							<label class="lyear-radio radio-inline radio-primary">
								<input type="radio" name="egenderUpdate" value="女"><span>女</span>
							</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label" for="ejobUpdate">职务</label>
						<div class="col-md-9">
							<input class="form-control" type="text" id="ejobUpdate" placeholder="请输入职务">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label" for="eentrydateUpdate">入职日期</label>
						<div class="col-md-9">
							<input class="form-control js-datepicker m-b-10" type="text" id="eentrydateUpdate" name="example-datepicker" placeholder="请选择入职日期" value="" data-date-format="yyyy年mm月dd日" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label" for="esalaryUpdate">薪资</label>
						<div class="col-md-9">
							<input class="form-control" type="number" id="esalaryUpdate" placeholder="请输入薪资">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label" for="didAdd">所在部门</label>
						<div class="col-md-9">
							<select class="form-control" type="number" id="didUpdate">
							</select>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary btn-info btn-sm" onclick="update()">修改</button>
			</div>
		</div>
	</div>
</div>
<!-- 修改模态框 -->

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
<script src="js/func.js"></script>
<!--消息提示-->
<script src="js/bootstrap-notify.min.js"></script>
<script type="text/javascript" src="js/lightyear.js"></script>
<!--对话框-->
<script src="js/jconfirm/jquery-confirm.min.js"></script>
<script src="js/template-web.js"></script>
<!--日期选择插件-->
<script src="js/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<script src="js/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>
<script type="text/html" id="all_employee">
	<table class="table table-bordered table-hover">
		<thead>
		<tr>
			<th>编号</th>
			<th>工号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>职务</th>
			<th>入职日期</th>
			<th>薪资</th>
			<th>状态</th>
			<th>所在部门</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		{{each data.list}}
			<tr>
				<td>{{$value.eid}}</td>
				<td>{{$value.eno}}</td>
				<td>{{$value.ename}}</td>
				<td>{{$value.eage}}</td>
				<td>{{$value.egender}}</td>
				<td>{{$value.ejob}}</td>
				<td>{{$value.eentrydate}}</td>
				<td>{{$value.esalary}}</td>
				<td>
					{{if $value.estate==1}}
						<span class="label label-info">在职</span>
					{{else}}
						<span class="label label-default">离职</span>
					{{/if}}
				</td>
				<td>{{$value.dname}}</td>
				<td>
					{{if $value.estate == 1}}
						<button type="button" class="btn btn-xs btn-primary btn-success" onclick="findById('{{$value.eid}}', '{{data.currentPage}}')">修改</button>
						<button type="button" class="btn btn-xs btn-primary btn-danger" onclick="showDelConfirm('{{$value.eid}}', '{{data.currentPage}}')">删除</button>
					{{else}}
						<button type="button" class="btn btn-xs btn-primary btn-success disabled">修改</button>
						<button type="button" class="btn btn-xs btn-primary btn-danger disabled">删除</button>
					{{/if}}
				</td>
			</tr>
		{{/each}}
		</tbody>
	</table>
	<nav>
		<ul class="pagination pagination-circle">
			{{if data.currentPage == 1}}
				<li class="disabled"><span><i class="mdi mdi-chevron-left"></i></span></li>
			{{else}}
				<li onclick="findByPage('{{data.currentPage-1}}')"><a href="javascript:void(0);"><span><i class="mdi mdi-chevron-left"></i></span></a></li>
			{{/if}}
			{{each data.navigation}}
				{{if $value == data.currentPage}}
					<li class="active"><span>{{$value}}</span></li>
				{{else}}
					<li onclick="findByPage('{{$value}}')"><a href="javascript:void(0);">{{$value}}</a></li>
				{{/if}}
			{{/each}}
			{{if data.currentPage == data.totalPage}}
				<li class="disabled"><span><i class="mdi mdi-chevron-right"></i></span></li>
			{{else}}
				<li onclick="findByPage('{{data.currentPage+1}}')"><a href="javascript:void(0);"><span><i class="mdi mdi-chevron-right"></i></span></a></li>
			{{/if}}
		</ul>
	</nav>
</script>
<script type="text/html" id="all_department">
	<option disabled hidden selected>--请选择--</option>
	{{each data}}
	<option value="{{$value.did}}">{{$value.dname}}</option>
	{{/each}}
</script>
<script type="text/javascript">
	//修改
	function update() {
		lightyear.loading('show');
		$.ajax({
			type: "POST",
			url: "admin/employee?action=update",
			data: {eid:$("#eidUpdate").val(),
				ename:$("#enameUpdate").val(),
				eage:$("#eageUpdate").val(),
				egender:$("input[name='egenderUpdate']:checked").val(),
				ejob:$("#ejobUpdate").val(),
				eentrydate:$("#eentrydateUpdate").val(),
				esalary:$("#esalaryUpdate").val(),
				did:$("#didUpdate").val()},
			dataType: "json",
			success: (resp) => {
				lightyear.loading('hide');
				if(resp.code == 10000) {
					//隐藏模态框
					$("#updateModal").modal('hide');
					$("#updateForm")[0].reset();
					lightyear.notify('修改成功', 'success', 1000, 'mdi mdi-emoticon-happy', 'top', 'center');
					//去当前页
					findByPage($("#currentPage").val());
				}
			}
		});
	}
	
	//显示修改模态框
	function findById(eid, currentPage) {
		//获取所有部门
		$.ajax({
			type: "GET",
			url: "admin/department?action=findAll",
			dataType: "json",
			success: (resp) => {
				let html = template('all_department', {data:resp.data});
				//将渲染完成的数据挂载在页面上
				$('#didUpdate').html(html);
				
				$.ajax({
					type: "POST",
					url: "admin/employee?action=findById",
					data: {eid:eid},
					dataType: "json",
					success: (resp) => {
						if(resp.code == '10000') {
							$("#eidUpdate").val(resp.data.eid);
							$("#enameUpdate").val(resp.data.ename);
							$("#eageUpdate").val(resp.data.eage);
							if(resp.data.egender == '男') {
								$("input:radio[name='egenderUpdate'][value='男']").attr('checked', true);
							} else {
								$("input:radio[name='egenderUpdate'][value='女']").attr('checked', true);
							}
							$("#ejobUpdate").val(resp.data.ejob);
							$("#eentrydateUpdate").val(resp.data.eentrydate);
							$("#esalaryUpdate").val(resp.data.esalary);
							$("#didUpdate").val(resp.data.did);
							
							$("#currentPage").val(currentPage);
							//显示修改模态框
							$("#updateModal").modal('show');
						}
					}
				})
			}
		})
	}
	
	//显示删除提示框
	function showDelConfirm(eid, currentPage) {
		$.alert({
			title: '删除确认',
			content: '您确定要删除该员工吗',
			buttons: {
				confirm: {
					text: '确认',
					btnClass: 'btn-primary',
					action: function(){
						$.ajax({
							type: "POST",
							url: "admin/employee?action=del",
							data: {eid:eid},
							dataType: "json",
							success: (resp) => {
								if(resp.code == '10000') {
									//显示通知
									lightyear.notify('删除成功', 'success', 1000, 'mdi mdi-emoticon-happy', 'top', 'center');
									//刷新表格
									findByPage(currentPage);
								} else {
									lightyear.notify(resp.msg, 'danger', 1000, 'mdi mdi-emoticon-sad', 'top', 'center');
								}
							}
						})
					}
				},
				cancel: {
					text: '取消',
				}
			}
		});
	}
	
	//添加
	function add() {
		lightyear.loading('show');
		$.ajax({
			type: "POST",
			url: "admin/employee?action=add",
			data: {ename:$("#enameAdd").val(),
				eage:$("#eageAdd").val(),
				egender:$("input[name='egenderAdd']:checked").val(),
				ejob:$("#ejobAdd").val(),
				eentrydate:$("#eentrydateAdd").val(),
				esalary:$("#esalaryAdd").val(),did:$("#didAdd").val()},
			dataType: "json",
			success: (resp) => {
				lightyear.loading('hide');
				if(resp.code == 10000) {
					//隐藏模态框
					$("#addModal").modal('hide');
					$("#addForm")[0].reset();
					lightyear.notify('添加成功', 'success', 1000, 'mdi mdi-emoticon-happy', 'top', 'center');
					//去最后一页
					findByPage(-1);
				}
			}
		});
	}
	
	//显示添加模态框
	function showAddModal() {
		//获取所有部门
		$.ajax({
			type: "GET",
			url: "admin/department?action=findAll",
			dataType: "json",
			success: (resp) => {
				let html = template('all_department', {data:resp.data});
				//将渲染完成的数据挂载在页面上
				$('#didAdd').html(html);
				$("#addModal").modal('show');
			}
		})
	}
	
	//分页查询
	function findByPage(currentPage) {
		$.ajax({
			type: "GET",
			url: "admin/employee?action=findByPage",
			data: {currentPage:currentPage,searchName:$("#searchName").val()},
			dataType: "json",
			success: (resp) => {
				//resp.data是返回的数据，将服务器返回的数据在模板中渲染
				let html = template('all_employee', {data:resp.data});
				//将渲染完成的数据挂载在页面上
				$('#employee_table').html(html);
			}
		});
	}
	
	$(function () {
		//展开左侧菜单，设置头部标题
		setLeftAndTop("a[href='admin/toEmployee']");
		//查询首页
		findByPage(1);
	});
</script>
</body>
</html>