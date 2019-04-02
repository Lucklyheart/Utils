### Utils
一些经常使用的工具类，避免重复手写，一行代码搞定，值得拥有！
### What functions can be used
- ActivityUtil （栈管理器）

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
- AppUtil （APP的工具类，包含版本号、版本名称、安装的应用程序ICON）
	
		//获取APP的icon
        Drawable drawable = AppUtil.getApplicationIcon(this);
        //获取设备上安装的所有应用的包信息
        List<PackageInfo> list = AppUtil.getInstalledPackages(this);
        //获取APP的包名
        String packageName = AppUtil.getPackageName(this);
        //获取APP的versionCode值
        int versionCode = AppUtil.getVersionCode(this);
        //获取APP的versionName值
        String versionName = AppUtil.getVersionName(this);
        //安装指定路径下的APP
        AppUtil.installApk(this, "将要安装的APP的路径");
- BitmapUtil （工具类，获取Bitmap对象）
 		
		//将bitmap转成二进制
        Byte[] bytes = BitmapUtil.bitmapToByte(Bitmap);
        //将Bitmap转成Drawable
        Drawable drawable = BitmapUtil.bitmapToDrawable(this, Bitmap);
        //将Drawable转成Bitmap
        Bitmap bitmap = BitmapUtil.drawableToBitmap(Drawable);
        //获取指定路径下的指定大小的图片
        Bitmap bitmap  BitmapUtil.getBitmapFromFile(path, height, width);
        //获取资源文件中指定ID，指定大小的图片
        Bitmap bitmap  BitmapUtil.getBitmapFromResource(this,id,height,width);
        //获取指定图片，指定大小的缩略图
        Bitmap bitmap  BitmapUtil.getThumbnailsBitmap(Bitmap,height,width);
- ColorUtil  (定义了一些出场率较高的色值) 
	
		定义了69种常用色值供使用
- CountDownTimerUtil （倒计时工具类）
	
		//millisInFuture：总时长
        //countDownInterval：每次减少时长
        //button控件
        //enable：可点击时控件背景
        //disable：不可点击时控件背景
        new CountDownTimerUtil( millisInFuture,  countDownInterval,  button,  enable,  disable);
- DateUtil （日期工具类）
	 	
		//将日期格式化成pattern样式如：YY-MM-DD hh:mm:ss
        String date = DateUtil.dateToString(Data, pattern);
        //获取某年的某月有几天
        int days = DateUtil.daysOfMonth(year, month);
        //获取这天是本周的第几天
        int days = DateUtil.getIndexWeekOfDate(Date);
        //获取格式化后的当天日期
        String date = DateUtil.getNowDate(pattern);
        //获取当前日期
        int days = DateUtil.getNowDay();
        //获取当前月份
        int month = DateUtil.getNowMonth();
        //获取当前年份
        int year = DateUtil.getNowYear();
        //获取当前日期月份有几天
        int days = DateUtil.getNowDaysOfMonth();
- FileUtil （文件管理类）
		
		//是否复制指定source文件到目标文件target
        FileUtil.copy(source, target, boolean);
        //是否删除指定path文件夹
        FileUtil.delDir(path, boolean);
        //删除指定path文件
        FileUtil.delFile(path);
        //新建指定path文件夹
        FileUtil.mkDir(path);
        //是否新加指定path文件
        FileUtil.mkFile(path, boolean);
- HttpUtil （原生HTTP请求工具）
	
		//get同步请求
        String result = HttpUtil.doGet(url);
        //get异步请求
        HttpUtil.doGetAsyn(url, new HttpUtil.CallBack() {
            @Override
            public void onRequestComplete(String s) {
                //do something
            }
        });
	
        //post同步请求
        String result=HttpUtil.doPost(url,param);
        //post异步请求
        HttpUtil.doPostAsyn(url, param,new HttpUtil.CallBack() {
            @Override
            public void onRequestComplete(String s) {
                //do something
            }
        });
    }
- LogUtil （日志工具，调整为只在Debug模式下才有输出信息）

		//只有在debug模式下日志信息才会输出
        LogUtil.d(msg);
        LogUtil.d(msg,throwable);
        LogUtil.e(msg);
        LogUtil.e(msg,throwable);
        LogUtil.i(msg);
        LogUtil.i(msg,throwable);
        LogUtil.v(msg);
        LogUtil.v(msg,throwable);
- MeasureUtil （测量控件大小的工具）

		//获取View高度
        MeasureUtil.getHeight(View);
        //获取View宽度
        MeasureUtil.getWidth(View);
        //设置View 测量高度
        MeasureUtil.getMeasuredHeight(View);
        //设置View测量宽度
        MeasureUtil.getMeasuredWidth(View);
        //设置View高度
        MeasureUtil.setHeight(View,height);
        //设置View宽度
        MeasureUtil.setWidth(View,width);
        //设置listview实际高度
        MeasureUtil.setListHeight(ListView);
        //设置grideview高度，n:行数，m:列数
        MeasureUtil.setGridViewHeight(Context, GridView,n,m);
- NetWorkUtil （网络工具类，包含网络的判断、跳转到设置页面）
		
		//打开设置
        NetWorkUtil.openSetting(Activity);
        //跳转到网络设置
        NetWorkUtil.GoSetting(Activity);
        //判断MOBILE网络是否可用
        NetWorkUtil.isMobileDataEnable(Context);
        //判断当前是否有网络连接
        NetWorkUtil.isNetWorkEnable(Context);
        //判断当前是否有wifi网络连接
        NetWorkUtil.isWiFiConnected(Context);
        //判断wifi网络是否可用
        NetWorkUtil.isWifiDataEnable(Context);
