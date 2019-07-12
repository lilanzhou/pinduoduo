<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>后台欢迎页</title>
	<link rel="stylesheet" href="../css/reset.css" />
	<link rel="stylesheet" href="../css/public.css" />
	<link rel="stylesheet" href="../css/content.css" />
    <link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body marginwidth="0" marginheight="0">







	<div class="container">
		<div class="public-nav">发商品</div>
		<div class="public-content">
			<div class="public-content-header">
				<span>基本信息</span>
			</div>
			<div class="public-content-cont">




			<form action="/product/add" method="post" enctype="multipart/form-data">

                <div class="form-group">
                    <label for="">名称</label>
                    <input class="form-input-txt" type="text"id="productName" name="productName" value="" />
                </div>

				<div class="form-group">
					<label for="">请选择分类</label>
					<select name="category" id="category" class="form-select">
						<option value="家具类" >家具类</option>
                        <option value="衣服类" >衣服类</option>
						<option value="鞋类" >鞋类</option>
                        <option value="食物类" >食物类</option>
					</select>
				</div>
                <div class="form-group">
                    <label for="">分类图片</label>
                    <input type="file" name="picture">
				</div>
				<div class="form-group">
					<label for="">商品详情</label>
					<textarea id="editor_id" name="content"  class="form-input-textara" style="width:700px;height:300px;">
						商品详情描述
					</textarea> 
				</div>
                <div >
                <table >
                    <tr >
                        <td>图片</td>
                        <#--<td>时间</td>-->
                        <td>单价</td>
                        <td>发售总数</td>
                        <td>描述</td>

                    </tr>
                    <tr>
                        <td><input type="file" name="file"></td>
                        <#--<td><input  name="datetime" class="form-input-txt" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">-->
                        <#--</td>-->
                        <td><input name="price" placeholder="价格"></td>
                        <td><input name="totalSale" placeholder="发行总数"></td>
                        <td><input name="describe" placeholder="描述"></td>

                    </tr>
                </table>
                </div>
				<div class="form-group" style="margin-left:150px;">
					<input type="submit" class="sub-btn" value="提  交" />
					<input type="reset" class="sub-btn" value="重  置" />
				</div>
				</form>
			</div>
		</div>
	</div>

    <script src="../kingediter/kindeditor-all-min.js"></script>
    <script src="../js/laydate.js"></script>

<script>
	 KindEditor.ready(function(K) {
                window.editor = K.create('#editor_id');
        });
</script>


</body>
</html>