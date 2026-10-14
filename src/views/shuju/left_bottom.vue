<template>
	<div>
		<div style="color: #fff;text-align: center; font-size: 18px;">食堂好评榜</div>
		<dv-scroll-board :config="config" style="width:400px;height:220px;padding-left: 30px;" />
	</div>
</template>

<script>
export default {
name:'left_bottom',
data() {
  return {
	config:{
		header: ['菜名', '餐厅', '价格'],
		  data: [
		    ['烤鸭拌饭', '竹清苑', '13.50元'],
		    ['螺蛳粉', '竹清苑', '12.00元'],
		    ['招财鸡丁米线', '竹清苑', '11.00元'],
		    ['周黑鸭', '菊南苑', '12.00元'],
		    ['豆花鱼', '菊南苑', '12.00元'],
		    ['烤肉拌饭', '兰馨苑', '12.00元'],
		    ['大众套餐', '兰馨苑', '13.00元'],
		    ['东北木桶饭', '兰馨苑', '13.00元'],
		    ['猪脚饭', '菊南苑', '12.00元'],
		    ['花甲鸡丁面', '竹清苑', '12.00元'],
			['汉堡','竹清苑','10.00元'],
			['至尊咖喱饭','菊南苑','9.00元'],
		  ],
		  headerBGC:'#62c7c8',
		  oddRowBGC:'#4adfdf',
		  evenRowBGC:'#55aaff',
		  headerHeight:30,
		  index: true,
		  columnWidth: [45],
		  align: ['center']
	}
  }
  }
  }
</script>

<style>
</style>
