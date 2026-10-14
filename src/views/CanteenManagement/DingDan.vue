<template>
	<div class="home">
		<el-form :inline="true" :model="quarter" class="search">
		  <el-form-item label="订单名">
		  		<el-input v-model="quarter.OrderName" placeholder="请输入订单名"></el-input>
		  </el-form-item>
		  <el-form-item label="用户名">
		  		<el-input v-model="quarter.UserName" placeholder="请输入用户名"></el-input>
		  </el-form-item>
		  <el-form-item>
			<el-button type="primary" @click="search(quarter.OrderName,quarter.UserName)">搜索</el-button>
			<el-button type="primary" @click="chongzhi()">重置</el-button>
		  </el-form-item>
		</el-form>
	  <el-row>
	    <el-col :span="24">
	  	<el-button type="primary" plain @click="newlyAdded = true"><i class="el-icon-plus">新增</i></el-button>
	    </el-col>
		  <el-dialog
		    title="添加订单管理"
		    :visible.sync="newlyAdded"
		    width="30%"
		    :before-close="handleClose">
			<div style="display: flex; align-items: center; flex-wrap:wrap;">
				<div>
					<span style="margin-left: 15px;">订单名</span>
					<el-input v-model="OrderName" placeholder="请输入订单名名" style="width: 300px; margin-left: 10px;"></el-input>
				</div>
				<div>
					<span style="margin-left: 15px;">用户名</span>
					<el-input v-model="UserName" placeholder="请输入用户名" style="width: 300px; margin-left: 10px; margin-top: 10px;"></el-input>
				</div>
			</div>
		    <span slot="footer" class="dialog-footer">
		      <el-button @click="newlyAdded = false">取 消</el-button>
		      <el-button type="primary" @click="addItem()">确 定</el-button>
		    </span>
		  </el-dialog>
		  <el-dialog
		    title="修改订单管理"
		    :visible.sync="modify"
		    width="30%"
		    :before-close="handleClose"
			>
		  		<div style="display: flex; align-items: center; flex-wrap:wrap;">
		  			<div style="margin-bottom:10px ;">
		  				<span style="margin-left: 15px;">订单号</span>
		  				<el-input disabled v-model="Orderone" placeholder="请输入订单号" style="width: 300px; margin-left: 10px;"></el-input>
		  			</div>
		  			<div>
		  				<span style="margin-left: 15px;">订单名</span>
		  				<el-input v-model="OrderNametwo" placeholder="请输入订单名" style="width: 300px; margin-left: 10px;"></el-input>
		  			</div>
					<div>
						<span style="margin-left: 15px;">用户名</span>
						<el-input v-model="UserNamethree" placeholder="请输入用户名" style="width: 300px; margin-left: 10px;margin-top: 10px;"></el-input>
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
		      prop="Order"
			  label-class-name="lcn"
		      label="订单号">
		    </el-table-column>
		    <el-table-column
		      prop="OrderName"
			  label-class-name="lcn"
		      label="订单名"
			  width="">
		    </el-table-column>
			<el-table-column
			  prop="UserName"
			  label-class-name="lcn"
			  label="用户名"
			  width="">
			</el-table-column>
			<el-table-column
			  prop="time"
			  label-class-name="lcn"
			  label="订单时间"
			  width="">
			</el-table-column>
			<el-table-column
				label="操作"
				label-class-name="lcn"
				width="180">
				<template slot-scope="scope">
				<el-button @click="editItem(scope.row,scope.$index)" type="text" size="small">
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
	name:'DingDan',
	data() {
	     return {
				currentPage4: 2,
			//搜索栏
			quarter:{
				OrderName:'',
				UserName:''
			},
	       newlyAdded: false,
			  OrderName:'',
			  UserName:'',
			  Orderone:'',
			  OrderNametwo:'',
			  UserNamethree:'',
			  id:'',
			  tableData:[],
			  modify:false,
	     };
	   },
		created(){
			  this.getdata()
		},
		methods:{
			getdata(){
				axios.get('http://localhost:9090/dingdanall').then(res=>{
					console.log(res.data.data)
					this.tableData=res.data.data
				})
			},
		//查找
		search(OrderName,UserName){
			if(this.quarter.OrderName.trim()==''&& this.quarter.UserName.trim()==''){
				this.$message({
					message:'查询条件不能为空',
					type:'warning',
					duration:1000
				})
				return
			}else{
				this.tableData = this.tableData.filter(function(item){
				if(!UserName) return item.OrderName == OrderName
				if(!OrderName) return item.UserName == UserName
				})
			}
		},
		//重置
		chongzhi(){
			this.quarter.OrderName=''
			this.quarter.UserName=''
			this.getdata()
		},
		//增加
		addItem() {
				if(this.OrderName.trim()==''&& this.UserName.trim()=='' ){
					this.$message({
						message:'添加条件不能为空',
						type:'warning',
						duration:1000
					})
					return
				}
				axios.post('http://localhost:9090/dingdanadd',{
					OrderName:this.OrderName,
					UserName:this.UserName
				}).then(res=>{
					console.log(res.data.data)
					this.OrderName=''
					this.UserName=''
					this.newlyAdded=false
					this.getdata()
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
		          axios.delete('http://localhost:9090/dingshan?id='+row.id).then(res=>{
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
			editItem(row,index) {
				this.id=row.id
				axios.get('http://localhost:9090/dingdan/'+row.id).then(res=>{
					this.Orderone=res.data.data.Order
					this.OrderNametwo=res.data.data.OrderName;
					this.UserNamethree=res.data.data.UserName
				});
				this.modify=true;
				this.index = index;
			},
			// 确认修改
			updateItem() {
				axios.put('http://localhost:9090/dingdanxiua',{
					id:this.id,
					Order:this.Orderone,
					OrderName:this.OrderNametwo,
					UserName:this.UserNamethree
				}).then(res=>{
					console.log(res)
					this.Orderone=''
					this.OrderNametwo=''
					this.UserNamethree=''
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
