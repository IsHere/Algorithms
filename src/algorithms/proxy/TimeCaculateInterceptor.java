package algorithms.proxy;

import java.lang.reflect.Method;

import algorithms.utils.ListNode;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import static algorithms.utils.ListNodeUtil.*;
import static algorithms.utils.ArrayUtil.*;

public class TimeCaculateInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object arg0, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		printArgs(args);
		Long begainTime = System.nanoTime();
		Object proxyObject = methodProxy.invokeSuper(arg0, args);
		Long endTime = System.nanoTime();
		System.out.println("运行时间 :"+(endTime-begainTime)+"ns");
		return proxyObject;
	}

	private void printArgs(Object[] args) {
		Class pa = args[0].getClass();

		if (pa.isArray()) {
			printrArray((Integer[]) args[0]);
		}
		if (args[0] instanceof ListNode) {
			printListNode((ListNode) args[0]);
		}
	}
}
