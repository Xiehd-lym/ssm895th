<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
	  style="background: transparent;"
    >  
     <el-row>
      <el-col :span="12">
        <el-form-item   v-if="flag=='hugong'"  label="护工工号" prop="hugonggonghao">
          <el-input v-model="ruleForm.hugonggonghao" readonly              placeholder="护工工号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='hugong'"  label="护工姓名" prop="hugongxingming">
          <el-input v-model="ruleForm.hugongxingming"               placeholder="护工姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='hugong'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in hugongxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="24">  
        <el-form-item v-if="flag=='hugong'" label="护工照片" prop="hugongzhaopian">
          <file-upload
          tip="点击上传护工照片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.hugongzhaopian?ruleForm.hugongzhaopian:''"
          @change="hugonghugongzhaopianUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='hugong'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="年龄" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='hugong'"  label="护工电话" prop="hugongdianhua">
          <el-input v-model="ruleForm.hugongdianhua"               placeholder="护工电话" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='hugong'"  label="民族" prop="minzu">
          <el-input v-model="ruleForm.minzu"               placeholder="民族" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='hugong'"  label="学历" prop="xueli">
          <el-input v-model="ruleForm.xueli"               placeholder="学历" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='hugong'"  label="婚否" prop="hunfou">
          <el-select v-model="ruleForm.hunfou"  placeholder="请选择婚否">
            <el-option
                v-for="(item,index) in hugonghunfouOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='hugong'"  label="护理级别" prop="hulijibie">
          <el-select v-model="ruleForm.hulijibie"  placeholder="请选择护理级别">
            <el-option
                v-for="(item,index) in hugonghulijibieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jiashu'"  label="家属账号" prop="jiashuzhanghao">
          <el-input v-model="ruleForm.jiashuzhanghao" readonly              placeholder="家属账号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jiashu'"  label="家属姓名" prop="jiashuxingming">
          <el-input v-model="ruleForm.jiashuxingming"               placeholder="家属姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='jiashu'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in jiashuxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jiashu'"  label="家属手机" prop="jiashushouji">
          <el-input v-model="ruleForm.jiashushouji"               placeholder="家属手机" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jiashu'"  label="身份证" prop="shenfenzheng">
          <el-input v-model="ruleForm.shenfenzheng"               placeholder="身份证" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='jiashu'"  label="家庭住址" prop="jiatingzhuzhi">
          <el-input v-model="ruleForm.jiatingzhuzhi"               placeholder="家庭住址" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-form-item v-if="flag=='users'" label="用户名" prop="username">
        <el-input v-model="ruleForm.username" 
        placeholder="用户名"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
      </el-form-item>
      </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      hugongxingbieOptions: [],
      hugonghunfouOptions: [],
      hugonghulijibieOptions: [],
      jiashuxingbieOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.hugongxingbieOptions = "男,女".split(',')
    this.hugonghunfouOptions = "未婚,已婚".split(',')
    this.hugonghulijibieOptions = "特级护理,一级护理,二级护理,三级护理".split(',')
    this.jiashuxingbieOptions = "男,女".split(',')
  },
  methods: {
    hugonghugongzhaopianUploadChange(fileUrls) {
        this.ruleForm.hugongzhaopian = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.hugonggonghao)&& 'hugong'==this.flag){
        this.$message.error('护工工号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'hugong'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.hugongxingming)&& 'hugong'==this.flag){
        this.$message.error('护工姓名不能为空');
        return
      }
        if(this.ruleForm.hugongzhaopian!=null) {
                this.ruleForm.hugongzhaopian = this.ruleForm.hugongzhaopian.replace(new RegExp(this.$base.url,"g"),"");
        }
      if( 'hugong' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
       this.$message.error(`年龄应输入整数`);
        return
      }
      if( 'hugong' ==this.flag && this.ruleForm.hugongdianhua&&(!isMobile(this.ruleForm.hugongdianhua))){
        this.$message.error(`护工电话应输入手机格式`);
        return
      }
      if((!this.ruleForm.hulijibie)&& 'hugong'==this.flag){
        this.$message.error('护理级别不能为空');
        return
      }
      if((!this.ruleForm.jiashuzhanghao)&& 'jiashu'==this.flag){
        this.$message.error('家属账号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'jiashu'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if( 'jiashu' ==this.flag && this.ruleForm.jiashushouji&&(!isMobile(this.ruleForm.jiashushouji))){
        this.$message.error(`家属手机应输入手机格式`);
        return
      }
      if( 'jiashu' ==this.flag && this.ruleForm.shenfenzheng&&(!checkIdCard(this.ruleForm.shenfenzheng))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
