<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="UTF-8">
<body>
<h2>用户余额管理</h2>
<p>选择好各种选项然后提交</p>
<div style="margin:20px 0;"></div>
<%--<div class="easyui-panel" title="New Topic" style="width:400px">--%>
<div style="padding:10px 60px 20px 60px">
    <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
        <table cellpadding="5">
            <tr>
                <td>环境:</td>
                <td>
                    <select class="easyui-combobox" name="environment" id="environment">
                        <option value="mojie" id="mojie">摩羯</option>
                        <option value="shuangzi">双子</option>
                        <option value="shuangyu">双鱼</option>
                        <option value="baiyang">白羊</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>操作类型:</td>
                <td>
                    <select class="easyui-combobox" name="operationType" id="operationType">
                        <option value="addBanance" id="addBanance">余额充值</option>
                        <%--<option value="clear">清除账号缓存</option>--%>
                        <%--<option value="makeWxOldThrid">制造微信老三方</option>--%>
                        <%--<option value="makeQqOldThrid">制造qq老三方</option>--%>
                        <%--<option value="clearLevelPointCache">清除用户等级缓存</option>--%>
                    </select>
                </td>
            </tr>
            <tr>
                <td>用户id:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="condition" id="customerId" data-options="required:true"></input>
                </td>
            </tr>
            <tr>
                <td>充值余额</td>
                <td>
                    <input class="easyui-textbox" type="text" name="condition" id="levelId" data-options="required:true"></input>
                </td>
            </tr>
        </table>
    </form>
    <div style="text-align:center;padding:5px;width: 300px;">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清除</a>
    </div>
</div>
<%--</div>--%>
<script>
    function submitForm() {
        $('#ff').form('submit', {
            url: ctx + "/customer/customerManager.do",
            onSubmit: function () {
                return $(this).form('enableValidation').form('validate');
            },
            success: function (data) {
                var result = JSON.parse(data);
                console.info(result);
                if (result.success == 1) {
                    var msg = result.data + "";
                    topCenter(msg, "操作成功");
                } else {
                    var errMsg = result.error.message;
                    topCenter(errMsg, '操作失败');
                }

            }
        });
    }
    function clearForm() {
        $('#ff').form('reset')
    }
    function topCenter(message, title) {
        $.messager.show({
            title: title,
            msg: message,
            showType: 'slide',
            style: {
                right: '',
                top: document.body.scrollTop + document.documentElement.scrollTop,
                bottom: ''
            }
        });
    }
</script>
</body>
</html>