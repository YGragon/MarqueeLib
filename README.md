### Effect
![effect](/image/demo.gif)

### How to Use ?
- Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
        repositories {
            ...
            maven { url 'https://www.jitpack.io' }
        }
    }
```
- Step 2. Add the dependency
```
dependencies {
            implementation 'com.github.dongxi346:MarqueeLib:1.0.0'
    }
```
- Step 3. Add the xml
```
 <com.dong.marqueelib.MarqueeTextviewNofocus
            android:id="@+id/tv_marquee"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="16sp"
            />
```
- Step 4. init data in you `.java` code 
```

        MarqueeTextviewNofocus marqueeTextviewNofocus = findViewById(R.id.tv_marquee);
        marqueeTextviewNofocus.setText("大家好啊，我是跑马灯~");
        // 初始化
        marqueeTextviewNofocus.init(getWindowManager());
        // 设置滚动方向
        marqueeTextviewNofocus.setScrollDirection(MarqueeTextviewNofocus.RIGHT_TO_LEFT);
        // 设置滚动速度
        marqueeTextviewNofocus.setScrollMode(MarqueeTextviewNofocus.SCROLL_FAST);
```

thx to use!
