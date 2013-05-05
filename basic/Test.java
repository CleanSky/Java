Test.java源文件：
/*
* 如何编译运行Java程序
* 如何将程序中的文档注释提取出来生成说明文档
* 制作鼠标双击就可运行的Jar文件
*/
public class Test
{
	public static main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
	}
}

Test.java文件编译命令：
javac Test.java

Test程序执行命令：
java Test tom rose

将程序中的文档注释提取出来生成说明文档：
javadoc Test.java——生成HTML格式的Java程序说明文档


将Test.java打包为Test.jar命令：
jar -cvfm Test.jar myfest *.*

运行Test.jar文件：
java -jar Test.jar tom rose
