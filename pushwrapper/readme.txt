步骤如下 :
<1> 在github上面下载腾讯的mars,然后根据mars wiki说明,编译mars各个静态库;
<2> 直接将mars_android_sdk下面的java文件拷贝到工程,java文件的包路径不能够修改[除非同时修改jni代码,否则包名一定不能够改];
<3> 同时修改AndroidManifest.xml配置;
<4> 同时将mars_android_sdk里面的文件拷贝到android jni目录下,这个工程稍微分了一下类,include包含杂七杂八的辅助文件,src包含jni对接的核心程序,
    其中*.rewriteme 文件是可以自行根据工程调整的,不过修改的无非就是包结构和解包组包的操作.
<5> mars源码放到这个android工程源码根目录下即可,不然Android.mk里面需要修改路径
<5> 上面的文件都采用默认的.