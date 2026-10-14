<template>
	<div class="home">
		<el-form :inline="true" :model="quarter" class="search">
		   <el-form-item label="姓名">
			<el-input v-model="quarter.name" placeholder="请输入姓名"></el-input>
		  </el-form-item>
		  <el-form-item>
			<el-button type="primary" @click="search(quarter.name)">搜索</el-button>
			<el-button type="primary" @click="chongzhi()">重置</el-button>
		  </el-form-item>
		</el-form>
	  <el-row>
	    <el-col :span="24">
	  	<el-button type="primary" plain @click="newlyAdded = true"><i class="el-icon-plus">新增</i></el-button>
	    </el-col>
		  <el-dialog
		    title="添加人员管理"
		    :visible.sync="newlyAdded"
		    width="30%"
		    :before-close="handleClose">
			<div style="display: flex; align-items: center; flex-wrap:wrap;">
				<el-form ref="elForm" :model="fromData" :rules="rules" size="medium" label-width="100px">
					<el-form-item label="姓名" prop="name">
						<el-input v-model="fromData.name" placeholder="请输入姓名" clerable :style="{width:'100%'}"></el-input>
					</el-form-item>
					<el-form-item label="性别" prop="gender">
						<el-input v-model="fromData.gender" placeholder="请输入性别" clerable :style="{width:'100%'}"></el-input>
					</el-form-item>
					<el-form-item label="来源地" prop="address">
						<el-input v-model="fromData.address" placeholder="请输入来源地" clerable :style="{width:'100%'}"></el-input>
					</el-form-item>
					<el-form-item label="电话" prop="phone">
						<el-input v-model="fromData.phone" placeholder="请输入电话" :maxlength="11" show-word-limit clerable :style="{width:'100%'}"></el-input>
					</el-form-item>
					<el-form-item label="备注">
						<el-input v-model="fromData.notes" type="textarea" placeholder="请输入备注" :autosize="{minRows:4,maxRows:4}" :style="{width:'100%'}"></el-input>
					</el-form-item>
				</el-form>
			</div>
		    <span slot="footer" class="dialog-footer">
		      <el-button @click="newlyAdded = false">取 消</el-button>
		      <el-button type="primary" @click="addItem()">确 定</el-button>
		    </span>
		  </el-dialog>
		  <el-dialog
		    title="修改饭菜管理"
		    :visible.sync="modify"
		    width="30%"
			:modal="xiugai"
		    :before-close="handleClose">
		  		<div style="display: flex; align-items: center; flex-wrap:wrap;">
		  			<div style="margin-bottom:10px ;">
		  				<span style="margin-left: 15px;">姓&nbsp;&nbsp;&nbsp;名</span>
		  				<el-input v-model="xiugai.name" placeholder="请输入姓名" style="width: 300px; margin-left: 10px;"></el-input>
		  			</div>
		  			<div>
		  				<span style="margin-left: 15px;">性&nbsp;&nbsp;&nbsp;别</span>
		  				<el-input v-model="xiugai.gender" placeholder="请输入性别"  style="width: 300px; margin-left: 10px;"></el-input>
		  			</div>
		  			<div>
		  				<span style="margin-left: 15px;">来源地</span>
		  				<el-input v-model="xiugai.address" placeholder="请输入来源地" style="width: 300px; margin-left: 10px;margin-top:10px ;"></el-input>
		  			</div>
		  			<div>
		  				<span style="margin-left: 15px;">电&nbsp;&nbsp;&nbsp;话</span>
		  				<el-input v-model="xiugai.phone" placeholder="请输入电话" style="width: 300px; margin-left: 10px; margin-top:10px ;"></el-input>
		  			</div>
		  			<div>
		  				<span style="margin-left: 15px;">备&nbsp;&nbsp;&nbsp;注</span>
		  				<el-input v-model="xiugai.notes" placeholder="请输入备注" style="width: 300px; margin-left: 10px; margin-top:10px ;"></el-input>
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
			 type="selection"
			  width="100">
			</el-table-column>
		    <el-table-column
				prop="number"
				label-class-name="lcn"
		        type="index"
				label="编号"
		        width="100">
		    </el-table-column>
		    <el-table-column
		      prop="name"
			  label-class-name="lcn"
		      label="姓名">
		    </el-table-column>
		    <el-table-column
		      prop="gender"
			  label-class-name="lcn"
		      label="性别">
		    </el-table-column>
			<el-table-column
			  prop="address"
			  label-class-name="lcn"
			  label="来源地">
			</el-table-column>
			<el-table-column
			  prop="phone"
			  label-class-name="lcn"
			  label="电话">
			</el-table-column>
			<el-table-column
			  prop="notes"
			  label-class-name="lcn"
			  label="备注">
			</el-table-column>
			<el-table-column
				label="操作"
				label-class-name="lcn"
				width="180">
				<template slot-scope="scope">
				<el-button @click="editItem(scope.rows,scope.$index)" type="text" size="small">
					<i class="el-icon-edit"></i>修改</el-button>
				<el-button @click="del(scope.row,scope.$index)" type="text" size="small">
					<i class="el-icon-delete"></i>删除</el-button>
				</template>
				</el-table-column>
		</el-table>
	</div>
