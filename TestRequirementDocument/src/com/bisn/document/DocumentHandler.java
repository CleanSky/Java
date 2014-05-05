package com.bisn.document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.misc.BASE64Encoder;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 文档处理类
 */
public class DocumentHandler {
	private Configuration configuration = null;// 配置

	public DocumentHandler() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");// 设置默认编码格式
	}

	public void createDoc() {
		// 要填入模本的数据文件
		Map<String, Object> dataMap = new HashMap<String, Object>();
		getData(dataMap);
		// 设置模本装置方法和路径,FreeMarker支持多种模板装载方法。
		// 这里我们的模板是放在com.bisn.document.template包下面
		configuration.setClassForTemplateLoading(this.getClass(),
				"/com/bisn/document/template");
		Template t = null;
		try {
			// ftl文件为要装载的模板
			t = configuration
					.getTemplate("测试需求规格说明文档模板.ftl");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输出文档路径及名称，使用的是相对路径
		File outFile = new File("测试需求规格说明文档.doc");
		Writer out = null;
		try {
			try {
				out = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(outFile), "UTF-8"));// 以UTF-8编码方式向输出文档写数据
			} catch (UnsupportedEncodingException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			t.process(dataMap, out);// 向输出文档中写数据
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 注意dataMap里存放的数据Key值要与模板中的参数相对应
	 * Map中的标识与模板中的标号必须对应,否则会出错,而且不能为空
	 * @param dataMap
	 */
	private void getData(Map<String, Object> dataMap) {
		// 插值部分
		dataMap.put("danghao", "HIT-1");// 档号
		dataMap.put("bianhao", "HIT-1");// 编号
		dataMap.put("baoguanqixian", "三年");// 保管期限
		dataMap.put("banci", "1");// 版次
		dataMap.put("mingcheng", "飞控软件");// 名称
		dataMap.put("bianxie", "张  森   邹炳松");// 编写
		dataMap.put("jiaodui", "曲明成");// 校对
		dataMap.put("shenhe", "吴翔虎");// 审核
		dataMap.put("zhilianghuiqian", "计算机科学与技术学院");// 质量会签
		dataMap.put("pizhun", "哈尔滨工业大学");// 批准
		
		dataMap.put("neirongzhaiyao1", "飞行控制软件");// 内容摘要1
		dataMap.put("neirongzhaiyao2", "飞行控制软件");// 内容摘要2
		dataMap.put("neirongzhaiyao3", "飞行控制");// 内容摘要3
		dataMap.put("neirongzhaiyao4", "飞行控制软件");// 内容摘要4
		dataMap.put("zhutici", "长征7号   助推弹状态   飞行控制软件   配置项测试   需求规格说明");// 主题词
		
		dataMap.put("pizhunbiaoshi", "R_ZF_S_FX_X_TS_V1.0");// 批准标识
		dataMap.put("biaoti", "飞行控制软件测试需求规格说明");// 标题
		dataMap.put("beiceruanjianmingcheng", "飞行控制软件");// 被测软件名称
		
		dataMap.put("wendanggaishu1", "XXX");// 文档概述
		dataMap.put("wendanggaishu2", "XXX");// 文档概述
		dataMap.put("wendanggaishu3", "XXX");// 文档概述
		dataMap.put("beiceruanjianmiaoshu", "飞行控制软件代号为R/1BK-ZF/EF01-2.00。飞行控制软件是滑翔飞行器控制系统" +
				"设计的具体实现，其运行平台为控制组合主机板。它的主要任务是：实现射前飞行控制参数装订，完成弹地RS422通信，" +
				"数据接收和发送；实现射前瞄准、飞行器导航、制导与控制、前舱分离和安全自毁控制，以及向遥测系统发送遥测数据。");// 被测软件描述
		
		dataMap.put("jibenxinxi", "XXX");// 基本信息
		dataMap.put("anquandengji", "A级");// 安全等级
		dataMap.put("bianchengyuyan", "C");// 编程语言
		dataMap.put("ruanjianguimo", "大（16092行）");// 软件规模
		dataMap.put("bianyihuanjing", "CCS3.3");// 编译环境
		dataMap.put("beiceruanjiangongnengmiaoshu", "飞行控制软件实现射前飞行控制参数装订，完成弹地RS422通信，数据接收和发送；" +
				"实现射前瞄准、飞行器导航、制导与控制、前舱分离和安全自毁控制，以及向遥测系统发送遥测数据。飞行控制软件有制导、姿控、" +
				"综合三部分功能组成：其中制导部分完成射前制导初值计算、导航计算、时序判别、制导律计算及判别、前舱分离计算等功能；姿控部分" +
				"完成各级各通道姿态角计算、动静态增益计算、校正网络计算、姿态控制方程计算、姿控指令和信号输出等功能；综合部分完成弹地通讯、" +
				"输入信号采集处理、流程控制、时序输出、1553B总线通信、发送遥测数据等功能。");// 被测软件功能描述
		
		dataMap.put("image_yunxinghuanjing", getImageStr("yunxinghuanjing.jpg"));// 运行环境图
		dataMap.put("yunxinghuanjing", "飞控软件采用的开发工具为CCS3.3，编程语言为C语言，运行于控制组合AP1主板主CPU中，飞控计算机CPU为" +
				"DSP（SM32C6713BGDPS20EP）。");// 运行环境
		dataMap.put("ceshiduixiang", "XXX");// 测试对象
		
		dataMap.put("biaoshi", "DS_XXX_S_FX_P_001");// 标识
		dataMap.put("xiangmumingcheng", "飞行控制软件测试");// 项目名称
		dataMap.put("ruanjianmingcheng", "飞行控制软件");// 软件名称
		dataMap.put("banbenbiaoshi", "被测方标识：0；测试方标识：0；");// 版本标识
		dataMap.put("shenchaduixiang", "飞行控制软件源程序");// 审查对象

		
		
		// 第一张表：术语和缩略语
		List<Table1> _table1 = new ArrayList<Table1>();

		Table1 t1 = new Table1();
		t1.setShuyu("飞控软件");
		t1.setQuancheng("飞行控制软件");
		_table1.add(t1);// 往第一张表中加入一条数据

		Table1 t2 = new Table1();
		t2.setShuyu("拍、周期");
		t2.setQuancheng("5ms主控周期");
		_table1.add(t2);// 往第一张表中加入一条数据

		Table1 t3 = new Table1();
		t3.setShuyu("1553B");
		t3.setQuancheng("1553B总线");
		_table1.add(t3);// 往第一张表中加入一条数据

		Table1 t4 = new Table1();
		t4.setShuyu("软件任务书");
		t4.setQuancheng("飞行控制软件任务书");
		_table1.add(t4);// 往第一张表中加入一条数据

		Table1 t5 = new Table1();
		t5.setShuyu("YES");
		t5.setQuancheng("0xaaaa");
		_table1.add(t5);// 往第一张表中加入一条数据

		Table1 t6 = new Table1();
		t6.setShuyu("NO");
		t6.setQuancheng("0x5555");
		_table1.add(t6);// 往第一张表中加入一条数据

		dataMap.put("table1", _table1);// 往第一张表中加入数据

		
		
		// 第二张表：引用文件表
		List<Table2> _table2 = new ArrayList<Table2>();

		Table2 tt1 = new Table2();
		tt1.setMingcheng("飞行控制软件任务书");
		tt1.setWailaibiaoshi("DeDZFBK112-047RW");
		tt1.setCeshifangfabiaoshi("R_ZF_S_FX_X_RT_V1.0");
		tt1.setBianxiedanwei("三室");
		_table2.add(tt1);

		Table2 tt2 = new Table2();
		tt2.setMingcheng("飞行控制软件需求说明");
		tt2.setWailaibiaoshi("无");
		tt2.setCeshifangfabiaoshi("R_ZF_S_FX_X_RT_V1.0");
		tt2.setBianxiedanwei("八室");
		_table2.add(tt2);

		Table2 tt3 = new Table2();
		tt3.setMingcheng("控制系统软件总体结构与接口规格说明");
		tt3.setWailaibiaoshi("DeDZFBK112-058QW");
		tt3.setCeshifangfabiaoshi("无");
		tt3.setBianxiedanwei("八室");
		_table2.add(tt3);

		Table2 tt4 = new Table2();
		tt4.setMingcheng("控制系统1553B总线协议要求");
		tt4.setWailaibiaoshi("DeDZFBK112-062QW");
		tt4.setCeshifangfabiaoshi("无");
		tt4.setBianxiedanwei("12所");
		_table2.add(tt4);

		Table2 tt5 = new Table2();
		tt5.setMingcheng("滑翔飞行器串行通信统一化规定");
		tt5.setWailaibiaoshi("BT-353");
		tt5.setCeshifangfabiaoshi("无");
		tt5.setBianxiedanwei("八室");
		_table2.add(tt5);

		Table2 tt6 = new Table2();
		tt6.setMingcheng("测试需求规格说明编制规范");
		tt6.setWailaibiaoshi("无");
		tt6.setCeshifangfabiaoshi("RSTC/OI.401TSC-2010");
		tt6.setBianxiedanwei("软件站");
		_table2.add(tt6);
		
		dataMap.put("table2", _table2);// 往第二张表中加入数据
		
		
		
		// 第三张表：测试项优先级说明表
		List<Table3> _table3 = new ArrayList<Table3>();

		Table3 ttt1 = new Table3();
		ttt1.setCeshileixing("功能测试");
		ttt1.setCeshixiang("诸元装订及校核功能");
		ttt1.setYouxianji("高");
		_table3.add(ttt1);

		Table3 ttt2 = new Table3();
		ttt2.setCeshileixing("功能测试");
		ttt2.setCeshixiang("惯组检查功能");
		ttt2.setYouxianji("中");
		_table3.add(ttt2);

		Table3 ttt3 = new Table3();
		ttt3.setCeshileixing("功能测试");
		ttt3.setCeshixiang("不水平度测试功能");
		ttt3.setYouxianji("中");
		_table3.add(ttt3);

		Table3 ttt4 = new Table3();
		ttt4.setCeshileixing("功能测试");
		ttt4.setCeshixiang("电池激活中断响应");
		ttt4.setYouxianji("高");
		_table3.add(ttt4);

		Table3 ttt5 = new Table3();
		ttt5.setCeshileixing("功能测试");
		ttt5.setCeshixiang("转电中断响应");
		ttt5.setYouxianji("高");
		_table3.add(ttt5);

		Table3 ttt6 = new Table3();
		ttt6.setCeshileixing("接口测试");
		ttt6.setCeshixiang("惯组数据接收");
		ttt6.setYouxianji("高");
		_table3.add(ttt6);

		Table3 ttt7 = new Table3();
		ttt7.setCeshileixing("接口测试");
		ttt7.setCeshixiang("时序输出控制");
		ttt7.setYouxianji("高");
		_table3.add(ttt7);

		Table3 ttt8 = new Table3();
		ttt8.setCeshileixing("性能测试");
		ttt8.setCeshixiang("定时中断运行时间");
		ttt8.setYouxianji("高");
		_table3.add(ttt8);

		Table3 ttt9 = new Table3();
		ttt9.setCeshileixing("性能测试");
		ttt9.setCeshixiang("姿控延时时间");
		ttt9.setYouxianji("高");
		_table3.add(ttt9);

		Table3 ttt10 = new Table3();
		ttt10.setCeshileixing("性能测试");
		ttt10.setCeshixiang("时序输出延时");
		ttt10.setYouxianji("高");
		_table3.add(ttt10);

		Table3 ttt11 = new Table3();
		ttt11.setCeshileixing("余量测试");
		ttt11.setCeshixiang("程序空间余量测试");
		ttt11.setYouxianji("高");
		_table3.add(ttt11);

		Table3 ttt12 = new Table3();
		ttt12.setCeshileixing("静态分析");
		ttt12.setCeshixiang("无");
		ttt12.setYouxianji("中");
		_table3.add(ttt12);

		Table3 ttt13 = new Table3();
		ttt13.setCeshileixing("代码审查");
		ttt13.setCeshixiang("无");
		ttt13.setYouxianji("中");
		_table3.add(ttt13);
		
		dataMap.put("table3", _table3);// 往第三张表中加入数据
		
		
		
		// 第四张表：软件任务书与测试需求的追踪关系表
		List<Table4> _table4 = new ArrayList<Table4>();

		Table4 tttt1 = new Table4();
		tttt1.setZhangjiemingcheng("引言");
		tttt1.setZhangjiehao("1");
		tttt1.setCeshixiangmingcheng("-");
		tttt1.setCeshixiangbiaoshi("-");
		_table4.add(tttt1);

		Table4 tttt2 = new Table4();
		tttt2.setZhangjiemingcheng("来源背景");
		tttt2.setZhangjiehao("1.1");
		tttt2.setCeshixiangmingcheng("-");
		tttt2.setCeshixiangbiaoshi("-");
		_table4.add(tttt2);

		Table4 tttt3 = new Table4();
		tttt3.setZhangjiemingcheng("编写目的");
		tttt3.setZhangjiehao("1.2");
		tttt3.setCeshixiangmingcheng("-");
		tttt3.setCeshixiangbiaoshi("-");
		_table4.add(tttt3);
		
		dataMap.put("table4", _table4);// 往第四张表中加入数据
		
		
		
		// 第五张表：软件任务书与测试需求的追踪关系表
		List<Table5> _table5 = new ArrayList<Table5>();

		Table5 ttttt1 = new Table5();
		ttttt1.setZhangjiemingcheng("概述");
		ttttt1.setZhangjiehao("1");
		ttttt1.setCeshixiangmingcheng("-");
		ttttt1.setCeshixiangbiaoshi("-");
		_table5.add(ttttt1);

		Table5 ttttt2 = new Table5();
		ttttt2.setZhangjiemingcheng("编写目的");
		ttttt2.setZhangjiehao("1.1");
		ttttt2.setCeshixiangmingcheng("-");
		ttttt2.setCeshixiangbiaoshi("-");
		_table5.add(ttttt2);

		Table5 ttttt3 = new Table5();
		ttttt3.setZhangjiemingcheng("编写依据");
		ttttt3.setZhangjiehao("1.2");
		ttttt3.setCeshixiangmingcheng("-");
		ttttt3.setCeshixiangbiaoshi("-");
		_table5.add(ttttt3);

		dataMap.put("table5", _table5);// 往第五张表中加入数据
		
		
		
		// 第六张表：附录A 代码审查单
		List<Table6> _table6 = new ArrayList<Table6>();

		Table6 tttttt1 = new Table6();
		tttttt1.setXiangmu("系统初始化");
		tttttt1.setNeirong("DSP初始化");
		tttttt1.setHege("-");
		tttttt1.setShiyong("-");
		tttttt1.setBaogaodan("-");
		_table6.add(tttttt1);

		Table6 tttttt2 = new Table6();
		tttttt2.setXiangmu("系统初始化");
		tttttt2.setNeirong("中断控制器软复位");
		tttttt2.setHege("-");
		tttttt2.setShiyong("-");
		tttttt2.setBaogaodan("-");
		_table6.add(tttttt2);

		Table6 tttttt3 = new Table6();
		tttttt3.setXiangmu("系统初始化");
		tttttt3.setNeirong("DA初始化");
		tttttt3.setHege("-");
		tttttt3.setShiyong("-");
		tttttt3.setBaogaodan("-");
		_table6.add(tttttt3);
		
		dataMap.put("table6", _table6);// 往第六张表中加入数据
	}

	/**
	 * 图片的路径
	 * @param imgFile 图片路径
	 * @return
	 */
	private String getImageStr(String imgFile) {
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}

}
