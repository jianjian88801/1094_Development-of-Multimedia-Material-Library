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

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import liuyan from '@/views/modules/liuyan/list'
    import singleSeach from '@/views/modules/singleSeach/list'
    import sucai from '@/views/modules/sucai/list'
    import sucaiCollection from '@/views/modules/sucaiCollection/list'
    import sucaiCommentback from '@/views/modules/sucaiCommentback/list'
    import sucaiOrder from '@/views/modules/sucaiOrder/list'
    import yonghu from '@/views/modules/yonghu/list'
    import config from '@/views/modules/config/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionarySingleSeach from '@/views/modules/dictionarySingleSeach/list'
    import dictionarySucai from '@/views/modules/dictionarySucai/list'
    import dictionarySucaiCollection from '@/views/modules/dictionarySucaiCollection/list'
    import dictionarySucaiErji from '@/views/modules/dictionarySucaiErji/list'
        import dictionarySucaiErjiAddOrUpdate from '@/views/modules/dictionarySucaiErji/add-or-update'//二级
    import dictionarySucaiOrder from '@/views/modules/dictionarySucaiOrder/list'
    import dictionarySucaiOrderPayment from '@/views/modules/dictionarySucaiOrderPayment/list'





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
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionarySingleSeach',
        name: '单页数据类型',
        component: dictionarySingleSeach
    }
    ,{
        path: '/dictionarySucai',
        name: '素材类型',
        component: dictionarySucai
    }
    ,{
        path: '/dictionarySucaiCollection',
        name: '收藏表类型',
        component: dictionarySucaiCollection
    }
    ,{
        path: '/dictionarySucaiErji',
        name: '二级类型',
        component: dictionarySucaiErji
    }
    ,{
        path: '/dictionarySucaiErjiAddOrUpdate',
        name: '二级类型的新增修改页面',
        component: dictionarySucaiErjiAddOrUpdate
    }
    ,{
        path: '/dictionarySucaiOrder',
        name: '订单类型',
        component: dictionarySucaiOrder
    }
    ,{
        path: '/dictionarySucaiOrderPayment',
        name: '订单支付类型',
        component: dictionarySucaiOrderPayment
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/liuyan',
        name: '留言板',
        component: liuyan
      }
    ,{
        path: '/singleSeach',
        name: '单页数据',
        component: singleSeach
      }
    ,{
        path: '/sucai',
        name: '素材',
        component: sucai
      }
    ,{
        path: '/sucaiCollection',
        name: '素材收藏',
        component: sucaiCollection
      }
    ,{
        path: '/sucaiCommentback',
        name: '素材评价',
        component: sucaiCommentback
      }
    ,{
        path: '/sucaiOrder',
        name: '素材订单',
        component: sucaiOrder
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
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
