<template>
	<div id="Login">
		<div style="display: flex;justify-content: center;margin-top: 150px">
			<el-card style="width: 400px">
				<div slot="header" class="clearfix">
					<span>登录</span>
				</div>
				<table>
					<tr>
						<td>用户名</td>
						<td>
							<el-input v-model="user.username" placeholder="请输入用户名"></el-input>
						</td>
					</tr>
					<br />
					<tr>
						<td>密码</td>
						<td>
							<el-input type="password" v-model="user.password" placeholder="请输入密码" @keydown.enter.native="doLogin"></el-input>
						</td>
					</tr>
					<br />
					<tr>
						<td colspan="2">
							<el-button style="width: 300px" type="primary" @click="doLogin">登录</el-button>
						</td>
					</tr>
				</table>
			</el-card>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				user: {
					username: '',
					password: '',
				}
			}
		},
		methods: {
			doLogin() {
				if(this.user.username == "admin" && this.user.password == "admin") {
					this.$router.push('/management')
				}
				else {
					alert("号码或密码错误！");
				}
			}
		}
	}
</script>

<style>
</style>
