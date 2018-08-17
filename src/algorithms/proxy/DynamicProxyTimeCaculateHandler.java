package algorithms.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import static algorithms.utils.ArrayUtil.*;

public class DynamicProxyTimeCaculateHandler implements InvocationHandler {
	
	private Object object;
	
	public DynamicProxyTimeCaculateHandler(final Object object) {
		this.object = object;	
	}
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
	

}