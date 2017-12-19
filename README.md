# TestForCustomView

[1] 关于构造方法
- 一个参数的构造方法：在用代码动态的添加我们的自定义view时调用。
- 两个参数的构造方法：在使用xml +inflate的方法添加控件时会调用，里面多了一个AttributeSet类型的值。
- 三个参数的构造方法：这个构造方法系统是不调用的，需要我们显示调用并给defStyleAttr传值，多了一个defStyleAttr参数，这是这个view引用style资源的属性参数，也就是我们可以在style中为自定义View定义一个默认的属性样式然后添加进来！