</template>

<script>
import axios from 'axios';
export default {
	name:'RenYuan',
	data() {
	     return {
				currentPage4: 2,
			//搜索栏
			quarter:{
				nameone:'',//姓名
			},
			fromData:{
				naem:'',
				gender:'',
				address:'',
				phone:'',
				notes:''
			},
			xiugai:{
				name:'',
				gender:'',
				address:'',
				phone:'',
				notes:''
			},
			id:'',
	        newlyAdded: false,
			codetwo:'',
			numbertop:'',
			codetop:'',
			tableData:[],
			modify:false,
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
				gender:[{
					required:true,
					message:'请输入性别',
					trigger:'blur'
				}],
				address:[{
					required:true,
					message:'请输入来源地',
					trigger:'blur'
				}]
			}
	     };
	   },
		created(){
			this.getData();
		},
		methods:{
			getData(){
				axios.get('http://localhost:9090/cantingall').then(res=>{
					console.log(res.data.data)
					this.tableData=res.data.data
				})
			},
		//查找
		search(nameone){
			if(this.quarter.name.trim()==''){
				this.$message({
					message:'查询条件不能为空',
					type:'warning',
					duration:1000
				})
				return
			}else{
				this.tableData = this.tableData.filter(function(item){
				return item.name == nameone
				})
			}
			// this.getTableData()
		},
		//重置
		chongzhi(){
			this.quarter.name=''
			this.getData();
		},
		//增加
		addItem() {
				axios.post("http://localhost:9090/cantingadd",{
					name:this.fromData.name,
					gender:this.fromData.gender,
					address:this.fromData.address,
					phone:this.fromData.phone,
					notes:this.fromData.notes
				}).then(res=>{
					console.log(res)
					this.$message.success('添加成功') // 加成功提示
					this.fromData.name='';
					this.fromData.gender='';
					this.fromData.address='';
					this.fromData.phone='';
					this.fromData.notes='';
					this.newlyAdded=false
					this.getData()
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
		      }).then(() => {
		          // 这两句模拟接口删除返回的结果
				  axios.delete('http://localhost:9090/cantingshan?id='+row.id).then(res=>{
					  console.log(res)
					  this.getData();
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
			editItem(row,index) {
				this.modify=true;
				this.index = index;
				this.id=this.tableData[index].id;
				this.xiugai.name = this.tableData[index].name;
				this.xiugai.gender = this.tableData[index].gender;
				this.xiugai.address = this.tableData[index].address;
				this.xiugai.phone = this.tableData[index].phone;
				this.xiugai.notes = this.tableData[index].notes;
			},
			// 确认修改
			updateItem() {
				axios.put('http://localhost:9090/cantingxiu',{
					id:this.id,
					name:this.xiugai.name,
					gender:this.xiugai.gender,
					address:this.xiugai.address,
					phone:this.xiugai.phone,
					notes:this.xiugai.notes
				}).then(res=>{
					console.log(res)
					this.$message.success('修改成功') // 加成功提示
					this.modify=false;
					this.getData()
				}).catch(e=>{
				console.log(e)
				this.$message.error('修改失败')
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
