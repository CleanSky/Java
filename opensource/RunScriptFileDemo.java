package com.bisn.opensource;

import java.io.FileReader;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/*
 * 在 Java中执行 JavaScript文件 (.js)
 */

public class RunScriptFileDemo {
	public static void main(String[] args) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		try {
			FileReader reader = new FileReader("Add.js");
			engine.eval(reader);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}