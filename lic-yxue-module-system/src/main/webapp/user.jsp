<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2020/9/23
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function () {
        // 初始化用户数据表格
        $('#user-tt').jqGrid({
            url: '/user/show',
            datatype: 'json',
            colNames: ['id', '用户名', '手机号','签名','头像','状态','注册时间','分数'],
            styleUI: 'Bootstrap',
            colModel: [
                {name: 'id'},
                {name: 'username', editable: true},
                {name: 'mobile', editable: true},
                {name: 'sign', editable: true},
                {
                    name: 'headShow',
                    edittype: "file",
                    editable: true,
                    index: 'name asc, invdate',
                    width: 100,
                    align: "center",
                    //参数：各子的值,操作,行对象
                    formatter: function (cellvalue, options, rowObject) {
                        return "<img src='/static/yxue/upload/" + cellvalue + "' width='64px' height='64px'   >"
                    }
                },
                {name: 'status', editable: true,edittype:'select',editoptions:{value:"1:冻结;2:正常"},
                    //参数：各子的值,操作,行对象
                    formatter: function (cellvalue, options, rowObject) {
                    if(cellvalue=="1"){
                        return "<a onclick='ck(\""+cellvalue+"\",\""+rowObject.id+"\")'class='btn btn-success'>正常</a>"
                    }else{
                        return "<a onclick='ck(\""+cellvalue+"\",\""+rowObject.id+"\")'class='btn btn-danger'>冻结</a>"
                    }

                    }
                },
                {name: 'regTime',editable:true,edittype: 'date'},
                {name: 'score', editable: true},

            ],
            autowidth: true,
            mtype: 'get',
            pager: '#user-pager',
            viewrecords: true, // 是否显示信息总条数
            rowList: [5, 10, 30],
            rowNum:5,
            viewrecords: true,
            editurl: '/user/edit',
            cellurl: '',
            multiselect: true,
            height: '400px',
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
              //修改之后的额外操作
            { closeAfterEdit: true },
            {
                editData:{id:''},
                closeAfterAdd: true,//关闭添加框

                afterSubmit: function (data) {  //添加成功之后执行的内容
                    //1.数据入库    文件数据不对   文件没有上传
                    //2.文件异步上传   添加成功之后  上传
                    //3.修改文件路径   （id,要的的字段内容）
                    console.log(data);

                    let id=  data.responseJSON.rows.id;
                    alert(id);
                    $.ajaxFileUpload({
                        url: '${pageContext.request.contextPath}/user/headUpload',
                        type: "post",
                        data: {"id": id},
                        fileElementId: "headShow", //文件选择框的id属性，即<input type="file">的id
                        success: function () {
                            //上传成功 所作的事情
                            //刷新页面
                            $("#user_tt").trigger("reloadGrid");
                        }
                    });
                    return ["hello"];
                }
            },  //添加之后的额外操作
            {}   //删除之后的额外操作
        );
    });
    function ck(status,id){
        if(status=="1"){
            $.ajax({
                url:'/user/edit',
                data:{"id":id,"status":"2","oper":"edit"},
                success:function(data){
                    $("#user_tt").trigger("reloadGrid");
                },
                type:'POST'
            })
        }else{
            $.ajax({
                url:'/user/edit',
                data:{"id":id,"status":"1","oper":"edit"},
                success:function(data){
                    $("#user_tt").trigger("reloadGrid");
                },
                type:'POST'
            })
        }
    }
</script>
<div class="panel panel-info">

    <div class="panel panel-heading">
        <h2>用户信息</h2>
    </div>

    用户
    <table id="user-tt"></table>
    <div id="user-pager"></div>

</div>



