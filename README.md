# 记录下下，自己的需求功能实现方法。
### 前段时间看见澎湃新闻里面的新闻列表里面嵌套了一个横向滑动的列表。
![](https://user-images.githubusercontent.com/13359093/209492240-19329a05-84a7-4217-bfaa-431db5ca86f1.gif)

举个栗子，看到没，这就是澎湃新闻要闻列表中的效果


```

澎湃Android的大神别勿喷哦。我的猜想澎湃也是用的两个RecyclerView 列表，用recyclerView1 ，
addOnScrollListener（）获取滚动事件的坐标dx值，设置给recyclerView2.scrollBy(dy, dx);     
但是用这种方法要记住，当不需要联动的时候一定要recyclerView1 .clearOnScrollListeners(); 
调用这个方法清除掉添加的滚动监听，要不然addOnScrollListener添加的 int dx, int dy值会越来越多，
导致列表越来越卡顿。（个人理解）   所以一定要即使清除掉监听。

```

```

recyclerView1.addOnScrollListener(new RecyclerView.OnScrollListener() {

@Override

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

if (recyclerView.getScrollState() !=RecyclerView.SCROLL_STATE_IDLE) {

recyclerView2.scrollBy(dy, dx);       

}

}

});

```

### 还有种可能就是澎湃用的RecyclerView 里面嵌套View pager，但是原理应该八九不离十一样的，recyclerView1获取到的纵坐标dy值，设置给View pager 的x值。

就酱紫就可以进行实时联动了，其实还是很简单的 ，就是一句代码而已拉。下面这个是大神写一个示例效果Android若干条并排RecyclerView滑动实时联动


![2781551-fbda6f697331f9d1](https://user-images.githubusercontent.com/13359093/209492447-96bbd7a2-656f-4381-bbf0-8ed166247c13.gif)


如果要改成两个都垂直联动只要相互替换recyclerView2.scrollBy(dy, dx);    dy 和dx 值就了
