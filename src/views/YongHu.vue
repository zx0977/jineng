<template>
	<div class="home">
		<el-form :inline="true" :model="quarter" class="search">
		  <el-form-item label="用户名">
		  		<el-input v-model="quarter.name" placeholder="请输入用户名"></el-input>
		  </el-form-item>
		  <el-form-item label="位置">
		  		<el-input v-model="quarter.position" placeholder="请输入位置"></el-input>
		  </el-form-item>
		  <el-form-item>
			<el-button type="primary" @click="search(quarter.name,quarter.position)">搜索</el-button>
			<el-button type="primary" @click="chongzhi(quarter.name,quarter.position)">重置</el-button>
		  </el-form-item>
		</el-form>
	  <el-row>
	    <el-col :span="24">
	  	<el-button type="primary" plain @click="newlyAdded = true"><i class="el-icon-plus">新增</i></el-button>
	    </el-col>
		  <el-dialog
		    title="添加用户管理"
		    :visible.sync="newlyAdded"
		    width="30%"
		    :before-close="handleClose">
			<div style="display: flex; align-items: center; flex-wrap:wrap;">
				<el-form ref="elForm" :model="fromData" :rules="rules" size="medium" label-width="100px">
					<el-form-item label="用户名" prop="name">
						<el-input v-model="fromData.name" placeholder="请输入用户名" clerable :style="{width:'100%'}"></el-input>
					</el-form-item>
					<el-form-item label="联系电话" prop="phone">
						<el-input v-model="fromData.phone" placeholder="请输入联系电话" :maxlength="11" show-word-limit clerable :style="{width:'100%'}"></el-input>
					</el-form-item>
					<el-form-item label="寝室位置" prop="position">
						<el-input v-model="fromData.position" placeholder="请输入寝室位置" clerable :style="{width:'100%'}"></el-input>
					</el-form-item>
				</el-form>
			</div>
		    <span slot="footer" class="dialog-footer">
		      <el-button @click="newlyAdded = false">取 消</el-button>
		      <el-button type="primary" @click="addItem()">确 定</el-button>
		    </span>
		  </el-dialog>
		  <el-dialog
		    title="修改用户管理"
		    :visible.sync="modify"
		    width="30%"
		    :before-close="handleClose">
		  		<div style="display: flex; align-items: center; flex-wrap:wrap;">
		  			<div style="margin-bottom:10px ;">
		  				<span style="margin-left: 15px;">用&nbsp;户&nbsp;名</span>
		  				<el-input v-model="nameone" placeholder="请输入用户名" style="width: 300px; margin-left: 10px;"></el-input>
		  			</div>
		  			<div>
		  				<span style="margin-left: 15px;">联系电话</span>
		  				<el-input v-model="phonetwo" placeholder="请输入联系电话" style="width: 300px; margin-left: 10px;"></el-input>
		  			</div>
					<div>
						<span style="margin-left: 15px;">寝室位置</span>
						<el-input v-model="positionthree" placeholder="请输入寝室位置" style="width: 300px; margin-left: 10px;margin-top: 10px;"></el-input>
					</div>
		  		</div>
		    <span slot="footer" class="dialog-footer">
		      <el-button @click="modify = false">取 消</el-button>
		      <el-button type="primary" @click="updateItem()">确 定</el-button>
		    </span>
		  </el-dialog>
	  </el-row>
		<el-table
		    :data="tableData"
		    border
		    style="width: 100%;margin-top: 20px;">
			<el-table-column
			  prop="select"
			 label-class-name="lcn"
			 type="selection">
			</el-table-column>
		    <el-table-column
				prop="number"
				label-class-name="lcn"
		        type="index"
				label="编号"
				width="88">
		    </el-table-column>
		    <el-table-column
		      prop="name"
			  label-class-name="lcn"
		      label="用户名">
		    </el-table-column>
		    <el-table-column
		      prop="phone"
			  label-class-name="lcn"
		      label="联系电话"
			  width="">
		    </el-table-column>
			<el-table-column
			  prop="position"
			  label-class-name="lcn"
			  label="寝室位置"
			  width="">
			</el-table-column>
			<el-table-column
				label="操作"
				label-class-name="lcn"
				width="180">
				<template slot-scope="scope">
				<el-button @click="editItem(scope.row)" type="text" size="small">
					<i class="el-icon-edit"></i>修改</el-button>
				<el-button @click="del(scope.row)" type="text" size="small">
					<i class="el-icon-delete"></i>删除</el-button>
				</template>
				</el-table-column>
		</el-table>
	</div>
