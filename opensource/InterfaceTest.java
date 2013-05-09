package com.bisn.opensource;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/*
 * Java 脚本引擎：使用线程方式来运行脚本
 */

public class InterfaceTest {
	public static void main(String args[]) throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		engine.eval("function run() {print('www.oschina.net');}");

		Invocable invokeEngine = (Invocable) engine;
		Runnable runner = invokeEngine.getInterface(Runnable.class);

		Thread t = new Thread(runner);
		t.start();
		t.join();
		System.out.println();

		//Java脚本引擎：给脚本传递参数
		try {
			engine.put("name", "abcde");
			engine.eval("var output = '';for (i = 0; i <= name.length; i++) {"
					+ "  output = name.charAt(i)+'-' + output" + "}");
			String name = (String) engine.get("output");
			System.out.println(name);
		} catch (ScriptException e) {
			System.err.println(e);
		}
	}
}
