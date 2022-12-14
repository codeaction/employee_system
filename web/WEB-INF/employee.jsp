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
										<div class="input-group-btn">
											<input type="hidden" name="search_field" id="search-field" value="title">
											<button class="btn btn-default dropdown-toggle" id="search-btn"
													data-toggle="dropdown" type="button" aria-haspopup="true"
													aria-expanded="false">
												标题 <span class="caret"></span>
											</button>
											<ul class="dropdown-menu">
												<li><a tabindex="-1" href="javascript:void(0)" data-field="title">标题</a>
												</li>
												<li><a tabindex="-1" href="javascript:void(0)"
													   data-field="cat_name">栏目</a></li>
											</ul>
										</div>
										<input type="text" class="form-control" value="" name="keyword"
											   placeholder="请输入名称">
									</div>
								</form>
								<div class="toolbar-btn-action">
									<button class="btn btn-primary btn-info btn-label btn-sm" onclick="showAddModals()">
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
								<input type="radio" name="egender" value="男" checked="checked"><span>男</span>
							</label>
							<label class="lyear-radio radio-inline radio-primary">
								<input type="radio" name="egender" value="女"><span>女</span>
							</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label" for="ejob">职务</label>
						<div class="col-md-9">
							<input class="form-control" type="text" id="ejob" placeholder="请输入职务">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label" for="eentrydate">入职日期</label>
						<div class="col-md-9">
							<input class="form-control js-datepicker m-b-10" type="text" id="eentrydate" name="example-datepicker" placeholder="请选择入职日期" value="" data-date-format="yyyy-mm-dd" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label" for="esalary">薪资</label>
						<div class="col-md-9">
							<input class="form-control" type="number" id="esalary" placeholder="请输入薪资">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label" for="did">所在部门</label>
						<div class="col-md-9">
							<select class="form-control" type="number" id="did">
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

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
<script src="js/func.js"></script>
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
					<button class="btn btn-xs btn-primary btn-success">修改</button>
					<button class="btn btn-xs btn-primary btn-danger">删除</button>
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
	//显示添加模态框
	function showAddModals() {
		//获取所有部门
		$.ajax({
			type: "GET",
			url: "admin/department?action=findAll",
			dataType: "json",
			success: (resp) => {
				let html = template('all_department', {data:resp.data});
				//将渲染完成的数据挂载在页面上
				$('#did').html(html);
				$("#addModal").modal('show');
			}
		})
		
	}
	
	//分页查询
	function findByPage(currentPage) {
		$.ajax({
			type: "GET",
			url: "admin/employee?action=findByPage",
			data: {currentPage:currentPage},
			dataType: "json",
			success: (resp) => {
				console.log(resp);
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