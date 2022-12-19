<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <base href="${pageContext.request.contextPath}/"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>项目管理</title>
    <link rel="icon" href="favicon.ico" type="image/ico">
    <meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
    <meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
    <meta name="author" content="yinqi">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/materialdesignicons.min.css" rel="stylesheet">
    <!--对话框-->
    <link rel="stylesheet" href="js/jconfirm/jquery-confirm.min.css">
    <link href="css/style.min.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="http://libs.itshubao.com/bootstrap-multiselect/bootstrap-multiselect.css" rel="stylesheet">
    <!--日期选择插件-->
    <link rel="stylesheet" href="js/bootstrap-datepicker/bootstrap-datepicker3.min.css">
    <!--滑块插件-->
    <link rel="stylesheet" href="js/ion-rangeslider/ion.rangeSlider.min.css">
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
                                    <button class="btn btn-primary btn-cyan btn-label btn-sm" onclick="showAddModal()">
                                        <label>
                                            <i class="mdi mdi-plus"></i>
                                        </label>
                                        新增
                                    </button>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="table-responsive" id="project_table">
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

<!-- 添加模态框 -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加部门</h4>
            </div>
            <div class="modal-body">
                <form id="addForm" class="form-horizontal" action="#" method="post" onsubmit="return false;">
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="pnameAdd">项目名称</label>
                        <div class="col-md-9">
                            <input class="form-control" type="text" id="pnameAdd" placeholder="请输入项目名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="pstartAdd">开始时间</label>
                        <div class="col-md-9">
                            <input class="form-control js-datepicker m-b-10" type="text" id="pstartAdd" name="example-datepicker" placeholder="请输入开始时间" data-date-format="yyyy年mm月dd日" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="pendAdd">结束时间</label>
                        <div class="col-md-9">
                            <input class="form-control js-datepicker m-b-10" type="text" id="pendAdd" name="example-datepicker" placeholder="请输入结束时间" data-date-format="yyyy年mm月dd日" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="pprogressAdd">项目进度</label>
                        <div class="col-md-9">
                            <input id="pprogressAdd">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="pdescriptionAdd">项目描述</label>
                        <div class="col-md-9">
                            <input class="form-control" type="text" id="pdescriptionAdd" placeholder="请输入项目描述">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">参与人员</label>
                        <div class="col-md-9">
                            <select id="all_employee_add" multiple="multiple">
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
                <h4 class="modal-title">修改部门</h4>
            </div>
            <div class="modal-body">
                <form id="updateForm" class="form-horizontal" action="#" method="post" onsubmit="return false;">
                    <input type="hidden" id="didUpdate" />
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="dnameUpdate">部门名称</label>
                        <div class="col-md-9">
                            <input class="form-control" type="text" id="dnameUpdate" placeholder="请输入部门名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="dlocationUpdate">部门位置</label>
                        <div class="col-md-9">
                            <input class="form-control" type="text" id="dlocationUpdate" placeholder="请输入部门位置">
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
<script type="text/javascript" src="js/func.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/template-web.js"></script>
<!--消息提示-->
<script src="js/bootstrap-notify.min.js"></script>
<script type="text/javascript" src="js/lightyear.js"></script>
<!--对话框-->
<script src="js/jconfirm/jquery-confirm.min.js"></script>
<script type="text/javascript" src="http://libs.itshubao.com/bootstrap-multiselect/bootstrap-multiselect.min.js"></script>
<!--日期选择插件-->
<script src="js/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<script src="js/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>
<!--滑块插件-->
<script src="js/ion-rangeslider/ion.rangeSlider.min.js"></script>
<script type="text/html" id="all_project">
    <table class="table table-bordered table-hover">
        <thead>
            <tr>
                <th style="width: 50px;">ID</th>
                <th>项目名称</th>
                <th style="width: 150px;">开始时间</th>
                <th style="width: 150px;">结束时间</th>
                <th>进度</th>
                <th>涉及员工</th>
                <th>项目描述</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            {{each data}}
            <tr>
                <td>{{$value.pid}}</td>
                <td>{{$value.pname}}</td>
                <td>{{$value.pstart}}</td>
                <td>{{$value.pend}}</td>
                <td title="{{$value.pprogress}}">
                    <div class="progress progress-lg">
                        <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" style="width: {{$value.pprogress}}%;" aria-valuenow="{{$value.pprogress}}" aria-valuemin="0" aria-valuemax="100">
                            {{$value.pprogress}}%
                        </div>
                    </div>
                </td>
                <td>
                    {{each $value.emps}}
                        <span class="label label-info">{{$value.ename}}</span>
                    {{/each}}
                </td>
                <td>{{$value.pdescription}}</td>
                <td style="width: 110px;">
                    <button class="btn btn-xs btn-primary btn-success">修改</button>
                    <button class="btn btn-xs btn-primary btn-danger">删除</button>
                </td>
            </tr>
            {{/each}}
        </tbody>
    </table>
</script>
<script type="text/html" id="all_deptwithemps">
    {{each data}}
        <optgroup label="{{$value.dname}}">
            {{each $value.emps}}
                <option value="{{$value.eid}}">{{$value.ename}}</option>
            {{/each}}
        </optgroup>
    {{/each}}
</script>
<script type="text/javascript">
    function tests() {
        console.log($("#tests").val());
    }
    //添加
    function add() {
        console.log($("#all_employee_add").val());
        lightyear.loading('show');
        $.ajax({
            type: "POST",
            url: "admin/project?action=add",
            data: {pname:$("#pnameAdd").val(),
                pstart:$("#pstartAdd").val(),
                pend:$("#pendAdd").val(),
                pprogress:$("#pprogressAdd").val(),
                pdescription:$("#pdescriptionAdd").val(),
                eids:$("#all_employee_add").val()
            },
            dataType: "json",
            success: (resp) => {
                lightyear.loading('hide');
                if(resp.code == 10000) {
                    //隐藏模态框
                    $("#addModal").modal('hide');
                    //重置表单
                    $("#addForm")[0].reset();
                    //弹出提示信息
                    lightyear.notify('添加成功', 'success', 1000, 'mdi mdi-emoticon-happy', 'top', 'center');
                    //查询所有
                    findAll();
                }
            }
        });
    }
    //显示新增模态框
    function showAddModal() {
        $.ajax({
            type: "GET",
            url: "admin/department?action=findAllWithEmployee",
            dataType: "json",
            success: (resp) => {
                //将返回的数据渲染成html
                let html = template('all_deptwithemps', {data:resp.data});
                //将渲染完成的数据挂载在页面上
                $('#all_employee_add').html(html);
                //设置select为多选 - 折叠的
                $('#all_employee_add').multiselect({
                    enableCollapsibleOptGroups: true,
                    collapseOptGroupsByDefault: true,
                });
                
                //设置滑块
                $("#pprogressAdd").ionRangeSlider({
                    min: 0,
                    max: 100,
                    from: 0
                });
                
                //显示模态框
                $("#addModal").modal('show')
            }
        })
        
    }
    
    //查询所有项目
    function findAll() {
        $.ajax({
            type: "GET",
            url: "admin/project?action=findAll",
            dataType: "json",
            success: (resp) => {
                // console.log(resp);
                //resp.data是返回的数据，将服务器返回的数据在模板中渲染
                let html = template('all_project', {data:resp.data});
                //将渲染完成的数据挂载在页面上
                $('#project_table').html(html);
            }
        })
    }

    $(function () {
        //展开左侧菜单，设置头部标题
        setLeftAndTop("a[href='admin/toProject']");
        //查询所有部门
        findAll();
    });
</script>
</body>
</html>