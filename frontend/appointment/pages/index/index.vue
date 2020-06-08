<template>
	<view>
		<scroll-view scroll-y class="page">
			<image src="/static/componentBg.png" mode="widthFix" class="response"></image>
			<view class="nav-list">
				<navigator v-if="status" hover-class="none" :url="'/pages/index/appoint'" class="nav-li" navigateTo :class="'bg-cyan'"
				 :style="[{animation: 'show 1.2s 1'}]">
					<div>
						<view class="nav-title">口罩预约</view>
						<view class="nav-name">Appoint</view>
						<text :class="'cuIcon-edit'"></text>
					</div>
				</navigator>
				<navigator v-else hover-class="none" class="nav-li" navigateTo :class="'bg-red'" @click="notStart"
				 :style="[{animation: 'show 1.2s 1'}]">
					<div>
						<view class="nav-title">口罩预约</view>
						<view class="nav-name">Appoint</view>
						<text :class="'cuIcon-edit'"></text>
					</div>
				</navigator>
				<navigator hover-class="none" :url="'/pages/index/search'" class="nav-li" navigateTo :class="'bg-blue'"
				 :style="[{animation: 'show 1.4s 1'}]">
					<div>
						<view class="nav-title">预约查询</view>
						<view class="nav-name">Search</view>
						<text :class="'cuIcon-search'"></text>
					</div>
				</navigator>
			</view>
			<view v-if="status" class="bg-green padding margin text-center round">
				目前是开放预约状态！
			</view>
			<view v-else class="bg-red padding margin text-center round">
				预约暂未开放！
			</view>
			<view class="cu-card article">
				<view class="cu-item shadow light" :class="'bg-blue'">
					<view class="title"><h1>预约规则</h1></view>
					<view class="content">
						<view class="desc">
							<view class="text-black text-bold">
								【面向群体】该平台面向福州市民<br />
								【口罩预约】每轮预约每人限购10个口罩<br />
								【预约规则】<br />
								【预约购买】<br />
								【那没事了】
							</view>
						</view>
					</view>
				</view>
			</view>
		</scroll-view>
	</view>
</template>

<script>
	export default {
		data() {
		return {
				PageCur: 'basics',
				status: false
			}
		},
		created() {
			// this.status = true
		},
		methods: {
			NavChange: function(e) {
				this.PageCur = e.currentTarget.dataset.cur
			},
			notStart() {
				uni.showToast({
					image: "../../static/close.png",
					title: "现在不是预约开放时间！"
				})
			}
		}
	}
</script>

<style>

</style>
