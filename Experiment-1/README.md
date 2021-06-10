> 实验一 Java简单程序的调试与运行

## 一、实验目的：

1.  掌握正确安装与配置JDK的方法；

2.  掌握简单Java应用程序 的调试与运行； **二、实验时间：2021.3.30**

## 三、实验地点：C2-418 四、实验内容

> **五、实验要求**

1.  能够正确配置JDK;

2.  能在机器上正确运行程序。**六、实验结果分析：**

> 总结要求：包括实验内容总结，所出现问题以及解决方法，对实验的认识，不足之处等。

# 一、 JDK的安装与配置

### JDK安装

1.  打开下载页：https://[www.oracle.com/java/technologies/javase-jdk16-](http://www.oracle.com/java/technologies/javase-jdk16-) downloads.html

### 下载 Java SE Development Kit 16

2.  选择安装的操作系统"jdk-16_windows-x64_bin.exe"

> （适用于64位Windows系统）
>
> 注：适用于32位Windows系统的JDK请在下载页中搜索

3.  下载后执行安装（建议安装在C:\\Java）

### 设定系统变量(针对Windows2000)

> 在Windows10中，打开文件资源管理器，右键单击"此电脑"，选择 "属性"，点击"高级系统设置"则弹出一个名为\"系统特性\"的窗口，选择\"高级\"，然后选择\"环境变量\"，在\"环境变量\"窗口中编辑classpath和path。
>
> ![](media/image1.png){width="3.947505468066492in" height="4.921041119860018in"}

-   在「系统变量」中「新建」，其中「变量名称」设为JAVA_HOME，「变量值」设为刚才安装的目录下的jdk 文件夹(例如：C:\\j2sdk1.4.2)

-   在「系统变量」中「新建」，其中「变量名」设为

> classpath，「变量值」为
>
> .;%java_home%\\lib;%java_home%\\lib\\tools.jar

-   接着在原有的「系统变量」中找到PATH「编辑」，在

> 「变量值」的最前面加入
>
> %java_home%\\bin;%java_home%\\jre\\bin;
>
> ＿
>
> 新建(N).., 11 踪 (E) I 删 除(D)

![](media/image2.png)

> C o m S p ec C:\\ WI N\[)OWS\\ssy te m32.\\ c md．孜 e
>
> Drive rData C:\\ Wi n dows\\ Ssy te m32\\ Drive r叭Drive rData
>
> .IAVA HO ME C＼: Prog ra m F1i\| e5 \\I a va \\jdk-16
>
> ![](media/image4.png)症 取消

### 测试

> Windows键+R键，键入"cmd"，回车，打开在「命令提示字符」下
>
> 在「命令提示字符」下，打 java 指令，若没有出现找不到指令就可以了， 接着以程序直接测试。

# 二、构建Java程序

