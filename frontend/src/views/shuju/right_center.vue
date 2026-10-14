<template>
	<div>
		<div style="color: #fff;font-size: 18px; margin-left: 150px;">饭菜剩余量</div>
		<dv-percent-pond :config="config" style="width:300px;height:180px; margin: 20px 0 0 40px;" />
	</div>
</template>

<script>
export default {
name:'right_center',
data() {
  return {
	  config:{
			value: 66,
		    localGradient: true
		  }
	  }
  }
  }
</script>

<style>
</style>
