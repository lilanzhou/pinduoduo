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
		<div class="public-nav">您当前的位置：<a href="">管理首页</a>><a href="">商品列表</a></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3 style="display: inline-block;">商品列表</h3>
				<div class="public-content-right fr">
					<a href="" style="height: 24px; width: 60px;border: 1px solid #ccc;font-size: 12px;text-align:center">添加信息</a>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="public-content-cont two-col">

				<table class="public-cont-table col-2">
					<tr>
						<th style="width:5%">选择</th>
						<th style="width:25%">商品</th>
						<th style="width:5%">分类</th>
						<th style="width:5%">价格</th>
						<th style="width:5%">库存</th>
						<th style="width:5%">总销量</th>
						<th style="width:10%">发布时间</th>
						<th style="width:15%">操作</th>
					</tr>
					<#if products??>
				<#list products as prod>
					<tr>

						<td><input type="checkbox" /></td>
						<td><img class="state-img"style="width: 60px;height: 60px" src="${prod.product.images}" />${prod.product.name}<br><span>ID:${prod.product.prodId}</span></td>
						<td><span style="color:#999">${prod.category}</span></td>
						<td><span style="color:#6bc095">￥${prod.product.price}</span></td>
						<td><span style="color:#999">${prod.product.inventory}</span></td>
                        <td><span style="color:#999">${prod.product.totalSales}</span></td>
						<td><span style="color:#999">${prod.product.releaseTime?string("yyyy-MM-dd HH:mm:ss")}</span></td>
						<td>
							<div class="table-fun">
								<a href="/">修改</a>
								<a href="/product/delete/${prod.product.prodId}">删除</a>
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