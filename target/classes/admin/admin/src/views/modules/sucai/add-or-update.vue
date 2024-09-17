<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='yonghu'">
                    <el-form-item class="select" v-if="type!='info'"  label="用户" prop="yonghuId">
                        <el-select v-model="ruleForm.yonghuId" :disabled="ro.yonghuId" filterable placeholder="请选择用户" @change="yonghuChange">
                            <el-option
                                    v-for="(item,index) in yonghuOptions"
                                    v-bind:key="item.id"
                                    :label="item.yonghuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuName">
                        <el-input v-model="yonghuForm.yonghuName"
                                  placeholder="用户姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="用户姓名" prop="yonghuName">
                            <el-input v-model="ruleForm.yonghuName"
                                      placeholder="用户姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户手机号" prop="yonghuPhone">
                        <el-input v-model="yonghuForm.yonghuPhone"
                                  placeholder="用户手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="用户手机号" prop="yonghuPhone">
                            <el-input v-model="ruleForm.yonghuPhone"
                                      placeholder="用户手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24" v-if="sessionTable !='yonghu' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (yonghuForm.yonghuPhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.yonghuPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="yonghuId" name="yonghuId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="素材编号" prop="sucaiUuidNumber">
                       <el-input v-model="ruleForm.sucaiUuidNumber"
                                 placeholder="素材编号" clearable  :readonly="ro.sucaiUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="素材编号" prop="sucaiUuidNumber">
                           <el-input v-model="ruleForm.sucaiUuidNumber"
                                     placeholder="素材编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="素材名称" prop="sucaiName">
                       <el-input v-model="ruleForm.sucaiName"
                                 placeholder="素材名称" clearable  :readonly="ro.sucaiName"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="素材名称" prop="sucaiName">
                           <el-input v-model="ruleForm.sucaiName"
                                     placeholder="素材名称" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="素材类型" prop="sucaiTypes">
                        <el-select v-model="ruleForm.sucaiTypes" :disabled="ro.sucaiTypes" placeholder="请选择素材类型" @change="sucaiTypesChange">
                            <el-option
                                v-for="(item,index) in sucaiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="素材类型" prop="sucaiValue">
                        <el-input v-model="ruleForm.sucaiValue"
                            placeholder="素材类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="ruleForm.sucaiTypes != null && ruleForm.sucaiTypes != ''">
                    <el-form-item class="select" v-if="type!='info'"  label="二级类型" prop="sucaiErjiTypes">
                        <el-select v-model="ruleForm.sucaiErjiTypes" :disabled="ro.sucaiErjiTypes" placeholder="请选择二级类型">
                            <el-option
                                v-for="(item,index) in sucaiErjiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="二级类型" prop="sucaiErjiValue">
                        <el-input v-model="ruleForm.sucaiErjiValue"
                            placeholder="二级类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item class="upload" v-if="type!='info' && !ro.sucaiPhoto" label="素材照片" prop="sucaiPhoto">
                        <file-upload
                            tip="点击上传素材照片"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.sucaiPhoto?ruleForm.sucaiPhoto:''"
                            @change="sucaiPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.sucaiPhoto" label="素材照片" prop="sucaiPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.sucaiPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>



                <el-col :span="24" v-if="ruleForm.sucaiTypes ==3">
                    <el-form-item class="upload" v-if="type!='info' && !ro.sucaiZhanshiPhoto" label="素材展示照片" prop="sucaiZhanshiPhoto">
                        <file-upload
                            tip="点击上传素材展示照片"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.sucaiZhanshiPhoto?ruleForm.sucaiZhanshiPhoto:''"
                            @change="sucaiZhanshiPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.sucaiZhanshiPhoto" label="素材展示照片" prop="sucaiZhanshiPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.sucaiZhanshiPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24" v-if="ruleForm.sucaiTypes ==4 ||ruleForm.sucaiTypes ==5">
                    <el-form-item class="upload" v-if="type!='info' && !ro.sucaiVideo" label="素材展示视频" prop="sucaiVideo">
                        <file-upload
                            tip="点击上传素材展示视频"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.sucaiVideo?ruleForm.sucaiVideo:''"
                            @change="sucaiVideoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.sucaiVideo" label="素材展示视频" prop="sucaiVideo">
                            <video :src="ruleForm.sucaiVideo" width="100" height="100" controls="controls">
                            </video>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24" v-if="ruleForm.sucaiTypes ==1 ||ruleForm.sucaiTypes ==2">
                    <el-form-item class="upload" v-if="type!='info' && !ro.sucaiMusic" label="素材展示音频" prop="sucaiMusic">
                        <file-upload
                                tip="点击上传素材展示音频"
                                action="file/upload"
                                :limit="3"
                                :multiple="true"
                                :fileUrls="ruleForm.sucaiMusic?ruleForm.sucaiMusic:''"
                                @change="sucaiMusicUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.sucaiMusic" label="素材展示音频" prop="sucaiMusic">
                            <audio :src="ruleForm.sucaiMusic" controls="controls"  width="100" height="100">
                                您的浏览器不支持音频播放
                            </audio>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="素材原价" prop="sucaiOldMoney">
                       <el-input v-model="ruleForm.sucaiOldMoney"
                                 placeholder="素材原价" clearable  :readonly="ro.sucaiOldMoney"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="素材原价" prop="sucaiOldMoney">
                           <el-input v-model="ruleForm.sucaiOldMoney"
                                     placeholder="素材原价" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="现价" prop="sucaiNewMoney">
                       <el-input v-model="ruleForm.sucaiNewMoney"
                                 placeholder="现价" clearable  :readonly="ro.sucaiNewMoney"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="现价" prop="sucaiNewMoney">
                           <el-input v-model="ruleForm.sucaiNewMoney"
                                     placeholder="现价" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24" v-if="sessionTable != 'yonghu' || ( sessionTable == 'yonghu'&& type=='else')">
                    <el-form-item class="upload" v-if="type!='info' && !ro.sucaiFile" label="素材文件" prop="sucaiFile">
                        <file-upload
                                tip="点击上传素材文件"
                                action="file/upload"
                                :limit="3"
                                :multiple="true"
                                :fileUrls="ruleForm.sucaiFile?ruleForm.sucaiFile:''"
                                @change="sucaiFileUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.sucaiFile" label="素材文件" prop="sucaiFile">
                            <a type="text" style="text-decoration:none" class="el-button" :href="ruleForm.sucaiFile"  >素材文件下载</a>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="素材详细介绍" prop="sucaiContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.sucaiContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.sucaiContent" label="素材详细介绍" prop="sucaiContent">
                            <span v-html="ruleForm.sucaiContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                yonghuForm: {},
                ro:{
                    yonghuId: false,
                    sucaiUuidNumber: false,
                    sucaiName: false,
                    sucaiTypes: false,
                    sucaiErjiTypes: false,
                    sucaiPhoto: false,
                    sucaiZhanshiPhoto: false,
                    sucaiVideo: false,
                    sucaiMusic: false,
                    sucaiOldMoney: false,
                    sucaiNewMoney: false,
                    sucaiFile: false,
                    sucaiClicknum: false,
                    sucaiContent: false,
                    shangxiaTypes: false,
                    sucaiDelete: false,
                },
                ruleForm: {
                    yonghuId: '',
                    sucaiUuidNumber: new Date().getTime(),
                    sucaiName: '',
                    sucaiTypes: '',
                    sucaiErjiTypes: '',
                    sucaiPhoto: '',
                    sucaiZhanshiPhoto: '',
                    sucaiVideo: '',
                    sucaiMusic: '',
                    sucaiOldMoney: '',
                    sucaiNewMoney: '',
                    sucaiFile: '',
                    sucaiClicknum: '',
                    sucaiContent: '',
                    shangxiaTypes: '',
                    sucaiDelete: '',
                },
                sucaiTypesOptions : [],
                sucaiErjiTypesOptions : [],
                shangxiaTypesOptions : [],
                yonghuOptions : [],
                rules: {
                   yonghuId: [
                              { required: true, message: '用户不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   sucaiUuidNumber: [
                              { required: true, message: '素材编号不能为空', trigger: 'blur' },
                          ],
                   sucaiName: [
                              { required: true, message: '素材名称不能为空', trigger: 'blur' },
                          ],
                   sucaiTypes: [
                              { required: true, message: '素材类型不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   sucaiErjiTypes: [
                              { required: true, message: '二级类型不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   sucaiPhoto: [
                              { required: true, message: '素材照片不能为空', trigger: 'blur' },
                          ],
                   sucaiZhanshiPhoto: [
                              { required: true, message: '素材展示照片不能为空', trigger: 'blur' },
                          ],
                   sucaiVideo: [
                              { required: true, message: '素材展示视频不能为空', trigger: 'blur' },
                          ],
                   sucaiMusic: [
                              { required: true, message: '素材展示音频不能为空', trigger: 'blur' },
                          ],
                   sucaiOldMoney: [
                              { required: true, message: '素材原价不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   sucaiNewMoney: [
                              { required: true, message: '现价不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   sucaiFile: [
                              { required: true, message: '素材文件不能为空', trigger: 'blur' },
                          ],
                   sucaiClicknum: [
                              { required: true, message: '点击次数不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   sucaiContent: [
                              { required: true, message: '素材详细介绍不能为空', trigger: 'blur' },
                          ],
                   shangxiaTypes: [
                              { required: true, message: '是否上架不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   sucaiDelete: [
                              { required: true, message: '逻辑删除不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=sucai_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.sucaiTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=shangxia_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.shangxiaTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `yonghu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yonghuOptions = data.data.list;
            }
         });

        },
        mounted() {
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
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            yonghuChange(id){
                this.$http({
                    url: `yonghu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yonghuForm = data.data;
                    }
                });
            },
            //动态查询二级类型
            sucaiTypesChange(id){
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=sucai_erji_types&superId=${id}`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.ruleForm.sucaiErjiTypes = null;
                        this.sucaiErjiTypesOptions = data.data.list;
                    }
                });
            },
            //动态查询二级类型
            sucaiErjiTypesChange(id){
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=sucai_erji_types&superId=${id}`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.sucaiErjiTypesOptions = data.data.list;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `sucai/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.yonghuChange(data.data.yonghuId)
                        _this.sucaiErjiTypesChange(data.data.sucaiTypes);
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`sucai/${!this.ruleForm.id ? "save" : "update"}`,
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
                                        this.parent.sucaiCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
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
                this.parent.sucaiCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            sucaiPhotoUploadChange(fileUrls){
                this.ruleForm.sucaiPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },
            sucaiZhanshiPhotoUploadChange(fileUrls){
                this.ruleForm.sucaiZhanshiPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },
            sucaiVideoUploadChange(fileUrls){
                this.ruleForm.sucaiVideo = fileUrls;
                this.addEditUploadStyleChange()
            },
            sucaiMusicUploadChange(fileUrls){
                this.ruleForm.sucaiMusic = fileUrls;
                this.addEditUploadStyleChange()
            },
            sucaiFileUploadChange(fileUrls){
                this.ruleForm.sucaiFile = fileUrls;
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
}
.btn .el-button {
  padding: 0;
}</style>

