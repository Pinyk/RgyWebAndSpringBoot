webpackJsonp([3],{f2uQ:function(e,t){},lz4Y:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=a("bOdI"),l=a.n(o),r=a("mvHQ"),n=a.n(r),s=a("Muz9"),i=a.n(s),p={name:"xinjian",data:function(){return{options:[{value:"水电厂"},{value:"火电厂"},{value:"风电厂"},{value:"气电厂"}],options1:[{value:"10L"},{value:"20L"},{value:"30L"},{value:"40L"}],options2:[{value:"特级"},{value:"1"},{value:"2"},{value:"3"}],options3:[{value:"陕西省"},{value:"山西省"},{value:"山东省"},{value:"湖北省"}],powerPlantType:"",generatorCapacity:"",voltageLevel:"",province:"",form:{powerPlantName:"",address:"",phone:"",postcode:""}}},methods:{dataPush:function(){if(this.form.powerPlantName&&this.form.address&&this.form.phone&&this.form.postcode&&this.powerPlantType&&this.generatorCapacity&&this.voltageLevel&&this.province){var e,t={powerPlantName:this.form.powerPlantName,powerPlantType:this.powerPlantType,generatorCapacity:this.generatorCapacity,voltageLevel:this.voltageLevel,province:this.province,address:this.form.address,phone:this.form.phone,postcode:this.form.postcode};localStorage.setItem("data",n()(t)),this.$router.push({path:"./dianchangguanli"}),i.a.post("http://127.0.0.1:8084/power/add",(e={address:this.form.address,powerPlantName:this.form.powerPlantName,powerPlantType:this.powerPlantType,generatorCapacity:this.generatorCapacity,voltageLevel:this.voltageLevel,province:this.province},l()(e,"address",this.form.address),l()(e,"phone",this.form.phone),l()(e,"postcode",this.form.postcode),e)).then(function(e){console.log(e)}).catch(function(e){console.log(e)})}else alert("请检查你输入的数据")}}},c={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"app"}},[a("div",{staticClass:"card1"},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"电厂名称"}},[a("el-input",{model:{value:e.form.powerPlantName,callback:function(t){e.$set(e.form,"powerPlantName",t)},expression:"form.powerPlantName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"电厂类型"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.powerPlantType,callback:function(t){e.powerPlantType=t},expression:"powerPlantType"}},e._l(e.options,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{"lable-width":"120px",label:"发电机组容量",width:"120"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.generatorCapacity,callback:function(t){e.generatorCapacity=t},expression:"generatorCapacity"}},e._l(e.options1,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{label:"升压站电压等级"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.voltageLevel,callback:function(t){e.voltageLevel=t},expression:"voltageLevel"}},e._l(e.options2,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{label:"所在省份"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.province,callback:function(t){e.province=t},expression:"province"}},e._l(e.options3,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{label:"电厂地址"}},[a("el-input",{model:{value:e.form.address,callback:function(t){e.$set(e.form,"address",t)},expression:"form.address"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"电话"}},[a("el-input",{model:{value:e.form.phone,callback:function(t){e.$set(e.form,"phone",t)},expression:"form.phone"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"邮编"}},[a("el-input",{model:{value:e.form.postcode,callback:function(t){e.$set(e.form,"postcode",t)},expression:"form.postcode"}})],1),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:e.dataPush}},[e._v("保存 ")])],1)],1)])},staticRenderFns:[]};var u=a("VU/8")(p,c,!1,function(e){a("f2uQ")},"data-v-4d099c3c",null);t.default=u.exports},mvHQ:function(e,t,a){e.exports={default:a("qkKv"),__esModule:!0}},qkKv:function(e,t,a){var o=a("FeBl"),l=o.JSON||(o.JSON={stringify:JSON.stringify});e.exports=function(e){return l.stringify.apply(l,arguments)}}});
//# sourceMappingURL=3.2969583bd8b49c5d1a0e.js.map