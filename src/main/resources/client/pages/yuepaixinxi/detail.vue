
<template>
<view>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view class="container" :style='{"width":"100%","padding":"0px","position":"relative","background":"#ffffff","height":"auto"}'>
						<swiper :style='{"width":"100%","background":"#ffffff","height":"400rpx"}' class="swiper" :indicator-dots='true' :autoplay='true' :circular='true' indicator-active-color='#ff746d' indicator-color='#ffffff' :duration='500' :interval='5000' :vertical='false'>
				<swiper-item :style='{"width":"100%","textAlign":"center","background":"#ffffff","height":"100%"}' v-for="(swiper,index) in swiperList" :key="index">
					<img :style='{"width":"100%","padding":"0","objectFit":"contain","background":"#fefcd8","display":"block","height":"100%"}' mode="aspectFill" v-if="swiper.substring(0,4)=='http'" :src="swiper"></img>
					<img :style='{"width":"100%","padding":"0","objectFit":"contain","background":"#fefcd8","display":"block","height":"100%"}' mode="aspectFill" v-else :src="baseUrl+swiper"></img>
				</swiper-item>
			</swiper>
									            <view :style='{"padding":"24rpx 24rpx 24rpx 24rpx","flexWrap":"wrap","background":"#ffffff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}' class="detail-content">
				<view :style='{"padding":"0 80rpx 0 72rpx","margin":"0 0 0px 0","borderColor":"#cccccc","borderRadius":"0px 0 0 0px","borderWidth":"0 0 0px 0","background":"url(http://clfile.zggen.cn/20231130/99a276c461c94b9a9ab19652b1976f71.png) no-repeat center top / 100% 100%","display":"block","width":"100%","borderStyle":"solid","justifyContent":"space-between","height":"104rpx"}' class="detail-list-item price priceFavor">
					<view :style='{"color":"#ff796b","display":"inline-block","width":"48rpx","lineHeight":"104rpx","fontSize":"48rpx","float":"right","height":"48rpx"}' v-if="storeupFlag==1" class="iconfont icon-likefill2" @click="shoucang"></view>
					<view :style='{"color":"#ff796b","display":"inline-block","width":"48rpx","lineHeight":"104rpx","fontSize":"48rpx","float":"right","height":"48rpx"}' v-if="storeupFlag==0" class="iconfont icon-likeline1" @click="shoucang"></view>
				</view>

				<view :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","flexWrap":"wrap","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="lable">拍摄主题：</view>
					<view :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666","flex":"1"}' class="text">{{detail.paishezhuti}}</view>
				</view>
				<view :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","flexWrap":"wrap","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="lable">摄影师姓名：</view>
					<view :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666","flex":"1"}' class="text">{{detail.sheyingshixingming}}</view>
				</view>
				<view :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","flexWrap":"wrap","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="lable">价格：</view>
					<view :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666","flex":"1"}' class="text">{{detail.jiage}}</view>
				</view>

				<view class="detail-list-item" :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","flexWrap":"wrap","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>营业时间：</view>
					<view  class="text" :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666","flex":"1"}'>{{detail.yingyeshijian}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","flexWrap":"wrap","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>拍摄地点：</view>
					<view  class="text" :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666","flex":"1"}'>{{detail.paishedidian}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","flexWrap":"wrap","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>联系方式：</view>
					<view  class="text" :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666","flex":"1"}'>{{detail.lianxifangshi}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","flexWrap":"wrap","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>交付时间：</view>
					<view  class="text" :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666","flex":"1"}'>{{detail.jiaofushijian}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","flexWrap":"wrap","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>收藏数量：</view>
					<view  class="text" :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666","flex":"1"}'>{{detail.storeupnum}}</view>
				</view>



				<view class="detail-list-item" :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","flexWrap":"wrap","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>服务内容</view>
					<view class="text" :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666","flex":"1"}'>{{detail.fuwuneirong}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","flexWrap":"wrap","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>注意事项</view>
					<view class="text" :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666","flex":"1"}'>{{detail.zhuyishixiang}}</view>
				</view>





				<view class="bottom-content bg-white tabbar border shop" :style='{"padding":"0","margin":"20rpx 0 0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","height":"auto"}'>

					<button :style='{"border":"0","padding":"0 20rpx 0 20rpx","margin":"0 20rpx 12rpx 0","color":"#333","borderRadius":"0","background":"#fff000","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="userid&&isAuth('yuepaixinxi','下单')" @tap="onAcrossTap('dingdanxinxi','','','')" class="cu-btn bg-brown round shadow-blur" >下单</button>
					<button :style='{"border":"0","padding":"0 20rpx 0 20rpx","margin":"0 20rpx 12rpx 0","color":"#333","borderRadius":"0","background":"#fff000","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="!userid&&isAuthFront('yuepaixinxi','下单')" @tap="onAcrossTap('dingdanxinxi','','','')" class="cu-btn bg-brown round shadow-blur" >下单</button>
				</view>
			</view>

		</view>
	</view>
