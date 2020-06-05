import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
	{
		path: '/list',
		name: 'List',
		component: () => import('../views/List.vue')
	},
	{
		path: '/',
		name: 'Login',
		component: () => import('../views/Login.vue')
	},
	{
		path: '/management',
		name: 'Management',
		component: () => import('../views/Management.vue')
	},
	{
		path: '/statistics',
		name: 'Statistics',
		component: () => import('../views/Statistics.vue')
	}
]

const router = new VueRouter({
	routes
})

export default router
