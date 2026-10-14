<template>
	<dv-charts :option="option" />
</template>

<script>
	export default {
	name:'right_bottom',
	data() {
	  return {
		option:{
			  title: {
			    text: '食堂能源消耗表',
			    style: {
			    fill: '#fff'
			    }
			  },
			  series: [
			    {
			      type: 'gauge',
			      data: [ { name: 'itemA', value: 60 } ],
			      center: ['50%', '55%'],
			      axisLabel: {
			        formatter: '{value}%',
			        style: {
			          fill: '#fff'
			        }
			      },
			      axisTick: {
			        style: {
			          stroke: '#fff'
			        }
			      },
			      animationCurve: 'easeInOutBack'
			    }
			  ]
		}
	  }
	  }
	  }
</script>

<style>
</style>
