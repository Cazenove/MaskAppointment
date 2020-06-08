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
					<button class="btn btn-outline-success" @click="startAppoint">新增预约轮次</button>
				</template>
			</vxe-toolbar>
			<vxe-table border resizable row-key highlight-hover-row keep-source ref="xTable" :data="tableData">
				<vxe-table-column type="checkbox" width="60"></vxe-table-column>
				<vxe-table-column field="id" title="ID" width="80"></vxe-table-column>
				<vxe-table-column field="maxNum" title="投放总量"></vxe-table-column>
				<vxe-table-column field="limit" title="限购数量"></vxe-table-column>
				<vxe-table-column field="startTime" title="开始时间"></vxe-table-column>
				<vxe-table-column field="endTime" title="结束时间"></vxe-table-column>
				<vxe-table-column field="status" title="状态" :formatter="formatterStatus"></vxe-table-column>
				<vxe-table-column title="操作">
					<template v-slot="{ row }">
						<div v-if="row.status == 1">
							<button data-toggle="modal" data-target="#myModal" class="btn btn-danger">结束</button>
						</div>
						<div v-else>
							<button type="button" @click="showList(row.id)" class="btn btn-info">中奖名单</button>
							&nbsp;
							<button type="button" @click="showStatics(row.id)" class="btn btn-info">统计</button>
						</div>
					</template>
				</vxe-table-column>
			</vxe-table>
		</div>
		
		<!-- 新增模态框 -->
		<vxe-modal v-model="showEdit" :title="selectRow ? '编辑&保存' : '新增预约轮次'" width="800" :loading="submitLoading" resize destroy-on-close>
			<vxe-form :data="formData" :items="formItems" :rules="formRules" title-align="right" title-width="100" @submit="submitEvent"></vxe-form>
		</vxe-modal>
		
		<!-- 结束模态框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">确认结束</h4>
					</div>
					<div class="modal-body">确定要结束本轮预约吗？</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-danger" @click="endAppoint">确认结束</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div><!-- /.modal-fade -->
		
	</div>
</template>

<script>
	import Nav from '../components/Nav.vue'
	import axios from 'axios'
	export default {
		data() {
			return {
				allAlign: null,
				selectRow: null,
				showEdit: false,
				submitLoading: false,
				tableData: [
					{
						id: '1',
						maxNum: 10000,
						limit: 10,
						startTime: '2020-06-01',
						endTime: '2020-06-07',
						status: 0
					},
					{
						id: '1',
						maxNum: 20000,
						limit: 10,
						startTime: '2020-06-07',
						endTime: '2020-06-10',
						status: 1
					}
				],
				formData: {
					name: '',
					maxNum: '',
					limit: '',
					startTime: '',
					endTime: ''
				},
				formRules: {
					maxNum: [{ required: true, message: '请输入昵称' }],
					limit: [{ required: true, message: '请选择性别' }],
					startTime: [{ required: true, message: '请输入开始时间' }],
					endTime: [{ required: true, message: '请输入结束时间' }]
					},
				formItems: [
					{ title: '预约信息', span: 24, titleAlign: 'left', titleWidth: 200, titlePrefix: { icon: 'fa fa-address-card-o' } },
					{ field: 'maxNum', title: '投放数量', span: 12, itemRender: { name: '$input', props: { type: 'number', placeholder: '请输入投放数量' } } },
					{ field: 'limit', title: '限购数量', span: 12, itemRender: { name: '$input', props: { type: 'number', placeholder: '请输入限购数量' } } },
					{ field: 'startTime', title: '开始时间', span: 12, itemRender: { name: '$input', props: { type: 'date', placeholder: '请选择开始日期' } } },
					{ field: 'endTime', title: '结束时间', span: 12, itemRender: { name: '$input', props: { type: 'date', placeholder: '请选择结束日期' } } },
					{ align: 'center', span: 24, titleAlign: 'left', itemRender: { name: '$buttons', children: [{ props: { type: 'submit', content: '提交', status: 'primary' } }, { props: { type: 'reset', content: '重置' } }] } }
				]
			}
		},
		components: {
			Nav
		},
		created() {
		},
		methods: {
			formatterStatus({cellValue}) {
				if(cellValue == 1) {
					return "预约开放中"
				} else {
					return "预约结束"
				}
			},
			startAppoint() {
				this.formData = {
					maxNum: '',
					limit: '',
					startTime: '',
					endTime: ''
				}
				this.selectRow = null
				this.showEdit = true
			},
			endAppoint() {
				axios.post('',null)
				.then(function(res) {
					
				}).catch(function(error) {
					console.log(error);
				})
			},
			submitEvent() {
				
			},
			showList(row) {
				
			}
		}
	}
</script>

<style>
</style>
