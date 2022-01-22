# 实验 4 输入输出流程序设计

1. 实验目的：
   1. 巩固面向对象的分析与设计流程，能够根据需求画出合理的类图；
   1. 熟悉 Java 中字符数据流 Reader、Writer 和 RandomAccessFile 的使用，以及数据流嵌套的方法；
   1. 根据设计结果编写并调试代码。
1. 实验时间：
1. 实验地点：
1. 实验内容：

   1. 设计乘法表类 Multiplication，该类可以通过 FileWriter 类将 9\*9 乘法表的结果整数写入 D:\data.txt。
   1. 使用 RandomAccessFile 实现简单的留言板：
      (1) 留言信息由作者，标题与留言内容三个部分组成。
      (2) 通过标准输入流 System.in 获取用户输入的三部分信息(关于 System.in 的用法请上网查阅)，使用 RandomAccessFile 将留言信息保存在 d:\message.txt 文件中。
      (3) 使用 RandomAccessFile 将留言信息逐行读出。

**注：**

(1)存入文件的每条留言的结构为：”author&title&content\n”  
(2)通过 RandomAccessFile 类的 readLine()方法读取出留言后，使用 StringTokenizer 类对 1 中的留言结构进行分析，通过’&’字符析取出留言的三个部分，分别显示。  
(3)如何为每条留言编号？如何将新留言插入文件尾部(追加记录)？  
(4)设计好界面类 Liuyan.java(负责和用户交互，并控制核心类工作)，核心功能类 Message.java,MessageSet.java(负责同数据文件交互)；  
(5)界面一共 3 个指令：“add”、“display”和“quit”，运行过程示例：  
![](https://cdn.nlark.com/yuque/0/2022/png/23075474/1642758867582-2595693e-fe19-465a-a9e7-219d7202f405.png#)

五、实验要求

1. 理解类与类之间的依赖关系；
2. 画出相应的类图与数据流模型图
3. 在实验过程中设计相应类包；
4. 在设计过程中要考虑到程序的可读性与可扩展性。

六、实验结果分析：

总结要求：包括实验内容总结，所出现问题以及解决方法，对实验的认识，不足之处等。
