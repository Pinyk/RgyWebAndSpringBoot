webpackJsonp([17],{U2gu:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var s=a("mtWM"),l=a.n(s),o={data:function(){return{path:"./Aftermoban.vue",isshow:!1,isshow2:!1,formInline:{con:""},dialogTableVisible:!1,dialogFormVisible:!0,centerDialogVisible:!1,form:{name:"",record:"",type:[]},formLabelWidth:"120px",templateName:"",templateName1:"",templateId:"",equipmentTypeId:"",idarr:[],list:[],list1:[],list2:[],arr_template:[],arr_items:[]}},methods:{show:function(){this.isshow=!this.isshow},show2:function(){this.isshow2=!this.isshow2},delitem:function(t){console.log(t),l.a.get("http://localhost:8084/items/delete?itemsId="+t).then(function(t){console.log(t),window.location.reload()}).catch(function(t){console.log(t)})},additem:function(){var t=document.getElementById("itemsName").value,e=document.getElementById("sort").value;l.a.post("http://localhost:8084/items/add",{templateId:this.templateId1,itemsName:t,sort:e}).then(function(t){console.log(t),window.location.reload()}).catch(function(t){console.log(t)})},refrashData:function(){for(var t=document.getElementById("testEquipment").getElementsByTagName("input"),e=[],a=0;a<t.length;a++)1==t[a].checked&&(e.push(t[a].value),this.equipmentTypeId=e.toString());console.log(this.equipmentTypeId),l.a.post("http://localhost:8084/template/update",{templateId:this.templateId,templateName:this.templateName,equipmentTypeId:this.equipmentTypeId}).then(function(t){console.log(t),alert("修改成功!"),window.location.reload()}).catch(function(t){console.log(t)})},getId:function(t){this.templateId=t},getId1:function(t){this.templateId1=t},search:function(){var t=this,e=document.getElementById("btn0").value;l.a.get("http://localhost:8084/template/findByName?templateName="+e).then(function(e){t.list3=t.list,console.log(e),t.list=e.data.data.filter(function(t){return 0==t.infoState})}).catch(function(t){console.log(t),t.response?(console.log(t.response.data),console.log(t.response.status),console.log(t.response.headers)):console.log("Error",t.message),console.log(t.config)})},update:function(t){l.a.get("http://localhost:8084/template/delete?templateId="+t).then(function(t){console.log(t)}).catch(function(t){console.log(t),t.response?(console.log(t.response.data),console.log(t.response.status),console.log(t.response.headers)):console.log("Error",t.message),console.log(t.config)}),alert("确认删除？"),window.location.reload()},clearResult:function(){this.list=this.list1},paramMain:function(t){this.$router.push({name:"canshuKong",path:"./canshuKong",query:{data:t}})}},created:function(){var t=this;l.a.get("http://localhost:8084/template/findall1").then(function(e){console.log(e),t.list=e.data.data,console.log(t.list2)}).catch(function(t){console.log(t)})},activated:function(){this.$router.push(this.path)},beforeRouteLeave:function(t,e,a){this.path=this.$route.path,a()}},i={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{id:"app"}},[a("div",{directives:[{name:"show",rawName:"v-show",value:t.isshow2,expression:"isshow2"}],staticClass:"content2"},[a("div",{staticClass:"add"},[a("div",{staticClass:"header"},[a("span",{staticStyle:{float:"left"}},[t._v("新增实验报告模板")]),t._v(" "),a("span",{staticStyle:{float:"right",cursor:"pointer"},on:{click:t.show2}},[t._v("X")])]),t._v(" "),a("div",{staticClass:"zhong",staticStyle:{"margin-top":"50px","margin-left":"50px","text-align":"left",width:"500px"}},[a("el-form",{attrs:{model:t.form}},[a("el-form-item",{attrs:{label:"模板名称：","label-width":t.formLabelWidth}},[a("el-input",{attrs:{placeholder:"请输入"},model:{value:t.templateName,callback:function(e){t.templateName=e},expression:"templateName"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"适用设备：","label-width":t.formLabelWidth}},[a("el-checkbox-group",{attrs:{id:"testEquipment"},model:{value:t.form.type,callback:function(e){t.$set(t.form,"type",e)},expression:"form.type"}},[a("el-checkbox",{staticClass:"checkboxs",attrs:{label:"变压器",name:"1"}}),t._v(" "),a("el-checkbox",{staticClass:"checkboxs",attrs:{label:"避雷针",name:"2"}}),t._v(" "),a("el-checkbox",{staticClass:"checkboxs",attrs:{label:"母线",name:"3"}}),t._v(" "),a("el-checkbox",{staticClass:"checkboxs",attrs:{label:"电流互感器",name:"4"}}),t._v(" "),a("el-checkbox",{staticClass:"checkboxs",attrs:{label:"电压互感器",name:"5"}}),t._v(" "),a("el-checkbox",{staticClass:"checkboxs",attrs:{label:"进线柜",name:"6"}}),t._v(" "),a("el-checkbox",{staticClass:"checkboxs",attrs:{label:"出线柜",name:"7"}})],1)],1)],1)],1),t._v(" "),a("div",{staticClass:"bottom",staticStyle:{"text-align":"center","margin-top":"30px"}},[a("el-row",[a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.show2(),t.refrashData()}}},[t._v("下一步")])],1)],1)])]),t._v(" "),a("div",{staticClass:"mainBox"},[a("div",{staticClass:"headbox"},[a("div",{staticClass:"navbar"},[a("router-link",{attrs:{to:"/shiyan/zuoye"}},[a("div",{staticClass:"item"},[t._v("作业指导书")])]),t._v(" "),a("router-link",{attrs:{to:"/shiyan/baojia"}},[a("div",{staticClass:"item"},[t._v("报价管理")])]),t._v(" "),a("router-link",{attrs:{to:"/shiyan/moban"}},[a("div",{staticClass:"item active"},[t._v("报告模板")])]),t._v(" "),a("router-link",{attrs:{to:"/shiyan/reportGuanli"}},[a("div",{staticClass:"item"},[t._v("报告管理")])]),t._v(" "),a("router-link",{attrs:{to:"/shiyan/shiyanren"}},[a("div",{staticClass:"item"},[t._v("试验人员资料")])])],1)]),t._v(" "),a("div",{staticClass:"bottombox"},[a("div",{directives:[{name:"show",rawName:"v-show",value:t.isshow,expression:"isshow"}],staticClass:"content2"},[a("div",{staticClass:"add"},[a("div",{staticClass:"header"},[a("span",{staticStyle:{float:"left"}},[t._v("新增试验项")]),t._v(" "),a("span",{staticStyle:{float:"right",cursor:"pointer"},on:{click:t.show}},[t._v("X")])]),t._v(" "),a("div",{staticClass:"zhong",staticStyle:{"margin-top":"50px","margin-left":"100px","text-align":"left",width:"500px"}},[a("el-form",{attrs:{model:t.form}},[a("el-form-item",{staticStyle:{"margin-top":"32px"},attrs:{label:"试验项名称：","label-width":t.formLabelWidth}},[a("el-input",{attrs:{placeholder:"请输入",id:"itemsName"},model:{value:t.form.name,callback:function(e){t.$set(t.form,"name",e)},expression:"form.name"}})],1),t._v(" "),a("el-form-item",{staticStyle:{"margin-top":"32px"},attrs:{label:"显示排序：","label-width":t.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off",placeholder:"请输入",id:"sort"},model:{value:t.form.record,callback:function(e){t.$set(t.form,"record",e)},expression:"form.record"}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"margin-top":"32px"},attrs:{slot:"footer"},slot:"footer"},[a("div",{staticStyle:{float:"left"}},[a("el-button",{attrs:{type:"info"}},[t._v("新增检测项")])],1),t._v(" "),a("div",{staticStyle:{float:"right"}},[a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.additem(),t.show()}}},[t._v("保存")])],1)])],1)])]),t._v(" "),a("div",{staticClass:"inner"},[a("div",{staticClass:"inner_con"},[a("div",{staticClass:"inner_con_header"},[a("el-form",{staticClass:"demo-form-inline",attrs:{id:"el-form",inline:!0,model:t.formInline,"show-header":"true"}},[a("el-form-item",{attrs:{label:"模板名称："}},[a("el-input",{attrs:{placeholder:"请输入",id:"btn0"},model:{value:t.templateName1,callback:function(e){t.templateName1=e},expression:"templateName1"}})],1),t._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:t.search}},[t._v("查询")])],1),t._v(" "),a("el-form-item",[a("el-button",{on:{click:t.clearResult}},[t._v("重置")])],1),t._v(" "),a("el-form-item",{attrs:{id:"rt-btn"}},[a("el-button",{attrs:{type:"success"}},[a("router-link",{attrs:{to:"./moban"}},[t._v("+新增")])],1)],1)],1)],1),t._v(" "),a("div",{staticClass:"inner_con_main"},t._l(t.list,function(e){return a("div",{key:e.templateId,staticClass:"banner",staticStyle:{"margin-top":"10px"}},[a("div",{staticClass:"banner_top"},[a("div",{staticClass:"little_left"},[a("h4",[t._v(t._s(e.template.templateName))]),t._v(" "),a("p",[a("span",{staticClass:"gray"},[t._v("使用设备:")]),t._v(" "),a("span",[t._v(t._s(e.template.equipmentTypeId))])]),t._v(" "),t._m(0,!0),t._v(" "),a("p",[a("span",{staticClass:"gray"},[t._v("编制时间：")]),t._v(" "),a("span",[t._v(t._s(e.template.editorDate))])])]),t._v(" "),a("div",{staticClass:"little_right"},[a("ul",[a("a",{attrs:{href:"#"}},[a("li",{staticClass:"blue",on:{click:function(a){t.show(),t.getId1(e.template.templateId)}}},[t._v("新增实验项")])]),t._v(" "),a("a",{attrs:{href:"#"},on:{click:function(a){t.show2(),t.getId(e.template.templateId)}}},[a("li",{staticClass:"blue"},[t._v("修改")])]),t._v(" "),a("a",{staticClass:"del",attrs:{href:"#"},on:{click:function(a){return t.update(e.template.templateId)}}},[a("li",{staticClass:"red"},[t._v("删除")])])])])]),t._v(" "),a("div",{staticClass:"line"}),t._v(" "),a("div",{staticClass:"banner_bottom"},[a("span",{staticClass:"gray",staticStyle:{float:"left"}},[t._v("实验项:")]),t._v(" "),a("ul",{staticStyle:{float:"left","margin-left":"10px"}},t._l(e.items,function(e){return a("li",{key:e.templateId},[a("p",{staticClass:"close_rt"},[t._v(t._s(e.itemsName))]),t._v(" "),a("div",{staticClass:"right_span"},[a("span",{staticClass:"blue",on:{click:function(a){return t.paramMain(e.itemsId)}}},[t._v("参数配置")]),t._v(" "),a("span",{staticClass:"red",on:{click:function(a){return t.delitem(e.itemsId)}}},[t._v("删除")])])])}),0)])])}),0)])])])])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("p",[e("span",{staticClass:"gray"},[this._v("编制人:")]),this._v(" "),e("span",[this._v("张三")])])}]};var n=a("VU/8")(o,i,!1,function(t){a("daCu")},"data-v-ad51d5e2",null);e.default=n.exports},daCu:function(t,e){}});
//# sourceMappingURL=17.e38c92e2a81a09a45d76.js.map