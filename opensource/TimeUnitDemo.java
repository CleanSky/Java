package com.bisn.opensource;

import java.util.concurrent.TimeUnit;

/*
 * TimeUnit表示给定单元粒度的时间段，它提供在这些单元中进行跨单元转换和执行计时及延迟操作的实用工具方法。
 * TimeUnit不维护时间信息，但是有助于组织和使用可能跨各种上下文单独维护的时间表示形式。
 * TimeUnit主要用于通知基于时间的方法如何解释给定的计时参数。
 */

public class TimeUnitDemo {
	public static void main(String[] args) {
		TimeUnit tu = TimeUnit.DAYS;

		System.out.println(tu.toDays(1));
		System.out.println(tu.toHours(1));
		System.out.println(tu.toMinutes(1));
	}
}
