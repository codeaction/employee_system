function setLeftAndTop(e) {
    //设置左侧菜单展开
    $(e).parent().prop('class', "active").parent().css("display", "block");
    //获取一级标题
    var $parent_level_text = $(e).parent().parent().siblings().text();
    //获取二级标题
    var $sub_level_text = $(e).text();
    //设置navbar-page-title
    if($parent_level_text == "") {
        $("span[class='navbar-page-title']").text($sub_level_text);
    } else {
        $("span[class='navbar-page-title']").text($parent_level_text + " - " + $sub_level_text);
    }
}