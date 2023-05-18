import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import hugonggongzi from '@/views/modules/hugonggongzi/list'
    import caiwutongji from '@/views/modules/caiwutongji/list'
    import richangjiaofei from '@/views/modules/richangjiaofei/list'
    import waichudengji from '@/views/modules/waichudengji/list'
    import wupinruku from '@/views/modules/wupinruku/list'
    import jiashu from '@/views/modules/jiashu/list'
    import laorenruzhu from '@/views/modules/laorenruzhu/list'
    import yaopinruku from '@/views/modules/yaopinruku/list'
    import wupinxinxi from '@/views/modules/wupinxinxi/list'
    import shentizhuangkuang from '@/views/modules/shentizhuangkuang/list'
    import yaopinxinxi from '@/views/modules/yaopinxinxi/list'
    import yongyaoqingkuang from '@/views/modules/yongyaoqingkuang/list'
    import tuifangdengji from '@/views/modules/tuifangdengji/list'
    import yaopinchuku from '@/views/modules/yaopinchuku/list'
    import yujiaofei from '@/views/modules/yujiaofei/list'
    import loufangziliao from '@/views/modules/loufangziliao/list'
    import huliqingkuang from '@/views/modules/huliqingkuang/list'
    import wupinchuku from '@/views/modules/wupinchuku/list'
    import hugong from '@/views/modules/hugong/list'
    import fangjianziliao from '@/views/modules/fangjianziliao/list'
    import laorendangan from '@/views/modules/laorendangan/list'
    import tuifangfeiyong from '@/views/modules/tuifangfeiyong/list'
    import zhuanfangdengji from '@/views/modules/zhuanfangdengji/list'
    import chuangwei from '@/views/modules/chuangwei/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/hugonggongzi',
        name: '护工工资',
        component: hugonggongzi
      }
      ,{
	path: '/caiwutongji',
        name: '财务统计',
        component: caiwutongji
      }
      ,{
	path: '/richangjiaofei',
        name: '日常缴费',
        component: richangjiaofei
      }
      ,{
	path: '/waichudengji',
        name: '外出登记',
        component: waichudengji
      }
      ,{
	path: '/wupinruku',
        name: '物品入库',
        component: wupinruku
      }
      ,{
	path: '/jiashu',
        name: '家属',
        component: jiashu
      }
      ,{
	path: '/laorenruzhu',
        name: '老人入住',
        component: laorenruzhu
      }
      ,{
	path: '/yaopinruku',
        name: '药品入库',
        component: yaopinruku
      }
      ,{
	path: '/wupinxinxi',
        name: '物品信息',
        component: wupinxinxi
      }
      ,{
	path: '/shentizhuangkuang',
        name: '身体状况',
        component: shentizhuangkuang
      }
      ,{
	path: '/yaopinxinxi',
        name: '药品信息',
        component: yaopinxinxi
      }
      ,{
	path: '/yongyaoqingkuang',
        name: '用药情况',
        component: yongyaoqingkuang
      }
      ,{
	path: '/tuifangdengji',
        name: '退房登记',
        component: tuifangdengji
      }
      ,{
	path: '/yaopinchuku',
        name: '药品出库',
        component: yaopinchuku
      }
      ,{
	path: '/yujiaofei',
        name: '预交费',
        component: yujiaofei
      }
      ,{
	path: '/loufangziliao',
        name: '楼房资料',
        component: loufangziliao
      }
      ,{
	path: '/huliqingkuang',
        name: '护理情况',
        component: huliqingkuang
      }
      ,{
	path: '/wupinchuku',
        name: '物品出库',
        component: wupinchuku
      }
      ,{
	path: '/hugong',
        name: '护工',
        component: hugong
      }
      ,{
	path: '/fangjianziliao',
        name: '房间资料',
        component: fangjianziliao
      }
      ,{
	path: '/laorendangan',
        name: '老人档案',
        component: laorendangan
      }
      ,{
	path: '/tuifangfeiyong',
        name: '退房费用',
        component: tuifangfeiyong
      }
      ,{
	path: '/zhuanfangdengji',
        name: '转房登记',
        component: zhuanfangdengji
      }
      ,{
	path: '/chuangwei',
        name: '床位',
        component: chuangwei
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
