<template>
	<el-container class="layout">
		<!--左侧-->
	  <el-aside :width="$store.state.isCollapse?'64px':'230px'">
		<MenusOne></MenusOne>
	  </el-aside>
	  <!--右侧-->
	  <el-container>
		  <!--头部-->
		<el-header class="rightHeader">
			<HeaderOne></HeaderOne>
		</el-header>
		<!--底部-->
		<el-main>
		<!-- 展示子路由 -->
		<router-view></router-view>
		</el-main>
	  </el-container>
	</el-container> 
</template>

<script>
import MenusOne from './MenusOne.vue'
import HeaderOne from './HeaderOne.vue'
export default{
	components:{MenusOne,HeaderOne},
	name:'LayoutOne'
}
</script>

<style>
.layout{
	height: 100%;
}
.rightHeader{
	padding: 0 10px !important;
	display: flex;
	align-items: center;
	box-shadow: 0px 3px 4px 1px rgba(0,0,0,.2);
}
</style>
