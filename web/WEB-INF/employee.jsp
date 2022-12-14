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
									<a class="btn btn-primary m-r-5" href="#!"><i class="mdi mdi-plus"></i> 新增</a>
									<a class="btn btn-success m-r-5" href="#!"><i class="mdi mdi-check"></i> 启用</a>
									<a class="btn btn-warning m-r-5" href="#!"><i class="mdi mdi-block-helper"></i>
										禁用</a>
									<a class="btn btn-danger" href="#!"><i class="mdi mdi-window-close"></i> 删除</a>
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

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
<script src="js/func.js"></script>
<!--对话框-->
<script src="js/jconfirm/jquery-confirm.min.js"></script>
<script src="js/template-web.js"></script>
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
<script type="text/javascript">
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