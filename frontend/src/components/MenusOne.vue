<template>
<el-menu
	  :collapse="$store.state.isCollapse"
	  :default-active="$route.path" 
	  :router="true"
	  class="el-menu-vertical"
	  background-color="#545c64"
	  text-color="#fff"
	  active-text-color="#ffd04b">
	  <el-menu-item index="/shouye">
	  		<i class="el-icon-s-home"></i>
	  		<span slot="title">数据中心</span>
	  </el-menu-item>
	  <el-menu-item index="/homeview">
	  		<i class="el-icon-place"></i>
	  		<span slot="title">数据可视化</span>
	  </el-menu-item>
	  <el-submenu index="/canteen">
		<template slot="title">
		  <i class="el-icon-knife-fork"></i>
		  <span>食堂管理</span>
		</template>
		  <el-menu-item index="/fancai">
		  		<i class="el-icon-burger"></i>
		  		<span slot="title">饭菜管理</span>
		  </el-menu-item>
		  <el-menu-item index="/renyuan">
		  		<i class="el-icon-user"></i>
		  		<span slot="title">餐厅人员管理</span>
		  </el-menu-item>
		  <el-menu-item index="/dingdan">
		  		<i class="el-icon-s-order"></i>
		  		<span slot="title">订单管理</span>
		  </el-menu-item>
		</el-submenu>
	  <el-menu-item index="/yonghu">
	  		<i class="el-icon-user-solid"></i>
	  		<span slot="title">用户管理</span>
	  </el-menu-item>
	</el-menu>
</template>

<script>
	export default{
		name:'MenusOne',
		// 生命周期函数
		mounted() {
			// console.log(this.$route.path);
		}
	}
</script>

<style>
	.el-menu-vertical{
		height: 100%;
	}
</style>
