<template>
	<div id="Management">
		<Nav></Nav>
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">主页</a></li>
				<li class="breadcrumb-item active" aria-current="page">预约管理</li>
			</ol>
		</nav>
		<div class="container col-md-10 offset-md-1" style="margin: 50px auto;">
			<h1>预约管理</h1>
			<br />
			<vxe-toolbar>
				<template v-slot:buttons>
					<vxe-button @click="exportSelectEvent">新增预约轮次</vxe-button>
				</template>
			</vxe-toolbar>
			<vxe-table
			border
			resizable
			row-key
			highlight-hover-row
			keep-source
			ref="xTable"
			:data="tableData">
				<vxe-table-column type="checkbox" width="60"></vxe-table-column>
				<vxe-table-column field="id" title="ID"></vxe-table-column>
				<vxe-table-column field="name" title="名称"></vxe-table-column>
				<vxe-table-column field="maxNum" title="投放总量"></vxe-table-column>
				<vxe-table-column field="limit" title="限购数量"></vxe-table-column>
				<vxe-table-column field="startTime" title="开始时间"></vxe-table-column>
				<vxe-table-column field="endTime" title="结束时间"></vxe-table-column>
				<vxe-table-column title="操作">
					<template v-slot="{ row }">
						<button type="button" @click="editEvent(row)" class="btn btn-light" data-toggle="modal" data-target="#UpdateModal">修改</button>
						&nbsp;
						<button type="button" @click="removeEvent(row)" class="btn btn-warning">强制结束</button>
						&nbsp;
						<button type="button" @click="removeEvent(row)" class="btn btn-danger">删除</button>
					</template>
				</vxe-table-column>
			</vxe-table>
		</div>
	</div>
</template>

<script>
	import Nav from '../components/Nav.vue'
	export default {
		data() {
			return {
				allAlign: null,
				tableData: [
					{
						id: '1',
						name: 'xxxx',
						maxNum: 10000,
						limit: 10,
						startTime: '2020-06-01',
						endTime: '2020-06-07'
					}
				]
			}
		},
		components: {
			Nav
		},
		created() {
			this.tableData = window.MOCK_DATA_LIST.slice(0, 4)
		}
	}
</script>

<style>
</style>
