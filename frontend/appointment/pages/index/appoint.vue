<template>
	<view>
		<cu-custom bgColor="bg-gradual-blue" :isBack="true"><block slot="backText">返回</block><block slot="content">口罩预约</block></cu-custom>
		<form>
			<view class="cu-form-group margin-top">
				<view class="title">姓名</view>
				<input placeholder="请输入您的姓名" name="input" v-model="form.name"></input>
			</view>
			<view class="cu-form-group">
				<view class="title">身份证号码</view>
				<input placeholder="请输入您的身份证号码" name="input" v-model="form.id"></input>
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
	export default {
		data() {
			return {
				index: -1,
				index1: -1,
				masknumber: [1, 2, 3],
				position: ['A药房', 'B药房', 'C药房'],
				form: {
					name: '',
					id: '',
					number: null,
					position: null
				}
			}
		},
		methods: {
			PickerChange(e) {
				this.index = e.detail.value
			},
			PositionChange(e) {
				this.index1 = e.detail.value
			},
			submit() {
				console.log(this.form);
			}
		}
	}
</script>

<style>

</style>
