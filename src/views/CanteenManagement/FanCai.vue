<template>
	<div class="home">
		<el-form :inline="true" :model="quarter" class="search">
		   <el-form-item label="饭菜名">
			<el-input v-model="quarter.fanname" placeholder="请输入饭菜名"></el-input>
		  </el-form-item>
		  <el-form-item label="餐厅名">
		  		<el-input v-model="quarter.cainame" placeholder="请输入餐厅名"></el-input>
		  </el-form-item>
		  <el-form-item>
			<el-button type="primary" @click="search(quarter.fanname,quarter.cainame)">搜索</el-button>
			<el-button type="primary" @click="chongzhi(quarter.fanname,quarter.cainame)">重置</el-button>
		  </el-form-item>
		</el-form>
	  <el-row>
	    <el-col :span="24">
	  	<el-button type="primary" plain @click="newlyAdded = true"><i class="el-icon-plus">新增</i></el-button>
	    </el-col>
		  <el-dialog
		    title="添加饭菜管理"
		    :visible.sync="newlyAdded"
		    width="30%"
		    :before-close="handleClose">
			<div style="display: flex; align-items: center; flex-wrap:wrap;">
				<div style="margin-bottom:10px ;">
					<span style="margin-left: 15px;">饭菜名</span>
					<el-input v-model="numberone" placeholder="请输入饭菜名" style="width: 300px; margin-left: 10px;"></el-input>
				</div>
				<div>
					<span style="margin-left: 15px;">餐厅名</span>
					<el-input v-model="codeone" placeholder="请输入餐厅名" style="width: 300px; margin-left: 10px;"></el-input>
				</div>
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
		    :before-close="handleClose">
		  		<div style="display: flex; align-items: center; flex-wrap:wrap;">
		  			<div style="margin-bottom:10px ;">
		  				<span style="margin-left: 15px;">饭菜名</span>
		  				<el-input v-model="numbertwo" placeholder="请输入饭菜名" style="width: 300px; margin-left: 10px;"></el-input>
		  			</div>
		  			<div>
		  				<span style="margin-left: 15px;">餐厅名</span>
		  				<el-input v-model="codetwo" placeholder="请输入餐厅名" style="width: 300px; margin-left: 10px;"></el-input>
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
			  width="250">
			</el-table-column>
		    <el-table-column
				prop="number"
				label-class-name="lcn"
		        type="index"
				label="编号"
		        width="250">
		    </el-table-column>
		    <el-table-column
		      prop="fanname"
			  label-class-name="lcn"
		      label="饭菜名">
		    </el-table-column>
		    <el-table-column
		      prop="cainame"
			  label-class-name="lcn"
		      label="餐厅名"
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
	name:'FanCai',
	data() {
	     return {
				currentPage4: 2,
			//搜索栏
			quarter:{
				fanname:'',//饭菜名
				cainame:'',//餐厅名
			},
	       newlyAdded: false,
			  numberone:'',
			  numbertwo:'',
			  codeone:'',
			  codetwo:'',
			  numbertop:'',
			  codetop:'',
			  tableData:[],
			  modify:false,
	     };
	   },
		created(){
			this.getcai()
		},
		methods:{
		getcai(){
			axios.get('http://localhost:9090/fancai').then(res=>{
				this.tableData=res.data.data
			})
		},
		//查找
		search(fanname,cainame){
			if(this.quarter.fanname.trim()=='' && this.quarter.cainame.trim()==''){
				this.$message({
					message:'查询条件不能为空',
					type:'warning',
					duration:1000
				})
				return
			}else{
				this.tableData = this.tableData.filter(function(item){
				if(!cainame) return item.fanname == fanname
				if(!fanname) return item.cainame == cainame 
				})
			}
		},
		//重置
		chongzhi(){
			this.quarter.fanname=''
			this.quarter.cainame=''
			this.getcai()
		},
		//增加
		addItem() {
			
			// console.log('新增编码',this.numberone)
			// console.log('新增仓库',this.codeone)
			if(this.numberone.trim()==''&& this.codeone.trim()=='' ){
				this.$message({
					message:'添加条件不能为空',
					type:'warning',
					duration:1000
				})
				return
			}
			axios.post('http://localhost:9090/fancaiadd',{
				fanname:this.numberone,
				cainame:this.codeone
			}).then(res=>{
				console.log(res)
				this.$message.success('添加成功') // 加成功提示
				this.numberone=''
				this.codeone=''
				this.getcai()
				this.newlyAdded=false
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
					axios.delete('http://localhost:9090/caishan?id='+row.id).then(res=>{
						console.log(res)
						this.$message({
						  type: "success",
						  message: "删除成功!",
						});
						this.getcai()
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
				axios.get('http://localhost:9090/fanxiu/'+row.id).then(res=>{
					this.numbertwo=res.data.data.fanname;
					this.codetwo=res.data.data.cainame
				});
				this.modify=true;
				this.index = index;
			},
			// 确认修改
			updateItem() {
				axios.put('http://localhost:9090/caixiu',{
					id:this.id,
					fanname:this.numbertwo,
					cainame:this.codetwo
				}).then(res=>{
					console.log(res)
					this.$message.success('修改成功') // 加成功提示
					this.numbertwo='';
					this.codetwo='';
					this.modify=false;
					this.getcai()
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