> **1、 第一个Java 应用程序**
>
> **1.1 输入以下程序代码，存成HelloWorld.java(档名必须一模一样，因为**
>
> **Java有分大小写，档案可以先存在C:\\下)**
>
> public class HelloWorld
>
> {
>
> public static void main(String args\[\])
>
> {
>
> System.out.println(\"Hello World !!\");
>
> }
>
> }
>
> ![](media/image6.png)
>
> 注意：1、一个.java文件只能有一个public类。
>
> 2、这个public类中有且只能有一个静态的main()方法。
>
> 3、如果.java文件中有public类，则文件名必须与该public类名一致。4、Java语言区分大小写。
>
> 5、注意在文件中不要加入排版信息（不要用office中的word来写代码）。
>
> 接着在「命令提示字符下」输入以下指令先切换到档案所在目录，例如C:\\
>
> 编译：输入下列命令：

javac HelloWorld.java

编译OK会产生Helloworld.class

## 运行

> JVM通过Java解释器来解释执行.class文件。java HelloWorld
>
> (显示) Hello World !!
>
> 如此JAVA开发环境就完成了。
>
> 补充：什么是编译执行，什么是解释执行。
>
> 高级语言所编制的程序必须经过转换才能被计算机解释执行，按转换方式可将它们分为两类:
>
> 解释类：一边翻译一边执行。不能脱离其解释器。
>
> 编译类：在应用源程序执行之前，就将程序源代码"翻译"成目标代码(机器语言)，因此其目标程序可以脱离其语言环境独立执行。

3.  **编译时常见错误**

> 1、错误：javac : Command not found.
>
> 原因：包含javac的编译器的路径变量设置不正确。需要正确设置环境变量path。
>
> 2、

![](media/image9.png){width="9.135236220472441in" height="2.9971872265966755in"}

> 原因：系统不认识的标识符
>
> 3、

![](media/image10.png){width="8.0748687664042in" height="3.751874453193351in"}

> 原因：公有类helloworld和文件名HelloWorld不一致。
>
> 4、

![](media/image11.png){width="8.813658136482939in" height="2.5135411198600175in"}

> 原因：执行命令应该是 **java 类名。**
>
> 注意执行命令中类名后不要加后缀名.class
>
> 5、

![](media/image12.png){width="7.862779965004375in" height="3.7548950131233596in"}

> 原因：文件名没有找到。注意大小写。

## 补充：java中的注释

1.  **单行注释：**从"//"开始到本行结束的内容都是注释，例如：

> //这是一行单行注释

2.  **多行注释：**在"/\*"和"\*/"之间的所有内容都是注释，例如：

> /\*这是一段注释分布在多行之中\*/

3.  **文档注释：**当程序员编完程序以后，可以通过JDK提供的**javadoc**命令，生成所编程序的API文档，该API文档以HTML文件的形式出现，与java帮助文档的风格与形式完全一致。凡是在\"/\*\*\"和\"\*/\"之间的内容都是文档注释。例如：

> public class HelloWorld
>
> {
>
> /\*\*成员变量说明：float类型。用于测试float数据类型\*/ float f=1.23f;
>
> /\*\*成员函数：main()函数\*/ public static void main(String arg\[\])
>
> {
>
> /\*\*输出helloworld\*/ System.out.println(\"dfdfd\");
>
> }
>
> }
>
> **2、 第一个Java 小应用程序**
>
> Java程序的另一种形式是Java Applet（Java小应用程序），Applet没有main() 方法，它必须嵌在超文本文件（HTML）中，在浏览器中进行运行。下面这个程序将在浏览器中显示一行字符串。
>
> //这是我们的第一个java applet，该程序保存在文件HelloEducation.java中
>
> **import java.awt.Graphics;** //在进行显示输出时，需要用到类Graphics的对象；
>
> **import java.applet.Applet;** //Applet类是所有的java applet的父类；
>
> **public class HelloEducation extends Applet {**
>
> //程序员给这个类取名为HelloEducation
>
> //所有的applet程序都是Applet类的子类
>
> **public String s; public void init() {**
>
> **s=new String(\"Welcome to Java World！\");**
>
> //生成一个字符串对象
>
> **}**
>
> **public void paint(Graphics g){**
>
> **g.drawString(s,25,25);**
>
> //在浏览器中坐标为（25，25）的位置显示字符串s
>
> **}**
>
> **}**
>
> **applet程序是从方法init( )开始执行的，在该方法中完成了对字符串s的初始化工作。**
>
> **显示功能是在方法paint( )中执行的。**
>
> **paint( )方法是类Applet的一个成员方法，其参数是图形对象Graphics g，通过调用对象g的drawString( )方法就可以显示输出。**
>
> **Java Applet程序也是一个类，其编译方式与java application完全一样， elloEducation.java程序经过编译以后就生成了HelloEducation.class文件。**
>
> **Java Applet的执行方式与Java Application不同， Java Applet程序必须嵌入到html 文件中才能够执行，因此必须编写相应的html文件，该HTMl文件的位置请放置在HelloEducation.class文件旁边。下面为HelloEducaiton.html文件的内容：**
>
> **\<html\>**
>
> **\<applet code=HelloEducation.class width=250 height=250\>**
>
> **\</applet\>**
>
> **\</html\>**
>
> **如果是在windows操作系统中，就可以在\"命令提示符\"下敲入\"appletviewer HelloEducation.html\"**
>
> 请认真完成实验报告！
>
> 实验报告格式如下：
>
> 1、 实验名称
>
> 2、 实验目的
>
> 3、 实验时间
>
> 4、 实验地点
>
> 5、 实验步骤（简述实验步骤，但不可出现"略"，"详见PPT"等用语。）

## 6、 实验中遇到的问题及解决方法

1.  对问题的描述（问题出现的背景描述）

2.  错误的操作描述

3.  错误的提示信息

4.  修正错误的方法

> 7、 回答实验指导书中提出的问题
>
> 8、 本次实验尚存的疑问
>
> 9、 对课堂知识点的验证
>
> 10、实验总结
>
> 本次实验验证的知识点如下：1、....
>
> 2、....
>
> 3、....
