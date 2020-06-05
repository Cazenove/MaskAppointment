<template>
	<div id="app">
		<Nav></Nav>
		<router-view />
	</div>
</template>

<script>
	import Nav from './components/Nav.vue'
	export default {
		data() {
			return {

			}
		},
		components: {
			Nav
		}
	}
</script>

<style>
</style>
