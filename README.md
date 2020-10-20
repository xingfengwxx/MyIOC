# IOC框架Demo

## 什么是IOC 

- 控制反转（Inverse of control），用来降低代码的耦合度，最常见的方式叫做依赖注入 （Dependency Injection，DI），IOC的思想核心在于，资源不由使用资源的那乙方管理， 而有不使用资源的第三方管理 

## IOC的优点和缺点

### 优点

- 资源集中管理，实现资源的可配置和易管理
- 降低了使用资源双方的依赖程度，也就是耦合度

### 缺点

- 创建对象的步骤变复杂了
- 使用反射，会降低一定的性能 ，但是，相对于提高了程序的灵活性和可维护性来说，这些损耗微不足道 

## IOC依赖注入的两种实现 

- 编译期 XUtils 
- 运行期 ButterKnife 

## 注入的模块

#### 布局

- Java（Source）->class（Class）->JVM（RunTime） 

#### 视图

#### 事件 

```java
//设置监听的方法 
//监听器的类型 
//事件触发之后执行的回调方法 
btn.setOnClickListener(new View.OnClickListener() { 
    @Override 
    public void onClick(View v) {
        
    }
});
```

