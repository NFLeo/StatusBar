### 本文目标：
自定义设置状态栏高度、字体。

#### fitsSystemWindow 说明
```
true：状态栏、底部标题栏可占据屏幕高度，与布局区域分离。
false：布局区域可占据状态栏、底部标题栏。
默认：如false
```
![fitsSystemWindow.png](http://upload-images.jianshu.io/upload_images/2362769-33fa403841bf4b9f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1024)

```
实现思路：
1.针对4.4、5.0修改主题
2.设置状态栏透明
3.自行绘制状态栏占位
```
#### 一、闪屏图样式
无状态栏
![SplashActiviry.png](http://upload-images.jianshu.io/upload_images/2362769-16655a852d5f0dce.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/180)

![MainActivity-1.png](http://upload-images.jianshu.io/upload_images/2362769-9e033643da228d18.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/180)

![MainActivity-2.png](http://upload-images.jianshu.io/upload_images/2362769-8d67958c27312b46.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/180)

![ImageActivity.png](http://upload-images.jianshu.io/upload_images/2362769-775dd480211a46e9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/180)

![BaseDialogFragment.png](http://upload-images.jianshu.io/upload_images/2362769-ab5becf25684dfcb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/180)

代码(https://github.com/NFLeo/StatusBar)




