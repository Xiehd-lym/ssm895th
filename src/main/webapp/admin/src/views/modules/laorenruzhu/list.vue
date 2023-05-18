<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-row  :gutter="20" class="slt" :style="{justifyContent:contents.searchBoxPosition=='1'?'flex-start':contents.searchBoxPosition=='2'?'center':'flex-end'}">
                <el-form-item :label="contents.inputTitle == 1 ? '入住编号' : ''">
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" prefix-icon="el-icon-search" v-model="searchForm.ruzhubianhao" placeholder="入住编号" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" suffix-icon="el-icon-search" v-model="searchForm.ruzhubianhao" placeholder="入住编号" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 0" v-model="searchForm.ruzhubianhao" placeholder="入住编号" clearable></el-input>
                </el-form-item>
                <el-form-item :label="contents.inputTitle == 1 ? '房间号' : ''">
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" prefix-icon="el-icon-search" v-model="searchForm.fangjianhao" placeholder="房间号" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" suffix-icon="el-icon-search" v-model="searchForm.fangjianhao" placeholder="房间号" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 0" v-model="searchForm.fangjianhao" placeholder="房间号" clearable></el-input>
                </el-form-item>
                <el-form-item :label="contents.inputTitle == 1 ? '老人姓名' : ''">
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" prefix-icon="el-icon-search" v-model="searchForm.laorenxingming" placeholder="老人姓名" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" suffix-icon="el-icon-search" v-model="searchForm.laorenxingming" placeholder="老人姓名" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 0" v-model="searchForm.laorenxingming" placeholder="老人姓名" clearable></el-input>
                </el-form-item>
                <el-form-item :label="contents.inputTitle == 1 ? '护工姓名' : ''">
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" prefix-icon="el-icon-search" v-model="searchForm.hugongxingming" placeholder="护工姓名" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" suffix-icon="el-icon-search" v-model="searchForm.hugongxingming" placeholder="护工姓名" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 0" v-model="searchForm.hugongxingming" placeholder="护工姓名" clearable></el-input>
                </el-form-item>
		<el-form-item class="select" label="退房状态" prop="tuifangzhuangtai">
		  <el-select  @change="tuifangzhuangtaiChange" clearable v-model="searchForm.tuifangzhuangtai" placeholder="请选择退房状态">
		    <el-option
			v-for="(item,index) in tuifangzhuangtaiOptions"
			v-bind:key="index"
			:label="item"
			:value="item">
		    </el-option>
		  </el-select>
		</el-form-item>
          <el-form-item>
            <el-button v-if="contents.searchBtnIcon == 1 && contents.searchBtnIconPosition == 1" icon="el-icon-search" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}</el-button>
            <el-button v-if="contents.searchBtnIcon == 1 && contents.searchBtnIconPosition == 2" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}<i class="el-icon-search el-icon--right"/></el-button>
            <el-button v-if="contents.searchBtnIcon == 0" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}</el-button>
          </el-form-item>
        </el-row>

        <el-row class="ad" :style="{justifyContent:contents.btnAdAllBoxPosition=='1'?'flex-start':contents.btnAdAllBoxPosition=='2'?'center':'flex-end'}">
          <el-form-item>
            <el-button
              v-if="isAuth('laorenruzhu','新增') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1"
              type="success"
              icon="el-icon-plus"
              @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1?'新增':'' }}</el-button>
            <el-button
              v-if="isAuth('laorenruzhu','新增') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2"
              type="success"
              @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1?'新增':'' }}<i class="el-icon-plus el-icon--right" /></el-button>
            <el-button
              v-if="isAuth('laorenruzhu','新增') && contents.btnAdAllIcon == 0"
              type="success"
              @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1?'新增':'' }}</el-button>
            <el-button
              v-if="isAuth('laorenruzhu','删除') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1 && contents.tableSelection"
              :disabled="dataListSelections.length <= 0"
              type="danger"
              icon="el-icon-delete"
              @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1?'删除':'' }}</el-button>
            <el-button
              v-if="isAuth('laorenruzhu','删除') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2 && contents.tableSelection"
              :disabled="dataListSelections.length <= 0"
              type="danger"
              @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1?'删除':'' }}<i class="el-icon-delete el-icon--right" /></el-button>
            <el-button
              v-if="isAuth('laorenruzhu','删除') && contents.btnAdAllIcon == 0 && contents.tableSelection"
              :disabled="dataListSelections.length <= 0"
              type="danger"
              @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1?'删除':'' }}</el-button>




            <el-button
              v-if="isAuth('laorenruzhu','报表') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1"
              type="warning"
              icon="el-icon-s-data"
              @click="chartDialog()"
            >{{ contents.btnAdAllFont == 1?'统计报表':'' }}</el-button>
            <el-button
              v-if="isAuth('laorenruzhu','报表') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2"
              type="warning"
              @click="chartDialog()"
            >{{ contents.btnAdAllFont == 1?'统计报表':'' }}<i class="el-icon-s-data el-icon--right" /></el-button>
            <el-button
              v-if="isAuth('laorenruzhu','报表') && contents.btnAdAllIcon == 0"
              type="warning"
              @click="chartDialog()"
            >{{ contents.btnAdAllFont == 1?'统计报表':'' }}</el-button>

          </el-form-item>
        </el-row>
      </el-form>
      <div class="table-content">
        <el-table class="tables" :size="contents.tableSize" :show-header="contents.tableShowHeader"
            :header-row-style="headerRowStyle" :header-cell-style="headerCellStyle"
            :border="contents.tableBorder"
            :fit="contents.tableFit"
            :stripe="contents.tableStripe"
            :style="{width: '100%',fontSize:contents.tableContentFontSize,color:contents.tableContentFontColor}"
            v-if="isAuth('laorenruzhu','查看')"
            :data="dataList"
            v-loading="dataListLoading"
            @selection-change="selectionChangeHandler">
            <el-table-column  v-if="contents.tableSelection"
                type="selection"
                :header-align="contents.tableAlign"
                align="center"
                width="50">
            </el-table-column>
            <el-table-column label="索引" :align="contents.tableAlign"  v-if="contents.tableIndex" type="index" width="50" />
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="ruzhubianhao"
                   :header-align="contents.tableAlign"
		    label="入住编号">
		     <template slot-scope="scope">
                       {{scope.row.ruzhubianhao}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="fangjianhao"
                   :header-align="contents.tableAlign"
		    label="房间号">
		     <template slot-scope="scope">
                       {{scope.row.fangjianhao}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="loufangmingcheng"
                   :header-align="contents.tableAlign"
		    label="楼房名称">
		     <template slot-scope="scope">
                       {{scope.row.loufangmingcheng}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="chuangweihao"
                   :header-align="contents.tableAlign"
		    label="床位号">
		     <template slot-scope="scope">
                       {{scope.row.chuangweihao}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="laorenxingming"
                   :header-align="contents.tableAlign"
		    label="老人姓名">
		     <template slot-scope="scope">
                       {{scope.row.laorenxingming}}
                     </template>
                </el-table-column>
                  <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign"  prop="laorenzhaopian"
                   :header-align="contents.tableAlign"
                    width="200"
                    label="老人照片">
                    <template slot-scope="scope">
                      <div v-if="scope.row.laorenzhaopian">
                        <img :src="$base.url+scope.row.laorenzhaopian.split(',')[0]" width="100" height="100">
                      </div>
                      <div v-else>无图片</div>
                    </template>
                  </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="laorenxingbie"
                   :header-align="contents.tableAlign"
		    label="老人性别">
		     <template slot-scope="scope">
                       {{scope.row.laorenxingbie}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="laorennianling"
                   :header-align="contents.tableAlign"
		    label="老人年龄">
		     <template slot-scope="scope">
                       {{scope.row.laorennianling}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="jiashuzhanghao"
                   :header-align="contents.tableAlign"
		    label="家属账号">
		     <template slot-scope="scope">
                       {{scope.row.jiashuzhanghao}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="jiashuxingming"
                   :header-align="contents.tableAlign"
		    label="家属姓名">
		     <template slot-scope="scope">
                       {{scope.row.jiashuxingming}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="jiashushouji"
                   :header-align="contents.tableAlign"
		    label="家属手机">
		     <template slot-scope="scope">
                       {{scope.row.jiashushouji}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="guanxi"
                   :header-align="contents.tableAlign"
		    label="关系">
		     <template slot-scope="scope">
                       {{scope.row.guanxi}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="hugonggonghao"
                   :header-align="contents.tableAlign"
		    label="护工工号">
		     <template slot-scope="scope">
                       {{scope.row.hugonggonghao}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="hugongxingming"
                   :header-align="contents.tableAlign"
		    label="护工姓名">
		     <template slot-scope="scope">
                       {{scope.row.hugongxingming}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="ruzhushijian"
                   :header-align="contents.tableAlign"
		    label="入住时间">
		     <template slot-scope="scope">
                       {{scope.row.ruzhushijian}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="tuifangzhuangtai"
                   :header-align="contents.tableAlign"
		    label="退房状态">
		     <template slot-scope="scope">
                       {{scope.row.tuifangzhuangtai}}
                     </template>
                </el-table-column>
            <el-table-column width="300" :align="contents.tableAlign" 
               :header-align="contents.tableAlign"
                label="操作">
                <template slot-scope="scope">
                <el-button v-if="isAuth('laorenruzhu','查看') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1?'详情':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','查看') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1?'详情':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('laorenruzhu','查看') && contents.tableBtnIcon == 0" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1?'详情':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','档案') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="laorendanganCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'档案':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','档案') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="laorendanganCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'档案':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('laorenruzhu','档案') && contents.tableBtnIcon == 0" type="success" size="mini" @click="laorendanganCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'档案':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','身体') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="shentizhuangkuangCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'身体':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','身体') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="shentizhuangkuangCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'身体':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('laorenruzhu','身体') && contents.tableBtnIcon == 0" type="success" size="mini" @click="shentizhuangkuangCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'身体':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','用药') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="yongyaoqingkuangCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'用药':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','用药') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="yongyaoqingkuangCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'用药':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('laorenruzhu','用药') && contents.tableBtnIcon == 0" type="success" size="mini" @click="yongyaoqingkuangCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'用药':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','外出') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="waichudengjiCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'外出':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','外出') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="waichudengjiCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'外出':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('laorenruzhu','外出') && contents.tableBtnIcon == 0" type="success" size="mini" @click="waichudengjiCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'外出':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','转房') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="zhuanfangdengjiCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'转房':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','转房') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="zhuanfangdengjiCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'转房':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('laorenruzhu','转房') && contents.tableBtnIcon == 0" type="success" size="mini" @click="zhuanfangdengjiCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'转房':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','退房') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="tuifangdengjiCrossAddOrUpdateHandler(scope.row,'cross','','tuifangzhuangtai','已经退房了','已退房,未退房'.split(',')[0])">{{ contents.tableBtnFont == 1?'退房':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','退房') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="tuifangdengjiCrossAddOrUpdateHandler(scope.row,'cross','','tuifangzhuangtai','已经退房了','已退房,未退房'.split(',')[0])">{{ contents.tableBtnFont == 1?'退房':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('laorenruzhu','退房') && contents.tableBtnIcon == 0" type="success" size="mini" @click="tuifangdengjiCrossAddOrUpdateHandler(scope.row,'cross','','tuifangzhuangtai','已经退房了','已退房,未退房'.split(',')[0])">{{ contents.tableBtnFont == 1?'退房':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','缴费') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="richangjiaofeiCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'缴费':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','缴费') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="richangjiaofeiCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'缴费':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('laorenruzhu','缴费') && contents.tableBtnIcon == 0" type="success" size="mini" @click="richangjiaofeiCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'缴费':'' }}</el-button>
                <el-button v-if=" isAuth('laorenruzhu','修改') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="primary" icon="el-icon-edit" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}</el-button>
                <el-button v-if=" isAuth('laorenruzhu','修改') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}<i class="el-icon-edit el-icon--right" /></el-button>
                <el-button v-if=" isAuth('laorenruzhu','修改') && contents.tableBtnIcon == 0" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}</el-button>




                <el-button v-if="isAuth('laorenruzhu','删除') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="danger" icon="el-icon-delete" size="mini" @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'删除':'' }}</el-button>
                <el-button v-if="isAuth('laorenruzhu','删除') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="danger" size="mini" @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'删除':'' }}<i class="el-icon-delete el-icon--right" /></el-button>
                <el-button v-if="isAuth('laorenruzhu','删除') && contents.tableBtnIcon == 0" type="danger" size="mini" @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'删除':'' }}</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
          clsss="pages"
          :layout="layouts"
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="Number(contents.pageEachNum)"
          :total="totalPage"
          :small="contents.pageStyle"
          class="pagination-content"
          :background="contents.pageBtnBG"
          :style="{textAlign:contents.pagePosition==1?'left':contents.pagePosition==2?'center':'right'}"
        ></el-pagination>
      </div>
    </div>
    <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
    <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

    <laorendangan-cross-add-or-update v-if="laorendanganCrossAddOrUpdateFlag" :parent="this" ref="laorendanganCrossaddOrUpdate"></laorendangan-cross-add-or-update>
    <shentizhuangkuang-cross-add-or-update v-if="shentizhuangkuangCrossAddOrUpdateFlag" :parent="this" ref="shentizhuangkuangCrossaddOrUpdate"></shentizhuangkuang-cross-add-or-update>
    <yongyaoqingkuang-cross-add-or-update v-if="yongyaoqingkuangCrossAddOrUpdateFlag" :parent="this" ref="yongyaoqingkuangCrossaddOrUpdate"></yongyaoqingkuang-cross-add-or-update>
    <waichudengji-cross-add-or-update v-if="waichudengjiCrossAddOrUpdateFlag" :parent="this" ref="waichudengjiCrossaddOrUpdate"></waichudengji-cross-add-or-update>
    <zhuanfangdengji-cross-add-or-update v-if="zhuanfangdengjiCrossAddOrUpdateFlag" :parent="this" ref="zhuanfangdengjiCrossaddOrUpdate"></zhuanfangdengji-cross-add-or-update>
    <tuifangdengji-cross-add-or-update v-if="tuifangdengjiCrossAddOrUpdateFlag" :parent="this" ref="tuifangdengjiCrossaddOrUpdate"></tuifangdengji-cross-add-or-update>
    <richangjiaofei-cross-add-or-update v-if="richangjiaofeiCrossAddOrUpdateFlag" :parent="this" ref="richangjiaofeiCrossaddOrUpdate"></richangjiaofei-cross-add-or-update>




    <el-dialog
      title="统计报表"
      :visible.sync="chartVisiable"
      width="800">
        <div id="tuifangzhuangtaiChart" style="width:100%;height:600px;"></div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="chartDialog">返回</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
import laorendanganCrossAddOrUpdate from "../laorendangan/add-or-update";
import shentizhuangkuangCrossAddOrUpdate from "../shentizhuangkuang/add-or-update";
import yongyaoqingkuangCrossAddOrUpdate from "../yongyaoqingkuang/add-or-update";
import waichudengjiCrossAddOrUpdate from "../waichudengji/add-or-update";
import zhuanfangdengjiCrossAddOrUpdate from "../zhuanfangdengji/add-or-update";
import tuifangdengjiCrossAddOrUpdate from "../tuifangdengji/add-or-update";
import richangjiaofeiCrossAddOrUpdate from "../richangjiaofei/add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form:{},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      addOrUpdateFlag:false,
      laorendanganCrossAddOrUpdateFlag: false,
      shentizhuangkuangCrossAddOrUpdateFlag: false,
      yongyaoqingkuangCrossAddOrUpdateFlag: false,
      waichudengjiCrossAddOrUpdateFlag: false,
      zhuanfangdengjiCrossAddOrUpdateFlag: false,
      tuifangdengjiCrossAddOrUpdateFlag: false,
      richangjiaofeiCrossAddOrUpdateFlag: false,
      contents:{"searchBtnFontColor":"rgba(0, 0, 0, 1)","pagePosition":"2","inputFontSize":"14px","inputBorderRadius":"5px","tableBtnDelFontColor":"rgba(0, 0, 0, 1)","tableBtnIconPosition":"1","searchBtnHeight":"40px","tableBgColor":"rgba(253, 253, 229, 1)","inputIconColor":"rgba(0, 0, 0, 1)","searchBtnBorderRadius":"5px","tableStripe":true,"btnAdAllWarnFontColor":"rgba(74, 50, 22, 1)","tableBtnDelBgColor":"rgba(234, 207, 164, 1)","searchBtnIcon":"1","tableSize":"medium","searchBtnBorderStyle":"solid","text":{"padding":"0px 0px 0px 0px","boxShadow":"0 0 0px rgba(0,0,0,.1)","margin":"10px  auto","borderColor":"rgba(0,0,0,.3)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(74, 50, 22, 1)","borderRadius":"0","borderWidth":"0","width":"800px","lineHeight":"60px","fontSize":"30px","borderStyle":"solid"},"tableSelection":true,"searchBtnBorderWidth":"0","tableContentFontSize":"14px","searchBtnBgColor":"rgba(234, 207, 164, 1)","inputTitleSize":"15px","btnAdAllBorderColor":"rgba(74, 50, 22, 1)","pageJumper":true,"btnAdAllIconPosition":"1","searchBoxPosition":"1","tableBtnDetailFontColor":"rgba(2, 0, 0, 1)","tableBtnHeight":"40px","pagePager":true,"searchBtnBorderColor":"rgba(74, 50, 22, 1)","tableHeaderFontColor":"rgba(255, 255, 255, 1)","inputTitle":"1","tableBtnBorderRadius":"5px","btnAdAllFont":"1","btnAdAllDelFontColor":"rgba(74, 50, 22, 1)","tableBtnIcon":"1","btnAdAllHeight":"40px","btnAdAllWarnBgColor":"rgba(255, 255, 255, 0)","btnAdAllBorderWidth":"0","tableStripeFontColor":"rgba(0, 0, 0, 1)","tableBtnBorderStyle":"solid","inputHeight":"40px","btnAdAllBorderRadius":"5px","btnAdAllDelBgColor":"rgba(255, 255, 255, 0)","pagePrevNext":true,"btnAdAllAddBgColor":"rgba(255, 255, 255, 0)","searchBtnFont":"1","tableIndex":true,"btnAdAllIcon":"1","tableSortable":false,"pageSizes":true,"tableFit":true,"pageBtnBG":true,"searchBtnFontSize":"14px","tableBtnEditBgColor":"rgba(234, 207, 164, 1)","box":{"padding":"12px 0px 0px 0px","boxShadow":"0 0 6px rgba(0,0,0,0)","flag":"2","backgroundImage":"","background":"rgba(253, 253, 229, 1)"},"inputBorderWidth":"0","inputFontPosition":"2","inputFontColor":"rgba(0, 0, 0, 1)","pageEachNum":10,"tableHeaderBgColor":"rgba(74, 50, 22, 1)","inputTitleColor":"rgba(0, 0, 0, 1)","btnAdAllBoxPosition":"1","tableBtnDetailBgColor":"rgba(234, 207, 164, 1)","inputIcon":"1","searchBtnIconPosition":"1","btnAdAllFontSize":"16px","inputBorderStyle":"solid","tableHoverFontColor":"#333","inputBgColor":"rgba(234, 207, 164, 1)","pageStyle":false,"pageTotal":true,"btnAdAllAddFontColor":"rgba(74, 50, 22, 1)","tableBtnFont":"1","tableContentFontColor":"rgba(0, 0, 0, 1)","inputBorderColor":"rgba(74, 50, 22, 1)","tableShowHeader":true,"tableHoverBgColor":"rgba(234, 207, 164, 1)","tableBtnFontSize":"15px","tableBtnBorderColor":"rgba(0, 0, 0, 1)","inputIconPosition":"1","tableBorder":true,"btnAdAllBorderStyle":"solid","tableBtnBorderWidth":"6px 0px 6px 0px","tableStripeBgColor":"rgba(253, 253, 229, 1)","tableBtnEditFontColor":"rgba(0, 0, 0, 1)","tableAlign":"center"},
      layouts: '',


    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {

  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
    laorendanganCrossAddOrUpdate,
    shentizhuangkuangCrossAddOrUpdate,
    yongyaoqingkuangCrossAddOrUpdate,
    waichudengjiCrossAddOrUpdate,
    zhuanfangdengjiCrossAddOrUpdate,
    tuifangdengjiCrossAddOrUpdate,
    richangjiaofeiCrossAddOrUpdate,
  },
  methods: {

    contentStyleChange() {
      this.contentSearchStyleChange()
      this.contentBtnAdAllStyleChange()
      this.contentSearchBtnStyleChange()
      this.contentTableBtnStyleChange()
      this.contentPageStyleChange()
    },
    contentSearchStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .slt .el-input__inner').forEach(el=>{
          let textAlign = 'left'
          if(this.contents.inputFontPosition == 2) textAlign = 'center'
          if(this.contents.inputFontPosition == 3) textAlign = 'right'
          el.style.textAlign = textAlign
          el.style.height = this.contents.inputHeight
          el.style.lineHeight = this.contents.inputHeight
          el.style.color = this.contents.inputFontColor
          el.style.fontSize = this.contents.inputFontSize
          el.style.borderWidth = this.contents.inputBorderWidth
          el.style.borderStyle = this.contents.inputBorderStyle
          el.style.borderColor = this.contents.inputBorderColor
          el.style.borderRadius = this.contents.inputBorderRadius
          el.style.backgroundColor = this.contents.inputBgColor
        })
        if(this.contents.inputTitle) {
          document.querySelectorAll('.form-content .slt .el-form-item__label').forEach(el=>{
            el.style.color = this.contents.inputTitleColor
            el.style.fontSize = this.contents.inputTitleSize
            el.style.lineHeight = this.contents.inputHeight
          })
        }
        setTimeout(()=>{
          document.querySelectorAll('.form-content .slt .el-input__prefix').forEach(el=>{
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__suffix').forEach(el=>{
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__icon').forEach(el=>{
            el.style.lineHeight = this.contents.inputHeight
          })
        },10)

      })
    },
    // 搜索按钮
    contentSearchBtnStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .slt .el-button--success').forEach(el=>{
          el.style.height = this.contents.searchBtnHeight
          el.style.color = this.contents.searchBtnFontColor
          el.style.fontSize = this.contents.searchBtnFontSize
          el.style.borderWidth = this.contents.searchBtnBorderWidth
          el.style.borderStyle = this.contents.searchBtnBorderStyle
          el.style.borderColor = this.contents.searchBtnBorderColor
          el.style.borderRadius = this.contents.searchBtnBorderRadius
          el.style.backgroundColor = this.contents.searchBtnBgColor
        })
      })
    },
    // 新增、批量删除
    contentBtnAdAllStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .ad .el-button--success').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllAddFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllAddBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--danger').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllDelFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllDelBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--warning').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllWarnFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllWarnBgColor
        })
      })
    },
    // 表格
    // rowStyle({ row, rowIndex}) {
    //   if (rowIndex % 2 == 1) {
    //     if(this.contents.tableStripe) {
    //       return {color:this.contents.tableStripeFontColor}
    //     }
    //   } else {
    //     return ''
    //   }
    // },
    // cellStyle({ row, rowIndex}){
    //   if (rowIndex % 2 == 1) {
    //     if(this.contents.tableStripe) {
    //       return {backgroundColor:this.contents.tableStripeBgColor}
    //     }
    //   } else {
    //     return ''
    //   }
    // },
    headerRowStyle({ row, rowIndex}){
      return {color: this.contents.tableHeaderFontColor}
    },
    headerCellStyle({ row, rowIndex}){
      return {backgroundColor: this.contents.tableHeaderBgColor}
    },
    // 表格按钮
    contentTableBtnStyleChange(){
      // this.$nextTick(()=>{
      //   setTimeout(()=>{
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--success').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnDetailFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnDetailBgColor
      //     })
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--primary').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnEditFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnEditBgColor
      //     })
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--danger').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnDelFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnDelBgColor
      //     })

      //   }, 50)
      // })
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      if(this.contents.pageTotal) arr.push('total')
      if(this.contents.pageSizes) arr.push('sizes')
      if(this.contents.pagePrevNext){
        arr.push('prev')
        if(this.contents.pagePager) arr.push('pager')
        arr.push('next')
      }
      if(this.contents.pageJumper) arr.push('jumper')
      this.layouts = arr.join()
      this.contents.pageEachNum = 10
    },

    laorendanganCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.laorendanganCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','laorenruzhu');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.laorendanganCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.laorendanganCrossaddOrUpdate.init(row.id,type);
      });
    },
    shentizhuangkuangCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.shentizhuangkuangCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','laorenruzhu');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.shentizhuangkuangCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.shentizhuangkuangCrossaddOrUpdate.init(row.id,type);
      });
    },
    yongyaoqingkuangCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.yongyaoqingkuangCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','laorenruzhu');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.yongyaoqingkuangCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.yongyaoqingkuangCrossaddOrUpdate.init(row.id,type);
      });
    },
    waichudengjiCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.waichudengjiCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','laorenruzhu');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.waichudengjiCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.waichudengjiCrossaddOrUpdate.init(row.id,type);
      });
    },
    zhuanfangdengjiCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.zhuanfangdengjiCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','laorenruzhu');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.zhuanfangdengjiCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.zhuanfangdengjiCrossaddOrUpdate.init(row.id,type);
      });
    },
    tuifangdengjiCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.tuifangdengjiCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','laorenruzhu');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.tuifangdengjiCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.tuifangdengjiCrossaddOrUpdate.init(row.id,type);
      });
    },
    richangjiaofeiCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.richangjiaofeiCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','laorenruzhu');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.richangjiaofeiCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.richangjiaofeiCrossaddOrUpdate.init(row.id,type);
      });
    },
    chartDialog() {
      this.chartVisiable = !this.chartVisiable;
      this.$nextTick(()=>{
        var tuifangzhuangtaiChart = this.$echarts.init(document.getElementById("tuifangzhuangtaiChart"),'macarons');
        this.$http({
            url: "laorenruzhu/group/tuifangzhuangtai",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
            let res = data.data;
            let xAxis = [];
            let yAxis = [];
            let pArray = []
            for(let i=0;i<res.length;i++){
                xAxis.push(res[i].tuifangzhuangtai);
                yAxis.push(parseFloat((res[i].total)));
                pArray.push({
                value: parseFloat((res[i].total)),
                name: res[i].tuifangzhuangtai
                })
                var option = {};
                option = {
                        title: {
                            text: '老人入住',
                            left: 'center'
                        },
                        tooltip: {
                          trigger: 'item',
                          formatter: '{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                data: pArray,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                };
                // 使用刚指定的配置项和数据显示图表。
                tuifangzhuangtaiChart.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    tuifangzhuangtaiChart.resize();
                };
            }
            }
        });
        // xcolumn ycolumn  
      })
    },
    init () {
          this.tuifangzhuangtaiOptions = "已退房,未退房".split(',')
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
      }
          if(this.searchForm.ruzhubianhao!='' && this.searchForm.ruzhubianhao!=undefined){
            params['ruzhubianhao'] = '%' + this.searchForm.ruzhubianhao + '%'
          }
          if(this.searchForm.fangjianhao!='' && this.searchForm.fangjianhao!=undefined){
            params['fangjianhao'] = '%' + this.searchForm.fangjianhao + '%'
          }
          if(this.searchForm.laorenxingming!='' && this.searchForm.laorenxingming!=undefined){
            params['laorenxingming'] = '%' + this.searchForm.laorenxingming + '%'
          }
          if(this.searchForm.hugongxingming!='' && this.searchForm.hugongxingming!=undefined){
            params['hugongxingming'] = '%' + this.searchForm.hugongxingming + '%'
          }
          if(this.searchForm.tuifangzhuangtai!='' && this.searchForm.tuifangzhuangtai!=undefined){
            params['tuifangzhuangtai'] = this.searchForm.tuifangzhuangtai
          }
      this.$http({
        url: "laorenruzhu/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 查看评论
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "laorenruzhu/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


  }

};
</script>
<style lang="scss" scoped>
  .slt {
    margin: 0 !important;
    display: flex;
  }

  .ad {
    margin: 0 !important;
    display: flex;
  }

  .pages {
    & /deep/ el-pagination__sizes{
      & /deep/ el-input__inner {
        height: 22px;
        line-height: 22px;
      }
    }
  }
  

  .el-button+.el-button {
    margin:0;
  } 

  .tables {
	& /deep/ .el-button--success {
		height: 40px;
		color: rgba(2, 0, 0, 1);
		font-size: 15px;
		border-width: 6px 0px 6px 0px;
		border-style: solid;
		border-color: rgba(0, 0, 0, 1);
		border-radius: 5px;
		background-color: rgba(234, 207, 164, 1);
	}
	
	& /deep/ .el-button--primary {
		height: 40px;
		color: rgba(0, 0, 0, 1);
		font-size: 15px;
		border-width: 6px 0px 6px 0px;
		border-style: solid;
		border-color: rgba(0, 0, 0, 1);
		border-radius: 5px;
		background-color: rgba(234, 207, 164, 1);
	}
	
	& /deep/ .el-button--danger {
		height: 40px;
		color: rgba(0, 0, 0, 1);
		font-size: 15px;
		border-width: 6px 0px 6px 0px;
		border-style: solid;
		border-color: rgba(0, 0, 0, 1);
		border-radius: 5px;
		background-color: rgba(234, 207, 164, 1);
	}

    & /deep/ .el-button {
      margin: 4px;
    }
  }
	.form-content {
		background: transparent;
	}
	.table-content {
		background: transparent;
	}
	
	.tables /deep/ .el-table__body tr {
				background-color: rgba(253, 253, 229, 1) !important;
				color: rgba(0, 0, 0, 1) !important;
	 }
	.tables /deep/ .el-table__body tr.el-table__row--striped td {
	    background: transparent;
	}
	.tables /deep/ .el-table__body tr.el-table__row--striped {
		background-color: rgba(253, 253, 229, 1) !important;
		color: rgba(0, 0, 0, 1) !important;
	}
	
	 .tables /deep/ .el-table__body tr:hover>td {
	   	   background-color: rgba(234, 207, 164, 1) !important;
	   	   	   color: #333 !important;
	   	 }
	 
</style>
