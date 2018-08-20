package algorithms.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import algorithms.interfaces.GeneralSort;

import static algorithms.utils.ArrayUtil.*;

public class DynamicProxyTimeCaculateHandler implements InvocationHandler {
	//这个就是需要被代理的类了
	private Object object;
	
	public DynamicProxyTimeCaculateHandler(final Object object) {
		this.object = object;	
	}
	 //这里的method是接口定义的方法，args是方法传入的参数
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Integer[] arg = (Integer[])args[0];
		for(Integer i:arg) {
			System.out.print(i+" ");
		}System.out.println();
		Long begainTime = System.nanoTime();
		Object result = method.invoke(object, args);
		Long endTime = System.nanoTime();
		for(Integer i:arg) {
			System.out.print(i+" ");
		}System.out.println();
		System.out.println("运行时间 :"+(endTime-begainTime)+"ns");
		return result;
	}
	//将需要被代理的类进行绑定
	public Object bind() {
		return (GeneralSort) Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                this);
	}
}