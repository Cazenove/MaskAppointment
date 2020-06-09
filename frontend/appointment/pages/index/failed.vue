<template>
	<view>
		<cu-custom bgColor="bg-gradual-blue"><block slot="content">口罩预约</block></cu-custom>
		<view class="action">
			<view class="solids-bottom padding-xs flex align-center">
				<view class="flex-sub text-center">
					<view class="solid-bottom text-xsl padding">
						<text class=" cuIcon-roundclosefill text-red"></text>
					</view>
					<view class="solid-bottom text-xl padding">
						<text class="text-black text-bold">预约失败<br />原因:{{$route.query.msg}}</text>
					</view>
					<view class="padding flex flex-direction">
						<button class="cu-btn bg-red margin-tb-sm lg" @click="goBack">返回</button>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import api from '../../httpConfig.js'
	import axios from 'axios'
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			goBack() {
				this.$router.push('/pages/index/index');
			}
		}
	}
</script>

<style>
</style>
