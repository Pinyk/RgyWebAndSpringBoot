webpackJsonp([29],{KrQR:function(t,e){},NRCc:function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a={name:"canshuKong",data:function(){return{isshow:!1,iptIsshow1:!1,iptIsshow2:!1,goBack:function(){history.back()},dialogTableVisible:!1,dialogFormVisible:!0,centerDialogVisible:!1,form:{name:"",radio:"",input:"",dingxing1:"",dingxing2:"",factory:"",equipment:"",module:""},formLabelWidth:"120px"}},methods:{show:function(){this.isshow=!this.isshow},dingxing1:function(){this.iptIsshow1=!0,this.iptIsshow2=!1},dingxing2:function(){this.iptIsshow2=!0,this.iptIsshow1=!1}}},s={render:function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{attrs:{id:"app"}},[i("div",{directives:[{name:"show",rawName:"v-show",value:t.isshow,expression:"isshow"}],staticClass:"content2"},[i("div",{staticClass:"add"},[i("div",{staticClass:"header"},[i("span",{staticStyle:{float:"left"}},[t._v("新增参数")]),t._v(" "),i("span",{staticStyle:{float:"right",cursor:"pointer"},on:{click:t.show}},[t._v("X")])]),t._v(" "),i("div",{staticClass:"zhong",staticStyle:{"margin-top":"50px","text-align":"left",width:"100%"}},[i("el-form",{attrs:{model:t.form}},[i("el-form-item",{attrs:{label:"试验电厂","label-width":t.formLabelWidth}},[i("el-select",{staticStyle:{width:"486px",height:"32px"},attrs:{placeholder:"请选择"},model:{value:t.form.factory,callback:function(e){t.$set(t.form,"factory",e)},expression:"form.factory"}},[i("el-option",{attrs:{label:"区域一",value:"shanghai"}}),t._v(" "),i("el-option",{attrs:{label:"区域二",value:"beijing"}})],1)],1),t._v(" "),i("el-form-item",{attrs:{label:"试验设备","label-width":t.formLabelWidth}},[i("el-select",{staticStyle:{width:"486px",height:"32px"},attrs:{placeholder:"请选择"},model:{value:t.form.equipment,callback:function(e){t.$set(t.form,"equipment",e)},expression:"form.equipment"}},[i("el-option",{attrs:{label:"区域一",value:"shanghai"}}),t._v(" "),i("el-option",{attrs:{label:"区域二",value:"beijing"}})],1)],1),t._v(" "),i("el-form-item",{attrs:{label:"报告模板","label-width":t.formLabelWidth}},[i("el-select",{staticStyle:{width:"486px",height:"32px"},attrs:{placeholder:"请选择"},model:{value:t.form.module,callback:function(e){t.$set(t.form,"module",e)},expression:"form.module"}},[i("el-option",{attrs:{label:"区域一",value:"shanghai"}}),t._v(" "),i("el-option",{attrs:{label:"区域二",value:"beijing"}})],1)],1)],1),t._v(" "),i("span",{staticClass:"dialog-footer",staticStyle:{display:"block","text-align":"center","margin-top":"40px"},attrs:{slot:"footer"},slot:"footer"},[i("router-link",{attrs:{to:"./testMessageList"}},[i("el-button",{attrs:{type:"primary"},on:{click:function(e){t.centerDialogVisible=!1}}},[t._v("保存")])],1)],1)],1)])]),t._v(" "),i("div",{staticClass:"header"},[i("div",{staticClass:"header_con"},[i("el-breadcrumb",{staticStyle:{"font-size":"16px"},attrs:{separator:"/"}},[i("el-breadcrumb-item",[t._v("报告管理")]),t._v(" "),i("el-breadcrumb-item",[i("label",{staticStyle:{color:"black"},attrs:{for:""}},[t._v("实验数据列表")])])],1),t._v(" "),i("router-link",{attrs:{to:"./reportAfteradd"}},[i("button",{on:{click:t.goBack}},[t._v("返回")])])],1)]),t._v(" "),i("div",{staticClass:"section"},[i("div",{staticClass:"section_con"},[i("div",{staticClass:"section_con_main"},[t._m(0),t._v(" "),i("button",{on:{click:t.show}},[t._v("录入实验数据")])])])])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"img"},[e("img",{attrs:{src:i("1mMx"),alt:""}})])}]};var l=i("VU/8")(a,s,!1,function(t){i("KrQR")},"data-v-115ee8c2",null);e.default=l.exports}});
//# sourceMappingURL=29.b17b80124f52208e6386.js.map