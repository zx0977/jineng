<template>
	<div class="app-container home">
		<el-row type="flex" justify="center" :gutter="10">
		  <el-col :span="24">
		    <el-card>
		      <div slot="header">
		        <span>能耗总览</span>
		      </div>
		      <div>
		        <el-row type="flex" justify="center" :gutter="10">
		          <el-col>
		            <el-card class="today">
		              <div class="font-title">
		                <span>今日总能耗</span>
		              </div>
		              <div class="font-content">
		                12315.00KG
		              </div>
		            </el-card>
		          </el-col>
		          <el-col>
		            <el-card class="month">
		              <div class="font-title">
		                <span>本月总能耗</span>
		              </div>
		              <div class="font-content">
		                16545.00KG
		              </div>
		            </el-card>
		          </el-col>
		          <el-col>
		            <el-card class="year">
		              <div class="font-title">
		                <span>本年总能耗</span>
		              </div>
		              <div class="font-content">
		                546.00KG
		              </div>
		            </el-card>
		          </el-col>
		          <el-col>
		            <el-card class="year-save">
		              <div class="font-title">
		                <span>本年总减排</span>
		              </div>
		              <div class="font-content">
		                45646.00KG
		              </div>
		            </el-card>
		          </el-col>
		        </el-row>
		      </div>
		    </el-card>
		  </el-col>
		</el-row>
		<el-row>
			<el-col :span="12">
			  <el-card>
			    <div slot="header" >
			      <span>能耗占比</span>
			    </div>
			    <div>
			      <dv-active-ring-chart :config="config" style="width:300px;height:300px;color: #000; margin-left: 120px;" />
			    </div>
			  </el-card>
			</el-col>
			<el-col :span="12">
			  <el-card>
			    <div slot="header">
			      <span>设备耗能排行</span>
			    </div>
			    <div>
			      <dv-scroll-ranking-board :config="config1" style="width:500px;height:300px;color: #000000; margin-left: 30px;" />
			    </div>
			  </el-card>
			</el-col>
		</el-row>
	</div>
</template>

<script>
	export default{
		name:'ShouYe',
		data(){
			return{
				config:{
					radius: '0%',
					activeRadius: '10%',
					lineWidth:250,
					  data: [
					    {
					      name: '生产耗电量',
					      value: 55
					    },
					    {
					      name: '生产耗水量',
					      value: 120
					    },
					    {
					      name: '人员耗电量',
					      value: 78
					    },
					    {
					      name: '人员耗水量',
					      value: 66
					    },
					  ],
					  digitalFlopStyle: {
					    fontSize: 20,
						fill: '#000'
					  },
				},
				config1:{
					data: [
					    {
					      name: '保温柜',
					      value: 55
					    },
					    {
					      name: '空调',
					      value: 120
					    },
					    {
					      name: '电烤锅',
					      value: 78
					    },
					    {
					      name: '煮饭设备',
					      value: 66
					    },
					    {
					      name: '自动刷碗机',
					      value: 80
					    },
					    {
					      name: '灯',
					      value: 29
					    }
					  ]
				}
			}
		}
	}
</script>

<style>
	.home {
	  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
	  font-size: 13px;
	  color: #676a6c;
	  overflow-x: hidden;
	}
	.font-content {
	  font-size: 18px;
	}
	.font-title {
	  font-size: 20px;
	  padding-bottom: 20px;
	}
	.today {
	  background-color: #60cfeb;
	  color: aliceblue;
	}
	.month {
	  background-color: #f7b018;
	  color: aliceblue;
	}
	.year {
	  background-color: #fb846c;
	  color: aliceblue;
	}
	.year-save {
	  background-color: #28b976;
	  color: aliceblue;
	}
</style>