- PhoneUtil （手机组件工具类）
	
		//获取手机品牌
        PhoneUtil.getMobileBrand(Context);
        //获取手机型号
        PhoneUtil.getMobileModel(Context);
        //是否双击
        PhoneUtil.isFastDoubleClick();
        //发送短信
        PhoneUtil.sendMessage(Activity,phoneNumber,smsContent);
        //打开相册
        PhoneUtil.toTakePicture(requestCode,Activity);
        //打开相机 fileName：要保存的文件名
        PhoneUtil.toTakePhoto(requestCode,Activity,fileName);
- PreferencesUtil （SharedPreferences工具类，包含常用的数值获取和存储）
	 	
		//清空数据
        PreferencesUtil.clearValues(Context);
        //是否包含键
        PreferencesUtil.containsKey(Context,key);
        //删除键
        PreferencesUtil.removeKey(Context,key);
        //存储数据
        PreferencesUtil.put(Context,key,value);
        //根据键获取值
        PreferencesUtil.get(Context,key,defaultValue);
        //根据键获取集合
        PreferencesUtil.getStringSet(Context.setKey,defaultSet);
        //存储集合
        PreferencesUtil.putStringSet(Context,setKey,Set);
        //获取所有存储信息Map
        PreferencesUtil.getAll(Context);
- ProgressDlgUtil （进度条工具类）
	
		//圆形进度条
        ProgressDlgUtil.show(Context);
        ProgressDlgUtil.dismiss();
- ReflectUtil （反射工具用于二次验证）
	
		//根据字段名称获取指定Field字段
        ReflectUtil.getField(Class<?> clazz, String filedName);
        //根据字段名称获取指定的Field
        ReflectUtil.getFieldByName(Field[] fields, String fieldName);
        //判断该字段是否为FieldName对应字段
        ReflectUtil.isFiledWithName(Field field, String fieldName);
        //设置字段值
        ReflectUtil.setFieldValue(T t,Field field, String fieldName, String value);
- ScreenUtil （屏幕工具类，涉及到屏幕宽度、高度、密度比、(像素、dp、sp)之间的转换等）
	
		//dip转换为px大小
        ScreenUtil.dp2px(Context, dpValue);
        //px转换为dp值
        ScreenUtil.px2dp(Context, pxValue);
        //px转换为sp
        ScreenUtil.px2sp(Context, pxValue);
        //sp转换为px
        ScreenUtil.sp2px(Context, spValue);
        //获取系统dp尺寸密度值
        ScreenUtil.getDensity(Context);
        //获取DisplayMetrics对象
        ScreenUtil.getDisplayMetrics(Context);
        //获取系统字体sp密度值
        ScreenUtil.getScaledDensity(Context);
        // 获取屏幕宽度，单位为px
        ScreenUtil.getScreenWidth(Context);
        //获取屏幕高度，单位为px
        ScreenUtil.getScreenHeight(Context);
        //获得状态栏的高度
        ScreenUtil.getStatusHeight(Context);
        //获取当前屏幕截图，包含状态栏
        ScreenUtil.snapShotWithStatusBar(Activity);
        //获取当前屏幕截图，不包含状态栏
        ScreenUtil.snapShotWithoutStatusBar(Activity);
- SDCardUtil （SD卡工具类，包含SD卡状态、路径、容量大小）
	
		//data/data/PackageName/cache的路径
        SDCardUtil.getDataCachePath(Context);
        //获取应用程序的/data/data目录
        SDCardUtil.getDataFilePath(Context);
        //获取SD卡可用大小
        SDCardUtil.getSDCardAvailableSize();
        //获取SD卡DownloadCache路径文件
        SDCardUtil.getSDCardDownloadCacheFile();
        //获取SD卡DownloadCache路径
        SDCardUtil.getSDCardDownloadCachePath();
        //获取SD卡路径文件
        SDCardUtil.getSDCardFile();
        //获取系统存储路径文件
        SDCardUtil.getSDCardRootFile();
        //获取SD卡大小
        SDCardUtil.getSDCardSize();
        //获取系统存储路径
        SDCardUtil.getSDCardRootPath();
        //获取SD卡路径
        SDCardUtil.getSDCradPath();
        //判断SD卡是否可用
        SDCardUtil.isSDCardEnable();

- ShortCutUtil （创建删除快捷图标 需要权限：INSTALL_SHORTCUT和UNINSTALL_SHORTCUT）
	
		//为程序创建桌面快捷方式
        ShortCutUtil.addShortcut(Activity,res);
        // 检测是否存在快方式
        ShortCutUtil.hasShortcut(Activity);
        //删除程序的快捷方式
        ShortCutUtil.delShortcut(Activity);
- StringUtil （字符串工具类，提供一些字符串相关的便捷方法）
	
		包含了一些常用的字符串检测：格式转换、空判断、MD5加密、大小写判断、长度、截取、格式化等操作
- ToastUtil （Tosat提醒）
	
		常用的toast提醒
- XmlUtil （XML文件工具类，包含：将xml文件解析成实体集合、获取xml标签值、将标签值解析成实体集合）
	
		//获取xml字符串标签中的属性值
        XmlUtil.attributeToObject(String xml, Class<T> clazz, String tagName);
        // 获取Xml文件中的属性值
        XmlUtil.getTagAttribute(String xml, String tagName, String attributeName);
        //XML文件解析成实体,不涉及到标签的属性值。
        XmlUtil.xmlToObject(String xml, Class<T> clazz, String tagEntity);
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
	        implementation 'com.github.Lucklyheart:Utils:v1.0.3'
	} 
### Final
	欢迎指导和建议！！！
