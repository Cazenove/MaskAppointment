<template>
	<view>
		<cu-custom bgColor="bg-gradual-blue" :isBack="true">
			<block slot="backText">返回</block>
			<block slot="content">口罩预约</block>
		</cu-custom>
		<form v-if="position">
			<view class="cu-form-group margin-top">
				<view class="title">姓名</view>
				<input placeholder="请输入您的姓名" name="input" v-model="form.name"></input>
			</view>
			<view class="cu-form-group">
				<view class="title">身份证号码</view>
				<input placeholder="请输入您的身份证号码" name="input" v-model="form.id"></input>
			</view>
			<view class="cu-form-group">
				<view class="title">手机号码</view>
				<input placeholder="请输入您的手机号码" name="input" v-model="form.telephone"></input>
			</view>
			<view class="cu-form-group">
				<view class="title">口罩预约数量</view>
				<picker @change="PickerChange" :value="index" :range="masknumber" v-model="form.number">
					<view class="picker">
						{{index>-1?masknumber[index]:'请选择口罩预约数量'}}
					</view>
				</picker>
			</view>
			<view class="cu-form-group">
				<view class="title">取货地点</view>
				<picker @change="PositionChange" :value="index1" :range="position" v-model="form.position">
					<view class="picker">
						{{index1>-1?position[index1]:'请选择取货地点'}}
					</view>
				</picker>
			</view>
		</form>
		<br />
		<view class="cu-bar btn-group">
			<button class="cu-btn bg-green shadow-blur round lg" @click="submit">预约</button>
		</view>
	</view>
</template>

<script>
	import api from '../../httpConfig.js'
	import axios from 'axios'
	export default {
		data() {
			return {
				index: -1,
				index1: -1,
				masknumber: [],
				position: [],
				positionToId: {},
				endTime: '',
				form: {
					name: '',
					id: '',
					telephone: '',
					number: null,
					position: null
				},
				rules: {
					name: {
						rule: /\S/,
						msg: "姓名不能为空"
					},
					id: {
						rule: /(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}[0-9Xx]$)/,
						msg: "身份证号码有误"
					},
					telephone: {
						rule: /^1(3|4|5|7|8)\d{9}$/,
						msg: "手机号码有误"
					},
					number: {
						rule: /\S/,
						msg: "预约数量不能为空"
					},
					position: {
						rule: /\S/,
						msg: "取货地点不能为空"
					}
				}
			}
		},
		created() {
			var self = this;
			axios.get(api.getStatus,null)
			.then(function(res) {
				console.log(res);
				self.endTime = res.data.data.endTime;
				for(var i=1; i<=res.data.data.limit; i++) {
					self.masknumber[i] = i;
				}
			}).catch(function(error) {
				console.log(error);
			})
			axios.get(api.getPlace,null)
			.then(function(res) {
				for(var i=0; i<res.data.data.length; i++) {
					self.positionToId[res.data.data[i].place] = res.data.data[i].id;
					self.position[i] = res.data.data[i].place;
				}
			}).catch(function(error) {
				console.log(error);
			})
		},
		methods: {
			PickerChange(e) {
				this.index = e.detail.value
			},
			PositionChange(e) {
				this.index1 = e.detail.value
			},
			submit() {
				//进行表单检查
				if (!this.validate('name')) return;
				if (!this.validate("id")) return;
				if (!this.validate("telephone")) return;
				if (!this.validate("number")) return;
				if (!this.validate("position")) return;
				uni.showLoading({
					title: "表单提交中..."
				});
				var self = this;
				this.form.position = this.positionToId[this.position[this.index1]];
				this.form.number = this.index;
				
				axios.post(api.appoint,{
					appointNum: this.form.number,
					idNum: this.form.id,
					namee: this.form.name,
					placeId: this.form.position,
					telephone: this.form.telephone
				}).then(function(res) {
					if(res.data.status == 1) {
						self.$router.push({path: '/pages/index/success',query:{endTime: self.endTime}})
					} else {
						self.$router.push({path: '/pages/index/failed',query:{msg: res.data.msg}})
					}
				}).catch(function(error) {
					console.log(error);
				})
				// if(this.form.name == "成功") {
				// 	this.$router.push('/pages/index/success')
				// } else if(this.form.name == "失败") {
				// 	this.$router.push('/pages/index/failed')
				// }
			},
			validate(key) {
				let bool = true;
				if (!this.rules[key].rule.test(this.form[key])) {
					//提示信息
					uni.showToast({
						image: "../../static/close.png",
						title: this.rules[key].msg,
					})
					//取反
					bool = false;
					return false;
				}
				return bool;
			}
		}
	}
</script>

<style>
	.cu-form-group .title {
		min-width: calc(4em + 30px);
	}
</style>
