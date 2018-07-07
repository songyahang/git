<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
  
  <script type="text/javascript" src="js/jquery.validate.js"></script>
  <script type="text/javascript">
  	$(function(){
  		$("#for").validate({
  			rules:{
  				sname:{
  					required:true,
  					rangelength:[2,99],
  					remote:{
  						url:"stu?m=checkstu",
  						type:"post",
  						data:{
  							sname:function(){
  								return $("#sname").val();
  							}
  						}
  					}
  				},
  				sex:"required",
  				age:{
  					range:[18,99],
  					digits:true,
  				},
  				card:{
  					rangelength:[18,19],
  					digits:true,
  				}
  			},
  			messages:{
  				sname:{
  					required:"姓名不能为空",
  					rangelength:"长度为2到4",
  					remote:"学生已存在"
  				},
  				sex:"性别必须选择",
  				age:{
  					range:"年龄必须在18到99之间",
  					digits:"整数",
  				},
  				card:{
  					rangelength:"长度必须为18",
  					digits:"必须是整数",
  				}
  			},
  			submitHandler:function(form)
  			{
  				alert("验证成功");
  				$.ajax({
  					url:"stu?m=insert",
  					type:"post",
  					data:$("#for").serialize(),
  					success:function(msg){
  						if(msg>0){
  							alert("添加成功！");
  							location="stu?m=stulist";
  					}
  					},
  					dataType:"text"
  				});
  			}
  		});
  	});
  </script>
  <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script></head>
  
  <body>
    <form id="for">
    	用户名<input type="text" name="sname" id="sname"><br>
    	性别<input type="radio" value="男" name="sex">男
    	   <input type="radio" value="女" name="sex">女 
    	   <label for="sex" generated="true" class="error" style="color: red">
    	   
    	   </label><br>
    	年龄<input type="text" name="age"><br>
    	生日<input type="text" name="birthday" onclick="WdatePicker()" readonly="readonly"><br>
    	卡号<input type="text" name="card"><br>
    	<input type="submit" value="新增"><br>
    </form>
  </body>
</html>
