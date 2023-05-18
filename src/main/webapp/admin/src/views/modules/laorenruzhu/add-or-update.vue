<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row >
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'" label="入住编号" prop="ruzhubianhao">
            <el-input v-model="ruleForm.ruzhubianhao" 
                placeholder="入住编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.ruzhubianhao" label="入住编号" prop="ruzhubianhao">
              <el-input v-model="ruleForm.ruzhubianhao" 
                placeholder="入住编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="房间号" prop="fangjianhao">
          <el-input v-model="ruleForm.fangjianhao" 
              placeholder="房间号" clearable  :readonly="ro.fangjianhao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="房间号" prop="fangjianhao">
              <el-input v-model="ruleForm.fangjianhao" 
                placeholder="房间号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="楼房名称" prop="loufangmingcheng">
          <el-input v-model="ruleForm.loufangmingcheng" 
              placeholder="楼房名称" clearable  :readonly="ro.loufangmingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="楼房名称" prop="loufangmingcheng">
              <el-input v-model="ruleForm.loufangmingcheng" 
                placeholder="楼房名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="床位号" prop="chuangweihao">
          <el-input v-model="ruleForm.chuangweihao" 
              placeholder="床位号" clearable  :readonly="ro.chuangweihao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="床位号" prop="chuangweihao">
              <el-input v-model="ruleForm.chuangweihao" 
                placeholder="床位号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="老人姓名" prop="laorenxingming">
          <el-input v-model="ruleForm.laorenxingming" 
              placeholder="老人姓名" clearable  :readonly="ro.laorenxingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="老人姓名" prop="laorenxingming">
              <el-input v-model="ruleForm.laorenxingming" 
                placeholder="老人姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.laorenzhaopian" label="老人照片" prop="laorenzhaopian">
          <file-upload
          tip="点击上传老人照片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.laorenzhaopian?ruleForm.laorenzhaopian:''"
          @change="laorenzhaopianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.laorenzhaopian" label="老人照片" prop="laorenzhaopian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.laorenzhaopian.split(',')" :src="$base.url+item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="老人性别" prop="laorenxingbie">
          <el-select :disabled="ro.laorenxingbie" v-model="ruleForm.laorenxingbie" placeholder="请选择老人性别">
            <el-option
                v-for="(item,index) in laorenxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="老人性别" prop="laorenxingbie">
	      <el-input v-model="ruleForm.laorenxingbie"
                placeholder="老人性别" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="老人年龄" prop="laorennianling">
          <el-input v-model="ruleForm.laorennianling" 
              placeholder="老人年龄" clearable  :readonly="ro.laorennianling"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="老人年龄" prop="laorennianling">
              <el-input v-model="ruleForm.laorennianling" 
                placeholder="老人年龄" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'" label="家属账号" prop="jiashuzhanghao">
          <el-select :disabled="ro.jiashuzhanghao" @change="jiashuzhanghaoChange" v-model="ruleForm.jiashuzhanghao" placeholder="请选择家属账号">
            <el-option
                v-for="(item,index) in jiashuzhanghaoOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input"v-if="ruleForm.jiashuzhanghao" label="家属账号" prop="jiashuzhanghao">
              <el-input v-model="ruleForm.jiashuzhanghao" 
                placeholder="家属账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="家属姓名" prop="jiashuxingming">
          <el-input v-model="ruleForm.jiashuxingming" 
              placeholder="家属姓名" clearable  :readonly="ro.jiashuxingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="家属姓名" prop="jiashuxingming">
              <el-input v-model="ruleForm.jiashuxingming" 
                placeholder="家属姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="家属手机" prop="jiashushouji">
          <el-input v-model="ruleForm.jiashushouji" 
              placeholder="家属手机" clearable  :readonly="ro.jiashushouji"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="家属手机" prop="jiashushouji">
              <el-input v-model="ruleForm.jiashushouji" 
                placeholder="家属手机" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="关系" prop="guanxi">
          <el-input v-model="ruleForm.guanxi" 
              placeholder="关系" clearable  :readonly="ro.guanxi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="关系" prop="guanxi">
              <el-input v-model="ruleForm.guanxi" 
                placeholder="关系" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="护工工号" prop="hugonggonghao">
          <el-input v-model="ruleForm.hugonggonghao" 
              placeholder="护工工号" clearable  :readonly="ro.hugonggonghao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="护工工号" prop="hugonggonghao">
              <el-input v-model="ruleForm.hugonggonghao" 
                placeholder="护工工号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="护工姓名" prop="hugongxingming">
          <el-input v-model="ruleForm.hugongxingming" 
              placeholder="护工姓名" clearable  :readonly="ro.hugongxingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="护工姓名" prop="hugongxingming">
              <el-input v-model="ruleForm.hugongxingming" 
                placeholder="护工姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="入住时间" prop="ruzhushijian">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.ruzhushijian" 
                type="date"
                :readonly="ro.ruzhushijian"
                placeholder="入住时间">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.ruzhushijian" label="入住时间" prop="ruzhushijian">
              <el-input v-model="ruleForm.ruzhushijian" 
                placeholder="入住时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="退房状态" prop="tuifangzhuangtai">
          <el-select :disabled="ro.tuifangzhuangtai" v-model="ruleForm.tuifangzhuangtai" placeholder="请选择退房状态">
            <el-option
                v-for="(item,index) in tuifangzhuangtaiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="退房状态" prop="tuifangzhuangtai">
	      <el-input v-model="ruleForm.tuifangzhuangtai"
                placeholder="退房状态" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      </el-row>
      <el-form-item class="btn">
        <el-button  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"#fff","selectFontSize":"14px","btnCancelBorderColor":"rgba(234, 207, 164, 1)","inputBorderRadius":"4px","inputFontSize":"14px","textareaBgColor":"rgba(253, 253, 229, 1)","btnSaveFontSize":"14px","textareaBorderRadius":"4px","uploadBgColor":"rgba(253, 253, 229, 1)","textareaBorderStyle":"solid","btnCancelWidth":"100px","textareaHeight":"100px","dateBgColor":"rgba(253, 253, 229, 1)","btnSaveBorderRadius":"25px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"rgba(0, 0, 0, 1)","addEditBoxColor":"rgba(253, 253, 229, 0)","dateIconFontSize":"14px","btnSaveBgColor":"rgba(74, 50, 22, 1)","uploadIconFontColor":"rgba(74, 50, 22, 1)","textareaBorderColor":"rgba(74, 50, 22, 1)","btnCancelBgColor":"rgba(74, 50, 22, 1)","selectLableColor":"rgba(0, 0, 0, 1)","btnSaveBorderStyle":"solid","dateBorderWidth":"2px","dateLableFontSize":"14px","dateBorderRadius":"4px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"rgba(0, 0, 0, 1)","btnCancelHeight":"45px","inputHeight":"45px","btnCancelFontColor":"rgba(255, 255, 255, 1)","dateBorderColor":"rgba(74, 50, 22, 1)","dateIconFontColor":"rgba(0, 0, 0, 1)","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"rgba(0, 0, 0, 1)","dateFontSize":"14px","inputBorderWidth":"2px","uploadIconFontSize":"28px","selectHeight":"45px","inputFontColor":"rgba(0, 0, 0, 1)","uploadHeight":"148px","textareaLableColor":"rgba(0, 0, 0, 1)","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"25px","inputBgColor":"rgba(253, 253, 229, 1)","inputLableFontSize":"14px","uploadLableColor":"rgba(0, 0, 0, 1)","uploadBorderRadius":"4px","btnSaveHeight":"45px","selectBgColor":"rgba(253, 253, 229, 1)","btnSaveWidth":"100px","selectIconFontSize":"14px","dateHeight":"46px","selectBorderColor":"rgba(74, 50, 22, 1)","inputBorderColor":"rgba(74, 50, 22, 1)","uploadBorderColor":"rgba(74, 50, 22, 1)","textareaFontColor":"rgba(0, 0, 0, 1)","selectBorderWidth":"2px","dateFontColor":"rgba(0, 0, 0, 1)","btnCancelBorderWidth":"4px","uploadBorderWidth":"2px","textareaFontSize":"14px","selectBorderRadius":"4px","selectFontColor":"rgba(0, 0, 0, 1)","btnSaveBorderColor":"rgba(234, 207, 164, 1)","btnSaveBorderWidth":"4px"},
      id: '',
      type: '',
      ro:{
	ruzhubianhao : false,
	fangjianhao : false,
	loufangmingcheng : false,
	chuangweihao : false,
	laorenxingming : false,
	laorenzhaopian : false,
	laorenxingbie : false,
	laorennianling : false,
	jiashuzhanghao : false,
	jiashuxingming : false,
	jiashushouji : false,
	guanxi : false,
	hugonggonghao : false,
	hugongxingming : false,
	ruzhushijian : false,
	tuifangzhuangtai : false,
      },
      ruleForm: {
        ruzhubianhao: this.getUUID(),
        fangjianhao: '',
        loufangmingcheng: '',
        chuangweihao: '',
        laorenxingming: '',
        laorenzhaopian: '',
        laorenxingbie: '',
        laorennianling: '',
        jiashuzhanghao: '',
        jiashuxingming: '',
        jiashushouji: '',
        guanxi: '',
        hugonggonghao: '',
        hugongxingming: '',
        ruzhushijian: '',
       tuifangzhuangtai: '未退房',
      },
          laorenxingbieOptions: [],
          jiashuzhanghaoOptions: [],
          tuifangzhuangtaiOptions: [],
      rules: {
          ruzhubianhao: [
          ],
          fangjianhao: [
          ],
          loufangmingcheng: [
          ],
          chuangweihao: [
          ],
          laorenxingming: [
          ],
          laorenzhaopian: [
          ],
          laorenxingbie: [
          ],
          laorennianling: [
          ],
          jiashuzhanghao: [
          ],
          jiashuxingming: [
          ],
          jiashushouji: [
          ],
          guanxi: [
          ],
          hugonggonghao: [
          ],
          hugongxingming: [
          ],
          ruzhushijian: [
          ],
          tuifangzhuangtai: [
          ],
      }
    };
  },
  props: ["parent"],
  computed: {



  },
  created() {
	this.ruleForm.ruzhushijian = this.getCurDate()
	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='logistics'){
        this.logistics=false;
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          if(o=='ruzhubianhao'){
            this.ruleForm.ruzhubianhao = obj[o];
	    this.ro.ruzhubianhao = true;
            continue;
          }
          if(o=='fangjianhao'){
            this.ruleForm.fangjianhao = obj[o];
	    this.ro.fangjianhao = true;
            continue;
          }
          if(o=='loufangmingcheng'){
            this.ruleForm.loufangmingcheng = obj[o];
	    this.ro.loufangmingcheng = true;
            continue;
          }
          if(o=='chuangweihao'){
            this.ruleForm.chuangweihao = obj[o];
	    this.ro.chuangweihao = true;
            continue;
          }
          if(o=='laorenxingming'){
            this.ruleForm.laorenxingming = obj[o];
	    this.ro.laorenxingming = true;
            continue;
          }
          if(o=='laorenzhaopian'){
            this.ruleForm.laorenzhaopian = obj[o];
	    this.ro.laorenzhaopian = true;
            continue;
          }
          if(o=='laorenxingbie'){
            this.ruleForm.laorenxingbie = obj[o];
	    this.ro.laorenxingbie = true;
            continue;
          }
          if(o=='laorennianling'){
            this.ruleForm.laorennianling = obj[o];
	    this.ro.laorennianling = true;
            continue;
          }
          if(o=='jiashuzhanghao'){
            this.ruleForm.jiashuzhanghao = obj[o];
	    this.ro.jiashuzhanghao = true;
            continue;
          }
          if(o=='jiashuxingming'){
            this.ruleForm.jiashuxingming = obj[o];
	    this.ro.jiashuxingming = true;
            continue;
          }
          if(o=='jiashushouji'){
            this.ruleForm.jiashushouji = obj[o];
	    this.ro.jiashushouji = true;
            continue;
          }
          if(o=='guanxi'){
            this.ruleForm.guanxi = obj[o];
	    this.ro.guanxi = true;
            continue;
          }
          if(o=='hugonggonghao'){
            this.ruleForm.hugonggonghao = obj[o];
	    this.ro.hugonggonghao = true;
            continue;
          }
          if(o=='hugongxingming'){
            this.ruleForm.hugongxingming = obj[o];
	    this.ro.hugongxingming = true;
            continue;
          }
          if(o=='ruzhushijian'){
            this.ruleForm.ruzhushijian = obj[o];
	    this.ro.ruzhushijian = true;
            continue;
          }
          if(o=='tuifangzhuangtai'){
            this.ruleForm.tuifangzhuangtai = obj[o];
	    this.ro.tuifangzhuangtai = true;
            continue;
          }
        }
      }
      // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
		if(json.hugonggonghao!=''&&json.hugonggonghao){
                this.ruleForm.hugonggonghao = json.hugonggonghao
	    		this.ro.hugonggonghao = true;
		}
		if(json.hugongxingming!=''&&json.hugongxingming){
                this.ruleForm.hugongxingming = json.hugongxingming
	    		this.ro.hugongxingming = true;
		}
		if(this.$storage.get("role")!="管理员") {
			this.ro.tuifangzhuangtai = true;
		}
        } else {
          this.$message.error(data.msg);
        }
      });
            this.laorenxingbieOptions = "男,女".split(',')
            this.$http({
              url: `option/jiashu/jiashuzhanghao`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.jiashuzhanghaoOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
            this.tuifangzhuangtaiOptions = "已退房,未退房".split(',')
    },
    // 下二随
    jiashuzhanghaoChange () {
      this.$http({
        url: `follow/jiashu/jiashuzhanghao?columnValue=`+ this.ruleForm.jiashuzhanghao,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
              if(data.data.jiashuxingming){
                this.ruleForm.jiashuxingming = data.data.jiashuxingming
              }
              if(data.data.jiashushouji){
                this.ruleForm.jiashushouji = data.data.jiashushouji
              }
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    // 多级联动参数
    info(id) {
      this.$http({
        url: `laorenruzhu/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
	//解决前台上传图片后台不显示的问题
	let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {












	if(this.ruleForm.laorenzhaopian!=null) {
		this.ruleForm.laorenzhaopian = this.ruleForm.laorenzhaopian.replace(new RegExp(this.$base.url,"g"),"");
	}





















var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(!statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "laorenruzhu/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `laorenruzhu/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.laorenruzhuCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `laorenruzhu/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.laorenruzhuCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.laorenruzhuCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    laorenzhaopianUploadChange(fileUrls) {
	this.ruleForm.laorenzhaopian = fileUrls;
	this.addEditUploadStyleChange()
    },
	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}
</style>
