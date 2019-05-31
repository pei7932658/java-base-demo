package com.sy;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DataDictionary {
	private static Map<String,Object> data = new HashMap<String,Object>();
	static{
		//1:支付方式
		Map<String,String> payType = new TreeMap<String,String>();
			payType.put("1", "现金全额");
			payType.put("2", "pos全额");
			payType.put("3", "现金部分");
			payType.put("4", "pos部分");
			payType.put("5", "赊账");
			data.put("payType", payType);
		//2:支付状态
		Map<String,String> payState = new TreeMap<String,String>();
			payState.put("0", "未支付");
			payState.put("1", "部分支付");
			payState.put("2", "支付完成");
			data.put("payState", payState);
		//3:记录状态
		Map<String,String> rowStatus = new TreeMap<String,String>();
			rowStatus.put("0", "已入职");
			rowStatus.put("1", "未入职");
			data.put("rowStatus", rowStatus);
		//4:是否状态
		Map<String,String> ynStatus = new TreeMap<String,String>();
			ynStatus.put("0", "否");
			ynStatus.put("1", "是");
			data.put("ynStatus", ynStatus);
		//5:订单状态
		Map<String,String> oderState = new TreeMap<String,String>();
			oderState.put("1", "正常");
			oderState.put("0", "删除");
			data.put("oderState", oderState);
		//6:设备状态
		Map<String,String> deviceState = new TreeMap<String,String>();
			deviceState.put("0", "未使用");
			deviceState.put("1", "使用中");
			deviceState.put("2", "待维修");
			deviceState.put("3", "维修中");
			deviceState.put("4", "回收");
			data.put("deviceState", deviceState);
		//7:提现状态
		Map<String,String> drawCashState = new TreeMap<String,String>();
			drawCashState.put("0", "申请中");
			drawCashState.put("1", "处理中");
			drawCashState.put("2", "处理成功");
			drawCashState.put("3", "处理失败");
			drawCashState.put("4", "状态未知");
			drawCashState.put("5", "审核中");
			data.put("drawCashState", drawCashState);
		//8:账单操作类型
		Map<String,String> billBizCode = new TreeMap<String,String>();
			billBizCode.put("1", "代表提现");
			billBizCode.put("2", "代表购买");
			billBizCode.put("3", "代表购买");
			billBizCode.put("4", "代表pos");
			data.put("billBizCode", billBizCode);
			
		//9:查看数据类型
		Map<String,String> dataType = new TreeMap<String,String>();
			dataType.put("1", "我的数据");
			dataType.put("2", "全部数据");
			data.put("dataType", dataType);
		//10:查看数据类型
		Map<String,String> userRole = new TreeMap<String,String>();
			userRole.put("1", "店主");
			userRole.put("2", "店长");
			userRole.put("3", "收银员");
			userRole.put("4", "收单员");
			userRole.put("5", "市场专员");
			data.put("userRole", userRole);
		//11:配置-标签分类
		Map<String,String> tagOneType = new TreeMap<String,String>();
			tagOneType.put("1", "客户");
			tagOneType.put("2", "供应商");
			data.put("tagOneType", tagOneType);
		//12:市场分类
		Map<String,String> marketType = new TreeMap<String,String>();
			marketType.put("1", "消费市场");
			marketType.put("2", "生产市场");
			marketType.put("3", "消费一级市场");
			marketType.put("4", "消费二级市场");
			data.put("marketType", marketType);
		//13:商品质量标准
		Map<String,String> goodsQualityType = new TreeMap<String,String>();
			goodsQualityType.put("1", "优质");
			goodsQualityType.put("2", "普通");
			goodsQualityType.put("3", "较差");
			data.put("goodsQualityType", goodsQualityType);
			
		//14:城市类型
		Map<String,String> cityType = new TreeMap<String,String>();
			cityType.put("1", "省");
			cityType.put("2", "市");
			cityType.put("3", "县");
			data.put("cityType", cityType);
		//15:优惠卷-发放方式
		Map<String,String> couponTypeInfo_Sendmode = new TreeMap<String,String>();
			couponTypeInfo_Sendmode.put("0", "后台赠券");
			couponTypeInfo_Sendmode.put("1", "注册赠券");
			couponTypeInfo_Sendmode.put("2", "购物赠券");
			couponTypeInfo_Sendmode.put("3", "用户领劵");
			couponTypeInfo_Sendmode.put("4", "活动赠券");
			data.put("couponTypeInfo_Sendmode", couponTypeInfo_Sendmode);
		//16:优惠卷-获得方式
		Map<String,String> couponTypeInfo_usegoodstype = new TreeMap<String,String>();
			couponTypeInfo_usegoodstype.put("0", "全部商品");
			couponTypeInfo_usegoodstype.put("1", "指定商品");
			data.put("couponTypeInfo_usegoodstype", couponTypeInfo_usegoodstype);
		//17:优惠卷-使用方式
		Map<String,String> couponTypeInfo_Usemode = new TreeMap<String,String>();
			couponTypeInfo_Usemode.put("0", "可叠加");
			couponTypeInfo_Usemode.put("1", "不可叠加");
			data.put("couponTypeInfo_Usemode", couponTypeInfo_Usemode);
		//18:优惠卷-使用状态
		Map<String,String> couponinfo_UseState = new TreeMap<String,String>();
			couponinfo_UseState.put("1", "未使用");
			couponinfo_UseState.put("2", "使用中");
			couponinfo_UseState.put("3", "已使用");
			couponinfo_UseState.put("4", "已过期");
			data.put("couponinfo_UseState", couponinfo_UseState);
		//19:平台广告管理-发布状态
		Map<String,String> actAdinfo_Pubstate = new TreeMap<String,String>();
			actAdinfo_Pubstate.put("0", "未发布");
			actAdinfo_Pubstate.put("1", "已发布");
			data.put("actAdinfo_Pubstate", actAdinfo_Pubstate);
		//20:供应商角色-供应商角色
		Map<String,String> supplierrole = new TreeMap<String,String>();
			supplierrole.put("0", "企业");
			supplierrole.put("1", "个人");
			data.put("supplierrole", supplierrole);
		//21:供应商-客户一级分类
		Map<String,String> c_onesource = new TreeMap<String,String>();
			c_onesource.put("0", "自主新增");
			c_onesource.put("1", "销售开发");
			data.put("c_onesource", c_onesource);
		//22:供应商-客户二级分类
		Map<String,String> c_twosource = new TreeMap<String,String>();
			c_twosource.put("0", "自主新增");
			c_twosource.put("1", "销售开发");
			data.put("c_twosource", c_twosource);
		//23:供应商-区域分类
		Map<String,String> c_areaid = new TreeMap<String,String>();
			c_areaid.put("0", "自主新增");
			c_areaid.put("1", "销售开发");
			data.put("c_areaid", c_areaid);
		//24:商品单位-暂时使用
		Map<String,String> goods_unit = new TreeMap<String,String>();
			goods_unit.put("36", "斤");
			goods_unit.put("40", "包");
			goods_unit.put("41", "箱");
			goods_unit.put("44", "袋");
			goods_unit.put("45", "公斤");
			goods_unit.put("49", "盒");
			goods_unit.put("50", "厅");
			goods_unit.put("53", "只");
			goods_unit.put("65", "件");
			goods_unit.put("66", "打");
			goods_unit.put("67", "瓶");
			goods_unit.put("70", "桶");
			goods_unit.put("104", "罐");
			goods_unit.put("38", "个");
			goods_unit.put("105", "听 ");
			goods_unit.put("106", "提 ");
			goods_unit.put("107", "杯");
			goods_unit.put("108", "板");
			goods_unit.put("109", "碗");
			goods_unit.put("46", "条");
			goods_unit.put("110", "壶");
			goods_unit.put("62", "把");
			goods_unit.put("111", "筒");
			goods_unit.put("112", "块");
			goods_unit.put("113", "根");
			goods_unit.put("114", "双");
			goods_unit.put("115", "粒");
			goods_unit.put("116", "套");
			goods_unit.put("39", "支");
			goods_unit.put("117", "节");
			goods_unit.put("118", "床");
			data.put("goods_unit", goods_unit);
		//25:供应商管理supplier申请状态
		Map<String,String> priceApplyState = new TreeMap<String,String>();
			priceApplyState.put("0", "未申请");
			priceApplyState.put("1", "申请成功");
			priceApplyState.put("2", "申请中");
			priceApplyState.put("3", "申请失败");
			data.put("priceApplyState", priceApplyState);
		//26:商品单位-暂时使用
		Map<String,String> b2bPayState = new TreeMap<String,String>();
			b2bPayState.put("0", "不需要");
			b2bPayState.put("1", "未支付");
			b2bPayState.put("2", "支付成功");
			b2bPayState.put("3", "支付失败");
			b2bPayState.put("4", "支付中");
			data.put("b2bPayState", b2bPayState);
		//27:发货状态
		Map<String,String> b2bSendState = new TreeMap<String,String>();
			b2bSendState.put("0", "不需要");
			b2bSendState.put("1", "未发货");
			b2bSendState.put("2", "已发货");
			b2bSendState.put("3", "部分发货");
			data.put("b2bSendState", b2bSendState);
		//28:收货状态
		Map<String,String> b2bReceiveState = new TreeMap<String,String>();
			b2bReceiveState.put("1", "未收货");
			b2bReceiveState.put("2", "已签收");
			b2bReceiveState.put("3", "拒绝收货");
			data.put("b2bReceiveState", b2bReceiveState);
		//29:订单状态
		Map<String,String> b2bOrderState = new TreeMap<String,String>();
			b2bOrderState.put("0", "有效：未审核");
			b2bOrderState.put("1", "有效：已审核");
			b2bOrderState.put("2", "过期");
			b2bOrderState.put("3", "删除");
			b2bOrderState.put("4", "完成");
			b2bOrderState.put("5", "关闭");
			b2bOrderState.put("6", "审核失败");
			data.put("b2bOrderState", b2bOrderState);
		//30:收单-欠款时间
		Map<String,String> repaymentTimeLimit = new TreeMap<String,String>();
			repaymentTimeLimit.put("0", "无");
			repaymentTimeLimit.put("7", "一周");
			repaymentTimeLimit.put("15", "半个月");
			repaymentTimeLimit.put("30", "一个月");
			repaymentTimeLimit.put("90", "三个月");
			data.put("repaymentTimeLimit", repaymentTimeLimit);
		//31:活动管理里的广告位置
		Map<String,String> act_adsit_location = new TreeMap<String,String>();
			act_adsit_location.put("0", "区左");
			act_adsit_location.put("1", "区右");
			act_adsit_location.put("2", "区上");
			act_adsit_location.put("3", "区下");
			act_adsit_location.put("4", "弹出");
			data.put("act_adsit_location", act_adsit_location);
		//32:b2b分拣状态
		Map<String,String> b2bSortingState = new TreeMap<String,String>();
			b2bSortingState.put("1", "未分拣");
			b2bSortingState.put("2", "分拣中");
			b2bSortingState.put("3", "分拣完成");
			b2bSortingState.put("4", "不需要分拣");
			b2bSortingState.put("5", "部分分拣成功");
			data.put("b2bSortingState", b2bSortingState);
		//33:客户销售来源
			Map<String,String> customer_salemanid = new TreeMap<String,String>();
			customer_salemanid.put("1", "李竹青");
			customer_salemanid.put("2", "邱东波");
			customer_salemanid.put("3", "李成洁");
			customer_salemanid.put("4", "邱东方");
			customer_salemanid.put("5", "毕小露");
			customer_salemanid.put("6", "汪爽");
			customer_salemanid.put("7", "胡响斌");
			customer_salemanid.put("8", "王伟");
			customer_salemanid.put("9", "张琴");
			customer_salemanid.put("10", "罗兰");
			data.put("customer_salemanid", customer_salemanid);
//		//34:活动分类
//		Map<String,String> fullgiftInfo_actType = new TreeMap<String,String>();
//			fullgiftInfo_actType.put("1", "满减");
//			fullgiftInfo_actType.put("2", "满折");
//			data.put("fullgiftInfo_actType", fullgiftInfo_actType);
		//35:活动分类赠品分类 	
		Map<String,String> fullgiftInfo_giveType = new TreeMap<String,String>();
			fullgiftInfo_giveType.put("1", "商品");
			fullgiftInfo_giveType.put("2", "优惠券");
			fullgiftInfo_giveType.put("3", "积分");
			data.put("fullgiftInfo_giveType", fullgiftInfo_giveType);
		//36:活动分类	
		Map<String,String> full2goodsInfo_actType = new TreeMap<String,String>();
			full2goodsInfo_actType.put("1", "满减");
			full2goodsInfo_actType.put("2", "满折");
			full2goodsInfo_actType.put("3", "满送");
			data.put("full2goodsInfo_actType", full2goodsInfo_actType);
		//37:供应商：派单模式
		Map<String,String> suporder_ordermode = new TreeMap<String,String>();
			suporder_ordermode.put("0", "派单模式");
			suporder_ordermode.put("1", "抢单模式");
			data.put("suporder_ordermode", suporder_ordermode);
		//38:供应商：送到仓库
		Map<String,String> suporder_sendway = new TreeMap<String,String>();
			suporder_sendway.put("0", "送到仓库");
			suporder_sendway.put("1", "采购方自提");
			data.put("suporder_sendway", suporder_sendway);
		//39:供应商：送货状态
		Map<String,String> suporder_sendstate = new TreeMap<String,String>();
			suporder_sendstate.put("0", "已送货");
			suporder_sendstate.put("1", "未送货");
			data.put("suporder_sendstate", suporder_sendstate);
		//40:供应商：结算状态
		Map<String,String> suporder_settlestate = new TreeMap<String,String>();
			suporder_settlestate.put("0", "已结算");
			suporder_settlestate.put("1", "待结算");
			data.put("suporder_settlestate", suporder_settlestate);
		//41:供应商：送货状态
		Map<String,String> suporder_orderstate = new TreeMap<String,String>();
			suporder_orderstate.put("1", "未接单");
			suporder_orderstate.put("2", "已接单");
			suporder_orderstate.put("3", "放弃订单");
			suporder_orderstate.put("4", "过期订单");
			suporder_orderstate.put("5", "删除订单");
			suporder_orderstate.put("6", "未审核");
			suporder_orderstate.put("7", "已完成");
			data.put("suporder_sendstate", suporder_orderstate);
		//42退换货审核状态
		Map<String,String> refund_AuditState = new TreeMap<String,String>();
			refund_AuditState.put("0", "申请");
			refund_AuditState.put("1", "同意-未取货");
			refund_AuditState.put("2", "同意-已取货");
			refund_AuditState.put("3", "拒绝");
			data.put("refund_AuditState", refund_AuditState);
		//43退换货退货状态
		Map<String,String> refund_ReturnState = new TreeMap<String,String>();
			refund_ReturnState.put("1", "退货申请");
			refund_ReturnState.put("2", "退货成功");
			refund_ReturnState.put("3", "退货失败");
			refund_ReturnState.put("4", "退货中");
			data.put("refund_ReturnState", refund_ReturnState);
		//44物流车类型
		Map<String,String> deleveruser_carType = new TreeMap<String,String>();
			deleveruser_carType.put("1", "小型车");
			deleveruser_carType.put("2", "中型车");
			deleveruser_carType.put("3", "大型车");
			data.put("deleveruser_carType", deleveruser_carType);
		//45退换货分类
		Map<String,String> refund_kind = new TreeMap<String,String>();
			refund_kind.put("1", "退货");
			refund_kind.put("2", "换货");
			data.put("refund_kind", refund_kind);
		//46退换货审核状态
		Map<String,String> refund_AuditState_audit = new TreeMap<String,String>();
//			refund_AuditState_audit.put("1", "同意-未取货");
			refund_AuditState_audit.put("2", "同意-已取货");
			refund_AuditState_audit.put("3", "拒绝");
			data.put("refund_AuditState_audit", refund_AuditState_audit);
		//47:订单支付方式
		Map<String,String> order_PayWay = new TreeMap<String,String>();
			order_PayWay.put("0", "无");
			order_PayWay.put("1", "POS支付");
			order_PayWay.put("2", "现金支付");
			order_PayWay.put("3", "在线支付");
			order_PayWay.put("4", "账户余额");
			data.put("order_PayWay", order_PayWay);
		//48:订单支付渠道
		Map<String,String> order_PayChannel = new TreeMap<String,String>();
			order_PayChannel.put("1", "微信");
			order_PayChannel.put("2", "支付宝");
			order_PayChannel.put("3", "农商宝");
			order_PayChannel.put("4", "账户余额");
			data.put("order_PayChannel", order_PayChannel);
		//49:订单支付渠道
		Map<String,String> b2brefundPayState = new TreeMap<String,String>();
			b2brefundPayState.put("0", "不需要");
			b2brefundPayState.put("1", "未支付");
			b2brefundPayState.put("2", "支付成功");
			b2brefundPayState.put("3", "支付失败");
			b2brefundPayState.put("4", "支付中");
			b2brefundPayState.put("6", "支付关闭");
				data.put("b2brefundPayState", b2brefundPayState);
		//50:记录状态
		Map<String,String> row_Status = new TreeMap<String,String>();
			row_Status.put("0", "有效");
			row_Status.put("1", "无效");
			data.put("row_Status", row_Status);
		//51:商品限够
		Map<String,String> goods_MaxType = new TreeMap<String,String>();
			goods_MaxType.put("-1", "无限制");
			goods_MaxType.put("1", "每人每天");
			goods_MaxType.put("2", "每人");
			data.put("goods_MaxType", goods_MaxType);
		//52:优惠券发布状态
		Map<String,String> ActCouponPubstate = new TreeMap<String,String>();
			ActCouponPubstate.put("0", "未发布");
			ActCouponPubstate.put("1", "已发布-正常");
			ActCouponPubstate.put("2", "已发布-停用");
			data.put("ActCouponPubstate", ActCouponPubstate);
		//53:配送发货状态
		Map<String,String> dispatch_sendstate = new TreeMap<String,String>();
			dispatch_sendstate.put("0", "不需要");
			dispatch_sendstate.put("1", "未发货");
			dispatch_sendstate.put("2", "已发货");
			dispatch_sendstate.put("3", "已签收");
			dispatch_sendstate.put("4", "派送中");
			dispatch_sendstate.put("5", "拒签收");
			data.put("dispatch_sendstate", dispatch_sendstate);
		//53:配送审核状态
		Map<String,String> dispatch_auditstate = new TreeMap<String,String>();
			dispatch_auditstate.put("1", "未审核");
			dispatch_auditstate.put("2", "审核通过");
			dispatch_auditstate.put("3", "审核失败");
			data.put("dispatch_auditstate", dispatch_auditstate);
		//54:退货理由
		Map<String,String> refund_reason = new TreeMap<String,String>();
			refund_reason.put("0", "重复拍了");
			refund_reason.put("1", "质量问题");
			refund_reason.put("2", "不喜欢/不想买了");
			refund_reason.put("3", "卖家发错货");
			refund_reason.put("4", "其它");
			data.put("refund_reason", refund_reason);
		//55:商品基本信息
		Map<String,String> goods_Opway = new TreeMap<String,String>();
			goods_Opway.put("1", "自营");
			goods_Opway.put("2", "代运营");
			goods_Opway.put("3", "商户运营");
			data.put("goods_Opway", goods_Opway);
		//56:商品基本信息
		Map<String,String> goods_GoodsSource = new TreeMap<String,String>();
			goods_GoodsSource.put("1", "供应商供货");
			goods_GoodsSource.put("2", "仓库供货");
			data.put("goods_GoodsSource", goods_GoodsSource);
		//57:商品信息中渠道商分成
		Map<String,String> channel_DivideWayType = new TreeMap<String,String>();
			channel_DivideWayType.put("1", "比例分成");
			channel_DivideWayType.put("2", "金额分成");
			data.put("channel_DivideWayType", channel_DivideWayType);
		//58:渠道商级别
		Map<String,String> shop_channelLevel = new TreeMap<String,String>();
			shop_channelLevel.put("1", "一级");
			shop_channelLevel.put("2", "二级");
			shop_channelLevel.put("3", "三级");
			shop_channelLevel.put("4", "四级");
			data.put("shop_channelLevel", shop_channelLevel);
		//59:渠道商分类
		Map<String,String> shop_channelType = new TreeMap<String,String>();
			shop_channelType.put("1", "企业");
			shop_channelType.put("2", "个人");
			data.put("shop_channelType", shop_channelType);
		//60:订单配送方式
		Map<String,String> B2BOrder_SendWay = new TreeMap<String,String>();
			B2BOrder_SendWay.put("0", "不要配送");
			B2BOrder_SendWay.put("1", "送货上门");
			B2BOrder_SendWay.put("2", "自提");
			B2BOrder_SendWay.put("3", "快递");
			B2BOrder_SendWay.put("4", "大宗物流");
			data.put("B2BOrder_SendWay", B2BOrder_SendWay);
			
	}
	
	public static void main(String[] args) {
//		System.out.println(JSON.toJSONString(DataDictionary.data));
		System.out.println(JSON.toJSONString(DataDictionary.data));
		File file = new File("D:\\dataJson.json");
		if(file.exists()){
			file.delete();
		}
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			fw.write(JSON.toJSONString(DataDictionary.data));
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

