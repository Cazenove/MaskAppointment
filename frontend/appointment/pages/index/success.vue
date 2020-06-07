<template>
	<view>
		<cu-custom bgColor="bg-gradual-blue"><block slot="content">口罩预约</block></cu-custom>
		<view class="action">
			<view class="solids-bottom padding-xsl flex align-center">
				<view class="flex-sub text-center">
					<view class="solid-bottom text-xsl padding">
						<text class=" cuIcon-roundcheckfill text-green"></text>
					</view>
					<view class="solid-bottom text-xxl padding">
						<text class="text-black text-bold">您已预约成功！<br />在2020/x/x后可以查询中签状态！</text>
					</view>
					<view class="padding flex flex-direction">
						<button class="cu-btn bg-green margin-tb-sm lg" @click="goBack">返回</button>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
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