</template>

<script>
import axios from 'axios';
export default {
	name:'YongHu',
	data() {
	     return {
				currentPage4: 2,
			//搜索栏
			quarter:{
				name:'',
				position:''
			},
			fromData:{
				name:'',
				phone:'',
				position:''
			},
			rules:{
				phone:[{
					required:true,
					message:'请输入手机号',
					trigger:'blur'
				},{
					pattern:/^1(3|4|5|7|8|9)\d{9}$/,
					message:'手机号格式错误',
					trigger:'blur'
				}],
				name:[{
					required:true,
					message:'请输入姓名',
					trigger:'blur'
				}],
				position:[{
					required:true,
					message:'请输入寝室位置',
					trigger:'blur'
				}]
			},
	          newlyAdded: false,
			  id:'',
			  nameone:'',
			  phonetwo:'',
			  positionthree:'',
			  tableData:[],
			  modify:false,
	     };
	   },
		created(){
			  this.getdata();
		},
		methods:{
		getdata(){
			axios.get('http://localhost:9090/yonghuall').then(res=>{
				this.tableData=res.data.data
			})
		},
		//查找
		search(name,position){
			if(this.quarter.name.trim()==''&& this.quarter.position.trim()==''){
				this.$message({
					message:'查询条件不能为空',
					type:'warning',
					duration:1000
				})
				return
			}else{
				this.tableData = this.tableData.filter(function(item){
				if(!position) return item.name == name
				if(!name) return item.position == position
				})
			}
			// this.getTableData()
		},
		//重置
		chongzhi(){
			this.quarter.name=''
			this.quarter.position=''
			this.getdata()
		},
		//增加
		addItem() {
				axios.post('http://localhost:9090/yonghuadd',{
					name:this.fromData.name,
					phone:this.fromData.phone,
					position:this.fromData.position
				}).then(res=>{
					console.log(res)
					this.$message.success('添加成功') // 加成功提示
					this.fromData.name=''
					this.fromData.phone=''
					this.fromData.position=''
					this.newlyAdded=false
					this.getdata()
				}).catch(e=>{
				console.log(e)
				this.$message.error('添加失败')
			})
			},
			//删除
		del(row) {
		      this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {
		        confirmButtonText: "确定",
		        cancelButtonText: "取消",
		        type: "warning",
		      })
		        .then(() => {
					// 这两句模拟接口删除返回的结果
				  axios.delete('http://localhost:9090/yongshan?id='+row.id).then(res=>{
					  console.log(res)
					  this.getdata();
					  this.$message({
						type: "success",
						message: "删除成功!",
					  });
				  }).catch(e=>{
						console.log(e)
						this.$message.error('删除失败')
					})
				}).catch(() => {
				  this.$message({
					type: "info",
					message: "已取消删除",
				  });
				});
		    },
			//修改
			//获取要修改数据放在修改框
			editItem(row) {
				this.id=row.id
				axios.get('http://localhost:9090/yong/'+row.id).then(res=>{
					this.nameone = res.data.data.name
					this.phonetwo = res.data.data.phone
					this.positionthree = res.data.data.position
				})
				this.modify=true;
			},
			// 确认修改
			updateItem() {
				console.log(this.id)
				axios.put('http://localhost:9090/yongxiu',{
					id:this.id,
					name:this.nameone,
					phone:this.phonetwo,
					position:this.positionthree
				}).then(res=>{
					console.log(res)
					this.nameone = ''
					this.phonetwo = ''
					this.positionthree = ''
					this.$message.success('修改成功'); // 加成功提示
					this.modify=false;
					this.getdata()
				})
			}
		}
}
</script>

<style>
	.lcn,.cell{
		text-align: center;
	}
</style>
