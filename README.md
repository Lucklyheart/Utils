### Utils
一些经常使用的工具类，避免重复手写，一行代码搞定，值得拥有！
### What functions can be used
- ActivityUtil （栈管理器） 

'''
	//将Activity加入栈管理器
        ActivityUtil.getInstance().addActivity(this);
        //将Activity从栈管理器删除
        ActivityUtil.getInstance().finishActivity(this);
        //清空除栈管理器
        ActivityUtil.getInstance().finishAllActivity();
        //获取最后一个入栈的Activity
        ActivityUtil.getInstance().finishLastActivity();
        //获取最近的一个Activity
        ActivityUtil.getInstance().currentActivity();
        //退出APP
        ActivityUtil.getInstance().AppExit(this);
'''

- AppUtil （APP的工具类，包含版本号、版本名称、安装的应用程序ICON）
- BitmapUtil （工具类，获取Bitmap对象）
- ColorUtil  (定义了一些出场率较高的色值)
- CountDownTimerUtil （倒计时工具类）
- DateUtil （日期工具类）
- FileUtil （文件管理类）
- HttpUtil （原生HTTP请求工具）
- LogUtil （日志工具，调整为只在Debug模式下才有输出信息）
- MeasureUtil （测量控件大小的工具）
- NetWorkUtil （网络工具类，包含网络的判断、跳转到设置页面）
- PhoneUtil （手机组件工具类）
- PreferencesUtil （SharedPreferences工具类，包含常用的数值获取和存储）
- ProgressDlgUtil （进度条工具类）
- ReflectUtil （反射工具用于二次验证）
- ScreenUtil （屏幕工具类，涉及到屏幕宽度、高度、密度比、(像素、dp、sp)之间的转换等）
- SDCardUtil （SD卡工具类，包含SD卡状态、路径、容量大小）
- ShortCutUtil （创建删除快捷图标 需要权限：INSTALL_SHORTCUT和UNINSTALL_SHORTCUT）
- StringUtil （字符串工具类，提供一些字符串相关的便捷方法）
- ToastUtil （Tosat提醒）
- XmlUtil （XML文件工具类，包含：将xml文件解析成实体集合、获取xml标签值、将标签值解析成实体集合）
### How to use
#### Step 1. Add the JitPack repository to your build file 
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	} 
#### Step 2. Add the dependency 
	dependencies {
	        implementation 'com.github.Lucklyheart:Utils:v1.0.2'
	} 
### Final
	欢迎指导和建议！！！
