package es.codeurjc.test.ejem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CalculatorInterceptor implements IMethodInterceptor{
	
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
		List<IMethodInstance> last = new ArrayList<IMethodInstance>();
		
		for (IMethodInstance method : methods) {
			Test testMethod = method.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
			Set<String> groups = new HashSet<String>();
			for (String group : testMethod.groups()) groups.add(group);
			if (groups.contains("UI")) {
				last.add(method);
			} else {
				result.add(method);
			}
		}
		
		for(IMethodInstance m: last) result.add(m);

		return result;
	}
}
