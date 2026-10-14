import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'layoutone',
    component: () =>import('../components/LayoutOne.vue'),
	children:[
		{
			path:'/canteen',
			name:'canteen',
			component: () =>import('../views/CanteenManagement/CanteenManagement.vue'),
			children:[
				{
					path:'/fancai',
					name:'fancai',
					component: () =>import('../views/CanteenManagement/FanCai.vue'),
				},
				{
					path:'/renyuan',
					name:'renyuan',
					component: () =>import('../views/CanteenManagement/RenYuan.vue'),
				},
				{
					path:'/dingdan',
					name:'dingdan',
					component: () =>import('../views/CanteenManagement/DingDan.vue'),
				}
			]
		},{
			path:'/yonghu',
			name:'yonghu',
			component: () =>import('../views/YongHu.vue'),
		},{
			path:'/shouye',
			name:'shouye',
			component:()=>import('../views/ShouYe.vue')
  }
	]
  },
  {
  	path:'/loginone',
  	name:'loginone',
  	component: () =>import('../views/LoginOne.vue'),
  	meta:{title:'登录'}
  },{
	path:'/homeview',
	name:'homeview',
	component: () =>import('../views/HomeView.vue'),
  }
]

const router = new VueRouter({
  routes
})

// 登录判断
router.beforeEach((to,form,next)=>{
	if(to.name=='loginone'){
		next()
	}else{
		if(localStorage.getItem('token')){
			next()
		}else{
			next({
				name:'loginone'
			})
		}
	}
})

export default router
