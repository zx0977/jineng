<template>
<div>
	<div style="color: #fff;text-align: center; font-size: 18px;">食堂人数统计</div>
	<dv-capsule-chart :config="config" style="width:450px;height:230px;padding-left: 40px;" />
</div>
</template>

<script>
	export default {
	name:'left_top',
	data() {
	  return {
		  config:{
			data: [
			    {
			      name: '梅香苑',
			      value: 586
			    },
			    {
			      name: '兰馨苑',
			      value: 786
			    },
			    {
			      name: '竹青苑',
			      value: 966
			    },
			    {
			      name: '菊南苑',
			      value: 875
			    },
			  ],
			  colors: ['#e062ae', '#fb7293', '#32c5e9', '#96bfff'],
			  unit: '人数',
			  showValue: true
		  }
	  };
	}
	}
</script>

<style>
</style>
