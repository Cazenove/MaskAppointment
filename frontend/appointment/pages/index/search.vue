<template>
	<view>
		<cu-custom bgColor="bg-gradual-blue" :isBack="true"><block slot="backText">返回</block><block slot="content">预约查询</block></cu-custom>
		<view class="cu-bar search bg-white">
			<view class="search-form round">
				<text class="cuIcon-search"></text>
				<input v-model="telephone" :adjust-position="false" type="text" placeholder="请输入手机号查询中签结果" confirm-type="search"></input>
			</view>
			<view class="action">
				<button class="cu-btn bg-green shadow-blur round" @click="search">搜索</button>
			</view>
		</view>
		<view v-if="isSearch" class="flex solid-bottom padding justify-center">
			<vue-qr v-bind:text="this.telephone" :size="300"></vue-qr>
		</view>
	</view>
</template>

<script>
	import vueQr from 'vue-qr'
	export default {
		data() {
			return {
				telephone: '',
				isSearch: false
			}
		},
		components: {
			vueQr
		},
		methods: {
			search() {
				this.isSearch = true;
			}
		}
	}
</script>

<style>

</style>
