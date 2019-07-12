<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>后台欢迎页</title>
	<link rel="stylesheet" href="../css/reset.css" />
	<link rel="stylesheet" href="../css/content.css" />
</head>
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-nav">您当前的位置：<a href="">系统管理</a>><a href="">分类管理</a></div>
		<div class="public-content">

			<div class="public-content-cont two-col">



				<table class="public-cont-table">
					<tr>
						<th style="width:10%">分类名称</th>
						<th style="width:10%">分类图片</th>
						<th style="width:10%">商品数量</th>
						<th style="width:10%">创建时间</th>
						<th style="width:10%">新栏目</th>
						<th style="width:20%">操作</th>
					</tr>
				    <!--foreach-->
                    <#if category??>
					<#list category as c>
					<tr>
						<td>${c.name}</td>
						<td><img class="icon" width="30" src="${c.picture}" /></td>
                        <td>${c.quantiy}</td>
						<td><span style="color:#6bc095">${c.createTime?string("yyyy-MM-dd HH:mm:ss")}</span></td>
						<td><span style="color:#6bc095">显示</span></td>
						<td>
							<div class="table-fun">
								<a href="">编辑</a>
								<a href="/product/category/delete/${c.id}">删除</a>
							</div>
						</td>
					</tr>
					</#list>
				</#if>
				</table>

			</div>
		</div>
	</div>
</body>
</html>