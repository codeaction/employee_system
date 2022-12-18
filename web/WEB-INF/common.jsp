<%--
  Created by IntelliJ IDEA.
  User: Maxwell
  Date: 2022/10/16
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--左侧导航-->
<aside class="lyear-layout-sidebar">

    <!-- logo -->
    <div id="logo" class="sidebar-header">
        <a href="index.html"><img src="images/logo-sidebar.png" title="LightYear" alt="LightYear"/></a>
    </div>
    <div class="lyear-layout-sidebar-scroll">

        <nav class="sidebar-main">
            <ul class="nav nav-drawer">
                <li class="nav-item"><a href="admin/toIndex"><i class="mdi mdi-home"></i> 后台首页</a></li>
                <li class="nav-item nav-item-has-subnav active">
                    <a href="javascript:void(0)"><i class="mdi mdi-account-multiple"></i>员工管理</a>
                    <ul class="nav nav-subnav">
                        <li><a href="admin/toEmployee">人员管理</a></li>
                        <li><a href="admin/toDepartment">部门管理</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div class="sidebar-footer">
            <p class="copyright">Copyright © 2022 <a href="https://guide.code2048.tech">Code2048</a>. All right reserved</p>
        </div>
    </div>

</aside>
<!--End 左侧导航-->

<!--头部信息-->
<header class="lyear-layout-header">

    <nav class="navbar navbar-default">
        <div class="topbar">

            <div class="topbar-left">
                <div class="lyear-aside-toggler">
                    <span class="lyear-toggler-bar"></span>
                    <span class="lyear-toggler-bar"></span>
                    <span class="lyear-toggler-bar"></span>
                </div>
                <span class="navbar-page-title"> UI元素 - 表格 </span>
            </div>

            <ul class="topbar-right">
                <li class="dropdown dropdown-profile">
                    <a href="javascript:void(0)" data-toggle="dropdown">
                        <span>${sessionScope.admin.username} <span class="caret"></span></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <li> <a href="javascript:void(0)" onclick="showchgPwdModal()"><i class="mdi mdi-lock-outline"></i> 修改密码</a> </li>
                        <li class="divider"></li>
                        <li><a href="logout"><i class="mdi mdi-logout-variant"></i> 退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>
<!--End 头部信息-->
<!-- 修改密码模态框 -->
<div class="modal fade" id="chgPwdModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改密码</h4>
            </div>
            <div class="modal-body">
                <form id="addForm" class="form-horizontal" action="#" method="post" onsubmit="return false;">
                    <input type="hidden" id="id" value="${sessionScope.admin.id}" />
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="pwd">新密码</label>
                        <div class="col-md-9">
                            <input class="form-control" type="password" id="pwd" placeholder="请输入新密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="pwd2">重复新密码</label>
                        <div class="col-md-9">
                            <input class="form-control" type="password" id="pwd2" placeholder="请输入重复新密码">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary btn-info btn-sm" onclick="chgPwd()">修改</button>
            </div>
        </div>
    </div>
</div>
<!-- 修改密码模态框 -->

<script>
    function chgPwd() {
        lightyear.loading('show');
        //获取新密码
        var pwd = $("#pwd").val();
        var pwd2 = $("#pwd2").val();
        
        var reg = /^\w{6,10}$/;
        if(!reg.test(pwd)) {
            lightyear.notify("密码为6~10位字母、数字、_", 'danger', 1000, 'mdi mdi-emoticon-sad', 'top', 'center');
            return;
        }
        
        if(pwd != pwd2) {
            lightyear.notify("两次密码不相同", 'danger', 1000, 'mdi mdi-emoticon-sad', 'top', 'center');
            return;
        }
    
        $.ajax({
            url: "admin/chgpwd",
            type: "POST",
            data: {id:$("#id").val(),pwd:$("#pwd").val()},
            dataType: "json",
            success: function (resp) {
                if(resp.code == 10000) {
                    lightyear.loading('hide');
                    lightyear.notify('密码修改成功', 'success', 100, 'mdi mdi-emoticon-happy', 'top', 'center' , 'admin/toIndex');
                }
            }
        })
    }
    
    function showchgPwdModal() {
        $("#chgPwdModal").modal('show');
    }
</script>