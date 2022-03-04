## 写在前面

最近在学安卓，其实挺不想学的【毕竟我还在考研和工作之间做抉择，而且我的方向也不是安卓=_=】，但是谁叫sb学校开了呢，而且还不让实习。。。。。那就先学学看吧，毕竟对安卓还是有些兴趣的

然后，在搞这个Android Studio的时候，碰到了一个问题，就是一直在loading devices。。。。

 ![image-20220304135842925](https://gitee.com/lovely-hair/blog-img/raw/master/img/20220304140112.png)

然后时间比较紧张，所以也就没找视频进行·系统性的学习·直接在网上找的解决方案【所以不一定是最优的，仅供参考】

## 一、问题原因

java.lang.RuntimeException: Unable to create Debug Bridge: Timed out attempting to connect to adb: * daemon not running; starting now at tcp:5037
* daemon started successfully
Connected to adb for device monitoring
Sending Tracking request failed!
Adb connection Error:远程主机强迫关闭了一个现有的连接。
Cannot reach ADB server, attempting to reconnect.

> 从提示信息来看，应该是adb链接超时，所以我们关闭并重启一下就好了

## 二、操作步骤

- 方式一

  在cmd里输入如下命令·

  ```bash
  adb start-server
  ```

   ![image-20220304140853937](https://gitee.com/lovely-hair/blog-img/raw/master/img/20220304140855.png)

- 方式二

  交替输入如下两句话

  ```bash
  adb kill-server
  adb start-server
  ```

   ![image-20220304141234321](https://gitee.com/lovely-hair/blog-img/raw/master/img/20220304141234.png)

## 最后

不过我还是很不解，为什么会有这种情况【每次重开编译器，都要来一波这样的操作，真是太痛苦了】

