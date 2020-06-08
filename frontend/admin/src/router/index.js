import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
	{
		path: '/',
		name: 'Login',
		component: () => import('../views/Login.vue')
	},
	{
		path: '/management',
		name: 'Management',
		component: () => import('../views/Management.vue')
	}
]

const router = new VueRouter({
	routes
})

export default router
