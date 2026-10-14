<template>
	<div >
		<div style="color: #fff;text-align: center; font-size: 18px;padding-left: 30px;">食堂米面分布图</div>
		<div style="padding-left: 40px; display: flex;">
		<div>
		<dv-active-ring-chart :config="mi" style="width:200px;height:200px" />
		<div style="color: #fff; padding-left: 90px; font-size: 18px;">米</div>
		</div>
		<div>
		<dv-active-ring-chart :config="mian" style="width:200px;height:200px" />
		<div style="color: #fff; padding-left: 90px;font-size: 18px;">面</div>
		</div>
		</div>
	</div>
</template>

<script>
export default {
name:'left_top',
data() {
  return {
	mi:{
	  radius: '60%',
	  activeRadius: '70%',
	  data: [
		{
		  name: '梅香苑',
		  value: 4
		},
		{
		  name: '兰馨苑',
		  value: 5
		},
		{
		  name: '竹清苑',
		  value: 8
		},
		{
		  name: '菊南苑',
		  value: 10
		},
	  ],
	  digitalFlopStyle: {
		fontSize: 25
	  }
	},
	mian:{
	  radius: '60%',
	  activeRadius: '70%',
	  data: [
		{
		  name: '梅香苑',
		  value: 8
		},
		{
		  name: '兰馨苑',
		  value: 10
		},
		{
		  name: '竹清苑',
		  value: 7
		},
		{
		  name: '菊南苑',
		  value: 8
		},
	  ],
	  digitalFlopStyle: {
		fontSize: 25
	  }
	}
  }
  }
}
</script>

<style>
</style>
