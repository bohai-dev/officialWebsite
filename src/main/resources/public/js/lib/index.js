 new Vue({
 	el: '#app',
 	data: function() {
 		return {
 			tableData: [],
 			selectReadData: null,
 			tableDataCount: null, //数据长度
 			tableDataPageNum: 0, //当前页数
 			tableDataPageSize: 10, //每页页数
 			currentPage: 1, //当前页数
 			dialogTableVisible: false,
 			contactDeatil: "",
 			titleDeatilCont:"欢迎查看联系记录！",
 			reMarkBtn:"标为已读",
 			logout:"退出",

 		}
 	},
 	created: function() {
 		this.initData();
 	},
 	mounted: function() {
 		
 	},
 	components: {

 	},
 	methods: {
 		initData: function() {
 			this.$http.get("/contactUs/selectByUser").then((res) => {
 				if(res.status == 200 && res.body.errorCode == 0) {
 					this.tableData = res.body.data.slice(this.tableDataPageNum * this.tableDataPageSize, this.tableDataPageNum * this.tableDataPageSize + this.tableDataPageSize);
 					//				console.log(this.tableData )
 					this.tableDataCount = res.body.data.length;
 				}
 			}).catch((res) => {})

 		},
 		//标为已读
 		reMarkRead: function(index) {
 			if(this.selectReadData) {
 				var idList = [];
 				this.selectReadData.forEach(function(item) {
 					idList.push(item.id);
 				})
 				this.$http.get("/contactUs/signRead?idList=" + idList).then((res) => {
 					if(res.status == 200 && res.body.errorCode == 0) {
 						this.initData();
 						this.$message({
 							message: "成功标为已读！",
 							type: "success"
 						});
 					}
 				})
 			}
 		},
 		handleDetail: function(scope) {
 			this.dialogTableVisible = true;
 			this.contactDeatil = scope.row.contactDeatil;
 		},
 		//选择勾选
 		handleSelectionChange: function(e) {
 			this.selectReadData = e;
 		},
 		handleCurrentChange: function(data) {
 			this.tableDataPageNum = data - 1;
 			this.initData();
 		}
 	}
 })