</mescroll-uni>
</view>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				id: '',
                userid: '',
				detail: {},
				swiperList: [],
				commentList: [],
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				user: null,
				storeupFlag: 0,
				count: 0,
				timer: null
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(options) {
			this.id = options.id;
            if(options.userid) {
                this.userid = options.userid;
            }
			// 渲染数据
			this.init();
		},
        onUnload() {
            if(this.timer) {
                clearInterval(this.timer);
            }
        },
		async onShow(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.getStoreup();
			let crossCleanType = uni.getStorageSync('crossCleanType')
            if(crossCleanType) {
				uni.removeStorageSync('crossCleanType')
                res = await this.$api.info('yuepaixinxi', this.id);
                this.detail = res.data;
            }
		},
		destroyed: function() {
			//window.clearInterval(this.inter);
		},
		methods: {
			// 支付
			onPayTap(){
				uni.setStorageSync('paytable','yuepaixinxi');
				uni.setStorageSync('payObject',this.detail);
				this.$utils.jump('../pay-confirm/pay-confirm?type=1')
			},
            onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
                this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
            },
			// 收藏
			async getStoreup() {
				if(!this.user){
					
					return false
				}
				let params = {
					page: 1,
					limit: 1,
					refid : this.id,
					tablename : 'yuepaixinxi',
					userid: this.user.id,
					type: 1,
				}
				let res = await this.$api.list(`storeup`, params);
				this.storeupFlag = res.data.list.length;
			},
			async shoucang(){
				if(!this.user){
					
					return false
				}
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid : _this.detail.id,
					tablename : 'yuepaixinxi',
					userid: _this.user.id,
					type: 1,
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length == 1) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消',
						success: async function(res) {
							if (res.confirm) {
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.detail.storeupnum--
								await _this.$api.update('yuepaixinxi',_this.detail)
								_this.$utils.msg('取消成功');
								_this.getStoreup();
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否收藏',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
								name: _this.detail.paishezhuti,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'yuepaixinxi',
                                type: 1
							});
							_this.detail.storeupnum++
							await _this.$api.update('yuepaixinxi',_this.detail)
							_this.$utils.msg('收藏成功');
							_this.getStoreup();
						}
					}
				});
			},
			// 跨表
			onAcrossTap(tableName,crossOptAudit,statusColumnName,tips,statusColumnValue){
				if(!this.user){
					
					return false
				}
				uni.setStorageSync('crossTable','yuepaixinxi');
				uni.setStorageSync(`crossObj`, this.detail);
				uni.setStorageSync(`statusColumnName`, statusColumnName);
				uni.setStorageSync(`statusColumnValue`, statusColumnValue);
				uni.setStorageSync(`tips`, tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = uni.getStorageSync('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$utils.msg(tips);
							return
						}
					}
				}
				this.$utils.jump(`../${tableName}/add-or-update?cross=true`);
			},
			// 获取详情
			async init(){
                if(this.timer) {
                    clearInterval(this.timer);
                }
				let res = await this.$api.info('yuepaixinxi', this.id);
				this.detail = res.data;
				// 轮播图片
				this.swiperList = this.detail.tupian ? this.detail.tupian.split(",") : [];
			},

			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},

			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				mescroll.resetUpScroll()
			},

			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				mescroll.endSuccess(mescroll.size, this.hasNext);

            },



			onChatTap() {
				this.$utils.jump('../chat/chat')
			},
			// 下载
			download(url){
				let _this = this;
				url=_this.$base.url +  url;
				uni.downloadFile({
					url: url,
					success: (res) => {
						if (res.statusCode === 200) {
							_this.$utils.msg('下载成功');
							 window.open(url);
						}
					}
				});
			},
			//
			onCartTabTap() {
				this.$utils.tab('../shop-cart/shop-cart')
			},
			// 添加评论
			async onCommentTap() {
				if(!this.user){
					
					return false
				}
				this.$utils.jump(`../discussyuepaixinxi/add-or-update?refid=${this.id}`)
			},
			onSHTap() {
				if(!this.user){
					
					return false
				}
				this.$refs.popup.open()
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.seat-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		background: #FFFFFF;
		margin: 20upx;
		border-radius: 20upx;
		padding: 20upx;
		font-size: 30upx;
		.seat-item {
			width: 33.33%;
			display: flex;
			align-items: center;
			flex-direction: column;
			margin-bottom: 20upx;
	
			.seat-icon {
				width: 50upx;
				height: 50upx;
				margin-bottom: 10upx;
			}
		}
	}
	
	audio {
		display: flex;
		flex-direction: column;
	}
	
	.audio /deep/ .uni-audio-default {
		width: inherit;
	}
</style>
