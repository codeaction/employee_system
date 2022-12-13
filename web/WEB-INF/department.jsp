<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <base href="${pageContext.request.contextPath}/"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>部门管理</title>
    <link rel="icon" href="favicon.ico" type="image/ico">
    <meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
    <meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
    <meta name="author" content="yinqi">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/materialdesignicons.min.css" rel="stylesheet">
    <link href="css/style.min.css" rel="stylesheet">
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
                                <div class="toolbar-btn-action">
                                    <button class="btn btn-primary btn-cyan btn-label btn-sm">
                                        <label>
                                            <i class="mdi mdi-plus"></i>
                                        </label>
                                        新增
                                    </button>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="table-responsive col-md-6" id="class_table">
                                        <!-- 此处放置表格 -->
                                    </div>
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
<script type="text/javascript" src="js/func.js"></script>
<script type="text/javascript" src="js/template-web.js"></script>
<script type="text/html" id="all_department">
    <table class="table table-bordered table-hover">
        <thead>
            <tr>
                <th>部门编号</th>
                <th>部门名称</th>
                <th>部门位置</th>
                <th colspan="2">操作</th>
            </tr>
        </thead>
        <tbody>
            {{each data}}
            <tr>
                <td style="width: 90px;">{{$value.did}}</td>
                <td>{{$value.dname}}</td>
                <td>{{$value.dlocation}}</td>
                <td style="width: 110px;">
                    <button class="btn btn-xs btn-primary btn-success">修改</button>
                    <button class="btn btn-xs btn-primary btn-danger">删除</button>
                </td>
            </tr>
            {{/each}}
        </tbody>
    </table>
</script>
<script type="text/javascript">
    function findAll() {
        $.ajax({
            type: "GET",
            url: "admin/Department?action=findAll",
            dataType: "json",
            success: function (resp) {
                // console.log(resp);
                //resp.data是返回的数据，将服务器返回的数据在模板中渲染
                let html = template('all_department', {data:resp.data});
                console.log(html);
                //将渲染完成的数据挂载在页面上
                $('#class_table').html(html);
            }
        })
    }

    $(function () {
        //展开左侧菜单，设置头部标题
        setLeftAndTop("a[href='admin/toDepartment']");
        //查询所有部门
        findAll();
    });
</script>
</body>
</html>