webpackJsonp([21],{MVMd:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=o("mtWM"),n=o.n(a),s={data:function(){return{isshow:!1,form:{name:"",region:""},formInline:{user:"",region:""},name:"",authorities:"",roleId:"",generatorCapacity:"",voltageLevel:"",province:"",roleNote:"",roleName:"",address:"",phone:"",postcode:"",msg:8888,list3:[],list2:[],list:[],pagesize:5,currpage:1}},methods:{show:function(){this.isshow=!this.isshow},handleCurrentChange:function(e){this.currpage=e},handleSizeChange:function(e){this.pagesize=e},handleSelectionChange:function(e){console.log(e)},activated:function(){this.$router.push(this.path)},beforeRouteLeave:function(e,t,o){this.path=this.$route.path,o()},handleClick:function(e){n.a.get("http://localhost:8084/role/delete?roleId="+e.roleId).then(function(e){}).catch(function(e){console.log(e),e.response?(console.log(e.response.data),console.log(e.response.status),console.log(e.response.headers)):console.log("Error",e.message),console.log(e.config)}),alert("确认删除？"),window.location.reload()},search:function(){var e=this,t=document.getElementById("btn0").value;n.a.get("http://localhost:8084/role/findByName?roleName="+t).then(function(t){e.list3=e.list,console.log(t),e.list=t.data.data.filter(function(e){return 0==e.infoState})}).catch(function(e){console.log(e),e.response?(console.log(e.response.data),console.log(e.response.status),console.log(e.response.headers)):console.log("Error",e.message),console.log(e.config)})},reback:function(){this.list=this.list2},refrashData:function(){for(var e=document.getElementById("section_addRole_box_content_ChooseArea_radio").getElementsByTagName("input"),t=[],o=0;o<e.length;o++)1==e[o].checked&&t.push(e[o].name);this.authorities=t.toString(),n.a.post("http://localhost:8084/role/update",{roleName:this.roleName,roleNote:this.roleNote,authorities:this.authorities,roleId:this.roleId}).then(function(e){console.log(e),window.location.reload(),alert("修改成功!")}).catch(function(e){console.log(e)})},handleClick2:function(e){var t;t=e,this.roleName=t.roleName,this.roleNote=t.roleNote,this.authorities=t.authorities,this.roleId=t.roleId},ChooseAll:function(){for(var e=document.getElementById("section_addRole_box_content_ChooseArea_radio").getElementsByTagName("input"),t=0;t<e.length;t++)e[t].checked=!0},UnChooseAll:function(){for(var e=document.getElementById("section_addRole_box_content_ChooseArea_radio").getElementsByTagName("input"),t=0;t<e.length;t++)e[t].checked=!1}},created:function(){var e=this;n.a.get("http://localhost:8084/role/findall").then(function(t){console.log(t),e.list=t.data.data.filter(function(e){return 0==e.infoState}),e.list2=e.list}).catch(function(e){console.log(e),alert("网络错误，不能访问")})}},i={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{attrs:{id:"app"}},[o("div",{directives:[{name:"show",rawName:"v-show",value:e.isshow,expression:"isshow"}],staticClass:"content2"},[o("div",{attrs:{id:"section_addRole_box"}},[o("div",{attrs:{id:"section_addRole_box_title"}},[o("span",[e._v("新增角色")]),e._v(" "),o("div",{attrs:{id:"section_addRole_box_CloseBtn"},on:{click:e.show}},[e._v("X")])]),e._v(" "),o("div",{attrs:{id:"section_addRole_box_content"}},[o("div",{attrs:{id:"section_addRole_box_content_RoleName"}},[o("span",[e._v("角色名称：")]),e._v(" "),o("input",{directives:[{name:"model",rawName:"v-model",value:e.roleName,expression:"roleName"}],attrs:{type:"text",placeholder:"请输入"},domProps:{value:e.roleName},on:{input:function(t){t.target.composing||(e.roleName=t.target.value)}}})]),e._v(" "),o("div",{attrs:{id:"section_addRole_box_content_ChooseArea"}},[o("span",[e._v("权限选择：")]),e._v(" "),o("input",{attrs:{type:"radio",name:"1",id:"ChooseAll"},on:{click:e.ChooseAll}}),o("span",[e._v("全选")]),e._v(" "),o("input",{attrs:{type:"radio",name:"1",id:"UnChooseAll"},on:{click:e.UnChooseAll}}),o("span",[e._v("全不选")]),e._v(" "),o("br"),e._v(" "),e._m(0)]),e._v(" "),o("div",{attrs:{id:"section_addRole_box_content_remarks"}},[o("span",[e._v("备注:")]),e._v(" "),o("textarea",{directives:[{name:"model",rawName:"v-model",value:e.roleNote,expression:"roleNote"}],attrs:{name:"",id:"",cols:"30",rows:"10",placeholder:"请输入"},domProps:{value:e.roleNote},on:{input:function(t){t.target.composing||(e.roleNote=t.target.value)}}})]),e._v(" "),o("div",{attrs:{id:"section_addRole_box_HoldBtn"}},[o("span",{on:{click:function(t){e.show(),e.refrashData()}}},[e._v("保存")])])])])]),e._v(" "),o("div",{staticClass:"mainBox"},[o("div",{staticClass:"headbox"},[o("div",{staticClass:"navbar"},[o("router-link",{attrs:{to:"/xitong/xinzeng"}},[o("div",{staticClass:"item active"},[e._v("用户管理")])]),e._v(" "),o("router-link",{attrs:{to:"/xitong/user"}},[o("div",{staticClass:"item"},[e._v("角色管理")])])],1)]),e._v(" "),o("div",{staticClass:"bottombox"},[o("div",{staticClass:"card2"},[o("div",{staticClass:"card2_top"},[o("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0,model:e.form}},[o("div",{staticStyle:{float:"left","margin-left":"10%","margin-top":"20px"}},[o("el-form-item",{attrs:{label:"关键字"}},[o("el-input",{attrs:{placeholder:"请输入关键字",id:"btn0"},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}})],1),e._v(" "),o("el-form-item",[o("el-button",{attrs:{type:"primary"},on:{click:e.search}},[e._v("查询")])],1),e._v(" "),o("el-form-item",[o("el-button",{attrs:{type:"info"},on:{click:e.reback}},[e._v("重置")])],1)],1),e._v(" "),o("div",{staticStyle:{float:"right","margin-right":"10%","margin-top":"20px"}},[o("el-form-item",[o("el-button",{attrs:{type:"success"}},[o("router-link",{attrs:{to:"./xinzeng"}},[e._v(" +新增")])],1)],1)],1)])],1),e._v(" "),o("div",{attrs:{id:"card2_bottom"}},[o("el-table",{staticStyle:{width:"100%"},attrs:{data:e.list.slice((e.currpage-1)*e.pagesize,e.currpage*e.pagesize)},on:{"selection-change":e.handleSelectionChange}},[o("el-table-column",{attrs:{prop:"roleName",label:"角色名称"}}),e._v(" "),o("el-table-column",{attrs:{prop:"authorities",label:"权限"}}),e._v(" "),o("el-table-column",{attrs:{prop:"roleNote",label:"备注"}}),e._v(" "),o("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("el-button",{attrs:{type:"text",size:"small",data:e.list.id},on:{click:function(o){return e.handleClick(t.row)}}},[e._v("删除\r\n                       ")]),e._v(" "),o("el-button",{attrs:{type:"text",size:"small"},on:{click:function(o){e.handleClick2(t.row),e.show()}}},[e._v("修改\r\n                       ")])]}}])})],1),e._v(" "),o("el-pagination",{attrs:{background:"",layout:"prev, pager, next, sizes, total, jumper","page-sizes":[5,10,15,20],"page-size":e.pagesize,total:e.list.length},on:{"current-change":e.handleCurrentChange,"size-change":e.handleSizeChange}})],1)])])])])},staticRenderFns:[function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{attrs:{id:"section_addRole_box_content_ChooseArea_radio"}},[o("input",{attrs:{type:"checkbox",name:"1"}}),o("span",[e._v("电厂管理")]),e._v(" "),o("input",{attrs:{type:"checkbox",name:"2"}}),o("span",[e._v("设备类型管理")]),e._v(" "),o("input",{attrs:{type:"checkbox",name:"3"}}),o("span",[e._v("设备管理")]),e._v(" "),o("input",{attrs:{type:"checkbox",name:"4"}}),o("span",[e._v("合同管理")]),e._v(" "),o("br"),e._v(" "),o("input",{attrs:{type:"checkbox",name:"5"}}),o("span",[e._v("试验报价管理")]),e._v(" "),o("input",{attrs:{type:"checkbox",name:"6"}}),o("span",[e._v("实验报告模板管理")]),e._v(" "),o("input",{attrs:{type:"checkbox",name:"7"}}),o("span",[e._v("试验报告管理")]),e._v(" "),o("input",{attrs:{type:"checkbox",name:"8"}}),o("span",[e._v("作业指导书管理")]),e._v(" "),o("br"),e._v(" "),o("input",{attrs:{type:"checkbox",name:"9"}}),o("span",[e._v("用户管理")]),e._v(" "),o("input",{attrs:{type:"checkbox",name:"10"}}),o("span",[e._v("角色管理")]),e._v(" "),o("br"),e._v(" "),o("input",{attrs:{type:"checkbox",name:"11"}}),o("span",[e._v("合同(APP)")]),e._v(" "),o("input",{attrs:{type:"checkbox",name:"12"}}),o("span",[e._v("设备(APP)")]),e._v(" "),o("input",{attrs:{type:"checkbox",name:"13"}}),o("span",[e._v("指导书(APP)")]),e._v(" "),o("input",{attrs:{type:"checkbox",name:"14"}}),o("span",[e._v("报价(APP)")])])}]};var l=o("VU/8")(s,i,!1,function(e){o("nwxb")},"data-v-6639fae0",null);t.default=l.exports},nwxb:function(e,t){}});
//# sourceMappingURL=21.2efa94e56d179d6350cd.js.map