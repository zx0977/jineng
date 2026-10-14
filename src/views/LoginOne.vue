<template>
	<div class="login">
		<div>
		<h3>炫的食堂管理系统</h3>
		<el-form :model="ruleForm" status-icon :rules="rules" 
		ref="ruleForm" label-width="100px" class="demo-ruleForm">
		  <el-form-item label="用户名" prop="username">
			<el-input type="username" v-model="ruleForm.username" 
			autocomplete="off"></el-input>
		  </el-form-item>
		  <el-form-item label="密码" prop="password">
			<el-input type="password" v-model="ruleForm.password" 
			autocomplete="off"></el-input>
		  </el-form-item>
		  <el-form-item class="abc">
			<el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
			<el-button @click="resetForm('ruleForm')">注册</el-button>
		  </el-form-item>
		</el-form>
	</div>
	</div>
</template>

<script>
export default{
	name:'LoginOne',
	data(){
		return{
			ruleForm:{
				username:'',
				password:''
			},
			rules:{
				username: [
					{required:true,message:"用户名不能为空!",trigger:'blur'}
				],
				password: [
					{required:true,message:"密码不能为空!", trigger: 'blur' },
					{min:6,max:16,message:"密码长度不符合要求!",trigger:'blur'}
				],
			}
		}
	},
	 methods: {
	   submitForm(formName) {
		   // this.$refs = {ruleForm: el-form}
	     this.$refs[formName].validate(async (valid) => {
	       if (valid) {
	        // alert('submit!');
	        // http://43.143.190.87:8091/panghudaojiaBackend/login
	        /* let instance = axios.create({
	          timeout: 10,
	          // 设置当前ajax发起请求时请求头的配置
	          headers:{
	            //  告诉服务器发送数据的格式
	            "Content-Type": "application/x-www-form-urlencoded"
	          }
	        })
	        
	        // 发起网络请求
	        let res = await instance.post('http://www.panghu.com/login.php',`username=${this.ruleForm.username}&password=${this.ruleForm.password}`)
	        // console.log(this.ruleForm);
	        console.log(res)
	        // 对服务器返回的结构校验
	        if(res.data.code == 200){
	          // 成功
	          this.$message({
	            message: '登录成功！',
	            type: 'success',
	            duration: 1000
	          })
	        }else{
	          // 失败
	          this.$message({
	            message: '登录失败！',
	            type: 'error',
	            duration: 1000
	          })
	        } */
	        
	        // localStorage 浏览器的缓存，可以持久化保存某些数据
			localStorage.setItem('token', (new Date()).getTime())
			this.$message({
			  message: '登录成功！',
			  type: 'success',
			  duration: 1500, 
			  onClose: () => {
			    // 页面跳转
			    // this.$route 当前正在访问的路由信息 path compoenent name query
			    // this.$router 路由对象，控制页面跳转
			    this.$router.push('/shouye') // 编程（js）式跳转
			  }
			})
	       } else {
	         // console.log('error submit!!');
			 // 配置弹出提示
			 this.$message({
				 message:'登录失败!',
				 type:'error',
				 duration:1000
			 })
	         return false;
	       }
	     });
	   },
	   resetForm(formName) {
	     this.$refs[formName].resetFields();
	   }
	 }
}
</script>

<style>
	.login{
		width: 100%;
		height: 100%;
		background-image:url(../assets/aixin.webp);
		background-repeat: no-repeat;
		background-size: 100%;
	
		/* 弹性容器 */
		display: flex;
		/* 设置主轴上的对齐方式， center居中 */
		justify-content: center;
		/* 设置在交叉轴的对齐方式, center居中 */
		align-items: center;
		.login-ruleForm{
		  width: 600px;
		  /* bgc */
		  /* background-color: pink; */
		  .abc{
		    text-align: center;
		  }
		} 
	}
	h3{
		margin-left: 120px;
	}
</style>
