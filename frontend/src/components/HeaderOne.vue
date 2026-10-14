<template>
	<div class="header">
		<div ><!--左侧-->
		<i :class="$store.state.isCollapse?'el-icon-s-unfold':'el-icon-s-fold'"
		@click="changeTab"></i>&nbsp;&nbsp;&nbsp;
			<el-breadcrumb class="breadcrumbs" separator="/">
			  <el-breadcrumb-item :to="{ path: '/shouye' }">首页</el-breadcrumb-item>
			  <el-breadcrumb-item><a href="/">活动管理</a></el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<div><!--右侧-->
			<el-dropdown trigger="click">
			  <span class="el-dropdown-link">
			    <el-avatar shape="square" size="medium" src="https://fuss10.
				elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"></el-avatar>
				<i class="el-icon-arrow-down el-icon--right"></i>
			  </span>
			  <el-dropdown-menu slot="dropdown">
			    <el-dropdown-item>个人中心</el-dropdown-item>
			    <el-dropdown-item>退出登录</el-dropdown-item>
			  </el-dropdown-menu>
			</el-dropdown>
		</div>
	</div>
</template>

<script>
export default{
	name:'HeaderOne',
	data(){
		return{
			isTab: false
		}
	},
	methods:{
		changeTab(){
			// this.isTab=!this.isTab
			this.$store.commit('changeCollapse')
		}
	}
}
	
</script>

<style>
.header{
	display: flex;
	justify-content: space-between;
	width: 100%;
}
.header>div:first-child{
	display: flex;
	align-items: center;
}
.el-icon-s-fold{
	font-size: 23px;
}
.el-icon-s-unfold{
	font-size: 23px;
}
</style>
