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
				开放时间：{{startTime}}——{{endTime}}<br />每人限购{{limit}}个口罩
			</view>
			<view v-else class="bg-red padding margin text-center round">
				预约暂未开放！当前可进行预约查询
			</view>
			<view class="cu-card article">
				<view class="cu-item shadow light" :class="'bg-blue'">
					<view class="title"><h1>预约规则</h1></view>
					<view class="content">
						<view class="desc">
							<view class="text-black text-bold">
								该平台面向福州市民,市民可以在通过填写姓名、手机号、身份证号码来进行口罩预约，可以选择指定地点、预约指定数量的口罩。<br />
								当前轮次结束后,可通过上方预约查询功能查询自己是否中签，中签将生成二维码,请凭二维码在三个工作日内前往指定地点购买口罩。
							</view>
						</view>
					</view>
				</view>
			</view>
		</scroll-view>
	</view>
</template>

<script>
	import api from '../../httpConfig.js'
	import axios from 'axios'
	export default {
		data() {
		return {
				PageCur: 'basics',
				status: false,
				limit: '',
				startTime: '',
				endTime: ''
			}
		},
		created() {
			var self = this;
			axios.get(api.getStatus,null)
			.then(function(res) {
				self.limit = res.data.data.limit;
				self.startTime = res.data.data.startTime;
				self.endTime = res.data.data.endTime;
				self.status = res.data.status;
			}).catch(function(error) {
				console.log(error);
			})
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
