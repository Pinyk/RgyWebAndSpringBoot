webpackJsonp([27],{"2Z6r":function(t,e){},"7AKe":function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var i=a("mtWM"),o=a.n(i),l={name:"",created:function(){var t=this;o.a.get("http://localhost:8084/material/findAll").then(function(e){console.log(e),t.list=e.data.data.filter(function(t){return 0==t.infoState}),t.list2=t.list}).catch(function(t){console.log(t),alert("网络错误，不能访问")})},data:function(){return{isshow:!1,form:{name:"",region:"",materialName:""},formInline:{user:"",region:""},materialName:"",materialUrl:"",infoState:"",materialID:"",msg:8888,list3:[],list2:[],list:[],pagesize:5,currpage:1}},methods:{handleCurrentChange:function(t){this.currpage=t},handleSizeChange:function(t){this.pagesize=t},handleSelectionChange:function(t){console.log(t)},reback:function(){document.getElementById("btn0").value="",this.list=this.list2},search:function(){var t=this,e=document.getElementById("btn0").value;alert(e),o.a.get("http://localhost:8084/material/findByName?materialName="+e).then(function(e){console.log(e),t.list=e.data.data.filter(function(t){return 0==t.infoState})}).catch(function(t){console.log(t),t.response?(console.log(t.response.data),console.log(t.response.status),console.log(t.response.headers)):console.log("Error",t.message),console.log(t.config)})},show:function(){this.isshow=!this.isshow},handleClick2:function(t){alert(t.materialName),this.form.materialName=t.materialName,this.materialUrl=t.materialUrl,this.materialID=t.materialID,this.infoState=t.infoState},refrashData:function(){o.a.post("http://localhost:8084/material/update",{materialName:this.form.materialName,materialUrl:this.materialUrl,materialID:this.materialID,infoState:this.infoState}).then(function(t){}).catch(function(t){console.log(t)}),window.location.reload(),alert("修改成功!")},handleClick:function(t){alert(t.materialID),o.a.get("http://localhost:8084/material/delete?materialID="+t.materialID).then(function(t){alert("确认删除？"),window.location.reload()}).catch(function(t){console.log(t),t.response?(console.log(t.response.data),console.log(t.response.status),console.log(t.response.headers)):console.log("Error",t.message),console.log(t.config)})}},activated:function(){this.$router.push(this.path)},beforeRouteLeave:function(t,e,a){this.path=this.$route.path,a()}},n={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{id:"app"}},[a("div",{staticClass:"mainBox"},[a("div",{staticClass:"headbox"},[a("div",{staticClass:"navbar"},[a("router-link",{attrs:{to:"/shiyan/zuoye"}},[a("div",{staticClass:"item"},[t._v("作业指导书")])]),t._v(" "),a("router-link",{attrs:{to:"/shiyan/baojia"}},[a("div",{staticClass:"item"},[t._v("报价管理")])]),t._v(" "),a("router-link",{attrs:{to:"/shiyan/moban"}},[a("div",{staticClass:"item"},[t._v("报告模板")])]),t._v(" "),a("router-link",{attrs:{to:"/shiyan/reportGuanli"}},[a("div",{staticClass:"item"},[t._v("报告管理")])]),t._v(" "),a("router-link",{attrs:{to:"/shiyan/shiyanren"}},[a("div",{staticClass:"item active"},[t._v("试验人员资料")])])],1)]),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:t.isshow,expression:"isshow"}],staticClass:"back"},[a("div",{staticClass:"card1"},[a("el-form",{ref:"form",attrs:{"label-width":"80px"},model:{value:t.form.region,callback:function(e){t.$set(t.form,"region",e)},expression:"form.region"}},[a("el-form-item",{attrs:{label:"电厂名称"}},[a("el-input",{model:{value:t.form.materialName,callback:function(e){t.$set(t.form,"materialName",e)},expression:"form.materialName"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"上传附件"}},[a("div",[t._v("\r\n                     上传附件:"),a("input",{staticClass:"file",attrs:{type:"file",id:"btn1"}})])]),t._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.refrashData(),t.show()}}},[t._v(" 保存")])],1)],1)],1)]),t._v(" "),a("div",{staticClass:"bottombox"},[a("div",{staticClass:"card2"},[a("div",{staticClass:"card2_top"},[a("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0,model:t.form}},[a("div",{staticStyle:{float:"left","margin-left":"10%","margin-top":"20px"}},[a("el-form-item",{attrs:{label:"关键字"}},[a("el-input",{attrs:{placeholder:"请输入关键字",id:"btn0"},model:{value:t.form.powerPlantName,callback:function(e){t.$set(t.form,"powerPlantName",e)},expression:"form.powerPlantName"}})],1),t._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.search()}}},[t._v("查询")])],1),t._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"info"},on:{click:t.reback}},[t._v("重置")])],1)],1),t._v(" "),a("div",{staticStyle:{float:"right","margin-right":"10%","margin-top":"20px"}},[a("el-form-item",[a("el-button",{attrs:{type:"success"}},[a("router-link",{attrs:{to:"./shiyanren"}},[t._v(" +新增")])],1)],1)],1)])],1),t._v(" "),a("div",{attrs:{id:"card2_bottom"}},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.list.slice((t.currpage-1)*t.pagesize,t.currpage*t.pagesize)},on:{"selection-change":t.handleSelectionChange}},[a("el-table-column",{attrs:{prop:"materialName",label:"资料名称"}}),t._v(" "),a("el-table-column",{attrs:{prop:"materialUrl",label:"附件"}}),t._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.handleClick(e.row)}}},[t._v("删除\r\n                       ")]),t._v(" "),a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){t.handleClick2(e.row),t.show()}}},[t._v("修改\r\n                       ")])]}}])})],1),t._v(" "),a("el-pagination",{attrs:{background:"",layout:"prev, pager, next, sizes, total, jumper","page-sizes":[5,10,15,20],"page-size":t.pagesize,total:t.list.length},on:{"current-change":t.handleCurrentChange,"size-change":t.handleSizeChange}})],1)])])])])},staticRenderFns:[]};var r=a("VU/8")(l,n,!1,function(t){a("2Z6r")},"data-v-2a6362bc",null);e.default=r.exports}});
//# sourceMappingURL=27.d6f9d2b0c81c8d5fb826.js.map