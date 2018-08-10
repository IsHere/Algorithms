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
		System.out.println(object.getClass().getSimpleName());
		Long begainTime = System.nanoTime();
		Object result = method.invoke(object, args);
		Long endTime = System.nanoTime();
		System.out.println("运行时间 :"+(endTime-begainTime)+"ns");
		return result;
	}
	

}