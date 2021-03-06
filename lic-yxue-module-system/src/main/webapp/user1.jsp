<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/9/23
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script>
    $(function () {
        // 初始化用户数据表格
        $('#user-tt').jqGrid({
            url: '/user/show',
            datatype: 'json',
            colNames: ['id', 'username', 'mobile','sign','headShow','status','regTime','score','wechat'],
            styleUI: 'Bootstrap',
            colModel: [
                {name: 'id', editable: false},
                {name: 'username', editable: true},
                {name: 'mobile', editable: true},
                {name: 'sign', editable: true},
                {
                    name: 'headImg',
                    edittype: "file",
                    editable: true,
                    index: 'name asc, invdate',
                    width: 100,
                    align: "center",
                    //参数：各子的值,操作,行对象
                    formatter: function (cellvalue, options, rowObject) {
                        return "<img src='${pagecontext.request.contextPath}/" + cellvalue + "' width='64px' height='64px'   >"
                        // return "<img src='/static/img/yx-icon.png' width='64px' height='64px'   >"
                    }
                },

                {name: 'status', editable: true},
                {name: 'regTime',editable: false},
                {name: 'score',editable: false},
                {name: 'wechat',editable: false}

            ],
            autowidth: true,
            mtype: 'get',
            pager: '#user-pager',
            rowList: [10, 20, 30],
            viewrecords: true,
            editurl: '/user/edit',
            cellurl: '',
            multiselect: true,
            height: '300px',
            rownumbers: true,
            page: 1,
        }).jqGrid('navGrid', '#user-pager', {
                edit: true,
                add: true,
                del: true,
                edittext: "修改",
                addtext: "添加",
                deltext: "删除"
            },
            {},  //修改之后的额外操作
            {
                closeAfterAdd: true,//关闭添加框
                afterSubmit: function (data) {  //添加成功之后执行的内容
                    //1.数据入库    文件数据不对   文件没有上传
                    //2.文件异步上传   添加成功之后  上传
                    //3.修改文件路径   （id,要的的字段内容）
                    //id=  data.responseText
                    $.ajaxFileUpload({
                        url: "/user/headUpload",
                        type: "post",
                        data: {"id": data.responseText},
                        fileElementId: "headImg", //文件选择框的id属性，即<input type="file">的id
                        success: function () {
                            //上传成功 所作的事情
                            //刷新页面
                            $("#userTable").trigger("reloadGrid");
                        }
                    });
                    return "hello";
                }
            },  //添加之后的额外操作
            {}   //删除之后的额外操作
        );
    });
</script>
<div class="panel panel-info">

    <div class="panel panel-heading">
        <h2>用户信息</h2>
    </div>

    用户
    <table id="user-tt"></table>
    <div id="user-pager"></div>

</div>


