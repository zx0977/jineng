<template>
  <!--  我是大屏-->
  <dv-full-screen-container style="background-color:black; width: 100%; height: 100%;">
	<!-- <dv-loading style="color:#fff;">Loading...</dv-loading> -->
	<dv-border-box-11 title="食堂可视化平台">
		<div style="width: 30%; height: 100%;">
			<dv-border-box-1 style="padding: 40px 0 0 10px; width: 100%; height: 30%;">
				<left_top ></left_top>
			</dv-border-box-1>
			<dv-border-box-1 style="padding: 10px 0 0 10px; width: 100%; height: 30%;">
				<left_center></left_center>
			</dv-border-box-1>
			<dv-border-box-1 style="padding: 10px 0 0 10px; width: 100%; height: 30%;">
				<left_bottom></left_bottom>
			</dv-border-box-1>
		</div>
		<div style="width: 44%; height:700px;padding-top: 100px;padd">
			<dv-border-box-1 style="height: 650px;">
				<fei_xian></fei_xian>
			</dv-border-box-1>
		</div>
		<div style="width: 25%;height:100%;">
			<dv-border-box-1 style="width: 100%; height: 30%; padding-top: 40px;">
				<right_top></right_top>
			</dv-border-box-1>
			<dv-border-box-1 style="width: 100%; height: 30%; padding-top: 10px;">
				<right_center></right_center>
			</dv-border-box-1>
			<dv-border-box-1 style="width: 100%; height: 30%; padding-top: 10px;">
				<right_bottom></right_bottom>
			</dv-border-box-1>
		</div>
	</dv-border-box-11>
  </dv-full-screen-container>
</template>

<script>
import left_top from './shuju/left_top.vue'
import left_center from './shuju/left_center.vue'
import left_bottom from './shuju/left_bottom.vue'
import fei_xian from './shuju/fei_xian.vue'
import right_top from './shuju/right_top.vue'
import right_center from './shuju/right_center.vue'
import right_bottom from './shuju/right_bottom.vue'
export default {
	components:{left_top,left_center,left_bottom,fei_xian,right_top,right_center,right_bottom},
	name: 'HomeView',
}
</script>

<style>
*{
	margin: 0;
	padding: 0;
}
.dv-border-box-11 .border-box-content{
	display: flex;
}
</style>
