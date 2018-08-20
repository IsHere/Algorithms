package algorithms.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import algorithms.interfaces.GeneralSort;

import static algorithms.utils.ArrayUtil.*;

public class DynamicProxyTimeCaculateHandler implements InvocationHandler {
	//���������Ҫ�����������
	private Object object;
	
	public DynamicProxyTimeCaculateHandler(final Object object) {
		this.object = object;	
	}
	 //�����method�ǽӿڶ���ķ�����args�Ƿ�������Ĳ���
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
		System.out.println("����ʱ�� :"+(endTime-begainTime)+"ns");
		return result;
	}
	//����Ҫ�����������а�
	public Object bind() {
		return (GeneralSort) Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                this);
	}
}