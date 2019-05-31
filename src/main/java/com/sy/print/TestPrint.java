//package com.sy.print;
//
//import java.util.Vector;
//
//import com.gprinter.command.EscCommand;
//
//public class TestPrint {
//	public static void main(String[] args) {
//		sendReceipt();
//	}
//	public static void sendReceipt(){
//        EscCommand esc = new EscCommand();
//        esc.addPrintAndFeedLines((byte)3);
//        esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);//设置打印居中
//        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF,
//                EscCommand.ENABLE.ON, EscCommand.ENABLE.ON, EscCommand.ENABLE.OFF);//设置为倍高倍宽
//        esc.addText("Sample\n");   //  打印文字
//        esc.addPrintAndLineFeed();
//
//		/*打印文字*/
//        esc.addSelectPrintModes(EscCommand.FONT.FONTA, EscCommand.ENABLE.OFF,EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF, EscCommand.ENABLE.OFF);//取消倍高倍宽
////        esc.addSelectJustification(EscCommand.JUSTIFICATION.LEFT);//设置打印左对齐
//        esc.addText("鄂豫皖农商大市场\n");   //  打印文字
////        esc.addText("Welcome to use Gprinter!\n");   //  打印文字
//        esc.addPrintAndLineFeed();
//		/*打印图片*/
////
//
//		/*打印一维条码        esc.addText("Print bitmap!\n");   //  打印文字
////        Bitmap b = BitmapFactory.decodeResource(getResources(),
////                R.drawable.loading1);
////        esc.addRastBitImage(b,b.getWidth(),0);   //打印图片*/
//        esc.addText("Print code128\n");   //  打印文字
//        esc.addSelectPrintingPositionForHRICharacters(EscCommand.HRI_POSITION.BELOW);//设置条码可识别字符位置在条码下方
//        esc.addSetBarcodeHeight((byte)30); //设置条码高度为60点
//        esc.addCODE128("08150013");
////        esc.addCODABAR("201608150013");
////        esc.addCODE128("Gprinter");  //打印Code128码
//        esc.addPrintAndLineFeed();
//
//		/*QRCode命令打印
//			此命令只在支持QRCode命令打印的机型才能使用。
//			在不支持二维码指令打印的机型上，则需要发送二维条码图片
//		*/
//        esc.addText("Print QRcode\n");   //  打印文字
//        esc.addSelectErrorCorrectionLevelForQRCode((byte)0x31); //设置纠错等级
//        esc.addSelectSizeOfModuleForQRCode((byte)3);//设置qrcode模块大小
//        esc.addStoreQRCodeData("www.gprinter.com.cn");//设置qrcode内容
//        esc.addPrintQRCode();//打印QRCode
//        esc.addPrintAndLineFeed();
//
//		/*打印文字*/
//        esc.addSelectJustification(EscCommand.JUSTIFICATION.CENTER);//设置打印左对齐
//        esc.addText("今天天气不错!\r\n");
//        esc.addText("Completed!\r\n");   //  打印结束
//        esc.addPrintAndFeedLines((byte)8);
//
//        Vector<Byte> datas = esc.getCommand(); //发送数据
///*        Byte[] Bytes = datas.toArray(new Byte[datas.size()]);
//        byte[] bytes = ArrayUtils.toPrimitive(Bytes);
//        String str = Base64.encodeToString(bytes, Base64.DEFAULT);
//        int rel;
//        try {
//            rel = mGpService.sendEscCommand(mPrinterIndex, str);
//            GpCom.ERROR_CODE r=GpCom.ERROR_CODE.values()[rel];
//            if(r != GpCom.ERROR_CODE.SUCCESS){
//                Toast.makeText(getApplicationContext(),GpCom.getErrorText(r),
//                        Toast.LENGTH_SHORT).show();
//
//        } catch (RemoteException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }}*/
//    }
//}
