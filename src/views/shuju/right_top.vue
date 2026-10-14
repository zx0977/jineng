<template>
<div>
	<div style="color: #fff;font-size: 18px; margin-left: 150px;">人数总览</div>
	<ul style="display: flex;">
		<li style="color: #00fdfa;" type="none">
			<div class="allnum" style="width: 140px; height: 140px;">
			<dv-digital-flop :config="zong" style="width:100%;height:100%;" />
			<p>学校总人数</p>
			</div>
			
		</li>
		<li style="color: #e3b337;" type="none">
			<div class="online" style="width: 140px; height: 140px;">
			<dv-digital-flop :config="shitang" style="width:100%;height:100%;" />
			<p>食堂人数</p>
			</div>
		</li>
	</ul>
</div>
</template>

<script>
export default {
name:'right_top',
data() {
  return {
	zong:{
		  number: [7849],
		  content: '{nt}人',
		  style:{
			fontSize:24,
			fill:'#00fdfa'
		  }
	},
	shitang:{
		  number: [5342],
		  content: '{nt}人',
		  style:{
			fontSize:24,
			fill:'#e3b337'
		  }
	},
  }
  }
  }
</script>

<style>
.allnum{
	width: 100%;
	height: 100%;
	margin: 40px auto 30px;
	margin-left: 30px;
	background-size: cover;
	background-position: center center;
	position: relative;
	position: absolute;
	background-size: cover;
	background-image:url("./img/rigft_top_lan.png");
}
.online{
	width: 100%;
	height: 100%;
	margin: 40px auto 30px;
	margin-left: 220px;
	background-size: cover;
	background-position: center center;
	position: relative;
	position: absolute;
	background-size: cover;
	background-image: url(./img/rigft_top_hong.png);
}
p{
	text-align: center;
	height: 16px;
	font-size: 16px;
	margin-top: 20px;
}
</style>
