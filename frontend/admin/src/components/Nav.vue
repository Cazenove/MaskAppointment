<template>
	<div id="ManageNav">
		<nav class="navbar navbar-dark bg-dark navbar-expand-lg">
			<!-- <a class="navbar-brand" href="#">评价系统后台</a> -->
			<router-link class="nav-link navbar-brand" to="/admin/home">口罩预约系统后台</router-link>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
			 aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item">
						<router-link class="nav-link" to="/management">预约管理</router-link>
					</li>
					<li class="nav-item">
						<router-link class="nav-link" to="/statistics">统计</router-link>
					</li>
					<li class="nav-item">
						<a href="" class="nav-link" @click="loginOut()">注销</a>
					</li>
				</ul>
			</div>
		</nav>
	</div>
</template>

<script>
	export default {
		name: "Nav",
		methods: {
			loginOut() {
				window.sessionStorage.removeItem('loginState');
				this.$router.push('/');
				alert("已注销");
			},
		}
	}
</script>

<style>
	#ManageNav {
		font-family: "Microsoft JhengHei", 华文细黑;
	}
</style>
